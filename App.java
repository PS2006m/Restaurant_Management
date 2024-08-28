import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.sql.*;
import java.io.*;
class MainFrame extends JFrame {  //The MainFrame to show first panels of Code
    public static MainFrame mainf;
    public Font mainFont = new Font("Segoe Print", Font.BOLD, 18);
    public Font smallFont = new Font("Segoe Print", Font.BOLD, 10);
    
    public JLabel lbWelcome;
    int tableno;
    Dimension maxSize=new Dimension(300,400);
    //calls the initialize method
    public MainFrame() { 
        initialize();
    }
    // Allows the User to login with correct id
    public void initialize() { 
       
        lbWelcome = new JLabel("Admin Login");
        lbWelcome.setFont(mainFont);
        lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblAdminId = new JLabel("Admin ID:");
        lblAdminId.setFont(mainFont);

        JTextField ufAdminId = new JTextField(20);
        ufAdminId.setFont(mainFont);

        JPanel formPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        formPanel.add(lblAdminId);
        formPanel.add(ufAdminId);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(smallFont);
        btnSubmit.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    if((ufAdminId.getText().isEmpty()))
                    {
                        JOptionPane.showMessageDialog(MainFrame.this, "Enter Admin ID");
                    }
                    else 
                    {
                        int i=Integer.parseInt(ufAdminId.getText());
                        if(i==1||i==2)
                        {
                            startProgram();
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(MainFrame.this, "Wrong Admin Id");
                            ufAdminId.setText("");
                        }
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Admin Id is Integer , Enter a Number");
                    ufAdminId.setText("");
                    
                }
            }
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                ufAdminId.setText("");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnClear);


        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.YELLOW);
        mainPanel.add(lbWelcome, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel);

   
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);
        setVisible(true);
        }
        //starts the program after entering correct id
        public void startProgram() 
        {
            
            lbWelcome = new JLabel("Welcome");
            lbWelcome.setFont(mainFont);
            lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);
            StaffPanel sp=new StaffPanel(this);
            UserPanel up=new UserPanel(this);
            MenuPanel mp=new MenuPanel(this);
            JButton btnUser = new JButton("User");
            btnUser.setFont(mainFont);
            btnUser.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    up.userPanel();
                }
            });

            JButton btnOrder = new JButton("Menu");
            btnOrder.setFont(mainFont);
            btnOrder.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    mp.start();
                }
            });

            JButton btnStaff = new JButton("Staff");
            btnStaff.setFont(mainFont);
            btnStaff.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    sp.staffPanel();
                }
            });

            JButton btnLogOut =new JButton("Log Out");
            btnLogOut.setFont(mainFont);
            btnLogOut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    initialize();
                }
            });
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1000, 50));
            buttonPanel.setBackground(Color.BLUE);
            buttonPanel.add(btnOrder);
            buttonPanel.add(btnStaff);
            buttonPanel.add(btnUser);
            buttonPanel.add(btnLogOut);

            

            JPanel startPanel = new JPanel(new BorderLayout());
            startPanel.setBackground(Color.YELLOW);
            startPanel.add(lbWelcome, BorderLayout.NORTH);
            startPanel.add(buttonPanel, BorderLayout.CENTER);

            getContentPane().removeAll();
            getContentPane().add(startPanel);
            revalidate();

            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(startPanel);

            setTitle("Welcome");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 500);
            setResizable(false);
            setVisible(true);
    }
}
class MenuPanel extends JFrame //Contains methods regarding menu
{
  
    static public Font mainFont = new Font("Segoe Print", Font.BOLD, 18);
    static public Font smallFont = new Font("Segoe Print", Font.BOLD, 10);
    static Dimension maxSize=new Dimension(300,400);
    static public JLabel lbWelcome;
    static MainFrame mainf;
    MenuPanel(MainFrame mainf)
    {
        this.mainf=mainf;
    }
    //Shows different options which can be done on the menu
    public void start() 
    {
        lbWelcome=new JLabel("Menu Panel");
        lbWelcome.setFont(mainFont);
        MenuPanel mp=new MenuPanel(mainf);
        JButton btnBack=new JButton("Back");
        btnBack.setFont(mainFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                mainf.startProgram();
            }
            
        });
        JButton btnInsertMenu=new JButton("Insert New Dish");
        btnInsertMenu.setFont(mainFont);
        btnInsertMenu.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                mp.insertMenu();
            
            }
            
        });

        JButton btnAddOrder=new JButton("View Menu");
        btnAddOrder.setFont(mainFont);
        btnAddOrder.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                mp.viewMenu();
            
            }
            
        });
        JButton btnGenerateBill=new JButton("Update Menu");
        btnGenerateBill.setFont(mainFont);
        btnGenerateBill.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                mp.updateMenu();
            }
            
        });

        JButton btnDeleteMenu=new JButton("Delete Menu");
        btnDeleteMenu.setFont(mainFont);
        btnDeleteMenu.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                mp.deleteMenu();
            
            }
            
        });

        JPanel buttonPanel = new JPanel(new  FlowLayout(FlowLayout.CENTER, 1000, 30));
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnAddOrder);
        buttonPanel.add(btnInsertMenu);
        buttonPanel.add(btnGenerateBill);
        buttonPanel.add(btnDeleteMenu);
        buttonPanel.add(btnBack);

        JPanel Orderpanel = new JPanel(new BorderLayout());
        Orderpanel.setBackground(new Color(128, 128, 255));
        Orderpanel.add(lbWelcome, BorderLayout.NORTH);
        Orderpanel.add(buttonPanel, BorderLayout.CENTER);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(Orderpanel);
        mainf.setSize(400,500);
        mainf.revalidate();
    }
    //Allows to enter a new dish
    public void insertMenu() 
    {
        lbWelcome=new JLabel("Insert Menu");
        lbWelcome.setFont(mainFont);
        JLabel lbname=new JLabel("Enter Menu Name");
        lbname.setFont(mainFont);
        JTextField ufname=new JTextField(20);
        ufname.setFont(mainFont);
        JLabel lbprice=new JLabel("Price");
        lbprice.setFont(mainFont);
        JTextField ufprice=new JTextField(20);
        ufprice.setFont(mainFont);
        JPanel formPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        formPanel.add(lbname);
        formPanel.add(ufname);
        formPanel.add(lbprice);
        formPanel.add(ufprice);
        MenuPanel mp2=new MenuPanel(mainf);
        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mp2.start();
            }
        });

        JButton btnClear=new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
               ufname.setText("");
               ufprice.setText("");
            }
            
        });

        JButton btnInsert=new JButton("Insert");
        btnInsert.setFont(mainFont);
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);
                    String dburl = "jdbc:mysql://localhost:3306/java_project";
                    String dbuser = "root";
                    String dbpass = "";
                    Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                    String sql="Insert into view_menu(view_menu_name,view_menu_price) values (?,?)";
                    PreparedStatement pst=con.prepareStatement(sql);
                    String name=ufname.getText();
                    double price=Double.parseDouble(ufprice.getText());
                    pst.setString(1,name);
                    pst.setDouble(2,price);
                    int r=pst.executeUpdate();
                    if(r>0)
                    {
                        JOptionPane.showMessageDialog(mainf,"Dish Successfully added");
                        ufname.setText("");
                        ufprice.setText("");
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(mainf,"Did not add Dish , Enter again");
                        ufname.setText("");
                        ufprice.setText("");
                    }
                } catch (Exception ei) {
                    JOptionPane.showMessageDialog(mainf,"Exception Occured");
                    ufname.setText("");
                    ufprice.setText("");
                    
                }
            }
        });
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnInsert,BorderLayout.NORTH);
        buttonPanel.add(btnClear,BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);
        
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(formPanel, BorderLayout.CENTER);
        viewPanel.add(buttonPanel,BorderLayout.SOUTH);

        mainf.setSize(600, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
        
    }
     //Allows to delete a dish
    public void deleteMenu()
    {
        lbWelcome=new JLabel("Delete Menu");
        lbWelcome.setFont(mainFont);
        JLabel lbid=new JLabel("Enter Menu ID");
        lbid.setFont(mainFont);
        JTextField ufid=new JTextField(20);
        ufid.setFont(mainFont);
        JPanel formPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        formPanel.add(lbid);
        formPanel.add(ufid);
        MenuPanel mp2=new MenuPanel(mainf);
        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mp2.start();
            }
        });

        JButton btnClear=new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
               ufid.setText("");
            }
            
        });

        JButton btnInsert=new JButton("Delete");
        btnInsert.setFont(mainFont);
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);
                    String dburl = "jdbc:mysql://localhost:3306/java_project";
                    String dbuser = "root";
                    String dbpass = "";
                    Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                    String sql="delete from view_menu where view_menu_id=?";
                    PreparedStatement pst=con.prepareStatement(sql);
                    int id=Integer.parseInt(ufid.getText());
                    pst.setDouble(1,id);
                    int r=pst.executeUpdate();
                    if(r>0)
                    {
                        JOptionPane.showMessageDialog(mainf,"Dish Successfully Deleted");
                        ufid.setText("");
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(mainf,"Did not add get deleted , Enter again");
                        ufid.setText("");
                    }
                } catch (Exception ei) {
                    JOptionPane.showMessageDialog(mainf,"Exception Occured");
                    ufid.setText("");
                    
                }
            }
        });
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnInsert,BorderLayout.NORTH);
        buttonPanel.add(btnClear,BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);
        
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(formPanel, BorderLayout.CENTER);
        viewPanel.add(buttonPanel,BorderLayout.SOUTH);

        mainf.setSize(600, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
    //Checks if the dish id Admin wants to update exists or not
    public void updateMenu()  
    {
        lbWelcome=new JLabel("Update Menu");
        lbWelcome.setFont(mainFont);
        JLabel lfid=new JLabel("ID");
        lfid.setFont(mainFont);
        JTextField  ufid=new JTextField(20);
        ufid.setFont(mainFont);
        MenuPanel mp2=new MenuPanel(mainf);
        JPanel formPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        formPanel.add(lfid);
        formPanel.add(ufid);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mp2.start();
            }
        });
        JButton btnUpdate=new JButton("Update");
        btnUpdate.setFont(mainFont);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);
                    String dburl = "jdbc:mysql://localhost:3306/java_project";
                    String dbuser = "root";
                    String dbpass = "";
                    Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                    String sql="Select view_menu_id from view_menu";
                    PreparedStatement pstr=con.prepareStatement(sql);
                    boolean check=false;
                    ResultSet rst=pstr.executeQuery();
                    int i=0;
                    while(rst.next())
                    {
                        i=rst.getInt("view_menu_id");
                        int j=Integer.parseInt(ufid.getText());
                        if(i==j)
                        {
                            check=true;
                            break;
                        }
                    }
                    if(check)
                    {
                       update(i);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(mainf,"Menu ID does not exist");
                    }
                } catch (Exception e34) {
                    JOptionPane.showMessageDialog(mainf,"Exception occured");
                    e34.printStackTrace();
                    
                }
            }
        });
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnUpdate,BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);
        
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(formPanel, BorderLayout.CENTER);
        viewPanel.add(buttonPanel,BorderLayout.SOUTH);

        mainf.setSize(600, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
    //Allows to update menu
    public static void update(int id) 
    {
        MenuPanel mp=new MenuPanel(mainf);
        JLabel lfname=new JLabel("Name");
        lfname.setFont(mainFont);
        JTextField ufname=new JTextField(20);
        ufname.setFont(mainFont);
        JLabel lfprice=new JLabel("Price");
        lfprice.setFont(mainFont);
        JTextField ufprice=new JTextField(20);
        ufprice.setFont(mainFont);
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String dburl = "jdbc:mysql://localhost:3306/java_project";
            String dbuser = "root";
            String dbpass = "";
            Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
            PreparedStatement pstc=con.prepareStatement("Select view_menu_name,view_menu_price from view_menu where view_menu_id=?");
            pstc.setInt(1,id);
            ResultSet rt=pstc.executeQuery();
            while(rt.next())
            {
                ufname.setText(rt.getString("view_menu_name"));
                String line=Double.toString(rt.getDouble("view_menu_price"));
                ufprice.setText(line);
            }
        } catch (Exception exw) {
            JOptionPane.showMessageDialog(mainf,"Exception occured");
            
        }
        JPanel formPanel=new JPanel(new GridLayout(2, 1, 5, 5));
        formPanel.add(lfname);
        formPanel.add(ufname);
        formPanel.add(lfprice);
        formPanel.add(ufprice);

        JButton btnUpdate=new JButton("Update");
        btnUpdate.setFont(mainFont);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);
                    String dburl = "jdbc:mysql://localhost:3306/java_project";
                    String dbuser = "root";
                    String dbpass = "";
                    Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                    String sqlww="Update view_menu set view_menu_name=?,view_menu_price=? where view_menu_id=?";
                    PreparedStatement psrt=con.prepareStatement(sqlww);
                    double price=Double.parseDouble(ufprice.getText());
                    psrt.setString(1, ufname.getText());
                    psrt.setDouble(2,price);
                    psrt.setInt(3,id);
                    int r=psrt.executeUpdate();
                    if(r>0)
                    {
                        JOptionPane.showMessageDialog(mainf,"Menu changed ");
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(mainf,"No changed happened");
                    }
                } catch (Exception ewd) {
                    JOptionPane.showMessageDialog(mainf,"Exception occured");
                    ewd.printStackTrace();
                    
                }
            }
        });
        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mp.updateMenu();
            }
        });
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnUpdate,BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);

        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(formPanel, BorderLayout.CENTER);
        viewPanel.add(buttonPanel,BorderLayout.SOUTH);

        mainf.setSize(600, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
    //Simply fetcjes data from view_menu
    public Object[][] fetchMenuData() { 
        ArrayList<Object[]> menuData = new ArrayList<>();
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String dburl = "jdbc:mysql://localhost:3306/java_project";
            String dbuser = "root";
            String dbpass = "";
            Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
            String sql = "SELECT * FROM view_menu";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("view_menu_id");
                String name = rs.getString("view_menu_name");
                double price=rs.getDouble("view_menu_price");
                menuData.add(new Object[]{id, name,price});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuData.toArray(new Object[0][]);
    }
    //Allows to view menu
    public void viewMenu() 
    {
        lbWelcome = new JLabel("Menu");
        lbWelcome.setFont(mainFont);lbWelcome = new JLabel("Menu");
        String[] columnNames = {"ID", "Name","Price"};
        Object[][] data = fetchMenuData();

        JTable menuTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(menuTable);
        MenuPanel mp=new MenuPanel(mainf);
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(scrollPane, BorderLayout.CENTER);

        OrderPanel op=new OrderPanel(mainf);

        JButton btnOrder=new JButton("Place Order");
        btnOrder.setFont(mainFont);
        btnOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                op.init();
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mp.start();
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnOrder,BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);
        

        viewPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainf.setSize(600, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
}
class OrderPanel extends JFrame //Contains methods regarding order
{
    public Font mainFont = new Font("Segoe Print", Font.BOLD, 18);
    public Font smallFont = new Font("Segoe Print", Font.BOLD, 10);
    Dimension maxSize=new Dimension(300,400);
    public JLabel lbWelcome;
    MainFrame mainf;
    OrderPanel(MainFrame mainf)
    {
        this.mainf=mainf;
    }
    //Shows different button (options) available
    public void init() 
    {
        OrderPanel op=new OrderPanel(mainf);
        MenuPanel mp=new MenuPanel(mainf);
        lbWelcome=new JLabel("Order");
        lbWelcome.setFont(mainFont);
        lbWelcome.setBackground(Color.YELLOW);
        JButton btnBack=new JButton("Back");
        btnBack.setFont(mainFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                mp.viewMenu();
            }
            
        });
        JButton btnAddOrder=new JButton("Add Order");
        btnAddOrder.setFont(mainFont);
        btnAddOrder.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                op.addOrder();
            }
            
        });
        JButton btnGenerateBill=new JButton("Generate Bill");
        btnGenerateBill.setFont(mainFont);
        btnGenerateBill.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
               op.removeOrder();
            }
            
        });
        JPanel buttonPanel = new JPanel(new  FlowLayout(FlowLayout.CENTER, 1000, 50));
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnAddOrder, BorderLayout.NORTH);
        buttonPanel.add(btnGenerateBill,BorderLayout.CENTER);
        buttonPanel.add(btnBack,BorderLayout.SOUTH);

        JPanel Orderpanel = new JPanel(new BorderLayout());
        Orderpanel.setBackground(new Color(128, 128, 255));
        Orderpanel.add(lbWelcome, BorderLayout.NORTH);
        Orderpanel.add(buttonPanel, BorderLayout.CENTER);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(Orderpanel);
        mainf.setSize(400,500);
        mainf.revalidate();
    }   
    //Allows To Generate bill based on table
    public void removeOrder() 
    {
        lbWelcome=new JLabel("Bill");
        lbWelcome.setFont(mainFont);
        JLabel lfTb=new JLabel("Table Number");
        lfTb.setFont(mainFont);
        JTextField ufTb=new JTextField(20);
        ufTb.setFont(mainFont);

        JPanel formPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        formPanel.add(lfTb);
        formPanel.add(ufTb);

        JButton btnGenerate=new JButton("Generate");
        btnGenerate.setFont(smallFont);
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    if(ufTb.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(mainf,"Cannot leave field empty");
                    }
                    else 
                    {
                        String driverName = "com.mysql.cj.jdbc.Driver";
                        Class.forName(driverName);
                        String dburl = "jdbc:mysql://localhost:3306/java_project";
                        String dbuser = "root";
                        String dbpass = "";
                        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                        String sqlexe="Select sum(order_totalprice),order_tableno from order_table where order_tableno=?  group by order_tableno";
                        PreparedStatement pstexe=con.prepareStatement(sqlexe);
                        int tbn=Integer.parseInt(ufTb.getText());
                        if(!RestaurantManager.tbno.contains(tbn))
                        {
                            JOptionPane.showMessageDialog(mainf,"Table Number not found , enter correct value");
                            return;
                        }
                        pstexe.setInt(1,tbn);
                        ResultSet rstexe=pstexe.executeQuery();
                        boolean flaging=true;
                        ufTb.setText("");
                        while(rstexe.next())
                        {
                            double sum=rstexe.getDouble("sum(order_totalprice)");
                            if(sum==0)
                            {
                                JOptionPane.showMessageDialog(mainf,"Table has not ordered anything");
                                return;
                            }
                            flaging=false;
                            String line="Total Bill is "+sum;
                            JOptionPane.showMessageDialog(mainf,line);
                        }
                        if(flaging==false)
                        {
                            String sqldel="Delete from order_table where order_tableno=?";
                            PreparedStatement pstdel=con.prepareStatement(sqldel);
                            pstdel.setInt(1,tbn);   
                            int r=pstdel.executeUpdate();
                            String sqldelexe="delete from user where user_tableno=?";
                            PreparedStatement pstdelexe=con.prepareStatement(sqldelexe);
                            pstdelexe.setInt(1,tbn);   
                            int rdel=pstdelexe.executeUpdate();
                            if(rdel>0)
                            {
                                int t=RestaurantManager.tbno.indexOf(tbn);
                                RestaurantManager.tbno.remove(t);
                                User.totalTables++;
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(mainf,"Table has not ordered anything");
                            ufTb.setText("");
                        }
                    }
                } catch (Exception exe) {
                    JOptionPane.showMessageDialog(mainf,"Exception occured ,  enter again");
                    
                }
            }
        });

        JButton btnBack=new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                OrderPanel op=new OrderPanel(mainf);
                
                op.init();
            }
            
        });

        JButton btnClear=new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
               ufTb.setText("");
            }
            
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnGenerate, BorderLayout.NORTH);
        buttonPanel.add(btnClear,BorderLayout.CENTER);
        buttonPanel.add(btnBack,BorderLayout.SOUTH);

        JPanel removeOrderPanel = new JPanel(new BorderLayout());
        removeOrderPanel.setBackground(new Color(128, 128, 255));
        removeOrderPanel.add(lbWelcome, BorderLayout.NORTH);
        removeOrderPanel.add(formPanel, BorderLayout.CENTER);
        removeOrderPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(removeOrderPanel);
        mainf.setSize(400,500);
        mainf.revalidate();

    }
    //Allows to add an order
    public void addOrder() 
    {
        lbWelcome = new JLabel("Add Order");
        lbWelcome.setFont(mainFont);
        JLabel lborderId=new JLabel("ID");
        lborderId.setFont(mainFont);
        JTextField ufborderId=new JTextField(20);
        ufborderId.setFont(mainFont);
        JLabel lborderQuantity=new JLabel("Quantity");
        lborderQuantity.setFont(mainFont);
        JTextField uforderQuantity=new JTextField(20);
        uforderQuantity.setFont(mainFont);
        JLabel lbTableNo=new JLabel("Table Number");
        lbTableNo.setFont(mainFont);
        JTextField ufTableNo=new JTextField(20);
        ufTableNo.setFont(mainFont);
        MenuPanel mp=new MenuPanel(mainf);
        JButton btnAddOrder=new JButton("Add Order");
        btnAddOrder.setFont(mainFont);
        btnAddOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(ufborderId.getText().isEmpty()||uforderQuantity.getText().isEmpty()||ufTableNo.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(MainFrame.mainf,"Cannot leave any field empty");
                }
                else
                {
                    try {
                        String driverName = "com.mysql.cj.jdbc.Driver";
                        Class.forName(driverName);
                        String dburl = "jdbc:mysql://localhost:3306/java_project";
                        String dbuser = "root";
                        String dbpass = "";
                        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                        int id=Integer.parseInt(ufborderId.getText());
                        String sql = "SELECT view_menu_id FROM view_menu";
                        PreparedStatement pst = con.prepareStatement(sql);
                        ResultSet rs = pst.executeQuery();
                        boolean flag=false;
                        while(rs.next())
                        {
                            if(id==rs.getInt("view_menu_id"))
                            {
                                flag=true;
                                break;
                            }
                        }
                        if(flag)
                        {
                            int tb=Integer.parseInt(ufTableNo.getText());
                            boolean check=false;
                            sql="Select user_tableno from user";
                            PreparedStatement pst4=con.prepareStatement(sql);
                            ResultSet rst3=pst4.executeQuery();
                            while(rst3.next())
                            {
                                if(tb==rst3.getInt("user_tableno"))
                                {
                                    check=true;
                                    break;
                                }
                            }
                            if(check)
                            {
                                int quantity=Integer.parseInt(uforderQuantity.getText());
                                String sql1="Select view_menu_price from view_menu where view_menu_id=?";
                                PreparedStatement pst2=con.prepareStatement(sql1);
                                pst2.setInt(1,id);
                                ResultSet rst1=pst2.executeQuery();
                                double price=0;
                                while(rst1.next())
                                {
                                    price=rst1.getDouble("view_menu_price")*quantity;
                                }
                                String sql2="Insert into order_table values(?,?,?,?)";
                                PreparedStatement pst3=con.prepareStatement(sql2);
                                pst3.setInt(1,tb);
                                pst3.setInt(2,id);
                                pst3.setInt(3,quantity);
                                pst3.setDouble(4,price);
                                int r=pst3.executeUpdate();
                                uforderQuantity.setText("");
                                ufborderId.setText("");
                                ufTableNo.setText("");
                                if(r>0)
                                {
                                    JOptionPane.showMessageDialog(mainf,"Order placed");
                                }
                                else 
                                {
                                    JOptionPane.showMessageDialog(mainf,"Could not place order, Enter details again");
                                }
                            }   
                            else  
                            {
                                JOptionPane.showMessageDialog(mainf,"Enter correct table Number");
                                uforderQuantity.setText("");
                                ufborderId.setText("");
                                ufTableNo.setText("");
                            }
                        }
                        else 
                        {
                            throw new Exception();
                        }
                    } catch (Exception e7) {
                        JOptionPane.showMessageDialog(mainf,"Enter Proper Details");
                        uforderQuantity.setText("");
                        ufborderId.setText("");
                        ufTableNo.setText("");
                        // TODO: handle 
                    }
                }
            }
        });

        JButton btnBack=new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                OrderPanel op=new OrderPanel(mainf);
                
                op.init();
            }
            
        });

        JButton btnClear=new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                uforderQuantity.setText("");
                ufborderId.setText("");
                ufTableNo.setText("");
            }
            
        });
        JPanel formPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        formPanel.add(lborderId);
        formPanel.add(ufborderId);
        formPanel.add(lborderQuantity);
        formPanel.add(uforderQuantity);
        formPanel.add(lbTableNo);
        formPanel.add(ufTableNo);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnAddOrder, BorderLayout.NORTH);
        buttonPanel.add(btnClear,BorderLayout.CENTER);
        buttonPanel.add(btnBack,BorderLayout.SOUTH);

        JPanel addOrderPanel = new JPanel(new BorderLayout());
        addOrderPanel.setBackground(new Color(128, 128, 255));
        addOrderPanel.add(lbWelcome, BorderLayout.NORTH);
        addOrderPanel.add(formPanel, BorderLayout.CENTER);
        addOrderPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(addOrderPanel);
        mainf.setSize(400,500);
        mainf.revalidate();
    }
}
class UserPanel extends JFrame //Contains method regarding user (Customer)
{
    public Font mainFont = new Font("Segoe Print", Font.BOLD, 18);
    public Font smallFont = new Font("Segoe Print", Font.BOLD, 10);
    Dimension maxSize=new Dimension(300,400);
    public JLabel lbWelcome;
    MainFrame mainf;
    UserPanel(MainFrame mainf)
    {
        this.mainf=mainf;
    }
    //Allows to add user
    public void addUserPanel() 
    {
        
        JTextField ufFirstName, ufLastName;
        lbWelcome.setText("User Details");

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(mainFont);

        ufFirstName = new JTextField(20);
        ufFirstName.setFont(mainFont);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(mainFont);

        ufLastName = new JTextField(20);
        ufLastName.setFont(mainFont);

        Random random = new Random();

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(smallFont);
        btnSubmit.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                    
                try {
                    if (User.totalTables <= 0) {
                        JOptionPane.showMessageDialog(mainf, "Restaurant is full");
                        userPanel();
                    } else if (ufFirstName.getText().isEmpty() || ufLastName.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(mainf, "Cannot leave any field empty");
                    } else {
                        Random random = new Random();
                        int tableNo=0;
                        do {
                            tableNo = random.nextInt(50) + 1;
                        } while (RestaurantManager.tbno.contains(tableNo));
                        String firstName = ufFirstName.getText();
                        String lastName = ufLastName.getText();
                        User user = new User(tableNo, firstName, lastName);
                        int result = user.addUser(user);
                        if(result>0)
                        {
                            RestaurantManager.tbno.add(tableNo);
                        }
                        ufFirstName.setText("");
                        ufLastName.setText("");

                        if (result > 0) {
                            JOptionPane.showMessageDialog(mainf, "User information submitted successfully.");
                            User.totalTables--;
                        } else {
                            JOptionPane.showMessageDialog(mainf, "Could not connect to database");
                        }
                    }
                } catch (Exception e3) {
                    JOptionPane.showMessageDialog(mainf, "Could not enter User information");
                }
          }
        });

        JButton btnBack=new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                userPanel();
            }
            
        });

        JButton btnClear=new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                ufFirstName.setText("");
                ufLastName.setText("");
            }
            
        });

        JPanel formPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        formPanel.add(lblFirstName);
        formPanel.add(ufFirstName);
        formPanel.add(lblLastName);
        formPanel.add(ufLastName);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnSubmit, BorderLayout.NORTH);
        buttonPanel.add(btnClear,BorderLayout.CENTER);
        buttonPanel.add(btnBack,BorderLayout.SOUTH);

        JPanel addUserPanel = new JPanel(new BorderLayout());
        addUserPanel.setBackground(new Color(128, 128, 255));
        addUserPanel.add(lbWelcome, BorderLayout.NORTH);
        addUserPanel.add(formPanel, BorderLayout.CENTER);
        addUserPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(addUserPanel);
        mainf.revalidate();
    }
    //Allows to remove User
    public void removeUserPanel() 
    {
        lbWelcome=new JLabel("Remove User");
        lbWelcome.setText("Remove User");
        JLabel ulTableNo=new JLabel("Table Number");
        ulTableNo.setFont(mainFont);

        JTextField ufTableNo=new JTextField(20);
        ufTableNo.setFont(mainFont);
        
        JButton btnRemove=new JButton("Remove");
        btnRemove.setFont(mainFont);
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(ufTableNo.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(mainf,"Enter Table Number");
                }
                else
                {
                    try {
                        int tbno=Integer.parseInt(ufTableNo.getText());
                        String sql="Delete from user where user_tableno=?";
                        String driverName="com.mysql.cj.jdbc.Driver";
                        Class.forName(driverName);
                        String dburl="jdbc:mysql://localhost:3306/java_project";
                        String dbuser="root";
                        String dbpass="";
                        Main.con=DriverManager.getConnection(dburl, dbuser, dbpass);
                        PreparedStatement pst=Main.con.prepareStatement(sql);
                        pst.setInt(1,tbno);
                        String r=Integer.toString(pst.executeUpdate());
                        ufTableNo.setText("");
                        if(r.equals("1"))
                        {
                            JOptionPane.showMessageDialog(mainf,"User succesfully removed");
                            RestaurantManager.tbno.remove(RestaurantManager.tbno.indexOf(tbno));
                            User.totalTables++;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(mainf,"Removal failed , Enter detail properly");
                            ufTableNo.setText("");
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(mainf,"Removal failed , Enter detail properly");
                        ufTableNo.setText("");
                    }
                }
            }
        });
        JButton btnBack=new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                userPanel();
            }
            
        });

        JButton btnClear=new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                ufTableNo.setText("");
            }
            
        });

        JPanel formPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        formPanel.add(ulTableNo);
        formPanel.add(ufTableNo);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnRemove, BorderLayout.NORTH);
        buttonPanel.add(btnClear,BorderLayout.CENTER);
        buttonPanel.add(btnBack,BorderLayout.SOUTH);

        JPanel removeUserPanel = new JPanel(new BorderLayout());
        removeUserPanel.setBackground(new Color(128, 128, 255));
        removeUserPanel.add(lbWelcome, BorderLayout.NORTH);
        removeUserPanel.add(formPanel, BorderLayout.CENTER);
        removeUserPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(removeUserPanel);
        mainf.revalidate();

    }
    //Fetches User data from user table
    public Object[][] fetchUserData() { 
        ArrayList<Object[]> userData = new ArrayList<>();
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String dburl = "jdbc:mysql://localhost:3306/java_project";
            String dbuser = "root";
            String dbpass = "";
            Main.con = DriverManager.getConnection(dburl, dbuser, dbpass);
            String sql = "SELECT * FROM user";
            PreparedStatement pst = Main.con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int tableNo = rs.getInt("user_tableno");
                String firstName = rs.getString("user_fname");
                String lastName = rs.getString("user_lname");
                userData.add(new Object[]{tableNo, firstName, lastName});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData.toArray(new Object[0][]);
    }

     //Allows to view All the users
    public void viewUserPanel() {
        String[] columnNames = {"Table No", "First Name", "Last Name"};
        Object[][] data = fetchUserData();

        JTable userTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(userTable);

        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                userPanel();
            }
        });

        JPanel buttonPanel = new JPanel(new  BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnBack);

        viewPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainf.setSize(700, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
    //Different options for user
    public void userPanel() { 
        lbWelcome = new JLabel("User Panel");
        lbWelcome.setFont(mainFont);
        lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnAddUser = new JButton("Add User");
       btnAddUser.setFont(mainFont);
       btnAddUser.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                addUserPanel();
            }
        });

        JButton btnRemoveUser = new JButton("Remove User");
        btnRemoveUser.setFont(mainFont);
        btnRemoveUser.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                removeUserPanel();
            }
        });

        JButton btnViewUser=new JButton("View Users");
        btnViewUser.setFont(mainFont);
        btnViewUser.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                viewUserPanel();
            }
            
        });

        JButton btnBack=new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
               mainf.startProgram();
            }
            
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1000, 50));
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.add(btnAddUser);
        buttonPanel.add(btnRemoveUser);

        buttonPanel.add(btnViewUser);
        buttonPanel.add(btnBack);

        JPanel userPanel = new JPanel(new BorderLayout());
       userPanel.setBackground(Color.YELLOW);
       userPanel.add(lbWelcome, BorderLayout.NORTH);
       userPanel.add(buttonPanel, BorderLayout.CENTER);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(userPanel);
        mainf.revalidate();

        mainf.getContentPane().setLayout(new BorderLayout());
        mainf.getContentPane().add(userPanel);

        mainf.setTitle("Welcome");
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setSize(400, 500);
        mainf.setResizable(false);
        mainf.setVisible(true);
    }
}
class StaffPanel extends JFrame //Contains method  regarding staff
{
    static public Font mainFont = new Font("Segoe Print", Font.BOLD, 18);
    static  public Font smallFont = new Font("Segoe Print", Font.BOLD, 10);
    static Dimension maxSize=new Dimension(300,400);
    static public JLabel lbWelcome;
    static MainFrame mainf;
    StaffPanel(MainFrame mainf)
    {
        this.mainf=mainf;
    }
    //Has different buttons (option) regarding staff
    public void staffPanel() 
    {
        lbWelcome = new JLabel("Staff Panel");
        lbWelcome.setFont(mainFont);
        lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnAddStaff = new JButton("Add Staff");
       btnAddStaff.setFont(mainFont);
       btnAddStaff.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                addStaffPanel();
            }
        });

        JButton btnRemoveStaff = new JButton("Remove Staff");
        btnRemoveStaff.setFont(mainFont);
        btnRemoveStaff.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                removeStaffPanel();
            }
        });

        JButton btnViewStaff=new JButton("View Staff");
        btnViewStaff.setFont(mainFont);
        btnViewStaff.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                viewStaffPanel();
            }
            
        });

        JButton btnUpdateStaff=new JButton("Upate Staff");
        btnUpdateStaff.setFont(mainFont);
        btnUpdateStaff.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                updateStaff();
            }
            
        });

        JButton btnBack=new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
               mainf.startProgram();
            }
            
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1000, 30));
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.add(btnAddStaff);
        buttonPanel.add(btnRemoveStaff);
        buttonPanel.add(btnViewStaff);
        buttonPanel.add(btnUpdateStaff);
        buttonPanel.add(btnBack);

        JPanel staffPanel = new JPanel(new BorderLayout());
       staffPanel.setBackground(Color.YELLOW);
       staffPanel.add(lbWelcome, BorderLayout.NORTH);
       staffPanel.add(buttonPanel, BorderLayout.CENTER);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(staffPanel);
        mainf.revalidate();

        mainf.getContentPane().setLayout(new BorderLayout());
        mainf.getContentPane().add(staffPanel);

        mainf.setTitle("Welcome");
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setSize(400, 500);
        mainf.setResizable(false);
        mainf.setVisible(true);
    }
    //Gets id from admin to update staff
    public void updateStaff() 
    {
        lbWelcome=new JLabel("Update staff");
        lbWelcome.setFont(mainFont);
        JLabel lfid=new JLabel("ID");
        lfid.setFont(mainFont);
        JTextField  ufid=new JTextField(20);
        ufid.setFont(mainFont);
        StaffPanel sp=new StaffPanel(mainf);
        JPanel formPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        formPanel.add(lfid);
        formPanel.add(ufid);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sp.staffPanel();
            }
        });
        JButton btnUpdate=new JButton("Update");
        btnUpdate.setFont(mainFont);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);
                    String dburl = "jdbc:mysql://localhost:3306/java_project";
                    String dbuser = "root";
                    String dbpass = "";
                    Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                    String sql="Select staff_id from staff";
                    PreparedStatement pstr=con.prepareStatement(sql);
                    boolean check=false;
                    ResultSet rst=pstr.executeQuery();
                    int i=0;
                    while(rst.next())
                    {
                        i=rst.getInt("staff_id");
                        int j=Integer.parseInt(ufid.getText());
                        if(i==j)
                        {
                            check=true;
                            break;
                        }
                    }
                    if(check)
                    {
                       update(i);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(mainf,"Staff ID does not exist");
                    }
                } catch (Exception e34) {
                    JOptionPane.showMessageDialog(mainf,"Exception occured");
                    
                }
            }
        });
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnUpdate,BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);
        
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(formPanel, BorderLayout.CENTER);
        viewPanel.add(buttonPanel,BorderLayout.SOUTH);

        mainf.setSize(600, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
    //Allows to update staff
    public static void update(int id) 
    {
        MenuPanel mp=new MenuPanel(mainf);
        JLabel lfname=new JLabel("Name");
        lfname.setFont(mainFont);
        JTextField ufname=new JTextField(20);
        ufname.setFont(mainFont);
        JLabel lfemail=new JLabel("Email");
        lfemail.setFont(mainFont);
        JTextField ufemail=new JTextField(20);
        ufemail.setFont(mainFont);
        JLabel lfsalary=new JLabel("Salary");
        lfsalary.setFont(mainFont);
        JTextField ufsalary=new JTextField(20);
        ufsalary.setFont(mainFont);
        StaffPanel sp=new StaffPanel(mainf);
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String dburl = "jdbc:mysql://localhost:3306/java_project";
            String dbuser = "root";
            String dbpass = "";
            Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
            PreparedStatement pstc=con.prepareStatement("Select staff_name,staff_email,staff_salary from staff where staff_id=?");
            pstc.setInt(1,id);
            ResultSet rt=pstc.executeQuery();
            while(rt.next())
            {
                ufname.setText(rt.getString("staff_name"));
                ufemail.setText(rt.getString("staff_email"));
                String line=Double.toString(rt.getDouble("staff_salary"));
                ufsalary.setText(line);
            }
        } catch (Exception exw) {
            JOptionPane.showMessageDialog(mainf,"Exception occured");
            
        }
        JPanel formPanel=new JPanel(new GridLayout(3, 1, 5, 5));
        formPanel.add(lfname);
        formPanel.add(ufname);
        formPanel.add(lfemail);
        formPanel.add(ufemail);
        formPanel.add(lfsalary);
        formPanel.add(ufsalary);

        JButton btnUpdate=new JButton("Update");
        btnUpdate.setFont(mainFont);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);
                    String dburl = "jdbc:mysql://localhost:3306/java_project";
                    String dbuser = "root";
                    String dbpass = "";
                    Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
                    String sqlww="Update staff set staff_name=?,staff_email=?,staff_salary=? where staff_id=?";
                    PreparedStatement psrt=con.prepareStatement(sqlww);
                    double salary=Double.parseDouble(ufsalary.getText());
                    psrt.setString(1, ufname.getText());
                    psrt.setString(2,ufemail.getText());
                    psrt.setDouble(3,salary);
                    psrt.setInt(4,id);
                    int r=psrt.executeUpdate();
                    if(r>0)
                    {
                        JOptionPane.showMessageDialog(mainf,"Staff changed ");
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(mainf,"No changed happened");
                    }
                } catch (Exception ewd) {
                    JOptionPane.showMessageDialog(mainf,"Exception occured");
                    ewd.printStackTrace();
                    
                }
            }
        });
        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sp.updateStaff();
            }
        });
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnUpdate,BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);

        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(formPanel, BorderLayout.CENTER);
        viewPanel.add(buttonPanel,BorderLayout.SOUTH);

        mainf.setSize(600, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
    //Allows to add Staff
    public void addStaffPanel() 
    {
        lbWelcome = new JLabel("Staff Panel");
        lbWelcome.setFont(mainFont);

        JLabel lblID = new JLabel("Id : ");
        lblID.setFont(mainFont);

        JTextField sfID = new JTextField(20);
        sfID.setFont(mainFont);

        JLabel lblName = new JLabel("Name : ");
        lblName.setFont(mainFont);

        JTextField sfName = new JTextField(20);
        sfName.setFont(mainFont);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(mainFont);

        JTextField sfEmail = new JTextField(20);
        sfEmail.setFont(mainFont);

        JLabel lblSalary = new JLabel("Salary :");
        lblSalary.setFont(mainFont);

        JTextField sfSalary = new JTextField(20);
        sfSalary.setFont(mainFont);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(smallFont);
        btnSubmit.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    if (sfID.getText().isEmpty() || sfName.getText().isEmpty() || sfEmail.getText().isEmpty() || sfSalary.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(mainf, "Fill in all the text Fields");
                    } else {
                        int id = Integer.parseInt(sfID.getText());
                        String name = sfName.getText();
                        String email = sfEmail.getText();
                        double salary = Double.parseDouble(sfSalary.getText());

                        Staff staff = new Staff(id, name, email, salary);
                        String result = staff.addStaff(staff);

                        if (result.equals("1")) {
                            JOptionPane.showMessageDialog(mainf, "Staff information submitted successfully.");
                            Main.sl.addInList(id);
                        } else {
                            JOptionPane.showMessageDialog(mainf, "Staff Info insertion failed, enter info again correctly.");
                        }

                        // Clear fields after successful submission
                        sfID.setText("");
                        sfName.setText("");
                        sfEmail.setText("");
                        sfSalary.setText("");
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(mainf, "Please enter valid numeric values.");
                    sfID.setText("");
                    sfSalary.setText("");
                    sfName.setText("");
                    sfEmail.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainf, "An error occurred while submitting the staff information.");
                    System.out.println(ex.getMessage());
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                staffPanel();
            }
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                sfID.setText("");
                sfName.setText("");
                sfEmail.setText("");
                sfSalary.setText("");
            }
        });

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.add(lblID);
        formPanel.add(sfID);
        formPanel.add(lblName);
        formPanel.add(sfName);
        formPanel.add(lblEmail);
        formPanel.add(sfEmail);
        formPanel.add(lblSalary);
        formPanel.add(sfSalary);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnSubmit, BorderLayout.NORTH);
        buttonPanel.add(btnClear, BorderLayout.CENTER);
        buttonPanel.add(btnBack, BorderLayout.SOUTH);

        JPanel addStaffPanel = new JPanel(new BorderLayout());
        addStaffPanel.setBackground(new Color(128, 128, 255));
        addStaffPanel.add(lbWelcome, BorderLayout.NORTH);
        addStaffPanel.add(formPanel, BorderLayout.CENTER);
        addStaffPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(addStaffPanel);
        mainf.revalidate();
    }
     //Allows to remove Staff
    public void removeStaffPanel()
    {
        lbWelcome.setText("Remove Staff");
        JLabel ulStaffID=new JLabel("Staff ID");
        ulStaffID.setFont(mainFont);

        JTextField ufStaffID=new JTextField(20);
        ufStaffID.setFont(mainFont);
        
        JButton btnRemove=new JButton("Remove");
        btnRemove.setFont(mainFont);
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(ufStaffID.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(mainf,"Enter Staff Id");
                }
                else
                {
                    try {
                        int id=Integer.parseInt(ufStaffID.getText());
                        Staff s=new Staff();
                        int ab=Main.sl.deleteInList(id);
                        if(ab==-1)
                        {
                            JOptionPane.showMessageDialog(mainf,"Id does not exist");
                            ufStaffID.setText("");
                            return;
                        }
                        int r=s.removeStaff(id);
                        ufStaffID.setText("");
                        if(r>0)
                        {
                            JOptionPane.showMessageDialog(mainf,"Staff succesfully removed");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(mainf,"Removal failed , Enter detail properly");
                        }
                    } catch (Exception e1) {
                        
                        JOptionPane.showMessageDialog(mainf,"Removal failed , Enter detail properly");
                        ufStaffID.setText("");
                    }
                }
            }
        });
        JButton btnBack=new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                staffPanel();
            }
            
        });

        JButton btnClear=new JButton("Clear");
        btnClear.setFont(smallFont);
        btnClear.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                
                ufStaffID.setText("");
            }
            
        });

        JPanel formPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        formPanel.add(ulStaffID);
        formPanel.add(ufStaffID);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnRemove, BorderLayout.NORTH);
        buttonPanel.add(btnClear,BorderLayout.CENTER);
        buttonPanel.add(btnBack,BorderLayout.SOUTH);

        JPanel removeUserPanel = new JPanel(new BorderLayout());
        removeUserPanel.setBackground(new Color(128, 128, 255));
        removeUserPanel.add(lbWelcome, BorderLayout.NORTH);
        removeUserPanel.add(formPanel, BorderLayout.CENTER);
        removeUserPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(removeUserPanel);
        mainf.revalidate();
    }
    //Fetches data from staff table
    public Object[][] fetchStaffData() { 
        ArrayList<Object[]> staffData = new ArrayList<>();
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String dburl = "jdbc:mysql://localhost:3306/java_project";
            String dbuser = "root";
            String dbpass = "";
            Main.con = DriverManager.getConnection(dburl, dbuser, dbpass);
            String sql = "SELECT * FROM staff";
            PreparedStatement pst = Main.con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("staff_id");
                String name = rs.getString("staff_name");
                String email = rs.getString("staff_email");
                double salary=rs.getDouble("staff_salary");
                staffData.add(new Object[]{id,name,email,salary});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffData.toArray(new Object[0][]);
    }
    // Method to display the staff data
    public void viewStaffPanel() { 
        String[] columnNames = {"ID","Name","Email","Salary"};
        Object[][] data = fetchStaffData();

        JTable staffTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(staffTable);
        staffTable.getColumnModel().getColumn(2).setPreferredWidth(100);

        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(Color.YELLOW);
        viewPanel.add(lbWelcome, BorderLayout.NORTH);
        viewPanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(smallFont);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                staffPanel();
            }
        });

        JPanel buttonPanel = new JPanel(new  BorderLayout());
        buttonPanel.setBackground(new Color(128, 128, 255));
        buttonPanel.add(btnBack);

        viewPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainf.setSize(700, 500);
        mainf.getContentPane().removeAll();
        mainf.getContentPane().add(viewPanel);
        mainf.revalidate();
    }
}



class Main  //Main class
{
    static Connection con;
    static SinglyLinkedList sl=new SinglyLinkedList();
    //Main Method
    public static void main(String[] args) throws Exception{
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        String dburl = "jdbc:mysql://localhost:3306/java_project";
        String dbuser = "root";
        String dbpass = "";
        Connection con222 = DriverManager.getConnection(dburl, dbuser, dbpass);
        String sql12 = "Select user_tableno from user";
        PreparedStatement pst2=con222.prepareStatement(sql12);
        ResultSet rst12=pst2.executeQuery();
        while(rst12.next())
        {
            RestaurantManager.tbno.add(rst12.getInt("user_tableno"));
        }
        String sql32="Select staff_id from staff";
        PreparedStatement pt3=con222.prepareStatement(sql32);
        ResultSet rt4=pt3.executeQuery();
        while(rt4.next())
        {
            Main.sl.addInList(rt4.getInt("staff_id"));
        }
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
        });
    }
}

class RestaurantManager { //Class to store all the tables
    static ArrayList<Integer> tbno = new ArrayList<>();
}
class User { //Class to store User data
    int tbno;
    String firstName, lastName;
    static int totalTables=50,check;
    User()
    {

    }
    User(int tbno, String firstName, String lastName) {
        this.tbno = tbno;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //Allows to add User
    int addUser(User u) 
    {
        try{
            String driverName="com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String dburl="jdbc:mysql://localhost:3306/java_project";
            String dbuser="root";
            String dbpass="";
            Main.con=DriverManager.getConnection(dburl, dbuser, dbpass);
            PreparedStatement pst = Main.con.prepareStatement("INSERT INTO user VALUES (?, ?, ?)");
            pst.setInt(1, u.tbno);
            pst.setString(2, u.firstName);
            pst.setString(3, u.lastName);
            int r=pst.executeUpdate();
            return r;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return 0;
        }
    }
}
class Staff //Class to store and remove staff data
{
    int id;
    String name,email;
    double salary;
    Staff()
    {

    }
    Staff(int id,String name,String email,double salary)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.salary=salary;
    }
    //Method to add staff
    String addStaff(Staff s) 
    {
        try 
        {
            String driverName="com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String dburl="jdbc:mysql://localhost:3306/java_project";
            String dbuser="root";
            String dbpass="";
            Main.con=DriverManager.getConnection(dburl, dbuser, dbpass);
            PreparedStatement pst = Main.con.prepareStatement("INSERT INTO staff VALUES (?, ?, ?,?)");
            pst.setInt(1, id);
            pst.setString(2,name);
            pst.setString(3, email);
            pst.setDouble(4, salary);
            String r=Integer.toString(pst.executeUpdate());
            return r;
        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            return e.getLocalizedMessage();
        }
    }
    int removeStaff(int id) //Method to remove staff
    {
        try {
            String sql="{Call remove_from_staff(?)}";
             String driverName="com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
             String dburl="jdbc:mysql://localhost:3306/java_project";
            String dbuser="root";
            String dbpass="";
             Main.con=DriverManager.getConnection(dburl, dbuser, dbpass);
             CallableStatement cst=Main.con.prepareCall(sql);
             cst.setInt(1,id);
            int r=cst.executeUpdate();
            if(r>0)
            {
                Main.sl.deleteInList(id);
            }
              return r;
        } catch (Exception e) {
            
            return 0;
        }
    }
}
class SinglyLinkedList //DS for Linked List
{
    class Node //class To store Data
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            next=null;
        }
    }
    Node first=null;
    //Adds data in List
    void addInList(int data) 
    {
        Node n=new Node(data);
        if(first==null)
        {
            first=n;
        }
        else
        {
            Node temp=first;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=n;
        }
    }
     //Delete data in list
    int deleteInList(int value)
    {
        int flag=0;
        if(first==null)
        {
            return -1;
        }
        else 
        {
            Node dummy=first;
            while(dummy!=null)
            {
                if(dummy.data==value)
                {
                    flag=1;break;
                }
                dummy=dummy.next;
            }
            if(flag==0)
            {
                return -1;
            }
            else 
            {
                if(first.data==value)
                {
                    Node q=first;
                    int i=q.data;
                    first=null;
                    q=null;
                    return i;
                }
                Node temp=first;
                while(temp.next.data!=value&&temp.next!=null)
                {
                    temp=temp.next;
                }
                Node q=temp.next;
                int i=q.data;
                temp.next=q.next;
                q=null;
                return i;
            }
        }
    }
}