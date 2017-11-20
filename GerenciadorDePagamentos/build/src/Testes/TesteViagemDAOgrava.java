/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Testes;

import Model.Viagem;
import Controller.ViagemDAO;

/**
 *
 * @author EDUARDO
 */
public class TesteViagemDAOgrava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Viagem viagem=new Viagem();
        viagem.setOrigem("SFDSD");
        viagem.setDestino("dfsdfsdsa");
        viagem.setTotalViagem(15003433.00);
        viagem.setCliente(null);
        viagem.setMotorista(null);      
        
        System.out.println(ViagemDAO.grava(viagem));
    }    
}
