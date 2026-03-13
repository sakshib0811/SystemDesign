package Models;

public class User {
    String userId;
    String userName;
    String userEmail;
    String userPhnNo;

    public User(String userId, String userName, String userEmail, String userPhnNo) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhnNo = userPhnNo;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhnNo() {
        return userPhnNo;
    }

    public void setUserPhnNo(String userPhnNo) {
        this.userPhnNo = userPhnNo;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhnNo="
                + userPhnNo + "]";
    }

}
