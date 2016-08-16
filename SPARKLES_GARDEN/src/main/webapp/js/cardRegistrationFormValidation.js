function Validation(a,b,c) {
	
	var nameCheck = document.getElementById('formdiv:cardName');
	var numCheck = document.getElementById('formdiv:cardNumber');
	var expCheck = document.getElementById('formdiv:expDate');
	
	console.log(nameCheck.value);
	console.log(numCheck.value);
	console.log(expCheck.value);
	
	var variablesToCheck = [nameCheck, numCheck, expCheck];
	
	for(i=0; i < variablesToCheck.length; i++){
		if(variablesToCheck[i].value == null || variablesToCheck[i].value == ""){
			
			alert("Fields marked with a * must be completed");
			return false;
			
		} else if(variablesToCheck[i].value != null || variablesToCheck[i].value != ""){
			
			window.url='..\homepage.xhtml';
		}
	}
}

function Error() {
	
	alert("Error");
}