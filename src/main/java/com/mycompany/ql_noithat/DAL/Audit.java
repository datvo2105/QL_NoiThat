package com.mycompany.ql_noithat.DAL;

public class Audit {
    String username;
    String dbName;
    String host;
    String time;
    String table;
    String action;

    public Audit() {
    }

    public Audit(String username, String dbName, String host, String time, String table, String action) {
        this.username = username;
        this.dbName = dbName;
        this.host = host;
        this.time = time;
        this.table = table;
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public String getDbName() {
        return dbName;
    }

    public String getHost() {
        return host;
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public String getTable() {
        return table;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
