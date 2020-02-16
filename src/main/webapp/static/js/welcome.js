$(function(){
	//Favorite.init("#tab-favorite .ibox-content");
	
	$("#tab-favorite .ibox-tools a").click(function(){
		$("#tab-favorite .tab-favorite-close").each(function(i,o){
			if($(this).is(":visible")){
				$(this).hide();	
			}else{
				$(this).show();
			}
		})
	});
})