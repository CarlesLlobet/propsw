package gui;

import java.awt.Window;

import javax.swing.JComponent;

public class Principal {
	/**
	 * Launch the application.
	 */
	
	private static Window window;
	
	private static void prepareGUI(){
		window = new Ventana();
		Login login = new Login();
		window.add(login.getGUI());
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		prepareGUI();
	}

	public static void loadView(JPanelBg j){
		//Sempre que es cridi a loadview, caldra cridar al destroyPanel del component que crida.
		System.out.println("Cambiamos al componente por parametro");
		window.add(j);
		window.setVisible(true);
	}
	public static Window getWindow(){
		return window;
	}
}
