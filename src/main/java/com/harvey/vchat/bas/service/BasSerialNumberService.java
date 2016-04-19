package com.harvey.vchat.bas.service;

import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.model.BasSerialNumberModel;

public interface BasSerialNumberService extends BaseService {

	List<BasSerialNumberModel> saveAll(Collection<BasSerialNumberModel> models);
	
	BasSerialNumberModel getBillSerialNumber(String type);
	void save(BasSerialNumberModel model);
	
	/**
	 * 根据 type类型 （借款：O ,报销E) 公司代码 
	 * @param type
	 * @param companyCode
	 * @return
	 */
	BasSerialNumberModel getBillSerialNumber(String type,String companyCode);
	/**
	 * 重置流水号
	 */
	void reset();

}
