import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guruh Nurdiyansyah GA
 */
public class UasRobot extends javax.swing.JFrame {   
private volatile boolean stopAnimasi = false;
int trans =0;
int xdefault=180;
private volatile String warnaRobot= "WARNA DEFAULT";
private volatile Color warnaAbu = Color.gray;
private volatile Color gradient1= Color.gray;
private volatile Color gradient2 =Color.gray;
int a=150, b=185, c=225, d=238, e=251,  i=1, x,y,z=0;

@Override
public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2d=(Graphics2D)g;
    g.translate(trans,0);
    g.setColor(Color.RED);
    g.drawString(warnaRobot,xdefault,60);
    g.setColor(warnaAbu);
    GradientPaint gradien = new GradientPaint(0, 10,gradient1, 25, 25,gradient2, true);
    g2d.setPaint(gradien);

    //BADAN
    g.fillRect (190,150,80,140);
    
    //TANGAN KIRI 
    int[] x4={190,150,190  };
    int[] y4={a,b,b };
    Polygon tangankiri=new Polygon(x4,y4,3);
    g.fillPolygon(tangankiri);             
    int[] x5={154,150,187,182  };
    int[] y5={b,c,c,b };
    Polygon lengankiri=new Polygon(x5,y5,4);
    g.fillPolygon(lengankiri);
    int[] x6={154,146,154,162  };
    int[] y6={c,d,e,d };
    Polygon lengankirijari1=new Polygon(x6,y6,4);
    int[] x7={179,171,179,187  };
    int[] y7={c,d,e,d };
    Polygon lengankirijari2=new Polygon(x7,y7,4);
     
    // TANGAN KANAN
    int[] x8={270,310,270  };
    Polygon tangankanan=new Polygon(x8,y4,3);
    g.fillPolygon(tangankanan);
    int[] x9={276,272,309,304  };
    Polygon lengankanan=new Polygon(x9,y5,4);
    g.fillPolygon(lengankanan);     
    int[] x10={282,274,282,290  };
    Polygon lengankananjari1=new Polygon(x10,y6,4);     
    int[] x11={305,297,305,313  };
    Polygon lengankananjari2=new Polygon(x11,y7,4);     
  
    g.setColor(Color.black);
    g.drawPolygon(tangankiri);
    g.drawPolygon(lengankiri);
    g.fillPolygon(lengankirijari1);
    g.fillPolygon(lengankirijari2);
    g.drawPolygon(tangankanan);
    g.drawPolygon(lengankanan);
    g.fillPolygon(lengankananjari1);
    g.fillPolygon(lengankananjari2);
    g.drawRect (190,150,80,140);
    
    //KEPALA
    g.setColor(Color.magenta);
    g.fillRect(205,100,50,50);
    
    //TANDUK
    g.setColor(Color.black);   
    int[] x={189,197,205,255,263,271  };
    int[] y={150,80,150,150,80,150   };
    Polygon tanduk=new Polygon(x,y,6);
    g.fillPolygon(tanduk);
    
    // MATA
    g.setColor(Color.black);
    g.fillOval(214, 110, 13, 13);
    g.fillOval(235, 110, 13, 13);
        
    // LAMPU DADA 
    g.drawOval(234,155,11,11);
    g.drawOval(246,155,11,11);
    g.drawOval(258,155,11,11);
    g.setColor (Color.green);
    g.fillOval(234,155,11,11);
    g.setColor (Color.yellow);
    g.fillOval(246,155,11,11);
    g.setColor (Color.red);
    g.fillOval(258,155,11,11);
    
    //DADA
    g.setColor(Color.white);
    int[] x3={230,245,238,223,215  };
    int[] y3={190,200,217,217,201  };
    Polygon dada=new Polygon(x3,y3,5);
    g.fillPolygon(dada);
   
    //RODA
    g.setColor (Color.black);
    g.fillArc(205,260,50,60,0,-180);
    g.setColor (Color.gray); 
    g.fillArc(216,274,28,34,0,-180);
}
class AnimasiRunnable implements Runnable{
    private Thread runner;
    public AnimasiRunnable(){
    runner=new Thread(this);
    runner.start();
    }  
    
    @Override
    public void run(){
        while (!stopAnimasi){
            repaint();
            if (a>254)
                i=-1;
            else if (a<150)
                i=1;
                a+=i;
                b+=i;
                c+=i;
                d+=i;
                e+=i;
               
                try{
                Thread.sleep(30);
            }catch (Exception e){}
            }
        }
    }
public void requestStop() {
  stopAnimasi = true;
}
public void gantiwarnabiru(Graphics g){
   trans=0;
    xdefault=195;
   warnaRobot="WARNA ORANGE";
   warnaAbu = Color.orange;
   gradient1=Color.orange;
   gradient2=Color.orange;
   paint (getGraphics());
}
public void gantiwarnagradien(Graphics g){
    trans=0;
    xdefault= 180;
    warnaRobot= "WARNA CAMPURAN";
    gradient1=Color.green;
    gradient2=Color.orange;
    paint(getGraphics());
 }
public void translasi(Graphics g){
    super.paint(g);
    Graphics2D g2d=(Graphics2D)g;
    paint(getGraphics());
    trans=170;
    g.translate(trans,0);
    g.setColor(Color.RED);
    g.drawString("DUPLICATION",xdefault,60);
    g.setColor(warnaAbu);
    GradientPaint gradien = new GradientPaint(0, 10,gradient1, 25, 25,gradient2, true);
    g2d.setPaint(gradien);
   
    //BADAN
    g.fillRect (190,150,80,140);
    
    //TANGAN KIRI 
    int[] x4={190,150,190  };
    int[] y4={a,b,b };
    Polygon tangankiri=new Polygon(x4,y4,3);
    g.fillPolygon(tangankiri);             
    int[] x5={154,150,187,182  };
    int[] y5={b,c,c,b };
    Polygon lengankiri=new Polygon(x5,y5,4);
    g.fillPolygon(lengankiri);
    int[] x6={154,146,154,162  };
    int[] y6={c,d,e,d };
    Polygon lengankirijari1=new Polygon(x6,y6,4);
    int[] x7={179,171,179,187  };
    int[] y7={c,d,e,d };
    Polygon lengankirijari2=new Polygon(x7,y7,4);
     
    // TANGAN KANAN
    int[] x8={270,310,270  };
    Polygon tangankanan=new Polygon(x8,y4,3);
    g.fillPolygon(tangankanan);
    int[] x9={276,272,309,304  };
    Polygon lengankanan=new Polygon(x9,y5,4);
    g.fillPolygon(lengankanan);     
    int[] x10={282,274,282,290  };
    Polygon lengankananjari1=new Polygon(x10,y6,4);     
    int[] x11={305,297,305,313  };
    Polygon lengankananjari2=new Polygon(x11,y7,4);     
  
    g.setColor(Color.black);
    g.drawPolygon(tangankiri);
    g.drawPolygon(lengankiri);
    g.fillPolygon(lengankirijari1);
    g.fillPolygon(lengankirijari2);
    g.drawPolygon(tangankanan);
    g.drawPolygon(lengankanan);
    g.fillPolygon(lengankananjari1);
    g.fillPolygon(lengankananjari2);
    g.drawRect (190,150,80,140);
    
    //KEPALA
    g.setColor(Color.magenta);
    g.fillRect(205,100,50,50);
    
    //TANDUK
    g.setColor(Color.black);   
    int[] x={189,197,205,255,263,271  };
    int[] y={150,80,150,150,80,150   };
    Polygon tanduk=new Polygon(x,y,6);
    g.fillPolygon(tanduk);
        
    // MATA
    g.setColor(Color.black);
    g.fillOval(214, 110, 13, 13);
    g.fillOval(235, 110, 13, 13);
        
    // LAMPU DADA 
    g.drawOval(234,155,11,11);
    g.drawOval(246,155,11,11);
    g.drawOval(258,155,11,11);
    g.setColor (Color.green);
    g.fillOval(234,155,11,11);
    g.setColor (Color.yellow);
    g.fillOval(246,155,11,11);
    g.setColor (Color.red);
    g.fillOval(258,155,11,11);
    
    //DADA
    g.setColor(Color.white);
    int[] x3={230,245,238,223,215  };
    int[] y3={190,200,217,217,201  };
    Polygon dada=new Polygon(x3,y3,5);
    g.fillPolygon(dada);
    
    //RODA 
    g.setColor (Color.black); 
    g.fillArc(205,260,50,60,0,-180);
    g.setColor (Color.gray); 
    g.fillArc(216,274,28,34,0,-180);
    }
    /**
     * Creates new form UasRobot
     */
    public UasRobot() {
        initComponents();      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAS Komputer Grafik 1");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("A");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("C");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("GURUH_NURDIYANSYAH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(341, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>                        
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        x++;
               if(x==1){ 
        translasi(getGraphics());      
               }
               else if(x==2){
                   trans=0;
                   paint (getGraphics());
                   x=0;
               }else{
                   
               }           
    }                                        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
       
        y++;
           if (y==1){
                trans=0;
                new AnimasiRunnable();
           }
           else if (y==2){
               trans=0;
              requestStop();
               paint(getGraphics());
              stopAnimasi =false; 
           }  else if(y==3){
               trans=0;
              a=150;
             b=185;
             c=225;
             d=238; 
              e=251;
               paint(getGraphics());
              y=0;
           }
    }                                        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         z++;
         if (z==1){
             gantiwarnabiru(getGraphics());
         }
         else if(z==2) {
             gantiwarnagradien(getGraphics());
             }
         else {
             trans=0;
             xdefault=180;
             warnaRobot= "WARNA DEFAULT";
             gradient1=Color.gray;
             gradient2=Color.gray;
             warnaAbu= Color.gray;
             paint(getGraphics());
             z=0;
         }
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
            java.util.logging.Logger.getLogger(UasRobot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UasRobot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UasRobot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UasRobot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UasRobot().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration                   
}
  java.util.logging.Logger.getLogger(UasRobot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UasRobot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UasRobot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UasRobot().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JB