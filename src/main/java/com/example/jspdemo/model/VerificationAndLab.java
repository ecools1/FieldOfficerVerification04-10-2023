package com.example.jspdemo.model;

public class VerificationAndLab {
    private int id;
    private  Verification verification;
    private  PbfVvsLab pbfVvsLab;

    public VerificationAndLab() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public PbfVvsLab getPbfVvsLab() {
        return pbfVvsLab;
    }

    public void setPbfVvsLab(PbfVvsLab pbfVvsLab) {
        this.pbfVvsLab = pbfVvsLab;
    }
}
