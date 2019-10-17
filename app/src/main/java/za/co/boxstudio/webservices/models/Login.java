package za.co.boxstudio.webservices.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("UserId")
    @Expose
    public String userId;
    @SerializedName("UserName")
    @Expose
    public String userName;
    @SerializedName("UserPass")
    @Expose
    public String userPass;
    @SerializedName("UserGroup")
    @Expose
    public String userGroup;
    @SerializedName("Change_Pass")
    @Expose
    public String changePass;
    @SerializedName("Num_Retries_N")
    @Expose
    public String numRetriesN;
    @SerializedName("dateCreated_D")
    @Expose
    public String dateCreatedD;
    @SerializedName("createdBy_C")
    @Expose
    public String createdByC;
    @SerializedName("Logged_In_YN")
    @Expose
    public String loggedInYN;
    @SerializedName("dateDeleted_D")
    @Expose
    public Object dateDeletedD;
    @SerializedName("deletedBy_C")
    @Expose
    public Object deletedByC;
    @SerializedName("deleted_YN")
    @Expose
    public Object deletedYN;
    @SerializedName("authCode")
    @Expose
    public Object authCode;

}
