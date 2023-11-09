package com.mycompany.ql_noithat.DAL;

public class Logger {
    String log_id;
    String user_name;
    String time;

    public Logger(String log_id, String user_name, String time) {
        this.log_id = log_id;
        this.user_name = user_name;
        this.time = time;
    }

    public Logger() {
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
