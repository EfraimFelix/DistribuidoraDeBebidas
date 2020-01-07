package tccc.Entidade;

import java.util.List;
import org.jdesktop.swingx.JXTable;
import tccc.Modelo.Produto;
import tccc.Modelo.Produto;

public interface IProduto {

    List<Produto> Lista();

    List<Produto> getLista(String campo, String inf);

    List<Produto> ListarTabela(JXTable Tbl);

    public void BuscarProdutoID(int Id, Produto p);

    public void adicionar(Produto p);

    public void Alterar(Produto p);

    public void Pesquisar(String campo, String inf, JXTable Tbl);

    public void Remover(int Id);

    public void Relatorio();

    public void ChamaRelatorio();
}
