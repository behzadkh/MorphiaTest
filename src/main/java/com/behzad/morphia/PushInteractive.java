package com.behzad.morphia;

import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import java.util.Date;


@Entity (value = "pushinteractive", noClassnameStored = true)
public class PushInteractive {

    @Id
    @Property ("id")
    private long id;

    @Property ("destination")
    private long destination;

    @Property ("continuewithsms")
    private boolean continueWithSms;

    @Property ("originator")
    private long originator;

    @Property ("smsreferenceid")
    private long smsReferenceId = 0;

    @Property ("status")
    private Status status;

    @Property ("size")
    private long size;

    @Property ("referenceid")
    private long referenceId;

    @Property ("applicationcode")
    private String applicationCode;

    @Property ("mastercode")
    private String masterCode;

    @Property ("lifetime")
    private int lifeTime;

    @Property ("customerid")
    private long customerId;

    @Property ("content")
    private String content;

    @Property ("insertdate")
    private Date insertDate;

    @Property ("requesttime")
    private Date requestTime;

    @Property ("price")
    private double price;

    @Property ("usersuppliedid")
    private Long userSuppliedId;

    @Property ("sentdate")
    private Date sentDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDestination() {
        return destination;
    }

    public void setDestination(long destination) {
        this.destination = destination;
    }

    public boolean isContinueWithSms() {
        return continueWithSms;
    }

    public void setContinueWithSms(boolean continueWithSms) {
        this.continueWithSms = continueWithSms;
    }

    public long getOriginator() {
        return originator;
    }

    public void setOriginator(long originator) {
        this.originator = originator;
    }

    public long getSmsReferenceId() {
        return smsReferenceId;
    }

    public void setSmsReferenceId(long smsReferenceId) {
        this.smsReferenceId = smsReferenceId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(long referenceId) {
        this.referenceId = referenceId;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public String getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getUserSuppliedId() {
        return userSuppliedId;
    }

    public void setUserSuppliedId(Long userSuppliedId) {
        this.userSuppliedId = userSuppliedId;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "PushInteractive{" +
                "id=" + id +
                ", destination=" + destination +
                ", continueWithSms=" + continueWithSms +
                ", originator=" + originator +
                ", smsReferenceId=" + smsReferenceId +
                ", status=" + status +
                ", size=" + size +
                ", referenceId=" + referenceId +
                ", applicationCode='" + applicationCode + '\'' +
                ", masterCode='" + masterCode + '\'' +
                ", lifeTime=" + lifeTime +
                ", customerId=" + customerId +
//                ", content='" + content + '\'' +
                ", insertDate=" + insertDate +
                ", requestTime=" + requestTime +
                ", price=" + price +
                ", userSuppliedId=" + userSuppliedId +
                ", sentDate=" + sentDate +
                '}';
    }

    public enum Status {IN_QUEUE, DELIVERED, NOT_DELIVERED}
}
