function addProductToHomepage(imageNumber){
	var elem = document.createElement("img");
	var srcLink = ("img/gnome"+imageNumber+".jpg");
	elem.setAttribute("src", srcLink);
	elem.setAttribute("style", "height:160");
	elem.setAttribute("alt", "");
	var elemId = ("imageInsertLocation" + imageNumber);
	var x = document.getElementById(elemId);
	x.appendChild(elem);
}
function addAllProducts(){
	var i=0;
	for (i=0;i<5;i++){
		addProductToHomepage(i);
	}
}