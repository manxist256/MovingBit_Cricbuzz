/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mankank
 */
public class CricketScoresJDBC {
    //should be passed dynamically from client side.
    private static final int MATCH_ID = 94512;
    public static String getScores() throws ClassNotFoundException, SQLException{
        String query = "select * from matchinfo where Matchid = " + MATCH_ID;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/Cricket","kbk","ytkd0CSIK656f2ZL");
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        return "India : " + rs.getString(2) + "<br/>" + "Australia : " + rs.getString(3);
    }
    public static String getNews() throws ClassNotFoundException, SQLException{
        String query = "select * from matchinfo where Matchid = " + MATCH_ID;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/Cricket","kbk","ytkd0CSIK656f2ZL");
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        return rs.getString(4);
    }
}
