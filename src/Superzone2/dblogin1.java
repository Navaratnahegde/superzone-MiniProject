package Superzone2;


import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class dblogin1 extends JFrame {
	public JTextField ut;
	public JPasswordField pt;
	public JTextField et;
	public JTextField lut;
	public JPasswordField passwordField_1;
	public JPasswordField lpt;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JTextField ppt;
	public String user;
	String add;
	int count=0;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dblogin1 frame = new dblogin1();
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
	public dblogin1() {
		getContentPane().setForeground(new Color(0, 153, 153));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 9));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1359, 720);
		getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(752, 11, 14, 659);
		separator.setFont(new Font("Dialog", Font.PLAIN, 13));
		separator.setOrientation(SwingConstants.VERTICAL);
		getContentPane().add(separator);
		
		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setForeground(Color.WHITE);
		lblNewUser.setBounds(261, 22, 201, 33);
		lblNewUser.setFont(new Font("Tahoma", Font.BOLD, 32));
		getContentPane().add(lblNewUser);
		
		JLabel ul = new JLabel("Username");
		ul.setBounds(102, 123, 120, 33);
		ul.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(ul);
		
		ut = new JTextField();
		ut.setBounds(301, 133, 184, 20);
		getContentPane().add(ut);
		ut.setColumns(10);
		
		JLabel pl = new JLabel("Password");
		pl.setBounds(102, 196, 123, 22);
		pl.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(pl);
		
		pt = new JPasswordField();
		pt.setBounds(306, 200, 184, 22);
		getContentPane().add(pt);
		
		JLabel gl = new JLabel("Gender");
		gl.setBounds(102, 262, 103, 25);
		gl.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(gl);
		
		JRadioButton gtm = new JRadioButton("male");
		buttonGroup.add(gtm);
		gtm.setBounds(307, 266, 80, 23);
		gtm.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(gtm);
		
		JRadioButton ft = new JRadioButton("female");
		buttonGroup.add(ft);
		ft.setBounds(411, 266, 80, 23);
		ft.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(ft);
		
		JLabel el = new JLabel("Email");
		el.setBounds(102, 342, 103, 19);
		el.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(el);
		
		et = new JTextField();
		et.setBounds(301, 345, 184, 20);
		getContentPane().add(et);
		et.setColumns(10);
		
		JLabel al = new JLabel("Address");
		al.setBounds(102, 471, 87, 20);
		al.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(al);
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
			Statement stmt=con.createStatement();
			//ResultSet rs=stmt.executeQuery("select * from Signupvalues");
			//while(rs.next())
			//{
			//System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			//}
		
			ResultSet rs=stmt.executeQuery("call Proc1()");
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			System.out.println(count);
	
			   
			}
			catch(Exception ee)
			{
			System.out.println(" "+ee.getMessage());
			}


	
		
		JTextArea at = new JTextArea();
		at.setBounds(299, 473, 232, 81);
		getContentPane().add(at);
		
		JButton sb = new JButton("Signup");
		sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(ut.getText().equals("")||pt.getText().equals("")||et.getText().equals("")||ppt.getText().equals("")||at.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter details in all the fields");
				}
				else if((ppt.getText().length())<10||(ppt.getText().length())>10)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid phone Number");
				}
				
				else if(!(et.getText().contains("@gmail.com"))||(et.getText().contains("@GMAIL.COM")))
				{
				JOptionPane.showMessageDialog(null,"Please enter a valid Emalil Id");
				}
				else
				{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=con.createStatement();
					//ResultSet rs=stmt.executeQuery("select * from Signupvalues");
					//while(rs.next())
					//{
					//System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
					//}
				
					
					System.out.println(count);
					System.out.println("I came here");
					String query = "Insert into signupvalues (Username,Password,gender,Email,phoneno,address)"+"values(?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,ut.getText());
					ps.setString(2,pt.getText());
					ps.setString(3,"female");
					ps.setString(4,et.getText());
					
					ps.setString(5,ppt.getText());
					ps.setString(6,at.getText());
					

					ps.execute();
					
					 System.out.println("data inserted successfully");
					ResultSet rs=stmt.executeQuery("call Proc1()");
					int count2=0;
					while(rs.next())
					{
						count2=rs.getInt(1);
					}
					System.out.println(count2);
					if(count2>count)
					{
					 JOptionPane.showMessageDialog(null,"Thankyou for SigningUp");
					}
					 ut.setText("");
					 pt.setText("");
					 et.setText("");
					 ppt.setText("");
					 at.setText("");
					   
					   
					}
					catch(Exception ee)
					{
					System.out.println(" "+ee.getMessage());
					}
				}


			}
		});
		sb.setBounds(279, 630, 121, 33);
		sb.setFont(new Font("Tahoma", Font.BOLD, 22));
		getContentPane().add(sb);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(1008, 12, 178, 55);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 32));
		getContentPane().add(lblLogin);
		
		JLabel lul = new JLabel("Username");
		lul.setBounds(867, 123, 130, 49);
		lul.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lul);
		
		lut = new JTextField();
		lut.setBounds(1043, 133, 161, 33);
		getContentPane().add(lut);
		lut.setColumns(10);
		
		JLabel pll = new JLabel("Password");
		pll.setBounds(867, 236, 114, 33);
		pll.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(pll);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(1072, 236, -17, 20);
		getContentPane().add(passwordField_1);
		
		lpt = new JPasswordField();
		lpt.setBounds(1043, 245, 161, 33);
		getContentPane().add(lpt);
		
		JButton ll = new JButton("Login");
		ll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=con.createStatement();

					ResultSet rs=stmt.executeQuery("select * from signupvalues where Username='"+lut.getText()+"'and (Password='"+lpt.getText()+"')");

					int cc=0;

					while(rs.next())
					{
					 cc++;
					 add=(rs.getString(6));
					 Payment ob=new Payment(add,0,lut.getText(),lpt.getText());
					
					}

					if(cc==0)

					JOptionPane.showMessageDialog(null," Username or Password Incorrect");

					else
					{
						 user =lut.getText();
						
						JOptionPane.showMessageDialog(null,"Login succsessfull");  
						product1 pobj=new product1(user,add,user,lpt.getText());
						pobj.main(user,add,user,lpt.getText());
						System.out.println(user);
										 System.out.println(user);
					  
					}


					}
					catch(Exception ee)
					{
					System.out.println(" "+ee.getMessage());
					}

			}
		});
		ll.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ll.setBounds(1008, 386, 89, 33);
		getContentPane().add(ll);
		
		JLabel lblSuperzone_1 = new JLabel("Superzone");
		lblSuperzone_1.setFont(new Font("Tahoma", Font.ITALIC, 36));
		lblSuperzone_1.setBounds(1135, 612, 178, 58);
		getContentPane().add(lblSuperzone_1);
		
		JLabel ltu = new JLabel("");
		ltu.setIcon(null);
		ltu.setBackground(new Color(0, 204, 204));
		ltu.setOpaque(true);
		ltu.setBounds(752, 0, 591, 681);
		getContentPane().add(ltu);
		
		JLabel ppl = new JLabel("Phoneno");
		ppl.setFont(new Font("Tahoma", Font.BOLD, 20));
		ppl.setBounds(99, 410, 90, 25);
		getContentPane().add(ppl);
		
		ppt = new JTextField();
		ppt.setBounds(301, 415, 184, 20);
		getContentPane().add(ppt);
		ppt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 153, 153));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 0, 752, 681);
		getContentPane().add(lblNewLabel);
	}
}
