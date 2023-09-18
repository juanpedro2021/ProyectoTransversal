
import java.sql.Connection;
import java.time.LocalDate;
import ulp.AccesoADatos.AlumnoData;
import ulp.AccesoADatos.Conexion;
import ulp.AccesoADatos.MateriaData;
import ulp.Entidades.Alumno;
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
         
         
  //       Connection con=Conexion.getConexion();
       //creo un alumno
//           Alumno juan = new Alumno(111222333,"luna","pedro",LocalDate.of(1980, 4, 25),true);
//       AlumnoData alu= new AlumnoData();

//agergo un alumno
//
//        alu.guardarAlumno(juan);
//     
//   //  creo una materia
    Materia m1 = new Materia("matematica",2,true);

     MateriaData m2 = new MateriaData();
////agrego una materia
     m2.guardarMateria(m1);
////     
//
//         
     }

     }
