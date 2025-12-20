import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Login");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            dao.inserirUsuario(nome, email, senha);
            System.out.println("Usuário cadastrado");

        } else if (op == 2) {
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (dao.login(email, senha)) {
                System.out.println("Login OK");
            } else {
                System.out.println("Credenciais inválidas");
            }
        }

        sc.close();
    }
}