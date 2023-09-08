/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Heber
 */
public class frmProducto extends javax.swing.JFrame {

    
    conexion con = new conexion();
    Connection connection;
    
    DefaultTableModel productoModel;
    Statement st;
    ResultSet rs;
    int idc;
    int idProducto;
    private enum operation {SAVE,UPDATE,NONE,SEARCH,CANCEL}
    private operation typeOfOperation = operation.NONE; 
    private operation searchOperation = operation.NONE; 
    
    Icon saveIcon = new ImageIcon(ClassLoader.getSystemResource("resource/save.png"));
    Icon addIcon = new ImageIcon(ClassLoader.getSystemResource("resource/agregar.png"));
    Icon deleteIcon = new ImageIcon(ClassLoader.getSystemResource("resource/borrar.png"));
    Icon editIcon = new ImageIcon(ClassLoader.getSystemResource("resource/editar.png"));
    Icon reportIcon = new ImageIcon(ClassLoader.getSystemResource("resource/reporte.png"));
    Icon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("resource/error.png"));
    ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("resource/iconP.png"));
    Icon findIcon = new ImageIcon(ClassLoader.getSystemResource("resource/lupa.png"));
    
    public boolean isAdmin;

    @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resource/iconP.png"));
        return retValue;
    }
    
    public frmProducto() {
        initComponents();
        setLocationRelativeTo(null);
        getProductos();
        UITable();
        UIButtons();
        SearchEnable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        txtFindId = new javax.swing.JTextField();
        txtFindName = new javax.swing.JTextField();
        lblIDFind = new javax.swing.JLabel();
        lblFindName = new javax.swing.JLabel();
        btnClean = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ferreteria");
        setBackground(new java.awt.Color(138, 216, 121));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));
        jPanel2.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Precio:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nombre: ");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);

        txtCantidad.setEditable(false);

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(235, 235, 235));

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/agregar.png"))); // NOI18N
        btnNew.setText(" Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/borrar.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/editar.png"))); // NOI18N
        btnUpdate.setText("Editar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/reporte.png"))); // NOI18N
        btnReport.setText("Reporte");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio", "Cantidad"
            }
        ));
        tblProducto.setFocusable(false);
        tblProducto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblProducto.setRowHeight(25);
        tblProducto.setSelectionBackground(new java.awt.Color(243, 83, 58));
        tblProducto.getTableHeader().setReorderingAllowed(false);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion");

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/lupa.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtFindId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindIdKeyReleased(evt);
            }
        });

        txtFindName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindNameKeyReleased(evt);
            }
        });

        lblIDFind.setText("ID:");

        lblFindName.setText("Nombre:");

        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/clean.png"))); // NOI18N
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIDFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFindId, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFindName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFindName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFindId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFindName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIDFind)
                            .addComponent(lblFindName)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad:");

        jLabel6.setFont(new java.awt.Font("Bodoni MT Black", 1, 36)); // NOI18N
        jLabel6.setText("PRODUCTOS ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel6)
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        int fila = tblProducto.getSelectedRow();
        if(fila == -1)
        {
            
        }else
        {
            String iD = tblProducto.getValueAt(fila, 0).toString();
            idc = Integer.parseInt(iD);
            String name = tblProducto.getValueAt(fila, 1).toString();
            String description = tblProducto.getValueAt(fila, 2).toString();
            String price = tblProducto.getValueAt(fila, 3).toString();
            String count = tblProducto.getValueAt(fila, 4).toString();
            
            txtId.setText(iD);
            txtNombre.setText(name);
            txtDescripcion.setText(description);
            txtPrecio.setText(price);
            txtCantidad.setText(count);
        }
    }//GEN-LAST:event_tblProductoMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        searchOperation = operation.NONE;
        SearchEnable();
        switch(typeOfOperation){
            case NONE:
                EnableControls();
                btnNew.setText("Guardar");
                btnNew.setIcon(saveIcon);
                btnDelete.setText("Cancelar");
                btnDelete.setIcon(cancelIcon);
                btnUpdate.setEnabled(false);
                btnReport.setEnabled(false);
                typeOfOperation = operation.SAVE;
                CleanFields();
            break;
            case SAVE:
                if(validateFields(txtId,txtNombre,txtDescripcion,txtPrecio,txtCantidad)){
                    AddProduct();
                    DisableControls();
                    CleanFields();                    
                    btnNew.setText("Nuevo");
                    btnNew.setIcon(addIcon);
                    btnDelete.setText("Eliminar");
                    btnDelete.setIcon(deleteIcon);
                    btnUpdate.setEnabled(true);
                    btnReport.setEnabled(true);
                    typeOfOperation = operation.NONE;
                    getProductos();
                }
                
            break;
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        searchOperation = operation.NONE;
        SearchEnable();
        switch(typeOfOperation){
            case UPDATE:
                DisableControls();
                CleanFields();
                btnUpdate.setText("Editar");
                btnReport.setText("Reporte");                                   
                btnUpdate.setIcon(editIcon);
                btnReport.setIcon(reportIcon);
                btnNew.setEnabled(true);
                btnDelete.setEnabled(true);
                typeOfOperation = operation.NONE;
            break;
            default:
                connection = con.gertConnection();
                JasperReport reporteProd = null;                
                String path = "src\\Report\\report.jasper";
        
            try {
                reporteProd = (JasperReport)JRLoader.loadObjectFromFile(path);
                JasperPrint jprint = JasperFillManager.fillReport(reporteProd, null,connection);
                JasperViewer view = new JasperViewer(jprint,false);
                view.setVisible(true);
                
            } catch (JRException ex) {
                Logger.getLogger(frmProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            break;
        }
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        searchOperation = operation.NONE;
        SearchEnable();
        switch(typeOfOperation){
            case NONE:
            int fila = tblProducto.getSelectedRow();
            if(fila > 0){
                btnUpdate.setText("Actualizar");
                btnReport.setText("Cancelar");
                btnUpdate.setIcon(saveIcon);
                btnReport.setIcon(cancelIcon);
                btnNew.setEnabled(false);
                btnDelete.setEnabled(false);
                EnableControls();                
                txtId.setEditable(false);
                typeOfOperation = operation.UPDATE;

            }else{
                JOptionPane.showMessageDialog(null,"Debe selecionar un Producto");
            }
            break;
            case UPDATE:
            if(validateFields(txtId,txtNombre,txtDescripcion,txtPrecio,txtCantidad)){
                updateProduct();
                btnUpdate.setText("Editar");
                btnReport.setText("Reporte");
                btnUpdate.setIcon(editIcon);
                btnReport.setIcon(reportIcon);
                btnNew.setEnabled(true);
                btnDelete.setEnabled(true);
                typeOfOperation = operation.NONE;
                getProductos();
                DisableControls();
            }
            break;
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        searchOperation = operation.NONE;
        SearchEnable();
        switch(typeOfOperation){
            case SAVE:
            DisableControls();
            CleanFields();
            btnNew.setText("Nuevo");
            btnDelete.setText("Eliminar");
            btnNew.setIcon(addIcon);
            btnDelete.setIcon(deleteIcon);
            btnUpdate.setEnabled(true);
            btnReport.setEnabled(true);
            typeOfOperation = operation.NONE;
            break;
            default:
            try{

                int fila = tblProducto.getSelectedRow();
                if(fila > 0){

                    int respuesta = JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar el registro?","Eliminar Producto",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(respuesta == JOptionPane.YES_OPTION){

                        String sql = "delete from producto where codigoProducto="+idc;
                        connection = con.gertConnection();
                        st = connection.createStatement();
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Se ha Eliminado correctamente el prodcuto");
                        CleanFields();

                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Debe selecionar un Producto");
                }
                getProductos();
            }catch(Exception e){}
            break;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if(searchOperation == operation.NONE){
            searchOperation = operation.SEARCH;
        }else{
            searchOperation = operation.NONE;
            getProductos();
        }    
        SearchEnable();
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtFindIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindIdKeyReleased
        FindIdAndName();
    }//GEN-LAST:event_txtFindIdKeyReleased

    private void txtFindNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindNameKeyReleased
        FindIdAndName();
    }//GEN-LAST:event_txtFindNameKeyReleased

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanSearch();
    }//GEN-LAST:event_btnCleanActionPerformed

  
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
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProducto().setVisible(true);
            }
        });
    }
    
    public void getProductos()
    {
        String sql = "select * from producto";
        try{
            connection = con.gertConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            Object[] producto = new Object[5];
            productoModel = (DefaultTableModel) tblProducto.getModel();
            productoModel.setRowCount(0);
            while(rs.next()){
                producto[0] = rs.getString("codigoProducto");
                producto[1] = rs.getString("nombreProducto");                
                producto[2] = rs.getString("descripcion");
                producto[3] = rs.getFloat("precioUnitario");
                producto[4] = rs.getInt("cantidadProducto");                     
                productoModel.addRow(producto);
            }
            tblProducto.setModel(productoModel);
        }catch(Exception e){
        }
    }
    
    public void FindIdAndName(){
        String sql;
        if(txtFindId.getText().equals("")){
           sql = "select * from producto where nombreProducto LIKE '%"+ txtFindName.getText()+"%'";
        }
        else if(txtFindName.getText().equals(""))
        {
          sql = "select * from producto where codigoProducto LIKE '%"+txtFindId.getText()+"%'";
        }
        else{
            sql = "select * from producto where codigoProducto LIKE '%"+txtFindId.getText()+"%' OR nombreProducto LIKE '%"+ txtFindName.getText()+"%'";
        }
        
        try{
            connection = con.gertConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            Object[] producto = new Object[5];
            productoModel = (DefaultTableModel) tblProducto.getModel();
            productoModel.setRowCount(0);
            while(rs.next()){
                producto[0] = rs.getString("codigoProducto");
                producto[1] = rs.getString("nombreProducto");                
                producto[2] = rs.getString("descripcion");
                producto[3] = rs.getFloat("precioUnitario");
                producto[4] = rs.getInt("cantidadProducto");                     
                productoModel.addRow(producto);
            }
            tblProducto.setModel(productoModel);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void EnableControls(){
    
        txtCantidad.setEditable(true);
        txtId.setEditable(true);
        txtNombre.setEditable(true);
        txtDescripcion.setEditable(true);
        txtPrecio.setEditable(true);
    }
    
    private void DisableControls(){
    
        txtCantidad.setEditable(false);
        txtId.setEditable(false);
        txtNombre.setEditable(false);
        txtDescripcion.setEditable(false);
        txtPrecio.setEditable(false);
    }
    
    private void CleanFields(){
    
        txtCantidad.setText("");
        txtDescripcion.setText("");
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    }
    
    private void AddProduct(){
        try{
            String sql = "insert into producto (codigoProducto, nombreProducto, precioUnitario, cantidadProducto, descripcion) "
                + "values ('"+txtId.getText()+"','"+txtNombre.getText()+"','"+txtPrecio.getText()+"','"+txtCantidad.getText()+"','"+txtDescripcion.getText()+"')";
       
            connection = con.gertConnection();
            st = connection.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha guardado correctamente el prodcuto");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    private void updateProduct(){
        try{
            String sql = "update producto set nombreProducto='"+txtNombre.getText()+"',precioUnitario='"+txtPrecio.getText()+"',cantidadProducto='"+Integer.parseInt(txtCantidad.getText())+"',descripcion='"+txtDescripcion.getText()+"' where codigoProducto="+idc;
       
            connection = con.gertConnection();
            st = connection.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha Actualizado correctamente el prodcuto");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void UITable(){       
        tblProducto.setRowHeight(25);     
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(0,168,205));
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 14));

        for (int i = 0; i < tblProducto.getColumnModel().getColumnCount(); i++) {
            tblProducto.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }              
    }
    
    private void UIButtons(){
        btnNew.setBackground(new Color(35,204,42));
        btnDelete.setBackground(new Color(255,47,47));
        btnUpdate.setBackground(new Color(35,113,204));
        btnReport.setBackground(new Color(250,159,66));
    }
    
    private void SearchEnable(){   
        if(searchOperation == operation.SEARCH){
            lblFindName.setVisible(true);
            lblIDFind.setVisible(true);
            txtFindId.setVisible(true);
            txtFindName.setVisible(true);
            btnClean.setVisible(true);
            btnFind.setText("");   
            btnFind.setIcon(cancelIcon);  
        }else{
            lblIDFind.setVisible(false);
            lblFindName.setVisible(false);
            txtFindId.setVisible(false);
            txtFindName.setVisible(false);
            btnClean.setVisible(false);
            btnFind.setText("");
            btnFind.setIcon(findIcon);
            cleanSearch();
        }
    }
    
    private void cleanSearch(){
        txtFindId.setText("");
        txtFindName.setText("");
        getProductos();
    }
    private boolean validateFields(JTextField id,JTextField name,JTextArea description,JTextField price,JTextField count){
    
        if(!id.getText().equals("") && !name.getText().equals("") && !description.getText().equals("")
                && !price.getText().equals("") && !count.getText().equals("")){
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos", "ADVERTENCIA",JOptionPane.INFORMATION_MESSAGE);
        }        
        return false;
    } 

    public void ShowButtons(boolean _isAdmin){
        if(!_isAdmin){
            btnDelete.setVisible(false);
            btnNew.setVisible(false);
            btnUpdate.setVisible(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFindName;
    private javax.swing.JLabel lblIDFind;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFindId;
    private javax.swing.JTextField txtFindName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
