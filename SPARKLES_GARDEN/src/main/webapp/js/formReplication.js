$(function(){
	
	var count=1;
	var addressCount = $("#addressCount");
	
	$("#addressCount").load(function(){
		$(this).html("Address" + count);
	});
	
	$("#extraForm").click(function(){
		console.log("Cloning form");
		count++; 
		$("#formdiv").clone().appendTo("#clonePoint");
		addressCount.html("Address" + count);
	});
	
});