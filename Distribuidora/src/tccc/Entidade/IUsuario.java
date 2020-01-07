/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.Entidade;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.Usuario;

/**
 *
 * @author Efraim
 */
public interface IUsuario {
    List<Usuario> Lista ();
    
    List<Usuario> getLista(String campo, String inf);
    
    // tem como parametro uma tabela, e com este parametro lista ela com os dados pegados
    List<Usuario> ListarTabela (JXTable Tbl);
    
    public void BuscarUsuarioID (int Id, Usuario u);
   
    public void adicionar (Usuario u);
    
    public void Alterar (Usuario u);
    
    public void Pesquisar (String campo, String inf, JXTable Tbl);
    
    public void Remover (int Id);
    
    public void Relatorio ();
    
    public void ChamaRelatorio ();
    
    public boolean VerificaUsuario (String Nome, String Senha);
}
