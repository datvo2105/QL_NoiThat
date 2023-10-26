package com.mycompany.ql_noithat.DAL;

import java.sql.CallableStatement;

public class RSAOracle {
    public String genarateKey() {
        try {
            String sql = "begin ? :=  CRYPTO.RSA_GENERATE_KEYS(KEY_SIZE => 1024); END;";
            CallableStatement cStatement = DB.getConnect().prepareCall(sql);
            cStatement.registerOutParameter(1, oracle.jdbc.OracleType.VARCHAR2);
            cStatement.execute();
            String kq = cStatement.getString(1);

            return kq;
        } catch (Exception e) {
            return null;
        }
    }

    public String encrypt(String planText, String publicKey) {
        try {
            String sql = "begin ? :=  CRYPTO.RSA_ENCRYPT(?,?); END;";
            CallableStatement cStatement = DB.getConnect().prepareCall(sql);
            cStatement.registerOutParameter(1, oracle.jdbc.OracleType.VARCHAR2);
            cStatement.setString(2, planText);
            cStatement.setString(3, publicKey);

            cStatement.execute();
            String kq = cStatement.getString(1);

            return kq;
        } catch (Exception e) {
            return null;
        }
    }

    public String decrypt(String encrypted, String privateKey) {
        try {
            String sql = "begin ? :=  CRYPTO.RSA_DECRYPT(?,?); END;";
            CallableStatement cStatement = DB.getConnect().prepareCall(sql);
            cStatement.registerOutParameter(1, oracle.jdbc.OracleType.VARCHAR2);
            cStatement.setString(2, encrypted);
            cStatement.setString(3, privateKey);

            cStatement.execute();
            String kq = cStatement.getString(1);

            return kq;
        } catch (Exception e) {
            return null;
        }
    }
}
