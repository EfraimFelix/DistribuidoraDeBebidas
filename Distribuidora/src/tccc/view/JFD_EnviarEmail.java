/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view;

import java.awt.Cursor;
import java.util.Random;
import javax.swing.JOptionPane;
import tccc.CommonsMail;
import tccc.DAO.UsuarioDAO;
import tccc.Modelo.Usuario;

public class JFD_EnviarEmail extends javax.swing.JDialog {

    int xMouse, yMouse;
    
    public JFD_EnviarEmail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
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
        txtnome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MovimentarJanela = new javax.swing.JPanel();
        fechar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NovaSenha = new javax.swing.JPanel();
        Entrar_3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        txtnome.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário:");

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

        NovaSenha.setBackground(new java.awt.Color(0, 0, 0));
        NovaSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NovaSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NovaSenhaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NovaSenhaMouseEntered(evt);
            }
        });

        Entrar_3.setBackground(new java.awt.Color(65, 105, 225));
        Entrar_3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Entrar_3.setForeground(new java.awt.Color(255, 255, 255));
        Entrar_3.setText("Nova senha");

        javax.swing.GroupLayout NovaSenhaLayout = new javax.swing.GroupLayout(NovaSenha);
        NovaSenha.setLayout(NovaSenhaLayout);
        NovaSenhaLayout.setHorizontalGroup(
            NovaSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NovaSenhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar_3)
                .addContainerGap())
        );
        NovaSenhaLayout.setVerticalGroup(
            NovaSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovaSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MovimentarJanela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addComponent(NovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void NovaSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovaSenhaMouseClicked
        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario user = new Usuario();
            CommonsMail CM = new CommonsMail();

            user.setNome(txtnome.getText());
            if (dao.VerificaNomeUsuario(user) == true) {
                if (user.getEmail() == null) {
                    JOptionPane.showMessageDialog(null, "Conta sem email, contacte um administrador !");
                } else {
                    jPanel1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                    String exemplo = user.getEmail(); //Pega o email (exemplo efraim856@gmail.com)
                    String[] saida = exemplo.split("@"); //Divide o email em dois, pois todo email tem apenas um @ e por isso que dividiremos usando por base o @ (ficaria assim saida[0] = efraim856 e saida[1] = gmail.com)

                    int r = ((saida[0].length()) / 4) * 3; //O length retorna o numero de caracteres q tem a string, no cado saida[0](efraim856)
                    int valor;
                    StringBuilder email = new StringBuilder(saida[0]); //Criamos um StringBuilder pois ele aceita diversas modificações e nao ocupa muita memoria, setamos a varivel como saida[0](efraim856)
                    for (int i = 0; i < r; i++) { //
                        valor = saida[0].length() - i - 1;
                        email.setCharAt(valor, '*'); //Trocamos os cacter por * de acordo com a variavel 'valor'
                    }
                    StringBuilder Email = new StringBuilder();
                    Email.append(email); // aki
                    Email.append("@"); // colocamos
                    Email.append(saida[1]); // o email como estava apenas adicionado os *

                    Random ra = new Random();// aki
                    String s = Long.toHexString(ra.nextLong());//criamos uma senha hexadecimal
                    user.setSenha(s);//
                    

                    CM.EnviarEmail("Nova Senha", "Sua nova senha é - " + s, user.getEmail());
                    dao.TrocarSenhaUsuario(user);
                    JOptionPane.showMessageDialog(null, "O e-email com sua nova senha foi enviado para o e-mail - " + Email);
                    jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nome de usuário não existe");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_NovaSenhaMouseClicked

    private void NovaSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovaSenhaMouseEntered
        NovaSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_NovaSenhaMouseEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Entrar_3;
    private javax.swing.JPanel MovimentarJanela;
    private javax.swing.JPanel NovaSenha;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables
}
