package Controller;

import Model.Viagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class ViagemDAO {
    
    public static List<Viagem> leTodos() {
        List<Viagem> viagem1 = null;
        try {
           Connection cn = GerenteDeConexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery( "SELECT * FROM Viagem ");
            viagem1 = new ArrayList<Viagem>();
            while (rs.next()) {
                Viagem viagem = new Viagem();
                viagem.setIdViagem(rs.getInt("idViagem"));
                viagem.setOrigem(rs.getString("Origem"));
                viagem.setDestino(rs.getString("Destino"));
                viagem.setTotalViagem(rs.getDouble("TotalViagem"));
                
                /**
                viagem.setCliente(ClienteDAO.leUm(rs.getInt("Cliente_idCliente")));
                viagem.setMotorista(MotoristaDAO.leUm(rs.getInt("Motorista_idMotorista")));                
                */
                
                viagem1.add(viagem);
                 
             
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return viagem1;
    }

    public static Viagem leUm(int codigo) {
        Viagem viagem = new Viagem();
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM viagem WHERE idViagem = ?");
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                viagem = new Viagem();
                viagem.setIdViagem(rs.getInt("idViagem"));
                viagem.setOrigem(rs.getString("Origem"));
                viagem.setDestino(rs.getString("Destino"));
                viagem.setTotalViagem(rs.getDouble("TotalViagem"));
                
                /*
                viagem.setCliente(ClienteDAO.leUm(rs.getInt("Cliente_idCliente")));
                viagem.setMotorista(MotoristaDAO.leUm(rs.getInt("Motorista_idMotorista")));
                */
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return viagem;
    }

    public static int grava(Viagem viagem) {

        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "INSERT INTO viagem (Origem, Destino, TotalViagem) VALUES (?, ?, ?)");         /**, Cliente_idCliente, Motorista_idMotorista*/
            pstm.setString(1, viagem.getOrigem());
            pstm.setString(2, viagem.getDestino());
            pstm.setDouble(3, viagem.getTotalViagem());
            
            /*
            ClienteDAO.grava(5,viagem.getCliente());
            MotoristaDAO.grava(6,viagem.getMotorista());
                    */
            ret = pstm.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

    public static int altera(Viagem viagem) {
        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE viagem SET  Origem = ?, Destino = ?, TotalViagem = ? WHERE idViagem = ?"); //*,Clinet_idCliente = ?, Motorista_idMotorista = ? */
            pstm.setInt(4, viagem.getIdViagem());
            pstm.setString(1, viagem.getOrigem());
            pstm.setString(2, viagem.getDestino());
            pstm.setDouble(3, viagem.getTotalViagem());
            /*
            ClienteDAO.altera(viagem.getCliente());
            pstm.setInt(4, viagem.getCliente().getIdCliente());

            MotoristaDAO.altera(viagem.getMotorista());
            pstm.setInt(5, viagem.getMotorista().getIdMotorista());
            */
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }

 public static int exclui(int codigo) {
        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "DELETE FROM viagem WHERE idViagem = ?");
            pstm.setInt(1, codigo);
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
    
    
}
