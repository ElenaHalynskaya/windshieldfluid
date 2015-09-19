package com.eftech.windshieldfluid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Capacity.class)
public abstract class Capacity_ {

	public static volatile SingularAttribute<Capacity, Long> id;
	public static volatile SingularAttribute<Capacity, Integer> capacityCol;
	public static volatile ListAttribute<Capacity, Fluid> fluids;

}

