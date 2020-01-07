/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
import tccc.Modelo.PedidoComprar;
import tccc.Entidade.IPedidoComprar;

/**
 *
 * @author Efraim
 */
public class PedidoComprarDAO implements IPedidoComprar {

    private Connection connection = null;

    @Override
    public List<PedidoComprar> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<PedidoComprar> compra = new ArrayList<PedidoComprar>();
            String sql = "{call listarTodosPedidoCompra}";
            CallableStatement stmt = connection.prepareCall(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoComprar pc = new PedidoComprar();
                pc.setId_compra(rs.getInt("IdPedidoCompra"));
                pc.setId_fornecedor(rs.getInt("IdFornecedor"));
                pc.setFornecedor_nome(rs.getString("Fornecedor"));
                pc.setFrete(rs.getDouble("Frete"));
                pc.setDescontoporcentagem(rs.getDouble("DescontoPorcentagem"));
                pc.setDesconto(rs.getDouble("Desconto"));
                pc.setValortotal_pedido(rs.getDouble("Total"));
                if (rs.getString("Status").equals("0")) {
                    pc.setStatus("Pendente");
                } else if (rs.getString("Status").equals("1")) {
                    pc.setStatus("Entregue");
                } else {
                    pc.setStatus("erro");
                }
                pc.setHora(rs.getTime("Hora"));
                pc.setData(rs.getDate("Data"));
                compra.add(pc);
            }
            rs.close();
            stmt.close();
            return compra;

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

    @Override
    public List<PedidoComprar> getLista(String campo, String inf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoComprar> ListarTabela(JXTable Tbl) {
        List<PedidoComprar> compra = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (PedidoComprar pc : compra) {
            model.addRow(new Object[]{
                pc.getId_compra(),
                pc.getId_fornecedor(),
                pc.getFornecedor_nome(),
                moeda.format(pc.getFrete()),
                String.format("%.2f", pc.getDescontoporcentagem()),
                moeda.format(pc.getDesconto()),
                moeda.format(pc.getValortotal_pedido()),
                pc.getStatus(),
                pc.getHora(),
                df.format(Date.valueOf(String.valueOf(pc.getData())))
            });
        }
        return compra;
    }

    @Override
    public void BuscarPedidoComprarID(int Id, PedidoComprar pc) {
        try {
            connection = new Conexao().getConnection();
            String sql = "{call listarTodosPedidoCompraPorID(?)}";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pc.setId_compra(rs.getInt("IdPedidoCompra"));
                pc.setId_fornecedor(rs.getInt("IdFornecedor"));
                pc.setFornecedor_nome(rs.getString("Fornecedor"));
                pc.setHora(rs.getTime("Hora"));
                pc.setData(rs.getDate("Data"));
                pc.setFrete(rs.getInt("Frete"));
                pc.setDesconto(rs.getInt("Desconto"));
                pc.setValortotal_pedido(rs.getDouble("Total"));
                if (rs.getString("Status").equals("0")) {
                    pc.setStatus("Pendente");
                } else if (rs.getString("Status").equals("1")) {
                    pc.setStatus("Entregue");
                } else {
                    pc.setStatus("erro");
                }
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

    @Override
    public void adicionar(PedidoComprar pc) {
        String sql = "{call inserirPedidoCompra(?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, pc.getId_fornecedor());
            stmt.setDouble(2, pc.getFrete());
            stmt.setDouble(3, pc.getDescontoporcentagem());
            stmt.setDouble(4, pc.getDesconto());
            stmt.setDouble(5, pc.getValortotal_pedido());
            stmt.setTime(6, pc.getHora());
            stmt.setDate(7, pc.getData());

            stmt.registerOutParameter(8, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(8));

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

    public void ConfirmaEntrega(PedidoComprar pc) {
        String sql = "{call confirmaEntregaCompra(?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setDouble(1, pc.getId_compra());
            stmt.setTime(2, pc.getHora());
            stmt.setDate(3, pc.getData());

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

    public void AlterarEstoque(int Id_compra) {
        try {
            String sql = "{call ListarItensPedidoCompra(?)}";
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, Id_compra);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AlterarEstoque2(rs.getInt("ID"), rs.getInt("Quantidade"), rs.getDouble("ValorUnit"));
                System.out.println("IdProduto - " + rs.getInt("ID"));
                System.out.println("Quantidade - " + rs.getInt("Quantidade"));
                System.out.println("ValorUnitario - " + rs.getDouble("ValorUnit"));
                System.out.println("---------------Estoque alterado---------------");
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

    public void AlterarEstoque2(int idProduto, int quantidade, double valorUnit) {
        try {
            String sql = "{call cadastroAlteracaoEstoqueCompra(?,?,?)}";
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, idProduto);
            stmt.setInt(2, quantidade);
            stmt.setDouble(3, valorUnit);
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

    @Override
    public void Alterar(PedidoComprar pc) {
        String sql = "{call alterarPedidoCompra(?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, pc.getId_compra());
            stmt.setInt(2, pc.getId_fornecedor());
            stmt.setDouble(3, pc.getFrete());
            stmt.setDouble(4, pc.getDescontoporcentagem());
            stmt.setDouble(5, pc.getDesconto());
            stmt.setDouble(6, pc.getValortotal_pedido());
            stmt.setTime(7, pc.getHora());
            stmt.setDate(8, pc.getData());

            stmt.registerOutParameter(9, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(9));

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

    @Override
    public void Pesquisar(String campo, String inf, JXTable Tbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Remover(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Relatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ChamaRelatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
