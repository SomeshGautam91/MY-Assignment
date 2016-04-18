package com.deere.dsfj.jdorder.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.deere.dsfj.jdorder.dao.CustomerDao;
import com.deere.dsfj.jdorder.dao.OrderDao;
import com.deere.dsfj.jdorder.dao.OrderStatusDao;
import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.LineItem;
import com.deere.dsfj.jdorder.domain.Order;
import com.deere.dsfj.jdorder.domain.OrderStatus;
import com.deere.dsfj.jdorder.form.LineItemForm;
import com.deere.dsfj.jdorder.form.OrderForm;
import com.deere.dsfj.jdorder.form.OrderSearchForm;

/**This class has all the service implementations for order operations.
 * The transaction boundry for all order related database operations starts from this class.
 * @Transactional annotation will do the transaction management.
 *   */
@Service(value="orderService")
public class OrderServiceImpl implements OrderService{
	
	/** logger object used to log the messages for this class */
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	/**Injected orderDao, this variable is used to call orderDaoImpl methods*/
    @Resource(name="orderDao")
    private OrderDao orderDao;  

	/**Injected customerDao, this variable is used to call customerDaoImpl methods*/
    @Resource(name="customerDao")
    private CustomerDao customerDao;  
    
    
    /**Injected orderStatusDao, this variable is used to call orderStatusDaoImpl*/
    @Resource(name="orderStatusDao")
    private OrderStatusDao orderStatusDao;
    
    /** dozerBeanMapping variable is used for mapping between OrderForm and Order */
	//@Resource(name="formDomainMapperFacade")
	//private MapperFacade formDomainMapperFacade;

	
	
    @Transactional(value="transactionManager",readOnly=true, propagation=Propagation.REQUIRED)
    public List<Order> searchOrdersOfCustomer(OrderSearchForm orderSearchCriteria) {
    	List<Order> orderList = orderDao.searchOrdersOfCustomer(orderSearchCriteria.getCustomerNumber(), orderSearchCriteria.getOrderStatusCode());
    	if(orderList != null){
	    	for(Order order :orderList){
	    		assignOrderStatus(order);
	    	}
    	}
    	logger.debug("inside searchOrdersOfCustomer");
    	return orderList;
    }
    
    /** This method is used in create order operation.This method will call orderDaoImpl to insert the order
     * into database. 
     * The transaction for this operation starts from this method
     */
    @Transactional(value="transactionManager",readOnly=false, propagation=Propagation.REQUIRED)
    public Order add(OrderForm orderForm, Errors errors){
    	Order order = null;//formDomainMapperFacade.map(orderForm, Order.class);
    	// get customer from customerId and set it in order object. Customer is excluded while mapping from orderForm to Order
    	Customer customer = customerDao.findById(orderForm.getCustomerNumber());
    	order.setCustomer(customer);
    	// call dao for database level constraint checking
    	// add constraints in errors object
    	if(errors.hasErrors()){
        	// validation error
    		order = null;
    	}else {
    		List<LineItemForm> lineItemFormList = orderForm.getLineItemFormList();
    		List<LineItem> lineItemList = new ArrayList<LineItem>();
    		if(lineItemFormList != null){
	    		for(LineItemForm lineItemForm : lineItemFormList ){
	                	LineItem lineItem = null;//formDomainMapperFacade.map(lineItemForm, LineItem.class);
	                	lineItemList.add(lineItem);
	    		}
    		}
    		order.setLineItems(lineItemList);
    		orderDao.add(order);
    	}
        return order;
    }

    
    /** This method is used in edit order operation. This method will orderDaoImpl to update the 
     * order record in database. 
     * The transaction boundry for this operations starts from this method
     */
    @Transactional(value="transactionManager",readOnly=false, propagation=Propagation.REQUIRED)
    public Order update(OrderForm orderForm, Errors errors){
        Order order = orderDao.getOrder(orderForm.getOrderNumber());
        
        // check for null order. Customer does not exists
    	// call dao for database level constraint checking
    	// adding it errors object
    	if(errors.hasErrors()){
        	// validation error
        	order = null;
         }else {
             //map the changed values in original customer.
             // values will be persisted to the database when transaction ends
        	 //Type<>
        	// formDomainMapperFacade.map(orderForm, order);
        	 // here only mapping of order is done 
        	    List<LineItem> lineItemList = order.getLineItems();
           	    List<LineItemForm> lineItemFormList = orderForm.getLineItemFormList();
            	if(lineItemFormList != null){    
	                for(LineItemForm lineItemForm : lineItemFormList ){
	                	if(lineItemForm.isDeleted()){
	                    	removeLineItemFromPersistenceList(lineItemList, lineItemForm);
	                    	continue;
	                    }
	                	
	                    if(lineItemForm.isInserted()){
	                    	LineItem lineItem =null;// formDomainMapperFacade.map(lineItemForm, LineItem.class);
	                    	lineItemList.add(lineItem);
	                    	continue;
	                    }
	                    	
	                    if(lineItemForm.isUpdated()){
	                    	LineItem lineItem = getLineItemFromList(lineItemList, lineItemForm );
	                    	if(lineItem != null){
	                    		//formDomainMapperFacade.map(lineItemForm, lineItem);
	                    	}
	                    	continue;
	                    }
	                }
            	}
         }
        return order;
        
        
        
    }

    /** This method is used to return the Order object 
     */
    @Transactional(value="transactionManager",readOnly=true, propagation=Propagation.REQUIRED)
    public Order getOrder(Integer orderNumber) {
        Order order = orderDao.getOrder(orderNumber);
    	assignOrderStatus(order);
        return order;
    }
    
    /** This method gets the orderStatus object from orderStatusDao and sets it into Order object */
    private void assignOrderStatus(Order order){
    	OrderStatus orderStatus = orderStatusDao.findOrderStatusByCode(order.getOrderStatus().getCode());
    	order.setOrderStatus(orderStatus);
    }
    
    
    private void removeLineItemFromPersistenceList(List<LineItem> lineItemList, LineItemForm lineItemForm ){
    	if(lineItemList != null){
    	    int loopCount = 0;
	        for(LineItem lineItem : lineItemList ){
	        	if(lineItem.getInventory().getItemNumber() == lineItemForm.getItemNumber()){
	        		lineItemList.remove(loopCount);
	        		break;
	        	}
	        	loopCount++;
	        }	
    	}
    }
    

    private LineItem getLineItemFromList(List<LineItem> lineItemList, LineItemForm lineItemForm ){
    	LineItem requiredLineItem = null; 
    	if(lineItemList != null){
	        for(LineItem lineItem : lineItemList ){
	        	if(lineItem.getInventory().getItemNumber() == lineItemForm.getItemNumber()){
	        		requiredLineItem = lineItem;
	        		break;
	        	}
	        }	
    	}
    	return requiredLineItem;
    }    
    
}
