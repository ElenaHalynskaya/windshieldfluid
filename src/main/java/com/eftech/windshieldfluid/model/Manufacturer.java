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
@Table(name="manufacturer")
@NamedQuery(name="Manufacturer.getAll", query = "select c from Manufacturer c")
public class Manufacturer implements Serializable {
    
    private Long id;
    private String manufacturerName;
    private String description;
    private String pictureName;
    private List<Fluid> fluids;

    @Id
    @Column(name = "idmanufacturer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min=2, max=100)
    @Column(name = "manufacturer", nullable = false)
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Size(min=2)
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Size(min=1, max=100)
    @Column(name = "picturename", nullable = false)
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manufacturer")
    public List<Fluid> getFluids() {
        return fluids;
    }

    public void setFluids(List<Fluid> fluids) {
        this.fluids = fluids;
    }
    
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Manufacturer)) {
            return false;
        }
        Manufacturer other = (Manufacturer) object;
        if ((this.id != other.id) || (this.manufacturerName != other.manufacturerName) || 
           (this.description != other.description)|| (this.pictureName != other.pictureName)) {
            return false;
        }    
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Manufacturer[ id=" + id + ", name=" + manufacturerName + 
                ", description=" + description + ", pictureName=" + pictureName +  " ]";
    }
    
}
