package tccc.Entidade;

import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.Funcionario;

public interface IFuncionario {
        
    List<Funcionario> Lista ();
    
    List<Funcionario> getLista(String campo, String inf);
    
    List<Funcionario> ListarTabela (JXTable Tbl);
    
    public void BuscarFuncionarioID (int Id, Funcionario f);
   
    public void adicionar (Funcionario f);
    
    public void Alterar (Funcionario f);
    
    public void Pesquisar (String campo, String inf, JXTable Tbl);
    
    public void Remover (int Id);
    
    public void Relatorio ();
    
    public void ChamaRelatorio ();
}
