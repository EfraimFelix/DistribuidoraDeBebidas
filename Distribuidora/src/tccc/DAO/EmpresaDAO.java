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
import tccc.Entidade.IEmpresa;
import tccc.Modelo.Empresa;

/**
 *
 * @author Efraim
 */
public class EmpresaDAO implements IEmpresa {

    private Connection connection = null;

    @Override
    public List<Empresa> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<Empresa> empresa = new ArrayList<Empresa>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from TB_DadosEmpresa");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Empresa e = new Empresa();
                e.setId_empresa(rs.getInt("IdTB_DadosEmpresa"));
                e.setNome(rs.getString("DadosEmpresa_Nome"));
                e.setEndereco(rs.getString("DadosEmpresa_Endereco"));
                e.setNumero(rs.getInt("DadosEmpresa_Numero"));
                e.setBairro(rs.getString("DadosEmpresa_Bairro"));
                e.setCidade(rs.getString("DadosEmpresa_Cidade"));
                e.setEstado(rs.getString("DadosEmpresa_Estado"));
                e.setCep(rs.getString("DadosEmpresa_CEP"));
                e.setEmail(rs.getString("DadosEmpresa_Email"));
                e.setTelefone1(rs.getString("DadosEmpresa_Telefone1"));
                e.setTelefone2(rs.getString("DadosEmpresa_Telefone2"));
                empresa.add(e);
            }
            rs.close();
            stmt.close();
            return empresa;

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public void Alterar(Empresa e) {
        String sql = "{call alterarDados(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getEndereco());
            stmt.setInt(3, e.getNumero());
            stmt.setString(4, e.getBairro());
            stmt.setString(5, e.getCidade());
            stmt.setString(6, e.getEstado());
            stmt.setString(7, e.getCep());
            stmt.setString(8, e.getEmail());
            stmt.setString(9, e.getTelefone1());
            stmt.setString(10, e.getTelefone2());

            stmt.registerOutParameter(11, Types.VARCHAR);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, stmt.getString(11));

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

}
