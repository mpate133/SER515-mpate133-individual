package DesignPattern;

public class UserInfoItem {
    private int userType;
    private String userName;
    private String userPassword;

    public UserInfoItem(int userType, String userName, String userPassword){
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserType(){
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return userPassword;
    }
}
