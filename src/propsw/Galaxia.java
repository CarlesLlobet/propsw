
package propsw;

public class Galaxia {
	
	private static Integer cont = 0;
	private String id;
	
	public Galaxia(){
		++cont;
		this.id = cont.toString();
	}
	
	public String getId(){
		return this.id;
	}
}