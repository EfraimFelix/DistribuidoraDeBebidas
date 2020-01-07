/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view;

import java.awt.Cursor;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import tccc.ControleDeColuna;
import tccc.DAO.FornecedorDAO;
import tccc.Modelo.Fornecedor;

/**
 *
 * @author Efraim
 */
public class JFD_PesquisarFornecedor extends javax.swing.JDialog {

    FornecedorDAO dao = new FornecedorDAO();
    private int xMouse, yMouse;
    private String nome, id;
    boolean fechou;

    public JFD_PesquisarFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        List<Fornecedor> fornecedor = dao.Lista();
        DefaultTableModel model = (DefaultTableModel) TblFornecedor.getModel();
        model.setNumRows(0);
        for (Fornecedor forn : fornecedor) {
            model.addRow(new Object[]{
                forn.getId_fornecedor(),
                forn.getNome(),
                forn.getTelefone(),
                forn.getEmail(),
                forn.getCnpj()
            });
        }
        ControleDeColuna c = new ControleDeColuna(TblFornecedor, false);

        this.setLocationRelativeTo(null);
    }

    public String getNome() {
        return nome;
    }

    public String getID() {
        return id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        TxtPesquisa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BotaoPesquisar = new javax.swing.JLabel();
        CbCampo = new javax.swing.JComboBox<>();
        MovimentarJanela = new javax.swing.JPanel();
        fechar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblFornecedor = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.setForeground(new java.awt.Color(171, 121, 85));

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(TxtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 150, -1));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pesquisar");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        BotaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png"))); // NOI18N
        BotaoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoPesquisarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoPesquisarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoPesquisarMouseExited(evt);
            }
        });
        jPanel6.add(BotaoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 30, 30));

        CbCampo.setForeground(new java.awt.Color(255, 255, 255));
        CbCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome", "Telefone", "E-Mail", "CNPJ" }));
        CbCampo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbCampoItemStateChanged(evt);
            }
        });
        jPanel6.add(CbCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 40, 90, -1));

        MovimentarJanela.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MovimentarJanelaMouseDragged(evt);
            }
        });
        MovimentarJanela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MovimentarJanelaMousePressed(evt);
            }
        });

        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Close_Window_20px_3.png"))); // NOI18N
        fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fecharMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gerenciador Comercial - J.C Tramontina");

        javax.swing.GroupLayout MovimentarJanelaLayout = new javax.swing.GroupLayout(MovimentarJanela);
        MovimentarJanela.setLayout(MovimentarJanelaLayout);
        MovimentarJanelaLayout.setHorizontalGroup(
            MovimentarJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MovimentarJanelaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fechar))
        );
        MovimentarJanelaLayout.setVerticalGroup(
            MovimentarJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovimentarJanelaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(MovimentarJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        TblFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        TblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Email", "CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblFornecedor.setToolTipText("");
        TblFornecedor.setEditable(false);
        TblFornecedor.setFillsViewportHeight(false);
        TblFornecedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TblFornecedor.setGridColor(new java.awt.Color(0, 0, 0));
        TblFornecedor.setHorizontalScrollEnabled(true);
        TblFornecedor.setSearchable(null);
        TblFornecedor.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TblFornecedor.getTableHeader().setResizingAllowed(false);
        TblFornecedor.getTableHeader().setReorderingAllowed(false);
        TblFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblFornecedor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MovimentarJanela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseClicked
        String campo = null;

        switch (CbCampo.getSelectedIndex()) {
            case 1:
                campo = "IdTB_Fornecedor";
                break;
            case 2:
                campo = "Fornecedor_Nome";
                break;
            case 3:
                campo = "Fornecedor_Telefone";
                break;
            case 4:
                campo = "Fornecedor_Email";
                break;
            case 5:
                campo = "Fornecedor_CNPJ";
                break;
            default:
                campo = "IdTB_Fornecedor";
                dao.Pesquisar(campo, TxtPesquisa.getText(), TblFornecedor);
                break;
        }
        String pesquisa = TxtPesquisa.getText();
        dao.Pesquisar(campo, pesquisa, TblFornecedor);
    }//GEN-LAST:event_BotaoPesquisarMouseClicked

    private void BotaoPesquisarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseEntered
        BotaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_3.png")));
        BotaoPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BotaoPesquisarMouseEntered

    private void fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_fecharMouseClicked

    private void fecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseEntered
        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Close_Window_20px_2.png")));
    }//GEN-LAST:event_fecharMouseEntered

    private void fecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseExited
        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Close_Window_20px_3.png")));
    }//GEN-LAST:event_fecharMouseExited

    private void MovimentarJanelaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovimentarJanelaMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - xMouse, this.getLocation().y + evt.getY() - yMouse);
    }//GEN-LAST:event_MovimentarJanelaMouseDragged

    private void MovimentarJanelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovimentarJanelaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_MovimentarJanelaMousePressed

    private void TblFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblFornecedorMouseClicked
        int linha = TblFornecedor.getSelectedRow();
        if (linha != -1) {
            id = (TblFornecedor.getValueAt(linha, 0).toString());
            nome = (TblFornecedor.getValueAt(linha, 1).toString());
            fechou = true;
            this.dispose();
        }
    }//GEN-LAST:event_TblFornecedorMouseClicked

    private void CbCampoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbCampoItemStateChanged
        TxtPesquisa.setText("");
        try {
            if (CbCampo.getSelectedIndex() == 0) {
                dao.Pesquisar("IdTB_Fornecedor", "", TblFornecedor);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_CbCampoItemStateChanged

    private void BotaoPesquisarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseExited
        BotaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png")));
    }//GEN-LAST:event_BotaoPesquisarMouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotaoPesquisar;
    private javax.swing.JComboBox<String> CbCampo;
    private javax.swing.JPanel MovimentarJanela;
    private org.jdesktop.swingx.JXTable TblFornecedor;
    private javax.swing.JTextField TxtPesquisa;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}