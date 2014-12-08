package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class MenuCapita extends JPanelBg {
	
	private JComboBox<String> box;
	private JButton btnAcceder;
	private JButton btnNewButton;
	//private MenuCapita view;
	/**
	 * Create the panel.
	 */
	public MenuCapita() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setImage("/images/bg.jpg");
        System.out.println("CREADO MENU CAPITAN");
        
        box = new JComboBox<String>();
        box.setRequestFocusEnabled(false);
        box.setFont(new Font("Tahoma", Font.PLAIN, 14));
        box.setMaximumRowCount(10);
        box.addItem("Gestionar rebeldes");
        box.addItem("Gestionar galaxia");
        box.addItem("Gestionar éxodos");
        box.addItem("Ejecutar éxodo");
        box.addItem("Añadir capitán");
        box.addItem("Borrar este capitán");

        Dimension d = new Dimension(150,23);
        
        Component verticalGlue = Box.createVerticalGlue();
        add(verticalGlue);
        box.setMinimumSize(d);
        box.setMaximumSize(d);
        add(box);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        add(verticalStrut);
        
        btnAcceder = new JButton("Acceder");
        btnAcceder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Principal.llistarcomponents();
        	}
        });
        btnAcceder.setRequestFocusEnabled(false);
        btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAcceder.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(btnAcceder);
        
        Component verticalGlue_1 = Box.createVerticalGlue();
        add(verticalGlue_1);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {
		    	if (isVisible()) System.out.println("TECLADO EN MENUCAPITAN");
		        return false;
		      }
		});
        
        btnNewButton = new JButton("Cerrar sesión");
        btnNewButton.setRequestFocusEnabled(false);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox.add(btnNewButton);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_1);

        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Principal.removeMenuCapita();
				System.out.println("To login");
				deleteView();
				Principal.loadLogin();
			}
		});
	}
	
	public void focus(){
		box.requestFocusInWindow();
	}
}
