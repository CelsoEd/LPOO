package Model;

import java.sql.Date;
import java.sql.Timestamp;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Win 10
 */
public class FormaDePagamento {
    
    private int id;
    private String data;
    private Viagem viagem;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public FormaDePagamento() {
    }

    public FormaDePagamento(int id, String data, Viagem viagem) {
        this.id = id;
        this.data = data;
        this.viagem = viagem;
    }    
    
    public FormaDePagamento(Viagem viagem) {
        this.viagem = viagem;
    }
    
    
    
    //public abstract void PagamentoMotorista(Viagem viagem,Motorista motorista);   

    @Override
    public String toString() {
        return "data=" + getData();
    }

    
    
}
