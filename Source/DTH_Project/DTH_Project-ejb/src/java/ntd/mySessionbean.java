/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.Stateless;

/**
 *
 * @author r0cklee147
 */
@Stateless
public class mySessionbean implements mySessionbeanLocal {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public Integer getCityId() {
        int eventid = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=RDTH;", "sa", "sa");
            pst = conn.prepareStatement("select Max(News_ID) as id from News");
            rs = pst.executeQuery();
            if (rs.next()) {
                eventid = rs.getInt("id");
            }
        } catch (Exception e) {

        }
        return eventid;
    }

    @Override
    public Integer getNewsid() {
        int eventid = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=RDTH;", "sa", "sa");
            pst = conn.prepareStatement("select Max(News_ID) as id from News");
            rs = pst.executeQuery();
            if (rs.next()) {
                eventid = rs.getInt("id");
            }
        } catch (Exception e) {

        }
        return eventid;
    }

    @Override
    public Integer getCommentid() {
        int commentid = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=RDTH;", "sa", "sa");
            pst = conn.prepareStatement("select Max(CommentID) as id from Comment");
            rs = pst.executeQuery();
            if (rs.next()) {
                commentid = rs.getInt("id");
            }
        } catch (Exception e) {

        }
        return commentid;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Integer getEventid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
