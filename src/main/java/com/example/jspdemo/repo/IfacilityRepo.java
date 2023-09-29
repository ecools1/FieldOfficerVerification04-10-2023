package com.example.jspdemo.repo;

import com.example.jspdemo.model.PbfVvsFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IfacilityRepo extends JpaRepository<PbfVvsFacility,Integer> {
}
