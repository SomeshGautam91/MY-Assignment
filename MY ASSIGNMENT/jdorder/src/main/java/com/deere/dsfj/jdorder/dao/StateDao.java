package com.deere.dsfj.jdorder.dao;

import java.util.List;

import com.deere.dsfj.jdorder.domain.State;

/** This is an interface for StateDaoImpl */
public interface StateDao {
	public List<State> getStatesOfCountry(String countryCode);

	public State findByCode(String code);
}
