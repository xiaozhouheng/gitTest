require(['domReady', 'jquery', 'XOMS', 'xoms.validate', 'xoms.lang.financial'], function(domReady, $, XOMS) {
	domReady(function() {
		/*var ctPath = XOMS.contextPath,
		Lang = XOMS.Lang.financial.payonline;
		
		$.validator.addMethod("amount", function(value, element, params) {
			var result = true;
			if(value < 10 || !/^\d+(?:\.\d{1,2})?$/.test(value)) {
				result = false;
			}
			if(value == 0.01 || value == 0.02) {
				result = true;
			}
			return result;
		}, Lang.amountReg);
		
		var view = {
			*//** 切换充值类型 *//*
			changePayType: function(type) {
				var msg = '',
				amountType = '',
				agreeTip = Lang.ppAgreen;
				$('.payoneer-group').hide();
				$('.agreement-group').hide();
				$('.payoneer-type-group').hide();
				$('.payoneer-tb-group').hide();
				if(type == 'KQ') {
					msg = Lang.kqReg;
					amountType = '(CNY)';
				} else if(type == 'BF') {
					msg = Lang.kqReg;
					amountType = '(CNY)';
				} else if(type == 'PP') {
					msg = Lang.usdMsg;
					amountType = '(USD)';
					agreeTip = Lang.ppAgreen;
					$('.agreement-group').show();
				} else if(type == 'PO') {
					msg = Lang.usdMsg;
					amountType = '(USD)';
					agreeTip = Lang.pyAgreen;
					$('.payoneer-type-group').show();
					$('.payoneer-group').show();
					$('.agreement-group').show();
				}
					$('.payonline-btn-group').show();
					$('#amount').attr('placeHolder', msg);
					$('.amount-type').html(amountType);
					$('.agreement-group label span').html(agreeTip);
					$('.payoneer-amount-group').show();
			},
		
			changeAmountType: function(amountType) {
				$('.amount-type').html('('+amountType+')');
				var msg = amountType=='USD'?Lang.usdMsg:Lang.eurMsg;
				$('#amount').attr('placeHolder', msg);
			}
		
		
		};*/
		
		/*var model = {
			*//** 获取账户余额 *//*
			getRemainingSum: function() {
				$.ajax({
					url: ctPath + '/order/finance_management/payonline/get_remaining_sum',
					success: function(re) {
						if(re.status == '1') {
							$('.payonline-sum-label').html(re.data + ' (CNY)');
						}
					}
				});
			},
			*//**获取payoneer注册链接*//*
			getPayoneerRechargeUrl:function(type){
				$.ajax({
					url:ctPath+'/order/finance_management/payonline/get_payoneer_recharge_url',
					data:{type:type},
					success:function(re){
						if(re.status == '1'){
							$('#payoneerRechargeUrl').attr("href",re.data);
						}
					}
				});
			}
		};*/
		
		var addEvent = function() {
			var pForm = $('.payonline-form'),
			validate = XOMS.validate(pForm, {
				rules: {
					amount: {
						required: true,
						amount: true
					},
					agreement: {
						required: true
					}
				},
				messages: {
					agreement: {
						required: Lang.agreenReg
					}
				},
				submitHandler: function(form) {
					$('#payonline-modal-dialog').modal('show');
					form.submit();
				}
			});
			
			// ------------ form 表单相关的事件 ----------
			// 切换充值类型
			$('.payonline-type-group').on('change', 'input', function(e) {
				alert(1)
				var val = $(e.target).val();
				view.changePayType(val);
			});
			
			
			//payoneer 切换充值币种
			$('.payoneer-type-group').on('change', 'input', function(e) {
				var val = $(e.target).val();
				model.getPayoneerRechargeUrl(val);
				view.changeAmountType(val);
			});
			
			
			$('.payonline-again').on('click', function(e) {
				location.reload();
			});
		};
		
		var init = function() {
			addEvent();
			model.getRemainingSum();
			model.getPayoneerRechargeUrl('USD');
		};
		
		init();
	});
});
