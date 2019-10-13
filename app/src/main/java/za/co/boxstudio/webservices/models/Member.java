package za.co.boxstudio.webservices.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member {

    @SerializedName("memberID")
    @Expose
    public String memberID;
    @SerializedName("memberName")
    @Expose
    public String memberName;
    @SerializedName("memberSurname")
    @Expose
    public String memberSurname;
    @SerializedName("membershipID")
    @Expose
    public String membershipID;
    @SerializedName("memberContact")
    @Expose
    public String memberContact;
    @SerializedName("memberEmail")
    @Expose
    public String memberEmail;
    @SerializedName("memberAddress")
    @Expose
    public String memberAddress;
    @SerializedName("memberGender")
    @Expose
    public String memberGender;
    @SerializedName("approved_YN")
    @Expose
    public String approvedYN;
    @SerializedName("memberDOB")
    @Expose
    public String memberDOB;
    @SerializedName("approvedBy")
    @Expose
    public String approvedBy;
    @SerializedName("approvalDate")
    @Expose
    public String approvalDate;
    @SerializedName("deleted_YN")
    @Expose
    public Integer deletedYN;
    @SerializedName("dateDeleted_D")
    @Expose
    public String dateDeletedD;
    @SerializedName("deletedBy_C")
    @Expose
    public String deletedByC;
    @SerializedName("password")
    @Expose
    public String password;

    public Member(String memberID, String memberName, String memberSurname, String memberEmail, String password) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.memberEmail = memberEmail;
        this.password = password;
        this.membershipID = memberID;
        this.memberContact = "";
        this.memberAddress = "";
        this.memberGender = "";
        this.approvedYN = "";
        this.memberDOB = "";
        this.approvedBy = "";
        this.approvalDate = "";
        this.deletedYN = 0;
        this.dateDeletedD = "";
        this.deletedByC = "";
    }
}