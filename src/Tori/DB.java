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

public String levag(String s, int n) {
        return s.length() > n ? s.substring(0, n) : s;
    }

public int szam (String s) {
    int n;
    try {
        n = Integer.parseInt(s);
        return n;
    } catch (NumberFormatException e) {
        return 0;
        }
    }

public int hozzaad(String tema, String ev, String esemeny) {
        if (tema.isEmpty() || ev.isEmpty() || esemeny.isEmpty())
            return 0;
        int m = szam(ev);
        if (m == 0)
            return 0;
        String s = "INSERT INTO evszamok (tema, ev, esemeny) "
                + "VALUES(?,?,?);";
        try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
                PreparedStatement parancs = kapcs.prepareStatement(s)) {
            parancs.setString(1, levag(tema.trim(), 10));
            parancs.setInt(2, m);
            parancs.setString(3, levag(esemeny.trim(), 80));
            return parancs.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
}
