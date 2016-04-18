package com.deere.dsfj.jdorder.dao.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.dao.CountryDao;
import com.deere.dsfj.jdorder.dao.StateDao;
import com.deere.dsfj.jdorder.domain.Country;
import com.deere.dsfj.jdorder.domain.State;
import com.googlecode.ehcache.annotations.Cacheable;

/**This class provides the state info.StateDaoImpl does not interact with Database.
 * Created an instance variable to hold the state objects 
 * i.e created an HashMap to hold the state objects.
 */
@Repository(value="stateDao")
public class StateDaoImpl implements StateDao {

	/** Injected countryDao, this variable is used to call the countryDaoImpl methods*/
    @Autowired
    @Qualifier(value="countryDao")
    private CountryDao countryDao = null;
    
    /** This HashMap will store the state objects.Key is state code and value is State Object*/
    private Map<String, State> stateMap = new HashMap<String, State>();
    
    /** This method is called after StateDaoImpl bean is created by spring container.
     * Currently initializing US,German and Indian states*/
    @PostConstruct
    public void initialize(){
    	System.out.println("init-for-countries");
        initializeUSAStates();
        initializeGermanStates();
        initializeIndiaState();
        
    }     
    
    /** initializing US states i.e adding US state objects to states map and setting the states list in country.*/
    private void  initializeUSAStates(){
        Country usa = countryDao.findByCode("US");
        List<State> states  = new ArrayList<State>();
        states.add(new State(usa, "AL", "Alabama"));
        states.add(new State(usa, "AK", "Alaska"));
        states.add(new State(usa, "AZ", "Arizona"));
        states.add(new State(usa, "AR", "Arkansas"));
        states.add(new State(usa, "CA", "California"));
        states.add(new State(usa, "CO", "Colorado"));
        states.add(new State(usa, "CT", "Connecticut"));
        states.add(new State(usa, "DE", "Delaware"));
        states.add(new State(usa, "DC", "District Of Columbia"));
        states.add(new State(usa, "FL", "Florida"));
        states.add(new State(usa, "GA", "Georgia"));
        states.add(new State(usa, "HI", "Hawaii"));
        states.add(new State(usa, "ID", "Idaho"));
        states.add(new State(usa, "IL", "Illinois"));
        states.add(new State(usa, "IN", "Indiana"));
        states.add(new State(usa, "IA", "Iowa"));
        states.add(new State(usa, "KS", "Kansas"));
        states.add(new State(usa, "KY", "Kentucky"));
        states.add(new State(usa, "LA", "Louisiana"));
        states.add(new State(usa, "ME", "Maine"));
        states.add(new State(usa, "MD", "Maryland"));
        states.add(new State(usa, "MA", "Massachusetts"));
        states.add(new State(usa, "MI", "Michigan"));
        states.add(new State(usa, "MN", "Minnesota"));
        states.add(new State(usa, "MS", "Mississippi"));
        states.add(new State(usa, "MO", "Missouri"));
        states.add(new State(usa, "MT", "Montana"));
        states.add(new State(usa, "NE", "Nebraska"));
        states.add(new State(usa, "NH", "New Hampshire"));
        states.add(new State(usa, "NJ", "New Jersey"));
        states.add(new State(usa, "NM", "New Mexico"));
        states.add(new State(usa, "NY", "New York"));
        states.add(new State(usa, "NV", "Nevada"));
        states.add(new State(usa, "NC", "North Carolina"));
        states.add(new State(usa, "ND", "North Dakota"));
        states.add(new State(usa, "OH", "Ohio"));
        states.add(new State(usa, "OK", "Oklahoma"));
        states.add(new State(usa, "OR", "Oregon"));
        states.add(new State(usa, "PA", "Pennsylvania"));
        states.add(new State(usa, "PR", "Puerto rico"));
        states.add(new State(usa, "RI", "Rhode island"));
        states.add(new State(usa, "SC", "South Carolina"));
        states.add(new State(usa, "SD", "South Dakota"));
        states.add(new State(usa, "TN", "Tennessee"));
        states.add(new State(usa, "TX", "Texas"));
        states.add(new State(usa, "UT", "Utah"));
        states.add(new State(usa, "VT", "Vermont"));
        states.add(new State(usa, "VA", "Virginia"));
        states.add(new State(usa, "WA", "Washington"));
        states.add(new State(usa, "WV", "West Virginia"));
        states.add(new State(usa, "WI", "Wisconsin"));
        states.add(new State(usa, "WY", "Wyoming"));
        
        usa.setStates(states);
        for(State state : states){
            stateMap.put(state.getCode(), state);
        }
    }    

    /** initializing German states i.e adding German state objects to states map and setting the states list in country.*/
    private void  initializeGermanStates(){        
        Country germany = countryDao.findByCode("DE");
        List<State> states  = new ArrayList<State>();

        states.add(new State(germany, "BW", "Baden-Wurttemberg"));
        states.add(new State(germany, "BY", "Bavaria"));
        states.add(new State(germany, "BE", "Berlin"));
        states.add(new State(germany, "BR", "Brandenburg"));
        states.add(new State(germany, "HB", "Bremen"));
        states.add(new State(germany, "HH", "Hamburg"));
        states.add(new State(germany, "HE", "Hesse"));
        states.add(new State(germany, "NI", "Lower Saxony"));
        states.add(new State(germany, "MV", "Mecklenburg-West Pomerania"));
        states.add(new State(germany, "NW", "North Rhine-Westphalia"));
        states.add(new State(germany, "RP", "Rhineland-Palatinate"));
        states.add(new State(germany, "SL", "Saarland"));
        states.add(new State(germany, "SN", "Saxony"));
        states.add(new State(germany, "ST", "Saxony-Anhalt"));
        states.add(new State(germany, "SH", "Schleswig-Holstein"));
        states.add(new State(germany, "TH", "Thuringia"));
        
        germany.setStates(states);
        for(State state : states){
            stateMap.put(state.getCode(), state);
        }
        
    }

    /** initializing Indian states i.e adding Indian state objects to states map and setting the states list in country.*/
    private void initializeIndiaState(){
        
        Country india = countryDao.findByCode("IN");
        List<State> states  = new ArrayList<State>();

        states.add(new State(india, "AN", "Andaman and Nicobar Islands"));
        states.add(new State(india, "AP", "Andhra Pradesh"));
        states.add(new State(india, "AR", "Arunachal Pradesh"));
        states.add(new State(india, "AS", "Assam"));
        states.add(new State(india, "BR", "Bihar"));
        states.add(new State(india, "CH", "Chandigarh"));
        states.add(new State(india, "CT", "Chhattisgarh"));
        states.add(new State(india, "DN", "Dadra and Nagar Haveli"));
        states.add(new State(india, "DD", "Daman and Diu"));
        states.add(new State(india, "DL", "Delhi"));
        states.add(new State(india, "GA", "Goa"));
        states.add(new State(india, "GJ", "Gujarat"));
        states.add(new State(india, "HR", "Haryana"));
        states.add(new State(india, "HP", "Himachal Pradesh"));
        states.add(new State(india, "JK", "Jammu and Kashmir"));
        states.add(new State(india, "JH", "Jharkhand"));
        states.add(new State(india, "KA", "Karnataka"));
        states.add(new State(india, "KL", "Kerala"));
        states.add(new State(india, "LD", "Lakshadweep"));
        states.add(new State(india, "MP", "Madhya Pradesh"));
        states.add(new State(india, "MH", "Maharashtra"));
        states.add(new State(india, "MN", "Manipur"));
        states.add(new State(india, "ML", "Meghalaya"));
        states.add(new State(india, "MZ", "Mizoram"));
        states.add(new State(india, "NL", "Nagaland"));
        states.add(new State(india, "OR", "Orissa"));
        states.add(new State(india, "PY", "Puducherry"));
        states.add(new State(india, "PB", "Punjab"));
        states.add(new State(india, "RJ", "Rajasthan"));
        states.add(new State(india, "SK", "Sikkim"));
        states.add(new State(india, "TN", "Tamil Nadu"));
        states.add(new State(india, "TR", "Tripura"));
        states.add(new State(india, "UL", "Uttarakhand"));
        states.add(new State(india, "UP", "Uttar Pradesh"));
        states.add(new State(india, "WB", "West Bengal"));
        
        india.setStates(states);
        for(State state : states){
            stateMap.put(state.getCode(), state);
        }
    }

    /** This method returns a state object for a particular state code.State object is cached*/
   @Cacheable(cacheName="GeoPoliticalCache")
    public State findByCode(String code) {
	   System.out.println("state cached method..");
        return stateMap.get(code);
    }

    /** This method returns states of a country. States list is cached*/
    @Cacheable(cacheName="GeoPoliticalCache")
    public List<State> getStatesOfCountry(String countryCode) {
        // assume country code is correct
        Country country = countryDao.findByCode(countryCode);
        if(country != null){
            return country.getStates();
        }
        return null;
    }

}
