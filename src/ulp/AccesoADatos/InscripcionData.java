/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ulp.Entidades.Inscripcion;

/**
 *
 * @author Gianfranco
 */
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

    //public List <Materia> obtenerMateriasCursadas(int id) {
//	
//	List<Materia> materias = new ArrayList<Materia>();
//	
//	try{
//		String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia WHERE inscripcion.idMateria = materia.idMateria\n AND inscripcion.idAlumno = ?;" ;
//		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//		ps.setInt(1, id);
//		ResultSet rs = ps.executeQuery();
//		Materia materia;
//
//		while (rs.next()) {
//			materia = new Materia();
//			materia.setIdMateria(rs.getInt("idMateria"));
//			materia.setNombre(rs.getString("nombre"));
//			materia.setAñoMateria(rs.getInt("año"));
//			materias.add(materia);
//		}
//		ps.close ();
//
//	 	} catch (SQLException ex) {
//			JOptionPane.showMessageDialog(null, "Error al obtener inscripciones"+ex.getMessage());
//		}
//		return materias;
//		}

public void actualizarNota(int idAlumno, int idMateria, double nota){
    
    String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno=? AND idMateria = ? ";
            try {
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setDouble(1, nota);
                ps.setInt(2, idAlumno);
                ps.setInt(3, idMateria);
                int filas=ps.executeUpdate();
                
                if(filas>0){
                   JOptionPane.showMessageDialog(null, "Nota actualizada");
                }
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            }
    
}


}
