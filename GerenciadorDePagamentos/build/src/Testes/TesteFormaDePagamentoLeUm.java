/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Controller.FormaDePagamentoDAO;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class TesteFormaDePagamentoLeUm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        System.out.println(FormaDePagamentoDAO.leUm(1));
    }
    
}
