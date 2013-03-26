package Model;

public class Motor {

	private double size;
	private String model;
	private String ben_dies;
	
	public Motor (double s, String m, String ben){
		this.size = s;
		this.model = m;
		this.ben_dies = ben;
	}
	
	public double getSize(){return this.size;}
	public String getModel(){return this.model;}
	public String getBen_Dies(){return ben_dies;}
	
}
