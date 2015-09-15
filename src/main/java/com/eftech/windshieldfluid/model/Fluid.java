package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@Entity
@Table(name="fluid")
public class Fluid implements Serializable {
   
    private int id;
    private String fluidName;
    private String pictureName;
    //private Country country;
    //private Capacity capacity;
    //private FluidType fluidtype;
    //private Manufacturer manufacturer;
    //private Temperature temperature;
    //private Use use;
    private String price;
    
    @Id
    @Column(name = "idfluid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Size(min=3, max=100)
    @Column(name = "name", nullable = false)
    public String getFluidName() {
        return fluidName;
    }

    public void setFluidName(String fluidName) {
        this.fluidName = fluidName;
    }

    @Size(min=3, max=100)
    @Column(name = "picturename", nullable = false)
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
    
    @Column(name = "price", nullable = false)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fluid)) {
            return false;
        }
        Fluid other = (Fluid) object;
        if ((this.id != other.id) || (this.fluidName != other.fluidName) 
                || (this.pictureName != other.pictureName) || (this.price != other.price)
                //|| (this.country != other.country) || (this.fluidtype != other.fluidtype)
               // || (this.manufacturer != other.manufacturer) || (this.temperature != other.temperature)
               // || (this.use != other.use)
                ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Fluid[ id=" + id + ", fluidName=" + fluidName + ", pictureName="
				+ pictureName + ", price=" + price + " ]";
    }
    
}
