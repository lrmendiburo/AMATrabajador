/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

/**
 *
 * @author lrmendiburo
 */
public class VentanaDJ05 extends javax.swing.JFrame {

    /**
     * Creates new form VentanaDJ05
     */
    public VentanaDJ05() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jComboBoxOficina = new javax.swing.JComboBox<>();
        jButtonEliminar = new javax.swing.JButton();
        jLabelMes = new javax.swing.JLabel();
        jComboBoxMes = new javax.swing.JComboBox<>();
        jLabelMes1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCR09 = new javax.swing.JTable();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuEstructura = new javax.swing.JMenu();
        jMenuItemOficinas = new javax.swing.JMenuItem();
        jMenuItemTrabajadores = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuOperacionServiciosAsAt = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemDJ08 = new javax.swing.JMenuItem();
        jMenuItemCR09 = new javax.swing.JMenuItem();
        jMenuItemDJ05 = new javax.swing.JMenuItem();
        jMenuItemTramite = new javax.swing.JMenuItem();
        jMenuItemOfimatica = new javax.swing.JMenuItem();
        jMenuItemOtro = new javax.swing.JMenuItem();
        jMenuItemGasto = new javax.swing.JMenuItem();
        jMenuItemServicio = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuClientes = new javax.swing.JMenu();
        jMenuItemClienteTitular = new javax.swing.JMenuItem();
        jMenuItemClienteContratado = new javax.swing.JMenuItem();
        jMenuGeneral = new javax.swing.JMenu();
        jMenuItemGenerarListado = new javax.swing.JMenuItem();
        jMenuItemGeneralResumen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(824, 464));
        setResizable(false);
        setSize(new java.awt.Dimension(824, 464));

        jButtonAdicionar.setText("Adicionar");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("DJ05");

        jButtonEditar.setText("Editar");

        jComboBoxOficina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Playa", "Redondel", "Marianao" }));

        jButtonEliminar.setText("Eliminar");

        jLabelMes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelMes.setText("Oficina:");

        jComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabelMes1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelMes1.setText("Mes:");

        jTableCR09.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Concepto", "Monto", "Mes", "Fecha", "Nota", "Oficina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCR09);

        jMenuEstructura.setText("Estructura");

        jMenuItemOficinas.setText("Oficinas");
        jMenuEstructura.add(jMenuItemOficinas);

        jMenuItemTrabajadores.setText("Trabajadores");
        jMenuEstructura.add(jMenuItemTrabajadores);

        jMenuItemUsuarios.setText("Usuarios");
        jMenuEstructura.add(jMenuItemUsuarios);

        jMenuBarPrincipal.add(jMenuEstructura);

        jMenuOperacionServiciosAsAt.setText("Operación");

        jMenu1.setText("Ingreso");

        jMenuItemDJ08.setText("DJ08");
        jMenu1.add(jMenuItemDJ08);

        jMenuItemCR09.setText("CR09");
        jMenu1.add(jMenuItemCR09);

        jMenuItemDJ05.setText("DJ05");
        jMenu1.add(jMenuItemDJ05);

        jMenuItemTramite.setText("Trámite");
        jMenu1.add(jMenuItemTramite);

        jMenuItemOfimatica.setText("Ofímatica");
        jMenu1.add(jMenuItemOfimatica);

        jMenuItemOtro.setText("Otro");
        jMenu1.add(jMenuItemOtro);

        jMenuOperacionServiciosAsAt.add(jMenu1);

        jMenuItemGasto.setText("Gasto");
        jMenuOperacionServiciosAsAt.add(jMenuItemGasto);

        jMenuItemServicio.setText("Servicio");
        jMenuOperacionServiciosAsAt.add(jMenuItemServicio);

        jMenuItem1.setText("Servicios Ad/At");
        jMenuOperacionServiciosAsAt.add(jMenuItem1);

        jMenuBarPrincipal.add(jMenuOperacionServiciosAsAt);

        jMenuClientes.setText("Clientes");

        jMenuItemClienteTitular.setText("Cliente Titular");
        jMenuClientes.add(jMenuItemClienteTitular);

        jMenuItemClienteContratado.setText("Cliente Contratado");
        jMenuClientes.add(jMenuItemClienteContratado);

        jMenuBarPrincipal.add(jMenuClientes);

        jMenuGeneral.setText("General");

        jMenuItemGenerarListado.setText("Generar Listado");
        jMenuGeneral.add(jMenuItemGenerarListado);

        jMenuItemGeneralResumen.setText("Generar Resumen");
        jMenuGeneral.add(jMenuItemGeneralResumen);

        jMenuBarPrincipal.add(jMenuGeneral);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabelMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(jLabelMes1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(361, 361, 361)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMes)
                    .addComponent(jComboBoxOficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMes1)
                    .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar)
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDJ05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDJ05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDJ05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDJ05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDJ05().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboBoxMes;
    private javax.swing.JComboBox<String> jComboBoxOficina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMes;
    private javax.swing.JLabel jLabelMes1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuEstructura;
    private javax.swing.JMenu jMenuGeneral;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemCR09;
    private javax.swing.JMenuItem jMenuItemClienteContratado;
    private javax.swing.JMenuItem jMenuItemClienteTitular;
    private javax.swing.JMenuItem jMenuItemDJ05;
    private javax.swing.JMenuItem jMenuItemDJ08;
    private javax.swing.JMenuItem jMenuItemGasto;
    private javax.swing.JMenuItem jMenuItemGeneralResumen;
    private javax.swing.JMenuItem jMenuItemGenerarListado;
    private javax.swing.JMenuItem jMenuItemOficinas;
    private javax.swing.JMenuItem jMenuItemOfimatica;
    private javax.swing.JMenuItem jMenuItemOtro;
    private javax.swing.JMenuItem jMenuItemServicio;
    private javax.swing.JMenuItem jMenuItemTrabajadores;
    private javax.swing.JMenuItem jMenuItemTramite;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuOperacionServiciosAsAt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCR09;
    // End of variables declaration//GEN-END:variables
}
