/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tccc.Conexao;
import tccc.Modelo.Pagamento;

/**
 *
 * @author Efraim
 */
public class PagamentoDAO {

    private Connection connection = null;

    public List<Pagamento> getLista() {
        try {
            connection = new Conexao().getConnection();
            List<Pagamento> pags = new ArrayList<Pagamento>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from TB_TipoPagamento");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamento p = new Pagamento();
                p.setId_pag(rs.getInt("IdTB_TipoPagamento"));
                p.setDescricao(rs.getString("TipoPagamento_Tipo"));
                pags.add(p);
            }
            rs.close();
            stmt.close();
            return pags;
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
}
