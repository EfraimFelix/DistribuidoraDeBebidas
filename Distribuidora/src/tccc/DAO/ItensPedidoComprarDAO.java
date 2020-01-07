/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.Conexao;
import tccc.Modelo.PedidoComprar;

/**
 *
 * @author Efraim
 */
public class ItensPedidoComprarDAO{

    private Connection connection = null;

    public List<PedidoComprar> Lista(int idPedidoCompra) {
        try {
            connection = new Conexao().getConnection();
            List<PedidoComprar> venda = new ArrayList<PedidoComprar>();
            String sql = "{call ListarItensPedidoCompra(?)}";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, idPedidoCompra);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoComprar pc = new PedidoComprar();
                pc.setId_produto(rs.getInt("ID"));
                pc.setProduto_nome(rs.getString("Descricao"));
                pc.setMarca_nome(rs.getString("Marca"));
                pc.setQuantidade(rs.getInt("Quantidade"));
                pc.setValor_custo(rs.getDouble("ValorCusto"));
                pc.setValor_unitario(rs.getDouble("ValorUnit"));
                pc.setValor_totalitem(rs.getDouble("SubTotal"));                
                venda.add(pc);
            }
            rs.close();
            stmt.close();
            return venda;

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

    public List<PedidoComprar> getLista(String campo, String inf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<PedidoComprar> ListarTabela(JXTable Tbl, int idPedidoCompra) {
        List<PedidoComprar> itenscompra = Lista(idPedidoCompra);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        for (PedidoComprar pc : itenscompra) {
            model.addRow(new Object[]{
                pc.getProduto_nome(),
                pc.getMarca_nome(),
                pc.getQuantidade(),
                moeda.format(pc.getValor_custo()),
                moeda.format(pc.getValor_unitario()),
                moeda.format(pc.getValor_totalitem())
            });
        }
        return itenscompra;
    }
    
    public List<PedidoComprar> ListarTabelaAlteracao(JXTable Tbl, int idPedidoCompra) {
        List<PedidoComprar> itenscompra = Lista(idPedidoCompra);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        for (PedidoComprar pc : itenscompra) {
            model.addRow(new Object[]{
                pc.getId_produto(),
                pc.getProduto_nome(),
                moeda.format(pc.getValor_custo()),
                moeda.format(pc.getValor_unitario()),
                pc.getQuantidade(),
                moeda.format(pc.getValor_totalitem())
            });
        }
        return itenscompra;
    }

    public void BuscarPedidoComprarID(int Id, PedidoComprar pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void adicionar(PedidoComprar pc) {
        String sql = "{call inserirItensPedidoCompra(?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, pc.getId_produto());
            stmt.setDouble(2, pc.getQuantidade());
            stmt.setDouble(3, pc.getValor_custo());
            stmt.setDouble(4, pc.getValor_unitario());
            stmt.setDouble(5, pc.getValor_totalitem());

            stmt.registerOutParameter(6, Types.VARCHAR);

            stmt.executeUpdate();

            System.err.println(""+stmt.getString(6));

            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        }finally {
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

    public void Alterar(PedidoComprar pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Pesquisar(String campo, String inf, JXTable Tbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Remover(int Id) {
        connection = new Conexao().getConnection();
        String sql = "{call excluirItensPedidoCompra(?)}";
        try {
            CallableStatement stmt = connection.prepareCall(sql);

            stmt.setInt(1, Id);

            stmt.executeUpdate();

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
