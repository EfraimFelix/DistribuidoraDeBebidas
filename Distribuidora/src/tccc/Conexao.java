package tccc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {

   public Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/alpha_parnaiba", "teste", "123");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new Conexao().getConnection();
        System.out.println("Conexão criada com sucesso");
    }
    
}
