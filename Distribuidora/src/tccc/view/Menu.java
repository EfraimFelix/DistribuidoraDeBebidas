/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.view;

import com.bulenkov.darcula.DarculaLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicLookAndFeel;
import tccc.DAO.EmpresaDAO;
import tccc.Modelo.Empresa;
import tccc.view.Paineis.Painel_TelaCliente;
import tccc.view.Paineis.Painel_TelaConfig;
import tccc.view.Paineis.Painel_TelaFuncionario;
import tccc.view.Paineis.Painel_TelaProduto;
import tccc.view.Paineis.Painel_TelaEstoque;
import tccc.view.Paineis.Painel_TelaFornecedor;
import tccc.view.Paineis.Painel_TelaHome;
import tccc.view.Paineis.Painel_TelaPedidoDeCompra;
import tccc.view.Paineis.Painel_TelaPedidoDeVenda;

public class Menu extends javax.swing.JFrame {

    GridBagLayout grid = new GridBagLayout();
    Painel_TelaCliente CC;
    Painel_TelaFuncionario CFU;
    Painel_TelaProduto CPR;
    Painel_TelaFornecedor CFO;
    Painel_TelaEstoque CE;
    Painel_TelaPedidoDeVenda CPV;
    Painel_TelaPedidoDeCompra CPC;
    Painel_TelaHome H;
    Painel_TelaConfig CFG;
    JSeparator JS, Separator;
    int xMouse, yMouse;
    javax.swing.JPanel Botao_Comprar, Botao_Vender, Botao_TipoConta, Botao_Sair, Botao_AlterarDados;
    javax.swing.JLabel Botao_Comprar_LblImg, Botao_Comprar_LblText, Botao_Vender_LblImg, Botao_Vender_LblText, Botao_TipoConta_LblImg, Botao_TipoConta_LblText, Botao_Sair_LblImg, Botao_Sair_LblText, Botao_AlterarDados_LblImg, Botao_AlterarDados_LblText;
    final JPopupMenu PopMenu = new JPopupMenu("Menu");
    final JPopupMenu PopMenuUsu = new JPopupMenu("Menu2");

    public Menu(int x) throws ParseException {
        initComponents();
        this.setLocationRelativeTo(null);

        CFG = new Painel_TelaConfig();
        CC = new Painel_TelaCliente();
        CFU = new Painel_TelaFuncionario();
        CPR = new Painel_TelaProduto();
        CFO = new Painel_TelaFornecedor();
        CE = new Painel_TelaEstoque();
        CPV = new Painel_TelaPedidoDeVenda();
        CPC = new Painel_TelaPedidoDeCompra();
        H = new Painel_TelaHome();

        AreaDinamica.setLayout(grid);
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        AreaDinamica.add(CC, gc);
        AreaDinamica.add(CFU, gc);
        AreaDinamica.add(CPR, gc);
        AreaDinamica.add(CFO, gc);
        AreaDinamica.add(CE, gc);
        AreaDinamica.add(CPV, gc);
        AreaDinamica.add(CPC, gc);
        AreaDinamica.add(H, gc);
        AreaDinamica.add(CFG, gc);

        setVisibleTrue(H);
        if (H.isVisible() == true) {
            setBackgroundBotao(Botao_Home);
        }

        colocarDados();
        criarPopMenuPedido();
        criarPopMenuUsuario();
        lblusuario.setText(System.getProperty("Usuario_Nome"));
    }

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void colocarDados() {

        EmpresaDAO daoemp = new EmpresaDAO();
        String endereco = null;
        List<Empresa> empresa = daoemp.Lista();
        for (Empresa emp : empresa) {
            endereco = "" + emp.getEndereco() + ", " + emp.getNumero() + " - " + emp.getBairro() + ", " + emp.getCidade() + " - " + emp.getEstado();
            lblnome.setText("" + emp.getNome());
            lblendereco.setText("" + endereco);
            lblemail.setText("" + emp.getEmail());
            lbltelefone1.setText("" + emp.getTelefone1());
            lbltelefone2.setText("" + emp.getTelefone2());
        }
    }

    public void setBackgroundBotao(JPanel jp) {
        Botao_Home.setBackground(new Color(0, 102, 255));
        Botao_Cliente.setBackground(new Color(0, 102, 255));
        Botao_Funcionario.setBackground(new Color(0, 102, 255));
        Botao_Produto.setBackground(new Color(0, 102, 255));
        Botao_Fornecedor.setBackground(new Color(0, 102, 255));
        Botao_Estoque.setBackground(new Color(0, 102, 255));
        Botao_Pedido.setBackground(new Color(0, 102, 255));
        Botao_Config.setBackground(new Color(0, 102, 255));
        jp.setBackground(new Color(0, 153, 255));
    }

    public void setVisibleTrue(JPanel jp) {
        CC.setVisible(false);
        CFU.setVisible(false);
        CPR.setVisible(false);
        CFO.setVisible(false);
        CE.setVisible(false);
        CPV.setVisible(false);
        CPC.setVisible(false);
        H.setVisible(false);
        CFG.setVisible(false);
        jp.setVisible(true);
    }

    public void setBacgroundIsVisible() {
        if (CC.isVisible() == true) {
            setBackgroundBotao(Botao_Cliente);
        } else if (CFU.isVisible() == true) {
            setBackgroundBotao(Botao_Funcionario);
        } else if (CPR.isVisible() == true) {
            setBackgroundBotao(Botao_Produto);
        } else if (CFO.isVisible() == true) {
            setBackgroundBotao(Botao_Fornecedor);
        } else if (CE.isVisible() == true) {
            setBackgroundBotao(Botao_Estoque);
        } else if (CPV.isVisible() == true) {
            setBackgroundBotao(Botao_Pedido);
        } else if (CPC.isVisible() == true) {
            setBackgroundBotao(Botao_Pedido);
        } else if (H.isVisible() == true) {
            setBackgroundBotao(Botao_Home);
        } else if (CFG.isVisible() == true) {
            setBackgroundBotao(Botao_Config);
        } else {
            System.out.println("Erro no Menu Lateral");
        }
    }

    public void setBacgroundIsVisibleSubMenu() {
        if (CPV.isVisible() == true) {
            Botao_Vender.setBackground(new Color(0, 153, 255));
            Botao_Comprar.setBackground(new Color(0, 102, 255));
        } else if (CPC.isVisible() == true) {
            Botao_Comprar.setBackground(new Color(0, 153, 255));
            Botao_Vender.setBackground(new Color(0, 102, 255));
        }
    }

    public void SubMenusetVisible(boolean bol) {
        PopMenu.setVisible(bol);
    }

    public void setBackgroundSubsBotoes(JPanel jp) {
        Botao_Comprar.setBackground(new Color(0, 102, 255));
        Botao_Vender.setBackground(new Color(0, 102, 255));
        jp.setBackground(new Color(0, 153, 255));
    }

    public void criarPopMenuPedido() {
        JS = new JSeparator();

        Botao_Comprar = new javax.swing.JPanel();
        Botao_Comprar_LblImg = new javax.swing.JLabel();
        Botao_Comprar_LblText = new javax.swing.JLabel();

        Botao_Comprar.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Comprar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Botao_Comprar_LblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Purchase_Order_15px.png"))); // NOI18N
        Botao_Comprar.add(Botao_Comprar_LblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        Botao_Comprar_LblText.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        Botao_Comprar_LblText.setForeground(new java.awt.Color(255, 255, 255));
        Botao_Comprar_LblText.setText("Pedidos de Compras   ");
        Botao_Comprar.add(Botao_Comprar_LblText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        Botao_Vender = new javax.swing.JPanel();
        Botao_Vender_LblImg = new javax.swing.JLabel();
        Botao_Vender_LblText = new javax.swing.JLabel();

        Botao_Vender.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Vender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Botao_Vender_LblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Purchase_Order_15px.png"))); // NOI18N
        Botao_Vender.add(Botao_Vender_LblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        Botao_Vender_LblText.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        Botao_Vender_LblText.setForeground(new java.awt.Color(255, 255, 255));
        Botao_Vender_LblText.setText("Pedidos de Vendas   ");
        Botao_Vender.add(Botao_Vender_LblText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        Botao_Comprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Botao_ComprarMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                Botao_ComprarMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                Botao_ComprarMouseExited(evt);
            }
        });

        Botao_Vender.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Botao_VenderMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                Botao_VenderMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                Botao_VenderMouseExited(evt);
            }
        });

        JS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                Botao_Pedido.setBackground(new Color(0, 153, 255));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                Botao_Pedido.setBackground(new Color(0, 102, 255));
            }
        });

        PopMenu.setBackground(new Color(255, 255, 255));
        PopMenu.setBorderPainted(false);

        JS.setForeground(new Color(255, 255, 255));
        JS.setBackground(new Color(255, 255, 255));
        PopMenu.add(Botao_Comprar);
        PopMenu.add(JS);
        PopMenu.add(Botao_Vender);
    }

    public void criarPopMenuUsuario() {
        Separator = new JSeparator();

        Botao_TipoConta = new javax.swing.JPanel();
        Botao_TipoConta_LblImg = new javax.swing.JLabel();
        Botao_TipoConta_LblText = new javax.swing.JLabel();

        Botao_TipoConta.setBackground(new java.awt.Color(0, 102, 255));
        Botao_TipoConta.setSize(70, 50);

//        Botao_TipoConta_LblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Purchase_Order_15px.png"))); // NOI18N
//        Botao_TipoConta.add(Botao_TipoConta_LblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));
        Botao_TipoConta_LblText.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        Botao_TipoConta_LblText.setForeground(new java.awt.Color(255, 255, 255));
        Botao_TipoConta_LblText.setText(System.getProperty("Usuario_TipoConta"));
        Botao_TipoConta.add(Botao_TipoConta_LblText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        Botao_Sair = new javax.swing.JPanel();
        Botao_Sair_LblImg = new javax.swing.JLabel();
        Botao_Sair_LblText = new javax.swing.JLabel();

        Botao_Sair.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Sair.setSize(70, 50);

//        Botao_Sair_LblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Purchase_Order_15px.png"))); // NOI18N
//        Botao_Sair.add(Botao_Sair_LblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));
        Botao_Sair_LblText.setFont(new java.awt.Font("Trebuchet MS", 1, 10));
        Botao_Sair_LblText.setForeground(new java.awt.Color(255, 255, 255));
        Botao_Sair_LblText.setText("Sair");
        Botao_Sair.add(Botao_Sair_LblText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        Botao_AlterarDados = new javax.swing.JPanel();
        Botao_AlterarDados_LblImg = new javax.swing.JLabel();
        Botao_AlterarDados_LblText = new javax.swing.JLabel();

        Botao_AlterarDados.setBackground(new java.awt.Color(0, 102, 255));
        Botao_AlterarDados.setSize(70, 50);

//        Botao_AlterarDados_LblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Purchase_Order_15px.png"))); // NOI18N
//        Botao_AlterarDados.add(Botao_AlterarDados_LblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));
        Botao_AlterarDados_LblText.setFont(new java.awt.Font("Trebuchet MS", 1, 10));
        Botao_AlterarDados_LblText.setForeground(new java.awt.Color(255, 255, 255));
        Botao_AlterarDados_LblText.setText("Alterar dados");
        Botao_AlterarDados.add(Botao_AlterarDados_LblText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

//*****************************************************************************************************************
        Botao_Sair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Botao_SairMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                Botao_SairMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                Botao_SairMouseExited(evt);
            }
        });
        Botao_AlterarDados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Botao_AlterarDadosMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                Botao_AlterarDadosMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                Botao_AlterarDadosMouseExited(evt);
            }
        });

        PopMenuUsu.setBackground(new Color(255, 255, 255));
        PopMenuUsu.setBorderPainted(false);

        Separator.setForeground(new Color(255, 255, 255));
        Separator.setBackground(new Color(255, 255, 255));

        PopMenuUsu.add(Botao_TipoConta);
        PopMenuUsu.add(Separator);
        PopMenuUsu.add(Botao_AlterarDados);
        PopMenuUsu.add(Botao_Sair);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        MenuLateral = new javax.swing.JPanel();
        Botao_Home = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Botao_Cliente = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Botao_Funcionario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Botao_Produto = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Botao_Fornecedor = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Botao_Estoque = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Botao_Pedido = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Botao_Config = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblnome = new javax.swing.JLabel();
        lbltelefone1 = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblendereco = new javax.swing.JLabel();
        lbltelefone2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblusuario = new javax.swing.JLabel();
        LblMenuUsuario = new javax.swing.JLabel();
        AreaDinamica = new javax.swing.JPanel();
        MovimentarJanela = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(444, 444));
        setUndecorated(true);

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        MenuLateral.setBackground(new java.awt.Color(0, 64, 136));
        MenuLateral.setToolTipText("");
        MenuLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Botao_Home.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_HomeMouseExited(evt);
            }
        });
        Botao_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Home_15px.png"))); // NOI18N
        Botao_Home.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Home");
        Botao_Home.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        MenuLateral.add(Botao_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, -1));

        Botao_Cliente.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_ClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_ClienteMouseExited(evt);
            }
        });
        Botao_Cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Customer_15px.png"))); // NOI18N
        Botao_Cliente.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cliente");
        Botao_Cliente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        MenuLateral.add(Botao_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 220, -1));

        Botao_Funcionario.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Funcionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_FuncionarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_FuncionarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_FuncionarioMouseExited(evt);
            }
        });
        Botao_Funcionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Workers_15px.png"))); // NOI18N
        Botao_Funcionario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Funcionario");
        Botao_Funcionario.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        MenuLateral.add(Botao_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, -1));

        Botao_Produto.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_ProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_ProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_ProdutoMouseExited(evt);
            }
        });
        Botao_Produto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Product_15px.png"))); // NOI18N
        Botao_Produto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Produto");
        Botao_Produto.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        MenuLateral.add(Botao_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 220, -1));

        Botao_Fornecedor.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_FornecedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_FornecedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_FornecedorMouseExited(evt);
            }
        });
        Botao_Fornecedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Truck_15px.png"))); // NOI18N
        Botao_Fornecedor.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fornecedor");
        Botao_Fornecedor.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        MenuLateral.add(Botao_Fornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 220, -1));

        Botao_Estoque.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_EstoqueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_EstoqueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_EstoqueMouseExited(evt);
            }
        });
        Botao_Estoque.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Trolley_15px_2.png"))); // NOI18N
        Botao_Estoque.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Estoque");
        Botao_Estoque.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        MenuLateral.add(Botao_Estoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 220, -1));

        Botao_Pedido.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_PedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_PedidoMouseExited(evt);
            }
        });
        Botao_Pedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Purchase_Order_15px.png"))); // NOI18N
        Botao_Pedido.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Pedidos");
        Botao_Pedido.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_More_26px.png"))); // NOI18N
        Botao_Pedido.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 20));

        MenuLateral.add(Botao_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 220, -1));

        Botao_Config.setBackground(new java.awt.Color(0, 102, 255));
        Botao_Config.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Botao_ConfigMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Botao_ConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Botao_ConfigMouseExited(evt);
            }
        });
        Botao_Config.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Settings_15px_1.png"))); // NOI18N
        Botao_Config.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Configurações");
        Botao_Config.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        MenuLateral.add(Botao_Config, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 220, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        lblnome.setFont(new java.awt.Font("Tw Cen MT", 1, 75)); // NOI18N
        lblnome.setForeground(new java.awt.Color(255, 255, 255));
        lblnome.setText("J.C Tramontina");

        lbltelefone1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbltelefone1.setForeground(new java.awt.Color(255, 255, 255));
        lbltelefone1.setText("(11) 4152-6500");

        lblemail.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblemail.setForeground(new java.awt.Color(255, 255, 255));
        lblemail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblendereco.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblendereco.setForeground(new java.awt.Color(255, 255, 255));
        lblendereco.setText("Rua Alberto Frediani, 219 - Centro, Santana de Parnaíba - SP");

        lbltelefone2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbltelefone2.setForeground(new java.awt.Color(255, 255, 255));
        lbltelefone2.setText("(11) 4152-6500");

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        lblusuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        LblMenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Sort_Down_30px_1.png"))); // NOI18N
        LblMenuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblMenuUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LblMenuUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LblMenuUsuarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LblMenuUsuarioMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblMenuUsuario)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblMenuUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltelefone1)
                        .addGap(40, 40, 40)
                        .addComponent(lbltelefone2)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblendereco, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblnome, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(lblnome, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AreaDinamica.setBackground(new java.awt.Color(0, 0, 0));
        AreaDinamica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AreaDinamicaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AreaDinamicaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout AreaDinamicaLayout = new javax.swing.GroupLayout(AreaDinamica);
        AreaDinamica.setLayout(AreaDinamicaLayout);
        AreaDinamicaLayout.setHorizontalGroup(
            AreaDinamicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        AreaDinamicaLayout.setVerticalGroup(
            AreaDinamicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Close_Window_20px_3.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Minimize_Window_20px_1.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Gerenciador Comercial - J.C Tramontina");

        javax.swing.GroupLayout MovimentarJanelaLayout = new javax.swing.GroupLayout(MovimentarJanela);
        MovimentarJanela.setLayout(MovimentarJanelaLayout);
        MovimentarJanelaLayout.setHorizontalGroup(
            MovimentarJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MovimentarJanelaLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 759, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5))
        );
        MovimentarJanelaLayout.setVerticalGroup(
            MovimentarJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovimentarJanelaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(MovimentarJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AreaDinamica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(MovimentarJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(AreaDinamica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Botao_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_HomeMouseClicked
        setVisibleTrue(H);
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_HomeMouseClicked

    private void Botao_FuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_FuncionarioMouseClicked
        setVisibleTrue(CFU);
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_FuncionarioMouseClicked

    private void Botao_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ClienteMouseClicked
        setVisibleTrue(CC);
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_ClienteMouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Close_Window_20px_2.png")));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        setExtendedState(Menu.ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Minimize_Window_20px_2.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Close_Window_20px_3.png")));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tccc/Imagens/icons8_Minimize_Window_20px_1.png")));
    }//GEN-LAST:event_jLabel2MouseExited

    private void MovimentarJanelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovimentarJanelaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_MovimentarJanelaMousePressed

    private void MovimentarJanelaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovimentarJanelaMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - xMouse, this.getLocation().y + evt.getY() - yMouse);
    }//GEN-LAST:event_MovimentarJanelaMouseDragged

    private void Botao_HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_HomeMouseEntered
        Botao_Home.setBackground(new Color(0, 153, 255));
        Botao_Home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SubMenusetVisible(false);
    }//GEN-LAST:event_Botao_HomeMouseEntered

    private void Botao_ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ClienteMouseEntered
        Botao_Cliente.setBackground(new Color(0, 153, 255));
        Botao_Cliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SubMenusetVisible(false);
    }//GEN-LAST:event_Botao_ClienteMouseEntered

    private void Botao_FuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_FuncionarioMouseEntered
        Botao_Funcionario.setBackground(new Color(0, 153, 255));
        Botao_Funcionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SubMenusetVisible(false);
    }//GEN-LAST:event_Botao_FuncionarioMouseEntered

    private void Botao_ProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ProdutoMouseEntered
        Botao_Produto.setBackground(new Color(0, 153, 255));
        Botao_Produto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SubMenusetVisible(false);
    }//GEN-LAST:event_Botao_ProdutoMouseEntered

    private void Botao_HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_HomeMouseExited
        Botao_Home.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_HomeMouseExited

    private void Botao_ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ClienteMouseExited
        Botao_Cliente.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_ClienteMouseExited

    private void Botao_FuncionarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_FuncionarioMouseExited
        Botao_Funcionario.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_FuncionarioMouseExited

    private void Botao_ProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ProdutoMouseExited
        Botao_Produto.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_ProdutoMouseExited

    private void Botao_FornecedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_FornecedorMouseEntered
        Botao_Fornecedor.setBackground(new Color(0, 153, 255));
        Botao_Fornecedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SubMenusetVisible(false);
    }//GEN-LAST:event_Botao_FornecedorMouseEntered

    private void Botao_FornecedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_FornecedorMouseExited
        Botao_Fornecedor.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_FornecedorMouseExited

    private void Botao_EstoqueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_EstoqueMouseEntered
        Botao_Estoque.setBackground(new Color(0, 153, 255));
        Botao_Estoque.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SubMenusetVisible(false);
    }//GEN-LAST:event_Botao_EstoqueMouseEntered

    private void Botao_EstoqueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_EstoqueMouseExited
        Botao_Estoque.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_EstoqueMouseExited

    private void Botao_PedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_PedidoMouseEntered
        Botao_Pedido.setBackground(new Color(0, 153, 255));
        if (PopMenu.isShowing() == false) {
            PopMenu.show(Botao_Pedido, Botao_Pedido.getWidth(), Botao_Pedido.getHeight() - 62);
            //System.err.println("abriu submenu");
        } else {
            //System.err.println("sub menu ja esta aberto");
        }
        setBacgroundIsVisibleSubMenu();

    }//GEN-LAST:event_Botao_PedidoMouseEntered

    private void Botao_PedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_PedidoMouseExited
        Botao_Pedido.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_PedidoMouseExited

    private void Botao_ConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ConfigMouseClicked
        if (System.getProperty("Usuario_TipoConta").equals("Administrador") || System.getProperty("Usuario_TipoConta") == null) {
            setVisibleTrue(CFG);
            setBacgroundIsVisible();
        } else {
            JOptionPane.showMessageDialog(null, "Desculpa, mas apenas administradores tem acesso a está página");
        }
    }//GEN-LAST:event_Botao_ConfigMouseClicked

    private void Botao_ConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ConfigMouseEntered
        Botao_Config.setBackground(new Color(0, 153, 255));
        Botao_Config.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SubMenusetVisible(false);
    }//GEN-LAST:event_Botao_ConfigMouseEntered

    private void Botao_ConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ConfigMouseExited
        Botao_Config.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_ConfigMouseExited

    private void Botao_ProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_ProdutoMouseClicked
        setVisibleTrue(CPR);
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_ProdutoMouseClicked

    private void Botao_FornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_FornecedorMouseClicked
        setVisibleTrue(CFO);
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_FornecedorMouseClicked

    private void Botao_EstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Botao_EstoqueMouseClicked
        setVisibleTrue(CE);
        CE.ListarTabela();
        setBacgroundIsVisible();
    }//GEN-LAST:event_Botao_EstoqueMouseClicked

    private void Botao_ComprarMouseClicked(MouseEvent evt) {
        setVisibleTrue(CPC);
        CPC.ListarTabela();
        SubMenusetVisible(false);
        setBacgroundIsVisible();
    }

    private void Botao_ComprarMouseEntered(MouseEvent evt) {
        Botao_Pedido.setBackground(new Color(0, 153, 255));
        Botao_Comprar.setBackground(new Color(0, 153, 255));
        Botao_Comprar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void Botao_ComprarMouseExited(MouseEvent evt) {
        Botao_Comprar.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }

    private void Botao_VenderMouseClicked(MouseEvent evt) {
        setVisibleTrue(CPV);
        CPV.ListarTabela();
        SubMenusetVisible(false);
        setBacgroundIsVisible();
    }

    private void Botao_VenderMouseEntered(MouseEvent evt) {
        Botao_Pedido.setBackground(new Color(0, 153, 255));
        Botao_Vender.setBackground(new Color(0, 153, 255));
        Botao_Vender.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void Botao_VenderMouseExited(MouseEvent evt) {
        Botao_Vender.setBackground(new Color(0, 102, 255));
        setBacgroundIsVisible();
    }

    private void Botao_SairMouseClicked(MouseEvent evt) {
        int r = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?!", "Mensagem", JOptionPane.YES_NO_OPTION);
        if (r == 0) {
            System.setProperty("Usuario_ID", "");
            System.setProperty("Usuario_Nome", "");
            System.setProperty("Usuario_Email", "");
            System.setProperty("Usuario_TipoConta", "");
            Login login = new Login();
            dispose();
            login.setVisible(true);
        }
    }

    private void Botao_SairMouseEntered(MouseEvent evt) {
        Botao_Sair.setBackground(new Color(0, 153, 255));
        Botao_Sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void Botao_SairMouseExited(MouseEvent evt) {
        Botao_Sair.setBackground(new Color(0, 102, 255));
    }

    private void Botao_AlterarDadosMouseClicked(MouseEvent evt) {
        JFD_AtualizarUsuario AU = new JFD_AtualizarUsuario(this, true);
        AU.setVisible(true);
    }

    private void Botao_AlterarDadosMouseEntered(MouseEvent evt) {
        Botao_AlterarDados.setBackground(new Color(0, 153, 255));
        Botao_AlterarDados.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void Botao_AlterarDadosMouseExited(MouseEvent evt) {
        Botao_AlterarDados.setBackground(new Color(0, 102, 255));
    }

    private void AreaDinamicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AreaDinamicaMouseEntered

    }//GEN-LAST:event_AreaDinamicaMouseEntered

    private void AreaDinamicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AreaDinamicaMouseClicked

    }//GEN-LAST:event_AreaDinamicaMouseClicked

    private void LblMenuUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblMenuUsuarioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_LblMenuUsuarioMouseExited

    private void LblMenuUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblMenuUsuarioMouseEntered

    }//GEN-LAST:event_LblMenuUsuarioMouseEntered

    private void LblMenuUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblMenuUsuarioMouseClicked
        if (PopMenuUsu.isShowing() == false) {
            PopMenuUsu.show(LblMenuUsuario, LblMenuUsuario.getWidth() - 70, LblMenuUsuario.getHeight());
            System.err.println("abriu submenu");
        } else {
            System.err.println("sub menu ja esta aberto");
        }
    }//GEN-LAST:event_LblMenuUsuarioMouseClicked

    private void LblMenuUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblMenuUsuarioMousePressed

    }//GEN-LAST:event_LblMenuUsuarioMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

            BasicLookAndFeel darcula = new DarculaLaf();
            UIManager.setLookAndFeel(darcula);

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AreaDinamica;
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Botao_Cliente;
    private javax.swing.JPanel Botao_Config;
    private javax.swing.JPanel Botao_Estoque;
    private javax.swing.JPanel Botao_Fornecedor;
    private javax.swing.JPanel Botao_Funcionario;
    private javax.swing.JPanel Botao_Home;
    private javax.swing.JPanel Botao_Pedido;
    private javax.swing.JPanel Botao_Produto;
    private javax.swing.JLabel LblMenuUsuario;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JPanel MovimentarJanela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblendereco;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lbltelefone1;
    private javax.swing.JLabel lbltelefone2;
    private javax.swing.JLabel lblusuario;
    // End of variables declaration//GEN-END:variables
}
