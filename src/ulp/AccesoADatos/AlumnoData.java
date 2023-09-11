package ulp.AccesoADatos;

import ulp.Entidades.Alumno;
//import univesidadejemplo.Entidades.Alumno;

import java.sql.Connection;
public class AlumnoData {
  
    
 private Connection con = null;

 public AlumnoData() {

 con = Conexion.getConexion();
}

public void guardarAlumno(Alumno alumno) {
    
    }
    
}
