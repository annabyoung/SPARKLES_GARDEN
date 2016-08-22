function regValidation() {
	
	var firstNCheck = document.getElementById('formdiv:firstName');
	var surnameCheck = document.getElementById('formdiv:surname');
	var emailCheck = document.getElementById('formdiv:email');
	var passwordCheck = document.getElementById('formdiv:password');
	var phoneCheck = document.getElementById('formdiv:phone');
	
	var error=""; 
	
	var variablesToCheck = [firstNCheck, surnameCheck, emailCheck, passwordCheck, phoneCheck];
	
	for(i=0; i < variablesToCheck.length; i++){
		if(variablesToCheck[i].value == null || variablesToCheck[i].value == ""){
			
			error="All fields must be filled in before continuing"
			document.getElementById("errorMessage").innerHTML= error;
			return false;
			
		}
	}
	
	window.location=('../registerAddress.xhtml');
	return true;
}