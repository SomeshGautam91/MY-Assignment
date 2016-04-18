package com.deere.dsfj.jdorder.form;

import java.util.Iterator;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**This is an input form for Order. This form will be populated only while create and edit order functionality
 * This form will not be used for display purpose*/
public class OrderForm{

	/** order number of order*/
    private Integer orderNumber = null;
    
    /** description of order*/
    private String description = null;
    
    /**due date of the order*/
    private String dueDate = null;
    
    /**date when order was place*/
    private String orderedDate = null;
    
    /** id of the user who is editing the order*/
    private String lockId = "";
    
    private String lockInd = null;
    private String lockDateTime = null;

    /** order status code*/
    private String orderStatus = "";
    
    /** description of order status*/
    private String orderStatusDescription = null;

	private Integer customerNumber = null;
    
    /** This list will hold order line items*/
    private List<LineItemForm> lineItemFormList = null;
   

	/** getters and setters of the properties*/
    
    public String getLockDateTime() {
		return lockDateTime;
	}

	public void setLockDateTime(String lockDateTime) {
		this.lockDateTime = lockDateTime;
	}
 
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {  
        this.orderNumber = orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    public String getLockInd() {
        return lockInd;
    }

    public void setLockInd(String lockInd) {
        this.lockInd = lockInd;
    }

    
	public  Integer getCustomerNumber() {
		return customerNumber;
	}

	public  void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}


	 
    public final List<LineItemForm> getLineItemFormList() {
		return lineItemFormList;
	}

	public final void setLineItemFormList(List<LineItemForm> lineItemFormList) {
		this.lineItemFormList = lineItemFormList;
	}
	
    /*public String getLockDateTime() {
        return lockDateTime;
    }

    public void setLockDateTime(String lockDateTime) {
        this.lockDateTime = lockDateTime;
    }*/
    
    
    /** this method will calculate and return the total price of all line items */
    public Float getTotal() {
    	//get the line items
        Iterator<LineItemForm> lineItemFormIterator = getLineItemFormList().iterator();
        float total = 0;
        LineItemForm lineItemBean = null;
        //add the price of each line item 
        while (lineItemFormIterator.hasNext()) {
            lineItemBean = (LineItemForm) lineItemFormIterator.next();
            total = total + lineItemBean.getExtendedPrice();
        }
        return total;
    }
  
	/** this method is used for validating order form.*/
    public void validate(Errors errors){
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "descriptionEmptyOrWhiteSpace");
        if (description != null && ((description.length()) < 1 || (description.length()) > 50)) {
          errors.rejectValue("description","descriptionlength");
        }  

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dueDate", "dueDateEmptyOrWhiteSpace");
  
    }
    
    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();

        buf.append("[OrderForm]: " + newLine);
        buf.append("orderNumber = " + (orderNumber == null ? "[null]" : orderNumber.toString()) + newLine);
        buf.append(" customerNumber = " + (customerNumber == null ? "[null]" : customerNumber.toString()) + newLine);
        buf.append(" description = " + (description == null ? "[description is null]" : "'" + description.trim() + "'") + newLine);
        buf.append(" dueDate = " + (dueDate == null ? "[dueDate is null]" : dueDate) + newLine);
        buf.append(" orderedDate = " + (orderedDate == null ? "[ordered date is null]" : orderedDate) + newLine);
        buf.append(" orderStatus = " + (orderStatus == null ? "[orderStatus is null]" : "'" + orderStatus.trim() + "'") + newLine);
        buf.append(" orderStatusDescription = " + (orderStatusDescription == null ? "[orderStatusDescription is null]" : "'" + orderStatusDescription.trim() + "'") + newLine);
        buf.append(" lockInd = " + (lockInd == null ? "[lockInd is null]" : "'" + lockInd.trim() + "'") + newLine);
        buf.append(" lockID = " + (lockId == null ? "[null]" : "'" + lockId.trim() + "'") + newLine);
        buf.append(" lockDateTime = " + (lockDateTime == null ? "[null]" : "'" + lockDateTime.trim() + "'") );

        return buf.toString();
    }
    

}
