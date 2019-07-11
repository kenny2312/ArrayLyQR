
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.barcodelib.barcode.QRCode;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.File;
import static java.lang.Thread.sleep;
import javax.swing.SwingUtilities;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.objects.NativeString.substring;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kenny
 */
public class venta1 extends javax.swing.JFrame {

    /**
     * Creates new form venta1
     */
    public static JButton[] btnp = new JButton[37];
    public static String fechaSal = "";
    public static DefaultTableModel lista;//Historial
    public static DefaultTableModel lista2;//Parqueadero Actual
    public static ArrayList<carro> lstcarros = new ArrayList<>();//Guarda todo en la lista carro
    public static ArrayList<carro> lstcarrospark = new ArrayList<>();//Lista del parqueadero/toma valores del carro
    int i = 0;
    int udm = 0, resol = 72, rot = 0;
    float mi = 0.0f, md = 0.00f, ms = 0.0f, min = 0.0f, tam = 8.00f;
    String directorio;
    File parqueadero;
    String directoriopdf;
    File carpetapdf;
    String directorioqr;
    File carpetaqr;

    public venta1() {
        String path = "C:\\Users\\LABORATORIO 5\\Desktop\\Música De Elevador Sin Copyright.mp3";
//    MP3 n = new MP3(path);
        String[] cls = {"Placa", "Fecha de entrada", "Hora de entrada", "Fecha de salida", "Hora de salida"};
        String[] cls2 = {"Lugares", "Disponible", "Hora de entrada", "Placa"};
        lista = new DefaultTableModel(cls, 0);
        lista2 = new DefaultTableModel(cls2, 0);

        directorio = "C:\\Parqueadero";
        parqueadero = new File(directorio);
        parqueadero.mkdir();
        directoriopdf = "C:\\Parqueadero\\pdf";
        carpetapdf = new File(directoriopdf);
        carpetapdf.mkdir();
        directorioqr = "C:\\Parqueadero\\qr";
        carpetaqr = new File(directorioqr);
        carpetaqr.mkdir();
        //

        initComponents();
       // n.play();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        añadirbtn();
        // probar();

        this.setLocationRelativeTo(null);
        selecord();
        Btnadd.setMnemonic(KeyEvent.VK_ENTER);
        lblsal.setVisible(false);

        //
        for (int i = 0; i < 37; i++) {
            Object[] row = new Object[4];
            // jTable2.setValueAt(  i+1,i,0);

            row[0] = i + 1;
            row[3] = "";
            row[2] = "";
            row[1] = "Disponible";
            lista2.addRow(row);
            jTable2.setDefaultRenderer(Object.class, new PintaTabla());
            ImageIcon fot = new ImageIcon(getClass().getResource("/imagenes/estacionamiento.jpg"));
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(btnp[i].getWidth(), btnp[i].getHeight(), Image.SCALE_DEFAULT));
            btnp[i].setIcon(icono);

        }

        int j = 5;

    }

    public void añadirbtn() {

        btnp[0] = p1;
        btnp[1] = p2;
        btnp[2] = p3;
        btnp[3] = p4;
        btnp[4] = p5;
        btnp[5] = p6;
        btnp[6] = p7;
        btnp[7] = p8;
        btnp[8] = p9;
        btnp[9] = p10;
        btnp[10] = p11;
        btnp[11] = p12;
        btnp[12] = p13;
        btnp[13] = p14;
        btnp[14] = p15;
        btnp[15] = p16;
        btnp[16] = p17;
        btnp[17] = p18;
        btnp[18] = p19;
        btnp[19] = p20;
        btnp[20] = p21;
        btnp[21] = p22;
        btnp[22] = p23;
        btnp[23] = p24;
        btnp[24] = p25;
        btnp[25] = p26;
        btnp[26] = p27;
        btnp[27] = p28;
        btnp[28] = p29;
        btnp[29] = p30;
        btnp[30] = p31;
        btnp[31] = p32;
        btnp[32] = p33;
        btnp[33] = p34;
        btnp[34] = p35;
        btnp[35] = p36;
        btnp[36] = p37;

    }

    /*
    public void probar() {
        for (int i = 0; i < 29; i++) {
            btnp[i].setEnabled(false);
        }

    }
     */
    //
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Placalbl = new javax.swing.JLabel();
        Btnadd = new javax.swing.JButton();
        Txtplaca = new javax.swing.JTextField();
        TxtFecha = new javax.swing.JTextField();
        TxtHora = new javax.swing.JTextField();
        Fechalbl = new javax.swing.JLabel();
        Horalbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSalida = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Historiallbl = new javax.swing.JLabel();
        OrdenarButton = new javax.swing.JButton();
        Cmbor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        PuestosLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblcar = new javax.swing.JLabel();
        p16 = new javax.swing.JButton();
        p15 = new javax.swing.JButton();
        p14 = new javax.swing.JButton();
        p13 = new javax.swing.JButton();
        p12 = new javax.swing.JButton();
        p11 = new javax.swing.JButton();
        p18 = new javax.swing.JButton();
        p17 = new javax.swing.JButton();
        p19 = new javax.swing.JButton();
        p20 = new javax.swing.JButton();
        p21 = new javax.swing.JButton();
        p22 = new javax.swing.JButton();
        p25 = new javax.swing.JButton();
        p27 = new javax.swing.JButton();
        p23 = new javax.swing.JButton();
        p26 = new javax.swing.JButton();
        p28 = new javax.swing.JButton();
        p29 = new javax.swing.JButton();
        p24 = new javax.swing.JButton();
        p30 = new javax.swing.JButton();
        p31 = new javax.swing.JButton();
        p33 = new javax.swing.JButton();
        p34 = new javax.swing.JButton();
        p35 = new javax.swing.JButton();
        p32 = new javax.swing.JButton();
        p10 = new javax.swing.JButton();
        p8 = new javax.swing.JButton();
        p7 = new javax.swing.JButton();
        p6 = new javax.swing.JButton();
        p9 = new javax.swing.JButton();
        p5 = new javax.swing.JButton();
        p3 = new javax.swing.JButton();
        p2 = new javax.swing.JButton();
        p1 = new javax.swing.JButton();
        p4 = new javax.swing.JButton();
        p36 = new javax.swing.JButton();
        p37 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblsal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnPrint = new javax.swing.JMenuItem();
        mnSettings = new javax.swing.JMenu();
        mnIdiom = new javax.swing.JMenu();
        mnEspañol = new javax.swing.JMenuItem();
        mnJP = new javax.swing.JMenuItem();
        mnIngles = new javax.swing.JMenuItem();
        mnChino = new javax.swing.JMenuItem();
        mnSession = new javax.swing.JMenu();
        mnClose = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 255, 0));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Placalbl.setFont(new java.awt.Font("Eras Medium ITC", 3, 18)); // NOI18N
        Placalbl.setForeground(new java.awt.Color(255, 51, 51));
        Placalbl.setText("   Ingreso de Placa");
        jPanel1.add(Placalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 200, 36));

        Btnadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btnadd.setText("Agregar");
        Btnadd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnaddActionPerformed(evt);
            }
        });
        jPanel1.add(Btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 60, 30));

        Txtplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtplacaActionPerformed(evt);
            }
        });
        jPanel1.add(Txtplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 55, 110, -1));

        TxtFecha.setEnabled(false);
        TxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(TxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 37, 144, -1));

        TxtHora.setEnabled(false);
        TxtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtHoraActionPerformed(evt);
            }
        });
        jPanel1.add(TxtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 63, 144, -1));

        Fechalbl.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Fechalbl.setForeground(new java.awt.Color(255, 51, 51));
        Fechalbl.setText("Fecha");
        jPanel1.add(Fechalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, -1, -1));

        Horalbl.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Horalbl.setForeground(new java.awt.Color(255, 51, 51));
        Horalbl.setText("Hora");
        jPanel1.add(Horalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 0));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 50, 60));

        btnSalida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalida.setText("Salida");
        btnSalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 70, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sin título-2.jpg"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(711, 400));
        jLabel6.setPreferredSize(new java.awt.Dimension(711, 400));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -8, 700, 420));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jTabbedPane1.addTab("parkeadero", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setModel(lista);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleDescription("");

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 75, 546, 251));

        Historiallbl.setBackground(new java.awt.Color(255, 255, 255));
        Historiallbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Historiallbl.setForeground(new java.awt.Color(204, 0, 0));
        Historiallbl.setText("Historial");
        jPanel2.add(Historiallbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 180, 46));

        OrdenarButton.setText("ORDENAR");
        OrdenarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarButtonActionPerformed(evt);
            }
        });
        jPanel2.add(OrdenarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 348, -1, -1));

        Cmbor.setBackground(new java.awt.Color(255, 255, 0));
        Cmbor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Cmbor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmborActionPerformed(evt);
            }
        });
        jPanel2.add(Cmbor, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 349, 129, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Black-Background-Metal-2560x1600-by-Freeman2.jpg"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 420));

        jTabbedPane1.addTab("Historial", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(lista2);
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 540, 250));

        PuestosLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        PuestosLabel.setForeground(new java.awt.Color(204, 0, 0));
        PuestosLabel.setText("Puestos");
        jPanel3.add(PuestosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 130, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Black-Background-Metal-2560x1600-by-Freeman2.jpg"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 740, 420));

        jTabbedPane1.addTab("Lugares", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel4KeyPressed(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconocarLeft.png"))); // NOI18N
        lblcar.setToolTipText("");
        lblcar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblcar.setMaximumSize(new java.awt.Dimension(100, 100));
        lblcar.setMinimumSize(new java.awt.Dimension(1, 1));
        lblcar.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel4.add(lblcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 70, 30));

        p16.setText(" ");
        p16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 129, 50, -1));

        p15.setText(" ");
        p15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 158, 50, -1));

        p14.setText(" ");
        p14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 192, 50, -1));

        p13.setText(" ");
        p13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 221, 50, -1));

        p12.setText(" ");
        p12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, -1));

        p11.setText(" ");
        p11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 279, 50, -1));

        p18.setText("  ");
        p18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 50, -1));

        p17.setText("    ");
        p17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, -1));

        p19.setText("  ");
        p19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 50, -1));

        p20.setText("   ");
        p20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 50, -1));

        p21.setText("  ");
        p21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 45, -1));

        p22.setText("  ");
        p22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 45, -1));

        p25.setText("  ");
        p25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p25, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 45, -1));

        p27.setText("  ");
        p27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p27, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 45, -1));

        p23.setText("  ");
        p23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 45, -1));

        p26.setText("  ");
        p26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 45, -1));

        p28.setText("  ");
        p28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 45, -1));

        p29.setText("  ");
        p29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p29, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 45, -1));

        p24.setText("  ");
        p24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 45, -1));

        p30.setText("  ");
        p30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p30, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 37, 45, -1));

        p31.setText("  ");
        p31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p31, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 66, 45, -1));

        p33.setText("  ");
        p33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p33, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 129, 45, -1));

        p34.setText("  ");
        p34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p34, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 158, 45, -1));

        p35.setText("  ");
        p35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p35, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 45, -1));

        p32.setText("  ");
        p32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p32, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 100, 45, -1));

        p10.setText(" ");
        p10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 45, -1));

        p8.setText("   ");
        p8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 45, -1));

        p7.setText("  ");
        p7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 45, -1));

        p6.setText("   ");
        p6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 45, -1));

        p9.setText("  ");
        p9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 45, -1));

        p5.setText("  ");
        p5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 45, -1));

        p3.setText("  ");
        p3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 45, -1));

        p2.setText("  ");
        p2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 45, -1));

        p1.setText("  ");
        p1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ActionPerformed(evt);
            }
        });
        jPanel4.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 45, -1));

        p4.setText("  ");
        p4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 45, -1));

        p36.setText("  ");
        p36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p36, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 221, 45, -1));

        p37.setText("  ");
        p37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(p37, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 250, 45, -1));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));

        lblsal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconocarLeft.png"))); // NOI18N
        lblsal.setMaximumSize(new java.awt.Dimension(100, 100));
        lblsal.setMinimumSize(new java.awt.Dimension(1, 1));
        jPanel4.add(lblsal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 70, 36));

        jTabbedPane1.addTab("Parqueadero", jPanel4);

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(204, 204, 0), new java.awt.Color(255, 204, 0)));
        jMenuBar1.setForeground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(56, 3276));

        mnFile.setText("Archivo");

        mnPrint.setText("Imprimir tabla");
        mnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPrintActionPerformed(evt);
            }
        });
        mnFile.add(mnPrint);

        jMenuBar1.add(mnFile);

        mnSettings.setText("Ajustes");

        mnIdiom.setText("Idiomas");

        mnEspañol.setText("Español");
        mnEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEspañolActionPerformed(evt);
            }
        });
        mnIdiom.add(mnEspañol);

        mnJP.setText("Japones");
        mnJP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJPActionPerformed(evt);
            }
        });
        mnIdiom.add(mnJP);

        mnIngles.setText("Ingles");
        mnIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnInglesActionPerformed(evt);
            }
        });
        mnIdiom.add(mnIngles);

        mnChino.setText("Chino");
        mnChino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnChinoActionPerformed(evt);
            }
        });
        mnIdiom.add(mnChino);

        mnSettings.add(mnIdiom);

        jMenuBar1.add(mnSettings);

        mnSession.setText("Sesion");

        mnClose.setText("cerrar sesion");
        mnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCloseActionPerformed(evt);
            }
        });
        mnSession.add(mnClose);

        jMenuBar1.add(mnSession);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void array() {

        for (carro c : lstcarros) {
            System.out.println("" + c.getPlaca());

        }

    }

    public String addzero(int x) {
        String t;
        if (x < 10) {
            t = "0" + x;
        } else {
            t = "" + x;
        }
        return t;

    }

    public static void precioapagar(carro p) {
        double valor = 0.016;
        double valor2 = 1.0;
        String hora1 = "";
        String hora2 = "";
        String minutos1 = "";
        String minutos2 = "";

        double shora = 0;
        double sminu = 0;
        double n1 = 0;
        double n2 = 0;
        double tot = 0;

        //   
        //System.out.println(substring(p.getHora1(), 1,3));
        //System.out.println(substring(p.getHora1(), 4,6));
        hora1 = substring(p.getHora1(), 1, 3);
        hora2 = substring(p.getHora2(), 0, 2);
        minutos1 = substring(p.getHora1(), 4, 6);
        minutos2 = substring(p.getHora2(), 3, 5);

        if (Double.parseDouble(hora2) > Double.parseDouble(hora1)) {
            shora = Double.parseDouble(hora2) - Double.parseDouble(hora1);
        } else {
            shora = Double.parseDouble(hora1) - Double.parseDouble(hora2);
        }

        if (Double.parseDouble(minutos2) > Double.parseDouble(minutos1)) {
            sminu = Double.parseDouble(minutos2) - Double.parseDouble(minutos1);
        } else {
            sminu = Double.parseDouble(minutos1) - Double.parseDouble(minutos2);
        }
        n1 = shora * valor2;
        n2 = sminu * valor;
        System.out.println("" + n2);
        tot = n1 + n2;
        System.out.println("VALOR A PAGAR :" + tot);

        // System.out.println(substring(p.getHora2(), 0,2));
        //System.out.println(substring(p.getHora2(), 3,5));
        //minutos2=substring(p.getHora2(), 4,6);
        //   tot=su*valor;
    }

    public void cerrar() {
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "Desea cerrar sesion", "Titulo", 0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.out.println("Se cancelo el cierre");
        }
    }

    public boolean validarrepe(String a) { //Busca para ver si una placa se repite o no

        boolean encontrado = false;
        String pla;

        encontrado = false;
        pla = a;

        for (carro objcar : lstcarrospark) {

            if (objcar.getPlaca().equals(pla)) {

                encontrado = true;

               
                Txtplaca.setText("");
                break;

            }

        }

        return encontrado;
    }

    public void cargar() {

        Calendar fecha = new GregorianCalendar(); //Calendario
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);   //Metodos para obtener correspondiente la fecha atual del sistema
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        String p = "";
        int segundo = fecha.get(Calendar.SECOND);
        carro pa = new carro();
        Object[] row = new Object[5];
        mes = mes + 1;// me falta un mes 

        TxtFecha.setText("" + addzero(dia) + "/" + addzero(mes) + "/" + anio);
        TxtHora.setText(" " + addzero(hora) + ":" + addzero(minuto) + ":" + addzero(segundo));

        row[0] = Txtplaca.getText();
        row[1] = TxtFecha.getText();
        row[2] = TxtHora.getText();// esta es el campo hora de salida

        pa.setPlaca(Txtplaca.getText());
        pa.setFecha1(TxtFecha.getText());
        pa.setHora1(TxtHora.getText());

        for (int i = 0; i < 37; i++) {
            if (btnp[i].isEnabled()) {

                jTable2.setValueAt("OCUPADO", i, 1);
                jTable2.setValueAt(pa.getHora1(), i, 2);
                jTable2.setValueAt(pa.getPlaca(), i, 3);
                ImageIcon fot = new ImageIcon(getClass().getResource("/imagenes/prohibido.png"));
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(btnp[i].getWidth(), btnp[i].getHeight(), Image.SCALE_DEFAULT));
                btnp[i].setIcon(icono);
                pa.setPuesto("" + i);
                p = "" + i;
                break;
            }

        }

        String datoqr = "Fecha y hora de entrada: " + TxtFecha.getText() + " " + TxtHora.getText() + "\n" + "Placa: " + Txtplaca.getText();

        pa.setQr(generarQr(datoqr));

        lstcarros.add(pa);
        lstcarrospark.add(pa);
        lista.addRow(row);

        Txtplaca.setText("");

        //jTable1.setDefaultRenderer(Object.class, new PintaTabla());
    }

    void ordenar1(ArrayList<carro> lista) {
        Collections.sort(lista, (carro o1, carro o2)
                -> o1.getPlaca().compareTo(o2.getPlaca()));
    }

    void ordenar2(ArrayList<carro> lista) {
        Collections.sort(lista, (carro o1, carro o2)
                -> o1.getFecha1().compareTo(o2.getFecha1()));
    }

    void ordenar3(ArrayList<carro> lista) {
        Collections.sort(lista, (carro o1, carro o2)
                -> o2.getHora1().compareTo(o1.getHora1()));
    }

    public void ordenarV1() {
        lista.getDataVector().clear();//vacia la tabla

        ordenar1(lstcarros);
        for (carro obj : lstcarros) {

            Object[] row = new Object[5];
            row[1] = obj.getFecha1();
            row[3] = obj.getFecha2();
            row[0] = obj.getPlaca();
            row[2] = obj.getHora1();
            row[4] = obj.getHora2();
            lista.addRow(row);
        } //  jTable1.setDefaultRenderer(Object.class, new PintaTabla());
    }

    public void ordenarV2() {
        lista.getDataVector().clear();//vacia la tabla

        ordenar3(lstcarros);
        for (carro obj : lstcarros) {
            Object[] row = new Object[5];
            row[1] = obj.getFecha1();
            row[3] = obj.getFecha2();
            row[0] = obj.getPlaca();
            row[2] = obj.getHora1();
            row[4] = obj.getHora2();
            lista.addRow(row);
        }
        //  jTable1.setDefaultRenderer(Object.class, new PintaTabla());
    }

    public void ordenarV3() {
        lista.getDataVector().clear();//vacia la tabla

        ordenar2(lstcarros);
        for (carro obj : lstcarros) {
            Object[] row = new Object[5];
            row[1] = obj.getFecha1();
            row[3] = obj.getFecha2();
            row[0] = obj.getPlaca();
            row[2] = obj.getHora1();
            row[4] = obj.getHora2();
            lista.addRow(row);
        }
        //  jTable1.setDefaultRenderer(Object.class, new PintaTabla());
    }

    public boolean va_placa() {
        boolean gokusuper4 = false;
        String placa = "";

        //   System.out.println(" Ejemplo ABZ-1234 o ABZ-123");
        placa = Txtplaca.getText();
        Pattern pa = Pattern.compile("^[A-Z]{3}+-{1}+[1-9]{3,4}$");//decigna el formato
        Matcher mat = pa.matcher(placa);//esto compara con el formato
        if (mat.matches()) {//reduelve el valor de verdadero o falso
            gokusuper4 = true;

        } else {
            Txtplaca.setText("");
        }

        return gokusuper4;
    }

    public QRCode generarQr(String dato) {
        QRCode c = new QRCode();
        try {

            c.setData(dato);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(mi);
            c.setResolution(resol);
            c.setModuleSize(tam);
            i++;
            String ar = directorioqr + "\\ticket" + i + ".jpeg";
            c.renderBarcode(ar);
            Generarpdf a = new Generarpdf();

            a.generarpdf(dato, ar, directoriopdf + "\\ticket" + i + ".pdf");

        } catch (Exception ex) {
            Logger.getLogger(venta1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }
    private void OrdenarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarButtonActionPerformed

        if (Cmbor.getSelectedItem().equals("placa alf")) {
            ordenarV1();
        } else if (Cmbor.getSelectedItem().toString().equals("Tiempo")) {
            ordenarV2();
        } else if (Cmbor.getSelectedItem().toString().equals("Fecha entrada")) {
            ordenarV3();
        }
    }//GEN-LAST:event_OrdenarButtonActionPerformed
    public static void recibirfechsal(String fecha_salida, String hora_salida, String placa) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < lista.getRowCount(); j++) {
                if (placa.equals(lista.getValueAt(j, 0))) {
                    lista.setValueAt(fecha_salida, j, 3);
                    lista.setValueAt(hora_salida, j, 4);
                }
            }

        }

    }

    class Carrera extends Thread {

        JLabel j;
        int velocidad;
        ImageIcon iconDown = new ImageIcon(getClass().getResource("/imagenes/iconocarDownpng.png"));

        ImageIcon iconUp = new ImageIcon(getClass().getResource("/imagenes/iconocarUp.png"));
        ImageIcon iconRight = new ImageIcon(getClass().getResource("/imagenes/iconocarRight.png"));
        ImageIcon iconLeft = new ImageIcon(getClass().getResource("/imagenes/iconocarLeft.png"));

        public Carrera(int velocidad, JLabel j) {
            this.j = j;
            this.velocidad = velocidad;
        }

        public void run() {
            jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 70, 36));
            j.setIcon(iconLeft);
            j.setVisible(true);

            for (int t = 0; t < 37; t++) {

                if (t < 10) {
                    if (btnp[t].isEnabled()) {
                        while (j.getX() > btnp[t].getLocation().x) {

                            j.setLocation(j.getX() - 1, j.getY());
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }
                        }

                        jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
                        j.setIcon(iconDown);

                        while (j.getY() < btnp[t].getLocation().y) {
                            j.setLocation(j.getX(), j.getY() + 1);

                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }
                        }

                        btnp[t].setEnabled(false);
                        if (!btnp[t].isEnabled()) {
                            //j.setSize(36, 70);
                            //j.setIcon(iconLeft);
                            break;
                        }
                    }
                } else if (t >= 10 && t < 19) {

                    if (btnp[t].isEnabled()) {
                        while (j.getX() > btnp[9].getLocation().x) {
                            j.setLocation(j.getX() - 1, j.getY());
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }

                        }
                        jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
                        j.setIcon(iconUp);
                        while (j.getY() > btnp[t].getLocation().y) {
                            j.setLocation(j.getX(), j.getY() - 1);
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }
                        }
                        jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 70, 36));
                        j.setIcon(iconLeft);
                        while (j.getX() > btnp[t].getLocation().x) {
                            j.setLocation(j.getX() - 1, j.getY());
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }

                        }
                        btnp[t].setEnabled(false);
                        if (!btnp[t].isEnabled()) {
                            break;
                        }
                    }
                } else if (t >= 19 && t < 29) {
                    if (btnp[t].isEnabled()) {
                        while (j.getX() > btnp[9].getLocation().x) {
                            j.setLocation(j.getX() - 1, j.getY());
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }

                        }
                        jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 76));
                        j.setIcon(iconUp);
                        while (j.getY() > btnp[18].getLocation().y) {
                            j.setLocation(j.getX(), j.getY() - 1);
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }
                        }
                        if (t == 19) {

                            while (j.getY() > btnp[t].getLocation().y) {
                                j.setLocation(j.getX(), j.getY() - 1);
                                try {
                                    sleep(100 / velocidad);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                        jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 70, 36));
                        j.setIcon(iconRight);
                        while (j.getX() < btnp[t].getLocation().x) {
                            j.setLocation(j.getX() + 1, j.getY());
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }

                        }
                        jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
                        j.setIcon(iconUp);
                        while (j.getY() > btnp[t].getLocation().y) {
                            j.setLocation(j.getX(), j.getY() - 1);
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }
                        }
                        btnp[t].setEnabled(false);
                        if (!btnp[t].isEnabled()) {
                            break;
                        }
                    }

                } else if (btnp[t].isEnabled()) {

                    while (j.getX() > btnp[9].getLocation().x) {
                        j.setLocation(j.getX() - 1, j.getY());
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
                    j.setIcon(iconUp);
                    while (j.getY() > btnp[18].getLocation().y) {
                        j.setLocation(j.getX(), j.getY() - 1);
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }
                    }
                    jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 70, 36));
                    j.setIcon(iconRight);
                    while (j.getX() < 590) {
                        j.setLocation(j.getX() + 1, j.getY());
                        try {
                            sleep(10 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    if (t == 29) {
                        while (j.getX() < btnp[t].getLocation().x) {
                            j.setLocation(j.getX() + 1, j.getY());
                            try {
                                sleep(100 / velocidad);
                            } catch (InterruptedException e) {
                            }

                        }

                    }

                    jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
                    j.setIcon(iconDown);
                    while (j.getY() < btnp[t].getLocation().y) {
                        j.setLocation(j.getX(), j.getY() + 1);
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 70, 36));
                    j.setIcon(iconRight);
                    while (j.getX() < btnp[t].getLocation().x) {
                        j.setLocation(j.getX() + 1, j.getY());
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    btnp[t].setEnabled(false);
                    if (!btnp[t].isEnabled()) {
                        break;
                    }
                }

            }
            jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 70, 36));
            j.setVisible(false);
        }

    }


    private void TxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaActionPerformed


    }//GEN-LAST:event_TxtFechaActionPerformed

    private void TxtplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtplacaActionPerformed

    }//GEN-LAST:event_TxtplacaActionPerformed

    private void BtnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnaddActionPerformed
        if (va_placa() == true && validarrepe(Txtplaca.getText()) == false) {
            cargar();
            Carrera carro = new Carrera(8, lblcar);
            carro.start();
            jTabbedPane1.setSelectedIndex(3);
        } else if ( validarrepe(Txtplaca.getText()) == true&&(va_placa()==true)) {
             JOptionPane.showMessageDialog(jPanel1, "Placa ya existe ");
        }else if (va_placa()==false){
        JOptionPane.showMessageDialog(jPanel1, "Formato incorrecto  Ejemplo ABZ-1234 o ABZ-123" + "O Placa ya existe");

        }
    }//GEN-LAST:event_BtnaddActionPerformed

    private void TxtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtHoraActionPerformed

    private void CmborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmborActionPerformed

    }//GEN-LAST:event_CmborActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed

        new WebcamQRCodeExampl().setVisible(true);

    }//GEN-LAST:event_btnSalidaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void mnEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEspañolActionPerformed
        // TODO add your handling code here:
        Cambiar_lenguaje("es", "EC");
        String[] cls3 = {"placa", "Fecha de entrada", "Hora de entrada", "Fecha de salida", "Hora de salida"};
        String[] cls4 = {"Lugares", "Disponible", "Hora de entrada", "Placa"};

        lista.setColumnIdentifiers(cls3);
        lista2.setColumnIdentifiers(cls4);

    }//GEN-LAST:event_mnEspañolActionPerformed

    private void mnInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnInglesActionPerformed
        // TODO add your handling code here:
        Cambiar_lenguaje("en", "US");
        String[] cls3 = {"plate", "Date of entry", "Time of entry", "Date of departure", "Time of departure"};
        String[] cls4 = {"Places", "Available", "Time of entry", "Plate"};
        lista.setColumnIdentifiers(cls3);
        lista2.setColumnIdentifiers(cls4);
    }//GEN-LAST:event_mnInglesActionPerformed

    private void mnChinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnChinoActionPerformed
        // TODO add your handling code here:
        Cambiar_lenguaje("zh", "CN");
        String[] cls3 = {"板塊", "進入日期", "進入時間", "出發日期", "出發時間"};
        String[] cls4 = {"地方", "可用", "进入时间", "板块"};
        lista.setColumnIdentifiers(cls3);
        lista2.setColumnIdentifiers(cls4);
    }//GEN-LAST:event_mnChinoActionPerformed

    private void jPanel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel4KeyPressed

    }//GEN-LAST:event_jPanel4KeyPressed

    private void p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p1ActionPerformed

    private void mnJPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnJPActionPerformed
        // TODO add your handling code here:
        Cambiar_lenguaje("jap", "JP");
        String[] cls3 = {"発券日", "発券日", "出発日", "出発時刻", "発時刻"};
        String[] cls4 = {"場所", "使用可能", "入場時期", "プレート"};
        lista.setColumnIdentifiers(cls3);
        lista2.setColumnIdentifiers(cls4);
    }//GEN-LAST:event_mnJPActionPerformed

    private void mnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCloseActionPerformed
        cerrar();
    }//GEN-LAST:event_mnCloseActionPerformed

    private void mnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPrintActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.print(JTable.PrintMode.NORMAL);
        } catch (PrinterException ex) {
            Logger.getLogger(venta1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnPrintActionPerformed

    public void selecord() {
        Cmbor.removeAllItems();
        Cmbor.addItem("Fecha entrada");
        Cmbor.addItem("placa alf");
        Cmbor.addItem("Tiempo");
    }

    public void Cambiar_lenguaje(String idioma, String region) {
        Locale.setDefault(new Locale(idioma, region));
        mnFile.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnFile"));
        mnPrint.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnPrint"));
        mnSettings.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnSettings"));
        mnIdiom.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnIdiom"));
        mnEspañol.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnEspañol"));
        mnIngles.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnIngles"));
        mnChino.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnChino"));
        mnSession.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnSession"));
        mnClose.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnClose"));
        Fechalbl.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("Fechalbl"));
        Horalbl.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("Horalbl"));
        btnSalida.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("btnSalida"));
        Btnadd.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("Btnadd"));
        Historiallbl.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("Historiallbl"));
        OrdenarButton.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("OrdenarButton"));
        PuestosLabel.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("PuestosLabel"));
        Placalbl.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("Placalbl"));
        mnJP.setText(ResourceBundle.getBundle("rs/Etiquetas").getString("mnJP"));
        jTabbedPane1.addTab(ResourceBundle.getBundle("rs/Etiquetas").getString("park"), jPanel1);
        jTabbedPane1.addTab(ResourceBundle.getBundle("rs/Etiquetas").getString("hist"), jPanel2);
        jTabbedPane1.addTab(ResourceBundle.getBundle("rs/Etiquetas").getString("lugar"), jPanel3);
        jTabbedPane1.addTab(ResourceBundle.getBundle("rs/Etiquetas").getString("park2"), jPanel4);

    }

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(venta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Login pri = new Login();
                pri.setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnadd;
    private javax.swing.JComboBox<String> Cmbor;
    private javax.swing.JLabel Fechalbl;
    private javax.swing.JLabel Historiallbl;
    private javax.swing.JLabel Horalbl;
    private javax.swing.JButton OrdenarButton;
    private javax.swing.JLabel Placalbl;
    private javax.swing.JLabel PuestosLabel;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtHora;
    private javax.swing.JTextField Txtplaca;
    private javax.swing.JButton btnSalida;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblcar;
    public static javax.swing.JLabel lblsal;
    private javax.swing.JMenuItem mnChino;
    private javax.swing.JMenuItem mnClose;
    private javax.swing.JMenuItem mnEspañol;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnIdiom;
    private javax.swing.JMenuItem mnIngles;
    private javax.swing.JMenuItem mnJP;
    private javax.swing.JMenuItem mnPrint;
    private javax.swing.JMenu mnSession;
    private javax.swing.JMenu mnSettings;
    private javax.swing.JButton p1;
    private javax.swing.JButton p10;
    private javax.swing.JButton p11;
    private javax.swing.JButton p12;
    private javax.swing.JButton p13;
    private javax.swing.JButton p14;
    private javax.swing.JButton p15;
    private javax.swing.JButton p16;
    private javax.swing.JButton p17;
    private javax.swing.JButton p18;
    private javax.swing.JButton p19;
    private javax.swing.JButton p2;
    private javax.swing.JButton p20;
    private javax.swing.JButton p21;
    private javax.swing.JButton p22;
    private javax.swing.JButton p23;
    private javax.swing.JButton p24;
    private javax.swing.JButton p25;
    private javax.swing.JButton p26;
    private javax.swing.JButton p27;
    private javax.swing.JButton p28;
    private javax.swing.JButton p29;
    private javax.swing.JButton p3;
    private javax.swing.JButton p30;
    private javax.swing.JButton p31;
    private javax.swing.JButton p32;
    private javax.swing.JButton p33;
    private javax.swing.JButton p34;
    private javax.swing.JButton p35;
    private javax.swing.JButton p36;
    private javax.swing.JButton p37;
    private javax.swing.JButton p4;
    private javax.swing.JButton p5;
    private javax.swing.JButton p6;
    private javax.swing.JButton p7;
    private javax.swing.JButton p8;
    private javax.swing.JButton p9;
    // End of variables declaration//GEN-END:variables
}
