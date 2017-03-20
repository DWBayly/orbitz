
public class Bullet extends Movable{
	public boolean isAlive(){
		if( counter > 50){
			return true;
		}
		return false;
	}
	public Bullet(String name, int x, int y,Movable Owner){
		super(name,x,y);
	}
	
}
