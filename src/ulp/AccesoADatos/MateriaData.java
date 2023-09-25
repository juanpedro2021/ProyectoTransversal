
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

	//creo el constructor

	public MateriaData(){

	con = Conexion.getConexion();
    }
   

public void guardarMateria (Materia materia) {
	
	String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?, ?, ?)";
	try {
		PreparedStatement ps = con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, materia.getNombre());
		ps.setInt(2, materia.getAñoMateria());
		ps.setBoolean(3, materia.isActivo());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()){
			materia.setIdMateria(rs.getInt(1));
		JOptionPane.showMessageDialog(null, "Materia añadida con éxito");
		}
		ps.close();
		} catch (SQLException ex){
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
		}
		}


public Materia buscarMateria(int id){
	Materia materia = null;
	String sql = "SELECT nombre, año FROM materia WHERE idMateria = ? AND estado = 1";
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
	

	try {
		PreparedStatement ps = con.prepareStatement(sql);
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

    public void eliminarMateria(int id){
         
         String sql ="update Materia set estado =0 where idMateria=?";
     try {
         
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       
         
         ps.setInt(1, id);
         
         int exito =ps.executeUpdate();
         
           if (exito ==1){
        JOptionPane.showMessageDialog(null, "Materia borrada"); 
    }
     } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "erro al acceder a la tabla materia"); 
     }
 
     }
    
    public List<Materia> listarMaterias(){
 
    String sql ="SELECT `idMateria`, `nombre`, `año`, `estado` FROM `materia` WHERE  estado=1";
    
    ArrayList<Materia> materias = new ArrayList<>();
         
     try {

         PreparedStatement ps = con.prepareStatement(sql);
                      
         ResultSet rs =ps.executeQuery();
         while (rs.next()) {
             
       Materia materia = new Materia();
           materia.setIdMateria(rs.getInt("id"));
           materia.setNombre((rs.getString("nombre")));
           materia.setAñoMateria(rs.getInt("año"));
           materia.setActivo(true);
           
          materias.add(materia);
         }
         ps.close();
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno"); 
     }
     return materias;
     
 }
}


