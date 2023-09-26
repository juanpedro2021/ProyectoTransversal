
package ulp.Vistas;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import ulp.AccesoADatos.AlumnoData;
import ulp.AccesoADatos.InscripcionData;
import ulp.Entidades.Alumno;
import ulp.Entidades.Inscripcion;
import ulp.Entidades.Materia;


public class CargaNotas extends javax.swing.JInternalFrame {

    
    private DefaultTableModel modelo;
    private List<Alumno> listaA;
   
    
    private AlumnoData alumData;
    private InscripcionData insData;
    
    public CargaNotas() {
        
        initComponents();
        alumData = new AlumnoData();
        listaA = alumData.listarAlumnos();
        insData = new InscripcionData();
//        listaM = insData.obtenerMateriasCursadas(WIDTH);
        modelo = new DefaultTableModel();
        
        cargarAlumnos();
        armarCabecera();
//         borrarFilas();
        cargarDatos();
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTInscripciones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSalir = new javax.swing.JButton();
        jGuardar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTInscripciones);

        jLabel2.setText("Seleccione un alumno:");

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        jGuardar.setText("Guardar");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jGuardar)
                        .addGap(48, 48, 48)
                        .addComponent(jSalir)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSalir)
                    .addComponent(jGuardar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        cargarDatos();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jSalirActionPerformed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> jComboBox1;
    private javax.swing.JButton jGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTInscripciones;
    // End of variables declaration//GEN-END:variables

    
    public boolean isCellEditable(int fila, int columna){
        if(columna==2){
            return true;
        }else{
            return false;
        }
    }
    private void armarCabecera(){
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jTInscripciones.setModel(modelo);
    }

    
    private void cargarAlumnos(){
        for(Alumno item:listaA){
            jComboBox1.addItem(item);
        }
    }
    
    private void borrarFilas(){
        int indice=modelo.getRowCount()-1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
  

    
    private void cargarDatos() { 
   
    //creo una inscripcion
        Inscripcion inscripcion = new Inscripcion();
        
        //creo unn alumno con lo que este seleccionado en el combo box
        Alumno alumno = (Alumno) jComboBox1.getSelectedItem();
        
         borrarFilas();
        //recorro las materias cursadas de ese alumno
        for (Materia mate1 : insData.obtenerMateriasCursadas(alumno.getIdAlumno())) {
            
            //recorro las incripciones que coincidan el id del alumno
            for (Inscripcion aux2 : insData.obtenerInscripcionesPorAlumno(alumno.getIdAlumno())) {
                
                //me fijo si las 2 materia son iguales 
                if (aux2.getMateria().getIdMateria() == mate1.getIdMateria()) {
                    
                    //agrego a la tabla el idmateria el nombre y la nota
                    modelo.addRow(new Object[]{
                        mate1.getIdMateria(),
                        mate1.getNombre(),
                        aux2.getNota(),});
                }
            }
        }
    }

    

}