/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view.Paineis;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Window;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;
import tccc.DAO.EmpresaDAO;
import tccc.Modelo.Empresa;
import tccc.WebServiceCep;
import tccc.view.Menu;

/**
 *
 * @author Efraim
 */
public class Painel_TelaConfig_Empresa extends javax.swing.JPanel {

    /**
     * Creates new form Painel_TelaConfig_Empresa
     */
    public Painel_TelaConfig_Empresa() throws ParseException {
        initComponents();

        MaskFormatter mascara_cep = new MaskFormatter("##.###-###");
        mascara_cep.setPlaceholderCharacter('0');
        mascara_cep.install(txtcep);
        MaskFormatter mascara_telefone = new MaskFormatter("(##) ####-####");
        mascara_telefone.setPlaceholderCharacter('0');
        mascara_telefone.install(txttelefone1);
        mascara_telefone.install(txttelefone2);

        colocar();
    }

    public void colocar() {
        EmpresaDAO daoemp = new EmpresaDAO();
        List<Empresa> empresa = daoemp.Lista();
        for (Empresa emp : empresa) {

            txtendereco.setText("" + emp.getEndereco());

            txtbairro.setText("" + emp.getBairro());
            txtcidade.setText("" + emp.getCidade());
            SpinnerNumberModel novo = new SpinnerNumberModel(emp.getNumero(), 0, 1000000, 1);
            JSpNumero.setModel(novo);
            txtcep.setValue("" + emp.getCep());
            cbuf.setSelectedItem("" + emp.getEstado());
            txtnome.setText("" + emp.getNome());
            txtemail.setText("" + emp.getEmail());
            txttelefone1.setText("" + emp.getTelefone1());
            txttelefone2.setText("" + emp.getTelefone2());
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtendereco = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        txtcidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JSpNumero = new javax.swing.JSpinner();
        SpinnerNumberModel novo = new SpinnerNumberModel (0, 0, 1000000, 1);
        JSpNumero.setModel(novo);
        ((DefaultFormatter) ((JSpinner.NumberEditor) JSpNumero.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        txtcep = new javax.swing.JFormattedTextField();
        Buscar = new javax.swing.JPanel();
        Entrar_2 = new javax.swing.JLabel();
        txttelefone1 = new javax.swing.JFormattedTextField();
        txttelefone2 = new javax.swing.JFormattedTextField();
        cbuf = new javax.swing.JComboBox<>();
        cbuf.getModel().setSelectedItem("SP");
        Entrar = new javax.swing.JPanel();
        Entrar_3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 115, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Telefone 1:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 115, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefone 2:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 115, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 115, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CEP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 115, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        txtnome.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 58, 0, 0);
        jPanel1.add(txtnome, gridBagConstraints);

        txtemail.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 176;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 58, 0, 0);
        jPanel1.add(txtemail, gridBagConstraints);

        txtendereco.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 131;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 43, 0, 0);
        jPanel1.add(txtendereco, gridBagConstraints);

        txtbairro.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 162;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 43, 0, 115);
        jPanel1.add(txtbairro, gridBagConstraints);

        txtcidade.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 162;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 43, 0, 115);
        jPanel1.add(txtcidade, gridBagConstraints);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Endereço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 35, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bairro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 35, 0, 0);
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 35, 0, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 35, 0, 0);
        jPanel1.add(jLabel9, gridBagConstraints);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Numero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 35, 0, 0);
        jPanel1.add(jLabel10, gridBagConstraints);

        JSpNumero.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 43, 0, 0);
        jPanel1.add(JSpNumero, gridBagConstraints);

        txtcep.setBorder(null);
        txtcep.setForeground(new java.awt.Color(255, 255, 255));
        txtcep.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcep.setPreferredSize(new java.awt.Dimension(4, 24));
        txtcep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcepKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 58, 0, 0);
        jPanel1.add(txtcep, gridBagConstraints);

        Buscar.setBackground(new java.awt.Color(0, 0, 0));
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarMouseEntered(evt);
            }
        });

        Entrar_2.setBackground(new java.awt.Color(65, 105, 225));
        Entrar_2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Entrar_2.setForeground(new java.awt.Color(255, 255, 255));
        Entrar_2.setText("Buscar");

        javax.swing.GroupLayout BuscarLayout = new javax.swing.GroupLayout(Buscar);
        Buscar.setLayout(BuscarLayout);
        BuscarLayout.setHorizontalGroup(
            BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BuscarLayout.setVerticalGroup(
            BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar_2)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 9, 0, 0);
        jPanel1.add(Buscar, gridBagConstraints);

        txttelefone1.setBorder(null);
        txttelefone1.setForeground(new java.awt.Color(255, 255, 255));
        txttelefone1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txttelefone1.setPreferredSize(new java.awt.Dimension(4, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 97;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 58, 0, 0);
        jPanel1.add(txttelefone1, gridBagConstraints);

        txttelefone2.setBorder(null);
        txttelefone2.setForeground(new java.awt.Color(255, 255, 255));
        txttelefone2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txttelefone2.setPreferredSize(new java.awt.Dimension(4, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 97;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 58, 0, 0);
        jPanel1.add(txttelefone2, gridBagConstraints);

        cbuf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cbuf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 43, 0, 0);
        jPanel1.add(cbuf, gridBagConstraints);

        Entrar.setBackground(new java.awt.Color(0, 0, 0));
        Entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EntrarMouseEntered(evt);
            }
        });

        Entrar_3.setBackground(new java.awt.Color(65, 105, 225));
        Entrar_3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Entrar_3.setForeground(new java.awt.Color(255, 255, 255));
        Entrar_3.setText("Alterar");

        javax.swing.GroupLayout EntrarLayout = new javax.swing.GroupLayout(Entrar);
        Entrar.setLayout(EntrarLayout);
        EntrarLayout.setHorizontalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EntrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar_3)
                .addContainerGap())
        );
        EntrarLayout.setVerticalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EntrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 23, 50, 0);
        jPanel1.add(Entrar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtcepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcepKeyPressed

    }//GEN-LAST:event_txtcepKeyPressed

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        buscaCep();
    }//GEN-LAST:event_BuscarMouseClicked

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Buscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BuscarMouseEntered

    private void EntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarMouseClicked
        try {
            EmpresaDAO dao = new EmpresaDAO();
            Empresa e = new Empresa();
            e.setNome(txtnome.getText());
            e.setEndereco(txtendereco.getText());
            e.setNumero((int) JSpNumero.getValue());
            e.setBairro(txtbairro.getText());
            e.setCidade(txtcidade.getText());
            e.setEstado(String.valueOf(cbuf.getSelectedItem()));
            e.setCep(txtcep.getText());
            e.setEmail(txtemail.getText());
            e.setTelefone1(txttelefone1.getText());
            e.setTelefone2(txttelefone2.getText());

            dao.Alterar(e);
            JOptionPane.showMessageDialog(null, "O sistema será reiniciado para fazer a alteração dos dados");
            Component comp = SwingUtilities.getRoot(this);
            ((Window) comp).dispose();
            Menu mm = new Menu(1);
            mm.setVisible(true);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }

    }//GEN-LAST:event_EntrarMouseClicked

    private void EntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarMouseEntered
        Entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EntrarMouseEntered
    public void buscaCep() {
        //Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(txtcep.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            txtendereco.setText(webServiceCep.getLogradouroFull());
            txtcidade.setText(webServiceCep.getCidade());
            txtbairro.setText(webServiceCep.getBairro());
            cbuf.setSelectedItem(webServiceCep.getUf());
            System.out.println("Cep: " + webServiceCep.getCep());
            System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
            System.out.println("Bairro: " + webServiceCep.getBairro());
            System.out.println("Cidade: " + webServiceCep.getCidade() + "/" + webServiceCep.getUf());

            //caso haja problemas imprime as exce??es.
        } else {
            if (webServiceCep.getResulCode() == 0) {
                JOptionPane.showMessageDialog(null, "Cep não encontrado");

            } else {
                System.out.println("Erro numero: " + webServiceCep.getResulCode());
                System.out.println("Descrição do erro: " + webServiceCep.getResultText());
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buscar;
    private javax.swing.JPanel Entrar;
    private javax.swing.JLabel Entrar_2;
    private javax.swing.JLabel Entrar_3;
    private javax.swing.JSpinner JSpNumero;
    private javax.swing.JComboBox<String> cbuf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtnome;
    private javax.swing.JFormattedTextField txttelefone1;
    private javax.swing.JFormattedTextField txttelefone2;
    // End of variables declaration//GEN-END:variables
}
