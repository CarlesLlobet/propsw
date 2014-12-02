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
		window.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		loadLogin();		
	}
	

	public static void loadLogin(){
		l = new Login();
		window.add(l);
		checks();
	}

	public static void removeLogin(){
		window.remove(l);
		checks();
	}

	public static void loadMenuCapita(){
		mc = new MenuCapita();
		window.add(mc);
		checks();
	}
	
	public static void removeMenuCapita(){
		mc.invalidate();
		window.remove(mc);
		checks();
	}

	public static void removeView(Component c){
		System.out.println("Remove view : "+ c.getName() + "focus estaba en " + window.getFocusOwner().getName());
		window.remove(c);
		checks();
	}
	
	
	public static Ventana getWindow(){
		return window;
	}
}
