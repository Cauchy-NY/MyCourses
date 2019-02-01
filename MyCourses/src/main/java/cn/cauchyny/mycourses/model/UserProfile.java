package cn.cauchyny.mycourses.model;

public class UserProfile {

    private String userId;
    private String userName;
    private String backupEmail;
    private String state;

    public UserProfile() {}

    public UserProfile(String userId, String userName, String backupEmail, String state) {
        this.userId = userId;
        this.userName = userName;
        this.backupEmail = backupEmail;
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBackupEmail() {
        return backupEmail;
    }

    public void setBackupEmail(String backupEmail) {
        this.backupEmail = backupEmail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
