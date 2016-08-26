$(function(){
	
});


$("#theBody").ready(function() {
	
	$("#extraForm").click(function(){
		$("#formdiv").clone().appendTo("#clonePoint");
		addressCount.html("Address" + count);
	});
	
	
});