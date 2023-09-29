package com.example.jspdemo.service;


import com.example.jspdemo.model.*;
import com.example.jspdemo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VerificationService {

    @Autowired
    IVerificationRepository verificationRepo;

    @Autowired
    IUser userRepo;
    @Autowired
    ILabRepo labRepo;

    @Autowired
    IfacilityRepo ifacilityRepo;

    @Autowired
    IHealthRepo iHealthRepo;

    String theUserName;
    /*
    int userId;
    public int findById(){
       userId= userRepo.findById();
       return userId;
    }
    *
     */

    public String getUsername(Principal principal){
       this.theUserName= principal.getName();
         return principal.getName();
    }
    public void setTheUserName(Principal principal){
        this.theUserName = principal.getName();
    }
/*
    public List<PbfVvsUser> findByUserName(String theUserName) {
        return userRepo.findByUserName(theUserName);
    }
 */

    public List<PbfVvsUser> getAllUser(){
        List<PbfVvsUser> userList = new ArrayList<>();
        userRepo.findAll().forEach(user -> userList.add(user));
        return userList;
    }

    public List<Verification> getAllVerification() {
        List<Verification> verificationList = new ArrayList<>();
        //list of labs

        verificationRepo.findAll().forEach(verification -> verificationList.add(verification));

        return verificationList;
    }

    public Verification getVerificationById(Long id) {
        return verificationRepo.findById(id).get();
    }
    public boolean saveOrUpdateVerification(Verification verification, PbfVvsLab pbfVvslab,PbfVvsFacility pbfVvsFacility,
                                            CustomUserDetailsService customUserDetailsService) {
     //   verification.setLastUpdatedById(customUserDetailsService.CurrentUserId());

        Verification updatedVerification = verificationRepo.save(verification);

        if (verificationRepo.findById(updatedVerification.getId()) != null) {
            return true;
        }

        return false;
    }

    public boolean deleteVerification(Long id) {
        verificationRepo.deleteById(id);

        if (verificationRepo.findById(id) != null) {
            return true;
        }

        return false;
    }
    public List<PbfVvsLab> getAllLabs() {

        List<PbfVvsLab> LabList = new ArrayList<>();
        return labRepo.findAll();
    }

    public List<PbfVvsFacility> getAllFacilies() {

        List<PbfVvsFacility> FacilityList = new ArrayList<>();
        return ifacilityRepo.findAll();
    }

    public List<PbfVvsHealthRegion> getAllHealthRegion() {

        List<PbfVvsHealthRegion> HealthRegionList = new ArrayList<>();
        return iHealthRepo.findAll();
    }
}
