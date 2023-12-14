package com.mycompany.ql_noithat.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuditDb {
  public List<Audit> getAuditByTableName(String tableName) {
    List<Audit> audits = new ArrayList<>();
    try {
      PreparedStatement statement = DB.getConnect()
          .prepareStatement("SELECT * FROM DBA_AUDIT_TRAIL WHERE OBJ_NAME = ?");
      statement.setString(1, tableName);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Audit audit = new Audit();
        audit.setUsername(resultSet.getString(("USERNAME")));
        audit.setHost(resultSet.getString(("USERHOST")));
        audit.setTable(resultSet.getString(("OBJ_NAME")));
        audit.setTime(resultSet.getString(("EXTENDED_TIMESTAMP")));
        audit.setAction(resultSet.getString(("ACTION_NAME")));

        audits.add(audit);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return audits;
  }
}
