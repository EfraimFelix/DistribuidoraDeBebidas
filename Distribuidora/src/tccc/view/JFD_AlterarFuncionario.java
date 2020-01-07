/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view;

import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Cursor;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.JXTable;
import tccc.ControleDeColuna;
import tccc.DAO.CargoDAO;
import tccc.DAO.FuncionarioDAO;
import tccc.JMoneyField_Transformar;
import tccc.Modelo.Cargo;
import tccc.Modelo.Funcionario;
import tccc.WebServiceCep;

public class JFD_AlterarFuncionario extends javax.swing.JDialog {

    JXTable Tbl;
    FuncionarioDAO dao = new FuncionarioDAO();
    int xMouse, yMouse;
    String cargo;

    public JFD_AlterarFuncionario(
            java.awt.Frame parent,
            boolean modal,
            JXTable Tbl1,
            int Id,
            String Nome,
            String Telefone,
            String Cargo,
            String Salario,
            String Bairro,
            String Cidade,
            String Estado,
            String Cep,
            String Sexo,
            String Cpf,
            Date Nascimento
    ) throws ParseException {
        super(parent, modal);
        initComponents();
        Tbl = Tbl1;

        txtnome.grabFocus();

        txtid.setText("" + Id);
        txtnome.setText(Nome);
        txttelefone.setValue("" + Telefone);
        cargo = Cargo;
        txtsalario.setText(Salario);
        txtbairro.setText(Bairro);
        txtcidade.setText(Cidade);
        cbuf.setSelectedItem(Estado);
        txtcep.setValue(Cep);
        cbsexo.setSelectedItem(Sexo);
        txtcpf.setValue(Cpf);
        txtnascimento.setDate(Nascimento);

        txtnome.addFocusListener(new CaretPosition());
        txttelefone.addFocusListener(new CaretPosition());
        txtcpf.addFocusListener(new CaretPosition());
        txtsalario.addFocusListener(new CaretPosition());
        txtcep.addFocusListener(new CaretPosition());
        txtbairro.addFocusListener(new CaretPosition());
        txtcidade.addFocusListener(new CaretPosition());

        lblcadastro.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        MaskFormatter mascara_cep = new MaskFormatter("##.###-###");
        mascara_cep.setValidCharacters("0123456789");
        mascara_cep.install(txtcep);

        MaskFormatter mascara_cpf = new MaskFormatter("###.###.###-##");
        mascara_cpf.setValidCharacters("0123456789");
        mascara_cpf.install(txtcpf);

        MaskFormatter mascara_telefone = new MaskFormatter("(##) ####-####");
        mascara_telefone.setValidCharacters("0123456789");
        mascara_telefone.install(txttelefone);

        this.setLocationRelativeTo(null);
    }

    private JFD_AlterarFuncionario(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class CaretPosition extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {

            JTextComponent comp = (JTextComponent) e.getSource();
            comp.setCaretPosition(0);
        }
    }

    public void buscaCep() {
        //Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(txtcep.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lblcomplemento = new javax.swing.JLabel();
        lblcpf = new javax.swing.JLabel();
        lblidade = new javax.swing.JLabel();
        lbltelefone = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtcidade = new javax.swing.JTextField();
        cbsexo = new javax.swing.JComboBox<>();
        txtcpf = new javax.swing.JFormattedTextField();
        txttelefone = new javax.swing.JFormattedTextField();
        txtnascimento = new com.toedter.calendar.JDateChooser();
        txtnascimento.getDateEditor().setEnabled(false);
        Entrar = new javax.swing.JPanel();
        Entrar_1 = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        txtcep = new javax.swing.JFormattedTextField();
        lblcep1 = new javax.swing.JLabel();
        Buscar = new javax.swing.JPanel();
        Entrar_3 = new javax.swing.JLabel();
        txtsalario = new tccc.JMoneyFieldValor();
        cbuf = new javax.swing.JComboBox<>();
        cbuf.getModel().setSelectedItem("SP");
        txtid = new javax.swing.JTextField();
        lblcep2 = new javax.swing.JLabel();
        cbcargo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
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
        lblcadastro.setText("Atualizar Cadastro de Funcionário");

        lblnome.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblnome.setForeground(new java.awt.Color(255, 255, 255));
        lblnome.setText("Nome:");

        lblend.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblend.setForeground(new java.awt.Color(255, 255, 255));
        lblend.setText("Salário:");

        lblbairro.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblbairro.setForeground(new java.awt.Color(255, 255, 255));
        lblbairro.setText("Cidade:");

        lblcidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcidade.setForeground(new java.awt.Color(255, 255, 255));
        lblcidade.setText("UF:");

        lblcep.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcep.setForeground(new java.awt.Color(255, 255, 255));
        lblcep.setText("Cargo:");

        lblsexo.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblsexo.setForeground(new java.awt.Color(255, 255, 255));
        lblsexo.setText("Sexo:");

        lblcomplemento.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcomplemento.setForeground(new java.awt.Color(255, 255, 255));
        lblcomplemento.setText("Bairro:");

        lblcpf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcpf.setForeground(new java.awt.Color(255, 255, 255));
        lblcpf.setText("CPF:");

        lblidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblidade.setForeground(new java.awt.Color(255, 255, 255));
        lblidade.setText("Nascimento:");

        lbltelefone.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbltelefone.setForeground(new java.awt.Color(255, 255, 255));
        lbltelefone.setText("Telefone:");

        txtnome.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtnome.setForeground(new java.awt.Color(255, 255, 255));

        txtcidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcidade.setForeground(new java.awt.Color(255, 255, 255));

        cbsexo.setForeground(new java.awt.Color(255, 255, 255));
        cbsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        txtcpf.setBorder(null);
        txtcpf.setForeground(new java.awt.Color(255, 255, 255));
        txtcpf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcpf.setPreferredSize(new java.awt.Dimension(4, 24));

        txttelefone.setBorder(null);
        txttelefone.setForeground(new java.awt.Color(255, 255, 255));
        txttelefone.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txttelefone.setPreferredSize(new java.awt.Dimension(4, 24));

        txtnascimento.setForeground(new java.awt.Color(255, 255, 255));
        txtnascimento.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtnascimento.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        txtnascimento.setMinimumSize(new java.awt.Dimension(50, 24));
        txtnascimento.setPreferredSize(new java.awt.Dimension(118, 24));

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
        Entrar_1.setText("Atualizar");

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

        txtbairro.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtbairro.setForeground(new java.awt.Color(255, 255, 255));

        txtcep.setBorder(null);
        txtcep.setForeground(new java.awt.Color(255, 255, 255));
        txtcep.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtcep.setPreferredSize(new java.awt.Dimension(4, 24));
        txtcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcepActionPerformed(evt);
            }
        });
        txtcep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcepKeyPressed(evt);
            }
        });

        lblcep1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcep1.setForeground(new java.awt.Color(255, 255, 255));
        lblcep1.setText("CEP:");

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

        Entrar_3.setBackground(new java.awt.Color(65, 105, 225));
        Entrar_3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Entrar_3.setForeground(new java.awt.Color(255, 255, 255));
        Entrar_3.setText("Buscar");

        javax.swing.GroupLayout BuscarLayout = new javax.swing.GroupLayout(Buscar);
        Buscar.setLayout(BuscarLayout);
        BuscarLayout.setHorizontalGroup(
            BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BuscarLayout.setVerticalGroup(
            BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtsalario.setBorder(null);
        txtsalario.setForeground(new java.awt.Color(255, 255, 255));
        txtsalario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtsalario.setText("0,0000");
        txtsalario.setPreferredSize(new java.awt.Dimension(28, 24));

        cbuf.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cbuf.setForeground(new java.awt.Color(255, 255, 255));
        cbuf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(0, 153, 255));
        txtid.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        txtid.setBorder(null);

        lblcep2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcep2.setForeground(new java.awt.Color(255, 255, 255));
        lblcep2.setText("ID:");

        cbcargo.setForeground(new java.awt.Color(255, 255, 255));
        cbcargo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbcargoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblsexo)
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbltelefone)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblidade)
                                .addGap(33, 33, 33)
                                .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblcpf)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnome)
                                    .addComponent(lblcep2))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcomplemento)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblbairro)
                                    .addComponent(lblcidade))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcep1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblend)
                                    .addComponent(lblcep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbcargo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtsalario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))))
                    .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcadastro)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblcep)
                        .addComponent(cbcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblcep2)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblend))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblcep1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcomplemento))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblbairro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcidade)
                            .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblnome))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltelefone))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblsexo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcpf))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void EntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarMouseClicked
        try {
            Funcionario f = new Funcionario();
            java.util.Date pega = txtnascimento.getDate();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            JMoneyField_Transformar transformar = new JMoneyField_Transformar();

            f.setId_funcionario(Integer.parseInt(txtid.getText()));
            f.setNome(txtnome.getText());
            f.setTelefone(txttelefone.getText());
            f.setCargo(String.valueOf(cbcargo.getSelectedItem()));
            f.setSalario(transformar.TransformaParaDouble(txtsalario.getText()));
            f.setBairro(txtbairro.getText());
            f.setCidade(txtcidade.getText());
            f.setEstado(String.valueOf(cbuf.getSelectedItem()));
            f.setCep(txtcep.getText());
            f.setSexo(String.valueOf(cbsexo.getSelectedItem()));
            f.setCpf(txtcpf.getText());
            f.setNascimento(formato.format(pega));

            dao.Alterar(f);
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

    private void txtcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcepActionPerformed

    private void txtcepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcepKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcepKeyPressed

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        buscaCep();
    }//GEN-LAST:event_BuscarMouseClicked

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Buscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BuscarMouseEntered

    private void cbcargoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbcargoAncestorAdded
        CargoDAO d = new CargoDAO();
        List<Cargo> cargos = d.getLista();
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbcargo.getModel();
        model.removeAllElements();
        for (Cargo c : cargos) {
            model.addElement(c.getDescricao());
        }
        cbcargo.setSelectedItem(cargo);
    }//GEN-LAST:event_cbcargoAncestorAdded
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buscar;
    private javax.swing.JPanel Entrar;
    private javax.swing.JLabel Entrar_1;
    private javax.swing.JLabel Entrar_3;
    private javax.swing.JPanel MovimentarJanela;
    private javax.swing.JComboBox<String> cbcargo;
    private javax.swing.JComboBox<String> cbsexo;
    private javax.swing.JComboBox<String> cbuf;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblbairro;
    private javax.swing.JLabel lblcadastro;
    private javax.swing.JLabel lblcep;
    private javax.swing.JLabel lblcep1;
    private javax.swing.JLabel lblcep2;
    private javax.swing.JLabel lblcidade;
    private javax.swing.JLabel lblcomplemento;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JLabel lblend;
    private javax.swing.JLabel lblidade;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lblsexo;
    private javax.swing.JLabel lbltelefone;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JTextField txtid;
    private com.toedter.calendar.JDateChooser txtnascimento;
    private javax.swing.JTextField txtnome;
    private tccc.JMoneyFieldValor txtsalario;
    private javax.swing.JFormattedTextField txttelefone;
    // End of variables declaration//GEN-END:variables
}