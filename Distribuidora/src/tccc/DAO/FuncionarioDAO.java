/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
import tccc.Entidade.IFuncionario;
import tccc.Modelo.Funcionario;

public class FuncionarioDAO implements IFuncionario {

    private Connection connection = null;

    @Override
    public List<Funcionario> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<Funcionario> funcionario = new ArrayList<Funcionario>();
            String sql = "{call listarTodosFuncionarios}";
            CallableStatement stmt = connection.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId_funcionario(rs.getInt("id"));
                f.setNome(rs.getString("Nome"));
                f.setTelefone(rs.getString("Telefone"));
                f.setCargo(rs.getString("Cargo"));
                f.setSalario(rs.getDouble("Salario"));
                f.setBairro(rs.getString("Bairro"));
                f.setCidade(rs.getString("Cidade"));
                f.setEstado(rs.getString("Uf"));
                f.setCep(rs.getString("CEP"));
                f.setSexo(rs.getString("Sexo"));
                f.setCpf(rs.getString("CPF"));
                f.setNascimento(rs.getString("Nascimento"));
                funcionario.add(f);
            }
            rs.close();
            stmt.close();
            return funcionario;

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
    public List<Funcionario> getLista(String campo, String inf) {
        try {
            connection = new Conexao().getConnection();
            List<Funcionario> funcionario = new ArrayList<Funcionario>();
            PreparedStatement stmt = this.connection.prepareStatement("select f.IdTB_Funcionario as Id, f.Funcionario_Nome as Nome, f.Funcionario_Telefone as Telefone, c.Cargo_Descricao as Cargo, f.Funcionario_Salario as Salario, f.Funcionario_Bairro as Bairro, f.Funcionario_Cidade as Cidade, f.Funcionario_Estado as Uf, f.Funcionario_CEP as CEP, f.Funcionario_Sexo as Sexo, f.Funcionario_CPF as CPF, f.Funcionario_Nascimento as Nascimento from TB_Funcionario as f inner join TB_Cargo as c on f.TB_Cargo_idTB_Cargo=c.IdTB_Cargo where " + campo + " like '%" + inf + "%'");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId_funcionario(rs.getInt("id"));
                f.setNome(rs.getString("Nome"));
                f.setTelefone(rs.getString("Telefone"));
                f.setCargo(rs.getString("Cargo"));
                f.setSalario(rs.getDouble("Salario"));
                f.setBairro(rs.getString("Bairro"));
                f.setCidade(rs.getString("Cidade"));
                f.setEstado(rs.getString("Uf"));
                f.setCep(rs.getString("CEP"));
                f.setSexo(rs.getString("Sexo"));
                f.setCpf(rs.getString("CPF"));
                f.setNascimento(rs.getString("Nascimento"));
                funcionario.add(f);
            }
            rs.close();
            stmt.close();
            return funcionario;

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
    public List<Funcionario> ListarTabela(JXTable Tbl) {
        List<Funcionario> funcionario = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (Funcionario func : funcionario) {
            model.addRow(new Object[]{
                func.getId_funcionario(),
                func.getNome(),
                func.getTelefone(),
                func.getCargo(),
                moeda.format(func.getSalario()),
                func.getCep(),
                func.getBairro(),
                func.getCidade(),
                func.getEstado(),
                func.getSexo(),
                func.getCpf(),
                df.format(Date.valueOf(String.valueOf(func.getNascimento())))
            });
        }
        return funcionario;
    }

    @Override
    public void BuscarFuncionarioID(int Id, Funcionario f) {
        try {
            connection = new Conexao().getConnection();
            PreparedStatement stmt = this.connection.prepareStatement("select f.IdTB_Funcionario as Id, f.Funcionario_Nome as Nome, f.Funcionario_Telefone as Telefone, c.Cargo_Descricao as Cargo, f.Funcionario_Salario as Salario, f.Funcionario_Bairro as Bairro, f.Funcionario_Cidade as Cidade, f.Funcionario_Estado as Uf, f.Funcionario_CEP as CEP, f.Funcionario_Sexo as Sexo, f.Funcionario_CPF as CPF, f.Funcionario_Nascimento as Nascimento from TB_Funcionario as f inner join TB_Cargo as c on f.TB_Cargo_idTB_Cargo=c.IdTB_Cargo where IdTB_Funcionario =" + Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                f.setId_funcionario(rs.getInt("id"));
                f.setNome(rs.getString("Nome"));
                f.setTelefone(rs.getString("Telefone"));
                f.setCargo(rs.getString("Cargo"));
                f.setSalario(rs.getDouble("Salario"));
                f.setBairro(rs.getString("Bairro"));
                f.setCidade(rs.getString("Cidade"));
                f.setEstado(rs.getString("Uf"));
                f.setCep(rs.getString("CEP"));
                f.setSexo(rs.getString("Sexo"));
                f.setCpf(rs.getString("CPF"));
                f.setNascimento(rs.getString("Nascimento"));
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
    public void adicionar(Funcionario f) {
        String sql = "{call inserirFuncionario(?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getCargo());
            stmt.setObject(4, f.getSalario());
            stmt.setString(5, f.getBairro());
            stmt.setString(6, f.getCidade());
            stmt.setString(7, f.getEstado());
            stmt.setString(8, f.getCep());
            stmt.setString(9, f.getSexo());
            stmt.setString(10, f.getCpf());
            stmt.setObject(11, f.getNascimento());

            stmt.registerOutParameter(12, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(12));

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
    public void Alterar(Funcionario f) {
        String sql = "{call alterarFuncionario(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, f.getId_funcionario());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getCargo());
            stmt.setObject(5, f.getSalario());
            stmt.setString(6, f.getBairro());
            stmt.setString(7, f.getCidade());
            stmt.setString(8, f.getEstado());
            stmt.setString(9, f.getCep());
            stmt.setString(10, f.getSexo());
            stmt.setString(11, f.getCpf());
            stmt.setObject(12, f.getNascimento());

            stmt.registerOutParameter(13, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(13));

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
        List<Funcionario> funcionario = getLista(campo, inf);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (Funcionario func : funcionario) {
            model.addRow(new Object[]{
                func.getId_funcionario(),
                func.getNome(),
                func.getTelefone(),
                func.getCargo(),
                moeda.format(func.getSalario()),
                func.getCep(),
                func.getBairro(),
                func.getCidade(),
                func.getEstado(),
                func.getSexo(),
                func.getCpf(),
                df.format(Date.valueOf(String.valueOf(func.getNascimento())))
            });
        }
    }

    @Override
    public void Remover(int Id) {
        String sql = "{call excluirFuncionario(?,?)}";
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

    @Override
    public void Relatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ChamaRelatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
