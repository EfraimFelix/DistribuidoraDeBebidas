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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.Conexao;
import tccc.Modelo.PesquisarProdutosEstoque;

/**
 *
 * @author Efraim
 */
public class PesquisarProdutosEstoqueDAO {

    private Connection connection = null;

    public List<PesquisarProdutosEstoque> Lista() {
        try {
            connection = new Conexao().getConnection();
            List<PesquisarProdutosEstoque> pes_prod_estoque = new ArrayList<PesquisarProdutosEstoque>();
            String sql = "{call listarTodosEstoque}";
            CallableStatement stmt = connection.prepareCall(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                PesquisarProdutosEstoque c = new PesquisarProdutosEstoque();

                c.setId_produto(rs.getInt("IdProduto"));
                c.setNome(rs.getString("ProdutoNome"));
                c.setMarca(rs.getString("Marca"));
                c.setQuantidade(rs.getInt("QuantidadeAtual"));
                c.setEstoquemin(rs.getInt("EstoqueMin"));
                c.setValorUnitario(rs.getDouble("ValorUnit"));
                pes_prod_estoque.add(c);
            }
            rs.close();
            stmt.close();
            return pes_prod_estoque;

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

    public List<PesquisarProdutosEstoque> ListarTabela(JXTable Tbl) {
        List<PesquisarProdutosEstoque> pes_prod_estoque = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (PesquisarProdutosEstoque pes : pes_prod_estoque) {
            if (pes.getQuantidade() < pes.getEstoquemin()) {
                pes.setNome("! " + pes.getNome());
            }
            model.addRow(new Object[]{
                pes.getId_produto(),
                pes.getNome(),
                pes.getMarca(),
                pes.getQuantidade(),
                pes.getEstoquemin()
            });
        }
        return pes_prod_estoque;

    }

    public List<PesquisarProdutosEstoque> ListarTabela2(JXTable Tbl) {
        List<PesquisarProdutosEstoque> pes_prod_estoque = Lista();
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);

        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (PesquisarProdutosEstoque pes : pes_prod_estoque) {
            if (pes.getQuantidade() < pes.getEstoquemin()) {

            }
            model.addRow(new Object[]{
                pes.getId_produto(),
                pes.getNome(),
                pes.getMarca(),
                pes.getQuantidade(),
                moeda.format(pes.getValorUnitario())
            });
        }
        return pes_prod_estoque;
    }

//    public void corNaLinha(JXTable Tbl) {
//
//        Tbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                int QTD = Integer.parseInt(String.valueOf(table.getValueAt(row, 2)));
//                int ESTMIN = Integer.parseInt(String.valueOf(table.getValueAt(row, 3)));
//
//                if (row == 8) {
//                    setBackground(Color.RED);//Preenche a linha de vermelho
//                } else {
//                    setBackground(null);//Preenche a linha de branco
//                }
//                if (isSelected) {
//                    setBackground(Color.GREEN);
//                }
//                return this;
//            }
//
//        });
//    }
//    public void corNaLinha2(JXTable Tbl) {
//
//        Tbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//                setBackground(Color.RED);//Preenche a linha de vermelho
//                setForeground(Color.WHITE);//E a fonte de branco
//
//                return this;
//            }
//
//        });
//
//    }
//    public void corNaLinha(JXTable Tbl){
//    List<PesquisarProdutosEstoque> pes_prod_estoque = Lista();
//    Tbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
//
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row , int collumn){
//            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, false, false, row, collumn);
//            
//            Color color = Color.GREEN;
//            label.setForeground(color);
//            Object texto = Tbl.getValueAt(row, 0);            
//            
//            if("*".equals(texto.toString().substring(0,1))){
//            color=Color.RED;
//            label.setForeground(color);
//            }
//            return label;
//        }
//    });           
//    }
    public List<PesquisarProdutosEstoque> getLista(String campo, String inf) {
        try {
            connection = new Conexao().getConnection();
            List<PesquisarProdutosEstoque> Pes = new ArrayList<PesquisarProdutosEstoque>();
            PreparedStatement stmt = this.connection.prepareStatement("select E.TB_Produto_idTB_Produto as IdProduto, P.Produto_Descricao as ProdutoNome, m.Marca_Descricao as Marca, E.Estoque_QuantidadeAtual as QuantidadeAtual, p.Produto_EstoqueMinimo as EstoqueMin from TB_Estoque as E inner join TB_Produto as P on P.IdTB_Produto = E.TB_Produto_IdTB_Produto left join tb_marca as m on m.IdTB_Marca = P.TB_Marca_idTB_Marca where " + campo + " like '%" + inf + "%'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PesquisarProdutosEstoque c = new PesquisarProdutosEstoque();

                c.setId_produto(rs.getInt("IdProduto"));
                c.setNome(rs.getString("ProdutoNome"));
                c.setMarca(rs.getString("Marca"));
                c.setQuantidade(rs.getInt("QuantidadeAtual"));
                c.setEstoquemin(rs.getInt("EstoqueMin"));
                Pes.add(c);
            }
            rs.close();
            stmt.close();
            return Pes;

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

    public void Pesquisar1(String campo, String inf, JXTable Tbl) {
        List<PesquisarProdutosEstoque> Pesquisa = getLista(campo, inf);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (PesquisarProdutosEstoque pes : Pesquisa) {
            if (pes.getQuantidade() < pes.getEstoquemin()) {
                pes.setNome("! " + pes.getNome());
            }
            model.addRow(new Object[]{
                pes.getId_produto(),
                pes.getNome(),
                pes.getMarca(),
                pes.getQuantidade(),
                moeda.format(pes.getValorUnitario())
            });
        }
    }
    public void Pesquisar2(String campo, String inf, JXTable Tbl) {
        List<PesquisarProdutosEstoque> Pesquisa = getLista(campo, inf);
        DefaultTableModel model = (DefaultTableModel) Tbl.getModel();
        model.setNumRows(0);
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (PesquisarProdutosEstoque pes : Pesquisa) {
            model.addRow(new Object[]{
                pes.getId_produto(),
                pes.getNome(),
                pes.getMarca(),
                pes.getQuantidade(),
                moeda.format(pes.getValorUnitario())
            });
        }
    }
}
