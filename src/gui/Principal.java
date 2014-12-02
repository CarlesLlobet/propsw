package gui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Menu;

import javax.swing.JPanel;

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
			container.add(new MenuCapita(), "menucap");
			
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
		container.add(new Login(),"login");
		card.show(container,"login");
	}
	
	public static void loadMenuCapita(){
		container.add(new MenuCapita(),"menucap");
		card.show(container,"menucap");
	}
	
	public static Ventana getWindow(){
		return window;
	}
}
