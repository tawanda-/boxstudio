package za.co.boxstudio.Webservices.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("instNo")
    @Expose
    public Integer instNo;
    @SerializedName("scheduleID")
    @Expose
    public String scheduleID;
    @SerializedName("staffID")
    @Expose
    public String staffID;
    @SerializedName("actvityID")
    @Expose
    public String actvityID;
    @SerializedName("FacilityNum")
    @Expose
    public String facilityNum;
    @SerializedName("scheduleDay")
    @Expose
    public String scheduleDay;
    @SerializedName("scheduleTime")
    @Expose
    public String scheduleTime;
    @SerializedName("ScheduleEndTime")
    @Expose
    public String scheduleEndTime;
    @SerializedName("startTime")
    @Expose
    public String startTime;
    @SerializedName("endTime")
    @Expose
    public String endTime;

    public Integer getInstNo() {
        return instNo;
    }

    public void setInstNo(Integer instNo) {
        this.instNo = instNo;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getActvityID() {
        return actvityID;
    }

    public void setActvityID(String actvityID) {
        this.actvityID = actvityID;
    }

    public String getFacilityNum() {
        return facilityNum;
    }

    public void setFacilityNum(String facilityNum) {
        this.facilityNum = facilityNum;
    }

    public String getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(String scheduleDay) {
        this.scheduleDay = scheduleDay;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getScheduleEndTime() {
        return scheduleEndTime;
    }

    public void setScheduleEndTime(String scheduleEndTime) {
        this.scheduleEndTime = scheduleEndTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}