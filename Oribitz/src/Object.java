
public class Object {
	double x;
	double y;
	String name;
	public Object(String name, double x, double y){
		this.x=x;
		this.y=y;
		this.name=name;
	}
	public double getDist(int nx,int ny){
		return Math.sqrt(((Math.pow((x-nx),2)+Math.pow((y-ny),2))));
	}
	public void setX(double x){
		this.x=x;
	}
	public double getX(){
		return x;
	}
}
