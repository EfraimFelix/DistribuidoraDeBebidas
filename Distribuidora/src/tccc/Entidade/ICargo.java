package tccc.Entidade;

import java.util.List;
import tccc.Modelo.Cargo;

public interface ICargo {
    public List<Cargo>getLista();
    
    public void adicionar (Cargo c);
    
    public void BuscarClienteID (String desc, Cargo c);
    
    public void Remover (int id);
}