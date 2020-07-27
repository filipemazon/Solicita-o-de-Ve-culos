
import java.applet.Applet;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.scene.media.AudioClip;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.IOException;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class FraSegundo extends javax.swing.JFrame {

    DefaultTableModel tmConsulta1 = new DefaultTableModel(null, new String[]{"Departamento", "Usuário", "Local de Saida", "Data",
        "Horário", "Tempo de Espera", "Situação", "N° do Pedido"});

    ListSelectionModel lsmContato;
    
    
            
    List<Pedido> listap1;
    List<Pedido> minhaLista;
    
    
    DefaultTableModel tmConsulta2 = new DefaultTableModel(null, new String[]{"Departamento", "Usuário", "Local de Saida", "Data",
        "Horário", "Tempo de Espera", "Situação", "N° do Pedido"});

    ListSelectionModel lsmContato2;
    List<Pedido> listap2;
    List<Pedido> minhaLista2;

    
// TABELA USUARIO AQUI <<
    DefaultTableModel tmConsulta3 = new DefaultTableModel(null, new String[]{"Departamento", "Usuario", "Login"});

    ListSelectionModel lsmContato3;
    List<Usuario> listap3;
    List<Usuario> minhaLista3;
    List<consulta2> minhaLista12;
// FIM AQUI <<
    int verifica = 0;
    int verificalogin = 0;
    int concluir = 0;
    int apitar = 0;
    int conc=1;
    int usu=1;
    String login;
    String senha;
    Long log_usuario;
    Long log_perfil;
    Long ultimo_id;
    Long atual_id;
    Long compara_id;
    String log_departamento;
    String log_autorizado;
    String log_pedido;
    String log_espera;
    String dep;
    String aut;
    String senhaCriptografada;
    

    private Connection conexao;

    public FraSegundo() throws SQLException {
        initComponents();

        departamento.setEditable(false);
        autorizado.setEditable(false);
        pedido.setEditable(false);
        TRdepartamento.setEditable(false);
        TRautorizado.setEditable(false);
        criaConexao criaConexao = new criaConexao();
        this.conexao = criaConexao.getConexao();

        JPasswordField password = new JPasswordField(15);
        password.setEchoChar('☻');
        JLabel rotuloU = new JLabel("Usuario:");
        JTextField usuario = new JTextField(15);
        JLabel rotulo = new JLabel("Senha:");
        JPanel entUsuario = new JPanel();
        entUsuario.add(rotuloU);
        entUsuario.add(usuario);
        entUsuario.add(rotulo);
        entUsuario.add(password);
        JOptionPane.showMessageDialog(null, entUsuario, "Acesso restrito", JOptionPane.PLAIN_MESSAGE);
        senha = password.getText();
        login = usuario.getText();
        //ComparaLogin();
        criptografa();
        if (verificalogin == 0) {
        } else {
            System.exit(0);
        }

        autorizado.setText(aut);
        departamento.setText(dep);

        minhaLista = getLista();
        mostraPesquisa(minhaLista);
        
        if(log_perfil==2||log_perfil==3){
        minhaLista2 = getLista2();
        mostraPesquisa2(minhaLista2);
    }
        else{}
        
        if(log_perfil==3){
        minhaLista3 = getLista3();
        mostraPesquisa3(minhaLista3);
        }
        else{}

        if (log_perfil == 2) {

            try {
                PegaID();
            } catch (SQLException ex) {
                Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
            }
            int delay = 5000;
            int interval = 60000;
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {

                    try {
                //VERIFICAR SE TEM NOVO PEDIDO

                        Alerta();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }, delay, interval);

        } else {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar4 = new javax.swing.JMenuBar();
        JSobre = new javax.swing.JMenu();
        JSair = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        aba = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        departamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        localsaida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        destino = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        horasaida = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        horaretorno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        datasaida = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        justificativa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passageiro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        qntusuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        autorizado = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pedido = new javax.swing.JTextField();
        BOk = new javax.swing.JButton();
        BAlterar = new javax.swing.JButton();
        Nova = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        BConfirma = new javax.swing.JButton();
        BLimpar = new javax.swing.JButton();
        BNovo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        checkurgencia = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        obs2 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        BCancelar = new javax.swing.JButton();
        atualiza = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        ADMusuario = new javax.swing.JTextField();
        ADMdepartamento = new javax.swing.JTextField();
        ADMlogin = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        ADMlimpa = new javax.swing.JButton();
        ADMexcluir = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        ADMalterar = new javax.swing.JButton();
        ADMsalvar = new javax.swing.JButton();
        ADMnovo = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        ADMperfil = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ADMlimpa1 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        TRdepartamento = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TRlocalsaida = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        TRdestino = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        TRhorasaida = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        TRhoraretorno = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        TRdatasaida = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        TRjustificativa = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        TRpassageiro = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        TRqntusuario = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        TRautorizado = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        TRpedido = new javax.swing.JTextField();
        BOk1 = new javax.swing.JButton();
        TRNova = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        BConfirma1 = new javax.swing.JButton();
        TRCancela = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        TRurgencia = new javax.swing.JCheckBox();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TRobs2 = new javax.swing.JTextArea();
        TRatualiza = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        filtro1 = new javax.swing.JComboBox();
        jMenuBar2 = new javax.swing.JMenuBar();
        historico = new javax.swing.JMenu();
        JSobre1 = new javax.swing.JMenu();
        JSobre2 = new javax.swing.JMenu();
        JSair1 = new javax.swing.JMenu();

        JSobre.setText("Sobre");
        JSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JSobreMouseClicked(evt);
            }
        });
        JSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSobreActionPerformed(evt);
            }
        });
        jMenuBar4.add(JSobre);

        JSair.setText("Sair");
        JSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JSairMouseClicked(evt);
            }
        });
        jMenuBar4.add(JSair);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transporte SMS");
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        aba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abaMouseEntered(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/primeiro/logoitaprnt.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PREFEITURA MUNICIPAL DE ITABIRA");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SOLICITAÇÃO DE VEÍCULO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Anexo I do decreto n° 0460, de 15 de abril 2005");

        jLabel1.setText("Departamento:");

        departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departamentoActionPerformed(evt);
            }
        });

        jLabel4.setText("Local de Saída:");

        localsaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localsaidaActionPerformed(evt);
            }
        });

        jLabel2.setText("Destino:");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("**********************************************************************");
            destino = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoActionPerformed(evt);
            }
        });

        jLabel3.setText("Hora de Saída:");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##:##");
            horasaida = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        horasaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horasaidaMouseClicked(evt);
            }
        });
        horasaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasaidaActionPerformed(evt);
            }
        });

        jLabel13.setText("Previsão de Retorno:");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##:##");
            horaretorno = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        horaretorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaretornoActionPerformed(evt);
            }
        });

        jLabel11.setText("Data da Saída:");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            datasaida = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        datasaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datasaidaActionPerformed(evt);
            }
        });

        jLabel14.setText("Justificativa:");

        justificativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                justificativaActionPerformed(evt);
            }
        });

        jLabel8.setText("Passageiro(s):");

        passageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passageiroActionPerformed(evt);
            }
        });

        jLabel16.setText("Qnt Passageiros:");

        qntusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qntusuarioActionPerformed(evt);
            }
        });

        jLabel9.setText("Autorizado Por:");

        autorizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorizadoActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acompanhar Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel15.setText("Número do Pedido:");

        pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoActionPerformed(evt);
            }
        });

        BOk.setText("BUSCAR");
        BOk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOkMouseClicked(evt);
            }
        });
        BOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOkActionPerformed(evt);
            }
        });

        BAlterar.setText("ALTERAR");
        BAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BAlterarMouseClicked(evt);
            }
        });
        BAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAlterarActionPerformed(evt);
            }
        });

        Nova.setText("NOVA BUSCA");
        Nova.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NovaMouseClicked(evt);
            }
        });
        Nova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BOk, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Nova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(BAlterar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAlterar)
                    .addComponent(Nova)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BConfirma.setBackground(new java.awt.Color(153, 153, 255));
        BConfirma.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        BConfirma.setForeground(new java.awt.Color(0, 0, 255));
        BConfirma.setText("CONCLUIR");
        BConfirma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BConfirmaMouseClicked(evt);
            }
        });
        BConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConfirmaActionPerformed(evt);
            }
        });

        BLimpar.setText("LIMPAR TELA");
        BLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BLimparMouseClicked(evt);
            }
        });
        BLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLimparActionPerformed(evt);
            }
        });

        BNovo.setText("NOVO PEDIDO");
        BNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BNovoMouseClicked(evt);
            }
        });
        BNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BLimpar)
                .addGap(18, 18, 18)
                .addComponent(BNovo)
                .addGap(18, 18, 18)
                .addComponent(BConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BConfirma, BLimpar, BNovo});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BLimpar)
                    .addComponent(BNovo)
                    .addComponent(BConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setText("Solicitações Recentes:");

        checkurgencia.setText("Urgência");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        obs2.setColumns(20);
        obs2.setRows(5);
        obs2.setLineWrap(true);
        jScrollPane3.setViewportView(obs2);

        jLabel17.setText("Observações:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("* Campos com preenchimento obrigatorio");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("*");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 0, 0));
        jLabel43.setText("*");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setText("*");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setText("  *");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 0, 0));
        jLabel48.setText("*");

        BCancelar.setForeground(new java.awt.Color(255, 0, 51));
        BCancelar.setText("CANCELA PEDIDO");
        BCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BCancelarMouseClicked(evt);
            }
        });
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        atualiza.setText("ATUALIZAR TABELA");
        atualiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atualizaMouseClicked(evt);
            }
        });
        atualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setText("*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(atualiza))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(justificativa, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(datasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(passageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jLabel17)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(checkurgencia))
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(qntusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(autorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(15, 15, 15)
                                                        .addComponent(localsaida, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(15, 15, 15)
                                                        .addComponent(horasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(horaretorno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel47))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel10)
                                .addGap(118, 118, 118)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel14, jLabel17, jLabel3, jLabel4, jLabel8, jLabel9});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {autorizado, localsaida});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {horaretorno, horasaida});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {justificativa, passageiro});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {departamento, destino});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(localsaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(horasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(horaretorno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(justificativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(checkurgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passageiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(qntusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BCancelar)
                        .addComponent(atualiza))))
        );

        jTable6.setModel(tmConsulta1);
        jTable6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmContato = jTable6.getSelectionModel();
        lsmContato.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(! e.getValueIsAdjusting()){
                    try{
                        jTTabelaLinhaSelecionada(jTable6);
                    }catch (SQLException ex){
                    }
                }
            }
        });
        /*sempre que eu clicar em alguma linha da tabela ele 
        vai fazer o que foi selecionado lá no jTTabelaLinhaSelecionada(jTTabela);*/
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        aba.addTab("Solicitação", jPanel3);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/primeiro/logoitaprnt.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("PREFEITURA MUNICIPAL DE ITABIRA");

        jLabel23.setText("Nome Usuário:");

        jLabel24.setText("Departamento:");

        jLabel25.setText("Login:");

        ADMusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMusuarioActionPerformed(evt);
            }
        });

        ADMdepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMdepartamentoActionPerformed(evt);
            }
        });

        ADMlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMloginActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ADMlimpa.setText("LIMPAR SENHA");
        ADMlimpa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADMlimpaMouseClicked(evt);
            }
        });
        ADMlimpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMlimpaActionPerformed(evt);
            }
        });

        ADMexcluir.setText("EXCLUIR");
        ADMexcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADMexcluirMouseClicked(evt);
            }
        });
        ADMexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMexcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ADMlimpa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADMexcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ADMexcluir, ADMlimpa});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ADMlimpa)
                .addGap(18, 18, 18)
                .addComponent(ADMexcluir)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários:"));

        jTable4.setModel(tmConsulta3);
        jTable4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmContato3 = jTable4.getSelectionModel();
        lsmContato3.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(! e.getValueIsAdjusting()){
                    try{
                        jTTabelaLinhaSelecionada3(jTable4);
                    }catch (SQLException ex){
                    }
                }
            }
        });
        /*sempre que eu clicar em alguma linha da tabela ele 
        vai fazer o que foi selecionado lá no jTTabelaLinhaSelecionada(jTTabela);*/
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ADMalterar.setText("ALTERAR");
        ADMalterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADMalterarMouseClicked(evt);
            }
        });
        ADMalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMalterarActionPerformed(evt);
            }
        });

        ADMsalvar.setText("SALVAR");
        ADMsalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADMsalvarMouseClicked(evt);
            }
        });
        ADMsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMsalvarActionPerformed(evt);
            }
        });

        ADMnovo.setText("NOVO USUÁRIO");
        ADMnovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADMnovoMouseClicked(evt);
            }
        });
        ADMnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMnovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADMnovo, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ADMalterar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ADMsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ADMalterar, ADMsalvar});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADMalterar)
                    .addComponent(ADMsalvar)
                    .addComponent(ADMnovo))
                .addGap(20, 20, 20))
        );

        jLabel26.setText("Perfil:");

        ADMperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMperfilActionPerformed(evt);
            }
        });

        jButton1.setText("DEPARTAMENTOS");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        ADMlimpa1.setText("ATUALIZAR TABELA");
        ADMlimpa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADMlimpa1MouseClicked(evt);
            }
        });
        ADMlimpa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMlimpa1ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("SOLICITAÇÃO DE VEÍCULO");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Anexo I do decreto n° 0460, de 15 de abril 2005");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel20)
                        .addGap(119, 119, 119)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ADMlimpa1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ADMperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 641, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ADMdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ADMusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ADMlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel23, jLabel24, jLabel25});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ADMlogin, ADMusuario});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ADMusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ADMdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ADMlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADMperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(ADMlimpa1))
                        .addGap(28, 28, 28)))
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        aba.addTab("Administração", jPanel1);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/primeiro/logoitaprnt.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("PREFEITURA MUNICIPAL DE ITABIRA");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("SOLICITAÇÃO DE VEÍCULO");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Anexo I do decreto n° 0460, de 15 de abril 2005");

        jLabel31.setText("Departamento:");

        TRdepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRdepartamentoActionPerformed(evt);
            }
        });

        jLabel32.setText("Local de Saída:");

        TRlocalsaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRlocalsaidaActionPerformed(evt);
            }
        });

        jLabel33.setText("Destino:");

        TRdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRdestinoActionPerformed(evt);
            }
        });

        jLabel34.setText("Hora de Saída:");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##:##");
            TRhorasaida = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        TRhorasaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRhorasaidaActionPerformed(evt);
            }
        });

        jLabel35.setText("Previsão de Retorno:");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##:##");
            TRhoraretorno = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        TRhoraretorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRhoraretornoActionPerformed(evt);
            }
        });

        jLabel36.setText("Data da Saída:");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            TRdatasaida = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        TRdatasaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRdatasaidaActionPerformed(evt);
            }
        });

        jLabel37.setText("Justificativa:");

        TRjustificativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRjustificativaActionPerformed(evt);
            }
        });

        jLabel38.setText("Passageiro(s):");

        TRpassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRpassageiroActionPerformed(evt);
            }
        });

        jLabel39.setText("Qnt Passageiros:");

        TRqntusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRqntusuarioActionPerformed(evt);
            }
        });

        jLabel40.setText("Autorizado Por:");

        TRautorizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRautorizadoActionPerformed(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Pedido:"));

        jLabel41.setText("Número do Pedido:");

        TRpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRpedidoActionPerformed(evt);
            }
        });

        BOk1.setText("OK");
        BOk1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BOk1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOk1MouseClicked(evt);
            }
        });
        BOk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOk1ActionPerformed(evt);
            }
        });

        TRNova.setText("NOVA BUSCA");
        TRNova.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TRNovaMouseClicked(evt);
            }
        });
        TRNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRNovaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TRpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TRNova, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BOk1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TRNova)
                    .addComponent(BOk1))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BOk1, TRNova});

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BConfirma1.setText("ATENDER");
        BConfirma1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BConfirma1MouseClicked(evt);
            }
        });
        BConfirma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConfirma1ActionPerformed(evt);
            }
        });

        TRCancela.setForeground(new java.awt.Color(255, 102, 102));
        TRCancela.setText("RECUSAR ATENDIMENTO");
        TRCancela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TRCancelaMouseClicked(evt);
            }
        });
        TRCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TRCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(BConfirma1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BConfirma1)
                    .addComponent(TRCancela))
                .addGap(20, 20, 20))
        );

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel42.setText("Solicitações:");

        jTable5.setModel(tmConsulta2);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmContato2 = jTable5.getSelectionModel();
        lsmContato2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(! e.getValueIsAdjusting()){
                    try{
                        jTTabelaLinhaSelecionada2(jTable5);
                    }catch (SQLException ex){
                    }
                }
            }
        });
        /*sempre que eu clicar em alguma linha da tabela ele 
        vai fazer o que foi selecionado lá no jTTabelaLinhaSelecionada(jTTabela);*/
        jScrollPane5.setViewportView(jTable5);

        TRurgencia.setText("Urgência");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        TRobs2.setColumns(20);
        TRobs2.setRows(5);
        TRobs2.setLineWrap(true);
        jScrollPane7.setViewportView(TRobs2);

        TRatualiza.setText("ATUALIZAR TABELA");
        TRatualiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TRatualizaMouseClicked(evt);
            }
        });
        TRatualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRatualizaActionPerformed(evt);
            }
        });

        jLabel18.setText("Observações:");

        filtro1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novas", "Recentes", "Todas" }));
        filtro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtro1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filtro1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                filtro1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                filtro1MouseReleased(evt);
            }
        });
        filtro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRautorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRlocalsaida, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRdestino, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(TRdatasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(TRjustificativa, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(TRpassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(TRhorasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(TRhoraretorno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TRurgencia)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(TRqntusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TRatualiza)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5))
                .addGap(21, 21, 21))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel21)
                        .addGap(118, 118, 118)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(filtro1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel32, jLabel34, jLabel36, jLabel37, jLabel38, jLabel40});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TRautorizado, TRlocalsaida});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TRhoraretorno, TRhorasaida});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TRjustificativa, TRpassageiro});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel18, jLabel31, jLabel33});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TRdepartamento, TRdestino});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TRdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRautorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRlocalsaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(TRurgencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TRqntusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TRhorasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TRhoraretorno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TRdatasaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TRjustificativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TRpassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TRatualiza))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel18, jLabel33});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        aba.addTab("Transporte", jPanel2);

        jMenuBar2.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar2.setToolTipText("Transporte - SMS");

        historico.setBackground(new java.awt.Color(153, 153, 153));
        historico.setText("Histórico");
        historico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historicoMouseClicked(evt);
            }
        });
        jMenuBar2.add(historico);

        JSobre1.setBackground(new java.awt.Color(153, 153, 153));
        JSobre1.setText("Sobre");
        JSobre1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JSobre1MouseClicked(evt);
            }
        });
        JSobre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSobre1ActionPerformed(evt);
            }
        });
        jMenuBar2.add(JSobre1);

        JSobre2.setBackground(new java.awt.Color(153, 153, 153));
        JSobre2.setText("Senha");
        JSobre2.setToolTipText("Alterar senha");
        JSobre2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JSobre2MouseClicked(evt);
            }
        });
        JSobre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSobre2ActionPerformed(evt);
            }
        });
        jMenuBar2.add(JSobre2);

        JSair1.setBackground(new java.awt.Color(153, 153, 153));
        JSair1.setText("Sair");
        JSair1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JSair1MouseClicked(evt);
            }
        });
        jMenuBar2.add(JSair1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aba, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aba, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JSobreMouseClicked
        new JFSobre().show();
    }//GEN-LAST:event_JSobreMouseClicked

    private void JSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSobreActionPerformed

    }//GEN-LAST:event_JSobreActionPerformed

    private void JSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JSairMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_JSairMouseClicked

    private void JSobre1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JSobre1MouseClicked
        new JFSobre().show();
    }//GEN-LAST:event_JSobre1MouseClicked

    private void JSobre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSobre1ActionPerformed

    }//GEN-LAST:event_JSobre1ActionPerformed

    private void JSair1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JSair1MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_JSair1MouseClicked

    private void departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departamentoActionPerformed

    }//GEN-LAST:event_departamentoActionPerformed

    private void localsaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localsaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localsaidaActionPerformed

    private void destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoActionPerformed

    private void horasaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasaidaActionPerformed

    private void horaretornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaretornoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaretornoActionPerformed

    private void datasaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datasaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datasaidaActionPerformed

    private void justificativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_justificativaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_justificativaActionPerformed

    private void passageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passageiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passageiroActionPerformed

    private void qntusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qntusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qntusuarioActionPerformed

    private void autorizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorizadoActionPerformed
        ;
    }//GEN-LAST:event_autorizadoActionPerformed

    private void pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidoActionPerformed

    private void BOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BOkActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BAlterarActionPerformed

    private void BConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConfirmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BConfirmaActionPerformed

    private void BLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLimparActionPerformed

        horasaida.setText("");
        destino.setText("");
        horaretorno.setText("");
        justificativa.setText("");
        passageiro.setText("");
        datasaida.setText("");
        pedido.setText("");
        qntusuario.setText("");
    }//GEN-LAST:event_BLimparActionPerformed

    private void BNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNovoActionPerformed

    }//GEN-LAST:event_BNovoActionPerformed

    private void ADMusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMusuarioActionPerformed

    private void ADMdepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMdepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMdepartamentoActionPerformed

    private void ADMloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMloginActionPerformed

    private void ADMlimpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMlimpaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMlimpaActionPerformed

    private void ADMsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMsalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMsalvarActionPerformed

    private void TRdepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRdepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRdepartamentoActionPerformed

    private void TRlocalsaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRlocalsaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRlocalsaidaActionPerformed

    private void TRdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRdestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRdestinoActionPerformed

    private void TRhorasaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRhorasaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRhorasaidaActionPerformed

    private void TRhoraretornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRhoraretornoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRhoraretornoActionPerformed

    private void TRdatasaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRdatasaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRdatasaidaActionPerformed

    private void TRjustificativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRjustificativaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRjustificativaActionPerformed

    private void TRpassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRpassageiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRpassageiroActionPerformed

    private void TRqntusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRqntusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRqntusuarioActionPerformed

    private void TRautorizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRautorizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRautorizadoActionPerformed

    private void TRpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRpedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRpedidoActionPerformed

    private void BOk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOk1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BOk1ActionPerformed

    private void BConfirma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConfirma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BConfirma1ActionPerformed

    private void TRCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRCancelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRCancelaActionPerformed

    private void historicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historicoMouseClicked
        if (log_perfil==2||log_perfil==3){
        
        try {
            new Histórico().show();
        } catch (SQLException ex) {
        }
        
        }
        else if(log_perfil==1){
            JOptionPane.showMessageDialog(null, "Acesso negado");
               
        }
        
    }//GEN-LAST:event_historicoMouseClicked

    @SuppressWarnings("empty-statement")
    private void BConfirmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BConfirmaMouseClicked
if(conc==1){
         if (concluir == 0) {
             NovoPedido();
         } else {
             EditaPedido();
         }
}


else {JOptionPane.showMessageDialog(null, "Pedido ja existente!");}

try {
            minhaLista = getLista();
            mostraPesquisa(minhaLista);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
        autorizado.setText(aut);
        departamento.setText(dep);

    }//GEN-LAST:event_BConfirmaMouseClicked

    private void abaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abaMouseClicked
        //PERFIL USUARIO
        if (log_perfil == 1) {
            if (aba.getSelectedIndex() == 0) {

            }
            if (aba.getSelectedIndex() == 1) {
                aba.setSelectedIndex(0);
            }
            if (aba.getSelectedIndex() == 2) {

                aba.setSelectedIndex(0);
            }
        }
        //PERFIL TRANSPORTE
        if (log_perfil == 2) {
            if (aba.getSelectedIndex() == 0) {

            }
            if (aba.getSelectedIndex() == 1) {
                aba.setSelectedIndex(0);
            }
            if (aba.getSelectedIndex() == 2) {

            }
        }
        //PERFIL ADMINISTRADOR
        if (log_perfil == 3) {
            if (aba.getSelectedIndex() == 0) {

            }
            if (aba.getSelectedIndex() == 1) {

            }
            if (aba.getSelectedIndex() == 2) {

            }
        }
    }//GEN-LAST:event_abaMouseClicked

    private void ADMsalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMsalvarMouseClicked
         
        if(usu==1){
            
        if(log_perfil==3){
        if ((Long.valueOf(ADMperfil.getText())) < 0 || (Long.valueOf(ADMperfil.getText())) > 3) {
            JOptionPane.showMessageDialog(null, "Perfil incorreto!");
        } else {

            try {

                Compara();
            } catch (SQLException ex) {
                Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (verifica == 0) {
                Usuario u1 = new Usuario();
                u1.setNome_usuario(ADMusuario.getText());
                u1.setId_departamento(ADMdepartamento.getText());
                u1.setId_autorizado(ADMdepartamento.getText());
                u1.setLogin(ADMlogin.getText());
                u1.setTipo(Long.valueOf(ADMperfil.getText()));
                u1.setSenha("123456");

                try {
                    cria(u1);
                } catch (SQLException ex) {
                }

                ADMusuario.setEditable(false);
                ADMdepartamento.setEditable(false);
                ADMlogin.setEditable(false);
                ADMperfil.setEditable(false);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario ja existente!");
            }
        }}
          else {JOptionPane.showMessageDialog(null, "Perfil incorreto");}}
        
        
        
        else if(usu==0){
            
            if(log_perfil==3){
        if ((Long.valueOf(ADMperfil.getText())) < 0 || (Long.valueOf(ADMperfil.getText())) > 3) {
            JOptionPane.showMessageDialog(null, "Perfil incorreto!");
        } else {

            try {

                Compara();
            } catch (SQLException ex) {
                Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (verifica == 1) {
                Usuario u1 = new Usuario();
                u1.setId_departamento(ADMdepartamento.getText());
                u1.setId_autorizado(ADMdepartamento.getText());
                u1.setNome_usuario(ADMusuario.getText());
                u1.setTipo(Long.valueOf(ADMperfil.getText()));
                

                try {
                    edita(u1);
                } catch (SQLException ex) {
                }

                ADMusuario.setEditable(false);
                ADMdepartamento.setEditable(false);
                ADMlogin.setEditable(false);
                ADMperfil.setEditable(false);

            } 
        }}
          else {JOptionPane.showMessageDialog(null, "Perfil incorreto");}}
            
            
        
    }//GEN-LAST:event_ADMsalvarMouseClicked

    private void BNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BNovoMouseClicked
        conc=1;
        concluir = 0;

        localsaida.setEditable(true);
        destino.setEditable(true);
        horasaida.setEditable(true);
        horaretorno.setEditable(true);
        datasaida.setEditable(true);
        justificativa.setEditable(true);
        passageiro.setEditable(true);
        pedido.setEditable(true);
        qntusuario.setEditable(true);
        obs2.setEditable(true);
        obs2.setEnabled(true);
        departamento.setEditable(false);
        autorizado.setEditable(false);

        autorizado.setText(aut);
        departamento.setText(dep);

        localsaida.setText("");
        horasaida.setText("");
        destino.setText("");
        horaretorno.setText("");
        justificativa.setText("");
        passageiro.setText("");
        datasaida.setText("");
        pedido.setText("");
        qntusuario.setText("");
        obs2.setText("");

    }//GEN-LAST:event_BNovoMouseClicked

    private void BLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BLimparMouseClicked
        localsaida.setText("");

        horasaida.setText("");
        destino.setText("");
        horaretorno.setText("");
        justificativa.setText("");
        passageiro.setText("");
        datasaida.setText("");
        pedido.setText("");
        qntusuario.setText("");
        obs2.setText("");

        localsaida.setEditable(true);
        destino.setEditable(true);
        horasaida.setEditable(true);
        horaretorno.setEditable(true);
        datasaida.setEditable(true);
        pedido.setEditable(true);
        justificativa.setEditable(true);
        passageiro.setEditable(true);
        qntusuario.setEditable(true);
        obs2.setEditable(true);
        obs2.setEnabled(true);
    }//GEN-LAST:event_BLimparMouseClicked

    private void ADMnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMnovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMnovoActionPerformed

    private void ADMnovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMnovoMouseClicked
        usu=1;
        ADMusuario.setText("");
        ADMdepartamento.setText("");
        ADMlogin.setText("");
        ADMperfil.setText("");

        ADMusuario.setEditable(true);
        ADMdepartamento.setEditable(true);
        ADMlogin.setEditable(true);
        ADMperfil.setEditable(true);
    }//GEN-LAST:event_ADMnovoMouseClicked

    private void ADMexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMexcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMexcluirActionPerformed

    private void ADMexcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMexcluirMouseClicked
        if(log_perfil==3){
        int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este usuário?", "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {

            ADMusuario.setText("");
            ADMdepartamento.setText("");
            ADMlogin.setText("");
        } else {
        }}
        
        else{}
        
    }//GEN-LAST:event_ADMexcluirMouseClicked

    private void BCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCancelarMouseClicked
        log_pedido = pedido.getText();
        int resp = JOptionPane.showConfirmDialog(null, "Deseja cancelar o pedido?", "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {

            try {
                cancelapedido1(log_pedido);
            } catch (SQLException ex) {
                Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Pedido cancelado com sucesso");

        } else {

            JOptionPane.showMessageDialog(null, "Operação cancelada!");

        }
    }//GEN-LAST:event_BCancelarMouseClicked

    private void ADMlimpaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMlimpaMouseClicked
        if(log_perfil==3){
        
        int resp = JOptionPane.showConfirmDialog(null, "Deseja resetar a senha?", "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
        String senha1;
        String senha2;

        
        senha1="123456";
        senha2="123456";

                try {
                    limpasenha(senha1);
                } catch (SQLException ex) {
                    Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                }

            JOptionPane.showMessageDialog(null, "Senha resetada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Acesso negado!");
        }
    }//GEN-LAST:event_ADMlimpaMouseClicked

    private void TRCancelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TRCancelaMouseClicked
        log_pedido = TRpedido.getText();

        if (log_perfil != 2) {
            JOptionPane.showMessageDialog(null, "Você não possui autoridade!");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "Deseja cancelar o atendimento?", "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {

                try {
                    cancelapedido(log_pedido);
                } catch (SQLException ex) {
                    Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Atendimento cancelado com sucesso");

            } else {

                JOptionPane.showMessageDialog(null, "Operação cancelada!");

            }
        }
        //ATUALIZANDO
        if(log_perfil==2||log_perfil==3){
        try {
            minhaLista2 = getLista2();
            mostraPesquisa2(minhaLista2);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       else{}
       
        
        
    }//GEN-LAST:event_TRCancelaMouseClicked

    private void ADMperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMperfilActionPerformed

    private void atualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atualizaActionPerformed

    private void TRatualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRatualizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRatualizaActionPerformed

    private void TRatualizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TRatualizaMouseClicked
       if(log_perfil==2||log_perfil==3){
        try {
            minhaLista2 = getLista2();
            mostraPesquisa2(minhaLista2);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       else{}
       
    }//GEN-LAST:event_TRatualizaMouseClicked

    private void atualizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizaMouseClicked
        try {
            minhaLista = getLista();
            mostraPesquisa(minhaLista);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
        autorizado.setText(aut);
        departamento.setText(dep);
        // TODO add your handling code here:
    }//GEN-LAST:event_atualizaMouseClicked

    private void BAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BAlterarMouseClicked
        conc=1;
        concluir = 1;

        localsaida.setEditable(true);
        destino.setEditable(true);
        horasaida.setEditable(true);
        horaretorno.setEditable(true);
        datasaida.setEditable(true);
        justificativa.setEditable(true);
        passageiro.setEditable(true);
        qntusuario.setEditable(true);
        obs2.setEditable(true);
        obs2.setEnabled(true);
        departamento.setEditable(false);
        autorizado.setEditable(false);
    }//GEN-LAST:event_BAlterarMouseClicked

    private void BOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOkMouseClicked
        conc=0;
        try {
            BuscaPedido();
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }

        departamento.setEditable(false);
        localsaida.setEditable(false);
        datasaida.setEditable(false);
        horasaida.setEditable(false);
        destino.setEditable(false);
        pedido.setEditable(false);
        horaretorno.setEditable(false);
        obs2.setEditable(false);
        obs2.setEnabled(false);
        justificativa.setEditable(false);
        passageiro.setEditable(false);
        qntusuario.setEditable(false);
        autorizado.setEditable(false);
    }//GEN-LAST:event_BOkMouseClicked

    private void BOk1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOk1MouseClicked
        try {
            TRBuscaPedido();
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }

        TRdepartamento.setEditable(false);
        TRlocalsaida.setEditable(false);
        TRdatasaida.setEditable(false);
        TRhorasaida.setEditable(false);
        TRdestino.setEditable(false);
        TRpedido.setEditable(false);
        TRhoraretorno.setEditable(false);
        TRobs2.setEditable(false);
        TRobs2.setEnabled(false);
        TRjustificativa.setEditable(false);
        TRpassageiro.setEditable(false);
        TRqntusuario.setEditable(false);
        TRautorizado.setEditable(false);


    }//GEN-LAST:event_BOk1MouseClicked

    private void TRNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRNovaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRNovaActionPerformed

    private void TRNovaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TRNovaMouseClicked
        TRlocalsaida.setText("");

        TRhorasaida.setText("");
        TRdestino.setText("");
        TRhoraretorno.setText("");
        TRjustificativa.setText("");
        TRpassageiro.setText("");
        TRdatasaida.setText("");
        TRpedido.setText("");
        TRqntusuario.setText("");
        TRobs2.setText("");

        TRpedido.setEditable(true);
        TRpedido.setText("");
        
        
    }//GEN-LAST:event_TRNovaMouseClicked

    private void JSobre2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JSobre2MouseClicked

        String senha1;
        String senha2;

        JPasswordField password1 = new JPasswordField(15);
        password1.setEchoChar('☻');
        JLabel rotuloU = new JLabel("Nova senha:");
        JPasswordField password2 = new JPasswordField(15);
        password2.setEchoChar('☻');
        JLabel rotulo = new JLabel("Confirmar nova senha:");
        JPanel entUsuario = new JPanel();
        entUsuario.add(rotuloU);
        entUsuario.add(password2);
        entUsuario.add(rotulo);
        entUsuario.add(password1);
        JOptionPane.showMessageDialog(null, entUsuario, "Alterar senha", JOptionPane.PLAIN_MESSAGE);
        senha1 = password1.getText();
        senha2 = password2.getText();

        if (senha1 == null || senha1.equals("") || senha2 == null || senha2.equals("")) {
            JOptionPane.showMessageDialog(null, "As senhas nao coincidem! ");
        } else {
            if (senha1.equals(senha2)) {

                try {
                    trocasenha(senha1);
                } catch (SQLException ex) {
                    Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                JOptionPane.showMessageDialog(null, "As senhas nao coincidem!");
            }
        }
    }//GEN-LAST:event_JSobre2MouseClicked

    private void JSobre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSobre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JSobre2ActionPerformed

    private void abaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abaMouseEntered
        //PERFIL USUARIO
        if (log_perfil == 1) {
            if (aba.getSelectedIndex() == 0) {

            }
            if (aba.getSelectedIndex() == 1) {
                aba.setSelectedIndex(0);
            }
            if (aba.getSelectedIndex() == 2) {

                aba.setSelectedIndex(0);
            }
        }
        //PERFIL TRANSPORTE
        if (log_perfil == 2) {
            if (aba.getSelectedIndex() == 0) {

            }
            if (aba.getSelectedIndex() == 1) {
                aba.setSelectedIndex(0);
            }
            if (aba.getSelectedIndex() == 2) {

            }
        }
        //PERFIL ADMINISTRADOR
        if (log_perfil == 3) {
            if (aba.getSelectedIndex() == 0) {

            }
            if (aba.getSelectedIndex() == 1) {

            }
            if (aba.getSelectedIndex() == 2) {
            }
        }
    }//GEN-LAST:event_abaMouseEntered

    private void BConfirma1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BConfirma1MouseClicked

        log_pedido = TRpedido.getText();
        if (log_perfil != 2) {
            JOptionPane.showMessageDialog(null, "Você não possui autoridade!");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "Atender pedido de imediato?", "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {

                
                //ATUALIZANDOO 
                if(log_perfil==2||log_perfil==3){
        try {
            minhaLista2 = getLista2();
            mostraPesquisa2(minhaLista2);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
                
                
       
       else{}
       
                
                try {
                    atendepedido(log_pedido);
                } catch (SQLException ex) {
                    Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Atendimento confirmado com sucesso");

            } else {
                String espera = null;
                espera = JOptionPane.showInputDialog("Qual o tempo de espera?");
                if (espera == null || espera.equals("")) {
                    JOptionPane.showMessageDialog(null, "Voce nao inseriu o tempo de espera");
                }

                if (espera != null) {
                    log_espera = espera;
                    try {
                        esperapedido(log_pedido, log_espera);
                    } catch (SQLException ex) {
                        Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                
                //ATUALIZANDOO
                if(log_perfil==2||log_perfil==3){
        try {
            minhaLista2 = getLista2();
            mostraPesquisa2(minhaLista2);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       else{}
       

            }
        }
    }//GEN-LAST:event_BConfirma1MouseClicked

    private void NovaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovaMouseClicked
        localsaida.setText("");

        horasaida.setText("");
        destino.setText("");
        horaretorno.setText("");
        justificativa.setText("");
        passageiro.setText("");
        datasaida.setText("");
        pedido.setText("");
        qntusuario.setText("");
        obs2.setText("");

        pedido.setEditable(true);
        pedido.setText("");
    }//GEN-LAST:event_NovaMouseClicked

    private void NovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NovaActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         
            new Departamentos().show();
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void ADMalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMalterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMalterarActionPerformed

    private void ADMalterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMalterarMouseClicked
        usu=0;
        ADMusuario.setEditable(true);
        ADMdepartamento.setEditable(true);
        ADMperfil.setEditable(true);
    }//GEN-LAST:event_ADMalterarMouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        conc=0;
    }//GEN-LAST:event_jTable6MouseClicked

    private void ADMlimpa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMlimpa1MouseClicked
        
        if(log_perfil==3)
        {try {
            minhaLista3 = getLista3();
            mostraPesquisa3(minhaLista3);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{}
    }//GEN-LAST:event_ADMlimpa1MouseClicked

    private void ADMlimpa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMlimpa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADMlimpa1ActionPerformed

    private void horasaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horasaidaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_horasaidaMouseClicked

    private void filtro1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtro1MouseEntered
        
    }//GEN-LAST:event_filtro1MouseEntered

    private void filtro1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtro1MousePressed
        
    }//GEN-LAST:event_filtro1MousePressed

    private void filtro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtro1MouseClicked
        
    }//GEN-LAST:event_filtro1MouseClicked

    private void filtro1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtro1MouseReleased
        
    }//GEN-LAST:event_filtro1MouseReleased

    private void filtro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtro1ActionPerformed
        TRatualizaMouseClicked(null);
    }//GEN-LAST:event_filtro1ActionPerformed

    // EXIBIR A PESQUISA 
    public void mostraPesquisa(List<Pedido> consult) throws SQLException {

        jTable6.setSelectionMode(0);

        while (tmConsulta1.getRowCount() > 0) {
            tmConsulta1.removeRow(0);
        }

        if (consult.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null, null};

            for (int i = 0; i < consult.size(); i++) {
                List<consulta2> consultaDois;
                tmConsulta1.addRow(linha);

                consultaDois = transformaID1(Long.valueOf(consult.get(i).getDepartamento()));
                for (int j = 0; j < consultaDois.size(); j++) {
                    tmConsulta1.setValueAt(consultaDois.get(j).getNome(), i, 0);
                }

                consultaDois = transformaID3(Long.valueOf(consult.get(i).getUsuario()));
                for (int j = 0; j < consultaDois.size(); j++) {
                    tmConsulta1.setValueAt(consultaDois.get(j).getNome(), i, 1);
                }

                tmConsulta1.setValueAt(consult.get(i).getLocalsaida(), i, 2);
                tmConsulta1.setValueAt(consult.get(i).getDatasaida(), i, 3);
                tmConsulta1.setValueAt(consult.get(i).getHorasaida(), i, 4);
                tmConsulta1.setValueAt(consult.get(i).getTempo_espera(), i, 5);
                tmConsulta1.setValueAt(consult.get(i).getSituacao(), i, 6);
                tmConsulta1.setValueAt(consult.get(i).getPedido(), i, 7);
            }
        }
    }
     // EXIBIR PESQUISA TRANSPORTE <<<

    public void mostraPesquisa2(List<Pedido> consult) throws SQLException {

        jTable5.setSelectionMode(0);

        while (tmConsulta2.getRowCount() > 0) {
            tmConsulta2.removeRow(0);
        }

        if (consult.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null, null};

            for (int i = 0; i < consult.size(); i++) {
                List<consulta2> consultaDois3;

                tmConsulta2.addRow(linha);

                consultaDois3 = transformaID1(Long.valueOf(consult.get(i).getDepartamento()));
                for (int j = 0; j < consultaDois3.size(); j++) {
                    tmConsulta2.setValueAt(consultaDois3.get(j).getNome(), i, 0);
                }

                consultaDois3 = transformaID3(Long.valueOf(consult.get(i).getUsuario()));
                for (int j = 0; j < consultaDois3.size(); j++) {
                    tmConsulta2.setValueAt(consultaDois3.get(j).getNome(), i, 1);
                }

                tmConsulta2.setValueAt(consult.get(i).getLocalsaida(), i, 2);
                tmConsulta2.setValueAt(consult.get(i).getDatasaida(), i, 3);
                tmConsulta2.setValueAt(consult.get(i).getHorasaida(), i, 4);
                tmConsulta2.setValueAt(consult.get(i).getTempo_espera(), i, 5);
                tmConsulta2.setValueAt(consult.get(i).getSituacao(), i, 6);
                tmConsulta2.setValueAt(consult.get(i).getPedido(), i, 7);

            }
        }
    }
     // EXIBIR LISTA DO USUARIO AQUI <<

    public void mostraPesquisa3(List<Usuario> consult) throws SQLException {

        jTable4.setSelectionMode(0);

        while (tmConsulta3.getRowCount() > 0) {
            tmConsulta3.removeRow(0);
        }

        if (consult.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        } else {
            String[] linha = new String[]{null, null, null};

            for (int i = 0; i < consult.size(); i++) {
                List<consulta2> consultaDoisADM;

                tmConsulta3.addRow(linha);

                consultaDoisADM = transformaID3(Long.valueOf(consult.get(i).getId_usuario()));
                for (int j = 0; j < consultaDoisADM.size(); j++) {
                    tmConsulta3.setValueAt(consultaDoisADM.get(j).getNome(), i, 1);
                }

                consultaDoisADM = transformaID1(Long.valueOf(consult.get(i).getId_departamento()));
                for (int j = 0; j < consultaDoisADM.size(); j++) {
                    tmConsulta3.setValueAt(consultaDoisADM.get(j).getNome(), i, 0);
                }

                tmConsulta3.setValueAt(consult.get(i).getLogin(), i, 2);

            }
        }
    }
    // TRANSFORMANDO ID'S EM STRINGS <<

    public List<consulta2> transformaID1(Long ID) throws SQLException {
        String sql2 = "select nome_departamento from departamento where id_departamento =" + ID;
        PreparedStatement stmt2 = conexao.prepareStatement(sql2);
        ResultSet rs = stmt2.executeQuery();
        List<consulta2> minhaLista = new ArrayList<consulta2>();

        while (rs.next()) {
            consulta2 c2 = new consulta2();
            c2.setNome(rs.getString("nome_departamento"));
            dep = c2.getNome();
            minhaLista.add(c2);
        }
        rs.close();
        stmt2.close();
        return minhaLista;

    }

    public List<consulta2> transformaID2(Long ID) throws SQLException {
        String sql2 = "select nome_autorizado from autorizado where id_autorizado =" + ID;
        PreparedStatement stmt2 = conexao.prepareStatement(sql2);
        ResultSet rs = stmt2.executeQuery();
        List<consulta2> minhaLista = new ArrayList<consulta2>();

        while (rs.next()) {
            consulta2 c2 = new consulta2();
            c2.setNome(rs.getString("nome_autorizado"));
            aut = c2.getNome();
            minhaLista.add(c2);
        }
        rs.close();
        stmt2.close();
        return minhaLista;

    }

    public List<consulta2> transformaID3(Long ID) throws SQLException {
        String sql2 = "select nome_usuario from usuario where id_usuario =" + ID;
        PreparedStatement stmt2 = conexao.prepareStatement(sql2);
        ResultSet rs = stmt2.executeQuery();
        List<consulta2> minhaLista = new ArrayList<consulta2>();

        while (rs.next()) {
            consulta2 c2 = new consulta2();
            c2.setNome(rs.getString("nome_usuario"));
            minhaLista.add(c2);
        }
        rs.close();
        stmt2.close();
        return minhaLista;

    }

     // SELECIONA LINHA DA TABELA <<<<<<<<<<<<<<
    private void jTTabelaLinhaSelecionada(JTable jTable6) throws SQLException {
        List<consulta2> consultaDois2 = null;
        if (jTable6.getSelectedRow() != -1) {
            departamento.setEditable(false);
            localsaida.setEditable(false);
            datasaida.setEditable(false);
            horasaida.setEditable(false);

            destino.setEditable(false);
            pedido.setEditable(false);
            horaretorno.setEditable(false);
            obs2.setEditable(false);
            obs2.setEnabled(false);
            justificativa.setEditable(false);
            passageiro.setEditable(false);
            qntusuario.setEditable(false);
            autorizado.setEditable(false);

            consultaDois2 = transformaID2(Long.valueOf(minhaLista.get(jTable6.getSelectedRow()).getAutorizado()));
            for (int j = 0; j < consultaDois2.size(); j++) {
                autorizado.setText(consultaDois2.get(j).getNome());
            }

            consultaDois2 = transformaID1(Long.valueOf(minhaLista.get(jTable6.getSelectedRow()).getDepartamento()));
            for (int j = 0; j < consultaDois2.size(); j++) {
                departamento.setText(consultaDois2.get(j).getNome());
            }

            localsaida.setText(minhaLista.get(jTable6.getSelectedRow()).getLocalsaida());
            destino.setText(minhaLista.get(jTable6.getSelectedRow()).getDestino());
            horasaida.setText(minhaLista.get(jTable6.getSelectedRow()).getHorasaida());
            horaretorno.setText(minhaLista.get(jTable6.getSelectedRow()).getHoraretorno());
            datasaida.setText(minhaLista.get(jTable6.getSelectedRow()).getDatasaida());
            justificativa.setText(minhaLista.get(jTable6.getSelectedRow()).getJustificativa());
            passageiro.setText(minhaLista.get(jTable6.getSelectedRow()).getPassageiro());
            qntusuario.setText(minhaLista.get(jTable6.getSelectedRow()).getQntusuario());
            pedido.setText(String.valueOf(minhaLista.get(jTable6.getSelectedRow()).getPedido()));
            obs2.setText(minhaLista.get(jTable6.getSelectedRow()).getObs2());

            if (minhaLista.get(jTable6.getSelectedRow()).getUrgencia() == 0) {
                checkurgencia.setSelected(false);
            } else {
                checkurgencia.setSelected(true);
            }

        } else {
            localsaida.setText("");
            departamento.setText("");
            autorizado.setText("");
            horasaida.setText("");
            destino.setText("");
            horaretorno.setText("");
            justificativa.setText("");
            passageiro.setText("");
            datasaida.setText("");
            pedido.setText("");
            qntusuario.setText("");
            obs2.setText("");

        }
    }

    // SELECIONA LINHA TABELA TRANSPORTE <<<<<<<
    private void jTTabelaLinhaSelecionada2(JTable jTable5) throws SQLException {
        List<consulta2> consultaDois3 = null;
        if (jTable5.getSelectedRow() != -1) {
            TRdepartamento.setEditable(false);
            TRlocalsaida.setEditable(false);
            TRdatasaida.setEditable(false);
            TRhorasaida.setEditable(false);

            TRdestino.setEditable(false);
            TRpedido.setEditable(false);
            TRhoraretorno.setEditable(false);
            TRobs2.setEditable(false);
            TRobs2.setEnabled(false);
            TRjustificativa.setEditable(false);
            TRpassageiro.setEditable(false);
            TRqntusuario.setEditable(false);
            TRautorizado.setEditable(false);

            consultaDois3 = transformaID2(Long.valueOf(minhaLista2.get(jTable5.getSelectedRow()).getAutorizado()));
            for (int j = 0; j < consultaDois3.size(); j++) {
                TRautorizado.setText(consultaDois3.get(j).getNome());
            }

            consultaDois3 = transformaID1(Long.valueOf(minhaLista2.get(jTable5.getSelectedRow()).getDepartamento()));
            for (int j = 0; j < consultaDois3.size(); j++) {
                TRdepartamento.setText(consultaDois3.get(j).getNome());
            }

            TRlocalsaida.setText(minhaLista2.get(jTable5.getSelectedRow()).getLocalsaida());
            TRdestino.setText(minhaLista2.get(jTable5.getSelectedRow()).getDestino());
            TRhorasaida.setText(minhaLista2.get(jTable5.getSelectedRow()).getHorasaida());
            TRhoraretorno.setText(minhaLista2.get(jTable5.getSelectedRow()).getHoraretorno());
            TRdatasaida.setText(minhaLista2.get(jTable5.getSelectedRow()).getDatasaida());
            TRjustificativa.setText(minhaLista2.get(jTable5.getSelectedRow()).getJustificativa());
            TRpassageiro.setText(minhaLista2.get(jTable5.getSelectedRow()).getPassageiro());
            TRqntusuario.setText(minhaLista2.get(jTable5.getSelectedRow()).getQntusuario());
            TRpedido.setText(String.valueOf(minhaLista2.get(jTable5.getSelectedRow()).getPedido()));
            TRobs2.setText(minhaLista2.get(jTable5.getSelectedRow()).getObs2());

            if (minhaLista2.get(jTable5.getSelectedRow()).getUrgencia() == 0) {
                TRurgencia.setSelected(false);
            } else {
                TRurgencia.setSelected(true);
            }

        } else {
            TRlocalsaida.setText("");
            TRdepartamento.setText("");
            TRautorizado.setText("");
            TRhorasaida.setText("");
            TRdestino.setText("");
            TRhoraretorno.setText("");
            TRjustificativa.setText("");
            TRpassageiro.setText("");
            TRdatasaida.setText("");
            TRpedido.setText("");
            TRqntusuario.setText("");
            TRobs2.setText("");

        }
    }

    // SELECIONA LINHA USUARIO
    private void jTTabelaLinhaSelecionada3(JTable jTable4) throws SQLException {
        List<consulta2> consultaDoisADM = null;
        if (jTable4.getSelectedRow() != -1) {

            ADMusuario.setEditable(false);
            ADMdepartamento.setEditable(false);
            ADMlogin.setEditable(false);
            ADMperfil.setEditable(false);

            consultaDoisADM = transformaID3(Long.valueOf(minhaLista3.get(jTable4.getSelectedRow()).getId_usuario()));
            for (int j = 0; j < consultaDoisADM.size(); j++) {
                ADMusuario.setText(consultaDoisADM.get(j).getNome());
            }

            consultaDoisADM = transformaID1(Long.valueOf(minhaLista3.get(jTable4.getSelectedRow()).getId_departamento()));
            for (int j = 0; j < consultaDoisADM.size(); j++) {
                ADMdepartamento.setText(consultaDoisADM.get(j).getNome());
            }

            ADMlogin.setText(minhaLista3.get(jTable4.getSelectedRow()).getLogin());
            ADMperfil.setText(String.valueOf(minhaLista3.get(jTable4.getSelectedRow()).getTipo()));

        } else {
            ADMusuario.setText("");
            ADMdepartamento.setText("");
            ADMlogin.setText("");
            ADMperfil.setText("");

        }
    }

    // GET LIST PEDIDO <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public List<Pedido> getLista() throws SQLException {
        List<consulta2> consulta3;

        String sql = "select * from Pedido where id_autorizado=" + log_autorizado + " ORDER BY datasaida DESC,horasaida DESC";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Pedido> minhaLista = new ArrayList<Pedido>();
        while (rs.next()) {
            Pedido c1 = new Pedido();
            c1.setDepartamento(rs.getString("id_departamento"));
            c1.setAutorizado(rs.getString("id_autorizado"));
            c1.setLocalsaida(rs.getString("localsaida"));
            c1.setHorasaida(rs.getString("horasaida"));
            c1.setDatasaida(rs.getString("datasaida"));
            c1.setDestino(rs.getString("destino"));
            c1.setObs2(rs.getString("obs2"));
            c1.setHoraretorno(rs.getString("horaretorno"));
            c1.setJustificativa(rs.getString("justificativa"));
            c1.setPassageiro(rs.getString("passageiro"));
            c1.setUsuario(Long.valueOf(rs.getLong("id_usuario")));
            c1.setTempo_espera(rs.getString("tempo_espera"));
            c1.setQntusuario(rs.getString("qntusuario"));
            c1.setSituacao(rs.getString("situacao"));
            c1.setPedido(Long.valueOf(rs.getLong("id_pedido")));
            c1.setUrgencia((rs.getInt("urgencia")));

            String dat = rs.getString("dataSaida");
            String A = retornaA2(dat);
            String M = retornaM2(dat);
            String D = retornaD2(dat);
            String data = D + "/" + M + "/" + A;
            c1.setDatasaida(data);

            minhaLista.add(c1);

        }
        rs.close();
        stmt.close();
        return minhaLista;

    }

    // GET LIST TRANSPORTE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public List<Pedido> getLista2() throws SQLException {
        List<consulta2> consulta3;

        String sql = "";
        if(filtro1.getSelectedIndex() == 0){
            sql = "select * from pedido where ((situacao not like 'cancelado' ) and (situacao not like 'atendido') and (situacao not like 'em espera') and (situacao not like 'recusado')) ORDER BY datasaida DESC,horasaida DESC";
        }
        else if(filtro1.getSelectedIndex() == 1){
            sql = "select * from pedido ORDER BY datasaida DESC,horasaida DESC limit 20";
        }
        else if(filtro1.getSelectedIndex() == 2){
            sql = "select * from Pedido where situacao not like 'cancelado' ORDER BY datasaida DESC,horasaida DESC";
        }

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Pedido> minhaLista2 = new ArrayList<Pedido>();
        while (rs.next()) {
            Pedido d1 = new Pedido();
            d1.setDepartamento(rs.getString("id_departamento"));
            d1.setAutorizado(rs.getString("id_autorizado"));
            d1.setLocalsaida(rs.getString("localsaida"));
            d1.setHorasaida(rs.getString("horasaida"));
            d1.setDatasaida(rs.getString("datasaida"));
            d1.setDestino(rs.getString("destino"));
            d1.setObs2(rs.getString("obs2"));
            d1.setHoraretorno(rs.getString("horaretorno"));
            d1.setJustificativa(rs.getString("justificativa"));
            d1.setPassageiro(rs.getString("passageiro"));
            d1.setUsuario(Long.valueOf(rs.getLong("id_usuario")));
            d1.setTempo_espera(rs.getString("tempo_espera"));
            d1.setSituacao(rs.getString("situacao"));
            d1.setQntusuario(rs.getString("qntusuario"));
            d1.setPedido(Long.valueOf(rs.getLong("id_pedido")));
            d1.setUrgencia((rs.getInt("urgencia")));

            String dat = rs.getString("dataSaida");
            String A = retornaA2(dat);
            String M = retornaM2(dat);
            String D = retornaD2(dat);
            String data = D + "/" + M + "/" + A;
            d1.setDatasaida(data);

            minhaLista2.add(d1);

        }
        rs.close();
        stmt.close();
        return minhaLista2;

    }

    // GET LIST USUARIO <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public List<Usuario> getLista3() throws SQLException {
        List<consulta2> consulta3;

        String sql = "select * from Usuario ORDER BY id_departamento DESC,id_usuario DESC";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Usuario> minhaLista3 = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario a1 = new Usuario();
            a1.setId_departamento(rs.getString("id_departamento"));
            a1.setId_usuario(Long.valueOf(rs.getLong("id_usuario")));
            a1.setId_autorizado(rs.getString("id_autorizado"));
            a1.setLogin(rs.getString("login"));
            a1.setTipo(Long.valueOf(rs.getLong("tipo")));

            minhaLista3.add(a1);

        }
        rs.close();
        stmt.close();
        return minhaLista3;

    }

    // FIM GET LIST
    private void cria(Usuario usu) throws SQLException {
        String sql = "insert into usuario (nome_usuario, login, senha, id_departamento,id_autorizado, tipo) " + "values(?,?,md5(?),?,?,?) ";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, usu.getNome_usuario());
        stmt.setString(2, usu.getLogin());
        stmt.setString(3, usu.getSenha());
        stmt.setString(4, usu.getId_departamento());
        stmt.setString(5, usu.getId_autorizado());

        stmt.setLong(6, usu.getTipo());

        stmt.execute();
        stmt.close();

        JOptionPane.showMessageDialog(null, "Usuario criado com sucesso!");
    }

    
    private void edita(Usuario usu) throws SQLException {
        
        String logs;
        logs = ADMlogin.getText();
        
        String sql = "update usuario set nome_usuario=?, id_departamento=?,id_autorizado=?, tipo=? where login like'" +logs+"'";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, usu.getNome_usuario());
        stmt.setString(2, usu.getId_departamento());
        stmt.setString(3, usu.getId_autorizado());
        stmt.setLong(4, usu.getTipo());
        stmt.execute();
        stmt.close();
        JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso!");
    }
    
    
    
    public int verificaBox() {

        if (checkurgencia.isSelected()) {
            return 1;
        } else {
            return 0;

        }
    }

    public String retornaD(String data) {
        return data.substring(0, 2);
    }

    public String retornaM(String data) {
        return data.substring(3, 5);
    }

    public String retornaA(String data) {
        return data.substring(6, 10);
    }

    public String retornaD2(String data) {
        return data.substring(8, 10);
    }

    public String retornaM2(String data) {
        return data.substring(5, 7);
    }

    public String retornaA2(String data) {
        return data.substring(0, 4);
    }

    // CRIAR NOVO PEDIDO <<<<<<<<<
    public void NovoPedido() {
        Pedido p1 = new Pedido();
        p1.setDepartamento(departamento.getText());
        p1.setLocalsaida(localsaida.getText());
        p1.setDestino(destino.getText());
        p1.setHorasaida(horasaida.getText());
        p1.setHoraretorno(horaretorno.getText());
        p1.setDatasaida(datasaida.getText());
        p1.setJustificativa(justificativa.getText());
        p1.setUrgencia(verificaBox());

        p1.setObs2(obs2.getText());
        p1.setPassageiro(passageiro.getText());
        p1.setAutorizado(autorizado.getText());
        p1.setQntusuario(qntusuario.getText());
        p1.setDataD(retornaD(datasaida.getText()));
        p1.setDataM(retornaM(datasaida.getText()));
        p1.setDataA(retornaA(datasaida.getText()));

        try {
            insere(p1);
        } catch (SQLException ex) {
        }

        localsaida.setEditable(false);
        destino.setEditable(false);
        horasaida.setEditable(false);
        horaretorno.setEditable(false);
        datasaida.setEditable(false);
        justificativa.setEditable(false);
        passageiro.setEditable(false);
        qntusuario.setEditable(false);
        obs2.setEditable(false);
        obs2.setEnabled(false);
        departamento.setEditable(false);
        autorizado.setEditable(false);

    }

    //EDITAR PEDIDO EXISTENTE <<<<<<
    public void EditaPedido() {
        Pedido p1 = new Pedido();
        p1.setDepartamento(departamento.getText());
        p1.setLocalsaida(localsaida.getText());
        p1.setDestino(destino.getText());
        p1.setHorasaida(horasaida.getText());
        p1.setHoraretorno(horaretorno.getText());
        p1.setDatasaida(datasaida.getText());
        p1.setJustificativa(justificativa.getText());
        p1.setUrgencia(verificaBox());
        p1.setObs2(obs2.getText());
        p1.setPassageiro(passageiro.getText());
        p1.setAutorizado(autorizado.getText());
        p1.setQntusuario(qntusuario.getText());
        p1.setDataD(retornaD(datasaida.getText()));
        p1.setDataM(retornaM(datasaida.getText()));
        p1.setDataA(retornaA(datasaida.getText()));
        p1.setPedido(Long.valueOf(pedido.getText()));

        try {
            altera(p1);
        } catch (SQLException ex) {
        }

        localsaida.setEditable(false);
        destino.setEditable(false);
        horasaida.setEditable(false);
        horaretorno.setEditable(false);
        datasaida.setEditable(false);
        justificativa.setEditable(false);
        passageiro.setEditable(false);
        qntusuario.setEditable(false);
        obs2.setEditable(false);
        obs2.setEnabled(false);
        departamento.setEditable(true);
        autorizado.setEditable(true);

    }

    public String getLog_departamento() {

        return log_departamento;
    }

    // CRIA PEDIDO
    public void insere(Pedido ped) throws SQLException {
        String sql = "insert into pedido (id_departamento, id_usuario, id_autorizado, localsaida, destino, horasaida, horaretorno, datasaida, justificativa, urgencia, qntusuario,  obs2, passageiro,situacao,tempo_espera, datahora) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, log_departamento);
        stmt.setLong(2, log_usuario);
        stmt.setString(3, log_autorizado);
        stmt.setString(4, ped.getLocalsaida());
        stmt.setString(5, ped.getDestino());
        stmt.setString(6, ped.getHorasaida());
        stmt.setString(7, ped.getHoraretorno());
        stmt.setString(8, ped.getDataA() + "-" + ped.getDataM() + "-" + ped.getDataD());
        stmt.setString(9, ped.getJustificativa());
        stmt.setInt(10, ped.getUrgencia());
        stmt.setString(11, ped.getQntusuario());
        stmt.setString(12, ped.getObs2());
        stmt.setString(13, ped.getPassageiro());
        stmt.setString(14," ");
        stmt.setString(15," ");

        stmt.execute();

        stmt.close();
        JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");

    }

    // ALTERA PEDIDO
    public void altera(Pedido ped1) throws SQLException {
        String sql = "update pedido set id_departamento=?, id_usuario=?, id_autorizado=?, localsaida=?, destino=?, horasaida=?, horaretorno=?, datasaida=?, justificativa=?, urgencia=?, qntusuario=?, obs2=?, passageiro=? where id_pedido=" + ped1.getPedido();

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, log_departamento);
        stmt.setLong(2, log_usuario);
        stmt.setString(3, log_autorizado);
        stmt.setString(4, ped1.getLocalsaida());
        stmt.setString(5, ped1.getDestino());
        stmt.setString(6, ped1.getHorasaida());
        stmt.setString(7, ped1.getHoraretorno());
        stmt.setString(8, ped1.getDataA() + "-" + ped1.getDataM() + "-" + ped1.getDataD());
        stmt.setString(9, ped1.getJustificativa());
        stmt.setInt(10, ped1.getUrgencia());
        stmt.setString(11, ped1.getQntusuario());
        stmt.setString(12, ped1.getObs2());
        stmt.setString(13, ped1.getPassageiro());

        stmt.execute();

        stmt.close();
        JOptionPane.showMessageDialog(null, "Pedido alterado com sucesso!");

    }

    // TROCA SENHA <<<<<
    public void trocasenha(String senha) throws SQLException {
        String sql = "update usuario set senha=md5(?) where id_usuario=" + log_usuario;
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, senha);

        stmt.execute();
        stmt.close();

        JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
    }
    
    public void limpasenha(String senha) throws SQLException {
        
        String logs;
        logs = ADMlogin.getText();
        
        String sql = "update usuario set senha=md5(?) where login like '" +logs+"'";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, senha);

        stmt.execute();
        stmt.close();

    }
    
    

    //EXCLUI PEDIDO
    public void cancelapedido(String log_pedido) throws SQLException {
        String sql = "update pedido set situacao=? where id_pedido=" + log_pedido;
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, "RECUSADO");

        stmt.execute();
        stmt.close();

    }
    //CANCELA PEDIDO

    public void cancelapedido1(String log_pedido) throws SQLException {
        String sql = "update pedido set situacao=? where id_pedido=" + log_pedido;
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, "CANCELADO");

        stmt.execute();
        stmt.close();

    }

    //ATENDE PEDIDO
    public void atendepedido(String log_pedido) throws SQLException {
        String sql = "update pedido set situacao=?,tempo_espera=?  where id_pedido=" + log_pedido;
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, "ATENDIDO");
        stmt.setString(2, "-");

        stmt.execute();
        stmt.close();

    }

    //PEDIDO COM TEMPO DE ESPERA
    public void esperapedido(String log_pedido, String log_espera) throws SQLException {
        String sql = "update pedido set situacao=?,tempo_espera=?  where id_pedido=" + log_pedido;
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, "EM ESPERA");
        stmt.setString(2, log_espera);

        stmt.execute();
        stmt.close();

    }

    //COMPARANDO LOGINS<<<<<
    public void Compara() throws SQLException {

        String sql = "select * from Usuario where login like '" + ADMlogin.getText() + "'";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.first()) {
            verifica = 1;

        } else {

            verifica = 0;
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // COMPARANDO LOGIN 
    public void transformaID12(String ID) throws SQLException {
        String sql2 = "select nome_departamento from departamento where id_departamento =" + ID;
        PreparedStatement stmt2 = conexao.prepareStatement(sql2);
        ResultSet rs = stmt2.executeQuery();
        List<consulta2> minhaLista = new ArrayList<consulta2>();

        while (rs.next()) {
            consulta2 c2 = new consulta2();
            c2.setNome(rs.getString("nome_departamento"));
            dep = c2.getNome();
        }
        rs.close();
        stmt2.close();

    }

    public void transformaID22(String ID) throws SQLException {
        String sql2 = "select nome_autorizado from autorizado where id_autorizado =" + ID;
        PreparedStatement stmt2 = conexao.prepareStatement(sql2);
        ResultSet rs = stmt2.executeQuery();
        List<consulta2> minhaLista = new ArrayList<consulta2>();

        while (rs.next()) {
            consulta2 c2 = new consulta2();
            c2.setNome(rs.getString("nome_autorizado"));
            aut = c2.getNome();
        }
        rs.close();
        stmt2.close();

    }

       //BUSCA ULTIMO ID AO LOGAR
    public void PegaID() throws SQLException {

        String sql = "select id_pedido from Pedido ORDER BY id_pedido DESC LIMIT 1";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Pedido> minhaLista = new ArrayList<Pedido>();
        Pedido c1 = new Pedido();
        while (rs.next()) {

            c1.setPedido(Long.valueOf(rs.getLong("id_pedido")));

            minhaLista.add(c1);

            ultimo_id = minhaLista.get(0).getPedido();

        }
        rs.close();
        stmt.close();

    }

       // COMPARA O NUMERO DO PEDIDO INICIAL COM O QUE VAI PEGAR AGORA
    public void ComparaID() throws SQLException {

        String sql = "select id_pedido from Pedido ORDER BY id_pedido DESC LIMIT 1";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Pedido> minhaLista = new ArrayList<Pedido>();
        Pedido c1 = new Pedido();
        while (rs.next()) {

            c1.setPedido(Long.valueOf(rs.getLong("id_pedido")));

            minhaLista.add(c1);

            atual_id = minhaLista.get(0).getPedido();
        }
        rs.close();
        stmt.close();
            
        
        System.out.println("atual" + atual_id+"2");
        System.out.println("ultimo" + ultimo_id+"2");
            
        //if (ultimo_id == atual_id){
        if (ultimo_id.equals(atual_id)){
            apitar=0;
            
        } else if(atual_id!=ultimo_id) {
            System.out.println("sioaaois111");
            apitar = 1;
            ultimo_id = atual_id;
            System.out.println("atuali" + atual_id);
            System.out.println("ultimoi" + ultimo_id);
        }
    }

// ALERTA
    public void Alerta() throws MalformedURLException, SQLException {

        ComparaID();
            System.out.println("apitar" + apitar);
        if (apitar == 0) {

            
            
        } else if(apitar==1){

            
            Music musica = new Music();
            musica.music();
            
            JOptionPane.showMessageDialog(null, "NOVO PEDIDO!");
            System.out.println("atual" + atual_id);
            System.out.println("ultimo" + ultimo_id);
            

           
            
 if(log_perfil==2||log_perfil==3){
        try {
            minhaLista2 = getLista2();
            mostraPesquisa2(minhaLista2);
        } catch (SQLException ex) {
            Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       else{}
            

        }

    }

    
    public void criptografa() throws SQLException {
        String sql = "set @senha = md5('"+senha+"')";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        sql = "select @senha";
        stmt = conexao.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        Usuario senha1 = new Usuario();
        while (rs.next()) {            
            
            senha1.setSenha(rs.getString("@senha"));
        }
        senhaCriptografada = senha1.getSenha();
        rs.close();
        stmt.close();
        ComparaLogin();
    }
        
       // FIM ALERTA <<
    public void ComparaLogin() throws SQLException {
        List<Usuario> usuario;
        
        String sql = "select * from Usuario where login like '" + login + "'";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Usuario> minhaLista3 = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario a1 = new Usuario();
            a1.setLogin(rs.getString("login"));
            a1.setSenha(rs.getString("senha"));
            a1.setNome_usuario(rs.getString("nome_usuario"));
            a1.setId_usuario(Long.valueOf(rs.getString("id_usuario")));
            a1.setId_departamento(rs.getString("id_departamento"));
            a1.setId_autorizado(rs.getString("id_autorizado"));
            a1.setTipo(Long.valueOf(rs.getString("tipo")));
            minhaLista3.add(a1);

            log_perfil = minhaLista3.get(0).getTipo();
            log_usuario = minhaLista3.get(0).getId_usuario();
            log_departamento = minhaLista3.get(0).getId_departamento();
            log_autorizado = minhaLista3.get(0).getId_autorizado();

            transformaID22(log_autorizado);
            transformaID12(log_departamento);

        }
        rs.close();
        stmt.close();
        
        
        if (minhaLista3.size() > 0) {
            if (senhaCriptografada.equals(minhaLista3.get(0).getSenha())) {
                verificalogin = 0;

                JOptionPane.showMessageDialog(null, "Bem vindo " + minhaLista3.get(0).getNome_usuario() + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
                verificalogin = 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario não existente!");
            verificalogin = 1;
        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FraSegundo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FraSegundo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FraSegundo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FraSegundo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FraSegundo().setVisible(true);
                    new FraSegundo().setResizable(false);
                    new FraSegundo().setSize(800, 600);
                } catch (SQLException ex) {
                    Logger.getLogger(FraSegundo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADMalterar;
    private javax.swing.JTextField ADMdepartamento;
    private javax.swing.JButton ADMexcluir;
    private javax.swing.JButton ADMlimpa;
    private javax.swing.JButton ADMlimpa1;
    private javax.swing.JTextField ADMlogin;
    private javax.swing.JButton ADMnovo;
    private javax.swing.JTextField ADMperfil;
    private javax.swing.JButton ADMsalvar;
    private javax.swing.JTextField ADMusuario;
    private javax.swing.JButton BAlterar;
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BConfirma;
    private javax.swing.JButton BConfirma1;
    private javax.swing.JButton BLimpar;
    private javax.swing.JButton BNovo;
    private javax.swing.JButton BOk;
    private javax.swing.JButton BOk1;
    private javax.swing.JMenu JSair;
    private javax.swing.JMenu JSair1;
    private javax.swing.JMenu JSobre;
    private javax.swing.JMenu JSobre1;
    private javax.swing.JMenu JSobre2;
    private javax.swing.JButton Nova;
    private javax.swing.JButton TRCancela;
    private javax.swing.JButton TRNova;
    private javax.swing.JButton TRatualiza;
    private javax.swing.JTextField TRautorizado;
    private javax.swing.JTextField TRdatasaida;
    private javax.swing.JTextField TRdepartamento;
    private javax.swing.JTextField TRdestino;
    private javax.swing.JTextField TRhoraretorno;
    private javax.swing.JTextField TRhorasaida;
    private javax.swing.JTextField TRjustificativa;
    private javax.swing.JTextField TRlocalsaida;
    private javax.swing.JTextArea TRobs2;
    private javax.swing.JTextField TRpassageiro;
    private javax.swing.JTextField TRpedido;
    private javax.swing.JTextField TRqntusuario;
    private javax.swing.JCheckBox TRurgencia;
    private javax.swing.JTabbedPane aba;
    private javax.swing.JButton atualiza;
    private javax.swing.JTextField autorizado;
    private javax.swing.JCheckBox checkurgencia;
    private javax.swing.JTextField datasaida;
    private javax.swing.JTextField departamento;
    private javax.swing.JTextField destino;
    private javax.swing.JComboBox filtro1;
    private javax.swing.JMenu historico;
    private javax.swing.JTextField horaretorno;
    private javax.swing.JTextField horasaida;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField justificativa;
    private javax.swing.JTextField localsaida;
    private javax.swing.JTextArea obs2;
    private javax.swing.JTextField passageiro;
    private javax.swing.JTextField pedido;
    private javax.swing.JTextField qntusuario;
    // End of variables declaration//GEN-END:variables

    private void BuscaPedido() throws SQLException {

        List<consulta2> consultaDois2 = null;
        String sql = "select * from Pedido where id_pedido =" + pedido.getText();

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Pedido> minhaLista = new ArrayList<Pedido>();
        Pedido c1 = new Pedido();
        while (rs.next()) {

            c1.setDepartamento(rs.getString("id_departamento"));
            c1.setAutorizado(rs.getString("id_autorizado"));
            c1.setLocalsaida(rs.getString("localsaida"));
            c1.setHorasaida(rs.getString("horasaida"));
            c1.setDatasaida(rs.getString("datasaida"));
            c1.setDestino(rs.getString("destino"));
            c1.setObs2(rs.getString("obs2"));
            c1.setHoraretorno(rs.getString("horaretorno"));
            c1.setJustificativa(rs.getString("justificativa"));
            c1.setPassageiro(rs.getString("passageiro"));
            c1.setUsuario(Long.valueOf(rs.getLong("id_usuario")));
            c1.setTempo_espera(rs.getString("tempo_espera"));
            c1.setSituacao(rs.getString("situacao"));
            c1.setPedido(Long.valueOf(rs.getLong("id_pedido")));
            c1.setUrgencia((rs.getInt("urgencia")));
            c1.setQntusuario(rs.getString("qntusuario"));
            
            
            
            String dat = rs.getString("dataSaida");
            String A = retornaA2(dat);
            String M = retornaM2(dat);
            String D = retornaD2(dat);
            String data = D + "/" + M + "/" + A;
            c1.setDatasaida(data);

            minhaLista.add(c1);

        }
        rs.close();
        stmt.close();

        consultaDois2 = transformaID2(Long.valueOf(c1.getAutorizado()));
        for (int j = 0; j < consultaDois2.size(); j++) {
            autorizado.setText(consultaDois2.get(j).getNome());
        }

        consultaDois2 = transformaID1(Long.valueOf(c1.getDepartamento()));
        for (int j = 0; j < consultaDois2.size(); j++) {
            departamento.setText(consultaDois2.get(j).getNome());
        }

        localsaida.setText(c1.getLocalsaida());
        destino.setText(c1.getDestino());
        horasaida.setText(c1.getHorasaida());
        horaretorno.setText(c1.getHoraretorno());
        datasaida.setText(c1.getDatasaida());
        justificativa.setText(c1.getJustificativa());
        passageiro.setText(c1.getPassageiro());
        pedido.setText(String.valueOf(c1.getPedido()));
        obs2.setText(c1.getObs2());
        qntusuario.setText(c1.getQntusuario());

        if (c1.getUrgencia() == 0) {
            checkurgencia.setSelected(false);
        } else {
            checkurgencia.setSelected(true);
        }
    }

    private void TRBuscaPedido() throws SQLException {

        List<consulta2> consultaDois2 = null;
        String sql = "select * from Pedido where id_pedido =" + TRpedido.getText();

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        List<Pedido> minhaLista = new ArrayList<Pedido>();
        Pedido c1 = new Pedido();
        while (rs.next()) {

            c1.setDepartamento(rs.getString("id_departamento"));
            c1.setAutorizado(rs.getString("id_autorizado"));
            c1.setLocalsaida(rs.getString("localsaida"));
            c1.setHorasaida(rs.getString("horasaida"));
            c1.setDatasaida(rs.getString("datasaida"));
            c1.setDestino(rs.getString("destino"));
            c1.setObs2(rs.getString("obs2"));
            c1.setHoraretorno(rs.getString("horaretorno"));
            c1.setJustificativa(rs.getString("justificativa"));
            c1.setPassageiro(rs.getString("passageiro"));
            c1.setUsuario(Long.valueOf(rs.getLong("id_usuario")));
            c1.setTempo_espera(rs.getString("tempo_espera"));
            c1.setSituacao(rs.getString("situacao"));
            c1.setPedido(Long.valueOf(rs.getLong("id_pedido")));
            c1.setUrgencia((rs.getInt("urgencia")));
            c1.setQntusuario(rs.getString("qntusuario"));

            String dat = rs.getString("dataSaida");
            String A = retornaA2(dat);
            String M = retornaM2(dat);
            String D = retornaD2(dat);
            String data = D + "/" + M + "/" + A;
            c1.setDatasaida(data);

            minhaLista.add(c1);

        }
        rs.close();
        stmt.close();

        consultaDois2 = transformaID2(Long.valueOf(c1.getAutorizado()));
        for (int j = 0; j < consultaDois2.size(); j++) {
            TRautorizado.setText(consultaDois2.get(j).getNome());
        }

        consultaDois2 = transformaID1(Long.valueOf(c1.getDepartamento()));
        for (int j = 0; j < consultaDois2.size(); j++) {
            TRdepartamento.setText(consultaDois2.get(j).getNome());
        }

        TRlocalsaida.setText(c1.getLocalsaida());
        TRdestino.setText(c1.getDestino());
        TRhorasaida.setText(c1.getHorasaida());
        TRhoraretorno.setText(c1.getHoraretorno());
        TRdatasaida.setText(c1.getDatasaida());
        TRjustificativa.setText(c1.getJustificativa());
        TRpassageiro.setText(c1.getPassageiro());
        TRpedido.setText(String.valueOf(c1.getPedido()));
        TRobs2.setText(c1.getObs2());
        TRqntusuario.setText(c1.getQntusuario());

        if (c1.getUrgencia() == 0) {
            TRurgencia.setSelected(false);
        } else {
            TRurgencia.setSelected(true);
        }

    }

    
     public static void music() {
        
        AudioPlayer MGP = AudioPlayer.player;  
        AudioStream BGM = null;  
        AudioData MD = null;  
        //ContinuousAudioDataStream loop = null;  
  
        try {
            System.out.println("g");
            BGM = new AudioStream(new FileInputStream("C:\\vera.wav")); /*(new FileInputStream("C:\\vera.wav"))*/  
            System.out.println("g1");
            MD = BGM.getData();
            System.out.println("g2");
           
                //loop = new ContinuousAudioDataStream(MD);
             
            System.out.println("g3");
            
        } catch(IOException error)  {  
            System.out.println("Error!!!");  
  
        }  
            //MGP.start(loop);
            MGP.start(new AudioDataStream(MD));
        
        }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
