(function($){  
    $.fn.serializeJson=function(){  
        var serializeObj={};  
        var array=this.serializeArray();  
        var str=this.serialize();  
        $(array).each(function(){  
            if(serializeObj[this.name]){  
                if($.isArray(serializeObj[this.name])){  
                    serializeObj[this.name].push(this.value);  
                }else{  
                    serializeObj[this.name]=[serializeObj[this.name],this.value];  
                }  
            }else{  
                serializeObj[this.name]=this.value;   
            }  
        });  
        return serializeObj;  
    };  
})(jQuery); 


Array.prototype.remove=function(dx)
{
    if(isNaN(dx)||dx>this.length){return false;}
    for(var i=0,n=0;i<this.length;i++)
    {
        if(this[i]!=this[dx])
        {
            this[n++]=this[i]
        }
    }
    this.length-=1
}

//********模式窗口类***********

function modalwindow(title,width,height,url){
	this.title=title;
	this.width=width;
	this.height=height;
	this.url=url;
	var id = new Date().getMilliseconds();
	this.windowid="win_"+id;
	this.iframeid="iframe_"+id;

}
modalwindow.prototype.createWindow = function(){
	var active = document.createElement("div");
	active.id="active";
	document.body.appendChild(active);
	active.innerHTML="<div id="+this.windowid+" class=\"easyui-window\" modal='true' closed='true' resizable='false' style='overflow:hidden;' iconCls=\"icon-save\" ><iframe scrolling='yes' style='overflow-x:hidden;' id='"+this.iframeid+"' src='"+this.url+"' frameborder='0' width='100%' height='100%'></iframe></div>";
	$('#'+this.windowid).window({
		title: this.title,
		width: this.width,
		modal: true,
		shadow: false,
		minimizable:false,
		collapsible:false,
		closed: true,
		height: this.height
	});
	this.open();

};
modalwindow.prototype.open = function(){
	$('#'+this.windowid).window('open');
};
modalwindow.prototype.close = function(){
	$('#'+this.windowid).window('close');
};

//模式窗口单一实例
var modalwindow_singleobj;
//创建模式窗口
function createmodalwindow(title,width,height,url){
	modalwindow_singleobj = new modalwindow(title,width,height,url);
	modalwindow_singleobj.createWindow();

}
//关闭模式窗口
function closemodalwindow(){
	if(modalwindow_singleobj){
		modalwindow_singleobj.close();
	}
}

Date.prototype.format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

//日期类型转成"yyyy-MM-dd hh:mm:ss"
function formatDate(value){
	//return new Date(value).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
	if(value==null){
		return '';
	}
	var date = new Date(value);
	return date.format("yyyy-MM-dd hh:mm:ss");
}

function formatDate4(value){
	//return new Date(value).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
	if(value==null){
		return '';
	}
	var date = new Date(value);
	return date.format("yyyy-MM-dd");
}
//日期类型转成"yyyy/MM/dd"
function formatDate2(value){
	if(value==null){
		return '';
	}
	var date = new Date(value);
	return date.format("yyyy/MM/dd");
}

/**13位时间戳转换成 年月日 上午 时间  2018-05-23 10:41:08 */
function createTime(v){  
	return new Date(parseInt(v)).toLocaleString()
}
/**重写toLocaleString方法*/
Date.prototype.toLocaleString = function() {
	 	var y = this.getFullYear();  
	    var m = this.getMonth()+1;  
	    m = m<10?'0'+m:m;  
	    var d = this.getDate();  
	    d = d<10?("0"+d):d;  
	    var h = this.getHours();  
	    h = h<10?("0"+h):h;  
	    var M = this.getMinutes();  
	    M = M<10?("0"+M):M;  
	    var S=this.getSeconds();
	    S=S<10?("0"+S):S;  
	    return y+"-"+m+"-"+d+" "+h+":"+M+":"+S; 
    //return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate() + " " + this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds();
};

function formatDate3(value){
	if(value==null){
		return '';
	}
	var date = new Date(value);
	return date.format("yyyy-MM");
}

function showBg(){
	var body = document.getElementsByTagName("body")[0];
	$(body).append("<div id='hidebg' style='position:absolute;left:0px;top:0px; background-color:#000;width:100%; filter:alpha(opacity=10); opacity:0.1; display:none; z-Index:2;'></div>");
	$(body).append("<div id='hidebox'  style='position:absolute;display:none;cursor:pointer;z-Index:3;margin:auto;top: 0; left: 0; bottom: 0; right: 0; width:100px;height:30px'><font color='black'>正在操作中...</font></div>");
	var hideobj=window.document.getElementById("hidebg");
	hidebg.style.display="block";  //显示隐藏层
	hidebg.style.height=window.document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
	window.document.getElementById("hidebox").style.display="block";  //显示弹出层
}

function hideBg(){
	window.document.getElementById("hidebg").style.display="none";
	window.document.getElementById("hidebox").style.display="none";
}

function printPartialPick(list){
	var html = '';
	html += '';
	html += '<style>';
	html += '	td{font-size:12px;}';
	html += '	#remark{margin-top:8px;}';
	html += '	#title{border-bottom:1px solid #000000;padding:5px 0px;}';
	html += '	#title h2{padding:0px;margin:0px;text-align:center;}';
	html += '	.expressList{border-right:1px solid #000000;border-bottom:1px solid #000000;}';
	html += '	.expressListLeft{border-bottom:1px solid #000000;font-size:16px;font-weight:bold;}';
	html += '	.dataHeader{font-weight:bold;text-align:center;}';
	html += '	.dataItem{font-weight:bold;text-align:center;}';
	html += '	#dataList td{border-left:1px solid #000000;border-top:1px solid #000000;}';
	html += '	#dataList{border-bottom:1px solid #000000;width:100%;border-right:1px solid #000000;}';
	html += '	#expressList{width:100%;margin:8px 0px;border-top:1px solid #000000;border-left:1px solid #000000;}';
	html += '</style>';
	html += '<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">';
	html += '	<tr>';
	html += '		<td id=\"title\">';
	html += '			<h2>分 拣 单</h2>';
	html += '		</td>';
	html += '	</tr>';
	html += '	<tr>';
	html += '		<td id=\"title\">';
	html += '			波次单号：'+list[0].batchno;
	html += '		</td>';
	html += '	</tr>';
	html += '</table>';
	html += '<br/>';
	html += '		<table id=\"dataList\"  cellspacing=\"0\" cellpadding=\"5\" style="border-collapse:collapse">';
	html += '			<tr>';
	html += '				<td class=\"dataHeader\">订单号</td>';
	html += '				<td class=\"dataHeader\">运单号</td>';
	html += '				<td class=\"dataHeader\">商品条码</td>';
	html += '				<td class=\"dataHeader\">商品名称</td>';
	html += '				<td class=\"dataHeader\">拣货数量</td>';
	html += '				<td class=\"dataHeader\">拣货库位</td>';
	html += '			</tr>';
	for(var i=0;i<list.length;i++){
		html += '			<tr>';
		html += '				<td class=\"dataHeader\">'+list[i].orderno+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].mailno+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].itemcode+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].itemname+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].pickcount+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].pickstoragelocation+'</td>';
		html += '			</tr>';
	}
	html += '			</table>';
	return html;

}

function printPartialPick2(data){
	var orders = data.orders;
	var list = data.list;
	var html = '';
	html += '';
	html += '<style>';
	html += '	td{font-size:12px;}';
	html += '	#remark{margin-top:8px;}';
	html += '	#title{border-bottom:1px solid #000000;padding:5px 0px;}';
	html += '	#title h2{padding:0px;margin:0px;text-align:center;}';
	html += '	.expressList{border-right:1px solid #000000;border-bottom:1px solid #000000;}';
	html += '	.expressListLeft{border-bottom:1px solid #000000;font-size:16px;font-weight:bold;}';
	html += '	.dataHeader{font-weight:bold;text-align:center;}';
	html += '	.dataItem{font-weight:bold;text-align:center;}';
	html += '	#dataList td{border-left:1px solid #000000;border-top:1px solid #000000;}';
	html += '	#dataList{border-bottom:1px solid #000000;width:100%;border-right:1px solid #000000;}';
	html += '	#expressList{width:100%;margin:8px 0px;border-top:1px solid #000000;border-left:1px solid #000000;}';
	html += '</style>';
	html += '<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">';
	html += '	<tr>';
	html += '		<td id=\"title\">';
	html += '			<h2>总 拣 单</h2>';
	html += '		</td>';
	html += '	</tr>';
	html += '	<tr>';
	html += '		<td id=\"title\">';
	html += '			波次单号：'+list[0].batchno;
	html += '		</td>';
	html += '	</tr>';
	html += '</table>';
	
	html += '<br/>';
	html += '		<table cellspacing=\"0\" cellpadding=\"5\" id=\"expressList\">';
	for(var i=0;i<orders.length;i++){
		html += '			<tr>';
		for(var j=0;j<4&&i<orders.length;j++){
			var order = orders[i];
			html += '				<td  class=\"expressListLeft\">' + (i+1)
					+ '</td><td class=\"expressList\">快递单号：'
					+ order.mailno + '<br />收货人：'
					+ order.receiveman + '</td>';

			i++;
		}
		i--;
		html += '			</tr>';
	}
	html += '		</table>';
	
	html += '<br/>';
	html += '		<table id=\"dataList\"  cellspacing=\"0\" cellpadding=\"5\" style="border-collapse:collapse">';
	html += '			<tr>';
	html += '				<td class=\"dataHeader\">拣货库位</td>';
	html += '				<td class=\"dataHeader\">商品条码</td>';
	html += '				<td class=\"dataHeader\">拣货数量</td>';
	html += '				<td class=\"dataHeader\">快递序号</td>';
	html += '				<td class=\"dataHeader\">商品名称</td>';
	html += '			</tr>';
	for(var i=0;i<list.length;i++){
		html += '			<tr>';
		html += '				<td class=\"dataHeader\">'+list[i].pickstoragelocation+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].itemcode+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].pickcount+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].kdxh+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].itemname+'</td>';
		html += '			</tr>';
	}
	html += '			</table>';
	return html;

}


function printTotalPick2(list){
	var html = '';
	html += '';
	html += '<style>';
	html += '	td{font-size:12px;}';
	html += '	#remark{margin-top:8px;}';
	html += '	#title{border-bottom:1px solid #000000;padding:5px 0px;}';
	html += '	#title h2{padding:0px;margin:0px;text-align:center;}';
	html += '	.expressList{border-right:1px solid #000000;border-bottom:1px solid #000000;}';
	html += '	.expressListLeft{border-bottom:1px solid #000000;font-size:16px;font-weight:bold;}';
	html += '	.dataHeader{font-weight:bold;text-align:center;}';
	html += '	.dataItem{font-weight:bold;text-align:center;}';
	html += '	#dataList td{border-left:1px solid #000000;border-top:1px solid #000000;}';
	html += '	#dataList{border-bottom:1px solid #000000;width:100%;border-right:1px solid #000000;}';
	html += '	#expressList{width:100%;margin:8px 0px;border-top:1px solid #000000;border-left:1px solid #000000;}';
	html += '</style>';
	html += '<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">';
	html += '	<tr>';
	html += '		<td id=\"title\">';
	html += '			<h2>总 拣 单</h2>';
	html += '		</td>';
	html += '	</tr>';
	html += '	<tr>';
	html += '		<td id=\"title\">';
	html += '			波次单号：'+list[0].batchno;
	html += '		</td>';
	html += '	</tr>';
	html += '</table>';
	html += '<br/>';
	html += '		<table id=\"dataList\"  cellspacing=\"0\" cellpadding=\"5\" style="border-collapse:collapse">';
	html += '			<tr>';
	html += '				<td class=\"dataHeader\">商品条码</td>';
	html += '				<td class=\"dataHeader\">商品名称</td>';
	html += '				<td class=\"dataHeader\">拣货总量</td>';
	html += '			</tr>';
	for(var i=0;i<list.length;i++){
		html += '			<tr>';
		html += '				<td class=\"dataHeader\">'+list[i].itemcode+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].itemname+'</td>';
		html += '				<td class=\"dataHeader\">'+list[i].pickcount+'</td>';
		html += '			</tr>';
	}
	html += '			</table>';
	return html;

}

function imgShow(outerdiv, innerdiv, bigimg, _this){
	var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
	$(bigimg).attr("src", src);//设置#bigimg元素的src属性
 
        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
	$("<img/>").attr("src", src).load(function(){
		var windowW = $(window).width();//获取当前窗口宽度
		var windowH = $(window).height();//获取当前窗口高度
		var realWidth = this.width;//获取图片真实宽度
		var realHeight = this.height;//获取图片真实高度
		var imgWidth, imgHeight;
		var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放
		
		if(realHeight>windowH*scale) {//判断图片高度
			imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
			imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
			if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
				imgWidth = windowW*scale;//再对宽度进行缩放
			}
		} else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
			imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                        imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
		} else {//如果图片真实高度和宽度都符合要求，高宽不变
			imgWidth = realWidth;
			imgHeight = realHeight;
		}
                $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放
		
		var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
		var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
		$(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
		$(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
	});
	
	$(outerdiv).click(function(){//再次点击淡出消失弹出层
		$(this).fadeOut("fast");
	});
}


