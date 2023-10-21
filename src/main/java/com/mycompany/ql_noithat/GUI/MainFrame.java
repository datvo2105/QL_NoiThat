package com.mycompany.ql_noithat.GUI;

public class MainFrame extends javax.swing.JFrame {

	public MainFrame() {
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jTabbedPane1 = new javax.swing.JTabbedPane();
                panel_Supplier = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                btn_reflesh = new javax.swing.JButton();
                jPanel3 = new javax.swing.JPanel();
                btn_deleteSupplier = new javax.swing.JButton();
                btn_editSupplier = new javax.swing.JButton();
                btn_addSupplier = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();
                jSeparator1 = new javax.swing.JSeparator();
                jLabel2 = new javax.swing.JLabel();
                txt_SupplierID = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                txt_SupplierName = new javax.swing.JTextField();
                jLabel5 = new javax.swing.JLabel();
                txt_ContactName = new javax.swing.JTextField();
                jLabel6 = new javax.swing.JLabel();
                txt_ContactEmail = new javax.swing.JTextField();
                jLabel7 = new javax.swing.JLabel();
                txt_ContactPhone = new javax.swing.JTextField();
                jLabel8 = new javax.swing.JLabel();
                txt_Address = new javax.swing.JTextField();
                txt_City = new javax.swing.JTextField();
                jLabel9 = new javax.swing.JLabel();
                txt_State = new javax.swing.JTextField();
                jLabel10 = new javax.swing.JLabel();
                txt_PostalCode = new javax.swing.JTextField();
                jLabel11 = new javax.swing.JLabel();
                txt_Contry = new javax.swing.JTextField();
                jLabel12 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                listSupplier = new javax.swing.JTable();
                jPanel2 = new javax.swing.JPanel();
                jMenuBar1 = new javax.swing.JMenuBar();
                menu_File = new javax.swing.JMenu();
                jMenuItem1 = new javax.swing.JMenuItem();
                jSeparator2 = new javax.swing.JPopupMenu.Separator();
                btn_exit = new javax.swing.JMenuItem();
                jMenu2 = new javax.swing.JMenu();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);

                jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(51, 51, 51));
                jLabel1.setText("Nhà Sản Xuất");

                btn_reflesh.setText("Làm Mới");
                btn_reflesh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_refleshActionPerformed(evt);
                        }
                });

                jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jPanel3.setPreferredSize(new java.awt.Dimension(500, 601));

                btn_deleteSupplier.setText("Xóa");
                btn_deleteSupplier.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_deleteSupplierActionPerformed(evt);
                        }
                });

                btn_editSupplier.setText("Sửa");
                btn_editSupplier.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_editSupplierActionPerformed(evt);
                        }
                });

                btn_addSupplier.setText("Thêm");
                btn_addSupplier.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_addSupplierActionPerformed(evt);
                        }
                });

                jLabel3.setText("Mã NSX");

                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Thông Tin");

                txt_SupplierID.setEditable(false);

                jLabel4.setText("Tên NSX");

                jLabel5.setText("Tên Quản Lý");

                jLabel6.setText("Email");

                jLabel7.setText("Số Điện Thoại");

                jLabel8.setText("Địa Chỉ");

                jLabel9.setText("Thành Phố");

                jLabel10.setText("Quận");

                jLabel11.setText("Mã Bưu Điện");

                jLabel12.setText("Quốc Gia");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btn_editSupplier)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_addSupplier)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                                                .addComponent(btn_deleteSupplier))
                                        .addComponent(txt_SupplierID)
                                        .addComponent(txt_SupplierName)
                                        .addComponent(txt_ContactName)
                                        .addComponent(txt_ContactEmail)
                                        .addComponent(txt_ContactPhone)
                                        .addComponent(txt_Address)
                                        .addComponent(txt_City)
                                        .addComponent(txt_State)
                                        .addComponent(txt_PostalCode)
                                        .addComponent(txt_Contry)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_SupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_SupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ContactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_State, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_PostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Contry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_editSupplier)
                                        .addComponent(btn_addSupplier)
                                        .addComponent(btn_deleteSupplier))
                                .addContainerGap())
                );

                jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                listSupplier.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null, null}
                        },
                        new String [] {
                                "Mã NSX", "Tên NSX", "Tên Quản Lý", "Email", "Số Điện Thoại", "Địa Chỉ", "Thành Phố", "Quận", "Mã Bưu Điện", "Quốc Gia"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, true, true, true, true, true, true, true, true, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jScrollPane1.setViewportView(listSupplier);

                javax.swing.GroupLayout panel_SupplierLayout = new javax.swing.GroupLayout(panel_Supplier);
                panel_Supplier.setLayout(panel_SupplierLayout);
                panel_SupplierLayout.setHorizontalGroup(
                        panel_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_SupplierLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(panel_SupplierLayout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_reflesh)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                panel_SupplierLayout.setVerticalGroup(
                        panel_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_SupplierLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(btn_reflesh))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                                .addContainerGap())
                );

                jTabbedPane1.addTab("NSX", panel_Supplier);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 756, Short.MAX_VALUE)
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 626, Short.MAX_VALUE)
                );

                jTabbedPane1.addTab("tab2", jPanel2);

                menu_File.setText("File");

                jMenuItem1.setText("user");
                menu_File.add(jMenuItem1);
                menu_File.add(jSeparator2);

                btn_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
                btn_exit.setText("Exit");
                btn_exit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_exitActionPerformed(evt);
                        }
                });
                menu_File.add(btn_exit);

                jMenuBar1.add(menu_File);

                jMenu2.setText("Edit");
                jMenuBar1.add(jMenu2);

                setJMenuBar(jMenuBar1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
		this.dispose();
        }//GEN-LAST:event_btn_exitActionPerformed

        private void btn_editSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editSupplierActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_btn_editSupplierActionPerformed

        private void btn_addSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addSupplierActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_btn_addSupplierActionPerformed

        private void btn_deleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteSupplierActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_btn_deleteSupplierActionPerformed

        private void btn_refleshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refleshActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_btn_refleshActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btn_addSupplier;
        private javax.swing.JButton btn_deleteSupplier;
        private javax.swing.JButton btn_editSupplier;
        private javax.swing.JMenuItem btn_exit;
        private javax.swing.JButton btn_reflesh;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JMenu jMenu2;
        private javax.swing.JMenuBar jMenuBar1;
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JPopupMenu.Separator jSeparator2;
        private javax.swing.JTabbedPane jTabbedPane1;
        private javax.swing.JTable listSupplier;
        private javax.swing.JMenu menu_File;
        private javax.swing.JPanel panel_Supplier;
        private javax.swing.JTextField txt_Address;
        private javax.swing.JTextField txt_City;
        private javax.swing.JTextField txt_ContactEmail;
        private javax.swing.JTextField txt_ContactName;
        private javax.swing.JTextField txt_ContactPhone;
        private javax.swing.JTextField txt_Contry;
        private javax.swing.JTextField txt_PostalCode;
        private javax.swing.JTextField txt_State;
        private javax.swing.JTextField txt_SupplierID;
        private javax.swing.JTextField txt_SupplierName;
        // End of variables declaration//GEN-END:variables
}
