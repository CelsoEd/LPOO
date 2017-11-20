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
public class TesteViagemDAOaltera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Viagem viagem=new Viagem();
        viagem.setIdViagem(1);
        viagem.setOrigem("asfdsdfsdfsd");
        viagem.setDestino("ASDAFSD");
        viagem.setTotalViagem(4545645.33);
        
        System.out.println(ViagemDAO.altera(viagem));
               
    }
    
}
