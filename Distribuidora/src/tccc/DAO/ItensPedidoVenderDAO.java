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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.Conexao;
import tccc.Modelo.PedidoVender;

/**
 *
 * @author Efraim
 */
public class ItensPedidoVenderDAO {

    private Connection connection = null;

    public List<PedidoVender> Lista(int idPedidoVenda) {
        try {
            connection = new Conexao().getConnection();
            List<PedidoVender> venda = new ArrayList<PedidoVender>();
            String sql = "{call ListarItensPedidoVenda(?)}";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, idPedidoVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoVender pv = new PedidoVender();
                pv.setProduto_descricao(rs.getString("Descricao"));
                pv.setMarcaNome(rs.getString("Marca"));
                pv.setQuantidade(rs.getInt("Quantidade"));
                pv.setValor_totalitem(rs.getDouble("SubTotal"));
                pv.setValor_unitario(rs.getDouble("ValorUnit"));
                venda.add(pv);
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

    public List<PedidoVender> getLista(String campo, String inf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PedidoVender> ListarTabela(JXTable Tbl, int idPedidoVenda) {
        List<PedidoVender> itensvenda = Lista(idPedidoVenda);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat(" dd/MM/yyyy ");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (PedidoVender pv : itensvenda) {
            model.addRow(new Object[]{
                pv.getProduto_descricao(),
                pv.getMarcaNome(),
                pv.getQuantidade(),
                moeda.format(pv.getValor_unitario()),
                moeda.format(pv.getValor_totalitem())
            });
        }
        return itensvenda;
    }

    public List<PedidoVender> ListarTabelaAlteracao(JXTable Tbl, int idPedidoVenda) {
        List<PedidoVender> itensvenda = Lista(idPedidoVenda);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (PedidoVender pc : itensvenda) {
            model.addRow(new Object[]{
                pc.getId_produto(),
                pc.getProduto_descricao(),
                moeda.format(pc.getValor_unitario()),
                pc.getQuantidade(),
                moeda.format(pc.getValor_totalitem())
            });
        }
        return itensvenda;
    }

    public void BuscarPedidoVenderID(int Id, PedidoVender pv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void adicionar(PedidoVender pv) {
        String sql = "{call inserirItensPedidoVenda(?,?,?,?,?)}";
        connection = new Conexao().getConnection();
        try {
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, pv.getId_produto());
            stmt.setDouble(2, pv.getQuantidade());
            stmt.setDouble(3, pv.getValor_unitario());
            stmt.setDouble(4, pv.getValor_totalitem());
            stmt.registerOutParameter(5, Types.VARCHAR);

            stmt.executeUpdate();

            System.err.println("" + stmt.getString(5));

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

    public void Alterar(PedidoVender pv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Pesquisar(String campo, String inf, JXTable Tbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Remover(int Id) {
        connection = new Conexao().getConnection();
        String sql = "{call excluirItensPedidoVenda(?)}";
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
