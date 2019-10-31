package main.java.com.erp.model;

public class Server {

    private String url;

    protected String username;

    protected String password;

    public Server(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String databaseName;

}
