/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Testes;

import Model.CartaoDeCredito;
import Model.Viagem;
import Controller.CartaoDeCreditoDAO;
import Controller.ViagemDAO;
import java.sql.SQLException;

/**
 *
 * @author EDUARDO
 */
public class TesteCartaoDeCreditoDAOgrava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Viagem viagem=new Viagem();
        viagem.setOrigem("aki");
        viagem.setDestino("ali");
        viagem.setTotalViagem(20.00);
        viagem.setCliente(null);
        viagem.setMotorista(null);      
        
        System.out.println(ViagemDAO.grava(viagem));
        CartaoDeCredito c = new CartaoDeCredito();
        c.setCVV(3333333);
        c.setNomeTitular("jo2232se");
        c.setNumCartao(234234);
        c.setVencimentoCartao("2012-02-02");
        CartaoDeCreditoDAO.grava(c);
    }
    
}
