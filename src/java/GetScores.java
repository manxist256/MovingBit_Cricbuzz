/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.CricketScoresJDBC;

/**
 *
 * @author mankank
 */
@WebServlet(urlPatterns = {"/GetScores"})
public class GetScores extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, ServletException {
        String scores = null;
        try {
            scores = CricketScoresJDBC.getScores();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GetScores.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter pw = response.getWriter();
        pw.println(scores);
    }
    
}
