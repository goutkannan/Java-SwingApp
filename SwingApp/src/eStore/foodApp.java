package eStore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Create the application.
	 */
	public foodApp() {
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
			public void actionPerformed(ActionEvent e) {
				//check for match in ID 
				frame.dispose();
				
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
