package com.deere.dsfj.jdorder.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**This is state domain object. This class holds the state data.*/
@Embeddable
public class State {

	/** country object, will hold the country data.*/
	@Transient
	private Country country;

	/**state code*/
	@Column(name = "CUSTOMER_STATE")
	private String code;

	/** name of the state*/
	@Transient
	private String name;

	public State() {
	}

	/**Constructor, set the country,stateCode and state name in State*/
	public State(Country country, String stateCode, String name) {
		this.country = country;
		this.code = stateCode;
		this.name = name;
	}

	/** getter and setter methods*/
	public final Country getCountry() {
		return country;
	}

	public final void setCountry(Country country) {
		this.country = country;
	}

	public final String getCode() {
		return code;
	}

	public final void setCode(String code) {
		this.code = code;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[State]: " + newLine);
        buf.append(" code = " + (code == null ? "[code is null]" :  "'" + code.toString() + "'") + newLine);
        buf.append(" name = " + (name == null ? "[name is null]" :  "'" + name.toString() + "'") );
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
		if(o != null && o instanceof State){
			if(this.code != null && ((State)o).code != null){
				if(this.code == ((State)o).code){
					result = true;
				}
			}
		}
		return result;
	}
}
