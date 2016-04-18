package com.deere.dsfj.jdorder.config;

import javax.annotation.Resource;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

/**This class provides the property file values to the application. 
 * Used PropertiesConfiguration api from apache configurations to get the property values from property file 
 * singleton beans are loaded at startup. Hence no need to call getBean to create instance of this
 * this bean. Instance of this class will be created by spring using blank constructor
 * only one instance of this class will be created, as this class will be defined as singleton
 * private also works. No one should call new ApplicationProperties

 * */
@Component(value="applicationProperties")
public class ApplicationProperties {

	/**Injected customerProperties bean, this variable is used to get the property values from customer-iafconfigsffix.properties */
	@Resource(name="customerProperties")
    private PropertiesConfiguration customerProperties;

    
    private static ApplicationProperties applicationProperties= null;
    
    private ApplicationProperties() {
        if(applicationProperties == null){
            applicationProperties = this;
        }
    }
    
    /**This method will provide the singleton instance of the ApplicationProperties*/
    public static ApplicationProperties getInstance() {
        return applicationProperties;
    }
    
    /**This method will return customerProperties variable*/
    public final PropertiesConfiguration getCustomerProperties() {
        return customerProperties;
    }
    
  
  
    
    
}
