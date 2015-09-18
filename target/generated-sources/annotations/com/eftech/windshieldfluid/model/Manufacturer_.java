package com.eftech.windshieldfluid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Manufacturer.class)
public abstract class Manufacturer_ {

	public static volatile SingularAttribute<Manufacturer, String> discription;
	public static volatile SingularAttribute<Manufacturer, String> manufacturerName;
	public static volatile SingularAttribute<Manufacturer, Long> id;
	public static volatile SingularAttribute<Manufacturer, String> pictureName;
	public static volatile ListAttribute<Manufacturer, Fluid> fluids;

}

