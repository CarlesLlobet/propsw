package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JPanelBg{

	private boolean usermod = false;
	private boolean passmod = false;
	private JButton button;
	private JTextField user;
	private JPasswordField pass;
	
	public Login() {
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("/images/bg.jpg");
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		add(verticalGlue_2);
	
		user = new JTextField();
		user.setRequestFocusEnabled(false);
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setText("Usuario");
		user.setToolTipText("");
		user.setName("Usuario");
		user.setMinimumSize(new Dimension(100, 23));
		user.setMaximumSize(new Dimension(100, 2));
		this.add(user);
		user.setColumns(10);
		
		user.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (!usermod) user.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		        // nothing
		    	if (user.getText().equals("")) user.setText("Usuario");
		    	else usermod = true;
		    	
		    }
		});
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		this.add(verticalStrut_1);
		
		pass = new JPasswordField();
		pass.setRequestFocusEnabled(false);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setText("********");
		pass.setMaximumSize(new Dimension(100, 48));
		this.add(pass);
		pass.setColumns(10);
		
		pass.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        if (!passmod) pass.setText("");
		    }
		    public void focusLost(FocusEvent e) {
		        // nothing
		    	String password = new String(pass.getPassword());  
		    	if (password.length() == 0) pass.setText("********");
		    	else passmod = true;
		    }
		});

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		this.add(verticalStrut_3);
		
		button = new JButton("Entrar");
		button.setSelected(true);
		button.setFocusCycleRoot(true);
		button.setFocusTraversalPolicyProvider(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//check user i password introduits etc 
				Menu m = new Menu();
				destroyPanel();
				Principal.loadView(m);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(100, 23));
		button.setMaximumSize(new Dimension(100, 23));
		this.add(button);
		button.requestFocus();
		Component verticalGlue_3 = Box.createVerticalGlue();
		this.add(verticalGlue_3);
		
		}

}
