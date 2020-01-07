/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.Entidade;

import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.Fornecedor;

/**
 *
 * @author Efraim
 */
public interface IFornecedor {
   List<Fornecedor> Lista ();
    
    List<Fornecedor> getLista(String campo, String inf);
    
    // tem como parametro uma tabela, e com este parametro lista ela com os dados pegados
    List<Fornecedor> ListarTabela (JXTable Tbl);
    
    public void BuscarFornecedorID (int Id, Fornecedor f);
   
    public void adicionar (Fornecedor f);
    
    public void Alterar (Fornecedor f);
    
    public void Pesquisar (String campo, String inf, JXTable Tbl);
    
    public void Remover (int Id);
    
    public void Relatorio ();
    
    public void ChamaRelatorio ();

}
