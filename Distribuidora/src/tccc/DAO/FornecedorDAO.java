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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.Conexao;
import tccc.Entidade.IFornecedor;
import tccc.Modelo.Fornecedor;

/**
 *
 * @author Efraim
 */
public class FornecedorDAO implements IFornecedor {

    private Connection connection = null;

    @Override
    public List<Fornecedor> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<Fornecedor> forn = new ArrayList<Fornecedor>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from TB_Fornecedor");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Fornecedor f = new Fornecedor();

                f.setId_fornecedor(rs.getInt("IdTB_Fornecedor"));
                f.setNome(rs.getString("Fornecedor_Nome"));
                f.setTelefone(rs.getString("Fornecedor_Telefone"));
                f.setEmail(rs.getString("Fornecedor_Email"));
                f.setCnpj(rs.getString("Fornecedor_CNPJ"));
                f.setCep(rs.getString("Fornecedor_CEP"));
                f.setEndereco(rs.getString("Fornecedor_Endereco"));
                f.setBairro(rs.getString("Fornecedor_Bairro"));
                f.setCidade(rs.getString("Fornecedor_Cidade"));
                f.setEstado(rs.getString("Fornecedor_Estado"));
                forn.add(f);
            }
            rs.close();
            stmt.close();
            return forn;

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

    @Override
    public List<Fornecedor> getLista(String campo, String inf) {
        try {
            connection = new Conexao().getConnection();
            List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from TB_Fornecedor where " + campo + " like '%" + inf + "%'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId_fornecedor(rs.getInt("IdTB_Fornecedor"));
                f.setNome(rs.getString("Fornecedor_Nome"));
                f.setTelefone(rs.getString("Fornecedor_Telefone"));
                f.setEmail(rs.getString("Fornecedor_Email"));
                f.setCnpj(rs.getString("Fornecedor_Cnpj"));
                f.setCep(rs.getString("Fornecedor_Cep"));
                f.setEndereco(rs.getString("Fornecedor_Endereco"));
                f.setBairro(rs.getString("Fornecedor_Bairro"));
                f.setCidade(rs.getString("Fornecedor_Cidade"));
                f.setEstado(rs.getString("Fornecedor_Estado"));
                fornecedor.add(f);
            }
            rs.close();
            stmt.close();
            return fornecedor;

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

    @Override
    public List<Fornecedor> ListarTabela(JXTable Tbl) {
        List<Fornecedor> fornecedor = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        for (Fornecedor forn : fornecedor) {
            model.addRow(new Object[]{
                forn.getId_fornecedor(),
                forn.getNome(),
                forn.getTelefone(),
                forn.getEmail(),
                forn.getCnpj(),
                forn.getCep(),
                forn.getEndereco(),
                forn.getBairro(),
                forn.getCidade(),
                forn.getEstado()
            });
        }
        return fornecedor;
    }

    @Override
    public void BuscarFornecedorID(int Id, Fornecedor f) {
        try {
            connection = new Conexao().getConnection();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from TB_Fornecedor where IdTB_Fornecedor = " + Id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                f.setId_fornecedor(rs.getInt("IdTB_Fornecedor"));
                f.setNome(rs.getString("Fornecedor_Nome"));
                f.setTelefone(rs.getString("Fornecedor_Telefone"));
                f.setEmail(rs.getString("Fornecedor_Email"));
                f.setCnpj(rs.getString("Fornecedor_Cnpj"));
                f.setCep(rs.getString("Fornecedor_Cep"));
                f.setEndereco(rs.getString("Fornecedor_Endereco"));
                f.setBairro(rs.getString("Fornecedor_Bairro"));
                f.setCidade(rs.getString("Fornecedor_Cidade"));
                f.setEstado(rs.getString("Fornecedor_Estado"));
            }
            rs.close();
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

    @Override
    public void adicionar(Fornecedor f) {
        String sql = "{call inserirFornecedor(?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getCnpj());
            stmt.setString(5, f.getCep());
            stmt.setString(6, f.getEndereco());
            stmt.setString(7, f.getBairro());
            stmt.setString(8, f.getCidade());
            stmt.setString(9, f.getEstado());

            stmt.registerOutParameter(10, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(10));

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

    @Override
    public void Alterar(Fornecedor f) {
        String sql = "{call alterarFornecedor(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, f.getId_fornecedor());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getCnpj());
            stmt.setString(6, f.getCep());
            stmt.setString(7, f.getEndereco());
            stmt.setString(8, f.getBairro());
            stmt.setString(9, f.getCidade());
            stmt.setString(10, f.getEstado());

            stmt.registerOutParameter(11, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(11));

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

    @Override
    public void Pesquisar(String campo, String inf, JXTable Tbl) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        List<Fornecedor> fornecedor = getLista(campo, inf);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        for (Fornecedor forn : fornecedor) {
            model.addRow(new Object[]{
                forn.getId_fornecedor(),
                forn.getNome(),
                forn.getTelefone(),
                forn.getEmail(),
                forn.getCnpj(),
                forn.getCep(),
                forn.getEndereco(),
                forn.getBairro(),
                forn.getCidade(),
                forn.getEstado(),});
        }
    }

    @Override
    public void Remover(int Id) {
        String sql = "{call excluirFornecedor(?,?)}";
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

    @Override
    public void Relatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ChamaRelatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
