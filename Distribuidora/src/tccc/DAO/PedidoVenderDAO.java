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
import tccc.Entidade.IPedidoVender;
import tccc.Modelo.Entrega;
import tccc.Modelo.Pagamento;
import tccc.Modelo.PedidoVender;

/**
 *
 * @author Efraim
 */
public class PedidoVenderDAO implements IPedidoVender {

    private Connection connection = null;

    @Override
    public List<PedidoVender> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<PedidoVender> venda = new ArrayList<PedidoVender>();
            String sql = "{call listarTodosPedidoVenda}";
            CallableStatement stmt = connection.prepareCall(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoVender pv = new PedidoVender();
                pv.setId_venda(rs.getInt("IdPedidoVenda"));
                pv.setId_cliente(rs.getInt("IdCliente"));
                pv.setCliente_nome(rs.getString("Cliente"));
                pv.setId_funcionario(rs.getInt("IdFuncionario"));
                pv.setFuncionario_nome(rs.getString("Funcionario"));
                pv.setFrete(rs.getDouble("Frete"));
                pv.setDescontoporcentagem(rs.getDouble("DescontoPorcentagem"));
                pv.setDesconto(rs.getDouble("Desconto"));
                pv.setValor_totalpedido(rs.getDouble("Total"));
                pv.setTipovenda(rs.getString("TipoDeVenda"));
                if (rs.getString("StatusPagamento").equals("0")) {
                    pv.setStatuspagamento("Pendente");
                } else if (rs.getString("StatusPagamento").equals("1")) {
                    pv.setStatuspagamento("Pago");
                } else {
                    pv.setStatuspagamento("erro");
                }
                if (rs.getString("StatusEntrega").equals("0")) {
                    pv.setStatusentrega("Pendente");
                } else if (rs.getString("StatusEntrega").equals("1")) {
                    pv.setStatusentrega("Entregue");
                } else {
                    pv.setStatusentrega("erro");
                }
                pv.setHora(rs.getTime("Hora"));
                pv.setData(rs.getDate("Data"));
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

    @Override
    public List<PedidoVender> getLista(String campo, String inf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoVender> ListarTabela(JXTable Tbl) {
        List<PedidoVender> venda = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat(" dd/MM/yyyy ");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (PedidoVender pv : venda) {
            model.addRow(new Object[]{
                pv.getId_venda(),
                pv.getId_cliente(),
                pv.getCliente_nome(),
                pv.getId_funcionario(),
                pv.getFuncionario_nome(),
                moeda.format(pv.getFrete()),
                String.format("%.2f", pv.getDescontoporcentagem()) + " %",
                moeda.format(pv.getDesconto()),
                moeda.format(pv.getValor_totalpedido()),
                pv.getTipovenda(),
                pv.getStatuspagamento(),
                pv.getStatusentrega(),
                df.format(Date.valueOf(String.valueOf(pv.getData()))),
                pv.getHora()
            });
        }
        return venda;
    }

    @Override
    public void BuscarPedidoVenderID(int Id, PedidoVender pv) {
        try {
            connection = new Conexao().getConnection();
            String sql = "{call listarTodosPedidoVendaPorID(?)}";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pv.setId_venda(rs.getInt("IdPedidoVenda"));
                pv.setId_cliente(rs.getInt("IdCliente"));
                pv.setCliente_nome(rs.getString("Cliente"));
                pv.setId_funcionario(rs.getInt("IdFuncionario"));
                pv.setFuncionario_nome(rs.getString("Funcionario"));
                pv.setFrete(rs.getDouble("Frete"));
                pv.setDescontoporcentagem(rs.getDouble("DescontoPorcentagem"));
                pv.setDesconto(rs.getDouble("Desconto"));
                pv.setValor_totalpedido(rs.getDouble("Total"));
                pv.setTipovenda(rs.getString("TipoDeVenda"));
                if (rs.getString("StatusPagamento").equals("0")) {
                    pv.setStatuspagamento("Pendente");
                } else if (rs.getString("StatusPagamento").equals("1")) {
                    pv.setStatuspagamento("Pago");
                } else {
                    pv.setStatuspagamento("erro");
                }
                if (rs.getString("StatusEntrega").equals("0")) {
                    pv.setStatusentrega("Pendente");
                } else if (rs.getString("StatusEntrega").equals("1")) {
                    pv.setStatusentrega("Entregue");
                } else {
                    pv.setStatusentrega("erro");
                }
                pv.setHora(rs.getTime("Hora"));
                pv.setData(rs.getDate("Data"));
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
    public void adicionar(PedidoVender pv) {
        String sql = "{call inserirPedidoVenda(?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            if (pv.getId_cliente() == 0) {
                stmt.setNull(1, pv.getId_cliente());
            } else {
                stmt.setInt(1, pv.getId_cliente());
            }
            if (pv.getId_funcionario() == 0) {
                stmt.setNull(2, pv.getId_funcionario());
            } else {
                stmt.setInt(2, pv.getId_funcionario());
            }
            stmt.setDouble(3, pv.getFrete());
            stmt.setDouble(4, pv.getDescontoporcentagem());
            stmt.setDouble(5, pv.getDesconto());
            stmt.setDouble(6, pv.getValor_totalpedido());
            stmt.setString(7, pv.getTipovenda());
            stmt.setTime(8, pv.getHora());
            stmt.setDate(9, pv.getData());

            stmt.registerOutParameter(10, Types.VARCHAR);

            stmt.executeUpdate();
            System.out.println(stmt.getString(10));

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

    public void ConfirmarPagamento(Pagamento pag) {
        String sql = "{call ConfirmaPagamentoVenda(?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setDouble(1, pag.getIdpedidovenda());
            stmt.setString(2, pag.getTipopagamento());
            stmt.setDouble(3, pag.getValorecebido());
            stmt.setDouble(4, pag.getTroco());
            stmt.setTime(5, pag.getHora());
            stmt.setDate(6, pag.getData());

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

    public void ConfirmarEntrega(Entrega ent) {
        String sql = "{call ConfirmaEntregaVenda(?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setDouble(1, ent.getIdVenda());
            stmt.setInt(2, ent.getIdFuncionario());
            stmt.setTime(3, ent.getHora());
            stmt.setDate(4, ent.getData());

            stmt.registerOutParameter(5, Types.VARCHAR);

            stmt.executeUpdate();
            System.out.println(stmt.getString(5));

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
            String sql1 = "{call ListarItensPedidoVenda(?)}";
            String sql2 = "{call AlteracaoEstoqueVenda(?,?)}";
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql1);
            stmt.setInt(1, Id_compra);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CallableStatement stmt2 = connection.prepareCall(sql2);
                stmt2.setInt(1, rs.getInt("ID"));
                stmt2.setInt(1, rs.getInt("Quantidade"));
                stmt2.close();
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
    public void Alterar(PedidoVender pv) {
        String sql = "{call inserirPedidoVenda(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setNull(1, pv.getId_venda());
            if (pv.getId_cliente() == 0) {
                stmt.setNull(2, pv.getId_cliente());
            } else {
                stmt.setInt(2, pv.getId_cliente());
            }
            if (pv.getId_funcionario() == 0) {
                stmt.setNull(3, pv.getId_funcionario());
            } else {
                stmt.setInt(3, pv.getId_funcionario());
            }
            stmt.setDouble(4, pv.getFrete());
            stmt.setDouble(5, pv.getDescontoporcentagem());
            stmt.setDouble(6, pv.getDesconto());
            stmt.setDouble(7, pv.getValor_totalpedido());
            stmt.setString(8, pv.getTipovenda());
            stmt.setTime(9, pv.getHora());
            stmt.setDate(10, pv.getData());

            stmt.registerOutParameter(11, Types.VARCHAR);

            stmt.executeUpdate();
            System.out.println(stmt.getString(11));

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
