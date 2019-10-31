package main.java.com.erp.model;

public class LoggedAccount {

    private static String username;

    private static String password;

    public LoggedAccount(String username, String password) {
        this.username = username;
        this.password = password;
        //System.out.print(username + password);
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
