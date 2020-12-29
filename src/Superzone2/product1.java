package Superzone2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class product1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField totalfield;
	private JTextField price1;
	private JTextField price2;
	private JTextField price4;
	private JTextField price3;
	public int  totalcost=0;
	public String amount1;
	String address;
	String user,pass;
	int oldsum=0;
	static product1 frame;
	/**
	 * Launch the application.
	 */
	public static void main(String username,String add,String user,String pass) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new product1(username,add,user,pass);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public product1(String username,String add,String user,String pass) 
	{
		address=add;
		this.user=user;
		this.pass=pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		totalfield = new JTextField();
		totalfield.setEditable(false);
		totalfield.setBounds(1187, 542, 101, 23);
		contentPane.add(totalfield);
		totalfield.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1009, 11, 9, 685);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(494, 0, 15, 696);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_1);
		
		JLabel lblFashion = new JLabel("Fashion");
		lblFashion.setBounds(167, 68, 147, 34);
		lblFashion.setFont(new Font("Cambria Math", Font.BOLD, 30));
		contentPane.add(lblFashion);
		DefaultTableModel model2=new DefaultTableModel();
		table = new JTable(model2);
		table.setBounds(1009, 188, 351, 326);
		model2.addColumn("Item name");
		model2.addColumn("price");

		table.setBorder((Border) new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		contentPane.add(table);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(207, 151, 137, 33);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Himalaya FaceWash", "Nevia BodyLotion", "Fogg Perfume", "Lux soap", "Face Cream"}));
		contentPane.add(comboBox);
		price1 = new JTextField();
		price1.setBounds(354, 157, 67, 20);
		contentPane.add(price1);
		price1.setColumns(10);
		  JScrollPane scroll=new JScrollPane();
		   scroll.setBounds(1010,200,345,280);
		   contentPane.add(scroll);
		    
		    //THE TABLE
		 
		    scroll.setViewportView(table);
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
			Statement stmt=(Statement) con.createStatement();
			Object obj=comboBox.getSelectedItem();
			String selected=(String) comboBox.getSelectedItem();
	
				System.out.println("Driver loaded successfully");
			
				//ResultSet rs=stmt.executeQuery("select * from Signupvalues");
				//while(rs.next())
				//{
				//System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				//}
				
			
				

				
				

			ResultSet rs=stmt.executeQuery("select * from cart where user='"+user+"' and pass='"+pass+"'");
			
			while(rs.next())
			{
			
			model2.addRow(new Object[] {rs.getString(1),rs.getString(2)});
			oldsum=oldsum+rs.getInt(2); 
		   
			
			}
			 totalfield.setText(Integer.toString(oldsum));
			System.out.println(oldsum);
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());
			}
		
		JButton btnAcceptpay = new JButton("Accept&Pay");

		JButton btnAddToCart = new JButton("Add to cart");
		if(!(totalfield.getText().equals(Integer.parseInt("0"))))
		{
			btnAcceptpay.setEnabled(true);
		}
		else
		{
			btnAcceptpay.setEnabled(false);	
		}
		
		btnAddToCart.setBounds(152, 223, 161, 33);
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=(Statement) con.createStatement();
					Object obj=comboBox.getSelectedItem();
					String selected=(String) comboBox.getSelectedItem();
			
						System.out.println("Driver loaded successfully");
					
						//ResultSet rs=stmt.executeQuery("select * from Signupvalues");
						//while(rs.next())
						//{
						//System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
						//}
						
					
						

						
						

					ResultSet rs=stmt.executeQuery("select * from Fashion where Productname='"+selected+"' ");
					
					while(rs.next())
					{
					
					int price=Integer.parseInt(rs.getString(2));
					model2.addRow(new Object[] {selected,rs.getString(2)});
					String query = "Insert into cart (items,price,user,pass)"+"values(?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,selected);
					ps.setString(2,rs.getString(2));
					ps.setString(3,user);
					ps.setString(4,pass);
					ps.execute();
				
					   
					price1.setText(rs.getString(2)+ " Rs");
					totalcost=totalcost+price+oldsum;
					oldsum=0;;
					String prices=Integer.toString(totalcost);
					totalfield.setText(prices);
					
					}
					}
					catch(Exception e)
					{
					System.out.println(e.getMessage());
					}
				if(!(totalfield.getText().equals(Integer.parseInt("0"))))
				{
					btnAcceptpay.setEnabled(true);
				}
				else
				{
					btnAcceptpay.setEnabled(false);	
				}
				


			}
		});
		
				
		btnAddToCart.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnAddToCart);
		
		JLabel lblFooddrink = new JLabel("Food/Drink");
		lblFooddrink.setBounds(673, 55, 190, 33);
		lblFooddrink.setFont(new Font("Cambria Math", Font.BOLD, 30));
		contentPane.add(lblFooddrink);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(733, 141, 161, 34);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Lays", "Biscuit", "cocacola", "pepsi", "namkeen", ""}));
		contentPane.add(comboBox_1);
		
		JButton btnAddToCart_1 = new JButton("Add to cart");
		btnAddToCart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=(Statement) con.createStatement();
					Object obj=comboBox_1.getSelectedItem();
					String selected=(String) comboBox_1.getSelectedItem();
					ResultSet rs=stmt.executeQuery("select * from FoodDrink where Productname='"+selected+"' ");
					
					while(rs.next())
					{
					
					
					model2.addRow(new Object[] {selected,rs.getString(2)});
					price2.setText(rs.getString(2)+ " Rs");

			
					String query = "Insert into cart (items,price,user,pass)"+"values(?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,selected);
					ps.setString(2,rs.getString(2));
					ps.setString(3,user);
					ps.setString(4,pass);

					ps.execute();
					int price=Integer.parseInt(rs.getString(2));
					totalcost=totalcost+price+oldsum;
					oldsum=0;;
					String prices=Integer.toString(totalcost);
					totalfield.setText(prices);

					}
					}
					catch(Exception e)
					{
					System.out.println(e.getMessage());
					}

			}
		});
		btnAddToCart_1.setBounds(673, 223, 169, 33);
		btnAddToCart_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnAddToCart_1);
		
		JLabel lblVegetable = new JLabel("Vegetable");
		lblVegetable.setBounds(185, 378, 161, 37);
		lblVegetable.setFont(new Font("Cambria Math", Font.BOLD, 30));
		contentPane.add(lblVegetable);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(231, 480, 82, 34);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Patato", "Brinjol", "Tomato", "Bitroot", "cucumber"}));
		contentPane.add(comboBox_2);
		
		JButton btnAddToCart_2 = new JButton("Add to cart");
		btnAddToCart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=(Statement) con.createStatement();
					Object obj=comboBox_2.getSelectedItem();
					String selected=(String) comboBox_2.getSelectedItem();
					ResultSet rs=stmt.executeQuery("select * from Vegetable where Productname='"+selected+"' ");
					
					while(rs.next())
					{
					
					
					model2.addRow(new Object[] {selected,rs.getString(2)});
					price3.setText(rs.getString(2)+ " Rs");
					String query = "Insert into cart (items,price,user,pass)"+"values(?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,selected);
					ps.setString(2,rs.getString(2));
					ps.setString(3,user);
					ps.setString(4,pass);

					ps.execute();
					int price=Integer.parseInt(rs.getString(2));
					totalcost=totalcost+price+oldsum;
					oldsum=0;
					String prices=Integer.toString(totalcost);
					totalfield.setText(prices);


					}
					}
					catch(Exception ee)
					{
					System.out.println(ee.getMessage());
					}

			}
		});
		btnAddToCart_2.setBounds(167, 581, 161, 33);
		btnAddToCart_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnAddToCart_2);
		
		JLabel lblGrocery = new JLabel("Grocery");
		lblGrocery.setForeground(new Color(0, 0, 0));
		lblGrocery.setBounds(696, 378, 126, 37);
		lblGrocery.setFont(new Font("Cambria Math", Font.BOLD, 30));
		contentPane.add(lblGrocery);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(807, 499, 92, 34);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Wheatflour", "Sugar", "Basamatirice", "Turmeric powder", "Dal"}));
		contentPane.add(comboBox_3);
		
		JButton btnAddToCart_3 = new JButton("Add to cart");
		btnAddToCart_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=(Statement) con.createStatement();
					Object obj=comboBox_3.getSelectedItem();
					String selected=(String) comboBox_3.getSelectedItem();
					ResultSet rs=stmt.executeQuery("select * from Grocery where Productname='"+selected+"' ");
					
					while(rs.next())
					{
					
					
					model2.addRow(new Object[] {selected,rs.getString(2)});
					price4.setText(rs.getString(2)+ " Rs");
					String query = "Insert into cart (items,price,user,pass)"+"values(?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,selected);
					ps.setString(2,rs.getString(2));
					ps.setString(3,user);
					ps.setString(4,pass);
					ps.execute();
					int price=Integer.parseInt(rs.getString(2));
					totalcost=totalcost+price+oldsum;
					oldsum=0;;
					
					String prices=Integer.toString(totalcost);
					totalfield.setText(prices);

					

					}
					}
					catch(Exception eee)
					{
					System.out.println(eee.getMessage());
					}

			}
		});
		btnAddToCart_3.setBounds(653, 579, 169, 35);
		btnAddToCart_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(btnAddToCart_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(7, 336, 1011, 12);
		contentPane.add(separator_2);
		
		JLabel lblCar = new JLabel("Cart");
		lblCar.setFont(new Font("Serif", Font.BOLD, 35));
		lblCar.setBounds(1228, 135, 92, 46);
		contentPane.add(lblCar);
		
		JLabel lblSelect = new JLabel("Select");
		lblSelect.setForeground(new Color(0, 0, 0));
		lblSelect.setFont(new Font("Gadugi", Font.BOLD, 22));
		lblSelect.setBounds(106, 150, 81, 25);
		contentPane.add(lblSelect);
		
		JLabel label = new JLabel("Select");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Gadugi", Font.BOLD, 22));
		label.setBounds(614, 150, 81, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Select");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Gadugi", Font.BOLD, 22));
		label_1.setBounds(118, 480, 81, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Select");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Gadugi", Font.BOLD, 22));
		label_2.setBounds(696, 506, 81, 25);
		contentPane.add(label_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int column =1;
				oldsum=0;
				int column2=0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				String value2 = table.getModel().getValueAt(row, column2).toString();
				((DefaultTableModel)table.getModel()).removeRow(row); //to delete a item 
				int prices=Integer.parseInt(value);
				totalcost=Integer.parseInt(totalfield.getText())-prices;
				
				String uprices=Integer.toString(totalcost);
				totalfield.setText(uprices);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=con.createStatement();
					
					String query="delete from cart where items='"+value2+"'and price='"+value+"'";
					 PreparedStatement ps = con.prepareStatement(query);
					 ps.execute();
						
						
						}
					 
			
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
			}
			
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(1011, 646, 109, 28);
		contentPane.add(btnDelete);
		
		
		btnAcceptpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if((totalfield.getText().equals("0")))
				{
					JOptionPane.showMessageDialog(null,"plese add item into the cart");
				}
				else
				{
					
				
				
				Payment obj=new Payment(address,totalcost+oldsum,user,pass);
				obj.main(address,totalcost+oldsum,user,pass);
			}
			}
		});
		btnAcceptpay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAcceptpay.setBounds(1213, 646, 147, 28);
		contentPane.add(btnAcceptpay);
		
		JLabel lblTotalCost = new JLabel("Total cost");
		lblTotalCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalCost.setBounds(1028, 542, 92, 20);
		contentPane.add(lblTotalCost);
		

		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 497, 335);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\faishon.jpg"));
		contentPane.add(lblNewLabel);
		
		price2 = new JTextField();
		price2.setBounds(902, 148, 73, 20);
		contentPane.add(price2);
		price2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\foodanddrink.jpg"));
		lblNewLabel_1.setBounds(494, 0, 517, 339);
		contentPane.add(lblNewLabel_1);
		
		price4 = new JTextField();
		price4.setColumns(10);
		price4.setBounds(909, 506, 73, 20);
		contentPane.add(price4);
		
		price3 = new JTextField();
		price3.setColumns(10);
		price3.setBounds(336, 487, 73, 20);
		contentPane.add(price3);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\grocery.jpg"));
		lblNewLabel_2.setBounds(-14, 336, 509, 360);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\grocery1.jpg"));
		lblNewLabel_3.setBounds(494, 336, 512, 351);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(username);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_5.setBounds(1028, 136, 190, 46);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(1017, 90, 343, 12);
		contentPane.add(separator_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{
				Disp ob=new Disp();
				ob.main(null);
				
			}
		});
		btnNewButton.setBounds(1038, 55, 89, 23);
		contentPane.add(btnNewButton);
	
		JButton btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int inputt = JOptionPane.showConfirmDialog(null,"Confirm logout of "+user+"?");
				if(inputt==0)
				{
				frame.setVisible(false);
				dblogin1 obj=new dblogin1();
				obj.main(null);
				}
				else
				{
					
				}
				
			}
		});
		btnLogout.setBounds(1247, 55, 89, 23);
		contentPane.add(btnLogout);
	}
}

