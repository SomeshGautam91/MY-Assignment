package com.deere.dsfj.jdorder.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**This is a Line Item domain object. Since the Items table does not have primary column, 
*  ORDER_NUMBER and ITEM_NUMBER together make a composite key for a table.
*  The LineItem class do not have orderNumber and itemNumber fields 
*  so created an ID class i.e LineItemID that can be used while inserting the records into database. 
*  This domain will map to ITEMS table in database
*/
@Entity
@Table(name="ITEMS" )
public class LineItem  {

	/** instance of the id class for LineItem domain. */
	@EmbeddedId
	private LineItemId lineItemId;
	
	/**instance of Order*/
	@ManyToOne
	@JoinColumn(name="ORDER_NUMBER", insertable=false, updatable=false)
	private Order order = null;
	
	/**instance of Inventory*/
	@ManyToOne
	@JoinColumn(name="ITEM_NUMBER", insertable=false, updatable=false )
    private Inventory inventory = null;
    
	/** quantity/no of units of a line item */
	@Column(name="QUANTITY")
    private int quantity = 1;

    public LineItem() {      
    }

    /** getters and setters of LineItem fields*/
    
    public Inventory getInventory() {
        return inventory; 
    }

    public Order getOrder() {
        return order;
    }
      
    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return getInventory().getDescription();
    }

    /**extended price = quantity x price per unit */
    public Float getExtendedPrice() {
        return (getQuantity() * getPricePerUnit().floatValue());
        //return extendedP
    }

    public Float getPricePerUnit() {
        return getInventory().getPrice();
    }


    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setOrder(Order newOrder) {
        order = newOrder;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }
	
	public LineItemId getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(LineItemId lineItemId) {
		this.lineItemId = lineItemId;
	}
	
	public int hashCode(){
		if(lineItemId != null){
			return lineItemId.hashCode();			
		}else{
			return super.hashCode();
		}
	}

	public boolean equals(Object o){
		boolean result = false;
		if(o != null && o instanceof LineItem){
			if(this.lineItemId != null && ((LineItem)o).lineItemId != null){
				if(this.lineItemId.equals(((LineItem)o).lineItemId)){
					result = true;
				}
			}
		}
		return result;
	}

    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[LineItem]: " + newLine);
        buf.append(" orderNumber = " + (order == null ? "[order is null]" : (order.getOrderNumber() == null ? "[orderNumber is null]" :"'" + order.getOrderNumber().toString() + "'")) + newLine );
        buf.append(" itemNumber = " + (inventory == null ? "[inventory is null]" : (inventory.getItemNumber() == null ? "[itemNumber is null]" :"'" + inventory.getItemNumber().toString() + "'")) + newLine );
        buf.append(" quantity = " + String.valueOf(quantity)+ newLine);
        return buf.toString();
    }
}