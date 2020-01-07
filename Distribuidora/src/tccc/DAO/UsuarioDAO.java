/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import tccc.Entidade.IUsuario;
import tccc.Modelo.Usuario;

/**
 *
 * @author Efraim
 */
public class UsuarioDAO implements IUsuario {

    private Connection connection = null;

    @Override
    public List<Usuario> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<Usuario> usuario = new ArrayList<Usuario>();
            String sql = "{call listarTodosUsuarios}";
            CallableStatement stmt = connection.prepareCall(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Usuario u = new Usuario();

                u.setId_usuario(rs.getInt("ID"));
                u.setNome(rs.getString("Nome"));
                u.setTipoconta(rs.getString("TipoConta"));
                u.setEmail(rs.getString("Email"));
                usuario.add(u);
            }
            rs.close();
            stmt.close();
            return usuario;

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
    public List<Usuario> getLista(String campo, String inf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> ListarTabela(JXTable Tbl) {
        List<Usuario> usuario = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        for (Usuario cli : usuario) {
            model.addRow(new Object[]{
                cli.getId_usuario(),
                cli.getNome(),
                cli.getTipoconta(),
                cli.getEmail()});
        }
        return usuario;
    }

    @Override
    public void BuscarUsuarioID(int Id, Usuario u) {
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall("{call listarUsuarioId(?)}");
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                u.setId_usuario(rs.getInt("ID"));
                u.setNome(rs.getString("Nome"));
                u.setEmail(rs.getString("Email"));
                u.setTipoconta(rs.getString("TipoConta"));
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
    public void adicionar(Usuario u) {
        String sql = "{call inserirUsuario(?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getTipoconta());

            String senha = u.getSenha();//Inicio
            MessageDigest m = MessageDigest.getInstance("MD5");//Transforma senha em MD5(criptografar senha)
            m.update(senha.getBytes(), 0, senha.length());
            senha = ("" + new BigInteger(1, m.digest()).toString(16));//Fim

            stmt.setString(4, senha);

            stmt.registerOutParameter(5, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(5));

            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public void Alterar(Usuario u) {
        String sql = "{call alterarUsuario(?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            String NovaSenha = u.getSenha();//Inicio
            MessageDigest m2 = MessageDigest.getInstance("MD5");//Transforma senha em MD5(criptografar senha)
            m2.update(NovaSenha.getBytes(), 0, NovaSenha.length());
            NovaSenha = ("" + new BigInteger(1, m2.digest()).toString(16));//Fim

            String SenhaAntiga = u.getSenhaAntiga();//Inicio
            MessageDigest m1 = MessageDigest.getInstance("MD5");//Transforma senha em MD5(criptografar senha)
            m1.update(SenhaAntiga.getBytes(), 0, SenhaAntiga.length());
            SenhaAntiga = ("" + new BigInteger(1, m1.digest()).toString(16));//Fim

            stmt.setInt(1, u.getId_usuario());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, NovaSenha);
            stmt.setString(5, SenhaAntiga);
            stmt.setString(6, u.getTipoconta());

            stmt.registerOutParameter(7, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(7));

            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);
        } catch (NoSuchAlgorithmException erro1) {
            JOptionPane.showMessageDialog(null, erro1);
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

    public void CadastrarEmail(Usuario u) {
        String sql = "update tb_usuario set Usuario_Email = '" + u.getEmail() + "' where IdTB_Usuario = " + System.getProperty("Usuario_ID");
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
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

    public boolean VerificaUsuario(String Nome, String Senha) {
        try {
            boolean verifica = false;

            connection = new Conexao().getConnection();

            String sql = "{call listarTodosUsuarios}";
            CallableStatement stmt = connection.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();

            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(Senha.getBytes(), 0, Senha.length());
            Senha = ("" + new BigInteger(1, m.digest()).toString(16));

            while (rs.next()) {
                if (rs.getString("Nome").equals(Nome) && Senha.equals(rs.getString("Senha"))) {

                    System.setProperty("Usuario_ID", String.valueOf(rs.getInt("ID"))); // Guarda Informações no sistema do usuário
                    System.setProperty("Usuario_Nome", rs.getString("Nome")); // Guarda Informações no sistema do usuário
                    System.setProperty("Usuario_Email", rs.getString("Email")); // Guarda Informações no sistema do usuário
                    System.setProperty("Usuario_TipoConta", rs.getString("TipoConta")); // Guarda Informações no sistema do usuário

                    verifica = true;
                } else {
                    if (verifica != true) {
                        verifica = false;
                    }
                }
            }
            rs.close();
            stmt.close();
            return verifica;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            throw new RuntimeException(erro);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

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
        return false;
    }

    public boolean VerificaNomeUsuario(Usuario u) {
        try {
            connection = new Conexao().getConnection();
            String nomeparapesquisa = "'" + u.getNome() + "'";
            PreparedStatement stmt = this.connection.prepareStatement("select*from TB_Usuario where Usuario_Nome = " + nomeparapesquisa);

            ResultSet rs = stmt.executeQuery();
            boolean verificacao;
            if (!rs.next()) {
                verificacao = false;
            } else {
                u.setId_usuario(rs.getInt("IdTB_Usuario"));
                u.setEmail(rs.getString("Usuario_Email"));
                verificacao = true;
            }
            rs.close();
            stmt.close();
            return verificacao;
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

    public void TrocarSenhaUsuario(Usuario u) throws NoSuchAlgorithmException {
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall("{call TrocarSenhaUsuario(?,?,?)}");
            stmt.setInt(1, u.getId_usuario());
            String senha = u.getSenha();//Inicio
            MessageDigest m = MessageDigest.getInstance("MD5");//Transforma senha em MD5(criptografar senha)
            m.update(senha.getBytes(), 0, senha.length());
            senha = ("" + new BigInteger(1, m.digest()).toString(16));//Fim
            stmt.setString(2, senha);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.executeUpdate();
            System.out.println(stmt.getString(3));
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

    public boolean VerificaoDeUsuarios() {
        try {
            connection = new Conexao().getConnection();
            PreparedStatement stmt = this.connection.prepareStatement("select*from TB_Usuario");

            ResultSet rs = stmt.executeQuery();
            boolean verificacao;
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Nenum usuário cadastrado!");
                JOptionPane.showMessageDialog(null, "O sistema irá cadastrar o usuário padrão!");
                Usuario user = new Usuario();
                user.setNome("admin");
                user.setSenha("12345");
                user.setEmail("");
                user.setTipoconta("Administrador");
                adicionar(user);
                verificacao = false;
            } else {
                verificacao = true;
            }
            rs.close();
            stmt.close();
            return verificacao;
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
}
