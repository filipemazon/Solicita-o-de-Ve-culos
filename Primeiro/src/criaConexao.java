import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class criaConexao {

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao banco...");
            return DriverManager.getConnection("jdbc:mysql://172.16.3.4/transporte", "transpadm", "4dmn1s1s");
            //return DriverManager.getConnection("jdbc:mysql://localhost/transporte", "root", "");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}