package universidaddeejemplo.AccesoADatos;

//import universidadejemplo.Entidades.Alumno;
//VER ESTO
//import uunivesidadejemplo.Entidades;
import java.sql.Connection;
public class AlumnoData {
  
    
 private Connection con = null;

 public AlumnoData() {

 con = Conexion.getConexion();
}

public void guardarAlumno(Alumno alumno) {
    
    }
    
}
