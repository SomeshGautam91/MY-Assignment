package com.deere.dsfj.jdorder.domain;

import java.util.List;
/**This is a Country domain object. This class will hold the country data*/
public class Country  {

	/** country code */	
    private String code;
    
    /**name of the country*/
    private String name;
    
    /**list of the states*/
    private List<State> states;

   /** blank constructor is required by dozer */ 
   public Country(){
	   
   }
    
   /** Constructor, set the country code and country name in class variables*/ 
   public Country(String code, String name){
        this.code = code;
        this.name = name;
    }
    
   /**getter and setters for class variables*/
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

	public final List<State> getStates() {
		return states;
	}

	public final void setStates(List<State> states) {
		this.states = states;
	}

    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[Country]: " + newLine);
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
		if(o != null && o instanceof Country){
			if(this.code != null && ((Country)o).code != null){
				if(this.code == ((Country)o).code){
					result = true;
				}
			}
		}
		return result;
	}

}
