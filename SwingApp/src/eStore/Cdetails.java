package eStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField textEmail;
	private JTextField txtAddress;
	private JTextField textNameCard;
	private JTextField textZip;
	private JTextField textcardNumber;
	private JTextField textCVV;
	private JTextField textExp;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cdetails frame = new Cdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 693);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setBounds(43, 48, 102, 22);
		
		JLabel lblLastName = new JLabel("Last Name ");
		lblLastName.setBounds(43, 97, 102, 22);
		
		JLabel lblEmailId = new JLabel("Email ID ");
		lblEmailId.setBounds(43, 149, 102, 22);
		
		JLabel lblFirstName_1 = new JLabel("Password");
		lblFirstName_1.setBounds(43, 208, 102, 22);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(43, 257, 122, 22);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(43, 315, 102, 22);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(43, 377, 102, 22);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setBounds(374, 380, 61, 22);
		
		JLabel lblNameOnCard = new JLabel("Name on Card");
		lblNameOnCard.setBounds(43, 468, 82, 16);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(43, 520, 82, 16);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setBounds(43, 554, 24, 16);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setBounds(43, 596, 64, 16);
		
		textFName = new JTextField();
		textFName.setBounds(181, 48, 116, 22);
		textFName.setColumns(10);
		
		textLName = new JTextField();
		textLName.setBounds(181, 97, 116, 22);
		textLName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(181, 149, 116, 22);
		textEmail.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(183, 315, 169, 22);
		txtAddress.setColumns(10);
		
		textNameCard = new JTextField();
		textNameCard.setBounds(189, 465, 116, 22);
		textNameCard.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(189, 380, 66, 22);
		
		textZip = new JTextField();
		textZip.setBounds(447, 380, 116, 22);
		textZip.setColumns(10);
		
		textcardNumber = new JTextField();
		textcardNumber.setBounds(189, 514, 116, 22);
		textcardNumber.setColumns(10);
		
		textCVV = new JTextField();
		textCVV.setBounds(189, 554, 116, 22);
		textCVV.setColumns(10);
		
		textExp = new JTextField();
		textExp.setBounds(189, 595, 116, 22);
		textExp.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(407, 594, 73, 25);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// Needs to insert data into the customer table  
			}
		});
		btnSubmit.setBackground(new Color(154, 205, 50));
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setBounds(17, 16, 116, 19);
		lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblCardDetails = new JLabel("Card Details");
		lblCardDetails.setBounds(17, 420, 546, 19);
		lblCardDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 199, 116, 22);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(183, 257, 116, 22);
		contentPane.setLayout(null);
		contentPane.add(lblFirstName);
		contentPane.add(lblLastName);
		contentPane.add(lblEmailId);
		contentPane.add(lblFirstName_1);
		contentPane.add(textEmail);
		contentPane.add(textLName);
		contentPane.add(textFName);
		contentPane.add(passwordField);
		contentPane.add(lblConfirmPassword);
		contentPane.add(lblAddress);
		contentPane.add(lblState);
		contentPane.add(lblCardNumber);
		contentPane.add(lblNameOnCard);
		contentPane.add(lblCvv);
		contentPane.add(lblExpiryDate);
		contentPane.add(textExp);
		contentPane.add(btnSubmit);
		contentPane.add(textCVV);
		contentPane.add(textcardNumber);
		contentPane.add(textNameCard);
		contentPane.add(comboBox);
		contentPane.add(lblZip);
		contentPane.add(textZip);
		contentPane.add(passwordField_1);
		contentPane.add(txtAddress);
		contentPane.add(lblAccountDetails);
		contentPane.add(lblCardDetails);
	}
}
