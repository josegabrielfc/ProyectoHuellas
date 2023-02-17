import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import static java.awt.image.ImageObserver.ERROR;
import javax.swing.JOptionPane;
import java.io.OutputStream;
import java.io.InputStream;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class JFrame_Sensor extends javax.swing.JFrame {

    //VARIABLES QUE PERMITEN ESTABLER LOS PARAMETROS DEL PUERTO 
    //Y CONEXION DEL MISMO
    SerialPort My_PuertoSerie;
    String PUERTO_IdName;
    private static final int TIMEOUT=2000; //Milisegundos
    private static final int BAUD_RATE=57600; 
    //VARIABLES QUE CAPTURAN Y ENVIA LOS DATOS SERIALES
    private OutputStream output=null;
    private InputStream input_str=null;
    //PERMITE BUSCAR Y ENUMERAR TODOS LOS PUERTOS DISPONIBLES
    java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
    
    //DENTRO DE LA PARTE DE INICIALIZACION TAMBIEN SE PUEDEN ASIGNAR
    //VALORES INICIALES PARA LOS CONTROLES
    public JFrame_Sensor() {
        initComponents();
        jBtnConectar.setEnabled(false);
        jBtnDesconectar.setEnabled(false);    
        this.setLocationRelativeTo(this); //Acomoda la ventana en el centro
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnBuscar = new javax.swing.JButton();
        jBtnConectar = new javax.swing.JButton();
        jBtnDesconectar = new javax.swing.JButton();
        jCbxPuertos = new javax.swing.JComboBox<>();
        jTxtRecibir = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtArea = new javax.swing.JTextArea();
        jBtnEnrolar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalirDetec = new javax.swing.JButton();
        jBtnDetectar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jBtnEnrolOK = new javax.swing.JButton();
        jBtnDeleteOK = new javax.swing.JButton();
        jBtnBorrarTodo = new javax.swing.JButton();
        jBtnCleanText = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBtnBuscar.setText("BUSCAR PUERTOS");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jBtnConectar.setText("CONECTAR");
        jBtnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConectarActionPerformed(evt);
            }
        });

        jBtnDesconectar.setText("DESCONECTAR");
        jBtnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDesconectarActionPerformed(evt);
            }
        });

        jTxtArea.setColumns(20);
        jTxtArea.setRows(5);
        jScrollPane1.setViewportView(jTxtArea);

        jBtnEnrolar.setText("ENROLAR");
        jBtnEnrolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEnrolarActionPerformed(evt);
            }
        });

        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnSalirDetec.setText("SALIR DETECCION");
        jBtnSalirDetec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirDetecActionPerformed(evt);
            }
        });

        jBtnDetectar.setText("DETECTAR");
        jBtnDetectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDetectarActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        jLabel4.setText("ID");

        jTextField2.setName("TxtEnrolar"); // NOI18N

        jTextField3.setName("TxtEliminar"); // NOI18N

        jBtnEnrolOK.setText("ACEPTAR");
        jBtnEnrolOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEnrolOKActionPerformed(evt);
            }
        });

        jBtnDeleteOK.setText("ACEPTAR");
        jBtnDeleteOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteOKActionPerformed(evt);
            }
        });

        jBtnBorrarTodo.setText("BORRAR TODO");
        jBtnBorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBorrarTodoActionPerformed(evt);
            }
        });

        jBtnCleanText.setText("LIMPIAR");
        jBtnCleanText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCleanTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnBorrarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jBtnEnrolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnDetectar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jBtnEnrolOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBtnDeleteOK, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jBtnSalirDetec, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCleanText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jTxtRecibir)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCbxPuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnBuscar)
                    .addComponent(jCbxPuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnConectar)
                    .addComponent(jBtnDesconectar))
                .addGap(18, 18, 18)
                .addComponent(jTxtRecibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnEnrolar)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnEnrolOK))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnEliminar)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnDeleteOK))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnDetectar)
                            .addComponent(jBtnSalirDetec))
                        .addGap(19, 19, 19)
                        .addComponent(jBtnBorrarTodo))
                    .addComponent(jBtnCleanText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        while ( portEnum.hasMoreElements() )
        {
            jBtnConectar.setEnabled(true);
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            String Mensajes = portIdentifier.getName()  +  " - " +  getPortTypeName(portIdentifier.getPortType()) ;
            String NombrePuertos = portIdentifier.getName();
            jTxtArea.append(Mensajes + "\n");
            jCbxPuertos.addItem(NombrePuertos);
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConectarActionPerformed
        CommPortIdentifier puertoID = null;
        java.util.Enumeration<CommPortIdentifier> listaPuertos = CommPortIdentifier.getPortIdentifiers();

        while(listaPuertos.hasMoreElements() )
        {
            CommPortIdentifier actualPuertoID=(CommPortIdentifier) listaPuertos.nextElement();
            PUERTO_IdName = jCbxPuertos.getSelectedItem().toString();
            if(PUERTO_IdName.equals(actualPuertoID.getName())){ puertoID=actualPuertoID;break;}
        }

        if(puertoID==null){
            mostrarError("No se puede conectar al puerto");
            System.exit(ERROR);
        }

        try{
            My_PuertoSerie = (SerialPort) puertoID.open(this.getClass().getName(), TIMEOUT);
            My_PuertoSerie.setSerialPortParams(BAUD_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            input_str = My_PuertoSerie.getInputStream();
            output = My_PuertoSerie.getOutputStream();
            My_PuertoSerie.addEventListener(new SerialReader(input_str));
            My_PuertoSerie.notifyOnDataAvailable(true);

            jBtnConectar.setEnabled(false);
            jBtnDesconectar.setEnabled(true);
        } catch(Exception e){
            mostrarError(e.getMessage());
            System.exit(ERROR);
        }
    }//GEN-LAST:event_jBtnConectarActionPerformed

    private void jBtnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDesconectarActionPerformed
        try{
            My_PuertoSerie.close();
            jBtnConectar.setEnabled(true);
            jBtnDesconectar.setEnabled(false);
           
        } catch(Exception e){
            mostrarError(e.getMessage());
            System.exit(ERROR);
        }
    }//GEN-LAST:event_jBtnDesconectarActionPerformed

    private void jBtnEnrolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEnrolarActionPerformed
        enviarDatos("E");        
    }//GEN-LAST:event_jBtnEnrolarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        enviarDatos("D");        
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnSalirDetecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirDetecActionPerformed
        // SALIR DETECCION
        enviarDatos("X");       
    }//GEN-LAST:event_jBtnSalirDetecActionPerformed

    private void jBtnDetectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDetectarActionPerformed
        enviarDatos("H");         
    }//GEN-LAST:event_jBtnDetectarActionPerformed

    private void jBtnEnrolOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEnrolOKActionPerformed
        // ACEPTAR ENROLAMIEMTO
        String IdEnrolar=jTextField2.getText();   
        enviarDatos(IdEnrolar);
        enviarDatos("\n");     
    }//GEN-LAST:event_jBtnEnrolOKActionPerformed

    private void jBtnDeleteOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteOKActionPerformed
        // ACEPTAR ELIMINAR     
        String IdEliminar=jTextField3.getText(); 
        enviarDatos(IdEliminar);
        enviarDatos("\n");      
    }//GEN-LAST:event_jBtnDeleteOKActionPerformed

    private void jBtnBorrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBorrarTodoActionPerformed
         enviarDatos("B"); // BORRAR TODO   
    }//GEN-LAST:event_jBtnBorrarTodoActionPerformed

    private void jBtnCleanTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCleanTextActionPerformed
        // TODO add your handling code here:
        
        jTxtArea.selectAll();
        jTxtArea.replaceSelection("");


    }//GEN-LAST:event_jBtnCleanTextActionPerformed

//--------------------------------------------------------------------------
//--------------------------------------------------------------------------
//--------------------------------------------------------------------------
    private void enviarDatos(String datos){
        try{
            output.write(datos.getBytes());
        } catch(Exception e){
            mostrarError(e.getMessage()); 
            System.exit(ERROR);
        }
    }
    
    static String getPortTypeName ( int portType )
    {
        switch ( portType )
        {          
            case CommPortIdentifier.PORT_SERIAL:
                return "Serial";
            default:
                return "unknown type";
        }
    }
    
    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public  class SerialReader implements SerialPortEventListener 
    {
        private InputStream in;
        private byte[] buffer = new byte[1024];
        private StringBuffer cadena = new StringBuffer();
        private String cadena_aux;
        
        public SerialReader ( InputStream in ){ this.in  =  in; }
        
        public void serialEvent(SerialPortEvent arg0) {
            int data;
          
            try
            {
                cadena_aux="";
                
                int len = 0;
                while ( ( data = in.read()) > -1 )
                {
                    // El carácter de nueva línea (\n) es equivalente al 
                    // carácter de salto de línea ASCII (hex 0A)
                    
                    if ( data == '\n' ) {
                    //if ( data == '&' ) {//Determina que carater se considera como uno final del mensaje.
                        break;
                    }
                    buffer[len++] = (byte) data;             
                    cadena = cadena.append((char) data);
                }
                
                cadena_aux = cadena.toString();  
                
                jTxtRecibir.setText("");
                jTxtRecibir.setText(cadena.toString()); 
                
                jTxtArea.append(cadena_aux+"\n");      
                cadena.delete(0, cadena.length());
                
                //A PARTIR DE AQUI ES NECESARIO UTILIZAR LAS VARIABLES
                //cadena_aux  => como string - pues es la unica variable que contiene los valores que ingresaron
                //buffer[x] = Contiene los datos en una matriz
                
                //int posicion = cadena_aux.indexOf("ID#1");
                 //jTextField1.setText(Integer.toString(posicion));
                 
                if (cadena_aux.indexOf("ID#1")==0) 
                {
                 jTxtRecibir.setText("");
                 jTxtRecibir.setText("INGRESO USUARIO 1");                
                }
                
                if (cadena_aux.indexOf("ID#2")==0) 
                {
                 jTxtRecibir.setText("");
                 jTxtRecibir.setText("INGRESO USUARIO 2");                
                }
                
                 if (cadena_aux.indexOf("ID#3")==0) 
                {
                 jTxtRecibir.setText("");
                 jTxtRecibir.setText("INGRESO USUARIO 3");                
                }
            }
            catch ( Exception e )
            {
                mostrarError(e.getMessage());           
            }             
        }
    }
     
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
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
            java.util.logging.Logger.getLogger(JFrame_Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Sensor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBorrarTodo;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnCleanText;
    private javax.swing.JButton jBtnConectar;
    private javax.swing.JButton jBtnDeleteOK;
    private javax.swing.JButton jBtnDesconectar;
    private javax.swing.JButton jBtnDetectar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnEnrolOK;
    private javax.swing.JButton jBtnEnrolar;
    private javax.swing.JButton jBtnSalirDetec;
    private javax.swing.JComboBox<String> jCbxPuertos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextArea jTxtArea;
    private javax.swing.JTextField jTxtRecibir;
    // End of variables declaration//GEN-END:variables
}
