$(function(){
	
	var count=1;
	
	$("#addressCount").load(function(){
		document.getElementById("addressCount").html("Address" + count);
	});
	
	$("#extraForm").click(function(){
		console.log("Cloning form");
		count++; 
		$("#formdiv").clone().appendTo("#clonePoint");
		document.getElementById("addressCount").html("Address" + count);
	});
	
});