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


//	document.setElementById("productname").value = productToAdd.productName;
//	var thePrice = ("£" + productToAdd.price);
//	document.setElementById("price").value = thePrice;


}
function addAllProducts(productList){
	console.log("addAllProducts entered and length of list is " + productList.length);
	for (var i=0;i<5;i++){
		console.log("in loop at position " + i);
		console.log("productList["+i+"] = " + productList[i]);
		addProductToHomepage(productList[i], i);
	}
}

function getListOfProducts(){
	var listOfProducts;

	listOfProducts = $.getJSON("/api/search/product").done(function getTheList(theData){

		theData = listOfProducts;
		console.log("Info Retrieved is " + theData); 
		console.log(Object.keys(listOfProducts))
		
		console.log(theData);
		
		var theJSONObject = listOfProducts["responseText"];
		console.log("theJSONObject = " +theJSONObject);
		var key = "productName";
		var prod = {productDefinition:theJSONObject}
		console.log("Product ID = " + (prod["productDefinition"].productID));
		

//		addAllProducts(listOfProducts);
//		console.log("addAllProducts called");
	});


}