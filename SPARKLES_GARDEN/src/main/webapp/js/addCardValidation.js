function cardValidation() {
	
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
	
	window.location=('manageCards.xhtml');
	return true;
}