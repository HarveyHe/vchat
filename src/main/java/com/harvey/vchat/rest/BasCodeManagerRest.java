package com.harvey.vchat.rest;

import java.util.Collection;
import java.util.List;

import com.gsst.eaf.core.service.BaseRest;
import com.harvey.vchat.bas.model.BasCodeDefModel;
import com.harvey.vchat.bas.model.BasCodeTypeModel;
import com.harvey.vchat.bas.query.CodeDefSelectCodeQueryItem;

public interface BasCodeManagerRest extends BaseRest {
	
	List<BasCodeTypeModel> saveAllCodeType(Collection<BasCodeTypeModel> models);
	

	List<BasCodeDefModel> saveAllCodeDef(Collection<BasCodeDefModel> models);
	
	List<CodeDefSelectCodeQueryItem> queryCodeDefByTypeAndValue(String codeType, String codeValue);

}
