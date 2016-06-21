package eStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;

public class homePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage frame = new homePage();
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
	public homePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(106, 61, 671, 580);
		contentPane.add(tabbedPane);
		
		JTabbedPane dispalyPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, dispalyPane, null);
		
		JTabbedPane displayCart = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, displayCart, null);
		tabbedPane.setEnabledAt(1, false);
		
		JScrollBar scrollBar = new JScrollBar();
		tabbedPane.addTab("New tab", null, scrollBar, null);
	}
}
