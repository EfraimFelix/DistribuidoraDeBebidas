/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view.Paineis;

import java.awt.Cursor;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tccc.DAO.UsuarioDAO;
import tccc.Modelo.Usuario;
import tccc.view.JFD_AlterarUsuario;
import tccc.view.JFD_CadastrarUsuario;
import tccc.view.Menu;

/**
 *
 * @author Efraim
 */
public class Painel_TelaConfig_Usuario extends javax.swing.JPanel {

    /**
     * Creates new form Painel_TelaConfig_Usuario
     */
    public Painel_TelaConfig_Usuario() {
        initComponents();
        UsuarioDAO dao = new UsuarioDAO();
        dao.ListarTabela(Tbl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AreaDinamica1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl = new org.jdesktop.swingx.JXTable();
        Alterar = new javax.swing.JPanel();
        Entrar_6 = new javax.swing.JLabel();
        Novo = new javax.swing.JPanel();
        Entrar_7 = new javax.swing.JLabel();

        AreaDinamica1.setBackground(new java.awt.Color(0, 153, 255));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        Tbl.setForeground(new java.awt.Color(255, 255, 255));
        Tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuário", "Tipo de Conta", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tbl.setToolTipText("");
        Tbl.setEditable(false);
        Tbl.setFillsViewportHeight(false);
        Tbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Tbl.setGridColor(new java.awt.Color(0, 0, 0));
        Tbl.setHorizontalScrollEnabled(true);
        Tbl.setSearchable(null);
        Tbl.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(Tbl);

        Alterar.setBackground(new java.awt.Color(0, 0, 0));
        Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Alterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlterarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AlterarMouseEntered(evt);
            }
        });

        Entrar_6.setBackground(new java.awt.Color(65, 105, 225));
        Entrar_6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Entrar_6.setForeground(new java.awt.Color(255, 255, 255));
        Entrar_6.setText("Alterar");

        javax.swing.GroupLayout AlterarLayout = new javax.swing.GroupLayout(Alterar);
        Alterar.setLayout(AlterarLayout);
        AlterarLayout.setHorizontalGroup(
            AlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AlterarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar_6)
                .addContainerGap())
        );
        AlterarLayout.setVerticalGroup(
            AlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Novo.setBackground(new java.awt.Color(0, 0, 0));
        Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Novo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NovoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NovoMouseEntered(evt);
            }
        });

        Entrar_7.setBackground(new java.awt.Color(65, 105, 225));
        Entrar_7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Entrar_7.setForeground(new java.awt.Color(255, 255, 255));
        Entrar_7.setText("Novo");

        javax.swing.GroupLayout NovoLayout = new javax.swing.GroupLayout(Novo);
        Novo.setLayout(NovoLayout);
        NovoLayout.setHorizontalGroup(
            NovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NovoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar_7)
                .addContainerGap())
        );
        NovoLayout.setVerticalGroup(
            NovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AreaDinamica1Layout = new javax.swing.GroupLayout(AreaDinamica1);
        AreaDinamica1.setLayout(AreaDinamica1Layout);
        AreaDinamica1Layout.setHorizontalGroup(
            AreaDinamica1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaDinamica1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(AreaDinamica1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AreaDinamica1Layout.createSequentialGroup()
                        .addComponent(Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        AreaDinamica1Layout.setVerticalGroup(
            AreaDinamica1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaDinamica1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(AreaDinamica1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AreaDinamica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AreaDinamica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarMouseClicked
        try {
            Menu menu = new Menu();
            Usuario u = new Usuario();
            UsuarioDAO dao = new UsuarioDAO();
            int linha = Tbl.getSelectedRow();
            int Id = 0;
            if (linha != -1) {
                Id = Integer.parseInt(Tbl.getValueAt(linha, 0).toString());
                dao.BuscarUsuarioID(Id, u);
                JFD_AlterarUsuario AU = new JFD_AlterarUsuario(
                        menu,
                        true,
                        Tbl,
                        String.valueOf(u.getId_usuario()),
                        u.getNome(),
                        u.getEmail(),
                        u.getTipoconta()
                );

                AU.setVisible(true);
                AU.setFocusableWindowState(true);
            } else if (linha != -0) {
                JOptionPane.showMessageDialog(null, "Por favor, clique em algum cadastro");
            }
            dao.ListarTabela(Tbl);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }//GEN-LAST:event_AlterarMouseClicked

    private void AlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterarMouseEntered
        Alterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_AlterarMouseEntered

    private void NovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovoMouseClicked
        Menu menu;
        try {
            menu = new Menu();
            JFD_CadastrarUsuario usu = new JFD_CadastrarUsuario(menu, true, Tbl);
            usu.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Painel_TelaConfig_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NovoMouseClicked

    private void NovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovoMouseEntered
        Novo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_NovoMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Alterar;
    private javax.swing.JPanel AreaDinamica1;
    private javax.swing.JLabel Entrar_6;
    private javax.swing.JLabel Entrar_7;
    private javax.swing.JPanel Novo;
    private org.jdesktop.swingx.JXTable Tbl;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
