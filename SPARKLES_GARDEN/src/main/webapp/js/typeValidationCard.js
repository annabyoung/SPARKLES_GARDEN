$(function(){
	$("#submit").click(function(){
		var number = document.getElementById("cardNumber");
		if(number.validity.typeMismatch){
			alert("Not correct");
		} else{
			number.setCustomValidity("");
		}
	});
});
