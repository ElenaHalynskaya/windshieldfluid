package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="capacity")
public class Capacity implements Serializable {
    
    private int id;
    private int capacityName;
    
    @Id
    @Column(name = "idcapacity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "capacitycol", nullable = false)
    public int getCapacityName() {
        return capacityName;
    }
    
    public void setCapacityName(int capacityName) {
        this.capacityName = capacityName;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Capacity)) {
            return false;
        }
        Capacity other = (Capacity) object;
        if ((this.id != other.id) || (this.capacityName != other.capacityName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Capacity[ id=" + id + ", capacityName=" + capacityName + " ]";
    }
    
}
