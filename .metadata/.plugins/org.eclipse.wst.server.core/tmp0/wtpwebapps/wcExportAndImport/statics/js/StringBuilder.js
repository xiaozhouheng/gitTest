 
/**
 * 实现类似java StringBuilder
 * */
function StringBuilder () {
	     this.__asBuilder = [];
	}

	StringBuilder.prototype.clear = function(){
	     this.__asBuilder = [];//这种写法要比this.__asBuilder.length = 0稍快,快多少，看数组的长度
	}

	StringBuilder.prototype.append = function(){
	     Array.prototype.push.apply(this.__asBuilder,arguments);//调用Array的push方法，这样调用，使用append,可以传递多个参数
	     return this;//这样可以实现append("a").append()的效果
	}

	StringBuilder.prototype.toString = function(){
	     return this.__asBuilder.join("");    
	}