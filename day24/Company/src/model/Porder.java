package model;

public class Porder {
	//field
	private int id;
	private String name;
	private int ruler;
	private int pen;
	private int sum;
	
	//constructors
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Porder(String name, int ruler, int pen) {
		super();
		this.name = name;
		this.ruler = ruler;
		this.pen = pen;
		sum=ruler*29+pen*30;
	}
	
	//methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRuler() {
		return ruler;
	}
	public void setRuler(int ruler) {
		this.ruler = ruler;
	}
	public int getPen() {
		return pen;
	}
	public void setPen(int pen) {
		this.pen = pen;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
