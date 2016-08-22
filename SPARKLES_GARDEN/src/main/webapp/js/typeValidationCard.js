$(function(){
	$("#submit").click(function(){
		var number = document.getElementById("#cardNumber").validity.typeMismatch;
		if(number.validity.typeMismatch){
			number.setCustomValidity("Data type mismatch");
		} else{
			number.setCustomValidity("");
		}
	});
});
