package tccc.Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Efraim
 */
public class Estoque {
    private int id_estoque;
    private String produtoNome;
    private String fornecedorNome;
    private double valorcompra;
    private double valorvenda;
    private double lucroporcentagem;
    private double lucro;
    private int quantidadeComprada;
    private int quantidadeAtual;
    private String status;
    private Time hora;
    private Date data;

    /**
     * @return the id_estoque
     */
    public int getId_estoque() {
        return id_estoque;
    }

    /**
     * @param id_estoque the id_estoque to set
     */
    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    /**
     * @return the produtoNome
     */
    public String getProdutoNome() {
        return produtoNome;
    }

    /**
     * @param produtoNome the produtoNome to set
     */
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    /**
     * @return the fornecedorNome
     */
    public String getFornecedorNome() {
        return fornecedorNome;
    }

    /**
     * @param fornecedorNome the fornecedorNome to set
     */
    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }

    /**
     * @return the valorcompra
     */
    public double getValorcompra() {
        return valorcompra;
    }

    /**
     * @param valorcompra the valorcompra to set
     */
    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    /**
     * @return the valorvenda
     */
    public double getValorvenda() {
        return valorvenda;
    }

    /**
     * @param valorvenda the valorvenda to set
     */
    public void setValorvenda(double valorvenda) {
        this.valorvenda = valorvenda;
    }

    /**
     * @return the lucroporcentagem
     */
    public double getLucroporcentagem() {
        return lucroporcentagem;
    }

    /**
     * @param lucroporcentagem the lucroporcentagem to set
     */
    public void setLucroporcentagem(double lucroporcentagem) {
        this.lucroporcentagem = lucroporcentagem;
    }

    /**
     * @return the lucro
     */
    public double getLucro() {
        return lucro;
    }

    /**
     * @param lucro the lucro to set
     */
    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    /**
     * @return the quantidadeComprada
     */
    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    /**
     * @param quantidadeComprada the quantidadeComprada to set
     */
    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    /**
     * @return the quantidadeAtual
     */
    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    /**
     * @param quantidadeAtual the quantidadeAtual to set
     */
    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
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
    
}
