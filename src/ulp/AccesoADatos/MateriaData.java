
package ulp.AccesoADatos;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ulp.Entidades.Materia;


public class MateriaData {
    private Connection con = null;
	
	public MateriaData(){

	con = Conexion.getConexion();
        }

 


//public class MateriaData() {
//	private Connection con = null;
//	
//	public MateriaData(){
//
//	con = Conexion.getConexion();
//        }
        
        

public void guardarMateria (Materia materia) {
	
	String sql = "INSERT INTO materia (nombre, añoMateria, activo) VALUES (?, ?, ?)";
	try {
		PreparedStatement ps = con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, materia.getNombre());
		ps.setInt(2, materia.getAñoMateria());
		ps.setBoolean(3, materia.isActivo());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()){
			materia.setIdMateria(rs.getInt("idMateria"));
		JOptionPane.showMessageDialog(null, "Materia añadida con éxito");
		}
		ps.close();
		} catch (SQLException ex){
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
		}
		}


public Materia buscarMateria(int id){
	Materia materia = null;
	String sql = "SELECT nombre, añoMateria FROM materia WHERE idMateria = ? AND activo = 1";
	PreparedStatement ps = null;
	try {
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()){
		materia=new Materia();
		materia.setIdMateria(id);
                materia.setNombre("nombre");
		materia.setAñoMateria(rs.getInt("añoMateria"));
		materia.setActivo(true);
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe la materia");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
		}
		return materia;
		}

public void modificarMateria (Materia materia) {
	
	String sql = "UPDATE materia SET nombre=?,año=?,estado= ? WHERE idMateria=?";
	PreparedStatement ps = null;

	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, materia.getNombre());
		ps.setInt(2, materia.getAñoMateria());
		ps.setBoolean(3, materia.isActivo());
              

              
		int exito = ps.executeUpdate();

		if (exito == 1) {
		
		JOptionPane.showMessageDialog(null, "Modificada exitosamente");
		} else {
		JOptionPane.showMessageDialog(null, "La materia no existe");
		}
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
		}

}

}



