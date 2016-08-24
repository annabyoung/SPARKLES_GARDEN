function addProductToHomepage(productToAdd, i){	
	//Create img
	var elem = document.createElement("img");
	var srcLink = ("img/gnome"+i+".jpg");
	elem.setAttribute("src", srcLink);
	elem.setAttribute("style", "height:160");
	elem.setAttribute("alt", "");
	var elemId = ("imageInsertLocation" + i);
	var x = document.getElementById(elemId);
	x.appendChild(elem);
	//End of create img
	
	
	document.setElementById("productname").value = productToAdd.productName;
	var thePrice = ("£" + productToAdd.price);
	document.setElementById("price").value = thePrice;
	
	
}
function addAllProducts(productList){
	console.log("addAllProducts entered and length of list is " + productList.length);
	for (var i=0;i<productList.length;i++){
		console.log("in loop at position " + i);
		addProductToHomepage(productList[i], i);
	}
}

function getListOfProducts(){
	var listOfProducts = $.getJSON("/api/search/productList");
	
	
	alert(JSON.stringify(listOfProducts.responseJSON));
	addAllProducts(listOfProducts);
	console.log("addAllProducts called");
}