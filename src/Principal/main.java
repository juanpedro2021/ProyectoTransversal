package Principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ulp.AccesoADatos.AlumnoData;
import ulp.AccesoADatos.InscripcionData;
import ulp.AccesoADatos.MateriaData;
import ulp.Entidades.Alumno;
import ulp.Entidades.Inscripcion;
import ulp.Entidades.Materia;


public class main {

   
    public static void main(String[] args) {
        
       // Alumno juan = new Alumno(11222335,"luna","pedro",LocalDate.of(1980, 4, 25),true);
        //AlumnoData alu= new AlumnoData();
//       alu.guardarAlumno(juan);
////      
////      
//      Materia m1 = new Materia("matematica",2,true);
//      MateriaData m2 = new MateriaData();
//     m2.guardarMateria(m1);
////      
////     
////     
//      Inscripcion ins = new Inscripcion(juan,m1,9.5);
//      
//      InscripcionData ins1 = new InscripcionData();
//      
//      ins1.guardarInscripcion(ins);
//      
     // Alumno alumnoEn = alu.buscarAlumno(14);
      
      //  System.out.println(""+ alumnoEn.toString());

//
//AlumnoData ad = new AlumnoData();
//MateriaData md = new MateriaData();
//InscripcionData insd = new InscripcionData(); 
//
//Alumno messi = ad.buscarAlumno(14);
//Materia mate = md.buscarMateria(25);
//
//Inscripcion ins = new Inscripcion( messi, mate, 9);
//     
//insd.guardarInscripcion(ins);
////insd.actualizarNota(14, 25, 5);
////insd.eliminarInscripcion(14, 25);
//     
//
//        System.out.println(""+ messi.toString());

//****************pruebo el metodo listarAlumnos*********
InscripcionData alu= new InscripcionData();

//for(Alumno alumno:alu.listarAlumnos() ){
//
//    System.out.println(alumno.getDni());
//    
//    System.out.println(alumno.getApellido());
//    
//    System.out.println(alumno.getNombre());
//    
//    System.out.println(alumno.getFechaNac());
//    
    alu.actualizarNota(8, 28, 1.0);
    

}




    }

