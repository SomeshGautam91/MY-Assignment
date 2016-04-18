package com.deere.dsfj.jdorder.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**This class is Id class for LineItem domain.Since the ITEMS table don't have a primary key, 
 * ORDER_NUMBER and ITEM_NUMBER columns form the composite key. For this we have created a id class. 
 * This class will contain orderNumber and itemNumber Integer fields which together will form the id class. 
 *  */
@Embeddable
public class LineItemId implements Serializable{
	
	private static final long serialVersionUID = -4567837915060788847L;
	
	@Column(name="ORDER_NUMBER", updatable=false)
	private Integer orderNumber;
	@Column(name="ITEM_NUMBER", updatable=false)
	private Integer itemNumber;
	
	public LineItemId() {
		
	}
	public LineItemId(Integer orderNumber, Integer itemNumber) {
		this.orderNumber = orderNumber;
		this.itemNumber = itemNumber;
	}
	

    public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public boolean equals(Object o){
		return((o instanceof LineItemId) && ( orderNumber==(((LineItemId)o).orderNumber)) && (itemNumber==(((LineItemId)o).itemNumber)));
	}
	
	public int hashCode(){
		return orderNumber.hashCode() + itemNumber.hashCode();
	}

}
