package com.harvey.vchat.common;

import com.harvey.common.core.model.PagingInfo;

public class QueryCondition<T> {
	private PagingInfo pagingInfo;
	private T condition;
	private String auditStatus;
	public PagingInfo getPagingInfo() {
		return pagingInfo;
	}
	public T getCondition() {
		return condition;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setPagingInfo(PagingInfo pagingInfo) {
		this.pagingInfo = pagingInfo;
	}
	public void setCondition(T condition) {
		this.condition = condition;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	
}
