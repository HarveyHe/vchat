package com.harvey.vchat.rest.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.harvey.vchat.bas.model.BasCodeDefModel;
import com.harvey.vchat.bas.model.BasCodeTypeModel;
import com.harvey.vchat.bas.query.CodeDefSelectCodeQueryItem;
import com.harvey.vchat.bas.service.BasCodeDefService;
import com.harvey.vchat.bas.service.BasCodeTypeService;
import com.harvey.vchat.rest.BasCodeManagerRest;
@Component
public class BasCodeManagerRestImpl implements BasCodeManagerRest {

	@Resource
	BasCodeDefService  basCodeDefService;
	@Resource
	BasCodeTypeService  basCodeTypeService;
	@Override
	public List<BasCodeTypeModel> saveAllCodeType(@RequestBody Collection<BasCodeTypeModel> models) {
		// TODO Auto-generated method stub
		return this.basCodeTypeService.saveAll(models);
	}

	@Override
	public List<BasCodeDefModel> saveAllCodeDef(@RequestBody Collection<BasCodeDefModel> models) {
		// TODO Auto-generated method stub
		return this.basCodeDefService.saveAll(models);
	}

	@Override
	public List<CodeDefSelectCodeQueryItem> queryCodeDefByTypeAndValue(
			String codeType, String codeValue) {
		// TODO Auto-generated method stub
		return this.basCodeDefService.queryCodeDefByTypeAndValue(codeType, codeValue);
	}

}
