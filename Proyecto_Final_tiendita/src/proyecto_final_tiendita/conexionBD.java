package proyecto_final_tiendita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*--> Sergio Eduardo Lastiri Torres - 22550031 <--*/

public class conexionBD
{
    //Declaracion de variables con usos especificos-//
    Connection conectar = null;                     //permite usar el driver de sql para la conexion con la base de datos
    PreparedStatement sentencia = null;             //PreparedStatement sirve para hacer la consulta de sql, o el uso del lenguaje del sql en general y poder ejecutarlo
    ResultSet resultado = null;                     //Permite regresar los datos obtenidos por la base de datos
    //----------------------------------------------//
    
    //Declaracion de un metodo publico para poder ser invocado en otro lugar dentro de las clases del proyecto.
    public conexionBD()
    {
        //Uso de try por que las sintaxis lo exige
        try
        {
            //Bloque de codigo de la conexion con la bse de datos-------------------------------------------------------------------------------------------------------//
            //La direccion de la base de datos junto con que driver utilizar para su conexion                                                                           //
            String url = "jdbc:ucanaccess://C:/Users/sergi/Documents/NetBeansProjects/Proyecto_Final_tiendita/src/BD/Proyecto_Final_BaseDeDatos_Tiendita.accdb";        //
            //Uso del driver y la variable conectar para realizar la conexion                                                                                           //
            conectar = DriverManager.getConnection(url);                                                                                                                //
            //Se utiliza un joptionpane para decirle al usuario que la base de datos esta conectada con el programa                                                     //
            JOptionPane.showMessageDialog(null, "conexion exitosa con base de datos");                                                                                  //
            //----------------------------------------------------------------------------------------------------------------------------------------------------------// 
        /*
            Aqui iba el bloque del codigo del query
        */
        } 
        catch (Exception e)
        {
            //Bloque de codigo en caso de que no se halla podido establecer conexion con la base de datos y manda a imprimir un codigo explicando porque. --//
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos, error: "+e);                                                       //
            System.out.println(e);                                                                                                                          //
            System.exit(0);                                                                                                                                 //
            //----------------------------------------------------------------------------------------------------------------------------------------------//
        }
    }
}

