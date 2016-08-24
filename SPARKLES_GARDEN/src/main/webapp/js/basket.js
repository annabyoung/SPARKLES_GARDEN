function deleteItem(){
	/**
	 * Call getProductByID in ProductRepository to get the Product p
	 * Call removeProductFromBasket from com.qac.sparkle_gardens.services.OrderService using p
	 */
}

function addItem(){
	var productID;
	var productName;
	var quantity;
	var costOfProduct;
	var costPerLine;
	
	productID = document.getElementById("productId");
	productName = document.getElementById("productName");
	quantity = document.getElementById("quantity");
	costOfProduct = document.getElementById("price");
	costPerLine = (costOfProduct * quantity);
	
	var lineToAdd = {productLineDefinitions:{productID: productID, productName: productName, quantity:quantity, costPerLine:costPerLine}}
}
function printTable(){
	/**
	 * Call isBasketEmpty from com.qac.sparkle_gardens.services.OrderService. If true, simply print a "Your basket is Empty" message. 
	 * Else
	 * Call getBasket from com.qac.sparkle_gardens.services.OrderService
	 * Retrieve Product image, name, desc and price from= the basket
	 * Find all orders with duplicate products, create one line with a quantity >1
	 * Set all other quantities to 1
	 * Print to screen
	 */
}
function clearBasket(){
	/**
	 * Call clearBasket from com.qac.sparkle_gardens.services.OrderService
	 */ 
}