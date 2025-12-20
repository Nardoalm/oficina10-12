import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login") // bate com o action do HTML
public class Main extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pega os dados do formulário
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        // só pra testar no console
        System.out.println("Email: " + email + ", Senha: " + senha);

        // resposta pro usuário
        response.setContentType("text/html");
        response.getWriter().println("<h1>Login Recebido!</h1>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("<p>Senha: " + senha + "</p>");
    }
}
