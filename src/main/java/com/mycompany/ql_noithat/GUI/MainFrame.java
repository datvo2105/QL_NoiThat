package com.mycompany.ql_noithat.GUI;

import java.io.Console;
import java.sql.Connection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mycompany.ql_noithat.DAL.Audit;
import com.mycompany.ql_noithat.DAL.AuditDb;
import com.mycompany.ql_noithat.DAL.Category;
import com.mycompany.ql_noithat.DAL.CategoryDB;
import com.mycompany.ql_noithat.DAL.DB;
import com.mycompany.ql_noithat.DAL.Key;
import com.mycompany.ql_noithat.DAL.Logger;
import com.mycompany.ql_noithat.DAL.LoggerDb;
import com.mycompany.ql_noithat.DAL.Product;
import com.mycompany.ql_noithat.DAL.ProductDB;
import com.mycompany.ql_noithat.DAL.RSAManager;
import com.mycompany.ql_noithat.DAL.RSAOracle;
import com.mycompany.ql_noithat.DAL.Supplier;
import com.mycompany.ql_noithat.DAL.SupplierDB;
import com.mycompany.ql_noithat.DAL.User;
import com.mycompany.ql_noithat.DAL.UserDb;
import com.mycompany.ql_noithat.DAL.UserKeys;

public class MainFrame extends javax.swing.JFrame {

  private Connection conn;
  private SupplierDB supplierDB = new SupplierDB();
  private CategoryDB categoryDB = new CategoryDB();
  private ProductDB productDB = new ProductDB();
  private AuditDb auditDb = new AuditDb();

  private LoggerDb loggerDb = new LoggerDb();
  UserKeys userKey = new UserKeys();

  private UserDb userDb = new UserDb();
  private RSAOracle rsaOracle = new RSAOracle();

  private Supplier selectedSupplier = null;
  private Category selectedCategory = null;
  private Product productSelected = null;
  private User userSelected = null;

  public MainFrame() {
    initComponents();
    conn = DB.getConnect();
    setExtendedState(MAXIMIZED_BOTH);
    initAction();
  }

  private void initLogger() {
    List<Logger> list = loggerDb.getAllLoggers();
    DefaultTableModel model = (DefaultTableModel) listLog.getModel();
    model.setRowCount(0);

    for (Logger logger : list) {
      model.addRow(new Object[] {
          logger.getLog_id(),
          logger.getUser_name(),
          logger.getTime()
      });
    }
  }

  void initAction() {
    List<Audit> audits = auditDb.getAuditByTableName("SUPPLIERS");
    DefaultTableModel model = (DefaultTableModel) list_actionSup.getModel();
    model.setRowCount(0);
    for (Audit audit : audits) {
      model.addRow(new Object[] {
          audit.getUsername(),
          audit.getHost(),
          audit.getTime(),
          audit.getAction(),
          audit.getTable(),
      });
    }

    audits = auditDb.getAuditByTableName("PRODUCT_CATEGORIES");
    model = (DefaultTableModel) list_actionCat.getModel();
    model.setRowCount(0);

    for (Audit audit : audits) {
      model.addRow(new Object[] {
          audit.getUsername(),
          audit.getHost(),
          audit.getTime(),
          audit.getAction(),
          audit.getTable(),
      });
    }

    audits = auditDb.getAuditByTableName("PRODUCTS");
    model = (DefaultTableModel) list_actionPro.getModel();
    model.setRowCount(0);

    for (Audit audit : audits) {
      model.addRow(new Object[] {
          audit.getUsername(),
          audit.getHost(),
          audit.getTime(),
          audit.getAction(),
          audit.getTable(),
      });
    }

    audits = auditDb.getAuditByTableName("LOGIN_LOG");
    model = (DefaultTableModel) list_actionLog.getModel();
    model.setRowCount(0);

    for (Audit audit : audits) {
      model.addRow(new Object[] {
          audit.getUsername(),
          audit.getHost(),
          audit.getTime(),
          audit.getAction(),
          audit.getTable(),
      });
    }

  }

  void initSupplier(String searchSupplier) {
    List<Supplier> suppliers = supplierDB.getAllSuppliers(searchSupplier);
    DefaultTableModel model = (DefaultTableModel) listSupplier.getModel();
    model.setRowCount(0);
    for (Supplier supplier : suppliers) {
      model.addRow(new Object[] {
          supplier.getSupplierId(),
          supplier.getSupplierName(),
          supplier.getContactName(),
          supplier.getContactEmail(),
          supplier.getContactPhone(),
          supplier.getAddress(),
          supplier.getCity(),
          supplier.getState(),
          supplier.getPostalCode(),
          supplier.getCountry()
      });
    }
  }

  void initCategory(String searchCategory) {
    List<Category> categories = categoryDB.getAllCategory(searchCategory);
    DefaultTableModel modelCategory = (DefaultTableModel) listCategory.getModel();
    modelCategory.setRowCount(0);
    for (Category category : categories) {
      modelCategory.addRow(new Object[] {
          category.getCategoryId(),
          category.getCategoryName(),
      });
    }
  }

  void initProduct(String searchProduct) {
    List<Product> products = productDB.getAllProducts(searchProduct);
    DefaultTableModel modelProduct = (DefaultTableModel) listProduct.getModel();
    modelProduct.setRowCount(0);
    for (Product product : products) {
      modelProduct.addRow(new Object[] {
          product.getProductId(),
          product.getProductName(),
          product.getCategoryId(),
          product.getPrice(),
          product.getDesc(),
      });
    }

  }

  void initUser() {
    List<User> users = userDb.getAllUsers();

    DefaultTableModel modelUser = (DefaultTableModel) listUser.getModel();
    modelUser.setRowCount(0);
    for (User user : users) {
      modelUser.addRow(new Object[] {
          user.getUserName(),
          user.getCreateAt(),
      });
    }
  }

  private void InitData(String searchSupplier, String searchCategory, String searchProduct) {
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel = new javax.swing.JTabbedPane();
    panel_Supplier = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    btn_refleshSupplier = new javax.swing.JButton();
    infoSupplier = new javax.swing.JPanel();
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
    tableSuplier = new javax.swing.JScrollPane();
    listSupplier = new javax.swing.JTable();
    txt_searchSupplier = new javax.swing.JTextField();
    btn_searchSupplier = new javax.swing.JButton();
    sup_txtKey = new javax.swing.JTextField();
    sup_btnKey = new javax.swing.JButton();
    panel_Category = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    tableCategory = new javax.swing.JScrollPane();
    listCategory = new javax.swing.JTable();
    infoCategory = new javax.swing.JPanel();
    jLabel14 = new javax.swing.JLabel();
    txt_CategoryId = new javax.swing.JTextField();
    txt_CategoryName = new javax.swing.JTextField();
    jLabel15 = new javax.swing.JLabel();
    btn_editCategory = new javax.swing.JButton();
    btn_addCategory = new javax.swing.JButton();
    btn_deleteCategory = new javax.swing.JButton();
    jSeparator4 = new javax.swing.JSeparator();
    jLabel18 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    btn_refleshCategory = new javax.swing.JButton();
    txt_searchCategory = new javax.swing.JTextField();
    btn_seachCategory = new javax.swing.JButton();
    cat_txtCheck = new javax.swing.JTextField();
    cate_btnKey = new javax.swing.JButton();
    panel_Product = new javax.swing.JPanel();
    jLabel16 = new javax.swing.JLabel();
    btn_refleshProduct = new javax.swing.JButton();
    tableProduct = new javax.swing.JScrollPane();
    listProduct = new javax.swing.JTable();
    infoProduct = new javax.swing.JPanel();
    jLabel17 = new javax.swing.JLabel();
    jSeparator3 = new javax.swing.JSeparator();
    jLabel19 = new javax.swing.JLabel();
    txt_ProductId = new javax.swing.JTextField();
    jLabel20 = new javax.swing.JLabel();
    txt_ProductName = new javax.swing.JTextField();
    jLabel21 = new javax.swing.JLabel();
    txt_CategoryProduct = new javax.swing.JTextField();
    jLabel22 = new javax.swing.JLabel();
    txt_ProductPrice = new javax.swing.JTextField();
    jLabel23 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    txt_ProductDesc = new javax.swing.JTextArea();
    btn_editProduct = new javax.swing.JButton();
    txt_addProduct = new javax.swing.JButton();
    btn_deleteProduct = new javax.swing.JButton();
    btn_searchProduct = new javax.swing.JButton();
    txt_searchProduct = new javax.swing.JTextField();
    pro_txtKey = new javax.swing.JTextField();
    pro_btnKey = new javax.swing.JButton();
    panel_User = new javax.swing.JPanel();
    jLabel24 = new javax.swing.JLabel();
    btn_refleshUser = new javax.swing.JButton();
    tableUser = new javax.swing.JScrollPane();
    listUser = new javax.swing.JTable();
    infoUser = new javax.swing.JPanel();
    jLabel25 = new javax.swing.JLabel();
    jSeparator5 = new javax.swing.JSeparator();
    jLabel28 = new javax.swing.JLabel();
    txt_Username = new javax.swing.JTextField();
    jLabel29 = new javax.swing.JLabel();
    txt_Password = new javax.swing.JTextField();
    jLabel33 = new javax.swing.JLabel();
    cb_UserRole = new javax.swing.JComboBox<>();
    btn_addUser = new javax.swing.JButton();
    btn_deleteUser = new javax.swing.JButton();
    btn_generatorKey = new javax.swing.JButton();
    txt_searchUser = new javax.swing.JTextField();
    btn_searchUser = new javax.swing.JButton();
    user_txtKey = new javax.swing.JTextField();
    user_btnKey = new javax.swing.JButton();
    panel_Log = new javax.swing.JPanel();
    jLabel26 = new javax.swing.JLabel();
    mainLog = new javax.swing.JPanel();
    tableLog = new javax.swing.JScrollPane();
    listLog = new javax.swing.JTable();
    btn_refleshLog = new javax.swing.JButton();
    txt_checkKey = new javax.swing.JTextField();
    btn_checkKey = new javax.swing.JButton();
    panel_actions = new javax.swing.JTabbedPane();
    action_sup = new javax.swing.JPanel();
    table_actionSup = new javax.swing.JScrollPane();
    list_actionSup = new javax.swing.JTable();
    action_cat = new javax.swing.JPanel();
    table_actionCat = new javax.swing.JScrollPane();
    list_actionCat = new javax.swing.JTable();
    action_pro = new javax.swing.JPanel();
    table_actionPro = new javax.swing.JScrollPane();
    list_actionPro = new javax.swing.JTable();
    action_log = new javax.swing.JPanel();
    table_actionLog = new javax.swing.JScrollPane();
    list_actionLog = new javax.swing.JTable();
    menuPanel = new javax.swing.JMenuBar();
    menu_File = new javax.swing.JMenu();
    jSeparator2 = new javax.swing.JPopupMenu.Separator();
    btn_logout = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(51, 51, 51));
    jLabel1.setText("Nhà Sản Xuất");

    btn_refleshSupplier.setText("Làm Mới");
    btn_refleshSupplier.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_refleshSupplierActionPerformed(evt);
      }
    });

    infoSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    infoSupplier.setPreferredSize(new java.awt.Dimension(500, 601));

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

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel3.setText("Mã NSX");

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Thông Tin");

    txt_SupplierID.setEditable(false);

    jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel4.setText("Tên NSX");

    jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel5.setText("Tên Quản Lý");

    jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel6.setText("Email");

    jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel7.setText("Số Điện Thoại");

    jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel8.setText("Địa Chỉ");

    jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel9.setText("Thành Phố");

    jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel10.setText("Quận");

    jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel11.setText("Mã Bưu Điện");

    jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel12.setText("Quốc Gia");

    javax.swing.GroupLayout infoSupplierLayout = new javax.swing.GroupLayout(infoSupplier);
    infoSupplier.setLayout(infoSupplierLayout);
    infoSupplierLayout.setHorizontalGroup(
        infoSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(infoSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoSupplierLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(infoSupplierLayout.createSequentialGroup()
                        .addComponent(btn_editSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_addSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            264, Short.MAX_VALUE)
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
                    .addGroup(infoSupplierLayout.createSequentialGroup()
                        .addGroup(infoSupplierLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap()));
    infoSupplierLayout.setVerticalGroup(
        infoSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoSupplierLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SupplierID, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SupplierName, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ContactName, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_City, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_State, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_PostalCode, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Contry, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoSupplierLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editSupplier)
                    .addComponent(btn_addSupplier)
                    .addComponent(btn_deleteSupplier))
                .addContainerGap()));

    tableSuplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    listSupplier.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null, null, null }
        },
        new String[] {
            "Mã NSX", "Tên NSX", "Tên Quản Lý", "Email", "Số Điện Thoại", "Địa Chỉ", "Thành Phố", "Quận",
            "Mã Bưu Điện", "Quốc Gia"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    listSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        listSupplierMouseClicked(evt);
      }
    });
    tableSuplier.setViewportView(listSupplier);

    btn_searchSupplier.setText("Tìm Kiếm");
    btn_searchSupplier.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_searchSupplierActionPerformed(evt);
      }
    });

    sup_btnKey.setText("Check");
    sup_btnKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sup_btnKeyActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panel_SupplierLayout = new javax.swing.GroupLayout(panel_Supplier);
    panel_Supplier.setLayout(panel_SupplierLayout);
    panel_SupplierLayout.setHorizontalGroup(
        panel_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_SupplierLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_SupplierLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278,
                            Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refleshSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_searchSupplier,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 222,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchSupplier))
                    .addComponent(tableSuplier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_SupplierLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoSupplier, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_SupplierLayout
                        .createSequentialGroup()
                        .addComponent(sup_txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 284,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sup_btnKey)))
                .addContainerGap()));
    panel_SupplierLayout.setVerticalGroup(
        panel_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_SupplierLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_refleshSupplier)
                    .addComponent(txt_searchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchSupplier)
                    .addComponent(sup_txtKey, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sup_btnKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_SupplierLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableSuplier)
                    .addComponent(infoSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 700,
                        Short.MAX_VALUE))
                .addContainerGap()));

    mainPanel.addTab("NSX", panel_Supplier);

    jPanel3.setLayout(new java.awt.GridLayout(1, 0));

    listCategory.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null },
            { null, null },
            { null, null },
            { null, null }
        },
        new String[] {
            "Mã Danh Mục", "Tên Danh Mục"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    listCategory.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        listCategoryMouseClicked(evt);
      }
    });
    tableCategory.setViewportView(listCategory);

    jPanel3.add(tableCategory);

    infoCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel14.setText("Mã Danh Mục");

    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel15.setText("Tên Danh Mục");

    btn_editCategory.setText("Sửa");
    btn_editCategory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_editCategoryActionPerformed(evt);
      }
    });

    btn_addCategory.setText("Thêm");
    btn_addCategory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_addCategoryActionPerformed(evt);
      }
    });

    btn_deleteCategory.setText("Xóa");
    btn_deleteCategory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_deleteCategoryActionPerformed(evt);
      }
    });

    jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel18.setText("Thông Tin");

    javax.swing.GroupLayout infoCategoryLayout = new javax.swing.GroupLayout(infoCategory);
    infoCategory.setLayout(infoCategoryLayout);
    infoCategoryLayout.setHorizontalGroup(
        infoCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoCategoryLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_CategoryId)
                    .addComponent(txt_CategoryName)
                    .addGroup(infoCategoryLayout.createSequentialGroup()
                        .addGroup(infoCategoryLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(infoCategoryLayout.createSequentialGroup()
                        .addComponent(btn_editCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_addCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_deleteCategory)))
                .addContainerGap())
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    infoCategoryLayout.setVerticalGroup(
        infoCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoCategoryLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CategoryId, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CategoryName, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoCategoryLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoCategoryLayout
                        .createSequentialGroup()
                        .addGroup(infoCategoryLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_editCategory)
                            .addComponent(btn_addCategory))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        infoCategoryLayout.createSequentialGroup()
                            .addComponent(btn_deleteCategory)
                            .addGap(14, 14, 14)))));

    jPanel3.add(infoCategory);

    jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(51, 51, 51));
    jLabel13.setText("Danh Sách Danh Mục");

    btn_refleshCategory.setText("Làm Mới");
    btn_refleshCategory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_refleshCategoryActionPerformed(evt);
      }
    });

    txt_searchCategory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txt_searchCategoryActionPerformed(evt);
      }
    });

    btn_seachCategory.setText("Tìm Kiếm");
    btn_seachCategory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_seachCategoryActionPerformed(evt);
      }
    });

    cate_btnKey.setText("Check");
    cate_btnKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cate_btnKeyActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panel_CategoryLayout = new javax.swing.GroupLayout(panel_Category);
    panel_Category.setLayout(panel_CategoryLayout);
    panel_CategoryLayout.setHorizontalGroup(
        panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_CategoryLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_CategoryLayout.createSequentialGroup()
                        .addComponent(btn_refleshCategory)
                        .addGap(229, 229, 229)
                        .addComponent(txt_searchCategory,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 255,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_seachCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cat_txtCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cate_btnKey)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE));
    panel_CategoryLayout.setVerticalGroup(
        panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CategoryLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_CategoryLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refleshCategory)
                    .addComponent(txt_searchCategory, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_seachCategory)
                    .addComponent(cat_txtCheck, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cate_btnKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    mainPanel.addTab("Danh Mục", panel_Category);

    jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(51, 51, 51));
    jLabel16.setText("Danh Sách Sản Phẩm");

    btn_refleshProduct.setText("Làm Mới");
    btn_refleshProduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_refleshProductActionPerformed(evt);
      }
    });

    listProduct.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null }
        },
        new String[] {
            "Mã Sản Phẩm", "Tên Sản Phẩm", "Mã Danh Mục", "Giá", "Ghi Chú"
        }) {
      boolean[] canEdit = new boolean[] {
          false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    listProduct.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        listProductMouseClicked(evt);
      }
    });
    tableProduct.setViewportView(listProduct);

    infoProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel17.setText("Thông Tin");

    jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel19.setText("Mã Sản Phẩm");

    txt_ProductId.setEditable(false);

    jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel20.setText("Tên Sản Phẩm");

    jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel21.setText("Mã Danh Mục");

    jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel22.setText("Giá");

    jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel23.setText("Ghi Chú");

    txt_ProductDesc.setColumns(20);
    txt_ProductDesc.setRows(5);
    jScrollPane1.setViewportView(txt_ProductDesc);

    btn_editProduct.setText("Sửa");
    btn_editProduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_editProductActionPerformed(evt);
      }
    });

    txt_addProduct.setText("Thêm");
    txt_addProduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txt_addProductActionPerformed(evt);
      }
    });

    btn_deleteProduct.setText("Xóa");
    btn_deleteProduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_deleteProductActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout infoProductLayout = new javax.swing.GroupLayout(infoProduct);
    infoProduct.setLayout(infoProductLayout);
    infoProductLayout.setHorizontalGroup(
        infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(infoProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoProductLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_ProductId)
                    .addComponent(txt_ProductName)
                    .addComponent(txt_CategoryProduct)
                    .addComponent(txt_ProductPrice)
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addGroup(infoProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE,
                                62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addComponent(btn_editProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_addProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_deleteProduct)))
                .addContainerGap()));
    infoProductLayout.setVerticalGroup(
        infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoProductLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ProductId, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ProductName, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CategoryProduct, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoProductLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editProduct)
                    .addComponent(txt_addProduct)
                    .addComponent(btn_deleteProduct))
                .addContainerGap()));

    btn_searchProduct.setText("Tìm Kiếm");
    btn_searchProduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_searchProductActionPerformed(evt);
      }
    });

    txt_searchProduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txt_searchProductActionPerformed(evt);
      }
    });

    pro_btnKey.setText("Check");
    pro_btnKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pro_btnKeyActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panel_ProductLayout = new javax.swing.GroupLayout(panel_Product);
    panel_Product.setLayout(panel_ProductLayout);
    panel_ProductLayout.setHorizontalGroup(
        panel_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_ProductLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                        panel_ProductLayout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE,
                                278, Short.MAX_VALUE)
                            .addGap(908, 908, 908))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_ProductLayout
                        .createSequentialGroup()
                        .addComponent(tableProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 849,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoProduct, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel_ProductLayout.createSequentialGroup()
                        .addComponent(btn_refleshProduct)
                        .addGap(267, 267, 267)
                        .addComponent(txt_searchProduct, javax.swing.GroupLayout.PREFERRED_SIZE,
                            230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pro_txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 304,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pro_btnKey)
                        .addContainerGap()))));
    panel_ProductLayout.setVerticalGroup(
        panel_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ProductLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refleshProduct)
                    .addComponent(btn_searchProduct)
                    .addComponent(txt_searchProduct, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pro_txtKey, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pro_btnKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ProductLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoProduct, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableProduct))
                .addContainerGap()));

    mainPanel.addTab("Sản Phẩm", panel_Product);

    jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(51, 51, 51));
    jLabel24.setText("Danh Sách Người Dùng");

    btn_refleshUser.setText("Làm Mới");
    btn_refleshUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_refleshUserActionPerformed(evt);
      }
    });

    listUser.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null },
            { null, null },
            { null, null },
            { null, null }
        },
        new String[] {
            "Tài Khoản", " Ngày Tạo"
        }) {
      boolean[] canEdit = new boolean[] {
          false, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });
    listUser.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        listUserMouseClicked(evt);
      }
    });
    tableUser.setViewportView(listUser);

    infoUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel25.setText("Thông Tin");

    jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel28.setText("Tài Khoản");

    jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel29.setText("Mật Khẩu");

    jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel33.setText("Quyền");

    cb_UserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RKhachHang", "RQuanLi" }));

    btn_addUser.setText("Thêm");
    btn_addUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_addUserActionPerformed(evt);
      }
    });

    btn_deleteUser.setText("Xóa");
    btn_deleteUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_deleteUserActionPerformed(evt);
      }
    });

    btn_generatorKey.setText("Tạo Khóa");
    btn_generatorKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_generatorKeyActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout infoUserLayout = new javax.swing.GroupLayout(infoUser);
    infoUser.setLayout(infoUserLayout);
    infoUserLayout.setHorizontalGroup(
        infoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(infoUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Username)
                    .addComponent(txt_Password)
                    .addComponent(cb_UserRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addGroup(infoUserLayout.createSequentialGroup()
                        .addGroup(infoUserLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel33)
                            .addGroup(infoUserLayout.createSequentialGroup()
                                .addComponent(btn_addUser)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_deleteUser)
                                .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_generatorKey)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
    infoUserLayout.setVerticalGroup(
        infoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoUserLayout.createSequentialGroup()
                .addComponent(jLabel25)
                .addGap(2, 2, 2)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_UserRole, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addUser)
                    .addComponent(btn_deleteUser)
                    .addComponent(btn_generatorKey))
                .addContainerGap()));

    txt_searchUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txt_searchUserActionPerformed(evt);
      }
    });

    btn_searchUser.setText("Tìm Kiếm");
    btn_searchUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_searchUserActionPerformed(evt);
      }
    });

    user_txtKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        user_txtKeyActionPerformed(evt);
      }
    });

    user_btnKey.setText("Check");
    user_btnKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        user_btnKeyActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panel_UserLayout = new javax.swing.GroupLayout(panel_User);
    panel_User.setLayout(panel_UserLayout);
    panel_UserLayout.setHorizontalGroup(
        panel_UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_UserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_UserLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_UserLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 279,
                            Short.MAX_VALUE)
                        .addGap(908, 908, 908))
                    .addGroup(panel_UserLayout.createSequentialGroup()
                        .addComponent(tableUser, javax.swing.GroupLayout.PREFERRED_SIZE, 771,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoUser, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel_UserLayout.createSequentialGroup()
                        .addComponent(btn_refleshUser)
                        .addGap(328, 328, 328)
                        .addComponent(txt_searchUser, javax.swing.GroupLayout.PREFERRED_SIZE,
                            225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user_txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 339,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user_btnKey)
                        .addContainerGap()))));
    panel_UserLayout.setVerticalGroup(
        panel_UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_UserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
                    panel_UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_refleshUser)
                        .addComponent(txt_searchUser, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_searchUser)
                        .addComponent(user_txtKey, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(user_btnKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
                    panel_UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(infoUser, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tableUser, javax.swing.GroupLayout.DEFAULT_SIZE, 672,
                            Short.MAX_VALUE))
                .addContainerGap()));

    mainPanel.addTab("Tài Khoản Người Dùng", panel_User);

    jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
    jLabel26.setForeground(new java.awt.Color(51, 51, 51));
    jLabel26.setText("Nhật Kí");

    listLog.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null },
            { null, null, null },
            { null, null, null },
            { null, null, null }
        },
        new String[] {
            "Mã Nhật Kí", "Tài Khoản", "Thời Gian "
        }));
    listLog.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        listLogMouseClicked(evt);
      }
    });
    tableLog.setViewportView(listLog);

    btn_refleshLog.setText("Làm Mới");

    btn_checkKey.setText("Xác Thực");
    btn_checkKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_checkKeyActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout mainLogLayout = new javax.swing.GroupLayout(mainLog);
    mainLog.setLayout(mainLogLayout);
    mainLogLayout.setHorizontalGroup(
        mainLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLogLayout.createSequentialGroup()
                        .addComponent(btn_refleshLog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_checkKey, javax.swing.GroupLayout.PREFERRED_SIZE, 471,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_checkKey))
                    .addComponent(tableLog, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap()));
    mainLogLayout.setVerticalGroup(
        mainLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refleshLog)
                    .addComponent(txt_checkKey, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_checkKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableLog, javax.swing.GroupLayout.PREFERRED_SIZE, 666,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    javax.swing.GroupLayout panel_LogLayout = new javax.swing.GroupLayout(panel_Log);
    panel_Log.setLayout(panel_LogLayout);
    panel_LogLayout.setHorizontalGroup(
        panel_LogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_LogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_LogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 1180,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainLog, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));
    panel_LogLayout.setVerticalGroup(
        panel_LogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_LogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainLog, javax.swing.GroupLayout.PREFERRED_SIZE, 686, Short.MAX_VALUE)
                .addGap(21, 21, 21)));

    mainPanel.addTab("Nhật Kí", panel_Log);

    list_actionSup.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null }
        },
        new String[] {
            "Username", "Host", "Time", "Action", "Table"
        }));
    table_actionSup.setViewportView(list_actionSup);

    javax.swing.GroupLayout action_supLayout = new javax.swing.GroupLayout(action_sup);
    action_sup.setLayout(action_supLayout);
    action_supLayout.setHorizontalGroup(
        action_supLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1193, Short.MAX_VALUE)
            .addGroup(action_supLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_supLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionSup, javax.swing.GroupLayout.DEFAULT_SIZE, 1181,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));
    action_supLayout.setVerticalGroup(
        action_supLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
            .addGroup(action_supLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_supLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionSup, javax.swing.GroupLayout.DEFAULT_SIZE, 704,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));

    panel_actions.addTab("NSX", action_sup);

    list_actionCat.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null }
        },
        new String[] {
            "Username", "Host", "Time", "Action", "Table"
        }));
    table_actionCat.setViewportView(list_actionCat);

    javax.swing.GroupLayout action_catLayout = new javax.swing.GroupLayout(action_cat);
    action_cat.setLayout(action_catLayout);
    action_catLayout.setHorizontalGroup(
        action_catLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1193, Short.MAX_VALUE)
            .addGroup(action_catLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_catLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionCat, javax.swing.GroupLayout.DEFAULT_SIZE, 1183,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));
    action_catLayout.setVerticalGroup(
        action_catLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
            .addGroup(action_catLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_catLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionCat, javax.swing.GroupLayout.DEFAULT_SIZE, 706,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));

    panel_actions.addTab("Danh Mục", action_cat);

    list_actionPro.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null }
        },
        new String[] {
            "Username", "Host", "Time", "Action", "Table"
        }));
    table_actionPro.setViewportView(list_actionPro);

    javax.swing.GroupLayout action_proLayout = new javax.swing.GroupLayout(action_pro);
    action_pro.setLayout(action_proLayout);
    action_proLayout.setHorizontalGroup(
        action_proLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1193, Short.MAX_VALUE)
            .addGroup(action_proLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_proLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionPro, javax.swing.GroupLayout.DEFAULT_SIZE, 1183,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));
    action_proLayout.setVerticalGroup(
        action_proLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
            .addGroup(action_proLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_proLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionPro, javax.swing.GroupLayout.DEFAULT_SIZE, 706,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));

    panel_actions.addTab("Sản Phẩm", action_pro);

    list_actionLog.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null },
            { null, null, null, null, null }
        },
        new String[] {
            "Username", "Host", "Time", "Action", "Table"
        }));
    table_actionLog.setViewportView(list_actionLog);

    javax.swing.GroupLayout action_logLayout = new javax.swing.GroupLayout(action_log);
    action_log.setLayout(action_logLayout);
    action_logLayout.setHorizontalGroup(
        action_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1193, Short.MAX_VALUE)
            .addGroup(action_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_logLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionLog, javax.swing.GroupLayout.DEFAULT_SIZE, 1183,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));
    action_logLayout.setVerticalGroup(
        action_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
            .addGroup(action_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_logLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(table_actionLog, javax.swing.GroupLayout.DEFAULT_SIZE, 706,
                        Short.MAX_VALUE)
                    .addGap(5, 5, 5))));

    panel_actions.addTab("Nhật Kí", action_log);

    mainPanel.addTab("Hoạt Động", panel_actions);

    menu_File.setText("File");

    btn_userInfo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_userInfoActionPerformed(evt);
      }
    });
    if (DB.user.equalsIgnoreCase("sys as sysdba")) {
      btn_userInfo.setText("SYS");
    } else {
      btn_userInfo.setText(DB.user.toUpperCase());
    }
    menu_File.add(btn_userInfo);
    menu_File.add(jSeparator2);

    btn_logout.setText("Logout");
    btn_logout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_logoutActionPerformed(evt);
      }
    });
    menu_File.add(btn_logout);

    menuPanel.add(menu_File);

    setJMenuBar(menuPanel);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 786,
                javax.swing.GroupLayout.PREFERRED_SIZE));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void user_txtKeyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_user_txtKeyActionPerformed

  }

  private void sup_btnKeyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sup_btnKeyActionPerformed
    try {
      String encodeString = sup_txtKey.getText();
      boolean isAllow = userKey.Validate(DB.user, encodeString);

      if (isAllow == true) {
        initSupplier("");
        return;
      }

      JOptionPane.showMessageDialog(rootPane,
          "error security");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(rootPane,
          "error security");

    }

  }// GEN-LAST:event_sup_btnKeyActionPerformed

  private void cate_btnKeyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cate_btnKeyActionPerformed
    try {
      String encodeString = cat_txtCheck.getText();
      boolean isAllow = userKey.Validate(DB.user, encodeString);

      if (isAllow == true) {
        initCategory("");
        return;
      }

      JOptionPane.showMessageDialog(rootPane,
          "error security");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(rootPane,
          "error security");

    }

  }// GEN-LAST:event_cate_btnKeyActionPerformed

  private void pro_btnKeyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pro_btnKeyActionPerformed
    try {
      String encodeString = pro_txtKey.getText();

      boolean isAllow = userKey.Validate(DB.user, encodeString);

      if (isAllow == true) {
        initProduct("");
        return;
      }

      JOptionPane.showMessageDialog(rootPane,
          "error security");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(rootPane,
          "error security");

    }
  }// GEN-LAST:event_pro_btnKeyActionPerformed

  private void user_btnKeyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_user_btnKeyActionPerformed
    try {
      String key = user_txtKey.getText();

      String decode = rsaOracle.decrypt(
          rsaOracle.encrypt(Key.pay_load, key),
          Key.private_key);

      if (!decode.equals(Key.pay_load)) {
        throw new Error("");
      }

      initUser();

    } catch (Exception e) {
      JOptionPane.showMessageDialog(rootPane,
          "lỗi xác thực");

    }

  }// GEN-LAST:event_user_btnKeyActionPerformed

  private void btn_generatorKeyActionPerformed(java.awt.event.ActionEvent evt) {
    if (userSelected != null) {
      RSAManager rsaManager = new RSAManager();
      userKey.saveKey(userSelected.getUserName(), rsaManager.getPrivateKey(), rsaManager.getPublicKey());
      JOptionPane.showMessageDialog(rootPane,
          "Private String: " + rsaManager.encrypt(userSelected.getUserName()));

    }

  }// GEN-LAST:event_btn_generatorKeyActionPerformed

  private void btn_deleteUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deleteUserActionPerformed
    if (userSelected != null) {
      boolean isDeleted = userDb.deleteUser(userSelected.getUserName());
      JOptionPane.showMessageDialog(rootPane,
          isDeleted ? "xoá thành công" : "xoá thất bại");
      userSelected = null;
      this.InitData("", "", "");

    }
  }// GEN-LAST:event_btn_deleteUserActionPerformed

  private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_logoutActionPerformed
    DB.disconnect();
    this.dispose();
    new ConnectDB().setVisible(true);
  }// GEN-LAST:event_btn_logoutActionPerformed

  private void listUserMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listUserMouseClicked
    int selectedRow = listUser.getSelectedRow();

    if (selectedRow >= 0) {
      userSelected = mapRowUser(selectedRow);
    }
  }

  private void btn_checkKeyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_checkKeyActionPerformed
    try {
      String key = txt_checkKey.getText();

      String decode = rsaOracle.decrypt(
          rsaOracle.encrypt(Key.pay_load, key),
          Key.private_key);

      if (!decode.equals(Key.pay_load)) {
        throw new Error("");
      }

      initLogger();

    } catch (Exception e) {
      JOptionPane.showMessageDialog(rootPane,
          "lỗi xác thực");

    }

  }// GEN-LAST:event_btn_checkKeyActionPerformed

  private void listLogMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listLogMouseClicked
    // TODO add your handling code here:
  }// GEN-LAST:event_listLogMouseClicked

  private void btn_UserKeyActionPerformed(java.awt.event.ActionEvent evt) {// G
    String key = rsaOracle.genarateKey();
    // String[] keys = key.split("publickey start");

    String encoded = rsaOracle.encrypt("",
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCeFPb1p09P79dX2g3aQL88fug7eCW2GG1bVBDhwpjeL9GUnROYpXwc0ZiOan37KSVkXjAiJMRQm1K6SX/D83ZyGVnLESWsSTWmYRyA1KMy80tVLt0yrR4kwwlNQAuGYh38ACr4W0l1n4i4qNqEukGlnCB1ycnFWzWCPcZuYhhzGQIDAQAB");

    String decode = rsaOracle.decrypt(encoded,
        "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ4U9vWnT0/v11faDdpAvzx+6Dt4JbYYbVtUEOHCmN4v0ZSdE5ilfBzRmI5qffspJWReMCIkxFCbUrpJf8PzdnIZWcsRJaxJNaZhHIDUozLzS1Uu3TKtHiTDCU1AC4ZiHfwAKvhbSXWfiLio2oS6QaWcIHXJycVbNYI9xm5iGHMZAgMBAAECgYEAm1Ht9B+XhesZom/U/IRxYXcvpn6+TtRhXkKS877HhEdnnKVZA7pU39vwEL4BWi1rV9pTYLjPSoPSHMbqihVEYfnlJ1S3RVrW/PppB7JbGZnahqDvzpXNk+iHOSy6IxZINxaFy49/T8wNXfOBDwm38ySYAKAi6e3yfvQT3u689AECQQDdwezSYuzrtMdaDrZAn6c4AxgRsALhgkVZDZGSljSVX6VrcCm6WRs0d9tmlCfHKghcUjGY8+rxtKiN3Eed7j5JAkEAtn3xKWzNOVLZjS8tq3Fy52EsDXiRIPUcfMyvvCOc274P+nymyZs2p+OAixS0f4xJxjvYqCeFTEnfGYdJ9tjOUQJAOI/aI99vpr85idLu0ZTnRfYkEX7ffT2JCqnXU5hUWTVIMBsvyYQo2D0qDQQFEVu7PjEIzYaJipUV2PkymynFYQJANuGHLhsPWMbmsAPZKy7yDE13zxFMK+oqyAlSbDUVjiwJaB4mloi8Fh9f3/O5GIabBSeoT2GbP8cTdfzurHKlEQJANgxyhWl+puyYYSo56RsN23jL7ffPXkHdMhdFQY3UXm5jg0AwD5r3rYMDzl+xRNMAWNAbl409tsNSTC97ub/0DA==");

    Pattern publicKeyPattern = Pattern.compile("\\*\\*\\*\\*publicKey start\\*{5}(.+?)\\*{4}publicKey end\\*{4}");
    Pattern privateKeyPattern = Pattern
        .compile("\\*\\*\\*\\*privateKey start\\*{5}(.+?)\\*{4}privateKey end\\*{4}");

    // Use Matchers to find matches
    Matcher publicKeyMatcher = publicKeyPattern.matcher(key);
    Matcher privateKeyMatcher = privateKeyPattern.matcher(key);

    if (publicKeyMatcher.find()) {
      String publicKeyValue = publicKeyMatcher.group(1).trim();
      System.out.println("Public Key: " + publicKeyValue);
    }

    if (privateKeyMatcher.find()) {
      String privateKeyValue = privateKeyMatcher.group(1).trim();
      System.out.println("Private Key: " + privateKeyValue);
    }

  }

  private void btn_refleshUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_refleshUserActionPerformed
    this.InitData("", "", "");
  }// GEN-LAST:event_btn_refleshUserActionPerformed

  private void btn_editUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_editUserActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_btn_editUserActionPerformed

  private void btn_addUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_addUserActionPerformed
    User user = new User(
        txt_Username.getText(),
        txt_Password.getText(),
        "");

    boolean isAdded = false;

    if (cb_UserRole.getSelectedItem() == "RKhachHang") {
      isAdded = userDb.createUserKhachHang(user);
    }

    if (cb_UserRole.getSelectedItem() == "RQuanLi") {
      isAdded = userDb.createUserQuanLi(user);
    }

    JOptionPane.showMessageDialog(rootPane,
        isAdded ? "thêm thành công" : "thêm thất bại vui lòng kiểm tra lại dữ liệu đầu vào");
    this.InitData("", "", "");
  }

  private void txt_searchUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_searchUserActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_txt_searchUserActionPerformed

  private void btn_searchUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_searchUserActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_btn_searchUserActionPerformed

  private Supplier mapRowToSupplier(int selectedRow) {
    // Retrieve the data from the selected row and create a Supplier object
    Supplier supplier = new Supplier();
    supplier.setSupplierId((int) listSupplier.getValueAt(selectedRow, 0));
    supplier.setSupplierName((String) listSupplier.getValueAt(selectedRow, 1));
    supplier.setContactName((String) listSupplier.getValueAt(selectedRow, 2));
    supplier.setContactEmail((String) listSupplier.getValueAt(selectedRow, 3));
    supplier.setContactPhone((String) listSupplier.getValueAt(selectedRow, 4));
    supplier.setAddress((String) listSupplier.getValueAt(selectedRow, 5));
    supplier.setCity((String) listSupplier.getValueAt(selectedRow, 6));
    supplier.setState((String) listSupplier.getValueAt(selectedRow, 7));
    supplier.setPostalCode((String) listSupplier.getValueAt(selectedRow, 8));
    supplier.setCountry((String) listSupplier.getValueAt(selectedRow, 9));

    return supplier;
  }

  private User mapRowUser(int selectedRow) {
    // Retrieve the data from the selected row and create a Supplier object
    User user = new User();
    user.setUserName((String) listUser.getValueAt(selectedRow, 0));

    return user;
  }

  private Category mapToCategory(int selectedRow) {
    // Retrieve the data from the selected row and create a Supplier object
    Category category = new Category();
    category.setCategoryId((int) listCategory.getValueAt(selectedRow, 0));
    category.setCategoryName((String) listCategory.getValueAt(selectedRow, 1));
    return category;
  }

  private Product mapToProduct(int selectedRow) {
    Product product = new Product();
    product.setProductId((int) listProduct.getValueAt(selectedRow, 0));
    product.setProductName((String) listProduct.getValueAt(selectedRow, 1));
    product.setCategoryId((int) listProduct.getValueAt(selectedRow, 2));
    product.setPrice((double) listProduct.getValueAt(selectedRow, 3));
    product.setDesc((String) listProduct.getValueAt(selectedRow, 4));

    return product;
  }

  private void listSupplierMouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = listSupplier.getSelectedRow();
    if (selectedRow >= 0) {
      selectedSupplier = mapRowToSupplier(selectedRow);
      txt_SupplierID.setText(String.valueOf(selectedSupplier.getSupplierId()));
      txt_SupplierName.setText(selectedSupplier.getSupplierName());
      txt_ContactName.setText(selectedSupplier.getContactName());
      txt_ContactEmail.setText(selectedSupplier.getContactEmail());
      txt_ContactPhone.setText(selectedSupplier.getContactPhone());
      txt_Address.setText(selectedSupplier.getAddress());
      txt_City.setText(selectedSupplier.getCity());
      txt_State.setText(selectedSupplier.getState());
      txt_PostalCode.setText(selectedSupplier.getPostalCode());
      txt_Contry.setText(selectedSupplier.getCountry());
    }

  }

  private void listCategoryMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listCategoryMouseClicked
    int selectedRow = listCategory.getSelectedRow();
    if (selectedRow >= 0) {
      selectedCategory = mapToCategory(selectedRow);
      txt_CategoryId.setText(String.valueOf(selectedCategory.getCategoryId()));
      txt_CategoryName.setText(String.valueOf(selectedCategory.getCategoryName()));
    }
  }// GEN-LAST:event_listCategoryMouseClicked

  private void listProductMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listProductMouseClicked
    int selectedRow = listProduct.getSelectedRow();
    if (selectedRow >= 0) {
      productSelected = mapToProduct(selectedRow);

      txt_ProductId.setText(String.valueOf(productSelected.getProductId()));
      txt_ProductName.setText(String.valueOf(productSelected.getProductName()));
      txt_CategoryProduct.setText(String.valueOf(productSelected.getCategoryId()));
      txt_ProductPrice.setText(String.valueOf(productSelected.getPrice()));
      txt_ProductDesc.setText(String.valueOf(productSelected.getDesc()));

    }
  }// GEN-LAST:event_listProductMouseClicked

  private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_exitActionPerformed
    this.dispose();
  }// GEN-LAST:event_btn_exitActionPerformed

  private void btn_editSupplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_editSupplierActionPerformed
    if (selectedSupplier != null) {
      Supplier supplier = new Supplier(
          Integer.parseInt(txt_SupplierID.getText()),
          txt_SupplierName.getText(),
          txt_ContactName.getText(),
          txt_ContactEmail.getText(),
          txt_ContactPhone.getText(),
          txt_Address.getText(),
          txt_City.getText(),
          txt_State.getText(),
          txt_PostalCode.getText(),
          txt_Contry.getText());

      boolean isUpdated = supplierDB.updateSupplier(supplier);
      JOptionPane.showMessageDialog(rootPane,
          isUpdated ? "update thành công" : "update thất bại vui lòng kiểm tra lại dữ liệu đầu vào");
      this.InitData("", "", "");

    }
  }// GEN-LAST:event_btn_editSupplierActionPerformed

  private void btn_addSupplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_addSupplierActionPerformed
    Supplier supplier = new Supplier(
        0,
        txt_SupplierName.getText(),
        txt_ContactName.getText(),
        txt_ContactEmail.getText(),
        txt_ContactPhone.getText(),
        txt_Address.getText(),
        txt_City.getText(),
        txt_State.getText(),
        txt_PostalCode.getText(),
        txt_Contry.getText());

    boolean isAdded = supplierDB.createSupplier(supplier);
    JOptionPane.showMessageDialog(rootPane,
        isAdded ? "thêm thành công" : "thêm thất bại vui lòng kiểm tra lại dữ liệu đầu vào");
    this.InitData("", "", "");

  }// GEN-LAST:event_btn_addSupplierActionPerformed

  private void btn_deleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deleteSupplierActionPerformed
    if (selectedSupplier != null) {
      boolean isDeleted = supplierDB.deleteSupplier(selectedSupplier.getSupplierId());
      JOptionPane.showMessageDialog(rootPane,
          isDeleted ? "xoá thành công" : "xoá thất bại");
      this.InitData("", "", "");

    }
  }// GEN-LAST:event_btn_deleteSupplierActionPerformed

  private void btn_refleshSupplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_refleshSupplierActionPerformed
    this.InitData("", "", "");
  }// GEN-LAST:event_btn_refleshSupplierActionPerformed

  private void btn_userInfoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_userInfoActionPerformed

  }

  private void btn_searchSupplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_searchSupplierActionPerformed
    String search = txt_searchSupplier.getText();

    if (!search.isEmpty()) {
      this.InitData(search, "", "");
    }
  }

  private void btn_refleshCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_refleshCategoryActionPerformed
    this.InitData("", "", "");
  }// GEN-LAST:event_btn_refleshCategoryActionPerformed

  private void txt_searchCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_searchCategoryActionPerformed

  }

  private void btn_seachCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_seachCategoryActionPerformed
    String search = txt_searchCategory.getText();

    if (!search.isEmpty()) {
      this.InitData("", search, "");
    }
  }// GEN-LAST:event_btn_seachCategoryActionPerformed

  private void btn_editCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_editCategoryActionPerformed
    if (selectedCategory != null) {
      Category category = new Category(
          Integer.parseInt(txt_CategoryId.getText()),
          txt_CategoryName.getText());

      boolean isUpdated = categoryDB.updateCategory(category);
      JOptionPane.showMessageDialog(rootPane,
          isUpdated ? "update thành công" : "update thất bại vui lòng kiểm tra lại dữ liệu đầu vào");
      this.InitData("", "", "");
    }
  }

  private void btn_addCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_addCategoryActionPerformed
    Category category = new Category(
        0,
        txt_CategoryName.getText());
    boolean isAdded = categoryDB.createCategory(category);
    JOptionPane.showMessageDialog(rootPane,
        isAdded ? "thêm thành công" : "thêm thất bại vui lòng kiểm tra lại dữ liệu đầu vào");
    this.InitData("", "", "");

  }// GEN-LAST:event_btn_addCategoryActionPerformed

  private void btn_deleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deleteCategoryActionPerformed
    if (selectedCategory != null) {
      boolean isDeleted = categoryDB.deleteCategory(selectedCategory.getCategoryId());
      JOptionPane.showMessageDialog(rootPane,
          isDeleted ? "xoá thành công" : "xoá thất bại");
      this.InitData("", "", "");

    }
  }// GEN-LAST:event_btn_deleteCategoryActionPerformed

  private void btn_refleshProductActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_refleshProductActionPerformed
    this.InitData("", "", "");
  }

  private void txt_searchProductActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_searchProductActionPerformed

  }

  private void btn_searchProductActionPerformed(java.awt.event.ActionEvent evt) {
    String search = txt_searchProduct.getText();

    if (!search.isEmpty()) {
      this.InitData(search, "", search);
    }
  }

  private void btn_editProductActionPerformed(java.awt.event.ActionEvent evt) {
    if (productSelected != null) {
      Product product = new Product(
          productSelected.getProductId(),
          txt_ProductName.getText(),
          Integer.parseInt(txt_CategoryProduct.getText()),
          txt_ProductDesc.getText(),
          Double.parseDouble(txt_ProductPrice.getText()));

      boolean isUpdated = productDB.updateProduct(product);
      JOptionPane.showMessageDialog(rootPane,
          isUpdated ? "update thành công" : "update thất bại vui lòng kiểm tra lại dữ liệu đầu vào");
      this.InitData("", "", "");
    }
  }

  private void txt_addProductActionPerformed(java.awt.event.ActionEvent evt) {
    Product product = new Product(
        0,
        txt_ProductName.getText(),
        Integer.parseInt(txt_CategoryProduct.getText()),
        txt_ProductDesc.getText(),
        Double.parseDouble(txt_ProductPrice.getText()));

    boolean isAdded = productDB.createProduct(product);
    JOptionPane.showMessageDialog(rootPane,
        isAdded ? "thêm thành công" : "thêm thất bại vui lòng kiểm tra lại dữ liệu đầu vào");
    this.InitData("", "", "");
  }

  private void btn_deleteProductActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deleteProductActionPerformed
    if (productSelected != null) {
      boolean isDeleted = productDB.deleteProduct(productSelected.getProductId());
      JOptionPane.showMessageDialog(rootPane,
          isDeleted ? "xoá thành công" : "xoá thất bại");
      this.InitData("", "", "");

    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel action_cat;
  private javax.swing.JPanel action_log;
  private javax.swing.JPanel action_pro;
  private javax.swing.JPanel action_sup;
  private javax.swing.JButton btn_addCategory;
  private javax.swing.JButton btn_addSupplier;
  private javax.swing.JButton btn_addUser;
  private javax.swing.JButton btn_checkKey;
  private javax.swing.JButton btn_deleteCategory;
  private javax.swing.JButton btn_deleteProduct;
  private javax.swing.JButton btn_deleteSupplier;
  private javax.swing.JButton btn_deleteUser;
  private javax.swing.JButton btn_editCategory;
  private javax.swing.JButton btn_editProduct;
  private javax.swing.JButton btn_editSupplier;
  private javax.swing.JButton btn_generatorKey;
  private javax.swing.JMenuItem btn_logout;
  private javax.swing.JButton btn_refleshCategory;
  private javax.swing.JButton btn_refleshLog;
  private javax.swing.JButton btn_refleshProduct;
  private javax.swing.JButton btn_refleshSupplier;
  private javax.swing.JButton btn_refleshUser;
  private javax.swing.JButton btn_seachCategory;
  private javax.swing.JButton btn_searchProduct;
  private javax.swing.JButton btn_searchSupplier;
  private javax.swing.JButton btn_searchUser;
  private final javax.swing.JMenuItem btn_userInfo = new javax.swing.JMenuItem();
  private javax.swing.JTextField cat_txtCheck;
  private javax.swing.JButton cate_btnKey;
  private javax.swing.JComboBox<String> cb_UserRole;
  private javax.swing.JPanel infoCategory;
  private javax.swing.JPanel infoProduct;
  private javax.swing.JPanel infoSupplier;
  private javax.swing.JPanel infoUser;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel20;
  private javax.swing.JLabel jLabel21;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JLabel jLabel23;
  private javax.swing.JLabel jLabel24;
  private javax.swing.JLabel jLabel25;
  private javax.swing.JLabel jLabel26;
  private javax.swing.JLabel jLabel28;
  private javax.swing.JLabel jLabel29;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel33;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator2;
  private javax.swing.JSeparator jSeparator3;
  private javax.swing.JSeparator jSeparator4;
  private javax.swing.JSeparator jSeparator5;
  private javax.swing.JTable listCategory;
  private javax.swing.JTable listLog;
  private javax.swing.JTable listProduct;
  private javax.swing.JTable listSupplier;
  private javax.swing.JTable listUser;
  private javax.swing.JTable list_actionCat;
  private javax.swing.JTable list_actionLog;
  private javax.swing.JTable list_actionPro;
  private javax.swing.JTable list_actionSup;
  private javax.swing.JPanel mainLog;
  private javax.swing.JTabbedPane mainPanel;
  private javax.swing.JMenuBar menuPanel;
  private javax.swing.JMenu menu_File;
  private javax.swing.JPanel panel_Category;
  private javax.swing.JPanel panel_Log;
  private javax.swing.JPanel panel_Product;
  private javax.swing.JPanel panel_Supplier;
  private javax.swing.JPanel panel_User;
  private javax.swing.JTabbedPane panel_actions;
  private javax.swing.JButton pro_btnKey;
  private javax.swing.JTextField pro_txtKey;
  private javax.swing.JButton sup_btnKey;
  private javax.swing.JTextField sup_txtKey;
  private javax.swing.JScrollPane tableCategory;
  private javax.swing.JScrollPane tableLog;
  private javax.swing.JScrollPane tableProduct;
  private javax.swing.JScrollPane tableSuplier;
  private javax.swing.JScrollPane tableUser;
  private javax.swing.JScrollPane table_actionCat;
  private javax.swing.JScrollPane table_actionLog;
  private javax.swing.JScrollPane table_actionPro;
  private javax.swing.JScrollPane table_actionSup;
  private javax.swing.JTextField txt_Address;
  private javax.swing.JTextField txt_CategoryId;
  private javax.swing.JTextField txt_CategoryName;
  private javax.swing.JTextField txt_CategoryProduct;
  private javax.swing.JTextField txt_City;
  private javax.swing.JTextField txt_ContactEmail;
  private javax.swing.JTextField txt_ContactName;
  private javax.swing.JTextField txt_ContactPhone;
  private javax.swing.JTextField txt_Contry;
  private javax.swing.JTextField txt_Password;
  private javax.swing.JTextField txt_PostalCode;
  private javax.swing.JTextArea txt_ProductDesc;
  private javax.swing.JTextField txt_ProductId;
  private javax.swing.JTextField txt_ProductName;
  private javax.swing.JTextField txt_ProductPrice;
  private javax.swing.JTextField txt_State;
  private javax.swing.JTextField txt_SupplierID;
  private javax.swing.JTextField txt_SupplierName;
  private javax.swing.JTextField txt_Username;
  private javax.swing.JButton txt_addProduct;
  private javax.swing.JTextField txt_checkKey;
  private javax.swing.JTextField txt_searchCategory;
  private javax.swing.JTextField txt_searchProduct;
  private javax.swing.JTextField txt_searchSupplier;
  private javax.swing.JTextField txt_searchUser;
  private javax.swing.JButton user_btnKey;
  private javax.swing.JTextField user_txtKey;

  // End of variables declaration//GEN-END:variables
}
