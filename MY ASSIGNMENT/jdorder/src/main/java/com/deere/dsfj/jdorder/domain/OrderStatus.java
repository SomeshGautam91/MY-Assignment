package com.deere.dsfj.jdorder.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**This is a OrderStatus domain object.This is an embeddable class*/
@Embeddable
public class OrderStatus {

	public OrderStatus(){
	}
	
    public OrderStatus(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
    
    /**Order Status Code*/
	@Column(name="ORDER_STATUS")
    private String code = null;
    
	/**Order Status Description.*/
    @Transient
    private String description = null;

    /** getter and setter methods for code and description*/
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[OrderStatus]: " + newLine);
        buf.append(" code = " + (code == null ? "[code is null]" :  "'" + code.toString() + "'") + newLine);
        buf.append(" description = " + (description == null ? "[description is null]" :  "'" + description.toString() + "'") );
        return buf.toString();
    }
    
	public int hashCode(){
		if(code != null){
			return code.hashCode();			
		}else{
			return super.hashCode();
		}
	}

	public boolean equals(Object o){
		boolean result = false;
		if(o != null && o instanceof OrderStatus){
			if(this.code != null && ((OrderStatus)o).code != null){
				if(this.code == ((OrderStatus)o).code){
					result = true;
				}
			}
		}
		return result;
	}
	
}