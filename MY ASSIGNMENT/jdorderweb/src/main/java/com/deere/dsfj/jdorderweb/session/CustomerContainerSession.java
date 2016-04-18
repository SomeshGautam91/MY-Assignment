package com.deere.dsfj.jdorderweb.session;

import com.deere.dsfj.jdorder.form.CustomerSearchForm;

/**This class is used to manage the customer data in session.The scope of this bean is session. 
 * This class acts as a container for CustomerSearchForm */

public class CustomerContainerSession  {

	public CustomerContainerSession(){
		//System.err.println(" CustomerContainerSession created");
	}
	
	/**This variable will hold the search criteria for Select Customer */
    private CustomerSearchForm selectCriteria = null;
    
    /**This variable will hold the search criteria for Search Customer*/
    private  CustomerSearchForm searchCriteria = null;
    
	public CustomerSearchForm getSelectCriteria() {
		return selectCriteria;
	}

	public  void setSelectCriteria(CustomerSearchForm selectCriteria) {
		this.selectCriteria = selectCriteria;
	}

	public  CustomerSearchForm getSearchCriteria() {
		return searchCriteria;
	}

	public  void setSearchCriteria(CustomerSearchForm searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	/** this method will clear search criteria */
	public void clearAll(){
		setSelectCriteria(null);
		setSearchCriteria(null);
	}

	public void clearSearchCriteria(){
		setSearchCriteria(null);
	}

	public void clearSelectCriteria(){
		setSelectCriteria(null);
	}
	
}
