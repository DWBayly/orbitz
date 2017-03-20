
public class clock implements Runnable{
	private Thread t;
	private int ticks;
	public void start(){
		t=new Thread(this);
		t.start();
	}
	public int getTicks(){
		return this.ticks;
	}
	public void run(){
		ticks=0;	
		try{
			while (true){
				Thread.sleep(30);
				//System.out.println("current ticks="+ticks);
				Orbitz.panel.update(ticks);
				ticks++;
			}
		}catch (InterruptedException e){
			System.exit(0);
		}
	}
}
