package com.example.jspdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "pbf_vvs_facilities", schema = "public")
public class PbfVvsFacility {
    @Id
    @Column(name = "facility_id", nullable = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 50,columnDefinition = "varchar")
    private String name;

    @Column(name="health_region_id")
    private int healthId;

    public PbfVvsFacility() {
    }

    public PbfVvsFacility(Integer id, String name, int healthId) {
        this.id = id;
        this.name = name;
        this.healthId = healthId;
    }

    public int getHealthId() {
        return healthId;
    }

    public void setHealthId(int healthId) {
        this.healthId = healthId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}