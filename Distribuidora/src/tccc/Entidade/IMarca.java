/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.Entidade;

import java.util.List;
import tccc.Modelo.Marca;

/**
 *
 * @author Efraim
 */
public interface IMarca {
    public List<Marca>getLista();
    
    public void adicionar (Marca m);
    
    public void BuscarClienteID (String desc, Marca m);
    
    public void Remover (int id);
}
