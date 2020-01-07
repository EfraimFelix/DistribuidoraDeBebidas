/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.Conexao;
import tccc.Entidade.IProduto;
import tccc.Modelo.Produto;

/**
 *
 * @author Efraim
 */
public class ProdutoDAO implements IProduto {

    private Connection connection = null;

    public List<Produto> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<Produto> produto = new ArrayList<Produto>();
            String sql = "{call listarTodosProdutos}";
            CallableStatement stmt = connection.prepareCall(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Produto p = new Produto();

                p.setId_produto(rs.getInt("Id"));
                p.setDescricao(rs.getString("Descricao"));
                p.setMarca(rs.getString("Marca"));
                p.setEstoque_minimo(rs.getInt("EstoqueMinimo"));
                produto.add(p);
            }
            rs.close();
            stmt.close();
            return produto;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Produto> getLista(String campo, String inf) {
        try {
            connection = new Conexao().getConnection();
            List<Produto> produto = new ArrayList<Produto>();
            PreparedStatement stmt = this.connection.prepareStatement("select p.IdTB_Produto as Id, p.Produto_Descricao as Descricao, m.Marca_Descricao as Marca, p.Produto_EstoqueMinimo as EstoqueMinimo from TB_Produto as p inner join TB_Marca as m on p.TB_Marca_idTB_Marca=m.IdTB_Marca where " + campo + " like '%" + inf + "%'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId_produto(rs.getInt("Id"));
                p.setDescricao(rs.getString("Descricao"));
                p.setMarca(rs.getString("Marca"));
                p.setEstoque_minimo(rs.getInt("EstoqueMinimo"));
                produto.add(p);
            }
            rs.close();
            stmt.close();
            return produto;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Produto> ListarTabela(JXTable Tbl) {
        List< Produto> produto = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        for (Produto prod : produto) {
            model.addRow(new Object[]{
                prod.getId_produto(),
                prod.getDescricao(),
                prod.getMarca(),
                prod.getEstoque_minimo(),});
        }
        return produto;
    }

    public void BuscarProdutoID(int Id, Produto p) {
        try {
            connection = new Conexao().getConnection();
            PreparedStatement stmt = this.connection.prepareStatement("select p.IdTB_Produto as Id, p.Produto_Descricao as Descricao, m.Marca_Descricao as Marca, p.Produto_EstoqueMinimo as EstoqueMinimo from TB_Produto as p inner join TB_Marca as m on p.TB_Marca_idTB_Marca=m.IdTB_Marca where IdTB_Produto = " + Id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.setId_produto(rs.getInt("Id"));
                p.setDescricao(rs.getString("Descricao"));
                p.setMarca(rs.getString("Marca"));
                p.setEstoque_minimo(rs.getInt("EstoqueMinimo"));
            }
            rs.close();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void adicionar(Produto p) {
        String sql = "{call inserirProduto(?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, p.getDescricao());
            stmt.setString(2, p.getMarca());
            stmt.setInt(3, p.getEstoque_minimo());

            stmt.registerOutParameter(4, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(4));

            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Alterar(Produto p) {
        String sql = "{call alterarProduto(?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, p.getId_produto());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getMarca());
            stmt.setInt(4, p.getEstoque_minimo());

            stmt.registerOutParameter(5, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(5));

            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Pesquisar(String campo, String inf, JXTable Tbl) {
        List<Produto> produto = getLista(campo, inf);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        for (Produto prod : produto) {
            model.addRow(new Object[]{
                prod.getId_produto(),
                prod.getDescricao(),
                prod.getMarca(),
                prod.getEstoque_minimo()
            });
        }
    }

    public void Remover(int Id) {
        String sql = "{call excluirProduto(?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);

            stmt.setInt(1, Id);

            stmt.registerOutParameter(2, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(2));

            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Relatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ChamaRelatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
