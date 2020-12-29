package Superzone2;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class Disp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	 int d=0,e=0,q=0,update=0;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	String a="";
	static String gotuser,gotpass;
	private JPasswordField passwordField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disp frame = new Disp();
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
	public Disp() {
		
		
		System.out.println("this is"+gotuser);
		setBounds(100, 100, 879, 490);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisplayUpdate = new JLabel("Update");
		lblDisplayUpdate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDisplayUpdate.setBounds(10, 11, 261, 47);
		contentPane.add(lblDisplayUpdate);
		
		textField = new JTextField();
		textField.setBounds(127, 107, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblUsername.setBounds(42, 110, 75, 14);
		contentPane.add(lblUsername);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 152, 799, 9);
		contentPane.add(separator);
		
		JLabel lblName = new JLabel("Username");
		lblName.setBounds(270, 175, 75, 14);
		contentPane.add(lblName);
		
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(638, 269, 113, 20);
		contentPane.add(passwordField_2);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(355, 172, 139, 20);
		contentPane.add(textField_1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(270, 226, 46, 14);
		contentPane.add(lblPhone);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(355, 226, 139, 20);
		contentPane.add(textField_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(270, 318, 46, 14);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(355, 312, 164, 20);
		contentPane.add(textField_3);
		System.out.println("Data Display Feild for "+gotuser);
		JLabel lblD = new JLabel("Data Display Feild");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblD.setBounds(20, 173, 164, 14);
		contentPane.add(lblD);
//		
//		JButton btnNewButton_1 = new JButton("Edit");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(d==0)
//					JOptionPane.showMessageDialog(null,"Please enter username to update");
//				else
//				{
//					q++;
//					JOptionPane.showMessageDialog(null,"Edit the data by changing data in the feilds and click update");
//					
//					textField_1.setText("");
//					textField_2.setText("");
//					textField_3.setText("");
//					
//					
//				}
//				
//			}
//		});
//		btnNewButton_1.setBounds(378, 381, 100, 23);
//		contentPane.add(btnNewButton_1);
//		
		
		
	
		JTextArea textArea = new JTextArea();
		textArea.setBounds(355, 360, 164, 28);
		contentPane.add(textArea);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(814, 360, -793, -9);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(54, 399, 799, 9);
		contentPane.add(separator_2);
		
		JLabel label = new JLabel("");
		label.setBounds(399, 184, 46, 14);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(388, 107, 120, 20);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(289, 110, 75, 14);
		contentPane.add(lblPassword);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\Reetik\\Downloads\\button_update.png"));
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				if(q==0)
//				{
//					JOptionPane.showMessageDialog(null,"Please edit first to update");
//				}
				if(d==0)
					btnUpdate.setEnabled(false);
//					JOptionPane.showMessageDialog(null,"Please enter username to update");
					try {
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loaded successfully");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery("select * from signupvalues");
						String pshow=passwordField.getText();
						String pshow2=passwordField_1.getText();
						String pshow3=passwordField_2.getText();
						a=textField.getText();
						btnUpdate.setEnabled(true);
													
						 String query = "update signupvalues set Username=?,Password=?,Email=?,Phoneno=?,Address=? where Username='"+a+"' and (Password='"+pshow+"')";
						 PreparedStatement ps = con.prepareStatement(query);
						 ps.setString(1,textField_1.getText());
						 ps.setString(5,textArea.getText());
						 ps.setString(4,textField_2.getText());
						 ps.setString(3,textField_3.getText());
						 ps.setString(2,passwordField_1.getText());
						 if(passwordField_1.getText().equals(""))
							{
							 if(d>0) {
								int inputt = JOptionPane.showConfirmDialog(null,"Do you want to change password?");
								if(inputt==0)
								{
									if(pshow2.equals(""))
									{
										
									}
									else
									{
										if(pshow2.equals(pshow3))
										{
										
									
											ps.execute();
											update++;
											
											JOptionPane.showMessageDialog(null,"Data updated successfully");
										}
								
										else
										{
											JOptionPane.showMessageDialog(null,"Password Mismatch");
										}
									}
								}
								if(inputt==1)
								{
									ps.setString(3,passwordField.getText());
									ps.execute();
									update++;
				 
									JOptionPane.showMessageDialog(null,"Data updated successfully");
								}
						}
			}
						
						else
						{
							btnUpdate.setEnabled(true);
							if(pshow2.equals(pshow3))
							{
							if(d>0) {	
							int inputtt=JOptionPane.showConfirmDialog(null,"Confirm Update ?");
								if(inputtt==0)
								{
									 query = "update signupvalues set Username=?,Password=?,Email=?,Phoneno=?,Address=? where Username='"+a+"' and (Password='"+pshow+"')";
									 PreparedStatement ps2 = con.prepareStatement(query);
									 ps2.setString(1,textField_1.getText());
									 ps2.setString(5,textArea.getText());
									 ps2.setString(4,textField_2.getText());
									 ps2.setString(3,textField_3.getText());
									 ps2.setString(2,passwordField_1.getText());
			
							 ps2.execute();
							 update++;
							 JOptionPane.showMessageDialog(null,"Data updated successfully");
								}
							}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Password Mismatch");
							}
						}
						 
					}
					
//						  textField_2.setText("");
//						  textField.setText("");
//						  textField_1.setText("");
//						  textField_3.setText("");
//						  passwordField_1.setText("");
						    
						    
					
					catch(Exception ee)
					{
						System.out.println(" "+ee.getMessage());
					}
					
				}
			
		});
		btnUpdate.setBounds(365, 406, 100, 34);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(270, 272, 65, 14);
		contentPane.add(lblNewLabel);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(355, 272, 139, 20);
		contentPane.add(passwordField_1);
		
	
		
		
		
//		lblNewLabel.setVisible(false);
//		lblName.setVisible(false);
//		lblPhone.setVisible(false);
//		lblEmail.setVisible(false);
		
//		passwordField_1.setVisible(false);
//		textField_1.setVisible(false);
//		textField_2.setVisible(false);
//		textField_3.setVisible(false);
		
		
	
		JButton btnShow = new JButton("Show");
		btnShow.setIcon(new ImageIcon("C:\\Users\\Reetik\\Downloads\\button_show.png"));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				lblNewLabel.setVisible(true);
//				lblName.setVisible(true);
//				lblPhone.setVisible(true);
//				lblEmail.setVisible(true);
				String b=" ";
				if(textField.getText().equals(""))
				{
					btnUpdate.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Please enter username");
				}
				else
					
				{
					btnUpdate.setEnabled(true);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=con.createStatement();
					 String show=textField.getText();
					 String pass=passwordField.getText();
					ResultSet rs=stmt.executeQuery("select * from signupvalues where Username='"+show+"'and Password='"+pass+"'");
				
					int c=0;
					while(rs.next())
					{
//						lblNewLabel.setVisible(true);
//						lblName.setVisible(true);
//						lblPhone.setVisible(true);
//						lblEmail.setVisible(true);
						
						System.out.println("here");
						  c++;
						  d++;
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
//						textArea.setText("\n"+"\t"+"\t"+rs.getString(1)+"\n"+"\n"+"\n"+"\t"+"\t"+rs.getString(2)+"\n"+"\n"+"\n"+"\t"+"\t"+"********"+"\n"+"\n"+"\n"+"\t"+"\t"+rs.getString(4));
						
//						textArea.setText(rs.getString(2));
						textField_1.setText(rs.getString(1));
						textField_2.setText(rs.getString(5));
						textField_3.setText(rs.getString(4));
						textArea.setText(rs.getString(6));
//					
					}
					
					if(c==0)
					{
						btnUpdate.setEnabled(false);
						JOptionPane.showMessageDialog(null,"Username or password incoreect");
					}
			}
				catch(Exception ee)
				{
					System.out.println("Error");
				}
			}
			}
		});
		btnShow.setBounds(541, 100, 100, 34);
		contentPane.add(btnShow);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your username and password to update your profile");
		lblPleaseEnterYour.setBounds(20, 69, 414, 14);
		contentPane.add(lblPleaseEnterYour);
		
		
		
		JLabel lblConfirmPassowrd = new JLabel("Confirm Passowrd");
		lblConfirmPassowrd.setBounds(514, 272, 107, 14);
		contentPane.add(lblConfirmPassowrd);
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Reetik\\Downloads\\button_reset.png"));
		btnReset.setBounds(651, 100, 100, 34);
		contentPane.add(btnReset);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(270, 361, 46, 14);
		contentPane.add(lblAddress);
		
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d=0;
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			passwordField_1.setText("");
			passwordField.setText("");
			passwordField_2.setText("");
			btnUpdate.setEnabled(false);
			}
		});

		
	}
}