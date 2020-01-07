/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view;

import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Cursor;
import java.awt.Window;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.ControleDeColuna;
import tccc.DAO.ItensPedidoVenderDAO;
import tccc.DAO.PedidoVenderDAO;
import tccc.Modelo.PedidoVender;

public class JFD_AlterarPedidoVenda extends javax.swing.JDialog {
    
    int xMouse, yMouse, qtd = 0; // o inteiro qtd servira para saber se a quantidade é maior ou menor do que a quantidade q esta em estoque
    String i;
    double antigo = 0, novo = 0, valorC;
    String clienteid, clientenome, produtoid, produtonome, valorunit, tabelatotal;
    int quantidade, idPedidoVenda;
    Color cordeborda = new Color(83, 83, 83);
    JXTable Tbl;
    String TipoDeVenda;
    
    public JFD_AlterarPedidoVenda(java.awt.Frame parent, boolean modal, JXTable tb,
            int idpedido,
            int idCliente,
            String nomeCliente,
            int idfuncionario,
            String nomeFuncionario,
            String frete,
            String descontoP,
            String descontoRS,
            String totalPedido,
            String tipoVenda
    ) throws ParseException {
        super(parent, modal);
        initComponents();
        TblItens.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ControleDeColuna c = new ControleDeColuna(TblItens, false);
        this.setLocationRelativeTo(null);
        lblcadastro.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        txtdescontopor.setEnabled(false);
        txtdescontors1.setEnabled(false);
        txtfrete.setEnabled(false);
        Tbl = tb;
        idPedidoVenda = idpedido;
        ListarTabela();
        buttonGroup1.clearSelection();
        TipoDeVenda = null;
        
        if (tipoVenda.equals("Local")) {
            rbvendalocal.setSelected(true);
        } else if (tipoVenda.equals("Entrega")) {
            rbvendaentrega.setSelected(true);
        }
        
        LblVeridicaQuantidade.setVisible(false);
    }
    
    public void ListarTabela() {
        ItensPedidoVenderDAO dao = new ItensPedidoVenderDAO();
        dao.ListarTabelaAlteracao(TblItens, idPedidoVenda);
        ControleDeColuna c = new ControleDeColuna(TblItens, false);
    }
    
    private JFD_AlterarPedidoVenda(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String replaces(String mudar) {
        mudar = mudar.replace("R$ ", "");
        mudar = mudar.replace(".", "");
        mudar = mudar.replace(",", ".");
        return mudar;
    }
    
    public boolean verificaidtabela(int x) {
        boolean vidtb = true;
        String id;
        int dd;
        for (int i = 0; i <= TblItens.getRowCount() - 1; i++) {
            id = String.valueOf(TblItens.getValueAt(i, 0));
            dd = Integer.parseInt(id);
            if (dd == x) {
                vidtb = false;
                JOptionPane.showMessageDialog(null, "Este produto ja foi adicionado na tabela");
            }
            
        }
        return vidtb;
    }
    
    public boolean verifica() {
        boolean verifica = true;
        if (txtprodutoid.getText().trim().equals("")) {
            verifica = false;
            JOptionPane.showMessageDialog(null, "Selecione algum produto");
            System.out.println("1");
        } else if (txtquantidade.getText().trim().equals("")) {
            verifica = false;
            JOptionPane.showMessageDialog(null, "Campo quantidade está vazio");
            System.out.println("3");
        }
        return verifica;
    }
    
    public String addTotalTabela() {
        valorunit = txtvalorunit.getText();
        valorunit = valorunit.replace(".", "");
        valorunit = valorunit.replace(",", ".");
        valorC = Double.parseDouble(valorunit);
        tabelatotal = String.valueOf(String.format("%.2f", quantidade * valorC));
        tabelatotal = tabelatotal.replace(".", ",");
        
        return tabelatotal;
    }
    
    private void inserirtotal() {
        double descontors, frete, nov, ant = 0;
        String des = null;
        
        des = txtdescontors1.getText();
        des = des.replace(".", "");
        des = des.replace(",", ".");
        nov = Double.parseDouble(des);
        
        if (nov < getvalortotal() + 0.01) {
            ant = nov;
            descontors = Double.parseDouble(des);
            Double total = (getvalortotal() - descontors);
            txttotal.setText(String.format("%.2f", total));
        } else {
            txtdescontors1.setText("" + ant);
        }
    }
    
    public double getvalortotal() {
        double x = 0, frete;
        String tt = null, frt;
        for (int i = 0; i <= TblItens.getRowCount() - 1; i++) {
            tt = String.valueOf(TblItens.getValueAt(i, 4));
            tt = tt.replace("R$ ", "");
            tt = tt.replace(".", "");
            tt = tt.replace(",", ".");
            x += Double.parseDouble(tt);
        }
        
        frt = txtfrete.getText();
        frt = frt.replace(".", "");
        frt = frt.replace(",", ".");
        frete = Double.parseDouble(frt);
        
        x += frete;
        return x;
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
        Entrar = new javax.swing.JPanel();
        Entrar_1 = new javax.swing.JLabel();
        lblcadastro = new javax.swing.JLabel();
        lblresponsavel = new javax.swing.JLabel();
        lblvalorunitario = new javax.swing.JLabel();
        lblcliente = new javax.swing.JLabel();
        lbladicionar = new javax.swing.JLabel();
        lblquantidade = new javax.swing.JLabel();
        lblexcluir = new javax.swing.JLabel();
        addcliente = new javax.swing.JLabel();
        txtprodutonome = new javax.swing.JTextField();
        addproduto = new javax.swing.JLabel();
        txtclienteid = new javax.swing.JTextField();
        txtprodutoid = new javax.swing.JTextField();
        lbldescontors1 = new javax.swing.JLabel();
        txtfrete = new tccc.JMoneyFieldValor();
        txtdescontors1 = new tccc.JMoneyFieldValor();
        lbldesconto = new javax.swing.JLabel();
        lbldescontors = new javax.swing.JLabel();
        lblvalortotal = new javax.swing.JLabel();
        txtvalorunit = new tccc.JMoneyFieldValor();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblItens = new org.jdesktop.swingx.JXTable();
        txtquantidade = new javax.swing.JTextField();
        txtclientenome = new javax.swing.JTextField();
        txtdescontopor = new tccc.JMoneyFieldValor();
        txttotal = new tccc.JMoneyFieldValor();
        addresponsavel = new javax.swing.JLabel();
        txtresponsavelnome = new javax.swing.JTextField();
        txtresponsavelid = new javax.swing.JTextField();
        lblcliente1 = new javax.swing.JLabel();
        LblVeridicaQuantidade = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbvendaentrega = new javax.swing.JRadioButton();
        rbvendalocal = new javax.swing.JRadioButton();
        rbvendalocal.setSelected(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(MovimentarJanela, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 887, -1));

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
        Entrar_1.setText("Alterar");

        javax.swing.GroupLayout EntrarLayout = new javax.swing.GroupLayout(Entrar);
        Entrar.setLayout(EntrarLayout);
        EntrarLayout.setHorizontalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EntrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Entrar_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EntrarLayout.setVerticalGroup(
            EntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EntrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar_1)
                .addContainerGap())
        );

        jPanel2.add(Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        lblcadastro.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblcadastro.setForeground(new java.awt.Color(255, 255, 255));
        lblcadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcadastro.setText("Cadastro de Venda");
        jPanel2.add(lblcadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 887, -1));

        lblresponsavel.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblresponsavel.setForeground(new java.awt.Color(255, 255, 255));
        lblresponsavel.setText("Produto ID/Nome:");
        jPanel2.add(lblresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 81, -1, -1));

        lblvalorunitario.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblvalorunitario.setForeground(new java.awt.Color(255, 255, 255));
        lblvalorunitario.setText("Valor Unitário:");
        jPanel2.add(lblvalorunitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 125, -1, -1));

        lblcliente.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcliente.setForeground(new java.awt.Color(255, 255, 255));
        lblcliente.setText("Cliente ID/Nome:");
        jPanel2.add(lblcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 81, -1, -1));

        lbladicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Ok_24px.png"))); // NOI18N
        lbladicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbladicionarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbladicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbladicionarMouseExited(evt);
            }
        });
        jPanel2.add(lbladicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(817, 219, -1, -1));

        lblquantidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblquantidade.setForeground(new java.awt.Color(255, 255, 255));
        lblquantidade.setText("Quantidade:");
        jPanel2.add(lblquantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 169, -1, -1));

        lblexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Cancel_24px_1.png"))); // NOI18N
        lblexcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblexcluirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblexcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblexcluirMouseExited(evt);
            }
        });
        jPanel2.add(lblexcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(859, 219, -1, -1));

        addcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png"))); // NOI18N
        addcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addclienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addclienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addclienteMouseExited(evt);
            }
        });
        jPanel2.add(addcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 76, -1, -1));

        txtprodutonome.setEditable(false);
        txtprodutonome.setBackground(new java.awt.Color(171, 121, 85));
        txtprodutonome.setForeground(new java.awt.Color(255, 255, 255));
        txtprodutonome.setCaretColor(new java.awt.Color(255, 255, 255));
        txtprodutonome.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtprodutonome.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtprodutonome, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 76, 150, -1));

        addproduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png"))); // NOI18N
        addproduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addprodutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addprodutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addprodutoMouseExited(evt);
            }
        });
        jPanel2.add(addproduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 76, -1, -1));

        txtclienteid.setEditable(false);
        txtclienteid.setBackground(new java.awt.Color(171, 121, 85));
        txtclienteid.setForeground(new java.awt.Color(255, 255, 255));
        txtclienteid.setCaretColor(new java.awt.Color(255, 255, 255));
        txtclienteid.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtclienteid.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtclienteid, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 76, 62, -1));

        txtprodutoid.setEditable(false);
        txtprodutoid.setBackground(new java.awt.Color(171, 121, 85));
        txtprodutoid.setForeground(new java.awt.Color(255, 255, 255));
        txtprodutoid.setCaretColor(new java.awt.Color(255, 255, 255));
        txtprodutoid.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtprodutoid.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtprodutoid, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 76, 62, -1));

        lbldescontors1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbldescontors1.setForeground(new java.awt.Color(255, 255, 255));
        lbldescontors1.setText("Frete R$:");
        jPanel2.add(lbldescontors1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 169, -1, -1));

        txtfrete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 83, 83)));
        txtfrete.setForeground(new java.awt.Color(255, 255, 255));
        txtfrete.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtfrete.setText("0,0000");
        txtfrete.setPreferredSize(new java.awt.Dimension(28, 24));
        txtfrete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfreteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfreteKeyTyped(evt);
            }
        });
        jPanel2.add(txtfrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 164, 103, -1));

        txtdescontors1.setBorder(null);
        txtdescontors1.setForeground(new java.awt.Color(255, 255, 255));
        txtdescontors1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtdescontors1.setText("0,0000");
        txtdescontors1.setPreferredSize(new java.awt.Dimension(28, 24));
        txtdescontors1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdescontors1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescontors1KeyTyped(evt);
            }
        });
        jPanel2.add(txtdescontors1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 206, 103, -1));

        lbldesconto.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbldesconto.setForeground(new java.awt.Color(255, 255, 255));
        lbldesconto.setText("Desconto %:");
        jPanel2.add(lbldesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 211, -1, -1));

        lbldescontors.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbldescontors.setForeground(new java.awt.Color(255, 255, 255));
        lbldescontors.setText("Desconto R$:");
        jPanel2.add(lbldescontors, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 211, -1, -1));

        lblvalortotal.setForeground(new java.awt.Color(255, 255, 255));
        lblvalortotal.setText("Total do Pedido R$:");
        jPanel2.add(lblvalortotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 406, -1, -1));

        txtvalorunit.setEditable(false);
        txtvalorunit.setBackground(new java.awt.Color(0, 153, 255));
        txtvalorunit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 83, 83)));
        txtvalorunit.setForeground(new java.awt.Color(255, 255, 255));
        txtvalorunit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtvalorunit.setText("0,0000");
        txtvalorunit.setPreferredSize(new java.awt.Dimension(28, 24));
        txtvalorunit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtvalorunitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalorunitKeyTyped(evt);
            }
        });
        jPanel2.add(txtvalorunit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 103, -1));

        TblItens.setForeground(new java.awt.Color(255, 255, 255));
        TblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produto", "Produto", "Valor Unitário", "Quantidade", "Total do Produto"
            }
        ));
        TblItens.setColumnControl(null);
        jScrollPane1.setViewportView(TblItens);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 248, 875, 118));

        txtquantidade.setForeground(new java.awt.Color(255, 255, 255));
        txtquantidade.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtquantidade.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtquantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtquantidadeFocusGained(evt);
            }
        });
        txtquantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtquantidadeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtquantidadeKeyTyped(evt);
            }
        });
        jPanel2.add(txtquantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 164, 84, -1));

        txtclientenome.setEditable(false);
        txtclientenome.setBackground(new java.awt.Color(171, 121, 85));
        txtclientenome.setForeground(new java.awt.Color(255, 255, 255));
        txtclientenome.setCaretColor(new java.awt.Color(255, 255, 255));
        txtclientenome.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtclientenome.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtclientenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 76, 150, -1));

        txtdescontopor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 83, 83)));
        txtdescontopor.setForeground(new java.awt.Color(255, 255, 255));
        txtdescontopor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtdescontopor.setText("0,0000");
        txtdescontopor.setPreferredSize(new java.awt.Dimension(28, 24));
        txtdescontopor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdescontoporFocusGained(evt);
            }
        });
        txtdescontopor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescontoporActionPerformed(evt);
            }
        });
        txtdescontopor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdescontoporKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescontoporKeyTyped(evt);
            }
        });
        jPanel2.add(txtdescontopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 206, 57, -1));

        txttotal.setEditable(false);
        txttotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 83, 83)));
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txttotal.setText("0,000");
        txttotal.setPreferredSize(new java.awt.Dimension(28, 24));
        jPanel2.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 402, 106, -1));

        addresponsavel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png"))); // NOI18N
        addresponsavel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addresponsavelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addresponsavelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addresponsavelMouseExited(evt);
            }
        });
        jPanel2.add(addresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 120, -1, -1));

        txtresponsavelnome.setEditable(false);
        txtresponsavelnome.setBackground(new java.awt.Color(171, 121, 85));
        txtresponsavelnome.setForeground(new java.awt.Color(255, 255, 255));
        txtresponsavelnome.setCaretColor(new java.awt.Color(255, 255, 255));
        txtresponsavelnome.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtresponsavelnome.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtresponsavelnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 120, 150, -1));

        txtresponsavelid.setEditable(false);
        txtresponsavelid.setBackground(new java.awt.Color(171, 121, 85));
        txtresponsavelid.setForeground(new java.awt.Color(255, 255, 255));
        txtresponsavelid.setCaretColor(new java.awt.Color(255, 255, 255));
        txtresponsavelid.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtresponsavelid.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtresponsavelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 120, 62, -1));

        lblcliente1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcliente1.setForeground(new java.awt.Color(255, 255, 255));
        lblcliente1.setText("Entregador ID/Nome:");
        jPanel2.add(lblcliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 125, -1, -1));

        LblVeridicaQuantidade.setForeground(new java.awt.Color(255, 255, 0));
        LblVeridicaQuantidade.setText("Este produto tem apenas");
        jPanel2.add(LblVeridicaQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 390, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Tipo de Venda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        rbvendaentrega.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rbvendaentrega.setForeground(new java.awt.Color(255, 255, 255));
        rbvendaentrega.setText("Entrega");
        rbvendaentrega.setOpaque(false);
        rbvendaentrega.setRequestFocusEnabled(false);

        rbvendalocal.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rbvendalocal.setForeground(new java.awt.Color(255, 255, 255));
        rbvendalocal.setText("Local");
        rbvendalocal.setOpaque(false);
        rbvendalocal.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(rbvendalocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(rbvendaentrega)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbvendaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbvendalocal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            if (rbvendaentrega.isSelected() == true) {
                TipoDeVenda = "Entrega";
            } else if (rbvendalocal.isSelected() == true) {
                TipoDeVenda = "Local";
            } else {
                TipoDeVenda = null;
            }
            if (TipoDeVenda == null) {
                JOptionPane.showMessageDialog(null, "Selecione um tipo de venda!");
            } else {
                if (TblItens.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum produto foi listado");
                } else {
                    PedidoVender pv = new PedidoVender();
                    //caso campo de texto Cliente ou responsavel if estiver vazio ele passa 0, q posteriormente sera tratado para que envie para o banco um valor nulo
                    if (txtclienteid.getText().equals("") || txtresponsavelid.getText().equals("")) {
                        if (txtclienteid.getText().equals("")) {
                            pv.setId_cliente(0);
                        } else {
                            pv.setId_cliente(Integer.parseInt(txtclienteid.getText()));
                        }
                        if (txtresponsavelid.getText().equals("")) {
                            pv.setId_funcionario(0);
                        } else {
                            pv.setId_funcionario(Integer.parseInt(txtresponsavelid.getText()));
                        }
                        pv.setFrete(Double.parseDouble(replaces(txtfrete.getText())));
                        pv.setDesconto(Double.parseDouble(replaces(txtdescontors1.getText())));
                        pv.setDescontoporcentagem(Double.parseDouble(replaces(txtdescontopor.getText())));
                        pv.setValor_totalpedido(Double.parseDouble(replaces(txttotal.getText())));
                        pv.setTipovenda(TipoDeVenda);
                    } else {
                        pv.setId_cliente(Integer.parseInt(txtclienteid.getText()));
                        pv.setId_funcionario(Integer.parseInt(txtresponsavelid.getText()));
                        pv.setFrete(Double.parseDouble(replaces(txtfrete.getText())));
                        pv.setDesconto(Double.parseDouble(replaces(txtdescontors1.getText())));
                        pv.setDescontoporcentagem(Double.parseDouble(replaces(txtdescontopor.getText())));
                        pv.setValor_totalpedido(Double.parseDouble(replaces(txttotal.getText())));
                        pv.setTipovenda(TipoDeVenda);
                    }
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime agorah = LocalTime.now();
                    pv.setHora(Time.valueOf(formatador.format(agorah)));
                    LocalDate agorad = LocalDate.now();
                    pv.setData(Date.valueOf(agorad));
                    
                    PedidoVenderDAO dao1 = new PedidoVenderDAO();
                    dao1.Alterar(pv);
                    ItensPedidoVenderDAO dao = new ItensPedidoVenderDAO();
                    dao.Remover(idPedidoVenda);
                    for (int linha = 0; linha <= TblItens.getRowCount() - 1; linha++) {
                        pv.setId_produto(Integer.parseInt(replaces(String.valueOf(TblItens.getValueAt(linha, 0)))));
                        pv.setValor_unitario(Double.parseDouble(replaces(String.valueOf(TblItens.getValueAt(linha, 2)))));
                        pv.setQuantidade(Integer.parseInt(replaces(String.valueOf(TblItens.getValueAt(linha, 3)))));
                        pv.setValor_totalitem(Double.parseDouble(replaces(String.valueOf(TblItens.getValueAt(linha, 4)))));
                        dao.adicionar(pv);
                    }
                    JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso");
                    Component comp = SwingUtilities.getRoot(this);
                    ((Window) comp).dispose();
                    dao1.ListarTabela(Tbl);
                    ControleDeColuna c = new ControleDeColuna(Tbl, true);
                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_EntrarMouseClicked

    private void EntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarMouseEntered
        Entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EntrarMouseEntered

    private void lbladicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladicionarMouseClicked
        if (txtprodutoid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto");
        } else {
            int vid = Integer.parseInt(txtprodutoid.getText());
            if (verificaidtabela(vid) == true) {
                if (verifica() == true) {
                    quantidade = Integer.parseInt(txtquantidade.getText());
                    if (quantidade > 0) {
                        produtoid = txtprodutoid.getText();
                        produtonome = txtprodutonome.getText();
                        valorunit = txtvalorunit.getText();
                        DefaultTableModel model = (DefaultTableModel) TblItens.getModel();
                        model.addRow(new Object[]{
                            produtoid,
                            produtonome,
                            "R$ " + valorunit,
                            quantidade,
                            "R$ " + addTotalTabela()
                        });
                        ControleDeColuna c = new ControleDeColuna(TblItens, false);
                        txtdescontopor.setEnabled(true);
                        txtdescontors1.setEnabled(true);
                        txtfrete.setEnabled(true);
                        txtprodutoid.setText("");
                        txtprodutonome.setText("");
                        txtvalorunit.setText("0,00");
                        txtquantidade.setText("");
                        LblVeridicaQuantidade.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantidade nao pode ser 0");
                    }
                }
            }
        }
        inserirtotal();
    }//GEN-LAST:event_lbladicionarMouseClicked

    private void lbladicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladicionarMouseEntered
        lbladicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Ok_24px_1.png")));
        lbladicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (txtquantidade.hasFocus() == true) {
            TblItens.requestFocus(true);
        }
        lbladicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbladicionarMouseEntered

    private void lbladicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladicionarMouseExited
        lbladicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Ok_24px.png")));
    }//GEN-LAST:event_lbladicionarMouseExited

    private void lblexcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexcluirMouseClicked
        int linha = TblItens.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) TblItens.getModel();
        if (linha != -1) {
            dtm.removeRow(linha);
            TblItens.setModel(dtm);
            if (TblItens.getRowCount() == 0) {
                txttotal.setText("0,00");
                txtdescontopor.setText("0,00");
                txtdescontors1.setText("0,00");
                txtfrete.setText("0,00");
                txtdescontopor.setEnabled(false);
                txtdescontors1.setEnabled(false);
                txtfrete.setEnabled(false);
            } else {
                inserirtotal();
            }
        } else if (linha != -0) {
            JOptionPane.showMessageDialog(null, "Por favor, clique em algum produto listado na tabela");
        }
        inserirtotal();
    }//GEN-LAST:event_lblexcluirMouseClicked

    private void lblexcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexcluirMouseEntered
        lblexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Cancel_24px.png")));
        lblexcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblexcluirMouseEntered

    private void lblexcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexcluirMouseExited
        lblexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Cancel_24px_1.png")));
    }//GEN-LAST:event_lblexcluirMouseExited

    private void addclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addclienteMouseClicked
        JFD_PesquisarCliente PF = new JFD_PesquisarCliente(null, true);
        PF.setVisible(true);
        if (PF.fechou == true) {
            txtclienteid.setText(PF.getID());
            txtclientenome.setText(PF.getNome());
        }
    }//GEN-LAST:event_addclienteMouseClicked

    private void addclienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addclienteMouseEntered
        addcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_3.png")));
        addcliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_addclienteMouseEntered

    private void addclienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addclienteMouseExited
        addcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png")));
    }//GEN-LAST:event_addclienteMouseExited

    private void addprodutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addprodutoMouseClicked
        LblVeridicaQuantidade.setVisible(false);
        JFD_PesquisarProdutoEstoque PC = new JFD_PesquisarProdutoEstoque(null, true);
        PC.setVisible(true);
        if (PC.fechou == true) {
            txtprodutoid.setText(PC.getID());
            txtprodutonome.setText(PC.getNome());
            txtvalorunit.setText(PC.getValor());
            qtd = Integer.parseInt(PC.getQuantidade());
            LblVeridicaQuantidade.setText("Este produto tem apena(s) " + qtd + " unidade(s) disponíveis");
        }
    }//GEN-LAST:event_addprodutoMouseClicked

    private void addprodutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addprodutoMouseEntered
        addproduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_3.png")));
        addproduto.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_addprodutoMouseEntered

    private void addprodutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addprodutoMouseExited
        addproduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png")));
    }//GEN-LAST:event_addprodutoMouseExited

    private void txtfreteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfreteKeyReleased
        if (txtfrete.getText().trim().equals("")) {
            txtfrete.setText("" + "0.00");
        }
        txtdescontors1KeyReleased(evt);
        inserirtotal();
    }//GEN-LAST:event_txtfreteKeyReleased

    private void txtfreteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfreteKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfreteKeyTyped

    private void txtdescontors1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescontors1KeyReleased
        if (txtdescontors1.getText().trim().equals("")) {
            txtdescontors1.setText("" + "0.00");
        }
        Double porcentagem = 0.0, desconto;
        i = txtdescontors1.getText();
        i = i.replace(".", "");
        i = i.replace(",", ".");
        desconto = Double.parseDouble(i);
        
        porcentagem = (desconto * 100) / getvalortotal();
        txtdescontopor.setText(String.valueOf(String.format("%.2f", porcentagem)));
        System.err.println(String.format("%.2f", porcentagem));
        inserirtotal();
    }//GEN-LAST:event_txtdescontors1KeyReleased

    private void txtdescontors1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescontors1KeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdescontors1KeyTyped

    private void txtvalorunitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorunitKeyReleased
        if (txtvalorunit.getText().trim().equals("")) {
            txtvalorunit.setText("" + "0.00");
        }
    }//GEN-LAST:event_txtvalorunitKeyReleased

    private void txtvalorunitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorunitKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtvalorunitKeyTyped

    private void txtquantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtquantidadeFocusGained
        txtquantidade.setText("");
    }//GEN-LAST:event_txtquantidadeFocusGained

    private void txtquantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantidadeKeyReleased
        try {
            if (txtprodutoid.getText().trim().equals("")) {
                LblVeridicaQuantidade.setText("");
            } else {
                if (!txtquantidade.getText().equals("")) {
                    long qtdVerifica = Integer.parseInt(txtquantidade.getText());
                    if (qtd < qtdVerifica) {
                        LblVeridicaQuantidade.setVisible(true);
                    } else {
                        LblVeridicaQuantidade.setVisible(false);
                    }
                }
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número muito grande!");
        }
    }//GEN-LAST:event_txtquantidadeKeyReleased

    private void txtquantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtquantidadeKeyTyped

    private void txtdescontoporFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescontoporFocusGained
        txtdescontopor.setBorder(new LineBorder(cordeborda));
    }//GEN-LAST:event_txtdescontoporFocusGained

    private void txtdescontoporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescontoporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescontoporActionPerformed

    private void txtdescontoporKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescontoporKeyReleased
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        i = txtdescontopor.getText();
        i = i.replace(".", "");
        i = i.replace(",", ".");
        novo = Double.parseDouble(i);
        
        if (novo < 100.01) {
            antigo = novo;
        } else {
            i = String.valueOf(String.format("%.2f", antigo));
            txtdescontopor.setText(i);
        }
        Double porcentagem;
        i = txtdescontopor.getText();
        i = i.replace(",", ".");
        porcentagem = Double.parseDouble(i);
        
        Double x = (porcentagem * getvalortotal()) / 100;
        txtdescontors1.setText(String.format("%.2f", x));
        System.err.println(String.format("%.2f", x));
        inserirtotal();
    }//GEN-LAST:event_txtdescontoporKeyReleased

    private void txtdescontoporKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescontoporKeyTyped
        if (txtdescontopor.getText().trim().equals("")) {
            txtdescontopor.setText("" + "0,00");
        }
    }//GEN-LAST:event_txtdescontoporKeyTyped

    private void addresponsavelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addresponsavelMouseClicked
        JFD_PesquisarFuncionario PF = new JFD_PesquisarFuncionario(null, true);
        PF.setVisible(true);
        if (PF.fechou == true) {
            txtresponsavelid.setText(PF.getID());
            txtresponsavelnome.setText(PF.getNome());
        }
    }//GEN-LAST:event_addresponsavelMouseClicked

    private void addresponsavelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addresponsavelMouseEntered
        addresponsavel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_3.png")));
        addresponsavel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_addresponsavelMouseEntered

    private void addresponsavelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addresponsavelMouseExited
        addresponsavel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Search_26px_1.png")));
    }//GEN-LAST:event_addresponsavelMouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Entrar;
    private javax.swing.JLabel Entrar_1;
    private javax.swing.JLabel LblVeridicaQuantidade;
    private javax.swing.JPanel MovimentarJanela;
    private org.jdesktop.swingx.JXTable TblItens;
    private javax.swing.JLabel addcliente;
    private javax.swing.JLabel addproduto;
    private javax.swing.JLabel addresponsavel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbladicionar;
    private javax.swing.JLabel lblcadastro;
    private javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lblcliente1;
    private javax.swing.JLabel lbldesconto;
    private javax.swing.JLabel lbldescontors;
    private javax.swing.JLabel lbldescontors1;
    private javax.swing.JLabel lblexcluir;
    private javax.swing.JLabel lblquantidade;
    private javax.swing.JLabel lblresponsavel;
    private javax.swing.JLabel lblvalortotal;
    private javax.swing.JLabel lblvalorunitario;
    private javax.swing.JRadioButton rbvendaentrega;
    private javax.swing.JRadioButton rbvendalocal;
    private javax.swing.JTextField txtclienteid;
    private javax.swing.JTextField txtclientenome;
    private tccc.JMoneyFieldValor txtdescontopor;
    private tccc.JMoneyFieldValor txtdescontors1;
    private tccc.JMoneyFieldValor txtfrete;
    private javax.swing.JTextField txtprodutoid;
    private javax.swing.JTextField txtprodutonome;
    private javax.swing.JTextField txtquantidade;
    private javax.swing.JTextField txtresponsavelid;
    private javax.swing.JTextField txtresponsavelnome;
    private tccc.JMoneyFieldValor txttotal;
    private tccc.JMoneyFieldValor txtvalorunit;
    // End of variables declaration//GEN-END:variables
}
