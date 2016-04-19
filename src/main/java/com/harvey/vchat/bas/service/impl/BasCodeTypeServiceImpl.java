package com.harvey.vchat.bas.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.vchat.bas.model.BasCodeTypeModel;
import com.harvey.vchat.bas.service.BasCodeTypeService;

@Service
public class BasCodeTypeServiceImpl extends BaseServiceImpl implements BasCodeTypeService {
	
	@Override
	public List<BasCodeTypeModel> saveAll(Collection<BasCodeTypeModel> models){
		return (List<BasCodeTypeModel>) this.dao.saveAll(models);
	}

}
