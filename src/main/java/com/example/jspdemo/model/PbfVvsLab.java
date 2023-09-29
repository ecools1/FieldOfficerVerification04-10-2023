package com.example.jspdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "pbf_vvs_labs", schema = "public")
public class PbfVvsLab {
    @Id
    @Column(name = "lab_id", nullable = false)
   // @GeneratedValue(strategy=GenerationType.TABLE, generator="SequenceStyleGenerator")
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    public PbfVvsLab() {
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

    public void setLabName(String name) {
        this.name = name;
    }

}