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
		
		JLabel lblLastName = new JLabel("Last Name ");
		
		JLabel lblEmailId = new JLabel("Email ID ");
		
		JLabel lblFirstName_1 = new JLabel("Password");
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		
		JLabel lblAddress = new JLabel("Address");
		
		JLabel lblState = new JLabel("State");
		
		JLabel lblZip = new JLabel("Zip");
		
		JLabel lblNameOnCard = new JLabel("Name on Card");
		
		JLabel lblCardNumber = new JLabel("Card Number");
		
		JLabel lblCvv = new JLabel("CVV");
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		
		textFName = new JTextField();
		textFName.setColumns(10);
		
		textLName = new JTextField();
		textLName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		
		textNameCard = new JTextField();
		textNameCard.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		textZip = new JTextField();
		textZip.setColumns(10);
		
		textcardNumber = new JTextField();
		textcardNumber.setColumns(10);
		
		textCVV = new JTextField();
		textCVV.setColumns(10);
		
		textExp = new JTextField();
		textExp.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// Needs to insert data into the customer table  
			}
		});
		btnSubmit.setBackground(new Color(154, 205, 50));
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblCardDetails = new JLabel("Card Details");
		lblCardDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmailId, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFirstName_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textEmail)
										.addComponent(textLName)
										.addComponent(textFName)
										.addComponent(passwordField)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblCardNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNameOnCard, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lblCvv)
										.addComponent(lblExpiryDate))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(6)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(textExp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(102)
													.addComponent(btnSubmit))
												.addComponent(textCVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textcardNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textNameCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
													.addGap(119)
													.addComponent(lblZip, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(textZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
										.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAccountDetails))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCardDetails, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)))
					.addGap(138))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblAccountDetails)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textLName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmailId, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(lblFirstName_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblZip, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(lblCardDetails)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNameOnCard)
						.addComponent(textNameCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCardNumber)
						.addComponent(textcardNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCvv)
							.addGap(26)
							.addComponent(lblExpiryDate))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textCVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textExp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSubmit))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
