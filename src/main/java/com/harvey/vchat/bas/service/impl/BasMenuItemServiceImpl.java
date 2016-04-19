package com.harvey.vchat.bas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.vchat.bas.model.BasMenuItemModel;
import com.harvey.vchat.bas.service.BasMenuItemService;
import com.harvey.vchat.common.Constants;

@Service
public class BasMenuItemServiceImpl extends BaseServiceImpl implements BasMenuItemService {

    @Override
    public BasMenuItemModel saveMenuItem(BasMenuItemModel model) {
        return this.dao.save(model);
    }

    @Override
    public boolean removeMenuItem(String itemId) {
        BasMenuItemModel model = this.dao.get(BasMenuItemModel.class, itemId);
        if(model == null){
            return false;
        }
        this.dao.remove(model);
        return true;
    }


	@Override
	public BasMenuItemModel getByUrl(BasMenuItemModel model) {
		if (model != null && model.getMenuItemUrl() != null) {
			List<BasMenuItemModel> models = this.dao.findByExample(model);
			if (models != null && models.size() > 0) {
				return models.get(0);
			} else {
				String name = Constants.menuItem.mapItem.get(model.getMenuItemUrl());
				if (name != null ) {
					BasMenuItemModel newModel = new BasMenuItemModel();
					newModel.setMenuItemUrl(model.getMenuItemUrl());
					newModel.setMenuItemName(name);
					return newModel;
				}
			}
		}
		return null;
	}
}
