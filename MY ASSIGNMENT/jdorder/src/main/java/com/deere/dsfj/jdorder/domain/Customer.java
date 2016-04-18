package com.deere.dsfj.jdorder.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.deere.dsfj.utility.StringUtils;

/**This is a Customer Domain object. This object will hold the customer data.
 * This domain will map to CUSTOMERS table in database*/
@Entity
@Table(name="CUSTOMERS" )
public class Customer  {
	
	/** customer number */
	@Id
	@Column(name = "CUSTOMER_NUMBER")
	@GenericGenerator(name="incr" , strategy="increment")
	@GeneratedValue(generator="incr")
    private Integer number = null;
    
	/**name of the customer*/
    @Column(name="CUSTOMER_NAME")
    private String name = null;
    
    /**address of the customer*/
    @Column(name="CUSTOMER_ADDRESS")
    private String address = null;
    
    /**city of the customer*/
    @Column(name="CUSTOMER_CITY")
    private String city = null;
    
    /**an instance of embeddable state object. This object will hold the state information.  */
    @Embedded
    private State state = null;
  
    /**zip code of the customer*/
    @Column(name="CUSTOMER_ZIP")
    private String zip = null;

    /**Instance of CustomerPhoto, annotated with @transient annotation so that this varible is not persistent  */
    @Transient
    private CustomerPhoto photo = null;


    /**getter and setter for Customer fields*/
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.killWhitespace(name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = StringUtils.killWhitespace(address);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = StringUtils.killWhitespace(city);
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip){
        this.zip = StringUtils.killWhitespace(zip);
    }

    public CustomerPhoto getPhoto(){
        return photo;
    }

    public void setPhoto(CustomerPhoto photo){
        this.photo = photo;
        if(this.photo != null){
            this.photo.setCustomer(this);
        }
    }

    public final State getState() {
        return state;
    }

    public final void setState(State state) {
        this.state = state;
    }
    
    
    
	public int hashCode(){
		if(number != null){
			return number.hashCode();			
		}else{
			return super.hashCode();
		}
	}

	public boolean equals(Object o){
		boolean result = false;
		if(o != null && o instanceof Customer){
			if(this.number != null && ((Customer)o).number != null){
				if(this.number == ((Customer)o).number){
					result = true;
				}
			}
		}
		return result;
	}
	

    public String toString() {
    	String newLine = "\n";
        StringBuffer buf = new StringBuffer();
        buf.append("[Customer]: " + newLine);
        buf.append(" number = " + (number == null ? "[customerNumber is null]" : number.toString()) + newLine);
        buf.append(" name = " + (name == null ? "[name is null]" : "'" + name.trim() + "'") + newLine );
        buf.append(" address = " + (address == null ? "[address is null]" : "'" + address.toString() + "'")+ newLine);
        buf.append(" city = " + (city == null ? "[city is null]" : "'" + city.toString() + "'") + newLine);
        buf.append(" stateCode = " + (state == null ? "[state is null]" : (state.getCode() == null ? "[stateCode is null]" :"'" + state.getCode().toString() + "'")) + newLine );
        buf.append(" stateName = " + (state == null ? "[state is null]" : (state.getName() == null ? "[stateName is null]" :"'" + state.getName().toString() + "'")) + newLine );
        buf.append(" zip = " + (zip == null ? "[zip is null]" : zip.toString())+ newLine);
        return buf.toString();
    }


}
