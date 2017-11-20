/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import View.jCadastrarViagem;
import static View.jCadastrarViagem.v1;
import View.jValePresente;
import Model.ValePresente;
import Controller.FormaDePagamentoDAO;
import Controller.GerenteDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author EDUARDO
 */
public class ValePresenteDAO {
    public static List<ValePresente> leTodos() {
        List<ValePresente> valepresente1 = null;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM ValePresente");
            valepresente1 = new ArrayList<ValePresente>();
            while (rs.next()) {
                ValePresente valepresente = new ValePresente();
                valepresente.setId(rs.getInt("idValePresente"));
                valepresente.setCodigo(rs.getString("Codigo"));
                valepresente.setValor(rs.getDouble("Valor"));
                
                FormaDePagamentoDAO.leUm(rs.getInt("FormaDePagamento_idFormaDePagamento"));
                
                
                //valepresente.setDestino(rs.getString("Destino"));
                //valepresente.setTotalValePresente(rs.getDouble("TotalValePresente"));               
                if(rs.getString("FormaDePagamento_idFormaDePagamento")==null){
                    valepresente1.add(valepresente);
                }       

            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return valepresente1;
    }

    public static List<ValePresente> PesquisaNome(String Codigo) {
        List<ValePresente> valepresente1 = null;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM ValePresente WHERE Codigo like ?");
            pstm.setString(1, Codigo);
            ResultSet rs = pstm.executeQuery();
        valepresente1 = new ArrayList<ValePresente>();
            while (rs.next()) {
                ValePresente valepresente = new ValePresente();
                valepresente.setId(rs.getInt("idValePresente"));
                valepresente.setCodigo(rs.getString("Codigo"));
                valepresente.setValor(rs.getDouble("Valor"));
                
                FormaDePagamentoDAO.leUm(rs.getInt("FormaDePagamento_idFormaDePagamento"));
                
                
                //valepresente.setDestino(rs.getString("Destino"));
                //valepresente.setTotalValePresente(rs.getDouble("TotalValePresente"));               

                valepresente1.add(valepresente);

            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return valepresente1;
    }
    
    public static ValePresente VerificaCodigo(String codigo) {
        int insercao = 0;
        ValePresente valepresente = new ValePresente();
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM ValePresente WHERE codigo = ?");
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {                
                if (rs.getString("FormaDePagamento_idFormaDePagamento")==null){
                    if(v1.getTotalViagem()<=rs.getDouble("valor")){
                        gravaViagem(codigo);
                        JOptionPane.showMessageDialog(null,"Viagem solicitada com suscesso\nAguarde o motorista.");                        
                        
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "O valor do Vale Presnte, não cobre o valor da Viagem");
                    }                
                }else{
                    JOptionPane.showMessageDialog(null, "O codigo ja esta em uso");
                }                
            }else{
                JOptionPane.showMessageDialog(null, "Codigo Invalido");
                
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return valepresente;
    }

    //vai bugar bunito
    public static int gravaViagem(String codigo) throws SQLException {
        int ret = 0;
        try {
            FormaDePagamentoDAO.grava();

            Connection cn = GerenteDeConexao.criaConexao();
            ResultSet rs;
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT idFormaDePagamento  FROM FormaDePagamento ORDER BY idFormaDePagamento DESC LIMIT 1");
            rs = pstm.executeQuery();

            if (rs.next()) {
                PreparedStatement ps2 = cn.prepareStatement("UPDATE valepresente SET  FormaDePagamento_idFormaDePagamento = ? WHERE codigo = ?");
                /**
                 * , Cliente_idCliente, Motorista_idMotorista
                 */
                                               
                ps2.setInt(1, rs.getInt("idFormaDePagamento"));
                ps2.setString(2, codigo);
                
                ret = ps2.executeUpdate();
            }

            /*
             ClienteDAO.grava(5,valepresente.getCliente());
             MotoristaDAO.grava(6,valepresente.getMotorista());
            
             GRAVADO NA ViagemDAO
             */
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
    
     public static ValePresente gravaCodigo(ValePresente valepresente) {
        int insercao = 0;
        
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM ValePresente WHERE codigo = ?");
            pstm.setString(1, valepresente.getCodigo());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {  
                JOptionPane.showMessageDialog(null, "O Codigo ja foi utilizado");      
                             
            }else{
            pstm = cn.prepareStatement("INSERT INTO ValePresente (Codigo, Valor) VALUES (?, ?)");
/**, Cliente_idCliente, Motorista_idMotorista*/
            pstm.setString(1, valepresente.getCodigo());
            pstm.setDouble(2, valepresente.getValor());
            
            /*
            ClienteDAO.grava(5,viagem.getCliente());
            MotoristaDAO.grava(6,viagem.getMotorista());
                    */
            pstm.executeUpdate();
                
                
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return valepresente;
    }
    
    public static int altera(ValePresente valePresente) {
        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "UPDATE valepresente SET  codigo = ?, valor =?  WHERE codigo = ?"); //*,Clinet_idCliente = ?, Motorista_idMotorista = ? */
            pstm.setString(1, valePresente.getCodigo());
            pstm.setDouble(2, valePresente.getValor());
            pstm.setString(3, valePresente.getCodigo());

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

 public static int exclui(String codigo) {
        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "DELETE FROM ValePresente WHERE codigo = ?");
            pstm.setString(1, codigo);
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
    
    
}
