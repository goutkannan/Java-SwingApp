package eStore;

import java.awt.EventQueue;
import eStore.dbutilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import eStore.DbInit;

public class foodApp {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					foodApp window = new foodApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void hi()
	{
		JOptionPane.showMessageDialog(null,"Hi");
	}
	/**
	 * Create the application.
	 */
	public foodApp() {
		DbInit db = new DbInit(); 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(48, 78, 56, 16);
		frame.getContentPane().add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 130, 56, 16);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(121, 75, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 127, 116, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
			{
				//check for match in ID 
			if (validate_login(textField.getText(),passwordField.getText()))
				{
					frame.setVisible(false);
					
					new homepage().setVisible(true);
				}
				
				
			}

			private boolean validate_login(String text, String password)
			{
				
				
				return (password.equals(dbutilities.validatepwd(text)));
				
			}
		});
		btnLogin.setBounds(273, 126, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("New User ? Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Cdetails custDetail = new Cdetails();
				custDetail.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(121, 190, 221, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
