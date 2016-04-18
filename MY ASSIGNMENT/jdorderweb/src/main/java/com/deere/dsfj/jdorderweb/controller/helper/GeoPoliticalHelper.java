package com.deere.dsfj.jdorderweb.controller.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.deere.dsfj.jdorder.domain.Country;
import com.deere.dsfj.jdorder.domain.State;
import com.deere.dsfj.jdorder.service.GeoPoliticalService;

/**GeoPoliticalHelper class is responsible to provide country and state information*/

@Component(value="geoPoliticalHelper")
public class GeoPoliticalHelper{

	/**Injected geoPoliticalService, this variable is used to call GeoPoliticalServiceImpl methods*/
    @Autowired
    @Qualifier(value="geoPoliticalService")
    private GeoPoliticalService geoPoliticalService;
    
    
    // getCountries
    public List<Country> getCountriesWithSelectText(){
        List<Country> countriesWithOutBlankCountry = geoPoliticalService.getCountries();
        List<Country> countriesWithBlankCountry    = new ArrayList<Country>();
        
        countriesWithBlankCountry.addAll(countriesWithOutBlankCountry);
        Country blankCountryBean = getSelectedTextCountryforDropDownView();
        countriesWithBlankCountry.add(blankCountryBean);
        return countriesWithBlankCountry;
    }
   
    
    /**
     * getStatesForCountryWithPrompt method returns the StateBeans to be displayed in State dropdown. 
     * When user selects the country and ajax call is made to this method. This method makes a call to 
     * geoPoliticalService to get the StateBeans. Currently this method is called from Create Customer screen
     * @param countryCode of the selected country of which states are to be displayed
     * @return
     */
	public List<State> getStatesForCountryWithSelectText(String countryCode){
        List<State> statesWithOutBlankState = geoPoliticalService.getStatesForCountry(countryCode);
        List<State> statesWithBlankState = new ArrayList<State>();
        if(statesWithOutBlankState != null){
        	statesWithBlankState.addAll(statesWithOutBlankState);
        }
        State blankStateWithSelectText = getSelectTextStateforDropDownView();
        statesWithBlankState.add(blankStateWithSelectText);
        return statesWithBlankState;
    }    
    
    
    private State getSelectTextStateforDropDownView(){
        State blankState = new State();
        blankState.setCode("");
        blankState.setName("-- Select a state --");
        return blankState;
    }
    

    private Country getSelectedTextCountryforDropDownView(){
        Country blankCountry = new Country();
        blankCountry.setCode("");
        blankCountry.setName("-- Select a country --");
        return blankCountry;
    }
    
}
