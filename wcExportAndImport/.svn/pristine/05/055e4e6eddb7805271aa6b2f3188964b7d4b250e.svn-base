<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = "";
    String username = "";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>修改</title>
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<link rel="stylesheet" href="../statics/css/track.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/to_create.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript" src="../statics/js/StringBuilder.js"></script>
<script type="text/javascript" src="../statics/js/tools.js"></script>
<script type="text/javascript" src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<!-- <script type="text/javascript" src="../statics/layui/layui.js"></script> -->
<script type="text/javascript" src="../statics/layui/layui.js"></script>
<style>
.order-no {
	width: 300px;
}

.ztck-biaodan {
	margin-top: 20px;
}

.order-select {
	width: 80px;
}

.ztck-textarea {
	width: 225px;
}

.xoms-secnavbar a {
	text-decoration: none;
}

.xoms-secnavbar {
	margin-top: -20px;
}

.saveInput {
	padding-top: 10px;
	padding-left: 0px;
	padding-right: 0px;
}

.bighuan {
	border: 1px dashed #F0F0F0;
	border-radius: 5px 5px 5px 5px;
	width: 1140px;
	margin-left: 30px;
}

.fieldName {
	text-align: right;
	padding-top: 7px;
	padding-left: 0px;
}

.valueName {
	padding-left: 0px;
}
/* 搜索栏 */
.ui-autocomplete {
        max-height: 50%;/* 高度值 */
        overflow-y: auto; /* 超过高度出现滚动条 */
        overflow-x: hidden;/*横向超出隐藏，如果要出现横向滚动，设置为auto即可 */
    }
    /*  IE 6不支持最大高度 
     *  我们使用高度代替，但这迫使菜单总是这么高。 
     */
     /**我也不知道写这个干啥，反正我们也不用IE6*/
    * html .ui-autocomplete {
        height: 300px;
    }
       .file {  
            position: relative;  
            display: inline-block;  
            background: #D0EEFF;  
            border: 1px solid #99D3F5;  
            border-radius: 4px;  
            padding: 4px 12px;  
            overflow: hidden;  
            color: #1E88C7;  
            text-decoration: none;  
            text-indent: 0;  
            line-height: 20px;  
        }  
        .file input {  
            position: absolute;  
            font-size: 100px;  
            right: 0;  
            top: 0;  
            opacity: 0;  
        }  
        .file:hover {  
            background: #AADFFD;  
            border-color: #78C3F3;  
            color: #004974;  
            text-decoration: none;  
        } 
</style>
<script type="text/javascript">
//时间戳
function getUnixTime(dateStr){
    var newstr = dateStr.replace(/-/g,'/'); 
    var date =  new Date(newstr); 
    var time_str = date.getTime().toString();
    return time_str.substr(0, 10);
    }
//时间格式
function createTime(v){
	if(v==null){
		 return "/";
	}
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
    var str = y+"-"+m+"-"+d;
    return str;
}    
    //当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
    var table_data=new Array();
    layui.use(['form', 'layedit', 'laydate', 'table', 'element','jquery'], function(){
    	 var table = layui.table;
         var form=layui.form;
         var $ = layui.jquery;
         var laydate = layui.laydate;
         
         //获取表头所有信息 放在函数外面方便时间修改函数使用
         var ids = ${sShippingPlanBy.id};
         var destinationCountry=$("#destinationCountry").val();//目的国
    	 var deliveryTime= createTime($("#deliveryTime").val());//出货时间
    	 var destination=$("#destination").val();//目的港
    	 var modeOfTransport= $("#modeOfTransport").val();//运输方式
    	 var exportPorts=$("#exportPorts").val();//出口口岸
    	 var mainWaybillNumber=$("#mainWaybillNumber").val();//主运单号
    	 var distributionOrderNumber=$("#distributionOrderNumber").val();//分运单号
    	 var overseasConsignee= $('#overseasConsignee').val();//境外发货人
    	 var domesticShipper=$("#domesticShipper").val();//境外收货人
    	 var productionUnit=$("#productionUnit").val();//生成销售单位
    	 var totalNumber=$("#totalNumber").val();//总件数
    	 var totalGrossWeight=$("#totalGrossWeight").val();//总毛重
    	 var totalCapacity=$("#totalCapacity").val();//总体积
    	 var packingType= $("#packingType").val();//包装种类
    	 var packageDimensions=$("#packageDimensions").val();//包装尺寸
    	 var supervisionType= $('#supervisionType').val();//监管方式
    	 var transactionTyep= $('#transactionTyep').val();//成交方式
    	 var status = $("#status").val();//状态
    	 var businessNumber = $("#businessNumber").val();//业务编码
    	 var salespersonCode = $("#salespersonCode").val();//销售员代码
    	 var reviewId = $("#reviewId").val();//派单操作员id
    	 var freight = $("#freight").val();//运费
    	 var premium = $("#premium").val();//保费
    	 /* var file1 = $('#invoice').get(0).files[0];
    	 var file2 = $('#packingList').get(0).files[0];
    	 var file3 = $('#contract').get(0).files[0];
    	 var file4 = $('#cpoa').get(0).files[0];
    	 var file5 = $('#packingDetails').get(0).files[0];
    	 var file6 = $('#other1').get(0).files[0];
    	 var file7 = $('#other2').get(0).files[0]; */
    	 var btDataQJa;//定义表体全局
    	 var mainWaybillNumberValue = mainWaybillNumber;//mainWaybillNumberValue---定义用户输入的主运单号变量，mainWaybillNumber--为初始化的主运单号值，赋值给输入的变量是为了下方验证主运单号不为空使用。当验证条件为初始化主运单号时，用户修改主运单号时便不能验证是否为空。
		    	//子表赋值 
		    	table.render({
					elem : '#orderSku',
					//data : '${aArrivalPlan.aArrivalPlanDetailsVOs }',//直接赋值json数据，只能拿到存json串对象的地址。
					//data:[{"chItemName": "苹果","countryOfOrigin": "1","currency": "1","hscode": "1","itemNumber": 123,"model": "1","netWeight": "1","note": "1","number": 1,"price": "1","serialNumber": 1,"totalPrice": "1","unit": "1"}],
					url:'<%=path%>/SShippingPlanDetails/getAllSShippingPlanDetails.do?sId='+'${sShippingPlanBy.id }',
		                page: false,
		                method:'get',
		                id: 'queryOrdersku',
		                 response: {
		                    statusName: 'success' //数据状态的字段名称，默认：code
		                    , statusCode: true //成功的状态码，默认：0
		                    , msgName: 'message' //状态信息的字段名称，默认：msg
		                    , countName: 'count' //数据总数的字段名称，默认：count
		                    , dataName: 'value' //数据列表的字段名称，默认：data  
		                },
		                cols: [[
		                    {field:'serialNumber',edit: 'text',  title: '序号',align :'center'},
		                    {field:'itemNumber',edit: 'text',  title: '货号',align :'center'},
		                    {field:'chItemName',edit: 'text',  title: '中文品名',align :'center'},
		                    {field:'hscode',edit: 'text',  title: '税号',align :'center'},
		                    {field:'model',edit: 'text',  title: '规格型号',align :'center'},
		                    {field:'number',edit: 'text',  title: '成交数量',align :'center'},
		                    {field:'unit',edit: 'text',  title: '成交单位',align :'center'},
		                    {field:'price',edit: 'text',  title: '价格',align :'center'},
		                    {field:'totalPrice',edit: 'text',  title: '总价',align :'center'},
		                    {field:'currency',edit: 'text',  title: '币制',align :'center'},
		                    {field:'netWeight',edit: 'text',  title: '净重',align :'center'},
		                    {field:'domesticSourceOfGoods',edit: 'text',  title: '境内货源地',align :'center'},
		                    {field:'note',edit: 'text',  title: '备注',align :'center'}
		                ]]
		                ,done: function(res, page, count){
		                	for(var i =0; i< res.value.length;i++){
		                		var sId = ${sShippingPlanBy.id};
		                		var id = res.value[i].id;
		                		var serialNumber = res.value[i].serialNumber;
		                		var itemNumber = res.value[i].itemNumber;
		                		var chItemName = res.value[i].chItemName;
		                		var hscode = res.value[i].hscode;
		                		var model = res.value[i].model;
		                		var number = res.value[i].number;
		                		var unit = res.value[i].unit;
		                		var price = res.value[i].price;
		                		var totalPrice = res.value[i].totalPrice;
		                		var currency = res.value[i].currency;
		                		var netWeight = res.value[i].netWeight
		                		var domesticSourceOfGoods = res.value[i].domesticSourceOfGoods;
		                		var note = res.value[i].note;
		                		var getData = [];
		                		var Data ={
		                				id:id,
		                				sId:sId,
		                				serialNumber:serialNumber,
		                				itemNumber:itemNumber,
		                				chItemName:chItemName,
		                				hscode:hscode,
		                				model:model,
		                				number:number,
		                				unit:unit,
		                				price:price,
		                				totalPrice:totalPrice,
		                				currency:currency,
		                				netWeight:netWeight,
		                				domesticSourceOfGoods:domesticSourceOfGoods,
		                				note:note,
		                		}
		                		btDataQJa = Data;//表体赋值给全局 方便点击时间修改函数使用
		                		getData.push(Data)

		                	}
		    
		    	
		    $(function(){
		    	//下拉框选择修改
		    	$("select").change(function(){
		    		var modeOfTransportName = $("#modeOfTransport").attr("name");
		    	    var modeOfTransportValue = $("#modeOfTransport").val();
		    	    var packingTypeName = $("#packingType").attr("name");
		    	    var packingTypeValue = $("#packingType").val();
		    	    var transactionTyepName = $("#transactionTyep").attr("name");
		    	    var transactionTyepValue = $("#transactionTyep").val();
		    	    var supervisionTypeName = $("#supervisionType").attr("name");
		    	    var supervisionTypeValue = $("#supervisionType").val();
		    	    var jsonGetSeleData ={
		    	    		shippingPlanDetails:getData,
		   			    	//BTXX:btxx,
		   			    	id:id,
		   			    	status:status,
		   			    	businessNumber:businessNumber,
		   			    	salespersonCode:salespersonCode,
		   			    	reviewId:reviewId,
		   			    	destinationCountry:destinationCountry,
		   	     			deliveryTime:deliveryTime,
		   	     			destination:destination,
		   	     			modeOfTransport:modeOfTransport,
		   	     			exportPorts:exportPorts,
		   	     			mainWaybillNumber:mainWaybillNumber,
		   	     			distributionOrderNumber:distributionOrderNumber,
		   	     			overseasConsignee:overseasConsignee,
		   	     			domesticShipper:domesticShipper,
		   	     			productionUnit:productionUnit,
		   	     			totalNumber:totalNumber,
		   	     			totalGrossWeight:totalGrossWeight,
		   	     			totalCapacity:totalCapacity,
		   	     			packingType:packingType,
		   	     			packageDimensions:packageDimensions,
		   	     			supervisionType:supervisionType,
		   	     			transactionTyep:transactionTyep,
		   	     			freight:freight,
		   	     			premium:premium,
		   			       }
				    	  var id = ${sShippingPlanBy.id}
				          id = id;
				          modeOfTransportKey = modeOfTransportName;
				          modeOfTransportValue = modeOfTransportValue;
				          packingTypeKey = packingTypeName;
				          packingTypeValue = packingTypeValue;
				          transactionTyepKey = transactionTyepName;
				          transactionTyepValue = transactionTyepValue;
				          supervisionTypeKey = supervisionTypeName;
				          supervisionTypeValue = supervisionTypeValue;
				          jsonGetSeleData[packingTypeKey] = packingTypeValue;
				          jsonGetSeleData[transactionTyepKey] = transactionTyepValue;
				          jsonGetSeleData[supervisionTypeKey] = supervisionTypeValue;
				          jsonGetSeleData[modeOfTransportKey] = modeOfTransportValue;
				          jsonGetSeleData['id'] = id;
				          var strSelect = JSON.stringify(jsonGetSeleData);
				          console.log(strSelect)
				          var formdata = new FormData();
	            		  formdata.append('shippingPlan',strSelect)
	            		//验证时间非空
	      	            if(deliveryTimeValue == 'NaN-NaN-NaN' || deliveryTimeValue== ''){
	      	    			layer.msg('出货时间不能为空',{
	      	    				icon:2,
	      	    				time:500,
	      	    				},function(){
	      	    					window.location.reload();
	      	    					});
	      	    			return false;
	      	    			}
	            		//验证主运单号不能为空
	                      if(mainWaybillNumberValue==null || mainWaybillNumberValue=="" ){
	                		  layer.msg('主运单号不能为空',{
	                				icon:2,
	                				time:500,
	                				},function(){
	                					window.location.reload();
	                					});
	                		    	return false;
	                		     }
		    	    $.ajax({
		         	    url:"<%=path%>/SShippingPlan/updateSShippingPlan.do",
		         	    type:'POST',
			   				async:true,
			   				dataType:'json',
			   				processData:false,
			   	            contentType:false,
			   				data:formdata,
		         	   success:function( data ){
		         		  if (data.status == 200){
								layer.msg(data.msg,{
									icon:1,
									time:500,
									},function(){
					     				window.location.reload();
					      				});
			                   }
			                   else{
			                	   layer.msg(data.msg,{
			                		   icon:2,
			                		   time:500,
			                		   },function(){
						     				window.location.reload();
					      				});
			                	   layer.close(index);
			                   }
						},
						error:function(){
							 alert("修改表头数据有误")
						}
		            })
		    	});
		    	//下拉框选择修改结束
		    	//点击单选按钮修改开始
		    	 $("input[name=ippc]").click(function(){
					    //var ippc = $(this).val();
	        	   //修改后的key和value
	            	 var ippcName = $(this).attr("name");
	            	 var ippcValue = Number($(this).val());
	        	     var jsonGetRadioData ={
	        	    		sShippingPlanDetails:getData,
	   			    	    id:id,
	   			    	    status:status,
		   			    	businessNumber:businessNumber,
		   			    	salespersonCode:salespersonCode,
		   			    	reviewId:reviewId,
	   			    	    destinationCountry:destinationCountry,
		   	     			deliveryTime:deliveryTime,
		   	     			destination:destination,
		   	     			modeOfTransport:modeOfTransport,
		   	     			exportPorts:exportPorts,
		   	     			mainWaybillNumber:mainWaybillNumber,
		   	     			distributionOrderNumber:distributionOrderNumber,
		   	     			overseasConsignee:overseasConsignee,
		   	     			domesticShipper:domesticShipper,
		   	     			productionUnit:productionUnit,
		   	     			totalNumber:totalNumber,
		   	     			totalGrossWeight:totalGrossWeight,
		   	     			totalCapacity:totalCapacity,
		   	     			packingType:packingType,
		   	     			packageDimensions:packageDimensions,
		   	     			supervisionType:supervisionType,
		   	     			transactionTyep:transactionTyep,
		   	     			freight:freight,
		   	     			premium:premium,
	   			       }
	        	    var id = ${sShippingPlanBy.id}
	        	     id = id;
	        	     ippcNameKey = ippcName;
	            	 ippcValue = ippcValue;
	        	     jsonGetRadioData[ippcNameKey] = ippcValue;
			         jsonGetRadioData['id'] = id;
			    var strRadio = JSON.stringify(jsonGetRadioData);
			       console.log(strRadio)
	            var formdata = new FormData();
	            formdata.append('shippingPlan',strRadio)
	            //验证时间非空
  	            if(deliveryTimeValue == 'NaN-NaN-NaN' || deliveryTimeValue== ''){
  	    			layer.msg('出货时间不能为空',{
  	    				icon:2,
  	    				time:500,
  	    				},function(){
  	    					window.location.reload();
  	    					});
  	    			return false;
  	    			}
	          //验证主运单号不能为空
	            if(mainWaybillNumberValue==null || mainWaybillNumberValue=="" ){
	      		  layer.msg('主运单号不能为空',{
	      				icon:2,
	      				time:500,
	      				},function(){
	      					window.location.reload();
	      					});
	      		    	return false;
	      		     }
	            $.ajax({
	         	    url:"<%=path%>/SShippingPlan/updateSShippingPlan.do",
	         	    type:'POST',
		   				async:true,
		   				dataType:'json',
		   				processData:false,
		   	            contentType:false,
		   				data:formdata,
	         	   success:function( data ){
	         		  if (data.status == 200){
							layer.msg(data.msg,{
								icon:1,
								time:500,
								},function(){
				     				window.location.reload();
				      				});
		                   }
		                   else{
		                	   layer.msg(data.msg,{
		                		   icon:2,
		                		   time:500,
		                		   },function(){
					     				window.location.reload();
				      				});
		                	   layer.close(index);
		                   }
					},
					error:function(){
						 alert("修改表头数据有误")
					}
	            })
	           });
		        //点击单选按钮修改结束
		        
		  //点击时间修改及时间处理开始       
		 //时间input框的值调用初始化
		 var arrinputId = ["deliveryTime"]//时间输入框的id放到数组里面。便于下方判断（过id判断是否是时间input输入框，是就return 不走接口，不是就走接口）
         var deliveryTimeValueFirst = deliveryTime //获取未修改之前的时间input框的value，用于下方时间值判断
         var deliveryTimeValueSecond = deliveryTime//用于获取修改之后的时间input框的value，用于下方时间值判断
         var deliveryTimeId = null //用于获取时间input框的id，当时间发生变化之后才会获取
         //时间input框的值调用初始化结束
    	 var deliveryTimeValue 
    	 laydate.render({
    		 elem: '#deliveryTime' //指定元素 
    			 ,done: function(value, date){
    		            $('#deliveryTime').change();  // 一定要加上这句！！！不然没有回调！！！
    		            //alert(value); //得到日期生成的值，如：2017-08-18
    		            var deliveryTimeName = $("#deliveryTime").attr("name")
    		            deliveryTimeValue = value
    		            //时间变动处理
    		            if(deliveryTimeValueFirst == deliveryTimeValue){//如果时间没有变化，就直接跳出，走input框的接口调用
    		            	return;
    		            }else if(deliveryTimeValueFirst != deliveryTimeValue && deliveryTimeValue != null){//第二次赋值，判断第一次赋值和第二次新值是否相等，如果不等，则给second赋值，用于下方判断
    		            	//alert("时间变化测试")
    		            	deliveryTimeValueFirst = deliveryTimeValue //用于下次判断
    		            	deliveryTimeValueSecond = deliveryTimeValue//用于下次判断
    		            	deliveryTimeId = "deliveryTime"//当时间变化之后，才会获取id,用于input框位置的验证，屏蔽input执行
    		            	deliveryTime = deliveryTimeValue //用于时间变动传值
    		            }else if(deliveryTimeValue == null){
    		            	//alert("时间为空测试")
    		            	deliveryTimeValueSecond = deliveryTimeValue
    		            	deliveryTimeId = null
    		            	deliveryTime = deliveryTimeValue
    		            	return false;
    		            }else{
    	  		             	alert("时间处理出现错误")
    	  		        }
    		            //验证时间非空
    		            if(deliveryTimeValue == 'NaN-NaN-NaN' || deliveryTimeValue== ''){
    		    			layer.msg('出货时间不能为空',{
    			    					icon:2,
    			    					time:500,
    			    				},function(){
    			    					deliveryTimeId = "deliveryTime"
    			    					window.location.reload();
    						      	});
    		    			return false;
    		    		     }
    		          //验证主运单号不能为空
    		            if(mainWaybillNumberValue==null || mainWaybillNumberValue=="" ){
    		      		  layer.msg('主运单号不能为空',{
    		      				icon:2,
    		      				time:500,
    		      				},function(){
    		      					window.location.reload();
    		      					});
    		      		    	return false;
    		      		     }
    					var date = new Date(deliveryTimeValue)
    		            var getBtData = [];
    		            getBtData.push(btDataQJa);
    		            var jsonGetTimeData = {
    		            	shippingPlanDetails:getBtData,
    		            	id:ids,
    		            	status:status,
		   			    	businessNumber:businessNumber,
		   			    	salespersonCode:salespersonCode,
		   			    	reviewId:reviewId,
    		            	destinationCountry:destinationCountry,
    		     			deliveryTime:deliveryTime,
    		     			destination:destination,
    		     			modeOfTransport:modeOfTransport,
    		     			exportPorts:exportPorts,
    		     			mainWaybillNumber:mainWaybillNumber,
    		     			distributionOrderNumber:distributionOrderNumber,
    		     			overseasConsignee:overseasConsignee,
    		     			domesticShipper:domesticShipper,
    		     			productionUnit:productionUnit,
    		     			totalNumber:totalNumber,
    		     			totalGrossWeight:totalGrossWeight,
    		     			totalCapacity:totalCapacity,
    		     			packingType:packingType,
    		     			packageDimensions:packageDimensions,
    		     			supervisionType:supervisionType,
    		     			transactionTyep:transactionTyep,
    		     			freight:freight,
    		     			premium:premium,
    		            }
    		            deliveryTimeValue = createTime(date.toString());
    		            deliveryTimeNameKey = deliveryTimeName;
    		            jsonGetTimeData[deliveryTimeNameKey] = deliveryTimeValue;
    		            var strTime = JSON.stringify(jsonGetTimeData);
				          console.log(strTime)
				          var formdata = new FormData();
	            		  formdata.append('shippingPlan',strTime)
		    	    $.ajax({
		         	    url:"<%=path%>/SShippingPlan/updateSShippingPlan.do",
		         	    type:'POST',
			   				async:true,
			   				dataType:'json',
			   				processData:false,
			   	            contentType:false,
			   				data:formdata,
		         	   success:function( data ){
		         		  if (data.status == 200){
								layer.msg(data.msg,{
									icon:1,
									time:500,
									},function(){
					     				window.location.reload();
					      				});
			                   }
			                   else{
			                	   layer.msg(data.msg,{
			                		   icon:2,
			                		   time:500,
			                		   },function(){
						     				window.location.reload();
					      				});
			                	   layer.close(index);
			                   }
						},
						error:function(){
							 alert("修改表头时间数据有误")
						}
		            })
		            }
    	 		})
		        //点击时间input框修改结束
	         
		    	//点击表头input框修改开始
		    	 $("input").blur(function(){
	            	setTimeout(inputUse,200);        
	           });
		    	function inputUse(){
		    		//修改后的key和value
		        	 var destinationCountryName =  $("#destinationCountry").attr("name");
		             var destinationCountryValue = $("#destinationCountry").val();
		             var destinationName = $("#destination").attr("name");
		             var destinationValue = $("#destination").val();
		             var exportPortsName = $("#exportPorts").attr("name");
	            	 var exportPortsValue = $("#exportPorts").val();
	            	 var mainWaybillNumberName = $("#mainWaybillNumber").attr("name");
	            	 mainWaybillNumberValue = $("#mainWaybillNumber").val();
	            	 var distributionOrderNumberName = $("#distributionOrderNumber").attr("name")
	            	 var distributionOrderNumberValue = $("#distributionOrderNumber").val();
	            	 var overseasConsigneeName = $("#overseasConsignee").attr("name");
	            	 var overseasConsigneeValue = $("#overseasConsignee").val();
	            	 var domesticShipperName = $("#domesticShipper").attr("name");
	            	 var domesticShipperValue = $("#domesticShipper").val();
	            	 var productionUnitName = $("#productionUnit").attr("name");
	            	 var productionUnitValue = $("#productionUnit").val();
	            	 var totalNumberName = $("#totalNumber").attr("name");
	            	 var totalNumberValue = $("#totalNumber").val();
	            	 var totalGrossWeightName = $("#totalGrossWeight").attr("name");
	            	 var totalGrossWeightValue = $("#totalGrossWeight").val();
	            	 var totalCapacityName = $("#totalCapacity").attr("name");
	            	 var totalCapacityValue = $("#totalCapacity").val();
	            	 var packageDimensionsName = $("#packageDimensions").attr("name");
	            	 var packageDimensionsValue = $("#packageDimensions").val();
	            	 var freightName = $("#freight").attr("name");
	            	 var freightValue = $("#freight").val();
	            	 var premiumName = $("#premium").attr("name");
	            	 var premiumValue = $("#premium").val();
	            	 var businessNumberName =  $("#businessNumber").attr("name");
		             var businessNumberValue = $("#businessNumber").val();
		             var salespersonCodeName = $("#salespersonCode").attr("name");
	            	 var salespersonCodeValue = $("#salespersonCode").val();
	        	     var jsonGetData ={
	        	    		shippingPlanDetails:getData,
	   			    	//BTXX:btxx,
	   			    	    id:id,
	   			    	    businessNumber:businessNumber,
		   			    	salespersonCode:salespersonCode,
	   			    	    status:status,
	   			    	    reviewId:reviewId,
	   			    	    destinationCountry:destinationCountry,
		   	     			deliveryTime:deliveryTime,
		   	     			destination:destination,
		   	     			modeOfTransport:modeOfTransport,
		   	     			exportPorts:exportPorts,
		   	     			mainWaybillNumber:mainWaybillNumber,
		   	     			distributionOrderNumber:distributionOrderNumber,
		   	     			overseasConsignee:overseasConsignee,
		   	     			domesticShipper:domesticShipper,
		   	     			productionUnit:productionUnit,
		   	     			totalNumber:totalNumber,
		   	     			totalGrossWeight:totalGrossWeight,
		   	     			totalCapacity:totalCapacity,
		   	     			packingType:packingType,
		   	     			packageDimensions:packageDimensions,
		   	     			supervisionType:supervisionType,
		   	     			transactionTyep:transactionTyep,
		   	     			freight:freight,
		   	     			premium:premium,
	   			       }
	        	   var id = ${sShippingPlanBy.id}
	        	   id = id;
	        	   //把修改后的name和value赋值给key和value
			       //key = name; 
			       //value = value;
			         destinationCountryKey = destinationCountryName;
			         destinationCountryValue = destinationCountryValue;
			         destinationKey = destinationName;
			         destinationValue = destinationValue;
			         exportPortsKey = exportPortsName;
			         exportPortsValue = exportPortsValue;
			         mainWaybillNumberKey = mainWaybillNumberName;
			         mainWaybillNumberValue = mainWaybillNumberValue;
			         distributionOrderNumberKey = distributionOrderNumberName;
			         distributionOrderNumberValue = distributionOrderNumberValue;
			         overseasConsigneeKey = overseasConsigneeName;
			         overseasConsigneeValue = overseasConsigneeValue;
			         domesticShipperKey = domesticShipperName;
			         domesticShipperValue = domesticShipperValue;
			         productionUnitKey = productionUnitName;
			         productionUnitValue = productionUnitValue;
			         totalNumberKey = totalNumberName;
			         totalNumberValue = totalNumberValue;
			         totalGrossWeightKey = totalGrossWeightName;
			         totalGrossWeightValue = totalGrossWeightValue;
			         totalCapacityKey = totalCapacityName;
			         totalCapacityValue = totalCapacityValue;
			         packageDimensionsKey = packageDimensionsName;
			         packageDimensionsValue = packageDimensionsValue;
			         freightKey = freightName;
			         freightValue = freightValue;
			         premiumKey = premiumName;
			         premiumValue = premiumValue;
			         businessNumberKey = businessNumberName;
			         businessNumberValue = businessNumberValue;
			         salespersonCodeKey = salespersonCodeName;
			         salespersonCodeValue = salespersonCodeValue;
			         jsonGetData[destinationCountryKey] = destinationCountryValue;
			         jsonGetData[destinationKey] = destinationValue;
			         jsonGetData[exportPortsKey] = exportPortsValue;
			         jsonGetData[mainWaybillNumberKey] = mainWaybillNumberValue;
			         jsonGetData[distributionOrderNumberKey] = distributionOrderNumberValue;
			         jsonGetData[overseasConsigneeKey] = overseasConsigneeValue;
			         jsonGetData[domesticShipperKey] = domesticShipperValue;
			         jsonGetData[productionUnitKey] = productionUnitValue;
			         jsonGetData[totalNumberKey] = totalNumberValue;
			         jsonGetData[totalGrossWeightKey] = totalGrossWeightValue;
			         jsonGetData[totalCapacityKey] = totalCapacityValue;
			         jsonGetData[packageDimensionsKey] = packageDimensionsValue;
			         jsonGetData[freightKey] = freightValue;
			         jsonGetData[premiumKey] = premiumValue;
			         jsonGetData[businessNumberKey] = businessNumberValue;
			         jsonGetData[salespersonCodeKey] = salespersonCodeValue;
			         jsonGetData['id'] = id;
			       //BTXX = btxx;
			    var strs = JSON.stringify(jsonGetData);
			       console.log(strs)
	            var formdata = new FormData();
	            formdata.append('shippingPlan',strs)
	            //验证时间非空
	            if(deliveryTimeValue == 'NaN-NaN-NaN' || deliveryTimeValue== ''){
	    			layer.msg('出货时间不能为空',{
	    				icon:2,
	    				time:500,
	    				},function(){
	    					deliveryTimeId = "deliveryTime"
	    					window.location.reload();
	    					});
	    			return false;
	    			}
	          //验证主运单号不能为空
	            if(mainWaybillNumberValue==null || mainWaybillNumberValue=="" ){
	      		  layer.msg('主运单号不能为空',{
	      				icon:2,
	      				time:500,
	      				},function(){
	      					window.location.reload();
	      					});
	      		    	return false;
	      		     }
	          //除时间框外的所有input框均走此执行路径
	            if(arrinputId.includes(deliveryTimeId)){
	            	return
	            }else{
	            	$.ajax({
	         	    url:"<%=path%>/SShippingPlan/updateSShippingPlan.do",
	         	    type:'POST',
		   				async:true,
		   				dataType:'json',
		   				processData:false,
		   	            contentType:false,
		   				data:formdata,
	         	   success:function( data ){
	         		  if (data.status == 200){
							layer.msg(data.msg,{
								icon:1,
								time:500,
								},function(){
				     				window.location.reload();
				      				});
		                   }
		                   else{
		                	   layer.msg(data.msg,{
		                		   icon:2,
		                		   time:500,
		                		   },function(){
					     				window.location.reload();
				      				});
		                	   layer.close(index);
		                   }
					},
					error:function(){
						 alert("修改表头数据有误")
					}
	            })
	            }
	          } 
	         //点击表头input框修改结束
            //监听单元格（表体修改）编辑开始
            var MXX = [];
	        var mxx = {};
            table.on('edit(orderSku)', function (obj) {
               var value = obj.value; //得到修改后的值
               var data = obj.data;  //得到所在行所有键值
               var sId = ${sShippingPlanBy.id};
               var chItemName = data.chItemName;
               var serialNumber = data.serialNumber;
               var itemNumber = data.itemNumber;
               var hscode = data.hscode;
               var model = data.model;
               var number = data.number;
               var unit = data.unit;
               var price = data.price;
               var totalPrice = data.totalPrice;
               var currency = data.currency;
               var netWeight = data.netWeight;
               var countryOfOrigin = data.countryOfOrigin;
               var note = data.note;
               var field = obj.field; //得到字段
               var MX = [];
               var mx = {
            		   sId:sId,
            		   chItemName:chItemName,
            		   serialNumber:serialNumber,
            		   itemNumber:itemNumber,
            		   hscode:hscode,
            		   model:model,
            		   number:number,
            		   unit:unit,
            		   price:price,
            		   totalPrice:totalPrice,
            		   currency:currency,
            		   netWeight:netWeight,
            		   countryOfOrigin:countryOfOrigin,
            		   note:note,
               };
			  //给data中的field、value动态赋值
               var id = obj.data.id; //定义需要传给后台的id
               mx.id = id; //传给后台的id
               key = field; //改动的field的名字赋给key，这样field就是动态的
               value = value; //value值赋给传给后台的value
               mx[key] = value; //传入后台的key：value
               mxx = mx;
               MX.push(mx);
               var jsonData = {
            		id:ids,
            		status:status,
   			    	businessNumber:businessNumber,
   			    	salespersonCode:salespersonCode,
   			    	reviewId:reviewId,
            		destinationCountry:destinationCountry,
   	     			deliveryTime:deliveryTime,
   	     			destination:destination,
   	     			modeOfTransport:modeOfTransport,
   	     			exportPorts:exportPorts,
   	     			mainWaybillNumber:mainWaybillNumber,
   	     			distributionOrderNumber:distributionOrderNumber,
   	     			overseasConsignee:overseasConsignee,
   	     			domesticShipper:domesticShipper,
   	     			productionUnit:productionUnit,
   	     			totalNumber:totalNumber,
   	     			totalGrossWeight:totalGrossWeight,
   	     			totalCapacity:totalCapacity,
   	     			packingType:packingType,
   	     			packageDimensions:packageDimensions,
   	     			supervisionType:supervisionType,
   	     			transactionTyep:transactionTyep,
   	     			freight:freight,
   	     			premium:premium,   
   	     		    shippingPlanDetails:MX,
           }
            var str = JSON.stringify(jsonData);
               console.log(str)
            var formdata = new FormData();
            formdata.append('shippingPlan',str)
            //验证时间非空
	            if(deliveryTimeValue == 'NaN-NaN-NaN' || deliveryTimeValue== ''){
	    			layer.msg('出货时间不能为空',{
	    				icon:2,
	    				time:500,
	    				},function(){
	    					window.location.reload();
	    					});
	    			return false;
	    			}
            //验证主运单号不能为空
            if(mainWaybillNumberValue==null || mainWaybillNumberValue=="" ){
      		  layer.msg('主运单号不能为空',{
      				icon:2,
      				time:500,
      				},function(){
      					window.location.reload();
      					});
      		    	return false;
      		     }
            $.ajax({
         	    url:"<%=path%>/SShippingPlan/updateSShippingPlan.do",
         	    type:'POST',
	   				async:true,
	   				dataType:'json',
	   				processData:false,
	   	            contentType:false,
	   				data:formdata,
         	   success:function( data ){
         		  if (data.status == 200){
						layer.msg(data.msg,{
							icon:1,
							time:500,
							},function(){
			     				window.location.reload();
			      				});
	                   }
	                   else{
	                	   layer.msg(data.msg,{
	                		   icon:2,
	                		   time:500,
	                		   },function(){
				     			window.location.reload();
			      				});
	                	   layer.close(index);
	                   }
				},
				error:function(){
					 alert("修改表体数据有误")
				}

            })
            
           });
          //监听单元格（表体修改）编辑结束
	            
	    })
	 }
      })
		    	  //双击打开修改页面
				  layer.open({
		        	   type: 1,
		        	   title: '订单详情',
		        	   area: ['1200px', '600px'],
		        	   skin: 'yourclass',
		        	   content: $('#orderMX'),
		        	   cancel: function(){
		       			// 右上角关闭事件的逻辑
		        		   location.href = '<%=path%>/page/pageJump.do?path=after/customsDeclaration/exportDeclaration';
		       		}
		        	 });
                
               
              
            
   	 var $ = layui.$, active = {
			    reload: function(){
	              var orderNo= $("#orderNo").val();
			      //执行重载
			      table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	key: value
			      }
			      });
			    },
	 }   
			  $('.btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
			  
});
</script>
</head>
<body>
	<!-- 双击弹出修改页面 -->	
	 <div id="orderMX" style="display: none; background-color: #F0F0F0;">
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">订单信息:</span>
		</div>
		<form id="typeMade" method="post" class="form-control">
		<input type="hidden" id="reviewId" name = "reviewId" value ="${sShippingPlanBy.reviewId }"class="form-control">
		<input type="hidden" id="status" name = "status" value ="${sShippingPlanBy.status }"class="form-control">
		<div class="col-lg-12 bighuan">
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>目的国:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="destinationCountry" name = "destinationCountry" value ="${sShippingPlanBy.destinationCountry }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>出货时间:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="deliveryTime" name = "deliveryTime" value="<fmt:formatDate value="${sShippingPlanBy.deliveryTime}" pattern="yyyy-MM-dd"/>"
							class="form-control">
							<span id="promptArrivalTime"style="color: red; display: none;">不能为空</span>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运输方式:</h9></label>
					<div class="col-lg-7 valueName">
						<select class="form-control category" name="modeOfTransport"
								id="modeOfTransport">
								<option value="" >请选择</option>
								<option value="0" <c:if test="${sShippingPlanBy.modeOfTransport=='0'}">selected</c:if>>公路</option>
								<option value="1" <c:if test="${sShippingPlanBy.modeOfTransport=='1'}">selected</c:if>>铁路</option>
							</select>
					</div>
				</div>
				<%-- <div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运输方式:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="modeOfTransport" name = "modeOfTransport" value ="${aArrivalPlan.modeOfTransport }"
							class="form-control">
					</div>
				</div> --%>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>目的港:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="destination" name = "destination" value ="${sShippingPlanBy.destination }"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>出口口岸:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="exportPorts" name = "exportPorts" value ="${sShippingPlanBy.exportPorts }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>主运单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="mainWaybillNumber" name = "mainWaybillNumber" value ="${sShippingPlanBy.mainWaybillNumber }"
							class="form-control">
							<span id="promptMainNumber" style="color: red; display: none;">不能为空</span>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>分运单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="distributionOrderNumber" name = "distributionOrderNumber" value ="${sShippingPlanBy.distributionOrderNumber }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>境外收货人:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="overseasConsignee" name = "overseasConsignee" value ="${sShippingPlanBy.overseasConsignee }"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>境外发货人:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="domesticShipper" name = "domesticShipper" value ="${sShippingPlanBy.domesticShipper }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>生成销售单位:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="productionUnit" name = "productionUnit" value ="${sShippingPlanBy.productionUnit }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>总件数:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="totalNumber" name = "totalNumber" value ="${sShippingPlanBy.totalNumber }"
							class="form-control">
					</div>
				</div>
				<%-- <div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>包装类型:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="packingType" name = "packingType" value ="${aArrivalPlan.packingType }"
							class="form-control">
					<select class="form-control category" name="packingType"
						id="packingType">
						<option value="" >请选择</option>
						<option value="0" <c:if test="${aArrivalPlan.packingType=='0'}">selected</c:if>>大包</option>
						<option value="1" <c:if test="${aArrivalPlan.packingType=='1'}">selected</c:if>>小包</option>
					</select> 
					</div>
				</div> --%>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>总毛重:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="totalGrossWeight" name = "totalGrossWeight" value ="${sShippingPlanBy.totalGrossWeight }"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>总体积:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="totalCapacity" name = "totalCapacity" value ="${sShippingPlanBy.totalCapacity }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>包装类型:</h9></label>
					<div class="col-lg-7 valueName">
						<%-- <input type="text" id="supervisionType" name = "supervisionType" value ="${aArrivalPlan.supervisionType }"
							class="form-control"> --%>
							<select class="form-control category" name="packingType"
								id="packingType">
								<option value="">请选择</option>
								<option value="0" <c:if test="${sShippingPlanBy.packingType=='0'}">selected</c:if>>大包</option>
								<option value="1" <c:if test="${sShippingPlanBy.packingType=='1'}">selected</c:if>>小包</option>
							</select>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运费:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="freight" name = "freight" value ="${sShippingPlanBy.freight }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>保费:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="premium" name = "premium" value ="${sShippingPlanBy.premium }"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>成交方式:</h9></label>
					<div class="col-lg-7 valueName">
						<%-- <input type="text" id="supervisionType" name = "supervisionType" value ="${aArrivalPlan.supervisionType }"
							class="form-control"> --%>
							<select class="form-control category" name="transactionTyep"
								id="transactionTyep">
								<option value="">请选择</option>
								<%-- <option value="0" <c:if test="${sShippingPlanBy.transactionTyep=='0'}">selected</c:if>>方式三</option> --%>
								<option value="1" <c:if test="${sShippingPlanBy.transactionTyep=='1'}">selected</c:if>>CIF</option>
								<option value="2" <c:if test="${sShippingPlanBy.transactionTyep=='2'}">selected</c:if>>C&F</option>
								<option value="3" <c:if test="${sShippingPlanBy.transactionTyep=='3'}">selected</c:if>>FOB</option>
								<option value="4" <c:if test="${sShippingPlanBy.transactionTyep=='4'}">selected</c:if>>C&I</option>
								<option value="5" <c:if test="${sShippingPlanBy.transactionTyep=='5'}">selected</c:if>>市场价</option>
								<option value="6" <c:if test="${sShippingPlanBy.transactionTyep=='6'}">selected</c:if>>垫仓</option>
								<option value="7" <c:if test="${sShippingPlanBy.transactionTyep=='7'}">selected</c:if>>EXW</option>
							</select>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>监管方式:</h9></label>
					<div class="col-lg-7 valueName">
						<%-- <input type="text" id="supervisionType" name = "supervisionType" value ="${aArrivalPlan.supervisionType }"
							class="form-control"> --%>
							<select class="form-control category" name="supervisionType"
								id="supervisionType">
								<option value="">请选择</option>
								<option value="0" <c:if test="${sShippingPlanBy.supervisionType=='0'}">selected</c:if>>方式一</option>
								<option value="1" <c:if test="${sShippingPlanBy.supervisionType=='1'}">selected</c:if>>方式二</option>
							</select>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>包装尺寸:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="packageDimensions" name = "packageDimensions" value ="${sShippingPlanBy.packageDimensions }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>业务编码:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="businessNumber" name = "businessNumber" value ="${sShippingPlanBy.businessNumber }"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>销售员代码:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="salespersonCode" name = "salespersonCode" value ="${sShippingPlanBy.salespersonCode }"
							class="form-control">
					</div>
				</div>
			</div>
			<%-- <div class="col-lg-12 hang">
				<div class="col-lg-12 saveInput">
				<label class="col-lg-1 fieldName"><h9>上传附件:</h9></label>
						<div class="form-group submit endit-btn" >
			            <a href="javascript:;" class="file" position='relative'>发票 <input type="file" name="file1" id="invoice" value="${sShippingPlanBy.invoice }"></a>
						<a href="javascript:;" class="file" position='relative'>装箱单  <input type="file" name="file2" id="packingList" value="${sShippingPlanBy.packingList }"></a>
						<a href="javascript:;" class="file" position='relative'>合同 <input type="file" name="file3" id="contract" value="${sShippingPlanBy.contract }"></a>
						<a href="javascript:;" class="file" position='relative'>报关委托书<input type="file" name="file4" id="cpoa" value="${sShippingPlanBy.cpoa }"></a>
						<a href="javascript:;" class="file" position='relative'>装箱明细 <input type="file" name="file5" id="packingDetails" value="${sShippingPlanBy.packingDetails }"></a>
						<a href="javascript:;" class="file" position='relative'>其他1  <input type="file" name="file6" id="other1" value="${sShippingPlanBy.other1 }"></a>
						<a href="javascript:;" class="file" position='relative'>其他2 <input type="file" name="file7" id="other2" value="${sShippingPlanBy.other2 }"></a>
						<span class="errorRegion" id="promptFile1" style="color: red;display: none;"></span>
						<span class="errorRegion" id="promptFile2" style="color: red;display: none;"></span>
						<span class="errorRegion" id="promptFile3" style="color: red;display: none;"></span>
						<span class="errorRegion" id="promptFile4" style="color: red;display: none;"></span>  
			           </div> 
			</div>
		  </div> --%>
		</div>
		</form>
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">出货计划表明细:</span>
		</div>
		<div class="col-lg-12 bighuan">
			<table id="orderSku" class="layui-hide"lay-filter="orderSku"></table>
		</div>
	</div>
	
</body>
</html>
