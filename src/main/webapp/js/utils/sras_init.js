$(document).ready(function(){
	$(".approval-hit").on("click",function(){
		if($(this).parent().children(".approval-icon").hasClass("approval-expanded")){
			$(this).parent().children(".approval-icon").removeClass("approval-expanded");
			$(this).parent().children(".approval-icon").addClass("approval-collapsed");
			$(this).parent().children("div").css("display","none");
		}else{
			$(this).parent().children(".approval-icon").addClass("approval-expanded");
			$(this).parent().children(".approval-icon").removeClass("approval-collapsed");
			$(this).parent().children("div").css("display","block");
			
		}
	});
	
	$('.checkbox-to-radio :input[type=checkbox]').click(
			function() {
				if ($(this).is(':checked')) {
					
					$(this).attr('checked', true).siblings(":input[type=checkbox]").attr('checked', false);
					$(this).attr('checked', true).parent().siblings().children(":input[type=checkbox]").attr('checked', false);
				} else {
					
					$(this).attr('checked', false).siblings(":input[type=checkbox]").attr('checked', false);
					$(this).attr('checked', false).parent().siblings().children(":input[type=checkbox]").attr('checked', false);
				}
				
	});
	
	$("#reimDetailTable :input").keyup(function(event){
		if(event.keyCode==13){
			return false;
		}
	});
	$("#borrowApplicationInputForm :input").keyup(function(event){
		if(event.keyCode==13){
			return false;
		}
	});
	$(document).on("keydown",".combo :input",function(event){
		if(event.keyCode==9 || event.keyCode==13){
			var id =$(this).parent().prev().attr("id");
			for(var i=1;i<7;i++){
				var t_id="approver"+i;
				if(id==t_id){
					var n_id=i+1;
					$("#approver"+n_id).next().children("input").focus();
					return false;
				}
			}
			
		}
	});
	$(document).on("keyup",".combo :input",function(event){
		if(event.keyCode==13){
			var id =$(this).parent().prev().attr("id");
			for(var i=1;i<7;i++){
				var t_id="approver"+i;
				if(id==t_id){
					var n_id=i+1;
					$("#approver"+n_id).next().children("input").focus();
					return false;
				}
			}
		}
	});
});
//动态绑定 验证
$.extend($.fn.validatebox.methods, {    
    remove: function(jq, newposition){    
        return jq.each(function(){    
            $(this).removeClass("validatebox-text validatebox-invalid").unbind('focus').unbind('blur');  
        });    
    },  
    reduce: function(jq, newposition){    
        return jq.each(function(){    
           var opt = $(this).data().validatebox.options;  
           $(this).addClass("validatebox-text").validatebox(opt);  
        });    
    }     
}); 
//初始化datagrid
$.extend($.fn.datagrid.defaults,{
	onRowContextMenu:$.noop,
	remoteSort:false,
	pageList:[50,60,70,80,90,100],
	pageSize:50
	
});

//input的回车监听事件
function listenEnter(id,fn){
	$(document).on("keyup",id,function(event){
		if(event.keyCode==13){
			fn();
		}
	});
}
