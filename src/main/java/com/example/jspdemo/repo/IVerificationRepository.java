package com.example.jspdemo.repo;


import com.example.jspdemo.model.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVerificationRepository extends JpaRepository<Verification, Long> {
/*
    @Query("select ver from vf ver where ver.userName=?1")
    public List<Verification> getAllVerificationByUser(String UserName);


 */

 //   List<Verification> findByUserName(String name);
}
