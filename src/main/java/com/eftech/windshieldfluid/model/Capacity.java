package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
@Table(name="capacity")
public class Capacity implements Serializable {
    
    private int id;
    private int capacityName;
    private List<Fluid> fluids;
    
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true, mappedBy = "capacity")
    public List<Fluid> getFluids() {
        return fluids;
    }

    public void setFluids(List<Fluid> fluids) {
        this.fluids = fluids;
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
