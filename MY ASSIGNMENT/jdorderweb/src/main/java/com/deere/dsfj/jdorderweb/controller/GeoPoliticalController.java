package com.deere.dsfj.jdorderweb.controller;

import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deere.dsfj.jdorder.domain.State;
import com.deere.dsfj.jdorderweb.controller.helper.GeoPoliticalHelper;
import com.deere.dsfj.jdorderweb.model.StateJsonMixin;


/** This class will be called by a ajax request to populate the state dropdpown on CreateCustomer or 
 * EditCustomer screens. This class will return the state beans to the screen*/
@Controller
public class GeoPoliticalController{
    private static final Logger logger = LoggerFactory.getLogger(GeoPoliticalController.class);
    

	/**Injected geoPoliticalHelper, this variable will be used to call the geoPoliticalHelper to get the state beans*/
    @Autowired
    @Qualifier(value="geoPoliticalHelper")
    private GeoPoliticalHelper geoPoliticalHelper;
    
    /**
     * getStatesOfCountryAjax method will be called from CreateCustomer or EditCustomer screen. 
     * An ajax call to display the states will call this method. This methods get the statebeans from geoPoliticalHelper
     * @param countryCode
     * @return states
     */
    @RequestMapping(value = {"/GetStatesForCountry"},  params="country", method=RequestMethod.GET)
    public @ResponseBody String getStatesForCountryWithPrompt(@RequestParam(value="country", required=true) String countryCode, HttpServletResponse response){
 	  logger.debug("inside getStatesForCountryWithPrompt");
 	  List<State> states = geoPoliticalHelper.getStatesForCountryWithSelectText(countryCode);
  	  String jsonformatStateList = convertStateListToJsonFormat(states);
  	  return jsonformatStateList;
    }
    
    private String convertStateListToJsonFormat(List<State> states){
   	  logger.debug("inside convertStateListToJsonFormat");
      String jsonformatStateList = ""; 	
  	  ObjectMapper mapper = new ObjectMapper();  
	  SerializationConfig serializationConfig = mapper.getSerializationConfig(); 
	  serializationConfig.addMixInAnnotations(State.class, StateJsonMixin.class);
	  StringWriter strWriter = new StringWriter();
	  try{
		  mapper.writeValue(strWriter, states);
	  }catch(Exception ex){
		  //TODO : should we log it as error or warning. What should be done in case of exception
		  logger.warn("Error in getting response body from jackson", ex);
	  }
	  jsonformatStateList = strWriter.toString();
      return jsonformatStateList;
    }
}
