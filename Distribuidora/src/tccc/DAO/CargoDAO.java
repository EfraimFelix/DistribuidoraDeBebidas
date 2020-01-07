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
import tccc.Conexao;
import tccc.Entidade.ICargo;
import tccc.Modelo.Cargo;

public class CargoDAO implements ICargo {

    Connection connection=null;

    @Override
    public List<Cargo> getLista() {
        try {
            connection = new Conexao().getConnection();
            List<Cargo> cargos = new ArrayList<Cargo>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from TB_Cargo");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cargo c = new Cargo();
                c.setId_c(rs.getInt("IdTB_Cargo"));
                c.setDescricao(rs.getString("Cargo_Descricao"));
                cargos.add(c);
            }
            rs.close();
            stmt.close();
            return cargos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public void adicionar(Cargo c) {
        String sql = "{call inserirCargo(?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, c.getDescricao());

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
    public void BuscarClienteID(String desc, Cargo c) {
        try {
            connection = new Conexao().getConnection();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from TB_Cargo where Cargo_Descricao = " + desc);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                c.setId_c(rs.getInt("IdTB_Cargo"));
                c.setDescricao(rs.getString("Cargo_Descricao"));
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
    public void Remover(int id) {
        String sql = "{call excluirCargo(?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);

            stmt.setInt(1, id);

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

}
