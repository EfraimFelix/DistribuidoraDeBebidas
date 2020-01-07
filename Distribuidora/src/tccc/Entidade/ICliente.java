package tccc.Entidade;

import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.Cliente;
public interface ICliente {
    
    List<Cliente> Lista ();
    
    List<Cliente> getLista(String campo, String inf);
    
    // tem como parametro uma tabela, e com este parametro lista ela com os dados pegados
    List<Cliente> ListarTabela (JXTable Tbl);
    
    public void BuscarClienteID (int Id, Cliente c);
   
    public void adicionar (Cliente c);
    
    public void Alterar (Cliente c);
    
    public void Pesquisar (String campo, String inf, JXTable Tbl);
    
    public void Remover (int Id);
    
    public void Relatorio ();
    
    public void ChamaRelatorio ();
}
