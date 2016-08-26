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
	var listOfProducts	= $.getJSON( "/api/search/productList", function( prodList ) {
		for (var i in prodList){
			getEachProduct(prodList[i]);
			console.log("Product " + i + " = " + prodList[i]);
		}
	});
/*	var listOfProducts	= $.getJSON( "/api/search/productList", function( data ) {
		  var items = [];
		  $.each( data, function( key, val ) {
		    items.push( "<li id='" + key + "'>" + val + "</li>" );
		    console.log("key: " + key + " val: " + val + " ");
		  });
		 
		  $( "<ul/>", {
		    "class": "my-new-list",
		    html: items.join( "" )
		  }).appendTo( "body" );
		});
*/	
	
	//listOfProducts = $.getJSON("/api/search/productList").done(function getTheList(theData){
	/*listOfProducts = $.getJSON("/api/search/product").done(function getTheList(theData){
		theData = listOfProducts;
		console.log("Info Retrieved is " + theData); 
		console.log(Object.keys(listOfProducts))

		console.log(theData);

		var theJSONObject = listOfProducts["responseText"];
		theJSONObject = theJSONObject.split("},");
		
		var key = "productName";
		var prod = {productDefinition:theJSONObject}
		console.log(theJSONObject);
		for (var i in theJSONObject){
			theJSONObject[i] = theJSONObject[i].split("}]");
			getDataElement(theJSONObject[i][0]);
		}
	});
	*/
}

function getEachProduct(data){
	 var items = [];
	  $.each( data, function( key, val ) {
	    items.push( "<li id='" + key + "'>" + val + "</li>" );
	    console.log("key: " + key + " val: " + val + " ");
	  });
	 
	  $( "<ul/>", {
	    "class": "my-new-list",
	    html: items.join( "" )
	  }).appendTo( "body" );
	
}

function getDataElement(product){
	console.log("In getDataElement");
	console.log(product);
	
	
	var element = [0,"7",3,4,5,6] ;
	var i = 0;
	var res = product.split(',');
	for (var i=0;i<res.length;i++){
		res[i] = res[i].split(":");

		console.log("res[" + i + "] = " + res[i]);
	}
	console.log("res = " + res);
	
	res[(res.length) -1][0] = res[(res.length) -1][0].split("]");
	var finalTag = res[(res.length) -1][0][0];
	var prodID = res[0][1];
	var name = res[1][1];
	var stock = res[2][1];
	var cost = res[3][1];
	var desc = res[4][1];
	console.log("Product ID = " + prodID);
	console.log("Name = " + name);
	console.log("Stock = " + stock);
	console.log("Price = " + cost);
	console.log("Description = " + desc);
	console.log(res);
	res[5][1]= res[5][1].split("[");
	var firstTag = res[5][1][1];
	var tags = firstTag;
	var i = 6;
	for (i=6;i<res.length-1;i++){
		tags+=res[i];
	}
	tags+=finalTag;
	console.log("Tags = " + tags);
}