(function($){
	$.extend({
		table : {
			_options : {},
			_option : {},
			_params  : {},
			init : function(options){
			$.table._options = options;
			$.table._option = options;
			layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element','form'], function(){
			var table = layui.table; //表格
			var	laydate = layui.laydate; //日期
			var laypage = layui.laypage; //分页
			var layer = layui.layer; //弹层
			var carousel = layui.carousel; //轮播
			var upload = layui.upload; //上传
			var element = layui.element; //元素操作
			var form=layui.form;
			   table.render({
			       url: options.url
			      ,height: 550
			      ,elem: '#layuiTable'
				  , limit: '10'/* 一页显示多少条 */
				  //, limits: [5,10,15]/* //每页条数的选择项 */
				  ,cellMinWidth: 80
				  ,cols:options.cols
				  ,id:'queryOrders'
				  ,page: true
				  //接口返回的数据放在table里
				  ,response: {
			          statusName: 'success' //数据状态的字段名称，默认：code
			          , statusCode: true //成功的状态码，默认：0
			          , msgName: 'message' //状态信息的字段名称，默认：msg
			          , countName: 'count' //数据总数的字段名称，默认：count
			          , dataName: 'value' //数据列表的字段名称，默认：data
			      }
			   , done: function(res, curr, count){
			    }
			   });
			})
		},
	        },
	        
	        
	operate:{
		// 提交数据
    	submit: function(url, type, dataType, data) {
        	var config = {
    	        url: url,
    	        type: type,
    	        dataType: dataType,
    	        data: data,
    	        beforeSend: function () {
    	        	layer.confirm("正在处理中，请稍后...");
    	        },
    	        
    	        success: function(result) {
    	        	$.operate.ajaxSuccess(result);
    	        }
    	    };
    	    $.ajax(config)
        },
     // 保存结果弹出msg刷新table表格
        ajaxSuccess: function (result) {
        	if (result.status == 200) {
        		layer.msg(result.msg,{
             		 icon: 1,
               		 time: 1000,
               	 },function(index){
     				//window.parent.location.reload();
               		window.location.reload();
      				layer.close(index); 
      				});
        	//$.table.refresh();
        		
            } else {
            	layer.confirm(result.msg);
            }
        	layer.close();
        },
        /*// 保存结果弹出msg刷新table表格
        ajaxSuccess: function (result) {
        	if (result.status == 200) {
        		layer.msg(result.msg);
        		$.table.refresh();
            } else {
            	layer.msg(result.msg);
            }
        	layer.close();
        },*/
      //保存修改方法
		save:function(url,param){
			var config = {
        	        url: url,
        	        type: "post",
        	        dataType: "json",
        	        data: param,
        	        success: function(result) {
        	        	if(result.status == 200){
        	        		$.operate.successCallback("保存成功");
        	               }else{
        	              	 layer.msg(result.msg,{
        	              		 icon: 2, 
        	              	 }); 
        	               } 
        	        }
        	    };
        	    $.ajax(config)
		},
		// 成功回调执行事件（父窗体静默更新）
        successCallback: function(result) {
        		
        		layer.msg(result, {
        			  icon: 1,
        			  time: 2000 //2秒关闭（如果不配置，默认是3秒）
        			}, function(index){
        			  //do something
        				window.parent.location.reload();
        				//$.table.reload();
        				layer.close(index); 
        	})
        },
		//添加Modal显示
		getAddData:function(width,height){
			var url = $.table._options.addUrl;
			layer.open({
  	    	  title: '新增',
  	    	  type: 2,
  	    	  closeBtn: 2,
  	    	  content: url,
  	    	  btn: ['保存', '取消'],
  	    	  isOutAnim : true,
  	    	  maxmin  : true,
  	    	  anim : 2 ,
  	    	  area : [width,height],
  	    	  yes: function(index, layero){
  	    		  	//按钮【按钮一】的回调
  	    		  var iframeWin = layero.find('iframe')[0];
        	          iframeWin.contentWindow.submitHandler();
  	    	  },
  	    	  btn2: function(index, layero){
  	    		  	//按钮【按钮二】的回调
  	    		  layer.close(index);
  	    		  //return false 开启该代码可禁止点击该按钮关闭
  	    	  }
  	    });      
		},
		//修改Modal显示
		getUpdateData:function(width,height){
			var table
			layui.use(['table'], function(){
				table = layui.table;
			})
			var checkStatus = table.checkStatus('queryOrders');
		      var data = checkStatus.data;
		      console.log(data)
    	    if (data.length == 0) {
    	    	layer.confirm("请至少选择一条记录");
    			return;
    		}
    	    if(data.length > 1 ){
    	    	layer.confirm("请选择一条记录");
    			return;
    	    }
    	    var id = checkStatus.data[0].id;
    	    var url = $.table._options.editUrl+"?id="+id;
    	    layer.open({
    	    	  title: '修改',
    	    	  type: 2,
    	    	  closeBtn: 2,
    	    	  content: url,
    	    	  btn: ['保存', '取消'],
    	    	  isOutAnim : true,
    	    	  maxmin  : true,
    	    	  anim : 2 ,
    	    	  area : [width,height],
    	    	  yes: function(index, layero){
    	    		  	//按钮【按钮一】的回调
    	    		  var iframeWin = layero.find('iframe')[0];
          	          iframeWin.contentWindow.submitHandler();
    	    	  },
    	    	  btn2: function(index, layero){
    	    		  	//按钮【按钮二】的回调
    	    		  layer.close(index);
    	    		  //return false 开启该代码可禁止点击该按钮关闭
    	    	  }
    	    });       
		},
		//派单Modal显示
		getSendOrder:function(width,height){
			var table
			var id
			layui.use(['table','layer',], function(){
				table = layui.table;
				layer = layui.layer;
				//监听行工具事件
		        table.on('tool(layuiTable)', function (obj) {
		            var data = obj.data;
		            id = data.id;
    	    var url = $.table._options.orderUrl+"&id="+id;
    	    layer.open({
    	    	  title: '派单',
    	    	  type: 2,
    	    	  closeBtn: 2,
    	    	  content: url,
    	    	  //btn: ['保存', '取消'],
    	    	  isOutAnim : true,
    	    	  maxmin  : true,
    	    	  anim : 2 ,
    	    	  area : [width,height],
    	    	  /*yes: function(index, layero){
    	    		  	//按钮【按钮一】的回调
    	    		  var iframeWin = layero.find('iframe')[0];
          	          iframeWin.contentWindow.submitHandler();
    	    	  },
    	    	  btn2: function(index, layero){
    	    		  	//按钮【按钮二】的回调
    	    		  layer.close(index);
    	    		  //return false 开启该代码可禁止点击该按钮关闭
    	    	  }*/
    	    });
		  });
		})
		},
		getDetails:function(width,height){
			var table
			var id
			layui.use(['table'], function(){
				table = layui.table;
				//监听行工具事件
		        table.on('tool(layuiTable)', function (obj) {
		            var data = obj.data;
		            id = data.id;
    	    var url = $.table._options.detailsUrl+"?id="+id;
    	    layer.open({
    	    	  title: '详情',
    	    	  type: 2,
    	    	  closeBtn: 2,
    	    	  content: url,
    	    	  //btn: ['保存', '取消'],
    	    	  isOutAnim : true,
    	    	  maxmin  : true,
    	    	  anim : 2 ,
    	    	  area : [width,height],
    	    	  /*yes: function(index, layero){
    	    		  	//按钮【按钮一】的回调
    	    		  var iframeWin = layero.find('iframe')[0];
          	          iframeWin.contentWindow.submitHandler();
    	    	  },
    	    	  btn2: function(index, layero){
    	    		  	//按钮【按钮二】的回调
    	    		  layer.close(index);
    	    		  //return false 开启该代码可禁止点击该按钮关闭
    	    	  }*/
    	    });
		  });
		})
		},
		 // 批量删除信息
        removeAll: function() {
        	var table
			layui.use(['table'], function(){
				table = layui.table;
			})
			var checkStatus = table.checkStatus('queryOrders');
		    var data = checkStatus.data;
			if (data.length == 0) {
				layer.confirm("请至少选择一条记录");
    			return;
    		}
			var ids = "";
			for(var i = 0 ; i < data.length ; i++ ){
				if(i==0){
					ids=data[i].id;
				}else{
					ids+=","+data[i].id;
				}
			}
			layer.confirm("确认要删除选中的" + data.length + "条数据吗?", function() {
    			var url = $.table._option.removeUrl;
				var data = { "ids": ids };
    			$.operate.submit(url, "post", "json", data);
    			
    		});
    		
           
        },
        //导出
        exportOrderOut: function() {
        	var table
			layui.use(['table','layer',], function(){
				table = layui.table;
				layer = layui.layer;
			})
			var checkStatus = table.checkStatus('queryOrders');
        	var length = checkStatus.data.length;
		    var data = checkStatus.data;
		    layer.confirm("确定导出这些条数据吗？", function(index) {
				if(length!=0){
						if (true){ 
								var ids="";
								for(var i=0;i<length;i++){
									//判断数据为不为空
									if(i==0){
										ids += checkStatus.data[i].id;
									}else{
										ids += ','+checkStatus.data[i].id;
									}
								}
								$("#ids").val(ids);//把勾选到的rows里数据放到id为ids的input里面
					 			$("#data-form").submit();//提交id为data-form表单
						}
						
				}else{
					var name = $('#serachname option:selected') .val();
					$('#ids').attr("name",name)
					$('#ids').val( $("#getValue").val())
					$("#data-form").submit();//提交id为data-form表单
					
				}
				layer.close(index);
					 })
    		
           
        },
        //企业管理审核页面显示
        comAudit:function(width,height){
			var table
			layui.use(['table'], function(){
				table = layui.table;
			})
			var checkStatus = table.checkStatus('queryOrders');
		      var data = checkStatus.data;
    	    if (data.length == 0) {
    	    	layer.confirm("请至少选择一条记录");
    			return;
    		}
    	    if(data.length > 1 ){
    	    	layer.confirm("请选择一条记录");
    			return;
    	    }
    	    var id = checkStatus.data[0].id;
    	    var url = $.table._options.AuditUrl+"?id="+id;
    	    layer.open({
    	    	  title: '审核',
    	    	  type: 2,
    	    	  closeBtn: 2,
    	    	  content: url,
    	    	  btn: ['审核', '取消'],
    	    	  isOutAnim : true,
    	    	  maxmin  : true,
    	    	  anim : 2 ,
    	    	  area : [width,height],
    	    	  yes: function(index, layero){
    	    		  	//按钮【按钮一】的回调
    	    		  var iframeWin = layero.find('iframe')[0];
          	          iframeWin.contentWindow.submitHandler();
    	    	  },
    	    	  btn2: function(index, layero){
    	    		  	//按钮【按钮二】的回调
    	    		  layer.close(index);
    	    		  //return false 开启该代码可禁止点击该按钮关闭
    	    	  }
    	    });       
		},
		//数据权限
		editDataPrivilegesUi:function(width,height){
			var table
			layui.use(['table'], function(){
				table = layui.table;
			})
			var checkStatus = table.checkStatus('queryOrders');
		    var data = checkStatus.data;
			if (data.length == 0) {
				layer.confirm("请至少选择一条记录");
    			return;
    		}
			 if(data.length > 1 ){
	    	    	layer.confirm("请选择一条记录");
	    			return;
	    	    }
			var ids = "";
			for(var i = 0 ; i < data.length ; i++ ){
				if(i==0){
					ids=data[i].id;
				}else{
					ids+=","+data[i].id;
				}
			}
			var id = checkStatus.data[0].id;
    	    var url = $.table._options.DataPrivilegesUrl+"&id="+id;
    	    layer.open({
    	    	  title: '数据权限',
    	    	  type: 2,
    	    	  closeBtn: 2,
    	    	  content: url,
    	    	  btn: ['保存', '取消'],
    	    	  isOutAnim : true,
    	    	  maxmin  : true,
    	    	  anim : 2 ,
    	    	  area : [width,height],
    	    	  yes: function(index, layero){
    	    		  	//按钮【按钮一】的回调
    	    		  var iframeWin = layero.find('iframe')[0];
          	          iframeWin.contentWindow.submitHandler();
    	    	  },
    	    	  btn2: function(index, layero){
    	    		  	//按钮【按钮二】的回调
    	    		  layer.close(index);
    	    		  //return false 开启该代码可禁止点击该按钮关闭
    	    	  }
    	    });
		},
		//模块权限
		editPrivilegesUi:function(width,height){
			var table
			layui.use(['table'], function(){
				table = layui.table;
			})
			var checkStatus = table.checkStatus('queryOrders');
		    var data = checkStatus.data;
			if (data.length == 0) {
				layer.confirm("请至少选择一条记录");
    			return;
    		}
			var ids = "";
			for(var i = 0 ; i < data.length ; i++ ){
				if(i==0){
					ids=data[i].id;
				}else{
					ids+=","+data[i].id;
				}
			}
			var id = checkStatus.data[0].id;
    	    var url = $.table._options.PrivilegesUrl+"&id="+id;
    	    layer.open({
    	    	  title: '模块权限',
    	    	  type: 2,
    	    	  closeBtn: 2,
    	    	  content: url,
    	    	  btn: ['保存', '取消'],
    	    	  isOutAnim : true,
    	    	  maxmin  : true,
    	    	  anim : 2 ,
    	    	  area : [width,height],
    	    	  yes: function(index, layero){
    	    		  	//按钮【按钮一】的回调
    	    		  var iframeWin = layero.find('iframe')[0];
          	          iframeWin.contentWindow.submitHandler();
    	    	  },
    	    	  btn2: function(index, layero){
    	    		  	//按钮【按钮二】的回调
    	    		  layer.close(index);
    	    		  //return false 开启该代码可禁止点击该按钮关闭
    	    	  }
    	    });
		},
	},
})

})(jQuery);

//时间控件  作为时间格式化使用
function createTime(v){
	var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}

