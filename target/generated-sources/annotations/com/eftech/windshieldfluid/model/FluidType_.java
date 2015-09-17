package com.eftech.windshieldfluid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FluidType.class)
public abstract class FluidType_ {

	public static volatile SingularAttribute<FluidType, Integer> id;
	public static volatile SingularAttribute<FluidType, String> type;
	public static volatile ListAttribute<FluidType, Fluid> fluids;

}

