function addressValidation() {
	
	var houseCheck = document.getElementById('formdiv:houseID');
	var adCheck = document.getElementById('formdiv:ad1');
	var cityCheck = document.getElementById('formdiv:city');
	var countryCheck = document.getElementById('formdiv:country');
	var postcodeCheck = document.getElementById('formdiv:postcode');
	
	var error=""; 
	
	var variablesToCheck = [houseCheck, adCheck, cityCheck, countryCheck, postcodeCheck];
	
	for(i=0; i < variablesToCheck.length; i++){
		if(variablesToCheck[i].value == null || variablesToCheck[i].value == ""){
			
			error="All fields marked with * must be filled in"
			document.getElementById("errorMessage").innerHTML= error;
			return false;
			
		}
	}
	
	window.location=('../registerPayment.xhtml');
	return true;
}

