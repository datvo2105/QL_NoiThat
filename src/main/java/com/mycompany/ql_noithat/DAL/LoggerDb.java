package com.mycompany.ql_noithat.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoggerDb {
    public List<Logger> getAllLoggers() {
        List<Logger> Loggers = new ArrayList<>();
        try {
            PreparedStatement statement = DB.getConnect().prepareStatement(
                    "SELECT * FROM DEV.LOGIN_LOG");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Logger logger = new Logger();
                logger.setLog_id(resultSet.getString(1));
                logger.setUser_name(resultSet.getString(2));
                logger.setTime(resultSet.getString(3));

                Loggers.add(logger);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Loggers;
    }

}
