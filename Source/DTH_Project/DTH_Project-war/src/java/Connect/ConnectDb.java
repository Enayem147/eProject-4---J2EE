/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class ConnectDb {
    Connection conn = null;
    public Connection connectMyWebDb(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=RDTH;","sa","sa");
        } catch (Exception e) {
        }
        return conn;
    }
}
