package com.deere.dsfj.jdorder.form;

/**This class is will hold the search criteria customer has entered for Customer search operations*/
public class CustomerSearchForm{
	
	
    /**This variable will hold the customer number*/
	private int number = 0;
	
	/**This variable will hold the customer name*/
    private String name = null; 
	
    private String searchNameOrNumber;
    
	public String getSearchNameOrNumber() {
		return searchNameOrNumber;
	}
	public void setSearchNameOrNumber(String searchNameOrNumber) {
		this.searchNameOrNumber = searchNameOrNumber;
	}

    /**Getters and setters for CustomerSearchCriteria fields*/
    
    public final int getNumber() {
        return number;
    }
    public final void setNumber(int number) {
        this.number = number;
    }
    public final String getName() {
        return name;
    }
    public final void setName(String name) {
        this.name = name;
    }
    
    public void checkAndAssignValues(){
        try{
            this.number = Integer.parseInt(this.searchNameOrNumber);
        }catch(NumberFormatException numEx){
            this.name = searchNameOrNumber;
        }
    }    
    public String toString() {
    	String newLine = "\n";
    	StringBuffer strBuffer = new StringBuffer();
    	strBuffer.append("CustomerSearchForm : " + newLine);
    	strBuffer.append(" number = " + String.valueOf(number)+ newLine);
    	strBuffer.append(" name = " + (name == null ? "[name is null]" : "'" + name.trim() + "'") );
    	return strBuffer.toString();
    }
}
