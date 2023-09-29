package com.example.jspdemo.repo;

import com.example.jspdemo.model.PbfVvsHealthRegion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHealthRepo extends JpaRepository<PbfVvsHealthRegion,Integer> {
}
