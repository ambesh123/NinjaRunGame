/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninjarun;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Ambesh Tiwari
 */
public class Animation {
    private final ArrayList<Image> images = new ArrayList<>();
    private int currIndex;
    public int height,width;
    
    Animation(int w, int h){
        width=w;
        height=h;
        currIndex=0;
    }
    
    public void addImage(Image i){
        images.add(i);
    }
    
    public void update(){
        if(currIndex>=images.size()-1)currIndex=0;
        else currIndex++;
    }
    public Image getImage(){
       return images.get(currIndex);
    }
}
