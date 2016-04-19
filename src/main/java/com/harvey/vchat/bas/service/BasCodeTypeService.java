package com.harvey.vchat.bas.service;

import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.model.BasCodeTypeModel;

public interface BasCodeTypeService extends BaseService {

	List<BasCodeTypeModel> saveAll(Collection<BasCodeTypeModel> models);
}
