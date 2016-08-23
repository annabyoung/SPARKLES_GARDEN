/*$(function(){
	$("#submit").click(function(){
		var number = document.getElementById("#cardNumber");
		if(number.validity.typeMismatch){
			number.setCustomValidity("Data type mismatch");
		} else{
			number.setCustomValidity("");
		}
	});
});*/

$(function(){
	$("#submit").click(function(){
		var valueToCheck = document.getElementById("#cardNumber").value;
		var validValue = new RegExp ('^4[0-9]{12}(?:[0-9]{3})?$');
		
		if(validValue.test(valueToCheck)){
			
			alert('Valid card number');
		}else{
			
			alert('Please enter a valid visa card number');
		}
	});
});