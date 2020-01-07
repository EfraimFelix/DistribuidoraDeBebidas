/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view.Paineis;

import com.lowagie.text.BadElementException;
import java.awt.Cursor;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tccc.ControleDeColuna;
import tccc.DAO.FuncionarioDAO;
import tccc.GerarPDF;
import tccc.Modelo.Funcionario;
import tccc.view.JFD_AlterarFuncionario;
import tccc.view.JFD_CadastrarFuncionario;
import tccc.view.Menu;

/**
 *
 * @author Efraim
 */
public class Painel_TelaFuncionario extends javax.swing.JPanel {

    FuncionarioDAO dao = new FuncionarioDAO();

    public Painel_TelaFuncionario() {
        initComponents();
        try {

            ListarTabela();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }

    }

    public void ListarTabela() {
        dao.ListarTabela(TblFuncionario);
        ControleDeColuna c = new ControleDeColuna(TblFuncionario, true);
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
        jPanel2 = new javax.swing.JPanel();
        BotaoNovo = new javax.swing.JLabel();
        LblNovo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BotaoAtualizar = new javax.swing.JLabel();
        LblAtualizar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BotaoExcluir = new javax.swing.JLabel();
        LblExcluir = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BotaoImprimir = new javax.swing.JLabel();
        LblImprimir = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        CbCampo = new javax.swing.JComboBox<>();
        TxtPesquisa = new javax.swing.JFormattedTextField();
        BotaoPesquisar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblFuncionario = new org.jdesktop.swingx.JXTable();

        setPreferredSize(new java.awt.Dimension(870, 410));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(870, 410));
        jPanel1.setPreferredSize(new java.awt.Dimension(870, 410));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        BotaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Add_File_65px.png"))); // NOI18N
        BotaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoNovoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoNovoMouseEntered(evt);
            }
        });

        LblNovo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        LblNovo.setForeground(new java.awt.Color(255, 255, 255));
        LblNovo.setText("Novo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoNovo)
                    .addComponent(LblNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblNovo))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        BotaoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Edit_File_65px_1.png"))); // NOI18N
        BotaoAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoAtualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAtualizarMouseEntered(evt);
            }
        });

        LblAtualizar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        LblAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        LblAtualizar.setText("Alterar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoAtualizar)
                    .addComponent(LblAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblAtualizar))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        BotaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Delete_File_65px.png"))); // NOI18N
        BotaoExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoExcluirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoExcluirMouseEntered(evt);
            }
        });

        LblExcluir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        LblExcluir.setForeground(new java.awt.Color(255, 255, 255));
        LblExcluir.setText("Excluir");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoExcluir)
                    .addComponent(LblExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblExcluir))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        BotaoImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Print_65px.png"))); // NOI18N
        BotaoImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoImprimirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoImprimirMouseEntered(evt);
            }
        });

        LblImprimir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        LblImprimir.setForeground(new java.awt.Color(255, 255, 255));
        LblImprimir.setText("Relátorio");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LblImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotaoImprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblImprimir))
        );

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CbCampo.setForeground(new java.awt.Color(255, 255, 255));
        CbCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome", "Telefone", "Cargo", "Salário", "CEP", "Bairro", "Cidade", "UF", "Sexo", "CPF", "Nascimento" }));
        CbCampo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbCampoItemStateChanged(evt);
            }
        });
        CbCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CbCampoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CbCampoMousePressed(evt);
            }
        });
        jPanel6.add(CbCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 40, 90, -1));

        TxtPesquisa.setBorder(null);
        TxtPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        TxtPesquisa.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        TxtPesquisa.setPreferredSize(new java.awt.Dimension(4, 24));
        jPanel6.add(TxtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 44, 140, 20));

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
        jPanel6.add(BotaoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 30, 50));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Pesquisar");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 290, -1));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        TblFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        TblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Cargo", "Salário", "CEP", "Bairro", "Cidade", "UF", "Sexo", "CPF", "Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblFuncionario.setToolTipText("");
        TblFuncionario.setEditable(false);
        TblFuncionario.setFillsViewportHeight(false);
        TblFuncionario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TblFuncionario.setGridColor(new java.awt.Color(0, 0, 0));
        TblFuncionario.setHorizontalScrollEnabled(true);
        TblFuncionario.setSearchable(null);
        TblFuncionario.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(TblFuncionario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoNovoMouseClicked
        try {
            Menu menu = new Menu();
            if (System.getProperty("Usuario_TipoConta").equals("Administrador")) {
                JFD_CadastrarFuncionario CC;
                CC = new JFD_CadastrarFuncionario(menu, true, TblFuncionario);
                CC.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Desculpa, mas apenas administradores tem acesso a está página");
            }
        } catch (ParseException ex) {
            Logger.getLogger(Painel_TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoNovoMouseClicked

    private void BotaoNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoNovoMouseEntered
        BotaoNovo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BotaoNovoMouseEntered

    private void BotaoAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarMouseClicked
        if (System.getProperty("Usuario_TipoConta").equals("Administrador")) {
            try {
                Menu menu = new Menu();
                Funcionario f = new Funcionario();
                FuncionarioDAO dao = new FuncionarioDAO();

                int linha = TblFuncionario.getSelectedRow();
                int Id = 0;

                if (linha != -1) {
                    Id = Integer.parseInt(TblFuncionario.getValueAt(TblFuncionario.getSelectedRow(), 0).toString());
                    dao.BuscarFuncionarioID(Id, f);

                    JFD_AlterarFuncionario AF = new JFD_AlterarFuncionario(
                            menu,
                            true,
                            TblFuncionario,
                            f.getId_funcionario(),
                            String.valueOf(f.getNome()),
                            String.valueOf(f.getTelefone()),
                            String.valueOf(f.getCargo()),
                            String.format("%.2f", f.getSalario()),
                            String.valueOf(f.getBairro()),
                            String.valueOf(f.getCidade()),
                            String.valueOf(f.getEstado()),
                            String.valueOf(f.getCep()),
                            String.valueOf(f.getSexo()),
                            String.valueOf(f.getCpf()),
                            Date.valueOf(String.valueOf(f.getNascimento())));
                    AF.setVisible(true);
                } else if (linha != -0) {
                    JOptionPane.showMessageDialog(null, "Por favor, clique em algum cadastro");
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Desculpa, mas apenas administradores tem acesso a está página");
        }
    }//GEN-LAST:event_BotaoAtualizarMouseClicked

    private void BotaoAtualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarMouseEntered
        BotaoAtualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BotaoAtualizarMouseEntered

    private void BotaoExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirMouseClicked
        if (System.getProperty("Usuario_TipoConta").equals("Administrador")) {
            try {
                FuncionarioDAO dao = new FuncionarioDAO();

                int linha = TblFuncionario.getSelectedRow();
                int Id = 0;

                if (linha != -1) {
                    int r = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este cadastro?", "Mensagem", JOptionPane.YES_NO_OPTION);
                    if (r == 0) {
                        Id = Integer.parseInt(TblFuncionario.getValueAt(TblFuncionario.getSelectedRow(), 0).toString());
                        dao.Remover(Id);
                        dao.ListarTabela(TblFuncionario);
                    }

                } else if (linha != -0) {
                    JOptionPane.showMessageDialog(null, "Por favor, clique em algum cadastro");
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Desculpa, mas apenas administradores tem acesso a está página");
        }
    }//GEN-LAST:event_BotaoExcluirMouseClicked

    private void BotaoExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirMouseEntered
        BotaoExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BotaoExcluirMouseEntered

    private void BotaoImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoImprimirMouseClicked
        try {
            GerarPDF pdf = new GerarPDF();
            pdf.criarPDF(TblFuncionario, "RelatorioFuncionario");
            pdf.abrirPDF("RelatorioFuncionario");
        } catch (BadElementException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_BotaoImprimirMouseClicked

    private void BotaoImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoImprimirMouseEntered
        BotaoImprimir.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BotaoImprimirMouseEntered

    private void CbCampoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbCampoItemStateChanged
        TxtPesquisa.setText("");
        try {
            if (CbCampo.getSelectedIndex() == 0) {
                dao.Pesquisar("IdTB_Funcionario", "", TblFuncionario);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_CbCampoItemStateChanged

    private void CbCampoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbCampoMouseClicked

    }//GEN-LAST:event_CbCampoMouseClicked

    private void CbCampoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbCampoMousePressed

    }//GEN-LAST:event_CbCampoMousePressed

    private void BotaoPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseClicked
        String campo = null;
        switch (CbCampo.getSelectedIndex()) {
            case 1:
                campo = "IdTB_Funcionario";
                break;
            case 2:
                campo = "Funcionario_Nome";
                break;
            case 3:
                campo = "Funcionario_Telefone";
                break;
            case 4:
                campo = "Cargo_Descricao";
                break;
            case 5:
                campo = "Funcionario_Salario";
                break;
            case 6:
                campo = "Funcionario_CEP";
                break;
            case 7:
                campo = "Funcionario_Bairro";
                break;
            case 8:
                campo = "Funcionario_Cidade";
                break;
            case 9:
                campo = "Funcionario_Estado";
                break;
            case 10:
                campo = "Funcionario_Sexo";
                break;
            case 11:
                campo = "Funcionario_CPF";
                break;
            case 12:
                campo = "Funcionario_Nascimento";
                break;
            default:
                campo = "IdTB_Funcionario";
                break;
        }
        dao.Pesquisar(campo, TxtPesquisa.getText(), TblFuncionario);
    }//GEN-LAST:event_BotaoPesquisarMouseClicked

    private void BotaoPesquisarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseEntered
        BotaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_3.png")));
        BotaoPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BotaoPesquisarMouseEntered

    private void BotaoPesquisarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPesquisarMouseExited
        BotaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png")));
    }//GEN-LAST:event_BotaoPesquisarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotaoAtualizar;
    private javax.swing.JLabel BotaoExcluir;
    private javax.swing.JLabel BotaoImprimir;
    private javax.swing.JLabel BotaoNovo;
    private javax.swing.JLabel BotaoPesquisar;
    private javax.swing.JComboBox<String> CbCampo;
    private javax.swing.JLabel LblAtualizar;
    private javax.swing.JLabel LblExcluir;
    private javax.swing.JLabel LblImprimir;
    private javax.swing.JLabel LblNovo;
    private org.jdesktop.swingx.JXTable TblFuncionario;
    private javax.swing.JFormattedTextField TxtPesquisa;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
