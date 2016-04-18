package com.deere.dsfj.jdorderweb.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.deere.dsfj.jdorder.domain.State;

// this should be moved to model folder of presentation layer

@JsonIgnoreProperties({"country"})
public class StateJsonMixin extends State{

}

