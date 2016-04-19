var Common = {

	//EasyUI用DataGrid用日期格式化
	DateTimeSSFormatter: function (value, rec, index) {
		if (value == undefined) {
			return "";
		}
		value = value.replace(/-/g,"/");
		value = value.replace(/T/g," ");
		value = value.replace(/.000/g,"");
		var date = new Date(value );
		return date.format("yyyy-MM-dd HH:mm:ss");
	},
    //EasyUI用DataGrid用日期格式化
    DateTimeFormatter: function (value, rec, index) {
        if (value == undefined) {
            return "";
        }
        	value = value.replace(/-/g,"/");
        	value = value.replace(/T/g," ");
        	value = value.replace(/.000/g,"");
        	var date = new Date(value );
        	return date.format("yyyy-MM-dd HH:mm");
    },

    //EasyUI用DataGrid用日期格式化
    DateFormatter: function (value, rec, index) {
        if (value == undefined) {
            return "";
        }
        	value = value.replace(/-/g,"/");
        	value = value.replace(/T/g," ");
        	value = value.replace(/.000/g,"");
        	var date = new Date(value );
        	return date.format("yyyy-MM-dd");
    },
    AmountFormatter:function(value,row,index){
    	var amount = (Math.round(value*100))/100;  
    	var amount_s=amount.toString();
    	var pos_decimal = amount_s.indexOf('.');  
    	if(pos_decimal<0){
    		pos_decimal=amount_s.length;
    		amount_s+=".";
    	}
    	while(amount_s.length<=pos_decimal+2){
    		amount_s+="0";
    	} 
    	return amount_s;
    },
    borrowStatus:function (value){
    	if(value=="DRAFT"){
    		return "草稿";
    	}else if(value=="DEPT_APPROVE"){
    		return "用户部门批准";
    	}else if(value=="PENDING"){
    		return "草稿";
    	}else if(value=="REJECT"){ 
    		return "拒绝";
    	}else{
    		return value;
    	}
    }
};

