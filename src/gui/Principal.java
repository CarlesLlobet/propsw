package gui;

import java.awt.Component;

public class Principal {
	/**
	 * Launch the application.
	 */
	
	private static Ventana window = new Ventana();
	private static Login l;
	private static MenuCapita mc;
	
	private static void checks(){
		window.invalidate();
        window.validate();
        window.repaint();
		window.setVisible(true);
	}

	private static void initView(){
		//incialitzem totes les vistes del programa
		l = new Login();
		mc = new MenuCapita();
	}
	
	private static void prepareGUI(){
		loadLogin();
	}
	
	public static void main(String[] args) {
		initView();
		prepareGUI();
	}
	

	public static void loadLogin(){
		window.add(l);
		checks();
	}

	public static void removeLogin(){
		window.remove(l);
		//checks();
	}

	public static void loadMenuCapita(){
		window.add(mc);
		checks();
	}
	
	public static void removeMenuCapita(){
		window.remove(mc);
		//checks();
	}
	
	public static Ventana getWindow(){
		return window;
	}
	
	public static void removeView(Component c){
		window.remove(c);
		//checks();
	}
	
}
