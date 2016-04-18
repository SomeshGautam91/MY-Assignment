package com.deere.dsfj.jdorder.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.deere.dsfj.jdorder.dao.CountryDao;
import com.deere.dsfj.jdorder.dao.StateDao;
import com.deere.dsfj.jdorder.domain.Country;
import com.deere.dsfj.jdorder.domain.State;

/**This class provides the country and state information */
@Service(value="geoPoliticalService")
public class GeoPoliticalServiceImpl implements GeoPoliticalService{
   
	/**Injected stateDao, this variable is used to call stateDaoImpl methods*/
	
    @Resource(name="stateDao")
    private StateDao stateDao = null; 
    
    /**Injected countryDao, this variable is used to call countryDaoImpl methods*/
    @Autowired
    @Qualifier(value="countryDao")
    private CountryDao countryDao = null;
    
    /**This method is used to provide the states list for the country*/
    public List<State> getStatesForCountry(String countryCode){
        List<State> states = stateDao.getStatesOfCountry(countryCode);
        return states;
    }
    
    /** This method will return list of countries*/
    public List<Country> getCountries(){
        List<Country> countries = countryDao.getAllCountries();
        return countries;
    }

    /**This method will return the State object based on state code*/
    public State getState(String stateCode){
        return this.stateDao.findByCode(stateCode);
    }
    
    /**This method will return the Country object based on country code*/
    public Country getCountry(String countryCode){
        return this.countryDao.findByCode(countryCode);
    }
}
