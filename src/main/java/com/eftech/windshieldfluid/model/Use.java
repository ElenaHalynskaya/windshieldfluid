package com.eftech.windshieldfluid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;
import javax.persistence.NamedQuery;

@Entity
@Table(name="uset")
@NamedQuery(name="Use.getAll", query = "select c from Use c")
public class Use implements Serializable {
    
    private Long id;
    private String useName;
    private List<Fluid> fluids;

    @Id
    @Column(name = "iduse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min=2, max=45)
    @Column(name = "name", nullable = false)
    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true, mappedBy = "use")
    public List<Fluid> getFluids() {
        return fluids;
    }

    public void setFluids(List<Fluid> fluids) {
        this.fluids = fluids;
    }
    
    
    @Override
    public boolean equals(Object object) {
         if (!(object instanceof Use)) {
            return false;
        }
        Use other = (Use) object;
        if ((this.id != other.id) || (this.useName != other.useName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eftech.windshieldfluid.model.Use[ id=" + id + ", useName=" + useName + " ]";
    }
    
}
