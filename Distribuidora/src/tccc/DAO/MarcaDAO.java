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
import tccc.Conexao;
import tccc.Entidade.IMarca;
import tccc.Modelo.Marca;

/**
 *
 * @author Efraim
 */
public class MarcaDAO implements IMarca {

    private Connection connection = null;

    @Override
    public List<Marca> getLista() {
        try {
            connection = new Conexao().getConnection();
            List<Marca> marcas = new ArrayList<Marca>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from TB_Marca");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Marca m = new Marca();
                m.setId_c(rs.getInt("IdTB_Marca"));
                m.setDescricao(rs.getString("Marca_Descricao"));
                marcas.add(m);
            }
            rs.close();
            stmt.close();
            return marcas;

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
    public void adicionar(Marca m) {
        connection = new Conexao().getConnection();
        String sql = "{call inserirMarca(?,?)}";
        try {
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, m.getDescricao());

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
    public void BuscarClienteID(String desc, Marca m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Remover(int id) {
        String sql = "{call excluirMarca(?,?)}";
        try {
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
