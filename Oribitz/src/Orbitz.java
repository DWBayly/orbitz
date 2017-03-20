
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.imageio.*;
import javax.swing.*;
public class Orbitz extends JPanel implements KeyListener{
	public static Orbitz panel;
	public static JFrame j;
	public static Movable O;
	public static Movable P;
	public static List<Movable> L;
	public static Object dest;
	public void keyTyped(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent e){
			
	}
	public void keyPressed(KeyEvent e){
		
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.blue);
		if(L.isEmpty()){
			return;
		}
		for(int i=0;i<L.size();i++){
			if(L.get(i)instanceof Bullet){
				g.setColor(Color.red);
				g.drawOval((int)L.get(i).x,(int)L.get(i).y,3,3);
			}else{
				g.setColor(Color.blue);
				g.drawOval((int)L.get(i).x,(int)L.get(i).y,10,10);
			}
		}
	}

	public void update(int ticks){
		pctrl();
		octrl();
		for(int i=0;i<L.size();i++){
			L.get(i).update();
			if(L.get(i) instanceof Bullet){
				if(L.get(i).counter>100||10>L.get(i).getDist((int)L.get(i).dest.x,(int)L.get(i).dest.y)){
					L.remove(i);
				}
			}
		}
		panel.repaint();
	}
	public static void main(String args[]){
		L=new ArrayList<Movable>();
		JFrame frame=new JFrame();
		frame.setLayout(new GridLayout(1,2));
		frame.setSize(700,700);
		frame.setVisible(true);
		Object p= new Object ("NEWOBJECT", 1,1);
		panel=new Orbitz();
		panel.setBackground(Color.black);
		panel.setSize(700, 700);
		panel.setVisible(true);
		frame.add(panel);
		JTextField t = new JTextField();
		t.setVisible(true);
		t.setSize(100,100);
		t.addKeyListener(panel);
		frame.add(t);
		O=new Movable("DEBBIE",100,120);
		O.moveTowards(1400, 1400);
		O.setVelocity(2);
		P=new Movable("DEBBIE",100,100);
		P.moveTowards(100, 120);
		P.setVelocity(3);
		L.add(P);
		L.add(O);
		
		//fire(O,400,500);
		//O.dx=100;
		clock c= new clock();
		c.start();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		//O.moveTo(100,100,100);
	}
	public static int fire(Movable O, int x,int y){
		Bullet Projectile=new Bullet("P",(int)O.x,(int)O.y,O);
		Projectile.moveTowards(x, y);
		Projectile.v=5;
		L.add(Projectile);
		return L.indexOf(Projectile);
	}
	public static void pctrl(){
		if(P.counter%10==1){
			fire(P,(int)500,(int)520);
		}
	}
	public static void octrl(){
		if(O.counter%10==1){
			fire(O,(int)300,(int)300);
		}
		/*if(O.counter%500>400){
			O.v=10;
			O.moveTowards(400, 500);
			
		}else if (O.counter%500>200){
			O.v=10;
			O.moveTowards(100, 300);
		}else{
			O.v=10;
			O.moveTowards(40, 30);
		}*/
	}
	
}

