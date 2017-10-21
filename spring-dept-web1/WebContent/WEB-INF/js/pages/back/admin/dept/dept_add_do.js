//倒计时处理
window.onload=function(){
	
	gotimeout();
	function gotimeout(){
		/*将字符串转换成数字*/
		var time=parseInt(document.getElementById("sptime").innerHTML);
		time--;
		if(time==0){
			window.location="pages/back/admin/dept/dept_add.jsp";
		}else{
			document.getElementById("sptime").innerHTML=time;
			setTimeout(gotimeout,1000);
		}
		
	}
}
