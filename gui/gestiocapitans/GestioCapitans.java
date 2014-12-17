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

import propsw.LlegirEscriureNatural;

public class GestioCapitans extends JPanelBg {
	private JComboBox<String> box;
	private JButton atras;
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
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox.add(horizontalBox_1);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        horizontalStrut_2.setPreferredSize(new Dimension(20, 40));
        horizontalStrut_2.setMinimumSize(new Dimension(20, 40));
        horizontalStrut_2.setMaximumSize(new Dimension(20, 40));
        horizontalBox_1.add(horizontalStrut_2);
        
        atras = new JButton("Atrás");
        
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontalBox_1.add(atras);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalBox_1.add(horizontalGlue);
        
        JButton guardar = new JButton("Guardar");
        guardar.setAlignmentX(0.5f);
        horizontalBox_1.add(guardar);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        horizontalStrut.setPreferredSize(new Dimension(20, 40));
        horizontalStrut.setMinimumSize(new Dimension(20, 40));
        horizontalStrut.setMaximumSize(new Dimension(20, 40));
        horizontalBox_1.add(horizontalStrut);
        
        
        //Programem el comportament del botó de retrocedir
        atras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadMenuCapita();
        	}
        }); 
        
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
        		        LlegirEscriureNatural len = new LlegirEscriureNatural(Principal.getCc());
						try {
							String ic = len.llegirCapita(ig.getText());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(Principal.getWindow(),"Ha ocurrido un error mientras se importaba el capitán" );
							e1.printStackTrace();
						}
						ig.reset();
        				break;
        			case 5: //exportar
        				LlegirEscriureNatural len2 = new LlegirEscriureNatural(Principal.getCc());
						try {
							len2.escriureCapita(eg.getText(), Principal.getCc().getCapita().getId());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(Principal.getWindow(),"Ha ocurrido un error mientras se exportaba el capitán" );
							e1.printStackTrace();
						}
						eg.reset();
        				break;	
        			default:
        				System.out.println("huehue");
        				break;
        		}        		
        	}
        });
                
        Component verticalGlue_1 = Box.createVerticalGlue();
        verticalBox_1.add(verticalGlue_1);
        

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
	                		boto.setVisible(false);
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
	                		String s = "Nom de l'arxiu (sense extensió), situat a la carpeta import.";
	                		ig.setText(s);
	                		card.show(panel,"import");
	                		break;
	                	case 5: //Marcamos como visible el botón de importar/exportar y le asignamos el texto según su función
	                		panel.setVisible(true);
	                		boto.setVisible(true);
	                		boto.setText("Exportar");
	                		eg.reset();
	                		String s2 = "Nom de l'arxiu (sense extensió), on s'exportarà el capita.";
	                		eg.setText(s2);
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
