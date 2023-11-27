/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_final_tiendita;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JButton;
import javax.swing.JOptionPane;

/*--> Sergio Eduardo Lastiri Torres - 22550031 <--*/
public class frmPrincipal extends javax.swing.JFrame {

    //Constructor para poder mandar a llamar a las variables locales del metodo de conexionBD
    conexionBD BD = new conexionBD();//Se agrega aqui para que este disponible localmente, si se agrega en algun otro metodo, solo estara disponible dentro de ese mismo metodo
    frmBD frmbd = new frmBD();
    //frmPrincipal frmPrin = new frmPrincipal();

    String cadena = null;    //Almacena los datos refinados de la base de datos en un variable string compatible con netbeans (Parte del query)
    String nombre;
    String cantidad;
    String compName;

    //querySQL----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public String querySQL() {
        try {
            //Bloque de codigo del query------------------------------------------------------------------------------------------------------------//
            //Consulta de sql para recibir los datos----------------------------------------//                                                      //
            String consulta = "SELECT descripcion , inventario ,prc_costo FROM inventario_smartmart WHERE inventario >= 1"; //                                                      //
            PreparedStatement preparedStatement = BD.conectar.prepareStatement(consulta);   //                                                      //
            BD.resultado = preparedStatement.executeQuery();                                //                                                      //
            //------------------------------------------------------------------------------//                                                      //        
            //Refina los datos recibidos y los almacena en la variable datos                                                                        //
            StringBuilder datos = new StringBuilder();                                                                                              //            
            //Se necesita un while para poder leer los datos, ya que solo daria un solo resultado ----------------------------------------------//  //
            while (BD.resultado.next()) //  //
            {                                                                                                                                   //  //
                //Este bloque de codigo sirve para poder leer y acomodar los datos.---------------------------------------------//              //  //
                nombre = BD.resultado.getString("descripcion");                                                                     //              //  //
                cantidad = BD.resultado.getString("inventario");                                                                      //              //  //
                String precio = BD.resultado.getString("prc_Costo");                                                               //              //  //
                datos.append(nombre).append("\t").append(" - ").append(cantidad).append(" :  $").append(precio).append("\n");   //              //  //  \t es para para poner un "TAB".
                //--------------------------------------------------------------------------------------------------------------//              //  //  \N es para saltar una linea.
            }                                                                                                                                   //  //
            //----------------------------------------------------------------------------------------------------------------------------------//  //
            //----------------------------------------------------------------------------------//                                                  //
            //Finalmente convierte los datos refinados en un String local para su uso general.  //                                                  //
            cadena = datos.toString();                                                          //                                                  //
            return cadena;                                                                      //                                                  //
            //----------------------------------------------------------------------------------//                                                  //
            //--------------------------------------------------------------------------------------------------------------------------------------//
        } catch (SQLException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //querySQL----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //queryCantidadSQL----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public String queryCantidadSQL() {
        try {
            //Bloque de codigo del query------------------------------------------------------------------------------------------------------------//
            //Consulta de sql para recibir los datos----------------------------------------//                                                      //
            String consulta = "SELECT inventario FROM inventario_smartmart WHERE descripcion = '" + compName + "'"; //                                                      //
            PreparedStatement preparedStatement = BD.conectar.prepareStatement(consulta);   //                                                      //
            BD.resultado = preparedStatement.executeQuery();                                //                                                      //
            //------------------------------------------------------------------------------//                                                      //        
            //Refina los datos recibidos y los almacena en la variable datos                                                                        //
            StringBuilder datos = new StringBuilder();                                                                                              //            
            //Se necesita un while para poder leer los datos, ya que solo daria un solo resultado ----------------------------------------------//  //
            while (BD.resultado.next()) //  //
            {                                                                                                                                   //  //
                //Este bloque de codigo sirve para poder leer y acomodar los datos.---------------------------------------------//              //  //
                cantidad = BD.resultado.getString("inventario");                                                                      //              //  //
                //--------------------------------------------------------------------------------------------------------------//              //  //  \N es para saltar una linea.
            }                                                                                                                                   //  //
            //----------------------------------------------------------------------------------------------------------------------------------//  //
            //----------------------------------------------------------------------------------//                                                  //
            //Finalmente convierte los datos refinados en un String local para su uso general.  //                                                  //
            cadena = datos.toString();                                                          //                                                  //
            //System.out.println("cantidad: " + cantidad);
            return cantidad;                                                                      //                                                  //
            //----------------------------------------------------------------------------------//                                                  //
            //--------------------------------------------------------------------------------------------------------------------------------------//
        } catch (SQLException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //queryCantidadSQL----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //updateSQL---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public String updateSQL() {
        //Bloque de codigo para editar la base de datos-------------------------------------------------------------------------------------------------------------------------------------//
        try //
        {                                                                                                                                                                                   //
            //Bloque de codigo del Update-------------------------------------------------------------------//                                                                              //
            String editar = "UPDATE inventario_smartmart SET inventario = inventario - 1 WHERE descripcion = '" + compName + "' AND inventario >= 1"; //Aqui es en donde se establece que celda (o que objeto) va a ser "vendido",    //
            BD.sentencia = BD.conectar.prepareStatement(editar);                                            //asi que elimina directamente de la cantidad que hay                           //                                                                                                     //                                                                                              //
            BD.sentencia.executeUpdate();                                                                   //                                                                              //
            //----------------------------------------------------------------------------------------------//                                                                              //
            querySQL();                                                                                                                                                                     //
            txaInventario.setText(cadena);                                                                                                                                                  //
            return cadena;                                                                                                                                                                  //
        } //
        catch (Exception e) //
        {                                                                                                                                                                                   //
            System.out.println(e);                                                                                                                                                          //
            return null;                                                                                                                                                                    //
        }                                                                                                                                                                                   //
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
        //}
    }
    //updateSQL---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public frmPrincipal() {
        initComponents();
        querySQL();
        //Se asignan los valores de la base de datos en el text area
        txaInventario.setText(cadena);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaInventario = new javax.swing.JTextArea();
        btnPanini = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuInventario = new javax.swing.JMenu();
        mnuBtnConInv = new javax.swing.JMenu();
        mnuBtnEditInv = new javax.swing.JMenu();
        mnuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Inventario");

        txaInventario.setColumns(20);
        txaInventario.setRows(5);
        jScrollPane1.setViewportView(txaInventario);

        btnPanini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panini.jpg"))); // NOI18N
        btnPanini.setText("Panini");
        btnPanini.setBorderPainted(false);
        btnPanini.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPanini.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panini.jpg"))); // NOI18N
        btnPanini.setFocusCycleRoot(true);
        btnPanini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaniniMouseClicked(evt);
            }
        });

        mnuInventario.setText("Inventario");

        mnuBtnConInv.setText("Consultar Inventario");
        mnuBtnConInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuBtnConInvMouseClicked(evt);
            }
        });
        mnuInventario.add(mnuBtnConInv);

        mnuBtnEditInv.setText("Editar Inventario");
        mnuInventario.add(mnuBtnEditInv);

        jMenuBar1.add(mnuInventario);

        mnuExit.setText("Salir");
        mnuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuExitMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(593, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(258, 258, 258)
                    .addComponent(btnPanini)
                    .addContainerGap(437, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(btnPanini)
                    .addContainerGap(297, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaniniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaniniMouseClicked
        compName = this.btnPanini.getText();
        if (queryCantidadSQL().equals("0")) {
            btnPanini.setEnabled(false);
            JOptionPane.showMessageDialog(null, "No quedan mas " + compName);
        } else {
            updateSQL();
        }
    }//GEN-LAST:event_btnPaniniMouseClicked

    private void mnuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuExitMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Seguro que quiere salir?") == 0)
            dispose();
    }//GEN-LAST:event_mnuExitMouseClicked

    private void mnuBtnConInvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuBtnConInvMouseClicked
        this.setEnabled(false);
        frmbd.setVisible(true);
        
        frmbd.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            // Volver a habilitar el formulario principal cuando se cierre el formulario secundario
            frmPrincipal.this.setEnabled(true);
        }
    });
    }//GEN-LAST:event_mnuBtnConInvMouseClicked

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPanini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuBtnConInv;
    private javax.swing.JMenu mnuBtnEditInv;
    private javax.swing.JMenu mnuExit;
    private javax.swing.JMenu mnuInventario;
    private javax.swing.JTextArea txaInventario;
    // End of variables declaration//GEN-END:variables
}
