package com.deere.dsfj.jdorder.dao.memory;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.dao.CountryDao;
import com.deere.dsfj.jdorder.domain.Country;
import com.deere.dsfj.jdorder.domain.State;
import com.googlecode.ehcache.annotations.Cacheable;

/**This class provides the country info.CountryDaoImpl does not interact with Database.
 * Created an instance variable to hold the country objects 
 * i.e created an arraylist to hold the country objects.Used @Cacheable to do the caching. 
 * */
@Repository(value="countryDao")
public class CountryDaoImpl implements CountryDao{
    
	/**This variable will hold the country objects.*/
	
    private List<Country> countryList = new ArrayList<Country>();
    
    public CountryDaoImpl(){
        
    }
    
    /**This method will be called after the CountryDaoImpl object is created by container. 
     * adding the country objects to countryList*/
    @PostConstruct
    public void initialize(){
        countryList.add((new Country("US", "USA")));
        countryList.add((new Country("DE", "Germany")));
        countryList.add((new Country("IN", "India")));
    }
    
    /**This method will return the Country Object.
     * Used @Cacheable annotation to do the caching of the results.
     * After the first request country will be cached.For next subsequent request of same country code,
     * EHCache will return the cached country object  */
    
    @Cacheable(cacheName="GeoPoliticalCache")
    public Country findByCode(String code) {
        for(Country country : countryList){
            if(country.getCode().equalsIgnoreCase(code)){
                return country;
            }
        }
        return null;
    }

    /** This method will return the list of all countries. Used @Cacheable to cache the countryList*/
    @Cacheable(cacheName="GeoPoliticalCache")
    public List<Country> getAllCountries() {
        return countryList;
    }
    
    /** This method will return the list of the states of a country. States list is cached*/
    @Cacheable(cacheName="GeoPoliticalCache")
    public List<State> getStatesOfCountry(String code){
        Country country = findByCode(code);
        if(country != null){
            return country.getStates();
        }
        return null;
    }
    
     
}
