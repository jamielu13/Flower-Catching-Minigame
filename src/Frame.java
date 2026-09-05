import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener, ActionListener
{
    Game game;
    Timer time;
    boolean left;
    boolean right;
    int leftlimit;
    int rightlimit;
    public Frame()
    {
        game = new Game();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(game);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
        this.addKeyListener(this);
        time = new Timer(10,this);
        left = false;
        right = false;
        time.start();
        leftlimit = 0;
        rightlimit = 550;
    }

    public void keyTyped(KeyEvent e)
    {
        String s = e.getKeyChar() + "";
        if(s.equals("a") || s.equals("A"))
        {
            left = true;
        }
        if(s.equals("d") || s.equals("D"))
        {
            right = true;
        }
    }
    public void keyPressed(KeyEvent e)
    {
    }
    public void keyReleased(KeyEvent e)
    {
        String s = e.getKeyChar() + "";
        if(s.equals("a") || s.equals("A"))
        {
            left = false;
        }
        if(s.equals("d") || s.equals("D"))
        {
            right = false;
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(game.getPlayerX()> leftlimit && game.getPlayerX()< rightlimit)
        {
            if(left)
            {
                game.changePlayerX(game.getPlayerX() - 15);
            }
            if(right)
            {
                game.changePlayerX(game.getPlayerX() + 15);
            }
        }
        else if(game.getPlayerX()<=leftlimit)
        {
            game.changePlayerX(game.getPlayerX() +10);
        }
        else if(game.getPlayerX()>=rightlimit)
        {
            game.changePlayerX(game.getPlayerX() - 10);
        }
    }
}
