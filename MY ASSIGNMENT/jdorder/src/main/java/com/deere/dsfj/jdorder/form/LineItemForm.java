package com.deere.dsfj.jdorder.form;

/** This is input form for Line Items. This form is will be populated by Create Order/Edit Order functionality. This form is not used while displaying the line items*/
public class LineItemForm{

	/** order number of the order to which the line item belongs*/
    private Integer orderNumber;
    
    /**item number of line item*/
    private Integer itemNumber;
    
    /**price of the line item*/
    private Float price;
    
    /**description of the line item */
    private String description;
    
    /** quantity of the line item*/
    private Integer quantity = 1;
    

    /** flag to indicate that line item should be deleted*/
	private boolean deleted = false;
	
	/** flag to indicate that line item is new*/
	private boolean inserted = false;
	
	/** flag to indicate that line item should be updated*/
	private boolean updated = true;

	/**getters and setters for the properties*/
    
    public Integer getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Integer getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** total price of line item,quantity x price*/
    public Float getExtendedPrice() {
        return (getQuantity() * getPrice().floatValue());
        //return extendedPrice;
    }
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isInserted() {
		return inserted;
	}
	public void setInserted(boolean inserted) {
		this.inserted = inserted;
	}
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[LineItemForm]: " + newLine);
        buf.append(" orderNumber = " + (orderNumber == null ? "[null]" : orderNumber.toString()) + newLine);
        buf.append(" itemNumber = " + (itemNumber == null ? "[null]" : itemNumber.toString()) + newLine);
        buf.append(" quantity = " + quantity.toString() + newLine);
        buf.append(" description = " + (description == null ? "[null]" :"'" + description.toString() + "'") + newLine);
        buf.append(" price = " + price.toString());
        return buf.toString();
    }
    
}
