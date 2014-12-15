package gui.gestiocapitans;
import gui.CreaNom;
import gui.ImpExp;
import gui.JPanelBg;
import gui.Principal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GestioCapitans extends JPanelBg {
	private JComboBox<String> box;
	private JButton button;
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel = new JPanel(); 
	private JButton boto;
	
	//vistes que es carregaran:
    private ImpExp eg = new ImpExp();
    private ImpExp ig = new ImpExp();
    private CreaNom cn = new CreaNom();
    private CanviaContra ccontra = new CanviaContra();
	
	public GestioCapitans() {
		
		//PREPARAMOS LA VISTA
        setImage("/images/bg.jpg");
        setLayout(new BorderLayout(0, 0));
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_2);
        
        Box horizontalBox_2 = Box.createHorizontalBox();
        verticalBox.add(horizontalBox_2);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
        horizontalBox_2.add(horizontalGlue_1);
        
        box = new JComboBox<String>();
        box.setPreferredSize(new Dimension(150, 20));
        box.setMinimumSize(new Dimension(150, 20));
        horizontalBox_2.add(box);
        box.setMaximumSize(new Dimension(200, 48));
        
        Component horizontalGlue_2 = Box.createHorizontalGlue();
        horizontalBox_2.add(horizontalGlue_2);
        box.addItem("Crear capitán");
        box.addItem("Cambiar contraseña");
        box.addItem("Esborrar capitán");
        box.addItem("Reset sistema");
        box.addItem("Importar");
        box.addItem("Exportar");
        
        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox.add(verticalBox_1);
        
        Component verticalGlue = Box.createVerticalGlue();
        verticalBox_1.add(verticalGlue);
        
        Box horizontalBox = Box.createHorizontalBox();
        verticalBox_1.add(horizontalBox);
        horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        Component horizontalGlue_5 = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue_5);
        
        panel = new JPanel();
        horizontalBox.add(panel);
        panel.setMaximumSize(new Dimension(48515, 562356));
        panel.setLayout(card);
        
        //Carreguem toas las vistas que vamos a utilizar y mostramos el dibujo
        panel.add(cn,"crea");
        panel.add(ccontra,"CambiaContra");
        panel.add(ig,"import");
        panel.add(eg,"export");
        card.show(panel, "crea");
                
        Component horizontalGlue_6 = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue_6);
        
        Box horizontalBox_4 = Box.createHorizontalBox();
        verticalBox_1.add(horizontalBox_4);
        
        Component horizontalGlue_7 = Box.createHorizontalGlue();
        horizontalBox_4.add(horizontalGlue_7);
        
        boto = new JButton("Crear");
        horizontalBox_4.add(boto);
        
        Component horizontalGlue_8 = Box.createHorizontalGlue();
        horizontalBox_4.add(horizontalGlue_8);
        boto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int val = box.getSelectedIndex();
        		switch(val) {
        			case 0: 
        				String lectura = cn.getNom();
        				if (lectura.equals("")) {
        					alertaCapitaNoNom();
        				}
        				else if (!Principal.getCc().checkCapitaNom(lectura)){
								try {
									Principal.getCc().afegirCapita(lectura);
									alertaCapitaAfegit(lectura);
									//Aquesta s'haura de borrar
									Principal.getCc().escriureCont();
									cn.reset();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
        				}
        				else {
        					alertaCapitaNomE();
        				}
        				break;
        			case 1: //cambiar contraseña
        				/*
        				Capita c = Principal.getCc().getCapita();
        				if (c == null) System.out.println("CAPITA NUL");
        				String current = c.getPassword();
        				String s1; = String.valueOf(ccontra.new1().getPassword());
        				String s2 = String.valueOf(ccontra.new2().getPassword());
        				String old = String.valueOf(ccontra.old().getPassword());
        				System.out.println("new: " + s1 + "new: "+ s2 + "old: " + old);
        				
        				System.out.println("current: "+ current);

        				if (old.equals(current)){
        					if (s1.equals("") || s2.equals("")){
        						JOptionPane.showMessageDialog(Principal.getWindow(),"La nueva contraseña no puede ser vacía");
        					}else if (s1.equals(s2)) {
        						Principal.getCc().canviContra(s1);
        					}else {
            					JOptionPane.showMessageDialog(Principal.getWindow(),"Las contraseñas no coinciden");
        					}
        				}
        				else {
        					JOptionPane.showMessageDialog(Principal.getWindow(),"Contraseña incorrecta");
        				}*/
        				break;
        			case 2: //borrar capitan
        				//FALTA PANEL CONFIRMACION
        				Principal.getCc().deleteCapita();
    					JOptionPane.showMessageDialog(Principal.getWindow(),"Capitán eliminado, se vuelve al login.");
        				deleteView();
        				Principal.loadLogin();
        				break;
        			case 3:
        				//FALTA PANEL CONFIRMACION
        				try {
							Principal.getCc().resetSistema();
	        				deleteView();
	        				Principal.getCc().inicialitzar();
	        				Principal.loadLogin();	
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
        				break;
        			case 4: //importar
        				break;
        			case 5: //exportar
        				break;	
        			default:
        				System.out.println("huehue");
        				break;
        		}        		
        	}
        });
                
        Component verticalGlue_1 = Box.createVerticalGlue();
        verticalBox_1.add(verticalGlue_1);
        
        Box horizontalBox_3 = Box.createHorizontalBox();
        verticalBox.add(horizontalBox_3);
        
        Component horizontalGlue_3 = Box.createHorizontalGlue();
        horizontalBox_3.add(horizontalGlue_3);
        
        Component horizontalGlue_4 = Box.createHorizontalGlue();
        horizontalBox_3.add(horizontalGlue_4);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox.add(horizontalBox_1);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        horizontalStrut_2.setPreferredSize(new Dimension(20, 40));
        horizontalStrut_2.setMinimumSize(new Dimension(20, 40));
        horizontalStrut_2.setMaximumSize(new Dimension(20, 40));
        horizontalBox_1.add(horizontalStrut_2);
        
        button = new JButton("Atrás");
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontalBox_1.add(button);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalBox_1.add(horizontalGlue);
        

        //PROGRAMEM EL COMPORTAMENT DE LA VISTA:
        //Programem el comportament cada cop que el JComboBox canvia de valor
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	//entrem al if només quan s'hagi seleccionat l'item, para evitar doble reaccion del listener
	                int val = box.getSelectedIndex();
	                revalidate();	
	                switch(val){
	                	case 0: 
	                		boto.setVisible(true);
	                		boto.setText("Crear");
	                		cn.reset();
	                		panel.setVisible(true);
	                		card.show(panel,"crea");
	                		break;
	                	case 1:
	                		//Ocultamos el botón, que no necesitamos
	                		boto.setVisible(true);
	                		boto.setText("Cambiar");
	                		panel.setVisible(true);
	                		ccontra = new CanviaContra();	                		
	                		card.show(panel,"CambiaContra");
	                		break;
	                	case 2:
	                		panel.setVisible(false);
	                		boto.setVisible(true);
	                		boto.setText("Borrar");
	                		break;
	                	case 3:
	                		//Ocultamos el botón, que no necesitamos
	                		boto.setVisible(true);
	                		boto.setText("Reset");
	                		panel.setVisible(false);
	                		break;
	                	case 4://Marcamos como visible el botón importar/exportar y le asignamos el texto según su función.
	                		panel.setVisible(true);
	                		boto.setVisible(true);
	                		boto.setText("Importar");
	                		ig.reset();
	                		//Cargamos el panel de importar
	                		card.show(panel,"import");
	                		break;
	                	case 5: //Marcamos como visible el botón de importar/exportar y le asignamos el texto según su función
	                		panel.setVisible(true);
	                		boto.setVisible(true);
	                		boto.setText("Exportar");
	                		eg.reset();
	                		//Cargamos el panel de exportar
	                		card.show(panel,"export");
	                		break;
	                	default:
	                		System.out.println("DEFAULT");
	                		break;
	                }
                }
            }
        });
        
        
        //Programem el comportament del botó de retrocedir
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadMenuCapita();
        	}
        }); 
        
        //FALTA PROGRAMAR LA LOGICA SEGUN EXP/IMPORTAR llamadas correspondientes. IMPEXP no tiene lógica ninguna. (matizar)
        
	}
	
	private void alertaCapitaNoNom(){
		JOptionPane.showMessageDialog(Principal.getWindow(),"El capitán debe tener un nombre.");
	}
	
	private void alertaCapitaNomE(){
		JOptionPane.showMessageDialog(Principal.getWindow(),"Ya existe un capitán con ese nombre.");

	}
	
	private void alertaCapitaAfegit(String s){
		JOptionPane.showMessageDialog(Principal.getWindow(),"Se ha añadido el capitán con nombre: " + s);
	}
	
	
	public void config(){
		box.requestFocusInWindow();
		
		//Centramos el texto del JComboBox
		((JLabel)box.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	}
}
