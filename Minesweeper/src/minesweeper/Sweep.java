
package minesweeper;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Sweep extends javax.swing.JFrame {
    /*
    -1: has a bomb
    0: not open
    1 - 8: number of bombs
    */
    final int wid = 9, hei = 9, noOfBombs = 10;
    JToggleButton[][] blocks = new JToggleButton[hei][wid];
    int[][] blox = new int[hei][wid];
    boolean firstGame = false;
    
    
    ActionListener listen = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int i = 0, j = 0;
            boolean found = false;
            for(i = 0; i < hei; i++){
                for(j = 0; j < wid; j++){
                    if(e.getSource() == blocks[i][j]){
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
            blocks[i][j].setSelected(true);
            if(!firstGame){
                spawn(i, j);
                firstGame = true;
            }
        }
    };
    
    
    
    public Sweep() {
        initComponents();
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                blocks[i][j] = new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
                blocks[i][j].addActionListener(listen);
            }
        }
    }

    private void spawn(int x, int y){
        for(int k = 1; k <= noOfBombs; k++){
           int i, j;
            do{
                i = (int)(Math.random()*(wid-0.01));
                j = (int)(Math.random()*(hei-0.01));
            }
            while(blox[i][j] == -1 && i == y && j == x);
             blox[i][j] = -1;
             blocks[i][j].setText("Bomb");
        }
    };
    
    
    private void resize(){
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        resize();
    }//GEN-LAST:event_jPanel1ComponentResized

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sweep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
