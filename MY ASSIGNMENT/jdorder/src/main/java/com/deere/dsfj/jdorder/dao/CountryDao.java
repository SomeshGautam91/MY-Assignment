package com.deere.dsfj.jdorder.dao;

import java.util.List;

import com.deere.dsfj.jdorder.domain.Country;

/** This is an interface for CountryDaoImpl*/
public interface CountryDao{
    public List<Country> getAllCountries();
    public Country findByCode(String code);

    
}
