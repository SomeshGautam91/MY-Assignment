package com.deere.dsfj.jdorder.form;


public class OrderSearchForm{
    
	private Integer customerNumber;
    private String  orderStatusCode = "";

	public final Integer getCustomerNumber() {
		return customerNumber;
	}

	public final void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}
    
    public final String getOrderStatusCode() {
        return orderStatusCode;
    }
    
    public final void setOrderStatusCode(String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }
 
    public String toString() {
    	String newLine = "\n";
    	StringBuffer strBuffer = new StringBuffer();
    	strBuffer.append("OrderSearchForm : " + newLine);
    	strBuffer.append(" customerNumber = " + (customerNumber == null ? "[customerNumber is null]" : customerNumber.toString()) + newLine);
    	strBuffer.append(" orderStatusCode = " + (orderStatusCode == null ? "[orderStatusCode is null]" : "'" + orderStatusCode.trim() + "'") );
    	return strBuffer.toString();
    }
    

}
