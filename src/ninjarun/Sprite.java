
package ninjarun;

import java.awt.Graphics;
/**
 *
 * @author Ambesh Tiwari
 */
public class Sprite{
    private Animation a;
    private int x,y,vx,vy;
    private final int gravity,groundY;
    
    Sprite(Animation a, int x, int y){
        this.a=a; this.x=x; this.y=y;
        vx=0; vy=0; gravity=8;
        groundY=y-a.height;
    }
    public void setAnimation(Animation a){
        this.a=a; // groundY=y-a.height;
    }
    public Animation getAnimation(){
        return a;
    }
    public void setVX(int vx){
        this.vx=vx;
    }
    public void setVY(int vy){
        this.vy=vy;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void update(){
      //System.out.printf("y %d groundY %d  vy %d\n",y,groundY,vy);
      if(x<0)vx=Math.abs(vx);
      if(x+a.width>NinjaRun.nr.getWidth())vx=-1*Math.abs(vx);
      
      x+=vx; 
      y+=vy;
      a.update();
      if(y-a.height<groundY)vy+=gravity;
      else if(y-a.height==groundY)setVY(0);
    }
    
    public void draw(Graphics g){
        g.drawImage(a.getImage(),x,y-a.height,a.width,a.height,NinjaRun.nr);
    }
    

   
    

}
