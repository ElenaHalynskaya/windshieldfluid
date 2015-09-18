package com.eftech.windshieldfluid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Use.class)
public abstract class Use_ {

	public static volatile SingularAttribute<Use, String> useName;
	public static volatile SingularAttribute<Use, Long> id;
	public static volatile ListAttribute<Use, Fluid> fluids;

}

