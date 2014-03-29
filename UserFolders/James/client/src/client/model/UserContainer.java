package client.model;

public class UserContainer {
    //User ID Number
    private int uid;
    //User Information
    private String username;
    private String password;
    private String email;

    public UserContainer(int inUid, String inName, String inPassword, String inEmail) {
        //init
        uid = inUid;
        username = inName;
        password = inPassword;
        email = inEmail;
    }
    //UID
    public void setUid(int inUid) {
        uid = inUid;
    }
    public int getUid() {
        return uid;
    }
    //Username
    public void setUsername(String inName) {
        username = inName;
    }
    public String getUsername() {
        return username;
    }
    //Password
    public void setPassword(String inPassword) {
        password = inPassword;
    }
    public String getPassword() {
        return password;
    }
    //E-Mail
    public void setEmail(String inEmail) {
        email = inEmail;
    }
    public String getEmail() {
        return email;
    }

}
