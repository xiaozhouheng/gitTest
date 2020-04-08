	require(['domReady', 'jquery', 'XOMS', 'xoms.tip', 'xoms.validate', 'bootstrap', 'select2', 'select2.locale', 'jquery.jqGrid', 'xoms.orderProblemReplydialog','xoms.lang.issue'], function(domReady, $, XOMS) {
		var viewType = $('#view-type-input').val();
		var locale = XOMS.locale,
		ctPath = XOMS.contextPath,
		titleKey = '',
		pkNameKey = '',
		statusKey = '';
		if(locale == 'zh_CN') {
			titleKey = 'title';
			pkNameKey = 'pkName';
		} else {
			titleKey = 'eTitle';
			pkNameKey = 'pkEname';
		}
		$('select.status').select2({
			minimumResultsForSearch: -1,
			width: 80
		});
		$('#issueKind').select2({
			minimumResultsForSearch: -1,
			width: 130
		});
		$('.status').change(function(e) {
			var status = $(this).val(),
				keyword = $('#main-tab .xoms-search-form input[name="keyword"]').val();
			if(gridTypeCurrent==gridTypeProblem){
				getIssueType(status);
			}
			lastStatus[gridTypeCurrent] = status;
			// 对于欠费件, 已解决查询不出来, 所以对于status的改变不重新查询欠费件
			if(gridTypeCurrent != gridTypeArrearage) {
				renderGrid(gridTypeCurrent, status, keyword);
			}
		});
		
		$('#issueKind').change(function() {
			var status = $('.problem-status select').val(),
				keyword = $('#main-tab .xoms-search-form input[name="keyword"]').val();
			var issueType=$("#issueKind").val();
			lastStatus[gridTypeCurrent] = status;
			// 对于欠费件, 已解决查询不出来, 所以对于status的改变不重新查询欠费件
			if(gridTypeCurrent != gridTypeArrearage) {
				renderGrid(gridTypeCurrent, status, keyword,issueType);
			}
		});
		var Lang = XOMS.Lang.issue,
		LangJqgrid = Lang.jqgrid;
		LangContent = Lang.content;
		// ------------------- 列表 变量 --------------------
		var arrearageGridId = 'arrearage-grid',
			arrearageGridPagerId = 'arrearage-grid-pager',
			problemGridId = 'problem-grid',
			problemGridPagerId = 'problem-grid-pager',
			noticeGridId = 'notice-grid',
			noticeGridPagerId = 'notice-grid-pager',
			searchGridId = 'search-grid',
			searchGridPagerId = 'search-grid-pager';
		var grid = {};
		var gridArrearageSetting = undefined,
			gridProblemSetting = undefined,
			gridNoticeSetting = undefined,
			gridSearchSetting = undefined;
		var gridTypeArrearage = 'arrearage',
			gridTypeProblem = 'problem',
			gridTypeNotice = 'notice',
			gridTypeSearch = 'search',
			// 切换页签时会更新, 如果逻辑执行过程中需要保证该变量不被重新赋值(切换页签) 则不要使用该变量
			gridTypeCurrent = gridTypeArrearage;
		
		// 保存每个页签(表格)对应的状态(全部0,未解决1,已解决2)
		var lastStatus = {};
		lastStatus[gridTypeArrearage] = 0;
		lastStatus[gridTypeProblem] = 1;
		lastStatus[gridTypeNotice] = 1;
		lastStatus[gridTypeSearch] = 0;
		
		// ------------------- 列表 --------------------
		var gridOriginData = [];
		var getGridOriginData = function(id, gridType) {
			var data = gridOriginData[gridType];
			for(var i = data.length - 1; i >=0; i--) {
				if(data[i].id == id) {
					return data[i];
				}
			}
			return null;
		};

		
		/**
		 * type gridTypeArrearage / gridTypeProblem / gridTypeNotice / gridTypeSearch
		 */
		var getGridSetting = function(gridType) {
			var gridLimit = undefined,
				rownumber = 1,
				gridPage = 1,
				gridSetting = {
					mtype: 'post',
					datatype: 'json',
					autowidth: true,
					height: 710,
					gridview: true,
					viewrecords: true,
					multiselect: gridType == gridTypeProblem || gridType == gridTypeNotice,
					multiselectWidth: 40,
					loadtext: LangJqgrid.loading,
					recordtext: LangJqgrid.recordtext,
					pgtext: LangJqgrid.pgtext,
					rowNum: gridType == gridTypeSearch ? 100 : 20,
					rowList: gridType == gridTypeSearch ? [100] : [20,50,100],
					sortable: false,
					prmNames: {
						sort: 'sortname',
						order: 'sortorder',
						rows: 'pageSize'
					},
					pager: undefined,
					beforeProcessing: function(data) {
						if(data.status == 0) {
							XOMS.tip({
								type: 0,
								content: data.msg
							});
						} else {
							var pagermodel = data.data || [];
							gridPage = pagermodel.pageNum;
							gridLimit = grid[gridType].jqGrid('getGridParam', 'rowNum'); 
							if(gridPage == 1) {
								rownumber = 1;
							}
							
							for(var name in data) {
								if(data.hasOwnProperty(name)) {
									data[name] = undefined;
								}
							}
							for(var name in pagermodel) {
								if(pagermodel.hasOwnProperty(name)) {
									data[name] = pagermodel[name];
								}
							}
							
							gridOriginData[gridType] = pagermodel.list;
						}
					},
					onSelectRow: function(rowid, status) {
						var arr = grid[gridTypeCurrent].jqGrid('getGridParam','selarrrow');
						switchBarStatus(arr);
			        },
			        onSelectAll: function(aRowids, status) {
						// status true 表示选中, false表示取消
						var arr = status ? aRowids : [];
						switchBarStatus(arr);
			        },
					jsonReader: undefined,
					colModel: undefined
			};
			
			var jsonReader= {
								root :"list",
								page : "pageNum" ,
								total : "pages" ,
								records : "total" 
			};
			
			var colModel = [
					           {name: 'id', hidden: true},
					           {name: 'rownumber', label: LangJqgrid.order, align: 'center', sortable: false, width: '6%', formatter: function(cellvalue, options, rowObject) {
					        	   if(rownumber > gridLimit) {
					        		   rownumber = 1;
					        	   }
					        	   var number = rownumber + (gridPage -1) * gridLimit;
					        	   rownumber++;
					        	   return number;
					           }}
					           ];
			if(gridType == gridTypeSearch) {
				colModel[colModel.length] = {name: 'title', label: LangJqgrid.issueType, sortable: false, align: 'left', width: '26%', formatter: function(cellvalue, options, rowObject) {
					if(rowObject && rowObject.arrearsAmount) {
						//return '<a data-id="' + rowObject.id + '">欠费件 (' + rowObject.arrearsAmount + '元)</a>';
					} else {
						return '<a data-id="' + rowObject.id + '">' + rowObject[titleKey] + '</a>';
					}
				}};
				colModel[colModel.length] = {name: 'closed', label: LangJqgrid.status, sortable: false, align: 'center', width: '10%', formatter: function(cellvalue, options, rowObject) {
					/**
					if(cellvalue == true) {
						//return '<span title="' + (rowObject.icCode == 'NT' ? '已读' : '已处理') + '" class="glyphicon glyphicon-ok-circle" style="color: #5cb85c;"></span>';
						if(rowObject.icCode == 'NT'){
							return '已读';
						}else{
							return '已解决';
						}
					} else {
						if(rowObject.icCode == 'NT'){
							return '未读';
						}else{
							return '未解决';
						}
							
						//return '<span title="' + (rowObject.icCode == 'NT' ? '未读' : '处理中') + '" class="glyphicon glyphicon-play" style="color: #5cb85c;"></span>';
						// return '<span title="处理中" class="glyphicon glyphicon-triangle-right" style="color: #5cb85c;"></span>';
					}
					*/
					if(rowObject && rowObject.arrearsAmount) {
						return locale=='zh_CN'?'欠费':'arrearage';
					}
					if(rowObject.isuInterActionSign == 'N'){
						if(rowObject.firstReferdate==null||rowObject.firstReferdate==''){
							return locale=='zh_CN'?'未读':'unread'; 
						}else{
							return locale=='zh_CN'?'已读':'readed';
						}
					}else{
						if(rowObject.issCode=='NW'||rowObject.issCode=='DL'){
							return locale=='zh_CN'?'未解决':'unresolved';
						}else{
							return locale=='zh_CN'?'已解决':'resolved';
						}
					}
				}};
				colModel[colModel.length] = {name: 'serveHawbCode', label: LangJqgrid.serveHawbCode, sortable: false, align: 'left', width: '25%'};
				colModel[colModel.length] = {name: 'customerHawbCode', label: LangJqgrid.shipperHawbCode, sortable: false, align: 'left', width: '25%'};
				colModel[colModel.length] = {name: 'pkName', label: LangJqgrid.product, sortable: false, align: 'left', width: '15%',formatter: function(cellvalue, options, rowObject) {
		        	  return rowObject[pkNameKey];
						//return pkNameKey+'|'+rowObject.pkName+'|'+rowObject.pkEname+'|'+rowObject['pkName']+'|'+rowObject['pkEname'];
			           }};
				colModel[colModel.length] = {name: 'occurTime', label: LangJqgrid.time, sortable: false, align: 'center', width: '15%'};
			} else if(gridType == gridTypeArrearage) {
				colModel[colModel.length] = {name: 'serveHawbCode', label: LangJqgrid.serveHawbCode, sortable: false, align: 'left', width: '25%'};
				colModel[colModel.length] = {name: 'customerHawbCode', label: LangJqgrid.shipperHawbCode, sortable: false, align: 'left', width: '25%'};
				colModel[colModel.length] = {name: 'pkName', label: LangJqgrid.product, sortable: false, align: 'left', width: '18%',formatter: function(cellvalue, options, rowObject) {
		        	  return rowObject[pkNameKey];
					//return pkNameKey+'|'+rowObject.pkName+'|'+rowObject.pkEname+'|'+rowObject['pkName']+'|'+rowObject['pkEname'];
		           }};
				colModel[colModel.length] = {name: 'arrearsAmount', label: LangJqgrid.amount, sortable: false, align: 'left', width: '18%', formatter: function(cellvalue, options, rowObject) {
					return '<a data-id="' + rowObject.id + '">' + cellvalue + '</a>';
				}};
				colModel[colModel.length] = {name: 'occurTime', label: LangJqgrid.arrivalTime, sortable: false, align: 'center', width: '18%'};
			} else {
				colModel[colModel.length] = {name: 'title', label: LangJqgrid.issueType, sortable: false, align: 'left', width: '14%', formatter: function(cellvalue, options, rowObject) {
					return '<a data-id="' + rowObject.id + '">' + rowObject[titleKey] + '</a>';
				}};
				colModel[colModel.length] = {name: 'closed', label: LangJqgrid.status, sortable: false, align: 'center', width: '8%', formatter: function(cellvalue, options, rowObject) {
					/**
					if(cellvalue == true) {
						//return '<span title="' + (rowObject.icCode == 'NT' ? '已读' : '已处理') + '" class="glyphicon glyphicon-ok-circle" style="color: #5cb85c;"></span>';
						if(rowObject.icCode == 'NT'){
							return '已读';
						}else{
							return '已解决';
						}
					} else {
						if(rowObject.icCode == 'NT'){
							return '未读';
						}else{
							return '未解决';
						}
							
						//return '<span title="' + (rowObject.icCode == 'NT' ? '未读' : '处理中') + '" class="glyphicon glyphicon-play" style="color: #5cb85c;"></span>';
						// return '<span title="处理中" class="glyphicon glyphicon-triangle-right" style="color: #5cb85c;"></span>';
					}
					*/
					if(rowObject.isuInterActionSign == 'N'){
						if(rowObject.firstReferdate==null||rowObject.firstReferdate==''){
							return locale=='zh_CN'?'未读':'unread';
						}else{
							return locale=='zh_CN'?'已读':'readed';
						}
					}else{
						if(rowObject.issCode=='NW'||rowObject.issCode=='DL'){
							return locale=='zh_CN'?'未解决':'unresolved';
						}else{
							return locale=='zh_CN'?'已解决':'resolved';
						}
					}
				}};
				colModel[colModel.length] = {name: 'serveHawbCode', label: LangJqgrid.serveHawbCode, sortable: false, align: 'left', width: '22%'};
				colModel[colModel.length] = {name: 'customerHawbCode', label: LangJqgrid.shipperHawbCode, sortable: false, align: 'left', width: '22%'};
				colModel[colModel.length] = {name: 'pkName', label: LangJqgrid.product, sortable: false, align: 'left', width: '15%',formatter: function(cellvalue, options, rowObject) {
		        	  return rowObject[pkNameKey];
						//return pkNameKey+'|'+rowObject.pkName+'|'+rowObject.pkEname+'|'+rowObject['pkName']+'|'+rowObject['pkEname'];
			           }};
				if(gridType == gridTypeProblem) {
					colModel[colModel.length] = {name: 'content', label: LangJqgrid.content, sortable: false, align: 'left', width: '30%'};
					colModel[colModel.length] = {name: 'occurTime', label: LangJqgrid.replyTime, sortable: false, align: 'center', width: '18%'};
					colModel[colModel.length] = {name: 'shipperReconfirmSign', label: LangJqgrid.isRelease, sortable: false, align: 'center', width: '5%', formatter: function(cellvalue, options, rowObject) {
						if(cellvalue=='N'){
							//return '否';
							return '';
						}else if(cellvalue=='Y'){
							//return '是';
							return '<span data-value="1" class="centent-status-icon glyphicon glyphicon-ok-circle" style="color: #5cb85c;"></span>';
						}
						return '';
					}};
					colModel[colModel.length] = {name: 'replySign', label: LangJqgrid.isReply, sortable: false, align: 'center', width: '5%', formatter: function(cellvalue, options, rowObject) {
						if(cellvalue=='N'||(rowObject.issCode!='NW'&&rowObject.issCode!='DL')){
							//return '否';
							return '';
						}else if(cellvalue=='Y'){
							//return '是';
							return '<span data-value="1" class="centent-status-icon glyphicon glyphicon-ok-circle" style="color: #5cb85c;"></span>';
						}
						return '';
					}};
				} else {
					colModel[colModel.length] = {name: 'occurTime', label: LangJqgrid.noticeTime, sortable: false, align: 'center', width: '15%'};
				}
				colModel[colModel.length] = {name: 'shipperReconfirmSign', label: 'shipperReconfirmSign', sortable: false,hidden:true, align: 'left', width: '15%'};
				colModel[colModel.length] = {name: 'replySign', label: 'replySign', sortable: false,hidden:true, align: 'left', width: '15%'};
				colModel[colModel.length] = {name: 'issCode', label: 'issCode', sortable: false,hidden:true, align: 'left', width: '15%'};
				colModel[colModel.length] = {name: 'ikCode', label: 'ikCode', sortable: false,hidden:true, align: 'left', width: '15%'};
			}
			gridSetting.jsonReader = jsonReader;
			gridSetting.colModel = colModel;
			return gridSetting;
		};
		
		/**
		 * gridType gridTypeArrearage / gridTypeProblem / gridTypeNotice / gridTypeSearch
		 */
		var renderGrid = function(gridType, status, keyword,issueType) {
			if(!gridSearchSetting) {
				gridSearchSetting = getGridSetting(gridTypeSearch);
				gridArrearageSetting = getGridSetting(gridTypeArrearage);
				gridProblemSetting = getGridSetting(gridTypeProblem);
				gridNoticeSetting = getGridSetting(gridTypeNotice);
			}
			
			if(gridType == gridTypeSearch) {
				var url = 'query',
					data = {status: status, keyword: keyword,issueType:issueType};
				gridSearchSetting.pager = '#' + searchGridPagerId;
				if(!grid[gridType]) {
					gridSearchSetting.url = url;
					gridSearchSetting.postData = data;
					grid[gridType] = $('#' + searchGridId).jqGrid(gridSearchSetting);
				} else {
					grid[gridType].jqGrid('setGridParam', {
						url: url,
						postData: data,
						pageNum: 1
					}).trigger('reloadGrid');
				}
			} else {
				var url = 'list',
					data = {status: status, type: gridType,issueType:issueType};
				if(gridType == gridTypeArrearage) {
					if(!grid[gridType]) {
						gridArrearageSetting.pager = '#' + arrearageGridPagerId;
						gridArrearageSetting.url = url;
						gridArrearageSetting.postData = data;
						grid[gridType] = $('#' + arrearageGridId).jqGrid(gridArrearageSetting);
					} else {
						grid[gridType].jqGrid('setGridParam', {
							url: url,
							postData: data,
							pageNum: 1
						}).trigger('reloadGrid');
					}	
				} else if(gridType == gridTypeProblem) {
					if(!grid[gridType]) {
						gridProblemSetting.pager = '#' + problemGridPagerId;
						gridProblemSetting.url = url;
						gridProblemSetting.postData = data;
						grid[gridType] = $('#' + problemGridId).jqGrid(gridProblemSetting);
					} else {
						grid[gridType].jqGrid('setGridParam', {
							url: url,
							postData: data,
							pageNum: 1
						}).trigger('reloadGrid');
					}
				} else if(gridType == gridTypeNotice) {
					if(!grid[gridType]) {
						gridNoticeSetting.pager = '#' + noticeGridPagerId;
						gridNoticeSetting.url = url;
						gridNoticeSetting.postData = data;
						grid[gridType] = $('#' + noticeGridId).jqGrid(gridNoticeSetting);
					} else {
						grid[gridType].jqGrid('setGridParam', {
							url: url,
							postData: data,
							pageNum: 1
						}).trigger('reloadGrid');
					}
				}
			}
		};
		
		// 表格内部事件, 如a标签点击事件,点击回复
		var gridEvent = function() {
			$('.tab-content').on('click', 'a', function(e) {
				var $this = $(e.currentTarget);
				var id = $this.attr('data-id');
				//var shipperReconfirmSign=$this.attr('shipperReconfirmSign');
				//var replySign=$this.attr('replySign');
				
				var gridType = '';
				var forefatherId = $this.closest('table').attr('id');
				if(forefatherId == arrearageGridId) {
					gridType = gridTypeArrearage;
				} else if(forefatherId == problemGridId) {
					gridType = gridTypeProblem;
				} else if(forefatherId == noticeGridId) {
					gridType = gridTypeNotice;
				} else if(forefatherId == searchGridId) {
					gridType = gridTypeSearch;
				}

				var obj = getGridOriginData(id, gridType);
				var issueType = obj.arrearsAmount == null ? '问题件' : '欠费件';
				
				if(issueType=='欠费件'){
					//window.location = ctPath + '/order/finance_management/payonline/index';
					return;
				}
				
				//if(obj.icCode == 'NT') {// 待阅
				//if(obj.isuInterActionSign=='N'&&(obj.firstReferdate==null||obj.firstReferdate=='')){
				if(obj.isuInterActionSign=='N'){
					/**
					XOMS.openToreadDialog(id, function(result, type, dataId) {
						// 标记为已读
					});
					*/
					obj.showAreaTextFlag=1;
					XOMS.openTodoDialog2(id, issueType,obj,1, function(result, type, dataId) {
						/**
						XOMS.tip({
							type: 1,
							content: '回复成功'
						});
						*/
						grid[gridTypeNotice].trigger('reloadGrid');
					});
					
				//} else if(obj.icCode = 'HD') {// 代办
				} else if(obj.isuInterActionSign == 'Y') {// 代办
					obj.showAreaTextFlag=0;
					XOMS.openTodoDialog2(id, issueType,obj,1, function(result, type, dataId) {
						XOMS.tip({
							type: 1,
							content: LangContent.replySuccess
						});
					});
				}
			});
		};
		
		/**
		 * 切换操作按钮的可用状态
		 */
		var switchBarStatus = function(selectedIds) {
			if(selectedIds.length > 0) {
				if(gridTypeCurrent == gridTypeProblem) {
					var reply=isReply(selectedIds);
					if(reply==0){
						$("#problem-list button.reply").removeAttr('disabled');
					}else{
						$("#problem-list button.reply").attr('disabled', 'disabled');
						/**
						if(reply==1){
							XOMS.tip({
								type: 1,
								content: '所选问题状态需为已创建或者正在处理'
							});
						}else if(reply==2){
							XOMS.tip({
								type: 1,
								content: '所选问题存在不需要回复的问题'
							});
						}
						*/
					}
					var release=isRelease(selectedIds);
					if(release==0){
						$("#problem-list button.release").removeAttr('disabled');
					}else{
						$("#problem-list button.release").attr('disabled', 'disabled');
						/**
						if(release==1){
							XOMS.tip({
								type: 1,
								content: '批量放行问题类型需一致'
							});
						}else if(release==2){
							XOMS.tip({
								type: 1,
								content: '放行问题状态需为已创建或正在处理'
							});
						}else if(release==3){
							XOMS.tip({
								type: 1,
								content: '所选问题含有非客户确认问题'
							});
						}
						*/
					}
						
					
				} else if(gridTypeCurrent == gridTypeNotice) {
					for(var i = 0; i < selectedIds.length; i++) {
						var obj = getGridOriginData(selectedIds[i], gridTypeCurrent);
						if(!obj.closed) {
							$("#notice-list button.sign-readed").removeAttr('disabled');
							break;
						}
					}
				}
			} else {
				if(gridTypeCurrent == gridTypeProblem) {
					$("#problem-list button.reply").attr('disabled', 'disabled');
					$("#problem-list button.release").attr('disabled', 'disabled');
				} else if(gridTypeCurrent == gridTypeNotice) {
					$("#notice-list button.sign-readed").attr('disabled', 'disabled');
				}
			}
		};
		
		var isReply=function(selectedIds){
			for(var i=0;i<selectedIds.length;i++){
				var obj = getGridOriginData(selectedIds[i], gridTypeProblem);
				if(obj.issCode!='NW'&&obj.issCode!='DL'){
					return 1;
				}
				if(obj.replySign=='N'){
					return 2;
				}
			}
			return 0;
		};
		var isRelease=function(selectedIds){
			var ikCode='';
			for(var i=0;i<selectedIds.length;i++){
				var obj = getGridOriginData(selectedIds[i], gridTypeProblem);
				if(i==0){
					ikCode=obj.ikCode;
				}else{
					if(ikCode!=obj.ikCode){
						return 1;
					}
				}
				if(obj.issCode!='NW'&&obj.issCode!='DL'){
					return 2;
				}
				if(obj.shipperReconfirmSign=='N'){
					return 3;
				}
			}
			return 0;
		};
		
		// ------------------- 全局事件 --------------------
		var renderInTab = function(href) {
			if(href == '#search-list') {
				// 已通过form.submit事件渲染
			} else {
				// 保证每次进入 搜索页签 都搜索全部
				lastStatus[gridTypeSearch] = 0;
				
				$('#main-tab .xoms-search-form input[name="keyword"]').val('');
				$('#main-tab a[href=#search-list]').hide();
				if(href == '#arrearage-list') {
					gridTypeCurrent = gridTypeArrearage;
//					$('#status').select2('val', lastStatus[gridTypeCurrent]);
					if(!grid[gridTypeCurrent]) {
						renderGrid(gridTypeCurrent, lastStatus[gridTypeCurrent]);
					}
				} else if(href == '#problem-list') {
					gridTypeCurrent = gridTypeProblem;
					$('.problem-status select').select2('val', lastStatus[gridTypeCurrent]);
					if(!grid[gridTypeCurrent]) {
						renderGrid(gridTypeCurrent, lastStatus[gridTypeCurrent]);
					}
				} else if(href == '#notice-list') {
					gridTypeCurrent = gridTypeNotice;
					$('.notice-status select').select2('val', lastStatus[gridTypeCurrent]);
					if(!grid[gridTypeCurrent]) {
						renderGrid(gridTypeCurrent, lastStatus[gridTypeCurrent]);
					}
				}
			}
		};
		
		var globalEvent = function() {
			// ------------------- 页签事件 --------------------
			$('#main-tab a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
				var href = $(e.target).attr('href');
				if(href=='#problem-list'){
					$("#issueKind-subsection").show();
					/**
					$("#status").empty();
					$("#status").append('<option value="0">全部</option><option value="1">未解决</option><option value="2">已解决</option>');
					$("#status").val("0");
					*/
				}else{
					/**
					if(href=='#notice-list'){
						$("#status").empty();
						$("#status").append('<option value="0">全部</option><option value="1">未读</option><option value="2">已读</option>');
						$("#status").val("0");
					}
					*/
					$("#issueKind-subsection").hide();
				}
				renderInTab(href);
			});
			
			// ------------------- 搜索 --------------------
			// 使用单号搜索时,搜索的是全部类型,与问题类型及状态没有关系
			$('#main-tab .xoms-search-form').submit(function() {
				$('#main-tab a[href=#search-list]').show().tab('show');
				gridTypeCurrent = gridTypeSearch;
//				$('#status').select2('val', lastStatus[gridTypeCurrent]);
				
//				var status = $('#status').val();
				var	keyword = $('#main-tab .xoms-search-form input[name="keyword"]').val();
				
				if($.trim(keyword).length == 0) {
					XOMS.tip({
						type: 2,
						content: '请输入单号'
					});
					if(!grid[gridTypeSearch]) {
						// 第一次进入搜索页签时生成空的表格
						renderGrid(gridTypeSearch, 0, keyword);
					}
				} else {
					renderGrid(gridTypeSearch, 0, keyword);
				}
				return false;
			});
			
			// ------------------- 批量回复 批量标记已读 --------------------
			$("#problem-list button.reply").click(function() {
				var arr = grid[gridTypeCurrent].jqGrid('getGridParam','selarrrow');
				// open dialog
				$('#batch-reply-dialog').dialog({
					title: LangContent.batchReply,
					autoOpen: true,
					resizable: false,
					width: 700,
					height: 520,
					modal: true,
					position: {my: "center", at: "center top+350", of: window},
					buttons: [{
						text:LangContent.reply,
						click : function() {
							if(!$('#batch-reply-dialog form').valid()) {
								return;
							}

							var _$dialog = $(this);
							var content = _$dialog.find('[name="content"]').val();
							
							$.ajax({
								url: 'reply',
								dataType: 'json',
								data: $.param({todoIds: arr, content: content}, true),
								type: 'post',
								success: function(result) {
									if(result.status == 1) {
										XOMS.tip({
											content: LangContent.replySuccess,
											type: 1
										});
										_$dialog.dialog("destroy");
									} else {
										XOMS.tip({
											content: result.msg,
											type: 0,
											delBtn: true
										});
									}
								}
							});
						}
					},
					{	text:LangContent.close,
						click : function() {
									$(this).dialog( "destroy" );
								}}],
					open: function() {
						var _$dialog = $(this);
						_$dialog.find('.content [name="content"]').val('');
						_$dialog.find('.content .error-tips').empty();
					}
				});
			});
			$("#problem-list button.release").click(function() {
				var arr = grid[gridTypeCurrent].jqGrid('getGridParam','selarrrow');
				var status = $('.problem-status select').val(),
				keyword = $('#main-tab .xoms-search-form input[name="keyword"]').val();
				var issueType=$("#issueKind").val();
				$.ajax({
					url: ctPath + '/order/my_order/order_problem/release',
					type:"post",
					data: {
						ids: JSON.stringify(arr)
					},
					success: function(result) {
						if(result.status==1){
							XOMS.tip({
								content: LangContent.releaseSuccess,
								type: 1
							});
							renderGrid(gridTypeCurrent, status, keyword,issueType);
						}else{
							XOMS.tip({
								content: result.msg,
								type: result.status
							});
						}
						
					}
				});
			});
			
			// ------------------- 导出 --------------------
			$("#problem-list button.export").click(function() {
				
				var status = $('.problem-status select').val();
				var issueType=$("#issueKind").val();
				
				var selIdArr = grid[gridTypeCurrent].jqGrid('getGridParam','selarrrow');
				isuIds = selIdArr.join(',');
				window.open(ctPath + '/order/my_order/order_problem/export_excel?isuIds=' + isuIds + '&status=' + status + '&issueType=' + issueType);
//				$('#export-iframe').attr('src', ctPath + '/order/my_order/order_problem/export_excel?isuIds=' + isuIds + '&status=' + status + '&issueType=' + issueType);

			});
			
			
			// ------------------- 批量标记已读 --------------------
			$("#notice-list button.sign-readed").click(function() {
				var arr = grid[gridTypeCurrent].jqGrid('getGridParam','selarrrow');
				$.ajax({
					url: 'sign',
					data: $.param({todoIds: arr}, true),
					dataType: 'json',
					success: function(result) {
						if(result.status == 0) {
							XOMS.tip({
								content: result.msg,
								type: 0,
								delBtn: true
							});
						} else {
							/**
							for(var i = arr.length - 1; i >= 0; i--) {
								var rowdata = grid[gridTypeCurrent].jqGrid('getRowData' , arr[i]);
								rowdata.closed = true;
								grid[gridTypeCurrent].jqGrid('setRowData', arr[i], rowdata);
							}
							*/
							grid[gridTypeNotice].trigger('reloadGrid');
						}
					}
				});
			});
		};

		// ------------------- 批量回复校验 --------------------
		XOMS.validate($('#batch-reply-dialog form'), {
			onfocusout: function(element, event) {
				if (!this.checkable(element)) {
					var $element = $(element);
					// 处理清空内容后, 插件没有消除错误的临时代码, 应该通过插件api来完成该功能
					if($.trim($element.val()).length == 0) {
						$element.siblings('.error-tips').remove();
					}
					
					this.element(element);
					event.stopPropagation();
				}
			},
			errorClass: 'error-element',
			success: function(label, element){
				// element is not jQuery object
				$(element).parent().find('.error-tips').remove();
			},
			errorPlacement: function(error, element) {
				var parent = element.parent();
				var errMsg = error.html();
				if(parent.find('.error-tips').length == 0) {
					$('<div class="error-tips"><i class="glyphicon glyphicon-exclamation-sign"></i>&nbsp;<span>' + errMsg + '</span></div>').appendTo(parent);
				} else {
					parent.find('.error-tips span').html(errMsg);
				}
			},
			rules: {
				content: {
					required: true,
					maxlength: 500
				}
			},
			messages: {
				content: {
					required: LangContent.requiredTip,
					maxlength: LangContent.contentMaxlengthTip
				}
			}
		});
		
		var getIssueType=function(status){
			$.ajax({
				type:"post",
				//async:false,
				dataType:"json",
				data:{status:status},
				url:ctPath + '/order/my_order/order_problem/queryIssueType',
				success:function(result){
					var issueArray=[];
					if(locale == 'zh_CN'){
						issueArray.push('<option value=\'\'>全部</option>');
					}else{
						issueArray.push('<option value=\'\'>all</option>');
					}
					for(var i=0;i<result.length;i++){
						if(locale == 'zh_CN'){
							issueArray.push('<option value='+result[i].id+'>'+result[i].name+'</option>');
						}else{
							issueArray.push('<option value='+result[i].id+'>'+result[i].eName+'</option>');
						}
						
					}
					var issueType = $("#issueKind").val();
					$("#issueKind").empty();
					$("#issueKind").append(issueArray.join(''));
					$("#issueKind").val(issueType);
					//$("#issueKind-subsection").hide();
				}
			});
		};
		// ------------------- start --------------------
		var init = function() {
			getIssueType(1);
			globalEvent();
			gridEvent();
			if(viewType == 'todo') {
				lastStatus[gridTypeProblem] = 1;
				renderInTab('#problem-list');
//				$('#main-tab a[href="#problem-list"]').tab('show');
			} else if(viewType == 'done') {
				lastStatus[gridTypeProblem] = 2;
				renderInTab('#problem-list');
//				$('#main-tab a[href="#problem-list"]').tab('show');
			} else if(viewType == 'toRead') {
				lastStatus[gridTypeNotice] = 1;
				renderInTab('#notice-list');
//				$('#main-tab a[href="#notice-list"]').tab('show');
			} else if(viewType == 'readed') {
				lastStatus[gridTypeNotice] = 2;
				renderInTab('#notice-list');
//				$('#main-tab a[href="#notice-list"]').tab('show');
			} else {
				renderInTab('#arrearage-list');
//				renderGrid(gridTypeArrearage, $('#status').val());
			}
		};
		
		init();
		
	});
