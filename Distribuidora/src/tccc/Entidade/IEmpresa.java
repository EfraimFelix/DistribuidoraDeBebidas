/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.Entidade;

import java.util.List;
import tccc.Modelo.Empresa;
import tccc.Modelo.Estoque;

/**
 *
 * @author Efraim
 */
public interface IEmpresa {
    List<Empresa> Lista ();
    
    public void Alterar ( Empresa e);
}
