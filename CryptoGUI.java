/**
 *
 * @author edvina
 */
public class CryptoGUI extends javax.swing.JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form CryptoGUI
     */
  public CryptoGUI() {
    initComponents();
  }

  /**
   * This method surpresses compilation warnings for the initiation of the components
   * where each button, label and field is set out
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    textLabel = new javax.swing.JLabel();
    textField = new javax.swing.JTextField();
    shiftLabel = new javax.swing.JLabel();
    shiftField = new javax.swing.JTextField();
    encryptButton = new javax.swing.JButton();
    decryptButton = new javax.swing.JButton();
    resulttextLabel = new javax.swing.JLabel();
    resulttextField = new javax.swing.JTextField();
    messageLabel = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Caesar Cipher");

    textLabel.setText("Text:");

    shiftLabel.setText("Shift by:");

    shiftField.setToolTipText("Enter an integer value.");

    encryptButton.setFont(new java.awt.Font("Tahoma", 1, 14)); 
    encryptButton.setText("Encrypt");
    encryptButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        encryptButtonActionPerformed(evt);
      }
    });

    decryptButton.setFont(new java.awt.Font("Tahoma", 1, 14)); 
    decryptButton.setText("Decrypt");
    decryptButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        decryptButtonActionPerformed(evt);
      }
    });

    resulttextLabel.setText("Result:");

    resulttextField.setEditable(false);

    messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(encryptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(decryptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(textLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(textField))
          .addGroup(layout.createSequentialGroup()
            .addComponent(resulttextLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(resulttextField, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(shiftLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(shiftField)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(textLabel)
          .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(shiftLabel)
          .addComponent(shiftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(encryptButton)
        .addGap(18, 18, 18)
        .addComponent(decryptButton)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(resulttextLabel)
          .addComponent(resulttextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }
  
  private void encryptButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_encryptButtonActionPerformed
    try {
      //remove existing text
      resulttextField.setText("");
            
      //get the input message string
      String text = textField.getText();
      
      //get the shift value
      int shiftAmount = Integer.parseInt(shiftField.getText());
      
      //if either value is missing or not applicable, an error message, output area clearing, and stop will occur
      specialcharactercheck(text);
      
      //shift the message string to produce the encrypted string
      Cipher c = new Caesar(shiftAmount);
      String resulttext = c.encrypt(text);
      
      //output the encrypted string
      resulttextField.setText(resulttext);
      
    }

    
    catch(NumberFormatException nfe) {
      //not an integer
      messageLabel.setText("Please enter an integer value for the shift.");
    }
    catch(Exception e) {
      //special characters in the plaintext
      messageLabel.setText("Please enter a text message with no special characters.");
    }
  } //GEN-LAST:event_encryptButtonActionPerformed

  private void decryptButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_decryptButtonActionPerformed
    try {
      //remove existing text
      resulttextField.setText("");
            
      //get the input message string
      String text = textField.getText();
      
      //get the shift value
      int shiftAmount = Integer.parseInt(shiftField.getText());
      
      //if either value is missing or not applicable, an error message, output area clearing, and stop will occur
      specialcharactercheck(text);
      
      //shift the message string to produce the decrypted string
      Cipher c = new Caesar(shiftAmount);
      String resulttext = c.decrypt(text);
      
      //output the decrypted string
      resulttextField.setText(resulttext);
      
    }

    
    catch(NumberFormatException nfe) {
      //not an integer
      messageLabel.setText("Please enter an integer value for the shift.");
    }
    catch(Exception e) {
      //special characters in the plaintext
      messageLabel.setText("Please enter a text message with no special characters.");
    }
  }//GEN-LAST:event_decryptButtonActionPerformed
 
  /**
   * Throws an Exception if the String s contains any characters with ASCII value less than 32 or more than 126.
   * @param s String of any length
   * @throws Exception 
   */
  private void specialcharactercheck(String s) throws Exception {
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) < 32 || s.charAt(i) > 126) throw new Exception();
    }
  }
  

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(CryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(CryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(CryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(CryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new CryptoGUI().setVisible(true);
      }
    });
  }

  // Variables declaration 
  private javax.swing.JTextField resulttextField;
  private javax.swing.JLabel resulttextLabel;
  private javax.swing.JLabel messageLabel;
  private javax.swing.JTextField textField;
  private javax.swing.JLabel textLabel;
  private javax.swing.JButton encryptButton;
  private javax.swing.JButton decryptButton;
  private javax.swing.JTextField shiftField;
  private javax.swing.JLabel shiftLabel;
  // End of variables declaration
}
