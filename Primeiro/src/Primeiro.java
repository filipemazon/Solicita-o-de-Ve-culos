import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;





public class Primeiro {

    public static void main(String[] args) throws SQLException {
          System.out.println("Programa Transporte");
          
      JOptionPane.showMessageDialog(null, "Por favor, evite o uso desnecessário da solicitação de veículos!  ");
          
      new FraSegundo().setVisible(true);
      
          
    }

   
 }
