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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXTable;
import tccc.Conexao;
import tccc.Entidade.IEstoque;
import tccc.Modelo.Estoque;

/**
 *
 * @author Efraim
 */
public class EstoqueDAO implements IEstoque {

    private Connection connection = null;

    @Override
    public List<Estoque> Lista() {
        try {
            connection = new Conexao().getConnection();
            List< Estoque> estoque = new ArrayList< Estoque>();
            String sql = "{call listarTodosEstoques}";
            CallableStatement stmt = connection.prepareCall(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Estoque e = new Estoque();

                e.setId_estoque(rs.getInt("ID"));
                e.setProdutoNome(rs.getString("Produto"));
                e.setFornecedorNome(rs.getString("Fornecedor"));
                e.setValorcompra(rs.getDouble("ValorCompra"));
                e.setValorvenda(rs.getInt("ValorCompra"));
                e.setLucroporcentagem(rs.getDouble("LucroPorcentagem"));
                e.setLucro(rs.getDouble("Lucro"));
                e.setQuantidadeAtual(rs.getInt("QuantidadeAtual"));
                e.setStatus(rs.getString("Status"));
                e.setHora(rs.getTime("Hora"));
                e.setData(rs.getDate("Data"));
                estoque.add(e);
            }
            rs.close();
            stmt.close();
            return estoque;

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
    public List<Estoque> getLista(String campo, String inf) {
        return null;
//        try {
//connection = new Conexao().getConnection();
//            List<Estoque> estoque = new ArrayList<Estoque>();
//            PreparedStatement stmt = this.connection.prepareStatement("Select * from tb_estoque where " + campo + " like '%" + inf + "%'");
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Estoque e = new Estoque();
//                e.setId_estoque(rs.getInt("ID"));
//                 e.setProdutoNome(rs.getString("Produto"));
//                 e.setFornecedorNome(rs.getString("Fornecedor"));
//                 e.setValorcompra(rs.getDouble("ValorCompra"));
//                 e.setValorvenda(rs.getInt("ValorCompra"));
//                 e.setLucroporcentagem(rs.getDouble("LucroPorcentagem"));
//                 e.setLucro(rs.getDouble("Lucro"));
//                 e.setQuantidadeAtual(rs.getInt("QuantidadeAtual"));
//                 e.setStatus(rs.getString("Status"));
//                 e.setHora(rs.getTime("Hora"));
//                 e.setData(rs.getDate("Data"));
//                estoque.add(e);
//            }
//            rs.close();
//            stmt.close();            connection.close();            connection=null;
//            return estoque;
//            
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, erro);
//            throw new RuntimeException(erro);
//        }
    }

    @Override
    public List<Estoque> ListarTabela(JXTable Tbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void BuscarEstoqueID(int Id, Estoque e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionar(Estoque e) {
        String sql = "{call inserirEstoque(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            connection = new Conexao().getConnection();
            CallableStatement stmt = connection.prepareCall(sql);
//            stmt.setString(1, e.getProdutoNome());
//            stmt.setString(2, e.get);
//            stmt.setString(3, e.getEndereco());
//            stmt.setInt(4, e.getNumero());
//            stmt.setString(5, e.getComplemento());
//            stmt.setString(6, e.getBairro());
//            stmt.setString(7, e.getCidade());
//            stmt.setString(8, e.getEstado());
//            stmt.setString(9, e.getCep());
//            stmt.setString(10, e.getSexo());
//            stmt.setString(11, e.getPessoa());
//            stmt.setString(12, e.getCpf_cnpj());
//            stmt.setObject(13, e.getNascimento());

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
    public void Alterar(Estoque e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
