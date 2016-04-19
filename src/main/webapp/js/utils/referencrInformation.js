//借款审批授权参考窗口
function openReferenceBorrowingAuthorizationDiv(){
	$('#referenceBorrowingAuthorizationDiv').dialog('open');
	loadReferenceCommonAuthorizationDiv("A","referenceBorrowingAuthorization");
}
//报销审批授权参考窗口
function openReferenceReimbursementAuthorizationDiv(){
	$('#referenceReimbursementAuthorizationDiv').dialog('open');
	loadReferenceCommonAuthorizationDiv("R","referenceReimbursementAuthorization");
}
//加载审批授权数据
function loadReferenceCommonAuthorizationDiv(approveType,appendId){
	$.post($url('/rest/docApproverRest/getAllDocApproverByGroup.json'),{"approveType":approveType},function(data) {
			$("#referenceBorrowingAuthorization").empty();
			$("#"+appendId).empty();
			if(data && data.length > 0) {
				
//				var newSortDatas = new Array();
				var newYictDatas = new Array();
				var newWp1Datas = new Array();
				var newPmlDatas = new Array();
				var newOrtherDatas = new Array();
				$.each(data,function(index,ele) {
					if(ele.companyShortName == 'YICT') {
						newYictDatas.push(ele);
					}else if(ele.companyShortName == 'WP1') {
						newWp1Datas.push(ele);
					}else if(ele.companyShortName == 'PML') {
						newPmlDatas.push(ele);
					}else if(ele.companyShortName == 'P3A' || ele.companyShortName == 'P3B' ||  ele.companyShortName == 'WP2') {
					}else {
						newOrtherDatas.push(ele);
					}
				});
				showReferenceCommonAuthorizationDiv(newYictDatas,"YICT",appendId);
				showReferenceCommonAuthorizationDiv(newWp1Datas,'WP1',appendId);
				showReferenceCommonAuthorizationDiv(newPmlDatas,'PML',appendId);
				showReferenceCommonAuthorizationDiv(newOrtherDatas,'OTHER',appendId);
				
				//第一行数据
//				createTrHead(data[0].companyName,appendId);
//				if(data.length==1){
//					createTrBody(data[0].moneyRmb,data[0].moneyHkd,appendId,data[0].userName);
//					createTrFooter(data[0].moneyRmb,data[0].moneyHkd,appendId);
//				}else{
//					for(var i=1;i<data.length;i++){
//    					createTrBody(data[i-1].moneyRmb,data[i-1].moneyHkd,appendId,data[i-1].userName);
//						if(data[i].companyName!=data[i-1].companyName){
//	    					createTrFooter(data[i-1].moneyRmb,data[i-1].moneyHkd,appendId);
//		    				createTrHead(data[i].companyName,appendId);
//						}		
//    				}
//					//最后一行
//					createTrBody(data[data.length-1].moneyRmb,data[data.length-1].moneyHkd,appendId,data[data.length-1].userName);
//					createTrFooter(data[data.length-1].moneyRmb,data[data.length-1].moneyHkd,appendId);
//				}
				
			}
		},"json");
}
//创建借款审批授权公司名称
function createTrHead(companyName,id){
	var s1="<tr>";
	s1+="<td  title='' width='300px' style='border:solid 1px #000;width:300px;'><span style='font-weight: 700;'>"+companyName+"</span></td>";
	s1+="<td title='' width='350px'  style='border:solid 1px #000;width:350px;'></td>";
	s1+="</tr>";
	$("#"+id).append($(s1));
}
//创建公司借款审批内容
function createTrBody(moneyRmb,moneyHkd,id,userName){
		var s1="<tr>";
		s1+="<td  title='' width='300px' style='border:solid 1px #000;width:300px;'>RMB&nbsp;"+moneyRmb+"&nbsp;/HKD&nbsp;"+moneyHkd+"&nbsp;以下</td>";
		s1+="<td title='' width='350px' style='border:solid 1px #000;width:350px;'>"+userName+"</td>";
		s1+="</tr>";
		$("#"+id).append($(s1));
}
//创建借款审批授权内容表尾
function createTrFooter(moneyRmb,moneyHkd,id){
	var s1="<tr>";
	s1+="<td  title='' width='300px' style='border:solid 1px #000;width:300px;'>超过RMB&nbsp;"+moneyRmb+"&nbsp;/HKD&nbsp;"+moneyHkd+"</td>";
	s1+="<td title='' width='350px' style='border:solid 1px #000;width:350px;'>请于财务及法律出纳组联系，联系电话：6510</td>";
	s1+="</tr>";
	$("#"+id).append($(s1));
}

function showReferenceCommonAuthorizationDiv(authArray,companyShortName,appendId){
	if(authArray.length>0){
		if(companyShortName == "YICT"){
			createTrHead("盐田国际及盐田三期国际",appendId);
		}else if(companyShortName == "WP1"){
			createTrHead("深圳盐田西港区码头有限公司",appendId);
		}else if(companyShortName == "PML"){
			createTrHead("深圳平盐海铁联运有限公司",appendId);
		}else{
			createTrHead(authArray[0].companyName,appendId);
		}
		for(var i=0;i<authArray.length;i++){
			createTrBody(authArray[i].moneyRmb,authArray[i].moneyHkd,appendId,authArray[i].userName);
		}
		createTrFooter(authArray[authArray.length-1].moneyRmb,authArray[authArray.length-1].moneyHkd,appendId);
	}
}



//参考政策
function openReferenceRelevantPolicyDiv(){
	$('#referenceRelevantPolicyDiv').dialog('open');
	loadReferenceRelevantPolicyDiv();
}
//获取并加载参考政策数据
function loadReferenceRelevantPolicyDiv(){
	$.postJSON($url('/rest/paramRelevantLinksRest/query.json'), {"pagingInfo":null,"condition":null}, function(data) {
		if(data) {
			$("#referenceRelevantPolicy").empty();
			createReferenceRelevantPolicy(data.dataList,"referenceRelevantPolicy");
		} 
      },"json");
}
//创建政策行
function createReferenceRelevantPolicy(relevantPolicies,id){
		var s="<ul>";
		for(var i=0;i<relevantPolicies.length;i++){
			s+="<li style='padding:5px'><a target='_blank' href='"+relevantPolicies[i].link+"'>"+relevantPolicies[i].fileName+"</a></li>";
		}
		s+="</ul>";
		$("#"+id).append($(s));
}

	
//常用预算科目
function openReferenceBudgetSubjectDiv(){
	$('#referenceBudgetSubjectDiv').dialog('open');
	loadReferenceBudgetSubjectDiv();
}
function loadReferenceBudgetSubjectDiv(){
	$.post($url('/rest/budgetSubjectRest/getAllRefCommonBudgetObject.json'),null,function(data) {
		if(data && data.length > 0) {
			$("#referenceBudgetSubjectGridResult").datagrid("loadData",{
				rows : data
			});
		} else {
			$("#referenceBudgetSubjectGridResult").datagrid("loadData",{
				rows : []
			});
		}
	},"json");
}

//参考汇率窗口
function openReferenceRateDiv(){
	$('#referenceRateDiv').dialog('open');
	loadReferenceRateDiv();
}
//参考汇率数据
function loadReferenceRateDiv(){
	$.post($url('/rest/referenceRateRest/getAllRateType.json'),null,function(data) {
		if(data && data.length > 0) {
			$("#referenceRateGridResult").datagrid("loadData",{
				rows : data
			});
		} else {
			$("#gridResult").datagrid("loadData",{
				rows : []
			});
		}
	},"json");
}
	