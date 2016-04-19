package com.harvey.vchat.bas.entity;





public class MessageEntity {
	/**
	 * 是否失败
	 */
	private Boolean error;
	/**
	 * 返回信息
	 */
	private String message;
	/**
	 * 返回对象
	 */
	private Object result; 
	
	
	public MessageEntity() {
		super();
	}
	public MessageEntity(Boolean error, String message, Object result) {
		super();
		this.error = error;
		this.message = message;
		this.result = result;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	public static MessageEntity getReturn(Boolean error,String message,Object obj) {
		MessageEntity result = new MessageEntity();
		result.setError(error);
		result.setMessage(message);
		result.setResult(obj);
		return result;
	} 
	public void setReturn(Boolean error,String message,Object result){
		this.result=result;
		this.error=error;
		this.message=message;
	}
}

