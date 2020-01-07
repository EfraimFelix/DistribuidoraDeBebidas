package tccc.Entidade;

import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.PedidoVender;
import tccc.Modelo.PedidoVender;
public interface IPedidoVender {
        
   List<PedidoVender> Lista ();
    
    List<PedidoVender> getLista(String campo, String inf);
    
    // tem como parametro uma tabela, e com este parametro lista ela com os dados pegados
    List<PedidoVender> ListarTabela (JXTable Tbl);
    
    public void BuscarPedidoVenderID (int Id, PedidoVender pv);
   
    public void adicionar (PedidoVender pv);
    
    public void Alterar (PedidoVender pv);
    
    public void Pesquisar (String campo, String inf, JXTable Tbl);
    
    public void Remover (int Id);
    
    public void Relatorio ();
    
    public void ChamaRelatorio ();
}
