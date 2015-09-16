package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;

@Entity
@Table(name="fluidtype")
@NamedQuery(name="Fluidtype.getAll", query = "select c from FluidType c")
public class FluidType implements Serializable {
   
    private int id;
    private String type;
    private List<Fluid> fluids;

    @Id
    @Column(name = "idfluidtype")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Size(min=2, max=45)
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true, mappedBy = "fluidType")
    public List<Fluid> getFluids() {
        return fluids;
    }

    public void setFluids(List<Fluid> fluids) {
        this.fluids = fluids;
    }
    
    
    @Override
    public boolean equals(Object object) {
      
        if (!(object instanceof FluidType)) {
            return false;
        }
        FluidType other = (FluidType) object;
        if ((this.id != other.id) || (this.type != other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.FluidType[ id=" + id + ", type=" + type +  " ]";
    }
    
}
