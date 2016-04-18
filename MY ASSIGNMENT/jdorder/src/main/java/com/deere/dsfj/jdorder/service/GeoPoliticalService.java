package com.deere.dsfj.jdorder.service;

import java.util.List;

import com.deere.dsfj.jdorder.domain.Country;
import com.deere.dsfj.jdorder.domain.State;

/** This is an interface for GeoPoliticalServiceImpl*/
public interface GeoPoliticalService{
	
	
    public List<State> getStatesForCountry(String countryCode);
    public List<Country> getCountries();  
    
}
