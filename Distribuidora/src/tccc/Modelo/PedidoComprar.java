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
public class PedidoComprar {    
    
    private int id_compra=0;
    private int id_produto=0;
    private int id_fornecedor=0;
    private String fornecedor_nome;
    private String produto_nome;
    private String marca_nome;
    private String status;
    private double valor_custo=0.0;
    private double valor_unitario=0.0;
    private double frete=0.0;
    private double desconto=0.0;
    private double descontoporcentagem=0.0;
    private int quantidade=0;
    private double valor_totalitem=0.0;
    private double valor_totalpedido=0.0;
    private Date data;
    private Time hora;

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the id_fornecedor
     */
    public int getId_fornecedor() {
        return id_fornecedor;
    }

    /**
     * @param id_fornecedor the id_fornecedor to set
     */
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    /**
     * @return the valor_custo
     */
    public double getValor_custo() {
        return valor_custo;
    }

    /**
     * @param valor_custo the valor_custo to set
     */
    public void setValor_custo(double valor_custo) {
        this.valor_custo = valor_custo;
    }

    /**
     * @return the valor_unitario
     */
    public double getValor_unitario() {
        return valor_unitario;
    }

    /**
     * @param valor_unitario the valor_unitario to set
     */
    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    /**
     * @return the frete
     */
    public double getFrete() {
        return frete;
    }

    /**
     * @param frete the frete to set
     */
    public void setFrete(double frete) {
        this.frete = frete;
    }

    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the descontoporcentagem
     */
    public double getDescontoporcentagem() {
        return descontoporcentagem;
    }

    /**
     * @param descontoporcentagem the descontoporcentagem to set
     */
    public void setDescontoporcentagem(double descontoporcentagem) {
        this.descontoporcentagem = descontoporcentagem;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valor_totalitem
     */
    public double getValor_totalitem() {
        return valor_totalitem;
    }

    /**
     * @param valor_totalitem the valor_totalitem to set
     */
    public void setValor_totalitem(double valor_totalitem) {
        this.valor_totalitem = valor_totalitem;
    }

    /**
     * @return the valortotal_pedido
     */
    public double getValortotal_pedido() {
        return valor_totalpedido;
    }

    /**
     * @param valortotal_pedido the valortotal_pedido to set
     */
    public void setValortotal_pedido(double valortotal_pedido) {
        this.valor_totalpedido = valortotal_pedido;
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
     * @return the id_compra
     */
    public int getId_compra() {
        return id_compra;
    }

    /**
     * @param id_compra the id_compra to set
     */
    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    /**
     * @return the fornecedor_nome
     */
    public String getFornecedor_nome() {
        return fornecedor_nome;
    }

    /**
     * @param fornecedor_nome the fornecedor_nome to set
     */
    public void setFornecedor_nome(String fornecedor_nome) {
        this.fornecedor_nome = fornecedor_nome;
    }

    /**
     * @return the produto_nome
     */
    public String getProduto_nome() {
        return produto_nome;
    }

    /**
     * @param produto_nome the produto_nome to set
     */
    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    /**
     * @return the marca_nome
     */
    public String getMarca_nome() {
        return marca_nome;
    }

    /**
     * @param marca_nome the marca_nome to set
     */
    public void setMarca_nome(String marca_nome) {
        this.marca_nome = marca_nome;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }  
}
