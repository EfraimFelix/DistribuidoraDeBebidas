package tccc.Entidade;

import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.Estoque;
public interface IEstoque {
        
    List< Estoque> Lista ();
    
    List< Estoque> getLista(String campo, String inf);
    
    // tem como parametro uma tabela, e com este parametro lista ela com os dados pegados
    List< Estoque> ListarTabela (JXTable Tbl);
    
    public void BuscarEstoqueID (int Id,  Estoque e);
   
    public void adicionar ( Estoque e);
    
    public void Alterar ( Estoque e);
    
    public void Pesquisar (String campo, String inf, JXTable Tbl);
    
    public void Remover (int Id);
    
    public void Relatorio ();
    
    public void ChamaRelatorio ();
}