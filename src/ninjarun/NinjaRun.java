
package ninjarun;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Ambesh Tiwari
 */
public class NinjaRun extends JFrame implements KeyListener{
    static NinjaRun nr;
    Animation idleNinja,runNinja,ninJump;
    Sprite ninja;
    
    Graphics bfg; Image bfi;
    
    NinjaRun(){
        setLocation(200,50);
        setSize(1600,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        addKeyListener(this);
        setVisible(true);
    }
    
    Thread thread = new Thread(){
        @Override
        public void run(){
            //for updating and repainting
          while(true){  
            ninja.update();
            repaint();
            pause(50);
            }
            
        }
    };
    public static void main(String[] args) { 
        nr= new NinjaRun();
         
        nr.idleNinja= new Animation(100,180);
        nr.runNinja=new Animation(130,180);
        nr.ninJump= new Animation(140,180);
        nr.loadAnimations();
        
        nr.ninja= new Sprite(nr.idleNinja,50,500);
        nr.thread.start();
       
        
    }
    
    public void loadAnimations(){
        for(int i=0;i<10;i++)nr.idleNinja.addImage(new ImageIcon("NinPics/Idle__00"+i+".png").getImage());
        for(int i=0;i<10;i++)nr.runNinja.addImage(new ImageIcon("NinPics/Run__00"+i+".png").getImage()); 
        for(int i=0;i<10;i++)nr.ninJump.addImage(new ImageIcon("NinPics/Jump__00"+i+".png").getImage());
    }
    
    
    @Override
    public void paint(Graphics g){
        bfi= createImage(getWidth(),getHeight());
        bfg= bfi.getGraphics();
        paintComponent(bfg);
        g.drawImage(bfi, 0, 0, nr);
    }
    
    
    public void paintComponent(Graphics g){
       try{
           ninja.draw(g); 
        } catch(Exception ex){}
    }
    
    
    public void pause(long time){
        try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                System.out.print(ex);
            }
    }
    
    public void ninXMove(int dir){
         ninja.setVX(10*dir); ninja.setAnimation(runNinja);
    }
    public void ninIdle(){
        ninja.setVX(0);   ninja.setVY(0);
        ninja.setAnimation(idleNinja);
    }
    public void ninJump(){
      
        Thread ninThread= new Thread(){
        int temp=ninja.getY();
        Animation temp1=ninja.getAnimation();
            public void run(){
                    ninja.setVY(-40);
                    ninja.setAnimation(ninJump);
                pause(600);
                ninja.setAnimation(temp1);
            }
            };
        ninThread.start();
    }
    
   
    @Override
    public void keyTyped(KeyEvent ke) {
    }

     @Override
    public void keyPressed(KeyEvent ke) {
        
        switch(ke.getKeyCode()){
                case KeyEvent.VK_RIGHT: ninXMove(2);
                break;
                case KeyEvent.VK_LEFT: ninXMove(-1);
                break;
                case KeyEvent.VK_SPACE: ninJump();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    
   
}
