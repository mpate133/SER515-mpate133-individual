package DesignPattern;

public class UserInfoItem {
    private final int userType;
    private final String username;
    private final String userPassword;

    public UserInfoItem(int userType, String username, String userPassword){
        this.userType = userType;
        this.username = username;
        this.userPassword = userPassword;
    }

    @SuppressWarnings(value = "unused")
    public int getUserType(){
        return userType;
    }

    @SuppressWarnings(value = "unused")
    public String getUserName() {
        return username;
    }

    @SuppressWarnings(value = "unused")
    public String getPassword() {
        return userPassword;
    }
}
