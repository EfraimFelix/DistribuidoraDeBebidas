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
public class PedidoVender {
     
    private int id_venda=0;
    private int id_produto=0;
    private String produto_descricao;
    private String marcaNome;
    private int id_cliente=0;
    private String cliente_nome;
    private int id_funcionario=0;
    private String funcionario_nome;
    private double valor_unitario=0.0;
    private double frete=0.0;
    private double desconto=0.0;
    private double descontoporcentagem=0.0;
    private int quantidade=0;
    private double valor_totalitem=0.0;
    private double valor_totalpedido=0.0;
    private String tipovenda;
    private String statusentrega;
    private String statuspagamento;
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
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_funcionario
     */
    public int getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
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
     * @return the valor_totalpedido
     */
    public double getValor_totalpedido() {
        return valor_totalpedido;
    }

    /**
     * @param valor_totalpedido the valor_totalpedido to set
     */
    public void setValor_totalpedido(double valor_totalpedido) {
        this.valor_totalpedido = valor_totalpedido;
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
     * @return the id_venda
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_venda to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    /**
     * @return the cliente_nome
     */
    public String getCliente_nome() {
        return cliente_nome;
    }

    /**
     * @param cliente_nome the cliente_nome to set
     */
    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    /**
     * @return the funcionario_nome
     */
    public String getFuncionario_nome() {
        return funcionario_nome;
    }

    /**
     * @param funcionario_nome the funcionario_nome to set
     */
    public void setFuncionario_nome(String funcionario_nome) {
        this.funcionario_nome = funcionario_nome;
    }

    /**
     * @return the tipovenda
     */
    public String getTipovenda() {
        return tipovenda;
    }

    /**
     * @param tipovenda the tipovenda to set
     */
    public void setTipovenda(String tipovenda) {
        this.tipovenda = tipovenda;
    }

    /**
     * @return the statusentrega
     */
    public String getStatusentrega() {
        return statusentrega;
    }

    /**
     * @param statusentrega the statusentrega to set
     */
    public void setStatusentrega(String statusentrega) {
        this.statusentrega = statusentrega;
    }

    /**
     * @return the statuspagamento
     */
    public String getStatuspagamento() {
        return statuspagamento;
    }

    /**
     * @param statuspagamento the statuspagamento to set
     */
    public void setStatuspagamento(String statuspagamento) {
        this.statuspagamento = statuspagamento;
    }

    /**
     * @return the produto_descricao
     */
    public String getProduto_descricao() {
        return produto_descricao;
    }

    /**
     * @param produto_descricao the produto_descricao to set
     */
    public void setProduto_descricao(String produto_descricao) {
        this.produto_descricao = produto_descricao;
    }

    /**
     * @return the marcaNome
     */
    public String getMarcaNome() {
        return marcaNome;
    }

    /**
     * @param marcaNome the marcaNome to set
     */
    public void setMarcaNome(String marcaNome) {
        this.marcaNome = marcaNome;
    }
}
