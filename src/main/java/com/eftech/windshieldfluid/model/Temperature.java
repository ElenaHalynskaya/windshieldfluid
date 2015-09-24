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
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="temperature")
@NamedQuery(name="Temperature.getAll", query = "select c from Temperature c")
public class Temperature implements Serializable {
   
    private Long id;
    private Integer temperatureMin;
    private Integer temperatureMax;
    private List<Fluid> fluids;
    private String range;

    @Id
    @Column(name = "idtemperature")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message="The field is required")
    @Min(value = -40)
    @Max(value = 40)
    @Column(name = "temperatureMin", nullable = false)
    public Integer getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Integer temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    @Min(value = 0)
    @Max(value = 100)
    @NotNull(message="The field is required")
    @Column(name = "temperatureMax", nullable = false)
    public Integer getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Integer temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "temperature")
    public List<Fluid> getFluids() {
        return fluids;
    }

    public void setFluids(List<Fluid> fluids) {
        this.fluids = fluids;
    }

    @Transient
    public String getRange() {
        this.range = Integer.toString(temperatureMin) + " - " + Integer.toString(temperatureMax);
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    
    
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Temperature)) {
            return false;
        }
        Temperature other = (Temperature) object;
        if ((this.id != other.id) || (this.temperatureMin != other.temperatureMin) 
                || (this.temperatureMax != other.temperatureMax)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Temperature[ id=" + id + ", temperatureMin=" 
                + temperatureMin + ", temperatureMax=" + temperatureMax + " ]";
    }
    
}
