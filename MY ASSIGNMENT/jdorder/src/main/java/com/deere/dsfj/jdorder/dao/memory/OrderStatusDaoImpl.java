package com.deere.dsfj.jdorder.dao.memory;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.dao.OrderStatusDao;
import com.deere.dsfj.jdorder.domain.OrderStatus;

/** This class provides Order Status Data.*/
@Repository(value="orderStatusDao")
public class OrderStatusDaoImpl implements OrderStatusDao{

	/** status code for ordered status*/
    private final static String ordered = "O";
    
    /** description for ordered status */
    private final static String orderedDescription = "Ordered";
    
    /**status code for pending status*/
    private final static String pending = "P";
    
    /** description for pending status*/
    private final static String pendingDescription = "Pending";
    
    /** status code for cancelled status*/
    private final static String cancelled = "C";
    
    /** description for cancelled status*/
    private final static String cancelledDescription = "Cancelled";
    
    /** status code for overdue status*/
    private final static String overdue = "D";
    
    /** description for overdue status*/
    private final static String overdueDescription = "Overdue";
    
    /** This list will hold OrderStatus objects*/
    private List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
    
    /** This method is called after OrderStatusDaoImpl bean is created by spring container. 
     * orderStatusList is populated with OrderStatus objects */
    @PostConstruct
    public void initialize(){
        orderStatusList.add((new OrderStatus(ordered, orderedDescription)));
        orderStatusList.add((new OrderStatus(pending, pendingDescription)));
        orderStatusList.add((new OrderStatus(cancelled, cancelledDescription)));
        orderStatusList.add((new OrderStatus(overdue, overdueDescription)));
    }
    
    /** This method will return the list orderStatusList*/
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusList;
    }

    /** This method will return the OrderStatus object for a particular status code*/
    public OrderStatus findOrderStatusByCode(String code) {
       for(OrderStatus orderStatus : orderStatusList){
           if(orderStatus.getCode().equalsIgnoreCase(code) ){
               return orderStatus; 
           }
       }
       return null;
    }

}
