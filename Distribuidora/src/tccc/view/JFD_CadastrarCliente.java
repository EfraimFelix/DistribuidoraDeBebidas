/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view;

import tccc.WebServiceCep;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.JXTable;
import tccc.ControleDeColuna;
import tccc.DAO.ClienteDAO;
import tccc.Modelo.Cliente;

/**
 *
 * @author Efraim
 */
public class JFD_CadastrarCliente extends javax.swing.JDialog {

    JXTable Tbl;
    ClienteDAO dao = new ClienteDAO();
    int xMouse, yMouse;
    
    public JFD_CadastrarCliente(java.awt.Frame parent, boolean modal, JXTable tb) throws ParseException {
        super(parent, modal);
         initComponents();
        this.setLocationRelativeTo(null);
        Tbl = tb;
        lblcadastro.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtnascimento.setDate(Date.valueOf(java.time.LocalDate.now()));
        
        txtnome.addFocusListener(new CaretPosition());
        txttelefone.addFocusListener(new CaretPosition());
        txtcpf_cnpj.addFocusListener(new CaretPosition());
        txtcep.addFocusListener(new CaretPosition());
        txtendereco.addFocusListener(new CaretPosition());
        txtcomplemento.addFocusListener(new CaretPosition());
        txtbairro.addFocusListener(new CaretPosition());
        txtcidade.addFocusListener(new CaretPosition());

        MaskFormatter mascara_cep = new MaskFormatter("##.###-###");
        mascara_cep.setPlaceholderCharacter('0');
        mascara_cep.install(txtcep);

        MaskFormatter mascara_cpf = new MaskFormatter("###.###.###-##");
        mascara_cpf.setPlaceholderCharacter('0');
        mascara_cpf.install(txtcpf_cnpj);

        MaskFormatter mascara_telefone = new MaskFormatter("(##) ####-####");
        mascara_telefone.setPlaceholderCharacter('0');
        mascara_telefone.install(txttelefone);
    }

    private JFD_CadastrarCliente(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
class CaretPosition extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {

            JTextComponent comp = (JTextComponent) e.getSource();
            comp.setCaretPosition(0);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        MovimentarJanela = new javax.swing.JPanel();
        fechar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblcadastro = new javax.swing.JLabel();
        lblnome = new javax.swing.JLabel();
        lblend = new javax.swing.JLabel();
        lblbairro = new javax.swing.JLabel();
        lblcidade = new javax.swing.JLabel();
        lblcep = new javax.swing.JLabel();
        lblsexo = new javax.swing.JLabel();
        lblnumero = new javax.swing.JLabel();
        lblcomplemento = new javax.swing.JLabel();
        lblestado = new javax.swing.JLabel();
        lblcpf = new javax.swing.JLabel();
        lblidade = new javax.swing.JLabel();
        lbltelefone = new javax.swing.JLabel();
        txtendereco = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        txtcidade = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        cbsexo = new javax.swing.JComboBox<>();
        txtcpf_cnpj = new javax.swing.JFormattedTextField();
        txttelefone = new javax.swing.JFormattedTextField();
        txtcep = new javax.swing.JFormattedTextField();
        txtnascimento = new com.toedter.calendar.JDateChooser();
        txtnascimento.getDateEditor().setEnabled(false);
        numero = new javax.swing.JSpinner();
        SpinnerNumberModel novo = new SpinnerNumberModel (0, 0, 1000000, 1);
        numero.setModel(novo);
        ((DefaultFormatter) ((JSpinner.NumberEditor) numero.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        cbuf = new javax.swing.JComboBox<>();
        cbuf.getModel().setSelectedItem("SP");
        rbpf = new javax.swing.JRadioButton();
        rbpf.setSelected(true);
        rbpj = new javax.swing.JRadioButton();
        Entrar = new javax.swing.JPanel();
        Entrar_1 = new javax.swing.JLabel();
        txtcomplemento = new javax.swing.JTextField();
        Buscar = new javax.swing.JPanel();
        Entrar_2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

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

        lblcadastro.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblcadastro.setForeground(new java.awt.Color(255, 255, 255));
        lblcadastro.setText("Cadastro de Cliente");

        lblnome.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblnome.setForeground(new java.awt.Color(255, 255, 255));
        lblnome.setText("Nome:");

        lblend.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblend.setForeground(new java.awt.Color(255, 255, 255));
        lblend.setText("Endereço:");

        lblbairro.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblbairro.setForeground(new java.awt.Color(255, 255, 255));
        lblbairro.setText("Bairro:");

        lblcidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcidade.setForeground(new java.awt.Color(255, 255, 255));
        lblcidade.setText("Cidade:");

        lblcep.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcep.setForeground(new java.awt.Color(255, 255, 255));
        lblcep.setText("CEP:");

        lblsexo.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblsexo.setForeground(new java.awt.Color(255, 255, 255));
        lblsexo.setText("Sexo:");

        lblnumero.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblnumero.setForeground(new java.awt.Color(255, 255, 255));
        lblnumero.setText("Numero:");

        lblcomplemento.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcomplemento.setForeground(new java.awt.Color(255, 255, 255));
        lblcomplemento.setText("Complemento:");

        lblestado.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblestado.setForeground(new java.awt.Color(255, 255, 255));
        lblestado.setText("UF:");

        lblcpf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcpf.setForeground(new java.awt.Color(255, 255, 255));
        lblcpf.setText("CPF:");

        lblidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblidade.setForeground(new java.awt.Color(255, 255, 255));
        lblidade.setText("Nascimento:");

        lbltelefone.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbltelefone.setForeground(new java.awt.Color(255, 255, 255));
        lbltelefone.setText("Telefone:");

        txtendereco.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtendereco.setForeground(new java.awt.Color(255, 255, 255));
        txtendereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtenderecoActionPerformed(evt);
            }
        });

        txtnome.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtnome.setForeground(new java.awt.Color(255, 255, 255));

        txtcidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcidade.setForeground(new java.awt.Color(255, 255, 255));

        txtbairro.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtbairro.setForeground(new java.awt.Color(255, 255, 255));

        cbsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        txtcpf_cnpj.setBorder(null);
        txtcpf_cnpj.setForeground(new java.awt.Color(255, 255, 255));
        txtcpf_cnpj.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcpf_cnpj.setPreferredSize(new java.awt.Dimension(4, 24));

        txttelefone.setBorder(null);
        txttelefone.setForeground(new java.awt.Color(255, 255, 255));
        txttelefone.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txttelefone.setPreferredSize(new java.awt.Dimension(4, 24));

        txtcep.setBorder(null);
        txtcep.setForeground(new java.awt.Color(255, 255, 255));
        txtcep.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcep.setPreferredSize(new java.awt.Dimension(4, 24));
        txtcep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcepKeyPressed(evt);
            }
        });

        txtnascimento.setForeground(new java.awt.Color(255, 255, 255));
        txtnascimento.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtnascimento.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        txtnascimento.setMinimumSize(new java.awt.Dimension(50, 24));
        txtnascimento.setPreferredSize(new java.awt.Dimension(118, 24));

        numero.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        cbuf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cbuf.setForeground(new java.awt.Color(255, 255, 255));
        cbuf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        buttonGroup1.add(rbpf);
        rbpf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rbpf.setForeground(new java.awt.Color(255, 255, 255));
        rbpf.setText("Pessoa Física");
        rbpf.setOpaque(false);
        rbpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbpfMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbpj);
        rbpj.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rbpj.setForeground(new java.awt.Color(255, 255, 255));
        rbpj.setText("Pessoa Jurídica");
        rbpj.setOpaque(false);
        rbpj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbpjMouseClicked(evt);
            }
        });

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

        Entrar_1.setBackground(new java.awt.Color(65, 105, 225));
        Entrar_1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Entrar_1.setForeground(new java.awt.Color(255, 255, 255));
        Entrar_1.setText("Cadastrar");

        javax.swing.GroupLayout EntrarLayout = new javax.swing.GroupLayout(Entrar);
        Entrar.setLayout(EntrarLayout);
        EntrarLayout.setHorizontalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EntrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar_1)
                .addContainerGap())
        );
        EntrarLayout.setVerticalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EntrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtcomplemento.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcomplemento.setForeground(new java.awt.Color(255, 255, 255));

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
            .addGroup(BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MovimentarJanela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbltelefone)
                        .addGap(50, 50, 50)
                        .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(lblend))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(rbpf)
                                .addGap(36, 36, 36)
                                .addComponent(rbpj))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblcpf)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcpf_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblidade)
                                    .addGap(35, 35, 35)
                                    .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcomplemento)
                            .addComponent(lblbairro)
                            .addComponent(lblcidade)
                            .addComponent(lblestado))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbairro, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtcidade))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblsexo)
                                .addGap(73, 73, 73)
                                .addComponent(cbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168)
                                .addComponent(lblnumero)
                                .addGap(75, 75, 75)
                                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblnome)
                                    .addGap(68, 68, 68)
                                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71)
                                    .addComponent(lblcep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(85, 85, 85)
                                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcadastro)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblnome))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblcep))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbltelefone))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblend))
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblsexo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(cbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblnumero))
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbpf)
                            .addComponent(rbpj))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcpf)
                            .addComponent(txtcpf_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblcomplemento)
                        .addGap(26, 26, 26)
                        .addComponent(lblbairro)
                        .addGap(26, 26, 26)
                        .addComponent(lblcidade)
                        .addGap(27, 27, 27)
                        .addComponent(lblestado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtenderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtenderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtenderecoActionPerformed

    private void txtcepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcepKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_txtcepKeyPressed

    private void rbpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbpfMouseClicked
        MaskFormatter mascara_cpf;
        try {
            txtcpf_cnpj.setValue("");
            mascara_cpf = new MaskFormatter("###.###.###-##");
            mascara_cpf.setPlaceholderCharacter('0');
            mascara_cpf.install(txtcpf_cnpj);
            lblcpf.setText("CPF:");
        } catch (ParseException ex) {
            Logger.getLogger(JFD_CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rbpfMouseClicked

    private void rbpjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbpjMouseClicked
        MaskFormatter mascara_cpf;
        try {
            txtcpf_cnpj.setValue("");
            mascara_cpf = new MaskFormatter("##.###.###/####-##");
            mascara_cpf.setPlaceholderCharacter('0');
            mascara_cpf.install(txtcpf_cnpj);
            lblcpf.setText("CNPJ:");
        } catch (ParseException ex) {
            Logger.getLogger(JFD_CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rbpjMouseClicked

    private void EntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarMouseClicked
        try {
            java.util.Date pega = txtnascimento.getDate();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            Cliente c = new Cliente();
            if (rbpf.isSelected()) {
                c.setPessoa("Fisica");
            }
            if (rbpj.isSelected()) {
                c.setPessoa("Juridica");
            }

            c.setNome(txtnome.getText());
            c.setTelefone(txttelefone.getText());
            c.setEndereco(txtendereco.getText());
            c.setNumero((int) numero.getValue());
            c.setComplemento(txtcomplemento.getText());
            c.setBairro(txtbairro.getText());
            c.setCidade(txtcidade.getText());
            c.setEstado(String.valueOf(cbuf.getSelectedItem()));
            c.setCep(txtcep.getText());
            c.setSexo(String.valueOf(cbsexo.getSelectedItem()));
            c.setCpf_cnpj(txtcpf_cnpj.getText());
            c.setNascimento(formato.format(pega));

            dao.adicionar(c);
            dao.ListarTabela(Tbl);

            Component comp = SwingUtilities.getRoot(this);
            ((Window) comp).dispose();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        ControleDeColuna c = new ControleDeColuna(Tbl, true);
    }//GEN-LAST:event_EntrarMouseClicked

    private void EntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarMouseEntered
        Entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EntrarMouseEntered

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        buscaCep();
    }//GEN-LAST:event_BuscarMouseClicked
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
            System.out.println("Erro numero: " + webServiceCep.getResulCode());
            System.out.println("Descrição do erro: " + webServiceCep.getResultText());
        }
    }
    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BuscarMouseEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buscar;
    private javax.swing.JPanel Entrar;
    private javax.swing.JLabel Entrar_1;
    private javax.swing.JLabel Entrar_2;
    private javax.swing.JPanel MovimentarJanela;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbsexo;
    private javax.swing.JComboBox<String> cbuf;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblbairro;
    private javax.swing.JLabel lblcadastro;
    private javax.swing.JLabel lblcep;
    private javax.swing.JLabel lblcidade;
    private javax.swing.JLabel lblcomplemento;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JLabel lblend;
    private javax.swing.JLabel lblestado;
    private javax.swing.JLabel lblidade;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lblnumero;
    private javax.swing.JLabel lblsexo;
    private javax.swing.JLabel lbltelefone;
    private javax.swing.JSpinner numero;
    private javax.swing.JRadioButton rbpf;
    private javax.swing.JRadioButton rbpj;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JTextField txtcomplemento;
    private javax.swing.JFormattedTextField txtcpf_cnpj;
    private javax.swing.JTextField txtendereco;
    private com.toedter.calendar.JDateChooser txtnascimento;
    private javax.swing.JTextField txtnome;
    private javax.swing.JFormattedTextField txttelefone;
    // End of variables declaration//GEN-END:variables
}