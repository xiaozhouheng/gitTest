	require(['domReady', 'jquery','jsencrypt'], function(domReady, $, jsencrypt) {
		domReady(function() {
			var JSEncrypt = jsencrypt.JSEncrypt;
			ctPath = $('input[name="xoms-contextPath"]').val();

			var addEvent = function() {
			// 聚焦到第一个输入框
			$('#loginName').focus();
			var loginForm = $('#login-form'),
			$loginBtn = $('#loginBtn');
			loginForm.submit(function(event) {
				event.preventDefault()
				var url = $(this).attr('data-url');
				var encrypt = new JSEncrypt();
	            encrypt.setPublicKey($("#publicKey").val());
	            var v_loginName = $('#loginName').val().toUpperCase();
	            var v_password = encrypt.encrypt($('#password').val());
				var data = {
					loginName: 	v_loginName,
					password: v_password,
					verificationCode: $('.verification-code-input').val()
				};
				$loginBtn.addClass('disabled');
				$.ajax({
					url: url,
					data: data,
					dataType: 'json',
					cache: false,
					type: 'POST',
					success: function(result) {
						if(result.status == '1') {
							window.location = result.data;
						} else {
							var data = result.data;
							if(data){
								var isDisplayVerifyCode = data['isDisplayVerifyCode'];
								if(isDisplayVerifyCode){
									$('.verification-code-div').show();
									$('.verification-code-img').click();
								}
							}
							$('#error-div').show();
							$('#error-div span').html(result.msg);
						}
						$loginBtn.removeClass('disabled');
					}
				});
				return false;
			});
			// 先禁用登录按钮,等全部就绪后再启用
			$('#loginBtn').removeClass('disabled');
			
			// 校验码图片点击事件
			$('.verification-code-img').click(function(){
				var url = ctPath + '/base/verification_code/get_image?_r=' + Math.random();
				$(this).attr('src', url);
			});
			
			var isDisplayVerifyCode = $('#isDisplayVerifyCode').val();
			if(isDisplayVerifyCode){
				$('.verification-code-div').show();
				$('.verification-code-img').click();
			}
			}
			
			var init = function() {
				addEvent();
			};
			
			init();
			
		});
	});
