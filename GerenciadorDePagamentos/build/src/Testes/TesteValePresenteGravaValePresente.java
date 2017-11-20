/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Testes;

import Model.ValePresente;
import Controller.ValePresenteDAO;

/**
 *
 * @author EDUARDO
 */
public class TesteValePresenteGravaValePresente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ValePresente vp=new ValePresente();
        vp.setCodigo("a3");
        vp.setValor(50.00);
        //ValePresenteDAO.gravaValePresente(vp);
    }
    
}
