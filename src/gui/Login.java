package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JPanelBg{

	private JButton button;
	private JTextField user;
	private JPasswordField pass;
	
	public Login() {
		invalidate();
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("/images/bg.jpg");
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		add(verticalGlue_2);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setMaximumSize(new Dimension(100, 23));
		add(lblNewLabel);
	
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setToolTipText("");
		user.setName("Usuario");
		user.setMinimumSize(new Dimension(100, 23));
		user.setMaximumSize(new Dimension(100, 2));
		this.add(user);
		user.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		this.add(verticalStrut_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFocusable(false);
		lblContrasea.setMaximumSize(new Dimension(100, 23));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setAlignmentX(0.5f);
		add(lblContrasea);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setMaximumSize(new Dimension(100, 48));
		this.add(pass);
		pass.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		this.add(verticalStrut_3);
		
		button = new JButton("Entrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("MENU CAPITAN");
				Principal.removeLogin();
				Principal.loadMenuCapita();
			}
		});
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {
		        System.out.println("TECLADO EN LOGIN");
		        return false;
		      }
		});
		
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));

		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(100, 23));
		button.setMaximumSize(new Dimension(100, 23));
		this.add(button);
		Component verticalGlue_3 = Box.createVerticalGlue();
		this.add(verticalGlue_3);
		Principal.getWindow().getRootPane().setDefaultButton(button);
		user.requestFocus();
	}
}
