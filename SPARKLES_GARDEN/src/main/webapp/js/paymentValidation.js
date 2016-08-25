function createCard(){
	
	if(cardValidation==true){
		console.log("check passed");
		createNewCard();
	}
}


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

	return true;
}

function createNewCard(){
	
	var cardOwnerName=document.getElementById('cardName').value;
	var cardNumber=document.getElementById('cardNumber').value;
	var expirationDate=document.getElementById('expDate').value;
	
	var JSONObjCard={card:{cardOwnerName: cardOwnerName, cardNumber: cardNumber, expirationDate: expirationDate}};
	
	$.postJSON("/api/cardrest/registerCard/", JSONObjCard, successCallback);
	
	window.location=('../homepage.xhtml');
	return true;
	
}

$.postJSON=function(url, data, callback){

	return jQuery.ajax({
		headers: { 
			Accept: 'application/json',
			contentType: 'application/json' 
		},
		type: 'POST',
		url: url,
		data: JSON.stringify(data),
		dataType: 'json',
		success: callback
	});
};

$.successCallBack=function(){
	
	alert("Welcom to NBGardens :)");
};