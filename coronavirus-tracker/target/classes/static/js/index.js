$(function () {
	var jsonLocstobj=
	
console.log("index.jsss");
	$('[data-toggle="popover"]').popover();
	
	
	$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});

});
	
//	$.ajax({
//		
//        url: "home",
//        contentType: "application/json",
//        dataType: 'json',
//        success: function(data){
//        	alert();
//        	if(data.responseStatus===200)
//            console.log(data);
//        
//        },
//	failure:function(data){
//		alert();
//		console.log(data);
//	}
//    });
	

//});
//
//$('.popover-dismiss').popover({
//	  trigger: 'focus'
//	});
//	
//$('#searchfield').keyup(function(){
//	
//	var key=$(".form-control").val();
//	$.ajax({
//        url: "searchKey?key=" + key,
//        contentType: "application/json",
//        dataType: 'json',
//        success: function(data){
//            console.log(data);
//            
//        }
//    });
//	
//	});


	