package tccc.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.Conexao;
import tccc.Entidade.ICliente;
import tccc.Modelo.Cliente;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements ICliente {

    private Connection connection = null;

    @Override
    public List<Cliente> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<Cliente> cliente = new ArrayList<Cliente>();
            String sql = "{call listarTodosClientes}";
            CallableStatement stmt = connection.prepareCall(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId_cliente(rs.getInt("IdTB_Cliente"));
                c.setNome(rs.getString("Cliente_Nome"));
                c.setTelefone(rs.getString("Cliente_Telefone"));
                c.setEndereco(rs.getString("Cliente_Endereco"));
                c.setNumero(rs.getInt("Cliente_Numero"));
                c.setComplemento(rs.getString("Cliente_Complemento"));
                c.setBairro(rs.getString("Cliente_Bairro"));
                c.setCidade(rs.getString("Cliente_Cidade"));
                c.setEstado(rs.getString("Cliente_Estado"));
                c.setCep(rs.getString("Cliente_CEP"));
                c.setSexo(rs.getString("Cliente_Sexo"));
                c.setPessoa(rs.getString("Cliente_Pessoa_F_J"));
                c.setCpf_cnpj(rs.getString("Cliente_CPF_CNPJ"));
                c.setNascimento(rs.getString("Cliente_Nascimento"));
                cliente.add(c);
            }
            rs.close();
            stmt.close();
            return cliente;

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
    public List<Cliente> getLista(String campo, String inf) {
        try {
            connection = new Conexao().getConnection();
            List<Cliente> cliente = new ArrayList<Cliente>();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from TT_Cliente where " + campo + " like '%" + inf + "%'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("IdTB_Cliente"));
                c.setNome(rs.getString("Cliente_Nome"));
                c.setTelefone(rs.getString("Cliente_Telefone"));
                c.setEndereco(rs.getString("Cliente_Endereco"));
                c.setNumero(rs.getInt("Cliente_Numero"));
                c.setComplemento(rs.getString("Cliente_Complemento"));
                c.setBairro(rs.getString("Cliente_Bairro"));
                c.setCidade(rs.getString("Cliente_Cidade"));
                c.setEstado(rs.getString("Cliente_Estado"));
                c.setCep(rs.getString("Cliente_CEP"));
                c.setSexo(rs.getString("Cliente_Sexo"));
                c.setPessoa(rs.getString("Cliente_Pessoa_F_J"));
                c.setCpf_cnpj(rs.getString("Cliente_CPF_CNPJ"));
                c.setNascimento(rs.getString("Cliente_Nascimento"));
                cliente.add(c);
            }
            rs.close();
            stmt.close();
            return cliente;

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
    public List<Cliente> ListarTabela(JXTable Tbl) {
        List<Cliente> cliente = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        for (Cliente cli : cliente) {
            model.addRow(new Object[]{
                cli.getId_cliente(),
                cli.getNome(),
                cli.getTelefone(),
                cli.getCep(),
                cli.getEndereco(),
                cli.getNumero(),
                cli.getComplemento(),
                cli.getBairro(),
                cli.getCidade(),
                cli.getEstado(),
                cli.getSexo(),
                cli.getPessoa(),
                cli.getCpf_cnpj(),
                df.format(Date.valueOf(String.valueOf(cli.getNascimento())))
            });
        }
        return cliente;
    }

    @Override
    public void adicionar(Cliente c) {
        connection = new Conexao().getConnection();
        String sql = "{call inserirCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEndereco());
            stmt.setInt(4, c.getNumero());
            stmt.setString(5, c.getComplemento());
            stmt.setString(6, c.getBairro());
            stmt.setString(7, c.getCidade());
            stmt.setString(8, c.getEstado());
            stmt.setString(9, c.getCep());
            stmt.setString(10, c.getSexo());
            stmt.setString(11, c.getPessoa());
            stmt.setString(12, c.getCpf_cnpj());
            stmt.setObject(13, c.getNascimento());

            stmt.registerOutParameter(14, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(14));

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
    public void Alterar(Cliente c) {
        connection = new Conexao().getConnection();
        String sql = "{call alterarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, c.getId_cliente());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getEndereco());
            stmt.setInt(5, c.getNumero());
            stmt.setString(6, c.getComplemento());
            stmt.setString(7, c.getBairro());
            stmt.setString(8, c.getCidade());
            stmt.setString(9, c.getEstado());
            stmt.setString(10, c.getCep());
            stmt.setString(11, c.getSexo());
            stmt.setString(12, c.getPessoa());
            stmt.setString(13, c.getCpf_cnpj());
            stmt.setObject(14, c.getNascimento());

            stmt.registerOutParameter(15, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(15));

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
    public void BuscarClienteID(int Id, Cliente c) {
        try {
            connection = new Conexao().getConnection();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from Tb_Cliente where IdTB_Cliente = " + Id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                c.setId_cliente(rs.getInt("IdTB_Cliente"));
                c.setNome(rs.getString("Cliente_Nome"));
                c.setTelefone(rs.getString("Cliente_Telefone"));
                c.setEndereco(rs.getString("Cliente_Endereco"));
                c.setNumero(rs.getInt("Cliente_Numero"));
                c.setComplemento(rs.getString("Cliente_Complemento"));
                c.setBairro(rs.getString("Cliente_Bairro"));
                c.setCidade(rs.getString("Cliente_Cidade"));
                c.setEstado(rs.getString("Cliente_Estado"));
                c.setCep(rs.getString("Cliente_CEP"));
                c.setSexo(rs.getString("Cliente_Sexo"));
                c.setPessoa(rs.getString("Cliente_Pessoa_F_J"));
                c.setCpf_cnpj(rs.getString("Cliente_CPF_CNPJ"));
                c.setNascimento(rs.getDate("Cliente_Nascimento"));
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
    public void Pesquisar(String campo, String inf, JXTable Tbl) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        List<Cliente> cliente = getLista(campo, inf);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        for (Cliente cli : cliente) {
            model.addRow(new Object[]{
                cli.getId_cliente(),
                cli.getNome(),
                cli.getTelefone(),
                cli.getCep(),
                cli.getEndereco(),
                cli.getNumero(),
                cli.getComplemento(),
                cli.getBairro(),
                cli.getCidade(),
                cli.getEstado(),
                cli.getSexo(),
                cli.getPessoa(),
                cli.getCpf_cnpj(),
                cli.getNascimento()
            });
        }
    }

    @Override
    public void Remover(int Id) {
        connection = new Conexao().getConnection();
        String sql = "{call excluirCliente(?,?)}";
        try {
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
    @Override
    public void Relatorio() {
        
    }
    @Override
    public void ChamaRelatorio() {
        
    }
}
