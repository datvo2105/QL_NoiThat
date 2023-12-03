/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ql_noithat;

import java.io.Console;

import com.mycompany.ql_noithat.DAL.Key;
import com.mycompany.ql_noithat.DAL.RSAManager;
import com.mycompany.ql_noithat.DAL.Sha;
import com.mycompany.ql_noithat.GUI.ConnectDB;
import com.mycompany.ql_noithat.GUI.MainFrame;

public class QL_NoiThat {

    public static void main(String[] args) {
        try {
            // new ConnectDB().setVisible(true);
            RSAManager rsa = new RSAManager(Key.private_key, Key.public_key);
            String encoding = rsa.encrypt("user@gmail.com");
            System.out.println(encoding);
            String decode = rsa.decrypt(encoding);
            System.out.println(decode);
        } catch (Exception e) {

        }
    }
}
