import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Falling implements ActionListener
{
    static int health;
    Timer timer;
    int x;
    int y;
    int speed;
    Image falling;
    int count;
    boolean run;
    String [] flowers;
    public Falling(String s)
    {
        falling = new ImageIcon(s).getImage();
        timer = new Timer (60,this);
//        x = (int)(Math.random()*10 + 1);
        x = (int)(Math.random()*510+10);
        y = -100;
        speed = 10;
        count = 0;
        run = true;
        timer.start();
        health = 3;
        flowers = new String[]{"src/Last/blue.png","src/Last/redflower.png","src/Last/bloodred.png"};
    }
    public void changeF()
    {
        falling = new ImageIcon(flowers[(int)(Math.random()*flowers.length)]).getImage();
    }
    public static int getHP()
    {
        return health;
    }
    public int getY()
    {
        return y;
    }
    public void changeY(int i)
    {
        y = i;
        x = (int)(Math.random()*510+10);
    }
    public int getX()
    {
        return x;
    }
    public boolean getrun()
    {
        return run;
    }
    public Image getFall()
    {
        return falling;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(health==0)
        {
            run = false;
        }
        if(run)
        {
            count++;
            y += speed;
            if(count % 100 == 0)
            {
                speed++;
            }
            if(y > 580)
            {
                y = -100;
                x = (int)(Math.random()*510+10);
                changeF();
                health--;
            }
        }
    }

}
