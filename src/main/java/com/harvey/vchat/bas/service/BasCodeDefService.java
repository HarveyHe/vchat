package com.harvey.vchat.bas.service;

import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.model.BasCodeDefModel;
import com.harvey.vchat.bas.query.CodeDefSelectCodeQueryItem;

public interface BasCodeDefService extends BaseService {

	List<BasCodeDefModel> saveAll(Collection<BasCodeDefModel> models);
	
	List<CodeDefSelectCodeQueryItem> queryCodeDefByTypeAndValue(String codeType, String codeValue);
}
