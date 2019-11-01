package main.java.com.erp.model;

import main.java.com.erp.controller.service.ServerProperties;

public class ServerDetails {

    private String url;

    private String dbName;

    private String username;

    private String password;

    public ServerDetails(ServerProperties serverProperties) {
        this.url = serverProperties.getUrl();
        this.dbName = serverProperties.getDbName();
        this.username = serverProperties.getUsername();
        this.password = serverProperties.getPassword();
        //System.out.println(url+dbName);
    }

    public ServerDetails(String url, String dbName, String username, String password) {
        this.url = url;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getDbname() {
        return dbName;
    }

    public String getUrl() {
        return url;
    }
}
