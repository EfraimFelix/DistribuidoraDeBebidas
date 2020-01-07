/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.Modelo;

/**
 *
 * @author Efraim
 */
public class Usuario {
    private int id_usuario;
    private String nome;
    private String email;
    private String tipoconta;
    private String senha;
    private String senhaAntiga;

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tipoconta
     */
    public String getTipoconta() {
        return tipoconta;
    }

    /**
     * @param tipoconta the tipoconta to set
     */
    public void setTipoconta(String tipoconta) {
        this.tipoconta = tipoconta;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the senhaAntiga
     */
    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    /**
     * @param senhaAntiga the senhaAntiga to set
     */
    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }
}
