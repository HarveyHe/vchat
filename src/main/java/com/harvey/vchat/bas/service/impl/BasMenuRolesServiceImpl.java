package com.harvey.vchat.bas.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import com.harvey.common.core.bean.TransactionTemplateBean;
import com.harvey.common.core.model.DynamicModelClass;
import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.common.core.spring.security.metadata.RoleUrlMetadataSource;
import com.harvey.vchat.bas.query.MenuRolesQueryItem;
import com.harvey.vchat.bas.service.BasMenuRolesService;

@Service
public class BasMenuRolesServiceImpl extends BaseServiceImpl implements BasMenuRolesService {

    @Resource
    private RoleUrlMetadataSource metadataSource;
    
    @Override
    public void saveMenuRoles(String roleId, Collection<MenuRolesQueryItem> menuRoles) {
        for(MenuRolesQueryItem item : menuRoles){
            if(Boolean.TRUE.equals(item.getChecked())){
                this.sqlDao.bulkUpdate("insert into bas_menu_roles(role_id, menu_id) values (?, ?)", roleId,item.getMenuUuid());
            }else{
                this.sqlDao.bulkUpdate("delete bas_menu_roles where role_id = ? and menu_id = ?", roleId,item.getMenuUuid());
            }
        }
        initialUrlRolesMetaData();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new TransactionTemplateBean().execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus arg0) {
                initialUrlRolesMetaData();
                return null;
            }
        });
    }
    
    private void initialUrlRolesMetaData(){
        String sql = "select r.role_id as role,m.menu_item_url as url from bas_menu_roles mr,bas_menu_item m,bas_roles r "+
                     "where mr.menu_id = m.sys_menu_item_uuid and m.status='ACTIVE' and r.role_id = mr.role_id";
        List<DynamicModelClass> items = this.sqlDao.query(sql);
        Map<String,Set<String>> metaData = new HashMap<String, Set<String>>();
        for(DynamicModelClass item : items){
            Set<String> roles = metaData.get(item.get("url"));
            if(roles == null){
                roles = new HashSet<String>();
                metaData.put(item.get("url")+"", roles);
            }
            roles.add(item.get("role")+"");
        }
        metadataSource.setUrlsRoles(metaData);
    }

}
