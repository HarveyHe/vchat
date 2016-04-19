package com.harvey.vchat.bas.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.vchat.bas.model.BasSerialNumberModel;
import com.harvey.vchat.bas.service.BasSerialNumberService;
import com.harvey.vchat.common.Constants;

@Service
public class BasSerialNumberServiceImpl extends BaseServiceImpl implements BasSerialNumberService {

	public List<BasSerialNumberModel> saveAll(Collection<BasSerialNumberModel> models) {
		return (List<BasSerialNumberModel>) this.dao.saveAll(models);
	}

	@Override
	public BasSerialNumberModel getBillSerialNumber(String type) {
		 BasSerialNumberModel example = new BasSerialNumberModel();
		 if(type.equals(Constants.billType.BORROW)){
			 example.setType("BORROWING_BILL_NO");
		 }else if(type.equals(Constants.billType.REIMBURSEMENT)){
			 example.setType("REIMBURSEMENT_BILL_NO");
		 }else if(type.equals("BANCH_NO")){
			 example.setType("BANCH_NO");
		 }else{
			 example.setType(type);
		 }
	     List<BasSerialNumberModel> serialNumberList = dao.findByExample(example);
	     if(serialNumberList!=null&& serialNumberList.size()>0){
	    	return serialNumberList.get(0);
	     }
		return null;
	}

	@Override
	public void save(BasSerialNumberModel model) {
		// TODO Auto-generated method stub
		this.dao.save(model);
	}

	@Override
	public void reset() {
		List<BasSerialNumberModel> list=new ArrayList<>();
		list=this.dao.getAll(BasSerialNumberModel.class);
		if(list!=null && list.size()>0){
			for (BasSerialNumberModel basSerialNumberModel : list) {
				basSerialNumberModel.setSerialNo("0000");
				this.save(basSerialNumberModel);
			}
		}
		
	}

	@Override
	public BasSerialNumberModel getBillSerialNumber(String type,
			String companyCode) {
		BasSerialNumberModel example = new BasSerialNumberModel();
		if(type.equals(Constants.billType.BORROW)){
			example.setType("BORROWING_BILL_NO"+companyCode);
		}else if(type.equals(Constants.billType.REIMBURSEMENT)){
			example.setType("REIMBURSEMENT_BILL_NO"+companyCode);
		}
		List<BasSerialNumberModel> serialNumberList = dao.findByExample(example);
		if(serialNumberList!=null&& serialNumberList.size()>0){
			return serialNumberList.get(0);
		}else{
			BasSerialNumberModel newSserialNumber = this.getBillSerialNumber(type, "");
			if(newSserialNumber!=null){
				
				example.setSerialNo(newSserialNumber.getSerialNo());
			}else{
				example.setSerialNo("0000");
			}
			this.dao.save(example);
			return example;
		}
	}

}
