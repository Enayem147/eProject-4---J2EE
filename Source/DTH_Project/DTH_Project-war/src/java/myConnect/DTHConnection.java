/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myConnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author r0cklee147
 */
public class DTHConnection {
    Connection conn = null;
    public Connection getDTHConnect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=RDTH;","sa","sa");
        } catch (Exception e) {
        }
        return conn;
    }
}
