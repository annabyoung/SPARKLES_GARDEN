function loginValidation() {
	
	var usernameCheck = document.getElementById('username');
	var passwordCheck = document.getElementById('password');
	
	var error=""; 
	
	var variablesToCheck = [usernameCheck, passwordCheck];
	for(i=0; i < variablesToCheck.length; i++){
		if(variablesToCheck[i].value == null || variablesToCheck[i].value == ""){
			error="Please enter a valid username and password"
			document.getElementById("errorMessage").innerHTML= error;
			return false;
		}
	}
	window.location=("../homepage.xhtml");
	return true;
}
