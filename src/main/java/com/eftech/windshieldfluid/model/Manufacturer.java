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
@Table(name="manufacturer")
public class Manufacturer implements Serializable {
    
    private int id;
    private String manufacturerName;
    private String discription;
    private String pictureName;

    @Id
    @Column(name = "idmanufacturer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "discription", nullable = false)
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Size(min=1, max=100)
    @Column(name = "picturename", nullable = false)
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Manufacturer)) {
            return false;
        }
        Manufacturer other = (Manufacturer) object;
        if ((this.id != other.id) || (this.manufacturerName != other.manufacturerName) || 
           (this.discription != other.discription)|| (this.pictureName != other.pictureName)) {
            return false;
        }    
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Manufacturer[ id=" + id + ", name=" + manufacturerName + 
                ", discription=" + discription + ", pictureName=" + pictureName +  " ]";
    }
    
}
