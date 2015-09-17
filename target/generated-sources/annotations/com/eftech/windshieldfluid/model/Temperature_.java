package com.eftech.windshieldfluid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Temperature.class)
public abstract class Temperature_ {

	public static volatile SingularAttribute<Temperature, Integer> temperatureMax;
	public static volatile SingularAttribute<Temperature, Integer> temperatureMin;
	public static volatile SingularAttribute<Temperature, Integer> id;
	public static volatile ListAttribute<Temperature, Fluid> fluids;

}

