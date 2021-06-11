/*
 * Wie Theseus rekursiv ins Labyrinth geht, und dank Ariadnes Faden (der Rekursion) wieder hinausfindet...
 * mkr, 30.09.2010
 */

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Point;
/*
 * LabyrinthRekursiv.java
 *
 * Created on 07.12.2009, 20:57:02
 */

/**
 *
 * @author mkr
 */
public class LabyrinthRekursiv extends javax.swing.JFrame {

    public void initCanvas(Graphics2D g) {
        // coord.setLocation(150, 60);
        g.translate(10, 30);
        g.drawLine(0, 0, 310, 0);
        g.drawLine(0, 0, 0, 260);
        g.drawLine(0, 260, 310, 260);
        g.drawLine(310, 0, 310, 260);
        g.setColor(Color.blue);
        g.fillRect(143, 32, 4, 5);
        g.setColor(Color.red);
        g.setColor(Color.black);
        coord.setLocation(150, 60);
    }

    public void drawLabEl(Graphics2D g, int ind) {
        String st = coord.toString();
        g.translate(Integer.valueOf(st.substring(st.indexOf("=") + 1, st.lastIndexOf(","))).intValue(), Integer.valueOf(st.substring(st.lastIndexOf("=") + 1, st.lastIndexOf("]"))).intValue());
        if (ind == 0) { // Geradeaus
            g.drawLine(0, 0, 0, 10);
            g.drawLine(10, 0, 10, 10);
            coord.translate(0, 10);
            LabInt[SchrittN] = 0;
            SchrittN++;
        } else if (ind == 1) { // Links
            g.drawLine(0, 0, 0, 10);
            g.drawLine(0, 10, 10, 10);
            g.drawLine(10, 0, 20, 0);
            g.drawLine(20, 0, 20, 10);
            coord.translate(10, 10);
            LabInt[SchrittN] = 1;
            SchrittN++;
        } else if (ind == 2) { // Rechts
            g.drawLine(10, 0, 10, 10);
            g.drawLine(0, 10, 10, 10);
            g.drawLine(-10, 0, -10, 10);
            g.drawLine(0, 0, -10, 0);
            coord.translate(-10, 10);
            LabInt[SchrittN] = 2;
            SchrittN++;
        } else if (ind == 3) { // Minotaurus
            g.setColor(Color.black);
            g.drawLine(0, 0, 0, 10);
            g.drawLine(10, 0, 10, 10);
            g.drawLine(10, 10, 0, 10);
            BasicStroke bs = new BasicStroke(3);
            g.setStroke(bs);
            g.setColor(Color.ORANGE);
            g.drawLine(2, 2, 8, 8);
            g.drawLine(8, 2, 2, 8);
            bs = new BasicStroke(1);
            g.setStroke(bs);
            coord.translate(0, 10);
            LabInt[SchrittN] = 3;
            SchrittN++;
        }
    }

    public int GeheSchrittZurück(int w, int s, Graphics2D g) {
        // System.out.println("Gehe "+w+". Schritt zurück...");
        String st = coord.toString();
        g.translate(Integer.valueOf(st.substring(st.indexOf("=") + 1, st.lastIndexOf(","))).intValue(), Integer.valueOf(st.substring(st.lastIndexOf("=") + 1, st.lastIndexOf("]"))).intValue());
        warte();
        if (w == 0) { // Geradeaus
            g.translate(10, -30);
            g.setColor(Color.white);
            g.drawArc(141, 40, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(141, 30, 8, 8, 0, 360);
            coord.translate(0, -10);
        } else if (w == 1) { // Links
            g.translate(20, -30);
            g.setColor(Color.white);
            g.drawArc(131, 40, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(131, 31, 8, 8, 0, 360);
            warte();
            g.setColor(Color.white);
            g.drawArc(131, 31, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(121, 30, 8, 8, 0, 360);
            coord.translate(-10, -10);
        } else if (w == 2) { // Rechts
            g.translate(0, -30);
            g.setColor(Color.white);
            g.drawArc(151, 40, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(151, 31, 8, 8, 0, 360);
            warte();
            g.setColor(Color.white);
            g.drawArc(151, 31, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(161, 30, 8, 8, 0, 360);
            coord.translate(10, -10);
        }
        s--;
        return s;
    }

    public int GeheSchrittVoran(int w, int s, Graphics2D g) {
        // System.out.println("Gehe "+w+". Schritt voran...");
        String st = coord.toString();
        g.translate(Integer.valueOf(st.substring(st.indexOf("=") + 1, st.lastIndexOf(","))).intValue(), Integer.valueOf(st.substring(st.lastIndexOf("=") + 1, st.lastIndexOf("]"))).intValue());
        s++;
        warte();
        if (w == 0) { // Geradeaus
            g.translate(10, 30);
            g.setColor(Color.white);
            g.drawArc(141, 30, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(141, 40, 8, 8, 0, 360);
            coord.translate(0, 10);
        } else if (w == 1) { // Links
            g.translate(20, 30);
            g.setColor(Color.white);
            g.drawArc(131, 30, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(141, 31, 8, 8, 0, 360);
            warte();
            g.setColor(Color.white);
            g.drawArc(141, 31, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(141, 40, 8, 8, 0, 360);
            coord.translate(10, 10);
        } else if (w == 2) { // Rechts
            g.translate(0, 30);
            g.setColor(Color.white);
            g.drawArc(151, 30, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(141, 31, 8, 8, 0, 360);
            warte();
            g.setColor(Color.white);
            g.drawArc(141, 31, 8, 8, 0, 360);
            g.setColor(Color.red);
            g.drawArc(141, 40, 8, 8, 0, 360);
            coord.translate(-10, 10);
        }
        return s;
    }

    public synchronized int BeobachteWeg(int n) {
        int Weg = getLabElem(n);
        return Weg;
    }

    public void TheseusStarten() {
        mitSchwarzemSegelGenKreta((Graphics2D)this.getGraphics());
        ImmerAnDerWandLang(SchrittN, (Graphics2D)this.getGraphics());
        mitWeissemSegelGenNaxos((Graphics2D)this.getGraphics());
    }

    public synchronized int ImmerAnDerWandLang(int SchrittN, Graphics2D g) {
        int Weg = BeobachteWeg(SchrittN);
        if (Weg == 3) {
            Kaempfe((Graphics2D)this.getGraphics());
        } else {
            SchrittN = GeheSchrittVoran(Weg, SchrittN, (Graphics2D)this.getGraphics());
            ImmerAnDerWandLang(SchrittN, (Graphics2D)this.getGraphics());
            // @SEE: Die entscheidende Zeile...: Dies ist Ariadnes Faden.
            SchrittN = GeheSchrittZurück(Weg, SchrittN, (Graphics2D)this.getGraphics());         
        }
        return SchrittN;
    }

    public void Kaempfe(Graphics2D g) {
        warte();
        g.drawString("Theseus fährt vor Kreta vor.", 0, 0);
        g.setColor(Color.black);
        coord.translate(0, 50);
        g.drawString("Der Minotaurus ist gefunden, Theseus kämpft ...", 15, 285);
        warte();
        warte();
    }

    public void mitWeissemSegelGenNaxos(Graphics2D g) {
        coord.setLocation(0, 0);
        g.translate(10, 30);
        warte();
        g.setColor(Color.black);
        g.drawString("Theseus verläßt Kreta gen Naxos, mit Ariadne und weißem Segel.", 5, 300);
    }

    public void warte() {
        try {
            java.lang.Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("Fehler!");
        }
    }

    public void mitSchwarzemSegelGenKreta(Graphics2D g) {
        g.translate(10, 30);
        g.setColor(Color.red);
        g.drawArc(141, 30, 8, 8, 0, 360);
        warte();
        g.setColor(Color.black);
        g.drawString("Theseus fährt vor Kreta vor, schwarzes Segel.", 10, 15);
        coord.setLocation(0, 0);
    }

    public synchronized int getLabElem(int e) {
        e = LabInt[e]++;
        return e;
    }

    Point coord = new Point(0, 0);
    static int[] LabInt = new int[300];
    int SchrittN = 0;


    /** Creates new form LabyrinthRekursiv */
    public LabyrinthRekursiv() {
        initComponents();
        coord.setLocation(150, 60);
        // initCanvas((Graphics2D)this.getGraphics());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Canvas = new javax.swing.JPanel();
        KnopfPanel = new javax.swing.JPanel();
        Auswahl = new javax.swing.JComboBox();
        TheseusButton = new javax.swing.JButton();
        NeuButton = new javax.swing.JButton();
        EndeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rekursiver Labyrinthgang, mkr, 1.1");

        Canvas.setBackground(new java.awt.Color(255, 255, 255));
        Canvas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Canvas.setAlignmentX(1.0F);
        Canvas.setAlignmentY(1.0F);
        Canvas.setMinimumSize(new java.awt.Dimension(140, 80));
        Canvas.setLayout(new java.awt.BorderLayout());
        getContentPane().add(Canvas, java.awt.BorderLayout.CENTER);

        Auswahl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geradeaus", "Rechts", "Links", "Minotaurus" }));
        Auswahl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuswahlActionPerformed(evt);
            }
        });
        KnopfPanel.add(Auswahl);

        TheseusButton.setText("Theseus starten");
        TheseusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TheseusButtonActionPerformed(evt);
            }
        });
        KnopfPanel.add(TheseusButton);

        NeuButton.setText("Reset Lab");
        NeuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NeuButtonActionPerformed(evt);
            }
        });
        KnopfPanel.add(NeuButton);

        EndeButton.setText("Ende");
        EndeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndeButtonActionPerformed(evt);
            }
        });
        KnopfPanel.add(EndeButton);

        jLabel1.setText("jLabel1");
        KnopfPanel.add(jLabel1);

        getContentPane().add(KnopfPanel, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(498, 400));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TheseusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TheseusButtonActionPerformed
        SchrittN = 0;
        TheseusStarten();
    }//GEN-LAST:event_TheseusButtonActionPerformed

    private void NeuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeuButtonActionPerformed
        LabInt = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        repaint();
        coord.setLocation(150, 60);
    }//GEN-LAST:event_NeuButtonActionPerformed

    private void AuswahlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuswahlActionPerformed
        drawLabEl((Graphics2D)this.getGraphics(), Auswahl.getSelectedIndex());
    }//GEN-LAST:event_AuswahlActionPerformed

    private void EndeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndeButtonActionPerformed
        System.exit(0);
}//GEN-LAST:event_EndeButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LabyrinthRekursiv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Auswahl;
    private javax.swing.JPanel Canvas;
    private javax.swing.JButton EndeButton;
    private javax.swing.JPanel KnopfPanel;
    private javax.swing.JButton NeuButton;
    private javax.swing.JButton TheseusButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    //--- Create the Graphics2D object
    Graphics2D g2d = (Graphics2D)this.getGraphics();
}
