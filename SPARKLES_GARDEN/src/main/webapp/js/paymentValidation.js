function CheckAll(){

	
	if(Validation()==true){
		
		Validity();
	}
}


function Validation() {
	
	var nameCheck = document.getElementById('formdiv:cardName');
	var numCheck = document.getElementById('formdiv:cardNumber');
	var expCheck = document.getElementById('formdiv:expDate');
	
	var error="";
	
	var variablesToCheck = [nameCheck, numCheck, expCheck];
	
	for(i=0; i < variablesToCheck.length; i++){
		if(variablesToCheck[i].value == null || variablesToCheck[i].value == ""){
			
			error="All fields marked with * must be filled in"
			document.getElementById("errorMessage").innerHTML= error;
			return false;
			
		}
	}
	
	window.location=('../homepage.xhtml');
	return true;
}

function Validity() {
	
	var checkName=document.getElementById("formdiv:cardName");
	var checkCard=document.getElementById("formdiv:cardnumber");
	var checkExp=document.getElementById("formdiv:expDate");
	
	var error="";
	
	var inputChecks=[checkName, checkCard, checkExp];
	
	for (i=0; i < inputChecks.length; i++){
		
		if(inputChecks[i].value.validity.typeMismatch){
			
			console.log(i); 
			error= "Your fields dont match the required input type. E.g Card Number must be a number"
		}
	}
	
	document.getElementById("errorMessage").innerHTML=error; 
} 