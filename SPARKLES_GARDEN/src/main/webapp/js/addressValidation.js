function createAddress() {

	if (addressValidation()==true){
		console.log("check passed");
		createNewAddress(); 
	}
}

function addressValidation() {

	var houseCheck = document.getElementById('houseID');
	var adCheck = document.getElementById('ad1');
	var cityCheck = document.getElementById('city');
	var countryCheck = document.getElementById('country');
	var postcodeCheck = document.getElementById('postcode');
	var addressTypeCheck = document.getElementById('addressType');

	var error=""; 

	var variablesToCheck = [houseCheck, adCheck, cityCheck, countryCheck, postcodeCheck];

	for(i=0; i < variablesToCheck.length; i++){
		if(variablesToCheck[i].value == null || variablesToCheck[i].value == ""){

			error="All fields marked with * must be filled in"
				document.getElementById("errorMessage").innerHTML= error;
			return false;	
		}
		console.log(addressTypeCheck.value);
		if((addressTypeCheck.value == "Billing" && !addressTypeCheck.value == "Shipping") || (!addressTypeCheck.value == "Billing" && addressTypeCheck.value == "Shipping") ){

			error="Please change your address type to eqaul either 'Billing' or 'Shipping' "
			document.getElementById("errorMessage").innerHTML= error;
			return false;
		}

		window.location=('../registerPayment.xhtml');
		return true;
	}
}

	function createNewAddress(){

		var houseID = document.getElementById('houseID').value;
		var ad1 = document.getElementById('ad1').value;
		var ad2 = document.getElementById('ad2').value;
		var city = document.getElementById('city').value;
		var city = document.getElementById('county').value;
		var country = document.getElementById('country').value;
		var postcode = document.getElementById('postcode').value;
		var addressType = document.getElementById('addressType').value;
		
		var JSONObjAddress = {address:{houseNum: houseID, line1: ad1, line2: ad2, city: city,
			county: county, country: country, postcode: postcode, addressType: addressType}};
		console.log(JSONObjAddress.address.postcode);
		return true;

	}

