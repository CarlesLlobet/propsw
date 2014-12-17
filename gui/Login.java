package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Login extends JPanelBg{

	private JButton button;
	private JTextField user;
	private JPasswordField pass;
	private JLabel lblContrasea;
	private JLabel lblAccederComo;
	private JComboBox<String> box;
	private Box horizontalBox;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Box horizontalBox_1;
	private Component horizontalGlue_2;
	private JComboBox<String> rebel;
	private Component horizontalGlue_3;
	private JLabel lblNewLabel;
	private String idrebelde;
	private String idcapitan;
	
	public Login() {
		//Preparamos la vista
		setBounds(100, 100, 793, 499);
		setFocusTraversalPolicyProvider(true);
		setAutoscrolls(true);
        setImage("/images/bg.jpg");
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		add(verticalGlue_2);
		
		lblAccederComo = new JLabel("Acceder como:");
		lblAccederComo.setMaximumSize(new Dimension(120, 23));
		lblAccederComo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccederComo.setFocusable(false);
		lblAccederComo.setAlignmentX(0.5f);
		add(lblAccederComo);
		
		horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		box = new JComboBox<String>();
		box.setFont(new Font("Tahoma", Font.PLAIN, 14));
		horizontalBox.add(box);
		box.setMaximumSize(new Dimension(200, 40));
		actuCombo();
		horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setMaximumSize(new Dimension(100, 23));
		add(lblNewLabel);
		
		horizontalBox_1 = Box.createHorizontalBox();
		add(horizontalBox_1);
		
		horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);
		
		rebel = new JComboBox<String>();
		rebel.setVisible(false);
		rebel.setMaximumSize(new Dimension(200, 40));
		rebel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		horizontalBox_1.add(rebel);
		
		horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_3);
	
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
		
		lblContrasea = new JLabel("Contrase\u00F1a");
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
		button.setSelected(true);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMinimumSize(new Dimension(100, 23));
		button.setMaximumSize(new Dimension(100, 23));
		this.add(button);
		Component verticalGlue_3 = Box.createVerticalGlue();
		this.add(verticalGlue_3);
		
		//LOGICA DE LA VISTA
		box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	//entrem al if només quan s'hagi seleccionat l'item, para evitar doble reaccion del listener
                	//Si val = 0 Entrem com a capita, per tant fiquem a visible el camp de password;
	                int val = box.getSelectedIndex();
	                if (val == 0){
	                	lblNewLabel.setText("Usuario");
	                	user.setVisible(true);
		                user.setText("");
	                	rebel.setVisible(false);
	                	lblContrasea.setVisible(true);
	                	pass.setVisible(true);
	                	pass.setText("");
	                }
	                else {
	                	lblNewLabel.setText("Rebelde");
	                	user.setVisible(false);
	                	rebel.setVisible(true);
	                	lblContrasea.setVisible(false);
	                	pass.setVisible(false);
	                	idcapitan = rebelCapId(box.getSelectedItem().toString());
	                	Principal.getCc().setIdCap(idcapitan);
	                	ArrayList<String> rebs = Principal.getCc().ordenarArrayString(new ArrayList<String>(Principal.getCc().getCapita(idcapitan).getRebels().keySet()));
	                	for (String s2: rebs){
	                		rebel.addItem(s2);
	                	}
	                }
                }
            }
		});
		
		rebel.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	idrebelde = rebel.getSelectedItem().toString();
                }
            }
        });
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (box.getSelectedIndex() == 0){
					String us = user.getText();
					String pa = String.valueOf(pass.getPassword());
					System.out.println("El valor de usuario: " +us);
					System.out.println("Contraseña: " + pa);
					if (Principal.getCc().login(us, pa) != null){
						deleteView();
						Principal.loadMenuCapita();
					}
					else {
						JOptionPane.showMessageDialog(Principal.getWindow(), "Usuario y/o contraseña incorrectos");
					}
				}
				else {
					System.out.println("Iniciamos sesión como rebelde " + idrebelde + " del capitan "+ idcapitan);
					deleteView();
					Principal.loadSessioRebel(idcapitan,idrebelde);
				}
			}
		});
	}

	public void config(){
		//Solicitamos focus al JComboBox
		box.requestFocusInWindow();
		
		//Asociamos la tecla intro con el botón de entrar
		JRootPane rootPane = SwingUtilities.getRootPane(button); 
		rootPane.setDefaultButton(button);
		
		//Centramos el texto del JComboBox
		((JLabel)box.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void actuCombo(){
		ArrayList<String> caps = Principal.getCc().arrayListCapOrd();
		box.removeAllItems();
		box.addItem("Capitán");
		for (String s : caps){
			box.addItem("Rebelde del capitán: " + s);
		}
	}
	
	//Donat un string del combo box, retorna la id del capita del rebel.
	private String rebelCapId(String s){
		boolean dospunts = false;
		int i = 0;
		while (!dospunts && i < s.length()){
			char c = s.charAt(i);
			if (String.valueOf(c).equals(":")){
				dospunts = true;
			}
			++i;
		}			
		++i;
		String id = s.substring(i, s.length());
		return id;
	}
}
