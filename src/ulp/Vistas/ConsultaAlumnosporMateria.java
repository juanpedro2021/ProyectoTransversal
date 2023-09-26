package ulp.Vistas;

import javax.swing.table.DefaultTableModel;

import ulp.Entidades.Alumno;
import ulp.Entidades.Materia;

public class ConsultaAlumnosporMateria extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public ConsultaAlumnosporMateria() {
        initComponents();
        armarCabecera();
        cargarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbListaMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaAlumnos = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Listado de alumnos por materia");

        jLabel2.setText("Seleccione una materia:");

        jcbListaMaterias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbListaMateriasItemStateChanged(evt);
            }
        });
        jcbListaMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbListaMateriasActionPerformed(evt);
            }
        });

        jtListaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtListaAlumnos);

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbListaMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbListaMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbListaMateriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbListaMateriasItemStateChanged


    }//GEN-LAST:event_jcbListaMateriasItemStateChanged

    private void jcbListaMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbListaMateriasActionPerformed
        borraFilas();
        String[] comboBox = jcbListaMaterias.getSelectedItem().toString().split(",");
        int codigo = Integer.parseInt(comboBox[1].trim());
        for (Alumno alumno : MenuPrincipal.inscripciondata.obtenerAlumnosXMateria(codigo)) {
            modelo.addRow(new Object[]{
                alumno.getIdAlumno(),
                alumno.getDni(),
                alumno.getApellido(),
                alumno.getNombre(),});
        }
    }//GEN-LAST:event_jcbListaMateriasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbListaMaterias;
    private javax.swing.JTable jtListaAlumnos;
    // End of variables declaration//GEN-END:variables

    public void cargarComboBox() {
        for (Materia materia : MenuPrincipal.materiadata.listarMaterias()) {
            jcbListaMaterias.addItem(materia.getNombre() + ", " + materia.getIdMateria() + ", " + materia.getAnio());
        }
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        jtListaAlumnos.setModel(modelo);
    }

    private void borraFilas() {
        int f = jtListaAlumnos.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
}