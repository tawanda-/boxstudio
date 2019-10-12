package za.co.boxstudio.Webservices.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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
    @SerializedName("UserName")
    @Expose
    public String userName;
    @SerializedName("staffName")
    @Expose
    public String staffName;
    @SerializedName("staffSurname")
    @Expose
    public String staffSurname;
    @SerializedName("positionID")
    @Expose
    public String positionID;
    @SerializedName("staffContact")
    @Expose
    public String staffContact;
    @SerializedName("staffEmail")
    @Expose
    public String staffEmail;
    @SerializedName("staffAddress")
    @Expose
    public String staffAddress;
    @SerializedName("dateCreated_D")
    @Expose
    public String dateCreatedD;
    @SerializedName("createdBy_C")
    @Expose
    public String createdByC;
    @SerializedName("deleted_YN")
    @Expose
    public Integer deletedYN;
    @SerializedName("dateDeleted_D")
    @Expose
    public Object dateDeletedD;
    @SerializedName("deletedBy_C")
    @Expose
    public Object deletedByC;
    @SerializedName("actvityName")
    @Expose
    public String actvityName;
    @SerializedName("actvityType")
    @Expose
    public String actvityType;
    @SerializedName("FacilityName")
    @Expose
    public String facilityName;
    @SerializedName("FacilityCost")
    @Expose
    public Object facilityCost;
    @SerializedName("MaxCapacity")
    @Expose
    public Object maxCapacity;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSurname() {
        return staffSurname;
    }

    public void setStaffSurname(String staffSurname) {
        this.staffSurname = staffSurname;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public String getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(String staffContact) {
        this.staffContact = staffContact;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getDateCreatedD() {
        return dateCreatedD;
    }

    public void setDateCreatedD(String dateCreatedD) {
        this.dateCreatedD = dateCreatedD;
    }

    public String getCreatedByC() {
        return createdByC;
    }

    public void setCreatedByC(String createdByC) {
        this.createdByC = createdByC;
    }

    public Integer getDeletedYN() {
        return deletedYN;
    }

    public void setDeletedYN(Integer deletedYN) {
        this.deletedYN = deletedYN;
    }

    public Object getDateDeletedD() {
        return dateDeletedD;
    }

    public void setDateDeletedD(Object dateDeletedD) {
        this.dateDeletedD = dateDeletedD;
    }

    public Object getDeletedByC() {
        return deletedByC;
    }

    public void setDeletedByC(Object deletedByC) {
        this.deletedByC = deletedByC;
    }

    public String getActvityName() {
        return actvityName;
    }

    public void setActvityName(String actvityName) {
        this.actvityName = actvityName;
    }

    public String getActvityType() {
        return actvityType;
    }

    public void setActvityType(String actvityType) {
        this.actvityType = actvityType;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Object getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(Object facilityCost) {
        this.facilityCost = facilityCost;
    }

    public Object getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Object maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(getInstNo(), schedule.getInstNo()) &&
                Objects.equals(getScheduleID(), schedule.getScheduleID()) &&
                Objects.equals(getStaffID(), schedule.getStaffID()) &&
                Objects.equals(getActvityID(), schedule.getActvityID()) &&
                Objects.equals(getFacilityNum(), schedule.getFacilityNum()) &&
                Objects.equals(getScheduleDay(), schedule.getScheduleDay()) &&
                Objects.equals(getScheduleTime(), schedule.getScheduleTime()) &&
                Objects.equals(getScheduleEndTime(), schedule.getScheduleEndTime()) &&
                Objects.equals(getStartTime(), schedule.getStartTime()) &&
                Objects.equals(getEndTime(), schedule.getEndTime()) &&
                Objects.equals(getUserName(), schedule.getUserName()) &&
                Objects.equals(getStaffName(), schedule.getStaffName()) &&
                Objects.equals(getStaffSurname(), schedule.getStaffSurname()) &&
                Objects.equals(getPositionID(), schedule.getPositionID()) &&
                Objects.equals(getStaffContact(), schedule.getStaffContact()) &&
                Objects.equals(getStaffEmail(), schedule.getStaffEmail()) &&
                Objects.equals(getStaffAddress(), schedule.getStaffAddress()) &&
                Objects.equals(getDateCreatedD(), schedule.getDateCreatedD()) &&
                Objects.equals(getCreatedByC(), schedule.getCreatedByC()) &&
                Objects.equals(getDeletedYN(), schedule.getDeletedYN()) &&
                Objects.equals(getDateDeletedD(), schedule.getDateDeletedD()) &&
                Objects.equals(getDeletedByC(), schedule.getDeletedByC()) &&
                Objects.equals(getActvityName(), schedule.getActvityName()) &&
                Objects.equals(getActvityType(), schedule.getActvityType()) &&
                Objects.equals(getFacilityName(), schedule.getFacilityName()) &&
                Objects.equals(getFacilityCost(), schedule.getFacilityCost()) &&
                Objects.equals(getMaxCapacity(), schedule.getMaxCapacity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInstNo(), getScheduleID(), getStaffID(), getActvityID(), getFacilityNum(), getScheduleDay(), getScheduleTime(), getScheduleEndTime(), getStartTime(), getEndTime(), getUserName(), getStaffName(), getStaffSurname(), getPositionID(), getStaffContact(), getStaffEmail(), getStaffAddress(), getDateCreatedD(), getCreatedByC(), getDeletedYN(), getDateDeletedD(), getDeletedByC(), getActvityName(), getActvityType(), getFacilityName(), getFacilityCost(), getMaxCapacity());
    }
}