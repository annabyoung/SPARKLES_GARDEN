function createCustomer(){

	if(regValidation()==true){
		console.log("check passed");
		createNewCustomer(); 
	}
}


function regValidation() {

	var firstNCheck = document.getElementById('firstName');
	var surnameCheck = document.getElementById('surname');
	var emailCheck = document.getElementById('email');
	var passwordCheck = document.getElementById('password');
	var phoneCheck = document.getElementById('phone');

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

function createNewCustomer() {

	var firstName = document.getElementById('firstName').value;
	var surname = document.getElementById('surname').value;
	var email = document.getElementById('email').value;
	var password = document.getElementById('password').value;
	var phone = document.getElementById('phone').value;

	var JSONObjCustomer ={customer:{firstName: firstName, surname: surname, passowrd: password, email: email, phone: phone}};
	console.log(JSONObjCustomer.customer.firstName);
	return true;

}