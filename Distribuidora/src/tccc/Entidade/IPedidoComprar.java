package tccc.Entidade;

import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.PedidoComprar;
import tccc.Modelo.PedidoComprar;
public interface IPedidoComprar {
        
   List<PedidoComprar> Lista ();
    
    List<PedidoComprar> getLista(String campo, String inf);
    
    // tem como parametro uma tabela, e com este parametro lista ela com os dados pegados
    List<PedidoComprar> ListarTabela (JXTable Tbl);
    
    public void BuscarPedidoComprarID (int Id, PedidoComprar pc);
   
    public void adicionar (PedidoComprar pc);
    
    public void Alterar (PedidoComprar pc);
    
    public void Pesquisar (String campo, String inf, JXTable Tbl);
    
    public void Remover (int Id);
    
    public void Relatorio ();
    
    public void ChamaRelatorio ();
}
