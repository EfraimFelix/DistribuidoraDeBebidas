/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view.Paineis;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.text.ParseException;
import javax.swing.JPanel;

public class Painel_TelaConfig extends javax.swing.JPanel {

    GridBagLayout grid = new GridBagLayout();
    Painel_TelaConfig_Backup CBack;
    Painel_TelaConfig_Usuario CUser;
    Painel_TelaConfig_Empresa CEmpr;

    public Painel_TelaConfig() throws ParseException {
        initComponents();
        CBack = new Painel_TelaConfig_Backup();
        CUser = new Painel_TelaConfig_Usuario();
        CEmpr = new Painel_TelaConfig_Empresa();

        AreaDinamica.setLayout(grid);

        AreaDinamica.add(CBack);
        AreaDinamica.add(CUser);
        AreaDinamica.add(CEmpr);

        CBack.setVisible(false);
        CUser.setVisible(true);
        CEmpr.setVisible(false);
        setBacgroundIsVisible();

    }

    public void setBackgroundBotao(JPanel jp) {
        Botao_Backup.setBackground(new Color(0, 102, 255));
        Botao_Empresa.setBackground(new Color(0, 102, 255));
        Botao_Usuario.setBackground(new Color(0, 102, 255));
        jp.setBackground(new Color(0, 153, 255));
    }

    public void setVisibleTrue(JPanel jp) {
        CBack.setVisible(false);
        CUser.setVisible(false);
        CEmpr.setVisible(false);
        jp.setVisible(true);
    }

    public void setBacgroundIsVisible() {
        if (CBack.isVisible() == true) {
            setBackgroundBotao(Botao_Backup);
        } else if (CUser.isVisible() == true) {
            setBackgroundBotao(Botao_Usuario);
        } else if (CEmpr.isVisible() == true) {
            setBackgroundBotao(Botao_Empresa);
        } else {
            System.out.println("Erro no Menu Lateral");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        AreaDinamica = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Botao_Empresa = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Botao_Backup = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Botao_Usuario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Botao_Despesas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(870, 408));

        jPanel4.setBackground(new java.awt.Color(93, 67, 41));
        jPanel4.setPreferredSize(new java.awt.Dimension(870, 410));

        AreaDinamica.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout AreaDinamicaLayout = new javax.swing.GroupLayout(AreaDinamica);
        AreaDinamica.setLayout(AreaDinamicaLayout);
        AreaDinamicaLayout.setHorizontalGroup(
            AreaDinamicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        AreaDinamicaLayout.setVerticalGroup(
            AreaDinamicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 64, 136));

        Botao_Empresa.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Empresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_EmpresaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_EmpresaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_EmpresaMouseExited(evt);
            }
        });
        Botao_Empresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Factory_15px.png"))); // NOI18N
        Botao_Empresa.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Empresa");
        Botao_Empresa.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 40));

        Botao_Backup.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Backup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_BackupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_BackupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_BackupMouseExited(evt);
            }
        });
        Botao_Backup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Data_Backup_15px.png"))); // NOI18N
        Botao_Backup.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Backup");
        Botao_Backup.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 40));

        Botao_Usuario.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_UsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_UsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_UsuarioMouseExited(evt);
            }
        });
        Botao_Usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_User_Account_15px.png"))); // NOI18N
        Botao_Usuario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Usuários");
        Botao_Usuario.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 40));

        Botao_Despesas.setBackground(new java.awt.Color(0, 64, 136));
        Botao_Despesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_DespesasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_DespesasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_DespesasMouseExited(evt);
            }
        });
        Botao_Despesas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Botao_Despesas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(Botao_Despesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Botao_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Botao_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Botao_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Botao_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botao_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botao_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botao_Despesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AreaDinamica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AreaDinamica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Botao_DespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_DespesasMouseClicked

    }//GEN-LAST:event_Botao_DespesasMouseClicked

    private void Botao_DespesasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_DespesasMouseEntered

    }//GEN-LAST:event_Botao_DespesasMouseEntered

    private void Botao_DespesasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_DespesasMouseExited

    }//GEN-LAST:event_Botao_DespesasMouseExited

    private void Botao_EmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_EmpresaMouseClicked
        setVisibleTrue(CEmpr);
        setBackgroundBotao(Botao_Empresa);
    }//GEN-LAST:event_Botao_EmpresaMouseClicked

    private void Botao_EmpresaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_EmpresaMouseEntered
        Botao_Empresa.setBackground(new Color(0, 153, 255));
        Botao_Empresa.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Botao_EmpresaMouseEntered

    private void Botao_EmpresaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_EmpresaMouseExited
        Botao_Empresa.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_EmpresaMouseExited

    private void Botao_BackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_BackupMouseClicked
        setVisibleTrue(CBack);
        setBackgroundBotao(Botao_Backup);
    }//GEN-LAST:event_Botao_BackupMouseClicked

    private void Botao_BackupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_BackupMouseEntered
        Botao_Backup.setBackground(new Color(0, 153, 255));
        Botao_Backup.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Botao_BackupMouseEntered

    private void Botao_BackupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_BackupMouseExited
        Botao_Backup.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_BackupMouseExited

    private void Botao_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_UsuarioMouseClicked
        setVisibleTrue(CUser);
        setBackgroundBotao(Botao_Usuario);
    }//GEN-LAST:event_Botao_UsuarioMouseClicked

    private void Botao_UsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_UsuarioMouseEntered
        Botao_Usuario.setBackground(new Color(0, 153, 255));
        Botao_Usuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Botao_UsuarioMouseEntered

    private void Botao_UsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_UsuarioMouseExited
        Botao_Usuario.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_UsuarioMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AreaDinamica;
    private javax.swing.JPanel Botao_Backup;
    private javax.swing.JPanel Botao_Despesas;
    private javax.swing.JPanel Botao_Empresa;
    private javax.swing.JPanel Botao_Usuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
