package com.deere.dsfj.jdorder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**This is a Inventory domain object. This class will hold the inventory data.
 * This domain will map to INVENTORY table in database*/
@Entity    
@Table(name="INVENTORY" )
public class Inventory{

	/** item number of the item*/
	@Id
    @Column(name="ITEM_NUMBER")
    private Integer itemNumber = null;

	/** description of the inventory item*/
	@Column(name="DESCRIPTION")
	private String description = null;
    
	/**price of the inventory item*/
	@Column(name="PRICE")
	private Float price = null;
	
    /** getters and setters of Inventory fields*/
	public Integer getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[Inventory]: " + newLine);
        buf.append(" itemNumber = " + (itemNumber == null ? "[itemNumber is null]" : itemNumber.toString()) + newLine);
        buf.append(" description = " + (description == null ? "[description is null]" : "'" + description.trim() + "'") + newLine );
        buf.append(" price = " + (price == null ? "[price is null]" : price.toString()));

        return buf.toString();
    }
    
	public int hashCode(){
		if(itemNumber != null){
			return itemNumber.hashCode();			
		}else{
			return super.hashCode();
		}
	}

	public boolean equals(Object o){
		boolean result = false;
		if(o != null && o instanceof Inventory){
			if(this.itemNumber != null && ((Inventory)o).itemNumber != null){
				if(this.itemNumber == ((Inventory)o).itemNumber){
					result = true;
				}
			}
		}
		return result;
	}
    
}
