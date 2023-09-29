package com.example.jspdemo.model;

import com.example.jspdemo.service.CustomUserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.Instant;

//@Entity(name = "vf")
//@Table(name="pbf_vvs_verification")

/*@SecondaryTables({
        @SecondaryTable(name = "pbf_vvs_users", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")),
        @SecondaryTable(name = "pbf_vvs_facilities", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")),
        @SecondaryTable(name = "pbf_vvs_labs", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")),
        @SecondaryTable(name = "pbf_vvs_health_regions", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))

})
*/


@Entity
@Table(name = "pbf_vvs_verifications", schema = "public")
public class Verification {


    /*
    get the current user id
    set the current user id
    to updatebyId to the current user
     */

   // private CustomUserDetailsService customUserDetailsService;

    @Id
    @Column(name = "verification_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "voucher_number")
    private String voucherNumber;
    @Column(name = "verification_month")
    private short month;

    @Column(name = "verification_year")
    private int year;


    @Column(name = "facility_id",insertable = false, updatable = false)
    private int facilityId;

    @Column(name = "lab_id", insertable = false, updatable = false)
    private int labId;

    @Column(name = "last_updated_by_id", insertable = false, updatable = false)
    private int lastUpdatedById;
    @Column(name = "recorded_by_id", insertable = false, updatable = false)
    private int recordedById;


    @Column(name = "renal_function_tests_verified")
    private Boolean renalFunctionTestsVerified;


    @Column(name = "liver_function_tests_verified")
    private Boolean liverFunctionTestsVerified;

    @Column(name = "lipid_profile_tests_verified")
    private Boolean lipidProfileTestsVerified;

    @Column(name = "urinalisys_tests_verified")
    private Boolean urinalisysTestsVerified;

    @Column(name = "glucose_tolerance_test_30_verified")
    private Boolean glucoseToleranceTest30Verified;

    @Column(name = "glucose_tolerance_test_60_verified")
    private Boolean glucoseToleranceTest60Verified;

    @Column(name = "glucose_tolerance_test_90_verified")
    private Boolean glucoseToleranceTest90Verified;



    @Column(name = "glucose_tolerance_test_120_verified")
    private Boolean glucoseToleranceTest120Verified;
    @Column(name = "glucose_tolerance_test_180_verified")
    private Boolean glucoseToleranceTest180Verified;
    @Column(name = "hba1c_test_verified")
    private Boolean hba1cTestVerified;
    @Column(name = "fasting_blood_glucose_test_verified")
    private Boolean fastingBloodGlucoseTestVerified;
    @Column(name = "urine_microalbumin_test_verified")
    private Boolean urineMicroalbumintestVerified;
    @Column(name = "two_hour_post_prandial_test_verified")
    private Boolean twoHourPostPrandialTestVerified;
    @Column(name = "recorded_time")
    private Instant recordedTime;
    @Column(name = "last_updated_time")
    private Instant lastUpdatedTime;


  //  @Column(name = "date_issued")
  //  private java.sql.Date dateIssued;

 //   @Column(name = "date_performed")
 //   private java.sql.Date datePerformed;

//    @Column (name="user_name")
//   private String userName;



    @Column(name = "notes")
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id")
    private PbfVvsLab lab;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private PbfVvsFacility facility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recorded_by_id")
    private PbfVvsUser recordedBy;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_updated_by_id")
    private PbfVvsUser lastUpdatedBy;

//this added for passing the value

    public Verification(CustomUserDetailsService customUserDetailsService) {
    }

    public Verification() {

    }

    //end of added code
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public int getLastUpdatedById() {
        return lastUpdatedById;
    }

    public void setLastUpdatedById(int lastUpdatedById , CustomUserDetailsService customUserDetailsService) {
    //public void setLastUpdatedById(int lastUpdatedById) {
      this.lastUpdatedById = 1;  //lastUpdatedById;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
      //  System.out.println(" customUserDetailsService.CurrentUserId()  " +customUserDetailsService.CurrentUserId());
      //  this.lastUpdatedById = customUserDetailsService.CurrentUserId();

    }

    public int getRecordedById() {
        return recordedById;
    }

    public void setRecordedById(int recordedById) {
        this.recordedById = recordedById;
    }

    public Boolean getRenalFunctionTestsVerified() {
        return renalFunctionTestsVerified;
    }

    public void setRenalFunctionTestsVerified(Boolean renalFunctionTestsVerified) {
        this.renalFunctionTestsVerified = renalFunctionTestsVerified;
    }

    public Boolean getLiverFunctionTestsVerified() {
        return liverFunctionTestsVerified;
    }

    public void setLiverFunctionTestsVerified(Boolean liverFunctionTestsVerified) {
        this.liverFunctionTestsVerified = liverFunctionTestsVerified;
    }

    public Boolean getLipidProfileTestsVerified() {
        return lipidProfileTestsVerified;
    }

    public void setLipidProfileTestsVerified(Boolean lipidProfileTestsVerified) {
        this.lipidProfileTestsVerified = lipidProfileTestsVerified;
    }

    public Boolean getUrinalisysTestsVerified() {
        return urinalisysTestsVerified;
    }

    public void setUrinalisysTestsVerified(Boolean urinalisysTestsVerified) {
        this.urinalisysTestsVerified = urinalisysTestsVerified;
    }

    public Boolean getGlucoseToleranceTest30Verified() {
        return glucoseToleranceTest30Verified;
    }

    public void setGlucoseToleranceTest30Verified(Boolean glucoseToleranceTest30Verified) {
        this.glucoseToleranceTest30Verified = glucoseToleranceTest30Verified;
    }

    public Boolean getGlucoseToleranceTest60Verified() {
        return glucoseToleranceTest60Verified;
    }

    public void setGlucoseToleranceTest60Verified(Boolean glucoseToleranceTest60Verified) {
        this.glucoseToleranceTest60Verified = glucoseToleranceTest60Verified;
    }

    public Boolean getGlucoseToleranceTest90Verified() {
        return glucoseToleranceTest90Verified;
    }

    public void setGlucoseToleranceTest90Verified(Boolean glucoseToleranceTest90Verified) {
        this.glucoseToleranceTest90Verified = glucoseToleranceTest90Verified;
    }

    public Boolean getGlucoseToleranceTest120Verified() {
        return glucoseToleranceTest120Verified;
    }

    public void setGlucoseToleranceTest120Verified(Boolean glucoseToleranceTest120Verified) {
        this.glucoseToleranceTest120Verified = glucoseToleranceTest120Verified;
    }

    public Boolean getGlucoseToleranceTest180Verified() {
        return glucoseToleranceTest180Verified;
    }

    public void setGlucoseToleranceTest180Verified(Boolean glucoseToleranceTest180Verified) {
        this.glucoseToleranceTest180Verified = glucoseToleranceTest180Verified;
    }

    public Boolean getHba1cTestVerified() {
        return hba1cTestVerified;
    }

    public void setHba1cTestVerified(Boolean hba1cTestVerified) {
        this.hba1cTestVerified = hba1cTestVerified;
    }

    public Boolean getFastingBloodGlucoseTestVerified() {
        return fastingBloodGlucoseTestVerified;
    }

    public void setFastingBloodGlucoseTestVerified(Boolean fastingBloodGlucoseTestVerified) {
        this.fastingBloodGlucoseTestVerified = fastingBloodGlucoseTestVerified;
    }

    public Boolean getUrineMicroalbumintestVerified() {
        return urineMicroalbumintestVerified;
    }

    public void setUrineMicroalbumintestVerified(Boolean urineMicroalbumintestVerified) {
        this.urineMicroalbumintestVerified = urineMicroalbumintestVerified;
    }

    public Boolean getTwoHourPostPrandialTestVerified() {
        return twoHourPostPrandialTestVerified;
    }

    public void setTwoHourPostPrandialTestVerified(Boolean twoHourPostPrandialTestVerified) {
        this.twoHourPostPrandialTestVerified = twoHourPostPrandialTestVerified;
    }

    public Instant getRecordedTime() {
        return recordedTime;
    }

    public void setRecordedTime(Instant recordedTime) {
        this.recordedTime = recordedTime;
    }

    public void setLastUpdatedById(int lastUpdatedById) {
        this.lastUpdatedById = lastUpdatedById;
    }

    public Instant getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Instant lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public PbfVvsLab getLab() {
        return lab;
    }

    public void setLab(PbfVvsLab lab) {
        this.lab = lab;
    }

    public PbfVvsFacility getFacility() {
        return facility;
    }

    public void setFacility(PbfVvsFacility facility) {
        this.facility = facility;
    }

    public PbfVvsUser getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(PbfVvsUser recordedBy) {
        this.recordedBy = recordedBy;
    }

    public PbfVvsUser getLastUpdatedBypdatedBy() {
        return lastUpdatedBy;
    }

    public void setlastupdatedBy(PbfVvsUser updatedBy) {
        this.lastUpdatedBy = updatedBy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PbfVvsUser getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(PbfVvsUser lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;

    }




}
