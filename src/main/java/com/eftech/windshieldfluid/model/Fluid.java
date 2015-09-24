package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="fluid")
@NamedQuery(name="Fluid.getAll", query = "select c from Fluid c")
public class Fluid implements Serializable {
   
    private Long id;
    private String fluidName;
    private String pictureName;
    private Capacity capacity;
    private Country country;
    private FluidType fluidType;
    private Manufacturer manufacturer;
    private Temperature temperature;
    private Use use;
    private int price;
    
    @Id
    @Column(name = "idfluid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotBlank(message="The field is required")
    @Size(min=3, max=100)
    @Column(name = "name", nullable = false)
    public String getFluidName() {
        return fluidName;
    }

    public void setFluidName(String fluidName) {
        this.fluidName = fluidName;
    }

    @NotBlank(message="The field is required")
    @Size(min=3, max=100)
    @Column(name = "picturename", nullable = false)
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
    
    @NotNull(message="The field is required")
    //@Min(value = 1)
    //@Max(value = 100000000)
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name="capacity_idcapacity")
    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @ManyToOne
    @JoinColumn(name="country_idcountry")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(name="fluidtype_idfluidtype")
    public FluidType getFluidType() {
        return fluidType;
    }

    public void setFluidType(FluidType fluidType) {
        this.fluidType = fluidType;
    }

    @ManyToOne
    @JoinColumn(name="manufacturer_idmanufacturer")
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @ManyToOne
    @JoinColumn(name="temperature_idtemperature")
    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @ManyToOne
    @JoinColumn(name="use_iduse")
    public Use getUse() {
        return use;
    }

    public void setUse(Use use) {
        this.use = use;
    }
        
    
    @Override
    public boolean equals(Object object) {
           if (!(object instanceof Fluid)) {
            return false;
        }
        Fluid other = (Fluid) object;
        if ((this.id != other.id) || (this.fluidName != other.fluidName) 
                || (this.pictureName != other.pictureName) || (this.price != other.price)
                || (this.country != other.country) || (this.fluidType != other.fluidType)
                || (this.manufacturer != other.manufacturer) || (this.temperature != other.temperature)
                || (this.use != other.use)|| (this.capacity != other.capacity)
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
