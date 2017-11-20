package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public class GerenteDeConexao {

    public static Connection criaConexao() throws SQLException {
        Connection cn = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Driver carregado!!!");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/GerenciadorDePagamento",
                    "root", "");
            System.out.println("Conexão efetuada com sucesso!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
        }
        return cn;
    }
}
