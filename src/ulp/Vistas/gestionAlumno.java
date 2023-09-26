
package ulp.Vistas;

import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import ulp.AccesoADatos.AlumnoData;
import ulp.Entidades.Alumno;

/*
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo33.accesoADatos.AlumnoData
*/

public class gestionAlumno extends javax.swing.JInternalFrame {


    public gestionAlumno() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Ldocumento = new javax.swing.JTextField();
        BuscarAlu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Lapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Lnombre = new javax.swing.JTextField();
        bEstado = new javax.swing.JRadioButton();
        bLimpiar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        Bsalir = new javax.swing.JButton();
        fechaN = new com.toedter.calendar.JDateChooser();

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Alumno");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Documento:");

        BuscarAlu.setText("Buscar");
        BuscarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarAluActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Estado:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Fecha de Nacimento");

        bLimpiar.setText("limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        Bsalir.setText("Salir");
        Bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Ldocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Lapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addComponent(BuscarAlu)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bEstado)
                                            .addComponent(Lnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(bEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(bGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(Bsalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(fechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 26, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BuscarAlu)
                        .addComponent(Ldocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Lapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Lnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(bEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bLimpiar)
                            .addComponent(bEliminar)
                            .addComponent(bGuardar)
                            .addComponent(Bsalir))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarAluActionPerformed
        
        AlumnoData alu= new AlumnoData();
        
        
        int buscar = Integer.parseInt(Ldocumento.getText());
        if( alu != null){
        Alumno encontrado = alu.buscarAlumnoPorDni(buscar);
        
        
        
        Lapellido.setText(encontrado.getApellido());
        
        Lnombre.setText(encontrado.getNombre());
        
        bEstado.setSelected(encontrado.isActivo());
        
        
        LocalDate fechaNacLocalDate = encontrado.getFechaNac();
        Date fechaNacDate = Date.from(fechaNacLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        fechaN.setDate(fechaNacDate);
        
    }

    }//GEN-LAST:event_BuscarAluActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
       
    }//GEN-LAST:event_jTextField4ActionPerformed

    
    private void BsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsalirActionPerformed
        limpiar();
        this.dispose();
        
    }//GEN-LAST:event_BsalirActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        
        //creo un alumno donde voy guardando
        Alumno alumnoG= new Alumno();
        
        // y agrego toda la info que esta en lo grafico
        int dniN = parseInt(Ldocumento.getText());
        alumnoG.setDni(dniN);
        alumnoG.setApellido(Lapellido.getText());
        alumnoG.setNombre(Lnombre.getText());
        
        //  agrrego el estado
        
        if(bEstado.isSelected()!=false){
            
            alumnoG.setActivo(true);
        }else{
            alumnoG.setActivo(false);
        }
    
        //agrego fecha nacimiento
        
        LocalDate fechaG = fechaN.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        alumnoG.setFechaNac(fechaG);
  
        //llamo a la funcion de alumnoData para subir ese alumno a la base de  datos
        AlumnoData alu = new AlumnoData();
        alu.guardarAlumno(alumnoG);
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
//creo un alumnoData

AlumnoData alu= new AlumnoData();
        
        //veo si el lumno no esta vacio
        
        if(alu != null){
            
        //guardo el dni en una variable
        
        int dni = parseInt(Ldocumento.getText());
        Alumno b = new Alumno();
        //agarro ese dni y lo pongo en burcar  alumno para saber cul es el id
        
        b=alu.buscarAlumnoPorDni(dni);
        int id =0;
        
        //obtengo el id y lo guardo
        
       id =  b.getIdAlumno();
        //le paso a eliminar el id del alumno
        alu.eliminarAlumno(id);
        limpiar();
        } else {
             JOptionPane.showMessageDialog(null, " no hay alumno a eliminar");
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        Ldocumento.setText("");
        Lapellido.setText("");
        Lnombre.setText("");
        bEstado.setSelected(false);
    }//GEN-LAST:event_bLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bsalir;
    private javax.swing.JButton BuscarAlu;
    private javax.swing.JTextField Lapellido;
    private javax.swing.JTextField Ldocumento;
    private javax.swing.JTextField Lnombre;
    private javax.swing.JButton bEliminar;
    private javax.swing.JRadioButton bEstado;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bLimpiar;
    private com.toedter.calendar.JDateChooser fechaN;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

private void limpiar (){
    
    Ldocumento.setText("");
    Lapellido.setText("");
    Lnombre.setText("");
    bEstado.setSelected(false);
    
}

}
