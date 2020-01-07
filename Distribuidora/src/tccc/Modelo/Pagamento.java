/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Efraim
 */
public class Pagamento {

    /**
     * @return the id_pag
     */
    public int getId_pag() {
        return id_pag;
    }

    /**
     * @param id_pag the id_pag to set
     */
    public void setId_pag(int id_pag) {
        this.id_pag = id_pag;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private int idpedidovenda;
    private String tipopagamento;
    private double valorecebido;
    private double troco;
    private Time hora;
    private Date data;
    private int id_pag;
    private String descricao;

    /**
     * @return the idpedidovenda
     */
    public int getIdpedidovenda() {
        return idpedidovenda;
    }

    /**
     * @param idpedidovenda the idpedidovenda to set
     */
    public void setIdpedidovenda(int idpedidovenda) {
        this.idpedidovenda = idpedidovenda;
    }

    /**
     * @return the valorecebido
     */
    public double getValorecebido() {
        return valorecebido;
    }

    /**
     * @param valorecebido the valorecebido to set
     */
    public void setValorecebido(double valorecebido) {
        this.valorecebido = valorecebido;
    }

    /**
     * @return the troco
     */
    public double getTroco() {
        return troco;
    }

    /**
     * @param troco the troco to set
     */
    public void setTroco(double troco) {
        this.troco = troco;
    }

    /**
     * @return the hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the tipopagamento
     */
    public String getTipopagamento() {
        return tipopagamento;
    }

    /**
     * @param tipopagamento the tipopagamento to set
     */
    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
    }
}
