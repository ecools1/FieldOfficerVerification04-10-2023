package com.example.jspdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pbf_vvs_health_regions", schema = "public")
public class PbfVvsHealthRegion {
    @Id
    @Column(name = "health_region_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

   // @Column(name = "health_region_name", length = 50)
   // private String healthRegionName;

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

   // public String getHealthRegionName() {
     //   return healthRegionName;
   // }

  //  public void setHealthRegionName(String healthRegionName) {
   //     this.healthRegionName = healthRegionName;
  //  }

}