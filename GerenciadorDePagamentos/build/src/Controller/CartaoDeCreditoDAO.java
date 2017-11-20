/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CartaoDeCredito;
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
public class CartaoDeCreditoDAO {

    public static List<CartaoDeCredito> leTodos() {
        List<CartaoDeCredito> cartaodecredito1 = null;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM CartaoDeCredito");
            cartaodecredito1 = new ArrayList<CartaoDeCredito>();
            while (rs.next()) {
                CartaoDeCredito cartaodecredito = new CartaoDeCredito();
                cartaodecredito.setId(rs.getInt("idCartaoDeCredito"));
                cartaodecredito.setNumCartao(rs.getInt("NumCartao"));
                cartaodecredito.setCVV(rs.getInt("CVV"));
                cartaodecredito.setNomeTitular(rs.getString("NomeTitular"));
                cartaodecredito.setVencimentoCartao(rs.getString("VencimentoCartao"));//pode da erro tipo de variavel date string
                FormaDePagamentoDAO.leUm(rs.getInt("FormaDePagamento_idFormaDePagamento"));
                
                
                //cartaodecredito.setDestino(rs.getString("Destino"));
                //cartaodecredito.setTotalCartaoDeCredito(rs.getDouble("TotalCartaoDeCredito"));               

                cartaodecredito1.add(cartaodecredito);

            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return cartaodecredito1;
    }

    public static CartaoDeCredito leUm(int codigo) {
        CartaoDeCredito cartaodecredito = new CartaoDeCredito();
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM CartaoDeCredito as cc join FormaDePagamento as fp on fp.idFormaDePagamento = cc.FormaDePagamento_idFormaDePagamento WHERE idCartaoDeCredito = ?");
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                cartaodecredito = new CartaoDeCredito();
                cartaodecredito.setId(rs.getInt("idCartaoDeCredito"));
                cartaodecredito.setNumCartao(rs.getInt("NumCartao"));
                cartaodecredito.setCVV(rs.getInt("CVV"));
                cartaodecredito.setNomeTitular(rs.getString("NomeTitular"));
                cartaodecredito.setVencimentoCartao(rs.getString("VencimentoCartao"));//pode da erro tipo de variavel date string

                cartaodecredito.setData(rs.getString("DataHora"));

                cartaodecredito.setViagem(ViagemDAO.leUm(rs.getInt("Viagem_idViagem")));

                /*
                 cartaodecredito.setCliente(ClienteDAO.leUm(rs.getInt("Cliente_idCliente")));
                 cartaodecredito.setMotorista(MotoristaDAO.leUm(rs.getInt("Motorista_idMotorista")));
                 */
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return cartaodecredito;
    }

    //vai bugar bunito
    public static int grava(CartaoDeCredito cartaodecredito) throws SQLException {
        int ret = 0;
        try {
            FormaDePagamentoDAO.grava();

            Connection cn = GerenteDeConexao.criaConexao();
            ResultSet rs;
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT idFormaDePagamento  FROM FormaDePagamento ORDER BY idFormaDePagamento DESC LIMIT 1");
            rs = pstm.executeQuery();

            if (rs.next()) {
                PreparedStatement ps2 = cn.prepareStatement("INSERT INTO cartaodecredito (NumCartao, CVV, NomeTitular,VencimentoCartao,FormaDePagamento_idFormaDePagamento) VALUES (?, ?,?, ?,?)");
                /**
                 * , Cliente_idCliente, Motorista_idMotorista
                 */
                ps2.setInt(1, cartaodecredito.getNumCartao());
                ps2.setInt(2, cartaodecredito.getCVV());
                ps2.setString(3, cartaodecredito.getNomeTitular());
                ps2.setString(4, cartaodecredito.getVencimentoCartao());
                
                ps2.setInt(5, rs.getInt("idFormaDePagamento"));
                ret = ps2.executeUpdate();
            }

            /*
             ClienteDAO.grava(5,cartaodecredito.getCliente());
             MotoristaDAO.grava(6,cartaodecredito.getMotorista());
            
             GRAVADO NA ViagemDAO
             */
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return ret;
    }
        
}
