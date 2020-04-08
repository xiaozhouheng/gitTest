/*  
*@Description:	requirejs 配制文件，该文件中因为要获取工程目录做特殊处理
*@Author:	yanxiaoe 
*/
//var ctPath = document.querySelector('input[name="xoms-contextPath"]').value,
//// 国际化处理
//locale = document.querySelector('input[name="xoms-locale"]').value;
//locale = !locale || locale == 'null' ? 'zh_CN' : locale;

require.config({
	baseUrl: '/javascript/src',
	waitSeconds: 100,
	paths: {
		'jquery': 'jquery/jquery-2.1.3',
		'XOMS': 'xoms/plugs/xoms.base',
		'domReady': 'requirejs/domReady',
		// jquery 插件
		'bootstrap': 'bootstrap/bootstrap',
		'select2': 'select2/select2',
		// 这里不要换成压缩的,因为修改了源码,修改内容的地方搜索yanxiaoe
		'jquery.jqGrid': 'jqGrid/jquery.jqGrid.src',
		'jquery.tablednd': 'jqGrid/plugins/jquery.tablednd',
		'zTree': 'ztree/jquery.ztree.core-3.5',
		'zTree-excheck': 'ztree/jquery.ztree.excheck-3.5',
		'zTree-exedit': 'ztree/jquery.ztree.exedit-3.5',
		'jquery.form': 'form/jquery.form',
		'jquery.validate': 'jquery-validation/jquery.validate',
		'switch': 'switch/bootstrap-switch',
		'jquery.mockjax': 'mockjax/jquery.mockjax',
		//'jquery.raty': 'raty/jquery.raty',
		'jquery.placeholder': 'placeholder/jquery.placeholder',
		'jquery.jqpagination': 'jqPagination/jquery.jqpagination',
		
		// jquery ui 项目中的jquery.ui是选择性的下载:
		// http://jqueryui.com/download/#!version=1.11.4&components=1111101000111110001000000000000000000
		'jquery.ui': 'jquery-ui/jquery-ui',
		'timepicker-addon': 'timepicker-addon/jquery-ui-timepicker-addon',
		'codemirror': 'codemirror/codemirror',
		'jquery.confirm' : 'jquery-confirm/jquery-confirm',
		'daterangepicker' : 'daterangepicker/daterangepicker',
		'moment' : 'daterangepicker/moment',
		// 独立插件
		// 不要切换kindeditor的引用, 里面做了修改
		// 修改内容是引 CSS的部分
//		'kindeditor': 'kindeditor/kindeditor',
//		'kindeditor.locale': 'xoms/i18n/plugs/kindeditor',
//		'kindeditor.locale': 'kindeditor/lang/en_US',
//		'echarts': 'echarts/dist/echarts-all',
//		'echarts.src': 'echarts/source/echarts-all',
		'template': 'artTemplate/template',
		'b64_md5': 'util/md5',
		'masonry': 'masonry/masonry.pkgd',
		'bridget': 'bridget/jquery.bridget',
		'jsencrypt': 'jsencrypt/jsencrypt',
		
		// xoms插件
		'xoms.banner': 'xoms/plugs/xoms.banner',
		'xoms.tip': 'xoms/plugs/xoms.tip',
		'xoms.confirm': 'xoms/plugs/xoms.confirm',
		'xoms.timepicker': 'xoms/plugs/xoms.timepicker',
		'xoms.validate': 'xoms/plugs/xoms.validate',
		'xoms.htmlESC': 'xoms/plugs/xoms.htmlESC',
		'xoms.storage': 'xoms/plugs/xoms.storage',
		'xoms.loading': 'xoms/plugs/xoms.loading',
		'xoms.mock': 'xoms/mockajax/xoms.mock',
		'xoms.chinaAddrSelect': 'xoms/plugs/xoms.chinaAddrSelect',
		
		// 业务模块插件
		'xoms.permission.selector': 'xoms/console/authority.permission.selector',
		'xoms.activateduser.selector': 'xoms/console/authority.activateduser.selector',
		//'xoms.activity.selector': 'xoms/console/activity.selector',
		'xoms.countryOrProductTemplate': 'xoms/common/xoms.countryOrProductTemplate',
		'xoms.countryOrProductMultiselect': 'xoms/common/xoms.countryOrProductMultiselect',
		'xoms.select': 'xoms/common/xoms.select',
		'xoms.templateMapping': 'xoms/common/xoms.templateMapping',
		'xoms.orderProblemReplydialog': 'xoms/common/xoms.orderProblemReplydialog',
		'order.form': 'xoms/console/order.form',
		'xoms.orderManagementGrid': 'xoms/order/myorder/order.management.grid',
		'xoms.orderManagementGrid.base': 'xoms/order/myorder/order.management.grid.base',
		'xoms.myOrderForm': 'xoms/common/xoms.myOrderForm',
		'xoms.shipperSelect': 'xoms/common/xoms.shipperSelect',
		'xoms.skuSelect': 'xoms/common/xoms.skuSelect',
		'xoms.defaultRule': 'xoms/common/xoms.defaultRule',
		'xoms.salerSelect':'xoms/console/saler.select',
		'xoms.chargeQueryValid':'xoms/common/xoms.chargeQueryValid',
		'xoms.salepriceSelect':'xoms/console/material/saleprice.select',
		'xoms.receivingOrderHeaderSelect':'xoms/console/material/receivingOrderHeader.select',
		'xoms.shipmentSelect':'xoms/console/material/shipment.select',
		
		'xoms.insuranceManagementGrid': 'xoms/order/vas/insurance/insurance.management.grid',
		'xoms.insuranceManagementGrid.base':'xoms/order/vas/insurance/insurance.management.grid.base',
		// 业务模块插件 - 运营监控中的图表生成JS
		//'statistics.chart': 'xoms/console/statistics/statistics.chart',
		// 揽收管理 - 站点选择插件
		//'pickup.stationSelect': 'xoms/console/settings/pickup.stationSelect',
		// 国际化文件
		'xoms.lang': 'xoms/i18n/xoms.lang',
		'xoms.lang.common': 'xoms/i18n/common/common',
		'xoms.lang.myorder': 'xoms/i18n/order/myorder',
		'xoms.lang.skusetting': 'xoms/i18n/order/skusetting',
		'xoms.lang.shipperaccount': 'xoms/i18n/order/shipperaccount',
		'xoms.lang.home': 'xoms/i18n/home/home',
		'xoms.lang.financial': 'xoms/i18n/order/financial',
		'xoms.lang.mybill': 'xoms/i18n/order/mybill',
		'xoms.lang.tranckquery': 'xoms/i18n/order/trackquery',
		'xoms.lang.issue': 'xoms/i18n/order/issue',
		'xoms.lang.feedback': 'xoms/i18n/order/feedback',
		'xoms.lang.changepassword': 'xoms/i18n/order/changepassword',
		

		'xoms.lang.insurance':'xoms/i18n/order/insurance',
		// 插件的国际化
		'xoms.timepicker.locale': 'xoms/i18n/plugs/timepicker',
		'xoms.validate.locale': 'xoms/i18n/plugs/validate',
		'select2.locale': 'xoms/i18n/plugs/select2',
		'jquery.jqGrid.locale': 'xoms/i18n/plugs/jqGrid',
	},
	shim: {
		// jquery 插件
		'XOMS': {
			deps: ['jquery']
		},
		'bootstrap': {
			deps: ['jquery'],
			exports: 'jQuery.fn.popover'
		},
		'select2': {
			deps: ['jquery']
		},
		'jquery.jqGrid': {
			deps: ['jquery', 'jquery.jqGrid.locale']
		},
		'jquery.jqGrid.locale': {
			deps: ['jquery']
		},
		'jquery.tablednd': {
			deps: ['jquery', 'jquery.jqGrid.locale']
		},
		// jquery.ui本身是不依赖bootstrap的,由于jquery.ui的button与bootstrap的冲突,为了使用jquery.ui的botton,只有在这里添加依赖,使bootstrap优先于jquery.ui加载
		'jquery.ui': {
			deps: ['bootstrap']
		},
		'jquery.confirm':{
			deps: ['jquery']
		},
		'jquery.mockjax': {
			deps: ['jquery']
		},
		'jquery.jqpagination': {
			deps: ['jquery']
		},
		'zTree': {
			deps: ['jquery']
		},
		'zTree-excheck': {
			deps: ['zTree']
		},
		'zTree-exedit': {
			deps: ['zTree']
		},		
		'timepicker-addon': {
			deps: ['jquery.ui']
		},
		'jquery.form': {
			deps: ['jquery']
		},
		'switch': {
			deps: ['jquery']
		},
		// 独立插件
		'kindeditor': {
			exports: 'kindEditor'
		},
		'kindeditor.locale': {
			exports: 'kindEditor',
			deps: ['kindeditor']
		},
		'b64_md5': {
			exports: 'b64_md5'
		}
	}
});