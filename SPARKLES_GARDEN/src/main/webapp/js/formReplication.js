function showNewForm() {
	
	var addressForm = document.getElementById("formdiv");
	
	document.getElementById("addExtraForm").innerHTML = '<label>House number/ name:</label><input type="text" name="houseName"><br><label>Address Line 1:</label><input type="text" name="ad1"><br><label>Address Line 2:</label><input type="text" name="ad2"><br><label>City:</label><input type="text" name="city"><br><label>County:</label><input type="text" name="county"><br><label>Country:</label><input type="text" name="country"><br><label>Postcode:</label><input type="text" name="postcode"><br><label>Address Type:</label><select><option value="House">Billing</option><option value="Apartment">Shipping</option><br></select><span id="addExtraForm"></span>'
	
}