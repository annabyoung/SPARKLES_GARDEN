function cardValidation() {
	var nameCheck = document.getElementById('cardName');
	var numCheck = document.getElementById('cardNumber');
	var expCheck = document.getElementById('expDate');
	var error="";
	var variablesToCheck = [nameCheck, numCheck, expCheck];
	for(i=0; i < variablesToCheck.length; i++){
		if(variablesToCheck[i] == null || variablesToCheck[i].value == ""){
			error="All fields marked with * must be filled in"
			document.getElementById("errorMessage").innerHTML= error;
			return false;
		}
	}
	window.location=('../homepage.xhtml');
	return true;
}

