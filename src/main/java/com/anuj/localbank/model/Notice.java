package com.anuj.localbank.model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name="notice_details")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private int noticeId;

    private String noticeSummary;

    private String noticeDetails;
    @Column(name = "noticBegDt")
    private Date noticBegDt;
    @Column(name = "noticEndDt")
    private Date noticEndDt;
    private Date createDt;
//    @Column(name = "update_dt")
//    private Date updateDt;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticBegDt() {
        return noticBegDt;
    }

    public void setNoticBegDt(Date noticBegDt) {
        this.noticBegDt = noticBegDt;
    }

    public Date getNoticEndDt() {
        return noticEndDt;
    }

    public void setNoticEndDt(Date noticEndDt) {
        this.noticEndDt = noticEndDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

//    public Date getUpdate_dt() {
//        return updateDt;
//    }
//
//    public void setUpdate_dt(Date updateDt) {
//        this.updateDt = updateDt;
//    }
}
