package com.yash.hibernateapplicationusingmanytomany.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="New_Employee")
public class NewEmployee
{
	private int id;
	private String name;
	private String  city;
	private String state;
}
