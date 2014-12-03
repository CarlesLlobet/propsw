package gui;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal {
	/**
	 * Launch the application.
	 */
	
	//contenedores
	private static Ventana window = new Ventana();
	private static JPanel container = new JPanel();
	private static CardLayout card = new CardLayout();
		
	private static void init(){
			container.setLayout(card);
			
			//Carreguem les vistes
			container.add(new Login(), "login");
			
			//Configurem la finestra
			window.add(container);
			card.show(container,"login");
			window.setVisible(true);
	}

	
	public static void main(String[] args) {
		init();
	}
	
	public static void loadLogin(){
		//Creem una nova instancia, ja que sempre necessitarem partir desde 0
		Login l = new Login();
		container.add(l,"login");
		card.show(container,"login");
		window.setVisible(true);
		l.focus();
	}
	
	public static void removeView(Component c){
		container.remove(c);
	}
	
	public static void loadMenuCapita(){
		MenuCapita mc = new MenuCapita();
		container.add(mc,"menucap");
		card.show(container,"menucap");
		window.setVisible(true);
		mc.focus();
	}
	
	public static Ventana getWindow(){
		return window;
	}
	
	public static void llistarcomponents(){
		Component[] comp = container.getComponents();
		for (int i = 0; i < comp.length; ++i){
			System.out.println("Component : " + i + comp[i].toString());
		}	
	}
}
