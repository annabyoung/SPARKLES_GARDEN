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
	
	var cardHolderName=document.getElementById('cardName').value;
	var cardNumber=document.getElementById('cardNumber').value;
	var startDate=document.getElementById('startDate').value;
	var expDate=document.getElementById('expDate').value;
	
	var JSONObjCard={card:{cardHolderName: cardHolderName, cardNumber: cardNumber, startDate: startDate, expDate: expDate}};
	
	console.log(JSONObjCard.card.cardNumber);
	window.location=('../homepage.xhtml');
	return true;
	
}