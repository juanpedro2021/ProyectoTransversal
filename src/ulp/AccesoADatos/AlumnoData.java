package ulp.AccesoADatos;

import ulp.Entidades.Alumno;
//import univesidadejemplo.Entidades.Alumno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class AlumnoData {
	private Connection con = null;
	
	public AlumnoData(){

	con = Conexion.getConexion();
        }
public void guardarAlumno (Alumno alumno) {
	
	String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
	try {
		PreparedStatement ps = con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, alumno.getDni());
		ps.setString(2, alumno.getApellido());
		ps.setString(3, alumno.getNombre());
		ps.setDate(4, Date.valueOf(alumno.getFechaNac()));//localDate a Date
		ps.setBoolean(5, alumno.isActivo());//if reducido
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()){
			alumno.setIdAlumno(rs.getInt("idAlumno"));
		JOptionPane.showMessageDialog(null, "Alumno añadido con éxito");
		}
		ps.close();
		} catch (SQLException ex){
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
		}
		}

public Alumno buscarAlumno(int id){//Video 5 Mercado. 0.10
	Alumno alumno = null;
	String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
	PreparatedStatement ps = null;
	try {
		ps = (PreparatedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next) {
		alumno=new Alumno();//acá uso el construct vacío de Alumno
		alumno.setIdAlumno(id);
		alumno.setDni(rs.getInt("dni"));
		alumno.setApellido(rs.getString("apellido"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
		alumno.setActivo(true); // en 7.25 explica esto
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe el alumno");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
		}
		return alumno;
		}

    private static class PreparatedStatement {

        public PreparatedStatement() {
        }

        private ResultSet executeQuery() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void close() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setInt(int i, int id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

  public Alumno buscarAlumnoPorDni(int dni){ //Video 5 Mercado 12.00
	Alumno alumno = null;
	String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";
	PreparatedStatement ps = null;
	try {
		ps = (PreparatedStatement) con.prepareStatement(sql);
		ps.setInt(1, dni);

		ResultSet rs = ps.executeQuery();

		if (rs.next) {
		alumno=new Alumno();
		alumno.setIdAlumno(rs.getInt("idAlumno"));
		alumno.setDni(rs.getInt("dni"));
		alumno.setApellido(rs.getString("apellido"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
		alumno.setActivo(true);
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe el alumno");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
		}
		return alumno;
		}  
    
    
}



