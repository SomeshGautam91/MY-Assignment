package com.deere.dsfj.jdorder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** This is an Order domain object.This domain will map to ORDERS table in database */
@Entity    
@Table(name="ORDERS" )
public class Order {
     
	/**order number of order*/
    @Id
    @Column(name="ORDER_NUMBER")
    private Integer orderNumber = null;

    /**customer object*/
    @ManyToOne
    @JoinColumn(name="CUSTOMER_NUMBER", updatable=false )
    private Customer customer = null;

    /**description of the order*/
    @Column(name="DESCRIPTION")
    private String description = null;

    /**dueDate of the order*/
    @Column(name="DUE_DATE")
    private String dueDate = null;

    /**intance of embeddeble OrderStatus object. This object will store the order status data*/
    @Embedded
    private OrderStatus orderStatus = null;
    
    /**ordererd date of the order*/
    @Column(name="ORDERED_DATE", updatable=false)
    private String orderedDate = null;
    
    @Column(name="LOCK_ID", updatable=false)
    private String lockId = null;
   
    @Column(name="LOCK_IND", updatable=false)
    private String lockInd = null;
    
    // need to change all date field from string to data or gregorian calendar
    @Column(name="LOCK_TIME", updatable=false)
    private String lockDateTime = null;

    /**This arraylist will be collection of lineItems*/
    @OneToMany(targetEntity=LineItem.class , mappedBy="order", fetch=FetchType.LAZY, cascade={CascadeType.ALL}, orphanRemoval=true)  
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    
    public Order(){
    }
    
    /**getters and setters for Order fields*/
    
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
        if(lineItems != null){
  	      for(LineItem lineItem : lineItems ){      
  	    	  if(lineItem != null){
  	    		  LineItemId lineItemId = lineItem.getLineItemId();
  	    		  if(lineItemId != null){
  	    			  lineItemId.setOrderNumber(orderNumber);
  	    		  }
  	    	  }
  	      }
        }

        
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


    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
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
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public List<LineItem> getLineItems() {
        return lineItems;
    }


    public void setLineItems(List<LineItem> lineItems) {
    	/*
        for(LineItem lineItem : lineItems){
            lineItem.setOrder(this);
        }
        */
        this.lineItems = lineItems;
    }


    public String getLockDateTime() {
        return lockDateTime;
    }


    public void setLockDateTime(String lockDateTime) {
        this.lockDateTime = lockDateTime;
    }

    public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**This method calculates total extended price. This method iterates through lineitem list, fetches each line item and adds the extended price for each line item*/
	public float getTotal() {
        Iterator<LineItem> lineItems = getLineItems().iterator();
        float total = 0;
        LineItem lineItem = null;
        while (lineItems.hasNext()) {
            lineItem = (LineItem) lineItems.next();
            total = total + lineItem.getExtendedPrice();
        }
        return total;
    }
    
	public int hashCode(){
		if(orderNumber != null){
			return orderNumber.hashCode();			
		}else{
			return super.hashCode();
		}
	}

	public boolean equals(Object o){
		boolean result = false;
		if(o != null && o instanceof Order){
			if(this.orderNumber != null && ((Order)o).orderNumber != null){
				if(this.orderNumber == ((Order)o).orderNumber){
					result = true;
				}
			}
		}
		return result;
	}

    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();

        buf.append("[Order]: " + newLine);
        buf.append("orderNumber = " + (orderNumber == null ? "[null]" : orderNumber.toString()) + newLine);
        String customerNumber;
        if (getCustomer() == null) {
            customerNumber = "[customer was null]";
        } else if (getCustomer().getNumber() == null) {
            customerNumber = "[null]";
        } else {
            customerNumber = getCustomer().getNumber().toString();
        }
        buf.append(" customer.number = " + customerNumber + newLine);
        buf.append(" description = " + (description == null ? "[description is null]" : "'" + description.trim() + "'") + newLine);
        buf.append(" dueDate = " + (dueDate == null ? "[dueDate is null]" : dueDate) + newLine);
        buf.append(" orderedDate = " + (orderedDate == null ? "[ordered date is null]" : orderedDate) + newLine);
        buf.append(" orderStatusCode = " + (orderStatus == null ? "[orderStatus is null]" : (orderStatus.getCode() == null ? "[orderStatusCode is null]" :"'" + orderStatus.getCode().toString() + "'")) + newLine );
        buf.append(" orderStatusDescription = " + (orderStatus == null ? "[orderStatus is null]" : (orderStatus.getDescription() == null ? "[orderStatusDescription is null]" :"'" + orderStatus.getDescription().toString() + "'")) + newLine );
        buf.append(" lockInd = " + (lockInd == null ? "[lockInd is null]" : "'" + lockInd.trim() + "'") + newLine);
        buf.append(" lockID = " + (lockId == null ? "[null]" : "'" + lockId.trim() + "'") + newLine);
        buf.append(" lockDateTime = " + (lockDateTime == null ? "[null]" : "'" + lockDateTime.trim() + "'") + newLine);

        return buf.toString();
    }

}