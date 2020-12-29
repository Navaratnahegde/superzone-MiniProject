package Superzone2;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField debitf;
	private JTextField upif;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String user,pass,add;
	int confirm=0;
	int confirm2=0;
	/**
	 * Launch the application.
	 */
	static Payment frame;
	public static void main(String add,int amount,String user,String pass) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame= new Payment(add,amount,user,pass);
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
	public Payment(String add,int amount,String user,String pass) {
		
		this.add=add;
		this.user=user;
		this.pass=pass;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 660);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setBounds(569, 11, 213, 38);
		lblPayment.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblPayment);
		
		JLabel lblSelectYourPayment = new JLabel("Select your payment method");
		lblSelectYourPayment.setBounds(455, 198, 327, 38);
		lblSelectYourPayment.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblSelectYourPayment);
		
		JLabel lblDeliverTo = new JLabel("Deliver to");
		lblDeliverTo.setBounds(139, 101, 116, 26);
		lblDeliverTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblDeliverTo);
		
		JTextArea textArea = new JTextArea(add);
		textArea.setBounds(265, 98, 480, 73);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBackground(Color.WHITE);
		contentPane.add(textArea);
		
		JButton btnUpdateAddress = new JButton("Update address");
		btnUpdateAddress.setBounds(815, 106, 145, 23);
		btnUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded successfully");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superzone","root","");
					Statement stmt=con.createStatement();
					String sql=("update signupvalues set Address='"+textArea.getText()+"'where Username='"+user+"' and (Password='"+pass+"')");
					stmt.executeUpdate(sql);		
				
					// PreparedStatement ps = con.prepareStatement(query);
					// ps.setString(6,textArea.getText());
					
					JOptionPane.showMessageDialog(null,"UPdated address successfull");
			}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		});
		contentPane.add(btnUpdateAddress);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(126, 60, 1030, 17);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(126, 442, -26, -354);
		separator_1.setBackground(new Color(153, 0, 0));
		separator_1.setForeground(new Color(0, 204, 153));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_1);
		
		JRadioButton rdbtnUpi = new JRadioButton("UPI");
		rdbtnUpi.setBounds(487, 286, 109, 23);
		buttonGroup.add(rdbtnUpi);
		rdbtnUpi.setBackground(Color.WHITE);
		contentPane.add(rdbtnUpi);
		
		JRadioButton rdbtnPhonepay = new JRadioButton("PhonePay");
		rdbtnPhonepay.setBounds(487, 375, 109, 23);
		buttonGroup.add(rdbtnPhonepay);
		rdbtnPhonepay.setBackground(Color.WHITE);
		contentPane.add(rdbtnPhonepay);
		
		JRadioButton rdbtnGooglepay = new JRadioButton("GooglePay");
		rdbtnGooglepay.setBounds(487, 443, 109, 23);
		buttonGroup.add(rdbtnGooglepay);
		rdbtnGooglepay.setBackground(Color.WHITE);
		contentPane.add(rdbtnGooglepay);
		
		JRadioButton rdbtnDebitcreditCard = new JRadioButton("Debit/Credit Card");
		rdbtnDebitcreditCard.setBounds(487, 512, 109, 23);
		buttonGroup.add(rdbtnDebitcreditCard);
		rdbtnDebitcreditCard.setBackground(Color.WHITE);
		contentPane.add(rdbtnDebitcreditCard);
		
		debitf = new JTextField();
		debitf.setBounds(610, 539, 145, 20);
		contentPane.add(debitf);
		debitf.setColumns(10);
		
		JRadioButton rdbtnCashOnDelivary = new JRadioButton("cash on delivery");
		rdbtnCashOnDelivary.setBounds(487, 591, 122, 23);
		rdbtnCashOnDelivary.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnCashOnDelivary);
		contentPane.add(rdbtnCashOnDelivary);
		
		
		
		JLabel lblCardnumber = new JLabel("CardNumber");
		lblCardnumber.setBounds(524, 542, 72, 14);
		contentPane.add(lblCardnumber);
		
		JLabel lblUpiId = new JLabel("UPI ID");
		lblUpiId.setBounds(550, 330, 46, 17);
		contentPane.add(lblUpiId);
		
		upif = new JTextField();
		upif.setBounds(610, 328, 145, 20);
		contentPane.add(upif);
		upif.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount to be paid:");
		lblAmount.setBounds(924, 509, 183, 23);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblAmount);
		
		JLabel lblNewLabel = new JLabel(amount+" INR");
		lblNewLabel.setBounds(1096, 512, 76, 18);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(387, 354, 63, 58);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\download.png"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(387, 435, 57, 38);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\googlepay.png"));
		contentPane.add(lblNewLabel_4);
		
		JButton btnPayNow = new JButton("Pay now");
		btnPayNow.setBounds(1056, 550, 116, 46);
		btnPayNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(rdbtnGooglepay.isSelected()==true||rdbtnPhonepay.isSelected()==true||rdbtnCashOnDelivary.isSelected())
				{
				 confirm++;
				}
				else if((rdbtnUpi.isSelected()==true&&upif.getText().equals(""))||(rdbtnDebitcreditCard.isSelected()==true&&debitf.getText().equals("")))
				{
					
							JOptionPane.showMessageDialog(null,"Please enter Your ID/CardNumber");
				}
				else if((rdbtnUpi.isSelected()==true&&upif.getText().equals("")==false)||(rdbtnDebitcreditCard.isSelected()==true&&debitf.getText().equals("")==false))
				{
					
					confirm2++;
				}
				else
					JOptionPane.showMessageDialog(null,"please select any one payment method");
				if(confirm>0||confirm2>0)
				{
					JOptionPane.showMessageDialog(null,"order placed and will be  delivered to the address "+textArea.getText());
					
				}
				
					
				
			}
		});
		btnPayNow.setBackground(new Color(0, 204, 0));
		contentPane.add(btnPayNow);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(387, 278, 72, 38);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\upi.jpg"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(387, 510, 72, 26);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\debit.png"));
		contentPane.add(lblNewLabel_3);
		
		JButton btnBackToCart = new JButton("Back to Cart ");
		btnBackToCart.setBounds(1066, 98, 131, 38);
		btnBackToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				product1 obj=new product1(user,add,user,pass);
				obj.main(user,add,user,pass);
				frame.setVisible(false);
			}
		});
		contentPane.add(btnBackToCart);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\tenorpayment.gif"));
		lblNewLabel_5.setBounds(811, 161, 424, 337);
		contentPane.add(lblNewLabel_5);

	}
}
