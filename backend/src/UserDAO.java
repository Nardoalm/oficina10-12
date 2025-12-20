import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public void inserirUsuario(String name, String email, String senha) {
        String senhaHash = PasswordUtils.hash(senha);

        String sql = "INSERT INTO users (name, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, senhaHash);
            ps.executeUpdate();

            System.out.println("Usuário inserido com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String senha) {
        String sql = "SELECT senha FROM users WHERE email = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaBanco = rs.getString("senha");
                String senhaHash = PasswordUtils.hash(senha);
                return senhaBanco.equals(senhaHash);
            }

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
