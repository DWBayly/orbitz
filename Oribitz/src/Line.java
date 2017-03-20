
public class Line extends Point{
	Point a;
	Point b;
	public Line(String name,int x,int y,Point b){
		super(name,x,y);
		this.a=new Point("a",x,y);
		this.b=b;
	}
	public Point getb (){
		return b;
	}
	public double getDist(){
			return Math.sqrt(((Math.pow((x-b.x),2)+Math.pow((y-b.y),2))));		
	}
}
