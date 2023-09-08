
package universidaddeejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="universidadulp";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    
    private static Connection connection;
    
    //contructor
    private Conexion(){}
    
    //metodo getConection
    
    public static Connection getConexion(){
        try{
        if (connection==null) {
            Class.forName("org.maridb.jdbc.Driver");
            //creo la conexion con la base de datos
            
            connection = DriverManager.getConnection(URL+DB + 
                    "?useLegacyDatetimecode=false&serverTimezone-UTC"+ "&user=" 
                    + USUARIO + "&password=" + PASSWORD) ;
        }
        } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "error a cargar driver = " + ex.getLocalizedMessage());
            
        } catch (SQLException co) {
            JOptionPane.showMessageDialog(null, "error de coneccion = " + co.getLocalizedMessage());
            
        }
        
        return connection;
    }
}
