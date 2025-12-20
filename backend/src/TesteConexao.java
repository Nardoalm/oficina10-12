import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/appdb";
        String user = "appuser";
        String password = "SenhaForte@123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
