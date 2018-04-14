package Tori;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabian Tamas 1.0
 */
public class DB {
    
     final String user = "tanulo";
     final String pass = "tanulo";
     String dbUrl = "jdbc:mysql://localhost:3306/tortenelem"
                    + "?useUnicode=true&characterEncoding=UTF-8";
     
public void beolvas (JTable tbl, String s) {
    final DefaultTableModel tm = (DefaultTableModel)tbl.getModel();
    
    try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement parancs = kapcs.prepareStatement(s);
            ResultSet eredmeny = parancs.executeQuery()) {
        tm.setRowCount(0);
        while (eredmeny.next()) {
            Object sor[] = {
                eredmeny.getInt("evID"),
                eredmeny.getString("tema"),
                eredmeny.getInt("ev"),
                eredmeny.getString("esemeny")
            };
            tm.addRow(sor);
        }
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(1);
        }
    }
}


