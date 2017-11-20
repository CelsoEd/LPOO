/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FormaDePagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class FormaDePagamentoDAO {

    public static int grava() throws SQLException {
        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            ResultSet rs;
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT idViagem  FROM Viagem ORDER BY idViagem DESC LIMIT 1");
            rs = pstm.executeQuery();

            if (rs.next()) {
                PreparedStatement ps2 = cn.prepareStatement("insert into FormaDePagamento(Viagem_idviagem) values (?)");
                //FALTA DATA
                ps2.setInt(1, rs.getInt("idViagem"));
                ret = ps2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL2" + e);
        }
        return ret;

    }

    public static FormaDePagamento leUm(int codigo) throws SQLException {
        FormaDePagamento formaDePagamento = new FormaDePagamento();
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM FormaDePagamento WHERE idFormaDePagamento = ?");
            pstm.setInt(1, codigo);
            ResultSet rs2 = pstm.executeQuery();
            if (rs2.next()) {
                formaDePagamento = new FormaDePagamento();
                formaDePagamento.setId(rs2.getInt("idFormaDePagamento"));
                formaDePagamento.setData (rs2.getString("DataHora"));
                formaDePagamento.setViagem(ViagemDAO.leUm(rs2.getInt("Viagem_idViagem")));
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return formaDePagamento;
    }
    
    public static List<FormaDePagamento> leTodos() throws SQLException {
        List<FormaDePagamento> formadepagamento1 = null;
        try {            
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pstm = cn.prepareStatement(
                    "SELECT * FROM FormaDePagamento");
            formadepagamento1 = new ArrayList<FormaDePagamento>();
            
            ResultSet rs2 = pstm.executeQuery();
            while (rs2.next()) {                
                FormaDePagamento formaDePagamento = new FormaDePagamento();
                formaDePagamento.setId(rs2.getInt("idFormaDePagamento"));
                formaDePagamento.setData (rs2.getString("DataHora"));
                formaDePagamento.setViagem(ViagemDAO.leUm(rs2.getInt("Viagem_idViagem")));
                formadepagamento1.add(formaDePagamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return formadepagamento1;
    }
}
