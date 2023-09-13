
package ulp.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ulp.Entidades.Alumno;
import ulp.Entidades.Inscripcion;
import ulp.Entidades.Materia;


public class InscripcionData {
 
    private Connection con = null;

     //contructor
public InscripcionData(){
 con = Conexion.getConexion();
 }
public void guardarInscripcion(Inscripcion ins){
 
    String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria)"
            + " VALUES (?,?,?)";
         try {
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
             //pido los datos a el objeto INSCRIPCION **ins**
             
             ps.setDouble(1, ins.getNota());
             ps.setInt(2,ins.getAlumno().getIdAlumno());
             ps.setInt(3, ins.getMateria().getIdMateria());
             
             ps.executeUpdate();
             
             ResultSet rs = ps.getGeneratedKeys();
             
                  if (rs.next()) {
                    ins.setIdInscripcion(rs.getInt(1));
                        JOptionPane.showMessageDialog(null, "incripcion agregada con exito"); 
       }             
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion"+ex.getMessage()); 

         }
}
 
         
    public List<Materia> obtenerMateriasCursadas(int id){
	
	List<Materia> materias = new ArrayList<>();
	
        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?;" ;
        
	try{		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Materia materia;

		while (rs.next()) {
			materia = new Materia();
			materia.setIdMateria(rs.getInt("idMateria"));
			materia.setNombre(rs.getString("nombre"));
			materia.setAñoMateria(rs.getInt("año"));			materias.add(materia);
		}
		ps.close ();

	 	} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al obtener inscripciones"+ex.getMessage());
		}
		return materias;
		}


}
