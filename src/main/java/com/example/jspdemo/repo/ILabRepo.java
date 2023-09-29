package com.example.jspdemo.repo;

import com.example.jspdemo.model.PbfVvsLab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILabRepo extends JpaRepository <PbfVvsLab,Integer>{
}
