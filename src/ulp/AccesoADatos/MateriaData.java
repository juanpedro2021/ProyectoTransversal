
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


public class MateriaData {
	private Connection con = null;
	
	public MateriaData(){

	con = Conexion.getConexion();
        }

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
}

}



