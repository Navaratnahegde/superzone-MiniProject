package Superzone2;



import java.awt.EventQueue;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;


public class startlogo1 {

private JFrame frame;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run()
{
try
{
startlogo1 window = new startlogo1();
window.frame.setVisible(true);
}
catch (Exception e)
{
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public startlogo1() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize()
{
Timer time = new Timer();
time.schedule(new TimerTask()
{
@Override
public void run()
{
frame.dispose();
dblogin1 lobj = new dblogin1();
lobj.main(null);
}
}, 3200);

frame = new JFrame();
frame.setBounds(100, 100, 800, 532);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
JLabel lblSuperzone = new JLabel("Superzone");
lblSuperzone.setFont(new Font("Tahoma", Font.BOLD, 55));
lblSuperzone.setForeground(new Color(0, 0, 0));
lblSuperzone.setBounds(167, 28, 354, 96);
frame.getContentPane().add(lblSuperzone);
JLabel lblNewLabel = new JLabel("New label");
lblNewLabel.setIcon(new ImageIcon("C:\\Users\\navar\\OneDrive\\Desktop\\supermarket.jpg"));
lblNewLabel.setBounds(0, 0, 774, 482);
frame.getContentPane().add(lblNewLabel);


}
}