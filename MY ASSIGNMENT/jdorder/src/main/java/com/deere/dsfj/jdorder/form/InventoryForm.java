package com.deere.dsfj.jdorder.form;

/***/
public class InventoryForm{
    private Integer itemNumber = null;
    private String description = null;
    // need to fix this
    private Float price = null;
    
    private boolean selected = false;
    private boolean selectable = true; //false if already part of order
    
   
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
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
   
    public boolean isSelectable() {
        return selectable;
    }
    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
    
    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[InventoryForm]: " + newLine);
        buf.append(" itemNumber = " + (itemNumber == null ? "[itemNumber is null]" : itemNumber.toString()) + newLine);
        buf.append(" description = " + (description == null ? "[description is null]" : "'" + description.trim() + "'") + newLine );
        buf.append(" price = " + (price == null ? "[price is null]" : price.toString()));

        return buf.toString();
    }
}
