/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pkgfinal.project;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
/**
 *
 * @author Amit Abuksis And Naor Tamir
 */

public class FinalProject extends javax.swing.JFrame {
    
    /**
     * the name of the teams in the matrix is:
     *
     * Golden State "Warriors" - 0
     * San Antonio "Spurs" - 1
     * Houston "Rockets" - 2
     * Boston "Celtics" - 3
     * Utah "Jazz" - 4
     * Toronto "Raptors" - 5
     * Cleveland "Cavaliers" - 6
     * LA "Clippers" - 7
     * Washington "Wizards" - 8
     * Oklahoma City "Thunder" -  9
     * Memphis "Grizzlies" - 10
     * Atlanta "Hawks" - 11
     * Indiana "Pacers" - 12
     * Milwaukee "Bucks" - 13
     * Chicago "Bulls" - 14
     * Portland "Trail Blazers" - 15
     * Miami "Heat" - 16
     * Denver "Nuggets" - 17
     * Detroit "Pistons" - 18
     * Charlotte "Hornets" - 19
     * New Orleans "Pelicans" - 20
     * Dallas "Mavericks" - 21
     * Sacramento "Kings" - 22
     * Minnesota "Timberwolves" - 23
     * New York "Knicks" - 24
     * Orlando "Magic" - 25
     * Philadelphia "76ers" - 26
     * Los Angeles "Lakers" - 27
     * Phoenix "Suns" - 28
     * Brooklyn "Nets" - 29
     */
    /**
     * Creates new form FinalProject
     */
    //this array contains all the static's avarages instances of the file
    //the rules is: PTS	FGM 3PM	FTM OREB DREB REB AST TOV STL BLK PF PFD
    
    /**key words:
     *
     * FGM - Field Goals Made
     * 3PM - 3 Point Field Goals Made
     * FTM - Free Throws Made
     * OREB - Offensive Rebounds
     * DREB - Defensive Rebounds
     * REB - Rebounds
     * AST - Assists
     * TOV - Turnovers
     * STL - Steals
     * BLK - Blocks
     * PF - Personal Fouls
     * PFD - Personal Fouls Drawn
     * PTS - Points
     */
    
    public double statics[][];
    public double weight[];
    public double rules[][];
    double rulesFromLearning [];
    double alpha[];
    final String teamName []  = {"Warriors", "Spurs", "Rockets", "Celtics", "Jazz", "Raptors", "Cavaliers", "Clippers", "Wizards",
        "Thunder", "Grizzlies", "Hawks", "Pacers", "Bucks", "Bulls", "Trail Blazers", "Heat", "Nuggets",
        "Pistons", "Hornets", "Pelicans", "Mavericks", "Kings", "Timberwolves", "Knicks", "Magic", "76ers",
        "Lakers", "Suns", "Nets"};
    
    public FinalProject() {
        initComponents();
        txt_qualified.setEditable(false);
        statics = readFromFile();
        Classifier c = new Classifier(statics);
        rules = c.getAllRules();
        rulesFromLearning = c.getRule();
        alpha = c.getAlpha();
    }
    
    private boolean isQuallified(double index){
        
        double fx = 0;
        System.out.println("rules from adaBoost is: " + Arrays.toString(rulesFromLearning));
        System.out.println("alpha from adaBoost is: " + Arrays.toString(alpha));
        // System.out.println("alpha from adaBoost is: " + Arrays.toString(alpha));
        for (int i = 0; i < alpha.length; i++) {
            System.out.println("for team: " + index + " tag rule: " +rulesFromLearning[i] +" is: " + rules[(int)rulesFromLearning[i]][(int)index]);
            fx += (double)alpha[i]*rules[(int)rulesFromLearning[i]][(int)index];
        }
        if(fx > 0){
            return true;
        }else
            return false;
    }
    
    private double [][] readFromFile() {
        
        statics = new double[30][14];
        String stringArray [] = null;
        try {
            File fil = new File("C:\\Users\\abuks\\Desktop\\Ariel University\\Machine Learning\\Mechine Learning Project\\staticsOf2016-17.txt");
            FileReader inputFil = new FileReader(fil);
            BufferedReader in = new BufferedReader(inputFil);
            int i = 0;
            String s = in.readLine();
            while(s != null){
                
                stringArray = s.split("\\s+");
                for (int j = 0; j < stringArray.length; j++) {
                    statics[i][j] = Double.parseDouble(stringArray[j]);
                }
                i++;
                
                s = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't read from file!");
        }
        /* System.out.println("the matrix from file is: ");
        printMat(statics);
        System.out.println("******************"); */
        return statics;
    }
    
    public void choose(boolean ans, double index){
        
        if(ans){
            txt_qualified.setText("YES! \n" +  teamName[(int)index] + " will be qualified");
            txt_qualified.setBackground(Color.GREEN);
        }else if(!ans){
            txt_qualified.setText("NO! \n" +  teamName[(int)index] + " will not qualified");
            txt_qualified.setBackground(Color.RED);
        }
    }
    public void printMat(double mat [][]){
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
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

        jLabel1 = new javax.swing.JLabel();
        btn_atlanta = new javax.swing.JButton();
        btn_boston = new javax.swing.JButton();
        btn_brooklyn = new javax.swing.JButton();
        btn_chicago = new javax.swing.JButton();
        btn_cleveland = new javax.swing.JButton();
        btn_dallas = new javax.swing.JButton();
        btn_denver = new javax.swing.JButton();
        btn_detroit = new javax.swing.JButton();
        btn_indiana = new javax.swing.JButton();
        btn_huston = new javax.swing.JButton();
        btn_goldenState = new javax.swing.JButton();
        btn_milwuakee = new javax.swing.JButton();
        btn_minesota = new javax.swing.JButton();
        btn_miami = new javax.swing.JButton();
        btn_memphis = new javax.swing.JButton();
        btn_clipppers = new javax.swing.JButton();
        btn_lakers = new javax.swing.JButton();
        btn_thunder = new javax.swing.JButton();
        btn_sacramento = new javax.swing.JButton();
        btn_pheonix = new javax.swing.JButton();
        btn_orlando = new javax.swing.JButton();
        btn_knicks = new javax.swing.JButton();
        btn_pelicans = new javax.swing.JButton();
        btn_philadelphia = new javax.swing.JButton();
        btn_portland = new javax.swing.JButton();
        btn_utah = new javax.swing.JButton();
        btn_washington = new javax.swing.JButton();
        btn_spurs = new javax.swing.JButton();
        btn_toronto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btn_charlotte = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_qualified = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 600));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pick a Team");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 10, 278, 53);

        btn_atlanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_atlanta_logo.gif"))); // NOI18N
        btn_atlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atlantaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atlanta);
        btn_atlanta.setBounds(18, 71, 83, 59);

        btn_boston.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_boston_logo.gif"))); // NOI18N
        btn_boston.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bostonActionPerformed(evt);
            }
        });
        getContentPane().add(btn_boston);
        btn_boston.setBounds(18, 259, 83, 59);

        btn_brooklyn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_brooklyn_logo.gif"))); // NOI18N
        btn_brooklyn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_brooklynActionPerformed(evt);
            }
        });
        getContentPane().add(btn_brooklyn);
        btn_brooklyn.setBounds(212, 156, 87, 59);

        btn_chicago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_chicago_logo.gif"))); // NOI18N
        btn_chicago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chicagoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_chicago);
        btn_chicago.setBounds(111, 156, 85, 59);

        btn_cleveland.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_cleveland_logo.gif"))); // NOI18N
        btn_cleveland.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clevelandActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cleveland);
        btn_cleveland.setBounds(210, 71, 85, 59);

        btn_dallas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_dallas_logo.gif"))); // NOI18N
        btn_dallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dallasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dallas);
        btn_dallas.setBounds(111, 71, 89, 59);

        btn_denver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_denver_logo.gif"))); // NOI18N
        btn_denver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_denverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_denver);
        btn_denver.setBounds(216, 259, 83, 59);

        btn_detroit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_detroit_logo.gif"))); // NOI18N
        btn_detroit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detroitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_detroit);
        btn_detroit.setBounds(317, 258, 90, 60);

        btn_indiana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_indiana_logo.gif"))); // NOI18N
        btn_indiana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_indianaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_indiana);
        btn_indiana.setBounds(110, 350, 90, 59);

        btn_huston.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_houston_logo.gif"))); // NOI18N
        btn_huston.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hustonActionPerformed(evt);
            }
        });
        getContentPane().add(btn_huston);
        btn_huston.setBounds(420, 70, 88, 59);

        btn_goldenState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_golden_state_logo.gif"))); // NOI18N
        btn_goldenState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goldenStateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_goldenState);
        btn_goldenState.setBounds(314, 71, 94, 59);

        btn_milwuakee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_milwaukee_logo.gif"))); // NOI18N
        btn_milwuakee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_milwuakeeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_milwuakee);
        btn_milwuakee.setBounds(224, 350, 80, 54);

        btn_minesota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_minnesota_logo.jpg"))); // NOI18N
        btn_minesota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minesotaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_minesota);
        btn_minesota.setBounds(530, 350, 91, 56);

        btn_miami.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_miami_logo.gif"))); // NOI18N
        btn_miami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_miamiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_miami);
        btn_miami.setBounds(426, 259, 78, 53);

        btn_memphis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_memphis_logo.gif"))); // NOI18N
        btn_memphis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_memphisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_memphis);
        btn_memphis.setBounds(220, 430, 83, 59);

        btn_clipppers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_los_angeles_clippers_logo.gif"))); // NOI18N
        btn_clipppers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clipppersActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clipppers);
        btn_clipppers.setBounds(111, 259, 87, 59);

        btn_lakers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_los_angeles_lakers_logo.gif"))); // NOI18N
        btn_lakers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lakersActionPerformed(evt);
            }
        });
        getContentPane().add(btn_lakers);
        btn_lakers.setBounds(18, 156, 83, 59);

        btn_thunder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_oklahoma_logo.gif"))); // NOI18N
        btn_thunder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thunderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_thunder);
        btn_thunder.setBounds(520, 70, 88, 59);

        btn_sacramento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_sacramento_logo.jpg"))); // NOI18N
        btn_sacramento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sacramentoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sacramento);
        btn_sacramento.setBounds(420, 350, 96, 59);

        btn_pheonix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_phoenix_logo.gif"))); // NOI18N
        btn_pheonix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pheonixActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pheonix);
        btn_pheonix.setBounds(423, 156, 81, 59);

        btn_orlando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_orlando_logo.gif"))); // NOI18N
        btn_orlando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orlandoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_orlando);
        btn_orlando.setBounds(20, 430, 85, 54);

        btn_knicks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_new_york_knick_logo.gif"))); // NOI18N
        btn_knicks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_knicksActionPerformed(evt);
            }
        });
        getContentPane().add(btn_knicks);
        btn_knicks.setBounds(318, 156, 87, 59);

        btn_pelicans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_new_orleans_logo.gif"))); // NOI18N
        btn_pelicans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pelicansActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pelicans);
        btn_pelicans.setBounds(510, 160, 102, 54);

        btn_philadelphia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_philadelphia_logo.gif"))); // NOI18N
        btn_philadelphia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_philadelphiaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_philadelphia);
        btn_philadelphia.setBounds(320, 430, 85, 59);

        btn_portland.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_portland_logo.gif"))); // NOI18N
        btn_portland.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_portlandActionPerformed(evt);
            }
        });
        getContentPane().add(btn_portland);
        btn_portland.setBounds(520, 260, 100, 56);

        btn_utah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_utah_logo.gif"))); // NOI18N
        btn_utah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_utahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_utah);
        btn_utah.setBounds(120, 430, 87, 53);

        btn_washington.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_washington_logo.gif"))); // NOI18N
        btn_washington.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_washingtonActionPerformed(evt);
            }
        });
        getContentPane().add(btn_washington);
        btn_washington.setBounds(530, 430, 84, 54);

        btn_spurs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_san_antonio_logo.gif"))); // NOI18N
        btn_spurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_spursActionPerformed(evt);
            }
        });
        getContentPane().add(btn_spurs);
        btn_spurs.setBounds(20, 350, 80, 59);

        btn_toronto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_toronto_logo.gif"))); // NOI18N
        btn_toronto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_torontoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_toronto);
        btn_toronto.setBounds(420, 430, 94, 59);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Atlanta Hawks");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(18, 136, 83, 14);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Boston Celtics");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(18, 324, 83, 14);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Brooklyn Nets");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(214, 221, 83, 14);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Charlotte Hornets");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(320, 410, 86, 14);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Chicago Bulls");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(119, 221, 85, 14);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cleveland Cavaliers");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 136, 102, 14);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dallas Mavericks");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(111, 136, 89, 14);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Denver Nuggets");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(214, 324, 87, 14);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Detroit Pistons");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(319, 324, 103, 14);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Golden-State Wariors");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(318, 136, 103, 14);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Oklahoma City Thunder");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(520, 140, 112, 14);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Indiana Pacers");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(110, 410, 95, 14);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Los Angeles Clippers");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(110, 324, 98, 14);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Los Angeles Lakers");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(18, 221, 91, 14);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Memphis Grizzlis");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(220, 490, 87, 14);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("New York Knicks");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(315, 221, 96, 14);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Huston Rockets");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(431, 136, 75, 14);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Pheonix Suns");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(426, 223, 95, 14);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Philadelphia 76ers");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(320, 490, 87, 14);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Utah Jazz");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(120, 490, 87, 14);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Toronto Raptors");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(420, 490, 83, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Orlando Magic");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(20, 490, 83, 14);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("San Antonio Spurs");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(10, 410, 98, 14);

        btn_charlotte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/rsz_charlotte_logo.gif"))); // NOI18N
        btn_charlotte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charlotteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_charlotte);
        btn_charlotte.setBounds(320, 350, 90, 54);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Minesota Timberwolves");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(530, 410, 111, 14);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("New Orleans Pelicans");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(520, 220, 102, 14);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Sacramento Kings");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(420, 410, 95, 14);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Miami Heat");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(428, 324, 76, 14);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Washington Wizzards");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(520, 490, 116, 14);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Milwuakee Bucks");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(220, 410, 86, 14);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Portland Trail-Blazer");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(510, 320, 105, 14);

        txt_qualified.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qualified.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qualifiedActionPerformed(evt);
            }
        });
        getContentPane().add(txt_qualified);
        txt_qualified.setBounds(667, 190, 270, 100);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 255));
        jLabel33.setText("Will Qualified...?");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(700, 130, 180, 50);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgfinal/project/bac.jpg"))); // NOI18N
        getContentPane().add(jLabel34);
        jLabel34.setBounds(0, 0, 1190, 570);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(660, 60, 0, 2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_atlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atlantaActionPerformed
        double i = 11;
        boolean boost = isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_atlantaActionPerformed
    
    private void btn_clevelandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clevelandActionPerformed
        
        double i = 6;
        boolean boost = isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_clevelandActionPerformed
    
    private void txt_qualifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qualifiedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qualifiedActionPerformed
    
    private void btn_lakersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lakersActionPerformed
        
        double i = 27;
        boolean boost = isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_lakersActionPerformed
    
    private void btn_bostonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bostonActionPerformed
        
        double i = 3;
        boolean boost = isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_bostonActionPerformed
    
    private void btn_spursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spursActionPerformed
        
        double i = 1;
        boolean boost = isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_spursActionPerformed
    
    private void btn_orlandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orlandoActionPerformed
        
        double i = 25;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_orlandoActionPerformed
    
    private void btn_dallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dallasActionPerformed
        
        double i = 21;
        boolean boost = isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_dallasActionPerformed
    
    private void btn_chicagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chicagoActionPerformed
        
        double i = 14;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_chicagoActionPerformed
    
    private void btn_clipppersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clipppersActionPerformed
        
        double i = 7;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_clipppersActionPerformed
    
    private void btn_indianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_indianaActionPerformed
        
        double i = 12;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        initComponents();
    }//GEN-LAST:event_btn_indianaActionPerformed
    
    private void btn_utahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_utahActionPerformed
        
        double i = 4;
        boolean boost = isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_utahActionPerformed
    
    private void btn_brooklynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_brooklynActionPerformed
        
        double i = 29;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_brooklynActionPerformed
    
    private void btn_denverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_denverActionPerformed
        
        double i = 17;
        boolean boost = isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_denverActionPerformed
    
    private void btn_milwuakeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_milwuakeeActionPerformed
        
        double i = 13;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_milwuakeeActionPerformed
    
    private void btn_memphisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_memphisActionPerformed
        
        double i = 10;
        boolean boost = isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_memphisActionPerformed
    
    private void btn_goldenStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goldenStateActionPerformed
        
        double i = 0;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_goldenStateActionPerformed
    
    private void btn_knicksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_knicksActionPerformed
        
        double i = 24;
        boolean boost = isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_knicksActionPerformed
    
    private void btn_detroitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detroitActionPerformed
        
        double i = 18;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_detroitActionPerformed
    
    private void btn_charlotteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charlotteActionPerformed
        
        double i = 19;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_charlotteActionPerformed
    
    private void btn_philadelphiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_philadelphiaActionPerformed
        
        double i = 26;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        //  initComponents();
    }//GEN-LAST:event_btn_philadelphiaActionPerformed
    
    private void btn_hustonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hustonActionPerformed
        
        double i = 2;
        boolean boost = isQuallified(i);
        choose(boost, i);
        /// initComponents();
    }//GEN-LAST:event_btn_hustonActionPerformed
    
    private void btn_pheonixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pheonixActionPerformed
        
        double i = 28;
        boolean boost = isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_pheonixActionPerformed
    
    private void btn_miamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_miamiActionPerformed
        
        double i = 16;
        boolean boost =   isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_miamiActionPerformed
    
    private void btn_sacramentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sacramentoActionPerformed
        
        double i = 22;
        boolean boost =   isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_sacramentoActionPerformed
    
    private void btn_torontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_torontoActionPerformed
        
        double i = 5;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_torontoActionPerformed
    
    private void btn_thunderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thunderActionPerformed
        
        double i = 9;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_thunderActionPerformed
    
    private void btn_pelicansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pelicansActionPerformed
        
        double i = 20;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_pelicansActionPerformed
    
    private void btn_portlandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_portlandActionPerformed
        
        double i = 15;
        boolean boost =   isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_portlandActionPerformed
    
    private void btn_minesotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minesotaActionPerformed
        
        double i = 23;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        // initComponents();
    }//GEN-LAST:event_btn_minesotaActionPerformed
    
    private void btn_washingtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_washingtonActionPerformed
        
        double i = 8;
        boolean boost =  isQuallified(i);
        choose(boost, i);
        //initComponents();
    }//GEN-LAST:event_btn_washingtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(FinalProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalProject().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atlanta;
    private javax.swing.JButton btn_boston;
    private javax.swing.JButton btn_brooklyn;
    private javax.swing.JButton btn_charlotte;
    private javax.swing.JButton btn_chicago;
    private javax.swing.JButton btn_cleveland;
    private javax.swing.JButton btn_clipppers;
    private javax.swing.JButton btn_dallas;
    private javax.swing.JButton btn_denver;
    private javax.swing.JButton btn_detroit;
    private javax.swing.JButton btn_goldenState;
    private javax.swing.JButton btn_huston;
    private javax.swing.JButton btn_indiana;
    private javax.swing.JButton btn_knicks;
    private javax.swing.JButton btn_lakers;
    private javax.swing.JButton btn_memphis;
    private javax.swing.JButton btn_miami;
    private javax.swing.JButton btn_milwuakee;
    private javax.swing.JButton btn_minesota;
    private javax.swing.JButton btn_orlando;
    private javax.swing.JButton btn_pelicans;
    private javax.swing.JButton btn_pheonix;
    private javax.swing.JButton btn_philadelphia;
    private javax.swing.JButton btn_portland;
    private javax.swing.JButton btn_sacramento;
    private javax.swing.JButton btn_spurs;
    private javax.swing.JButton btn_thunder;
    private javax.swing.JButton btn_toronto;
    private javax.swing.JButton btn_utah;
    private javax.swing.JButton btn_washington;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txt_qualified;
    // End of variables declaration//GEN-END:variables
    
}
