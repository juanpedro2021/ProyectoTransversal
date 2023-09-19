
import java.sql.Connection;
import java.time.LocalDate;
import ulp.AccesoADatos.AlumnoData;
import ulp.AccesoADatos.Conexion;
import ulp.AccesoADatos.InscripcionData;
import ulp.AccesoADatos.MateriaData;
import ulp.Entidades.Alumno;
import ulp.Entidades.Inscripcion;
import ulp.Entidades.Materia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gianfranco
 */
public class Main {
     public static void main(String[] args) {
      AlumnoData ad=new AlumnoData();
      MateriaData md=new MateriaData();
      InscripcionData id=new InscripcionData();
      
      Alumno encontrado= ad.buscarAlumnoPorDni(11888888);
     }

     }
