package com.harvey.vchat.bas.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.vchat.bas.model.BasCodeDefModel;
import com.harvey.vchat.bas.query.CodeDefSelectCodeQueryCondition;
import com.harvey.vchat.bas.query.CodeDefSelectCodeQueryItem;
import com.harvey.vchat.bas.service.BasCodeDefService;

@Service
public class BasCodeDefServiceImpl extends BaseServiceImpl implements BasCodeDefService {
	
	@Override
	public List<BasCodeDefModel> saveAll(Collection<BasCodeDefModel> models) {
//		BasCodeDefModel[] array = models.toArray(new BasCodeDefModel[models.size()]);
//		if (array != null && array.length > 0) {
//			List<BasCodeDefModel> deleteDefs = new ArrayList<BasCodeDefModel>();
//			String basCodeTypeUuid = array[0].getBasCodeTypeUuid();
//			BasCodeDefModel example = new BasCodeDefModel();
//			example.setBasCodeTypeUuid(basCodeTypeUuid);
//			List<BasCodeDefModel> examples = this.dao.findByExample(example);
//			if(ListUtils.isNotEmpty(examples)) {
//				for (BasCodeDefModel existsTemp : examples) {
//					boolean tag = false;
//					for (BasCodeDefModel newTemp : models) {
//						if (existsTemp.getBasCodeDefUuid().equals(newTemp.getBasCodeDefUuid())) {
//							tag = true;
//						}
//					}
//					if (!tag) {
//						deleteDefs.add(existsTemp);
//					}
//				}
//			}
//			if (ListUtils.isNotEmpty(deleteDefs)) {
//				this.dao.remove(deleteDefs);
//			}
//		}
		return (List<BasCodeDefModel>) this.dao.saveAll(models);
	}

	@Override
	public List<CodeDefSelectCodeQueryItem> queryCodeDefByTypeAndValue (String codeType, String codeValue) {
		CodeDefSelectCodeQueryCondition condition = new CodeDefSelectCodeQueryCondition();
		condition.setCodeType(codeType);;
		condition.setCodeValue(codeValue);
		
		return this.dao.query(condition , CodeDefSelectCodeQueryItem.class);
	}
}
