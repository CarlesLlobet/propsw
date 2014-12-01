package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Menu extends JPanelBg {
	
	private JComboBox<String> box;
	private JButton btnAcceder;
	private JButton btnNewButton;
	/**
	 * Create the panel.
	 */
	public Menu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setImage("/images/bg.jpg");
        
        box = new JComboBox<String>();
        box.setRequestFocusEnabled(false);
        box.setFocusCycleRoot(true);
        box.setFont(new Font("Tahoma", Font.PLAIN, 14));
        box.setFocusTraversalPolicyProvider(true);
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
        btnAcceder.setRequestFocusEnabled(false);
        btnAcceder.setFocusCycleRoot(true);
        btnAcceder.setFocusTraversalPolicyProvider(true);
        btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAcceder.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(btnAcceder);
        
        Component verticalGlue_1 = Box.createVerticalGlue();
        add(verticalGlue_1);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
        btnNewButton = new JButton("Cerrar sesión");
        btnNewButton.setRequestFocusEnabled(false);
        btnNewButton.setFocusCycleRoot(true);
        btnNewButton.setFocusTraversalPolicyProvider(true);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox.add(btnNewButton);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_1);
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login l = new Login();
        		Principal.loadView(l);
        		destroyPanel();
        	}
        });
        
	}

}
