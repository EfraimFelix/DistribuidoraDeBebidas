/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Window;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import tccc.ControleDeColuna;
import tccc.DAO.PedidoComprarDAO;
import tccc.DAO.ItensPedidoComprarDAO;
import tccc.Modelo.PedidoComprar;

/**
 *
 * @author Efraim
 */
public class JFD_AlterarPedidoCompra extends javax.swing.JDialog {

    int xMouse, yMouse;
    String i;
    double antigo = 0, novo = 0, valorC;
    String clienteid, clientenome, produtoid, produtonome, valorcusto, valorunit, tabelatotal;
    int quantidade, idcompra;
    JXTable Tbl;

    public JFD_AlterarPedidoCompra(java.awt.Frame parent, boolean modal, JXTable tb, 
            int idPedidoCompra,
            int idFornecedor,
            String nomeFornecedor,
            String frete,
            String descontoP,
            String descontoRS,
            String totalPedido) {
        super(parent, modal);
        initComponents();
        TblItens.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLocationRelativeTo(null);
        txtfornecedorid.setText(String.valueOf(idFornecedor));
        txtfornecedornome.setText(nomeFornecedor);
        txtfrete.setText(frete);
        txtdescontopor.setText(descontoP);
        txtdescontors1.setText(descontoRS);
        txttotal.setText(totalPedido);
        
        Tbl = tb;
        idcompra = idPedidoCompra;
        
        ListarTabela();
        
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
    }

    private JFD_AlterarPedidoCompra(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ListarTabela() {
        ItensPedidoComprarDAO dao = new ItensPedidoComprarDAO();
        dao.ListarTabelaAlteracao(TblItens, idcompra);
        ControleDeColuna c = new ControleDeColuna(TblItens, false);
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

    public String addTotalTabela() {
        valorcusto = txtvalorcusto.getText();
        valorcusto = valorcusto.replace(".", "");
        valorcusto = valorcusto.replace(",", ".");
        valorC = Double.parseDouble(valorcusto);
        tabelatotal = String.valueOf(String.format("%.2f", quantidade * valorC));
        tabelatotal = tabelatotal.replace(".", ",");

        return tabelatotal;
    }

    public boolean verifica() {
        boolean verifica = true;
        if (txtvalorunit.getText().trim().equals("0,00")) {
            verifica = false;
            JOptionPane.showMessageDialog(null, "Campo valor unitário está vazio");
        } else if (txtquantidade.getText().trim().equals("")) {
            verifica = false;
            JOptionPane.showMessageDialog(null, "Campo quantidade está vazio");
        } else if (txtvalorcusto.getText().trim().equals("0,00")) {
            verifica = false;
            JOptionPane.showMessageDialog(null, "Campo valor de custo está vazio");
        }
        return verifica;
    }

    public int vericaCusto() {
        double vac = 0, vau = 0, x = 0;
        int verificacusto = 0;
        String vc, vu;

        vc = txtvalorcusto.getText();
        vc = vc.replace(".", "");
        vc = vc.replace(",", ".");
        vac += Double.parseDouble(vc);

        vu = txtvalorunit.getText();
        vu = vu.replace(".", "");
        vu = vu.replace(",", ".");
        vau = Double.parseDouble(vu);

        if (vau > vac) {
            verificacusto = 1;
        } else {
            JOptionPane.showMessageDialog(null, "Valor de custo maior ou igual ao valor unitário");
        }
        return verificacusto;
    }

    public double getvalortotal() {
        double x = 0, frete;
        String tt = null, frt;
        for (int i = 0; i <= TblItens.getRowCount() - 1; i++) {
            tt = String.valueOf(TblItens.getValueAt(i, 5));
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

    private void inserirtotal() {
        double descontors, nov, ant = 0;
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
        txtfornecedorid = new javax.swing.JTextField();
        txtprodutoid = new javax.swing.JTextField();
        lbldescontors1 = new javax.swing.JLabel();
        txtfrete = new tccc.JMoneyFieldValor();
        txtdescontors1 = new tccc.JMoneyFieldValor();
        lbldesconto = new javax.swing.JLabel();
        lbldescontors = new javax.swing.JLabel();
        lblvalortotal = new javax.swing.JLabel();
        lblvalorunitario1 = new javax.swing.JLabel();
        txtvalorcusto = new tccc.JMoneyFieldValor();
        txtvalorunit = new tccc.JMoneyFieldValor();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblItens = new org.jdesktop.swingx.JXTable();
        txtquantidade = new javax.swing.JTextField();
        txtfornecedornome = new javax.swing.JTextField();
        txtdescontopor = new tccc.JMoneyFieldValor();
        txttotal = new tccc.JMoneyFieldValor();

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

        lblcadastro.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblcadastro.setForeground(new java.awt.Color(255, 255, 255));
        lblcadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcadastro.setText("Cadastro de Compra");

        lblresponsavel.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblresponsavel.setForeground(new java.awt.Color(255, 255, 255));
        lblresponsavel.setText("Produto ID/Nome:");

        lblvalorunitario.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblvalorunitario.setForeground(new java.awt.Color(255, 255, 255));
        lblvalorunitario.setText("Valor de Venda R$:");

        lblcliente.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblcliente.setForeground(new java.awt.Color(255, 255, 255));
        lblcliente.setText("Fornecedor ID/Nome:");

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

        lblquantidade.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblquantidade.setForeground(new java.awt.Color(255, 255, 255));
        lblquantidade.setText("Quantidade:");

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

        txtprodutonome.setEditable(false);
        txtprodutonome.setBackground(new java.awt.Color(171, 121, 85));
        txtprodutonome.setForeground(new java.awt.Color(255, 255, 255));
        txtprodutonome.setCaretColor(new java.awt.Color(255, 255, 255));
        txtprodutonome.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtprodutonome.setSelectedTextColor(new java.awt.Color(255, 255, 255));

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

        txtfornecedorid.setEditable(false);
        txtfornecedorid.setBackground(new java.awt.Color(171, 121, 85));
        txtfornecedorid.setForeground(new java.awt.Color(255, 255, 255));
        txtfornecedorid.setCaretColor(new java.awt.Color(255, 255, 255));
        txtfornecedorid.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtfornecedorid.setSelectedTextColor(new java.awt.Color(255, 255, 255));

        txtprodutoid.setEditable(false);
        txtprodutoid.setBackground(new java.awt.Color(171, 121, 85));
        txtprodutoid.setForeground(new java.awt.Color(255, 255, 255));
        txtprodutoid.setCaretColor(new java.awt.Color(255, 255, 255));
        txtprodutoid.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtprodutoid.setSelectedTextColor(new java.awt.Color(255, 255, 255));

        lbldescontors1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbldescontors1.setForeground(new java.awt.Color(255, 255, 255));
        lbldescontors1.setText("Frete R$:");

        txtfrete.setBorder(null);
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

        lbldesconto.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbldesconto.setForeground(new java.awt.Color(255, 255, 255));
        lbldesconto.setText("Desconto %:");

        lbldescontors.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbldescontors.setForeground(new java.awt.Color(255, 255, 255));
        lbldescontors.setText("Desconto R$:");

        lblvalortotal.setForeground(new java.awt.Color(255, 255, 255));
        lblvalortotal.setText("Total do Pedido R$:");

        lblvalorunitario1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblvalorunitario1.setForeground(new java.awt.Color(255, 255, 255));
        lblvalorunitario1.setText("Valor de Custo R$:");

        txtvalorcusto.setBorder(null);
        txtvalorcusto.setForeground(new java.awt.Color(255, 255, 255));
        txtvalorcusto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtvalorcusto.setText("0,0000");
        txtvalorcusto.setPreferredSize(new java.awt.Dimension(28, 24));
        txtvalorcusto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtvalorcustoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalorcustoKeyTyped(evt);
            }
        });

        txtvalorunit.setBorder(null);
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

        TblItens.setForeground(new java.awt.Color(255, 255, 255));
        TblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produto", "Produto", "Valor de Custo", "Valor de Venda", "Quantidade", "Total do Produto"
            }
        ));
        TblItens.setColumnControl(null);
        jScrollPane1.setViewportView(TblItens);

        txtquantidade.setForeground(new java.awt.Color(255, 255, 255));
        txtquantidade.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtquantidade.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtquantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtquantidadeKeyTyped(evt);
            }
        });

        txtfornecedornome.setEditable(false);
        txtfornecedornome.setBackground(new java.awt.Color(171, 121, 85));
        txtfornecedornome.setForeground(new java.awt.Color(255, 255, 255));
        txtfornecedornome.setCaretColor(new java.awt.Color(255, 255, 255));
        txtfornecedornome.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtfornecedornome.setSelectedTextColor(new java.awt.Color(255, 255, 255));

        txtdescontopor.setBorder(null);
        txtdescontopor.setForeground(new java.awt.Color(255, 255, 255));
        txtdescontopor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtdescontopor.setText("0,0000");
        txtdescontopor.setPreferredSize(new java.awt.Dimension(28, 24));
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

        txttotal.setEditable(false);
        txttotal.setBorder(null);
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txttotal.setText("0,000");
        txttotal.setPreferredSize(new java.awt.Dimension(28, 24));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblcadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MovimentarJanela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182)
                .addComponent(lblvalortotal)
                .addGap(18, 18, 18)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcliente)
                    .addComponent(lblquantidade)
                    .addComponent(lblvalorunitario1)
                    .addComponent(lbldesconto))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtvalorcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtfornecedorid, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfornecedornome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescontopor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblvalorunitario)
                            .addComponent(lbldescontors1)
                            .addComponent(lbldescontors)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(addcliente)
                        .addGap(45, 45, 45)
                        .addComponent(lblresponsavel)))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtprodutoid, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprodutonome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addproduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtdescontors1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfrete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(txtvalorunit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbladicionar)
                        .addGap(18, 18, 18)
                        .addComponent(lblexcluir)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcadastro)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblresponsavel)
                        .addComponent(lblcliente)
                        .addComponent(txtprodutonome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfornecedorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtprodutoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfornecedornome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addcliente)
                    .addComponent(addproduto))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblvalorunitario1)
                    .addComponent(txtvalorcusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalorunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvalorunitario))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldescontors1)
                            .addComponent(lblquantidade)
                            .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldesconto)
                            .addComponent(txtdescontors1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldescontors)
                            .addComponent(txtdescontopor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblexcluir)
                            .addComponent(lbladicionar))
                        .addGap(5, 5, 5)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblvalortotal)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PedidoComprar pc = new PedidoComprar();
        if (txtfornecedorid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um fornecedor");
        } else {
            if (TblItens.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum produto foi listado");
            } else {
                pc.setId_compra(idcompra);
                pc.setId_fornecedor(Integer.parseInt(txtfornecedorid.getText()));
                pc.setFrete(Double.parseDouble(replaces(txtfrete.getText())));
                pc.setDesconto(Double.parseDouble(replaces(txtdescontors1.getText())));
                pc.setDescontoporcentagem(Double.parseDouble(replaces(txtdescontopor.getText())));
                pc.setValortotal_pedido(Double.parseDouble(replaces(txttotal.getText())));

                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime agorah = LocalTime.now();
                pc.setHora(Time.valueOf(formatador.format(agorah)));
                LocalDate agorad = LocalDate.now();
                pc.setData(Date.valueOf(agorad));

                PedidoComprarDAO dao1 = new PedidoComprarDAO();
                dao1.Alterar(pc);
                ItensPedidoComprarDAO dao = new ItensPedidoComprarDAO();
                dao.Remover(idcompra);
                for (int linha = 0; linha <= TblItens.getRowCount() - 1; linha++) {
                    pc.setId_produto(Integer.parseInt(replaces(String.valueOf(TblItens.getValueAt(linha, 0)))));
                    pc.setValor_custo(Double.parseDouble(replaces(String.valueOf(TblItens.getValueAt(linha, 2)))));
                    pc.setValor_unitario(Double.parseDouble(replaces(String.valueOf(TblItens.getValueAt(linha, 3)))));
                    pc.setQuantidade(Integer.parseInt(replaces(String.valueOf(TblItens.getValueAt(linha, 4)))));
                    pc.setValor_totalitem(Double.parseDouble(replaces(String.valueOf(TblItens.getValueAt(linha, 5)))));
                    dao.adicionar(pc);
                }
                Component comp = SwingUtilities.getRoot(this);
                ((Window) comp).dispose();
                dao1.ListarTabela(Tbl);
                ControleDeColuna c = new ControleDeColuna(Tbl, true);
            }
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
                if (vericaCusto() == 1) {
                    if (verifica() == true) {
                        quantidade = Integer.parseInt(txtquantidade.getText());
                        if (quantidade > 0) {
                            produtoid = txtprodutoid.getText();
                            produtonome = txtprodutonome.getText();
                            valorcusto = txtvalorcusto.getText();
                            valorunit = txtvalorunit.getText();
                            DefaultTableModel model = (DefaultTableModel) TblItens.getModel();
                            model.addRow(new Object[]{
                                produtoid,
                                produtonome,
                                "R$ " + valorcusto,
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
                            txtvalorcusto.setText("0,00");
                            txtvalorunit.setText("0,00");
                            txtquantidade.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Quantidade nao pode ser 0");
                        }
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
    }//GEN-LAST:event_lblexcluirMouseClicked

    private void lblexcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexcluirMouseEntered
        lblexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Cancel_24px.png")));
        lblexcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblexcluirMouseEntered

    private void lblexcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexcluirMouseExited
        lblexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Cancel_24px_1.png")));
    }//GEN-LAST:event_lblexcluirMouseExited

    private void addclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addclienteMouseClicked
        JFD_PesquisarFornecedor PF = new JFD_PesquisarFornecedor(null, true);
        PF.setVisible(true);
        if (PF.fechou == true) {
            txtfornecedorid.setText(PF.getID());
            txtfornecedornome.setText(PF.getNome());
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
        JFD_PesquisarProduto PC = new JFD_PesquisarProduto(null, true);
        PC.setVisible(true);
        if (PC.fechou == true) {
            txtprodutoid.setText(PC.getID());
            txtprodutonome.setText(PC.getNome());
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

    private void txtvalorcustoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorcustoKeyReleased
        if (txtvalorcusto.getText().trim().equals("")) {
            txtvalorcusto.setText("" + "0.00");
        }
    }//GEN-LAST:event_txtvalorcustoKeyReleased

    private void txtvalorcustoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorcustoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtvalorcustoKeyTyped

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

    private void txtquantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtquantidadeKeyTyped

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Entrar;
    private javax.swing.JLabel Entrar_1;
    private javax.swing.JPanel MovimentarJanela;
    private org.jdesktop.swingx.JXTable TblItens;
    private javax.swing.JLabel addcliente;
    private javax.swing.JLabel addproduto;
    private javax.swing.JLabel fechar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbladicionar;
    private javax.swing.JLabel lblcadastro;
    private javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lbldesconto;
    private javax.swing.JLabel lbldescontors;
    private javax.swing.JLabel lbldescontors1;
    private javax.swing.JLabel lblexcluir;
    private javax.swing.JLabel lblquantidade;
    private javax.swing.JLabel lblresponsavel;
    private javax.swing.JLabel lblvalortotal;
    private javax.swing.JLabel lblvalorunitario;
    private javax.swing.JLabel lblvalorunitario1;
    private tccc.JMoneyFieldValor txtdescontopor;
    private tccc.JMoneyFieldValor txtdescontors1;
    private javax.swing.JTextField txtfornecedorid;
    private javax.swing.JTextField txtfornecedornome;
    private tccc.JMoneyFieldValor txtfrete;
    private javax.swing.JTextField txtprodutoid;
    private javax.swing.JTextField txtprodutonome;
    private javax.swing.JTextField txtquantidade;
    private tccc.JMoneyFieldValor txttotal;
    private tccc.JMoneyFieldValor txtvalorcusto;
    private tccc.JMoneyFieldValor txtvalorunit;
    // End of variables declaration//GEN-END:variables
}
