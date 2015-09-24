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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="capacity")
@NamedQuery(name="Capacity.getAll", query = "select c from Capacity c")
public class Capacity implements Serializable {
    
    private Long id;
    private Integer capacityCol;
    private List<Fluid> fluids;
    
    @Id
    @Column(name = "idcapacity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotNull(message="The field is required")
    @Min(value = 1, message = "The value must be greater than 0")
    @Column(name = "capacitycol", nullable = false)
    public Integer getCapacityCol() {
        return capacityCol;
    }
    
    public void setCapacityCol(Integer capacityCol) {
        this.capacityCol = capacityCol;
    }
  
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true, mappedBy = "capacity")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "capacity")
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
        if ((this.id != other.id) || (this.capacityCol != other.capacityCol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Capacity[ id=" + id + ", capacityCol=" + capacityCol + " ]";
    }
    
}
