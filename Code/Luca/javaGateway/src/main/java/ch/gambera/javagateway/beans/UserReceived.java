package ch.gambera.javagateway.beans;

public class UserReceived {
    public UserReceived(){

    }

    public int getpKUsers() {
        return pKUsers;
    }

    public void setpKUsers(int pkUsers) {
        this.pKUsers = pkUsers;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    private int pKUsers;
    private int admin;
}
