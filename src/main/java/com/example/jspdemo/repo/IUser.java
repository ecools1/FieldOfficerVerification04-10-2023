package com.example.jspdemo.repo;

import com.example.jspdemo.model.PbfVvsUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUser extends JpaRepository<PbfVvsUser,Integer> {

     Optional<PbfVvsUser> findByUserName (String userName);


   //  List<PbfVvsUser> findByUserName(String name);

}
