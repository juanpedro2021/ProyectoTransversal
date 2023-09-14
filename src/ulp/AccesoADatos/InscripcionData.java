
package ulp.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ulp.Entidades.Alumno;
import ulp.Entidades.Inscripcion;
import ulp.Entidades.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    // contructor
    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion ins) {

        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // pido los datos a el objeto INSCRIPCION **ins**

            ps.setDouble(1, ins.getNota());
            ps.setInt(2, ins.getAlumno().getIdAlumno());
            ps.setInt(3, ins.getMateria().getIdMateria());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ins.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "incripcion agregada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + ex.getMessage());

        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
                ins.setAlumno(alu);
                ins.setMateria(mat);
                ins.setNota(rs.getDouble("nota"));
                inscripciones.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
                ins.setAlumno(alu);
                ins.setMateria(mat);
                ins.setNota(rs.getDouble("nota"));
                inscripciones.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + ex.getMessage());
        }
        return inscripciones;
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) { // video 6 minuto 21.55

        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno=? AND idMateria = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Materia> obtenerMateriasCursadas(int id) {

        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?;";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;

            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAñoMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones" + ex.getMessage());
        }
        return materias;
    }

    public void eliminarInscripcion(int idAlumno, int idMateria) {

        String sql = "delete from inscripcion where idAlumno =? and idMateria=?";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "inscripcion  borrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro al acceder a la tabla inscripcion");
        }

    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnosMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno, dni, nombre, apellido, FechaNacimiento, estado "
                + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";

        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return alumnosMateria;

    }

}

    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
                ins.setAlumno(alu);
                ins.setMateria(mat);
                ins.setNota(rs.getDouble("nota"));
                inscripciones.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
                ins.setAlumno(alu);
                ins.setMateria(mat);
                ins.setNota(rs.getDouble("nota"));
                inscripciones.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + ex.getMessage());
        }
        return inscripciones;
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) { // video 6 minuto 21.55

        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno=? AND idMateria = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Materia> obtenerMateriasCursadas(int id) {

        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?;";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;

            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAñoMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones" + ex.getMessage());
        }
        return materias;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlumno){
	
	ArrayList<Materia> materias = new ArrayList<>();
	
        String sql = "SELECT * FROM materia WHERE activo = 1 AND idMateria not in (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        
	try{		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, idAlumno);
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

    public void borrarInscripcionMateriaAlumno(int idAlumno,int idMateria){
         
         String sql ="delete from inscripcion where idAlumno =? and idMateria=?";
     try {
         
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       
         
         ps.setInt(1, idAlumno);
         ps.setInt(2, idMateria);
         
         int filas=ps.executeUpdate();
         
           if (filas>0){
        JOptionPane.showMessageDialog(null, "inscripcion  borrada"); 
    }

}
