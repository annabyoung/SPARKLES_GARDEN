$(function(){
	
	var initCount=1;
	var count=1;
	var initAddressCount = $("#initAddressCount");
	var addressCount = $("#addressCount");
	
	$(document).ready(function(){
		$(addressCount).html("Address" + " " + initCount);
	});
	
	$("#extraForm").click(function(){
		count++; 
		$("#formdiv").clone().appendTo("#clonePoint");
		addressCount.html("Address" + " " + count);
	});
	
});