/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ql_noithat;

import com.mycompany.ql_noithat.DAL.DB;
import com.mycompany.ql_noithat.GUI.MainFrame;

public class QL_NoiThat {

    public static void main(String[] args) {
        try {
            DB.server = "0.tcp.ap.ngrok.io:17186:noithat";
            DB.user = "dev";
            DB.pass = "1";
            var conn = DB.getConnect();

            if (conn == null)
                throw new Error("connect faild");
            new MainFrame().setVisible(true);
        } catch (Exception e) {

        }
    }
}
