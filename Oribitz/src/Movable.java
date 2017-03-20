
public class Movable extends Object{
	double dx;
	double dy;
	Point dest;
	Point Obdest;
	int ax;//acceleration
	int ay;
	int v;//velocity
	int r;
	int mode;
	long counter;
	public Movable(String name, int x,int y){
		super(name,x,y);
		this.mode=0;
		this.v=0;
	}
	public void setVelocity(int v){
		this.v = v;
	}
	public void update(){
		switch(mode){
		default:
				this.counter++;
				if(counter>500){
					counter=0;
				}
				if(this.getDist((int)dest.x,(int)dest.y)<v){
					this.x=dest.x;
					this.y=dest.y;
					mode=3;

				}else{
					this.x=x+dx*v;
					this.y=y+dy*v;
				}
				break;
		case(1):
				if(y>Obdest.y){
					dy=dy-ay;
				}else{
					dy=ay+dy;
				}
				if(x>Obdest.x){
					dx=dx-ax;
				}else{
					dx=dx+ax;
				}
				x=x+dx;
				y=y+dy;
				break;
		case (2):
			if(dx>0 && x>dest.x+100){
				dx=-dx;
			}else if (dx<0 && x<dest.x-100){
				dx=-dx;
			}
			if(dy>0 && y>dest.y+100){
				dy=-dy;
			}else if (dy<0 && y<dest.y-100){
				dy=-dy;
			}
			x=x+dx;
			y=y+dy;
			break;
		case 3:
			
			counter++;
			if(counter>500){
				counter= 0;
			}
			break;
			
		
		case 4:
			counter++;
			if(counter>500){
				counter= 0;
			}
			
			x=x+dx;
			y=y+dy;
			break;
			case 5:
				this.counter++;
				if(counter>500){
					counter=0;
				}
				this.x=x+dx*v;
				this.y=y+dy*v;
			break;
		}

	}
	
	public void setMode(int m){
		this.mode=m;
	}
	public void setObdest(Point d){
		this.Obdest=d;
	}
	public void moveTowards(int x,int y){
		this.dest=new Point("Dest",x,y);
		this.Obdest=new Point("OBdest",x,y);
		this.mode=0;
		dx=((x-this.x)/Math.sqrt((Math.abs(Math.pow(this.x, 2)-Math.pow(x, 2))+(Math.abs(Math.pow(this.x, 2)-Math.pow(x, 2))))));
		dy=((y-this.y)/Math.sqrt((Math.abs(Math.pow(this.x, 2)-Math.pow(x, 2))+(Math.abs(Math.pow(this.x, 2)-Math.pow(x, 2))))));
		dx=dx/(Math.abs(dx)+Math.abs(dy));
		dy=dy/(Math.abs(dx)+Math.abs(dy));
		
	}
}
