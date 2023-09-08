package universidadejemplo.AccesoADatos;

import universidadejemplo.Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ArrayList;
import java.sql.List;
import javax.swing.JOptionPane;

public class AlumnoData {

  private Connection con = null;

public AlumnoData() {

            con = Conexion.getConexion();
