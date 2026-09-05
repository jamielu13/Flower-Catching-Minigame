import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player implements ActionListener
{
    Image player;
    Timer timer;
    String [] list;
    int count;
    public Player()
    {
        player = new ImageIcon("src/Last/princess.png").getImage();
        timer = new Timer(500, this);
		timer.start();
        list = new String[]{"src/Last/princess.png","src/Last/princess2.png"};
        count = 0;
    }
    public Image getPlayer()
    {
        return player;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(count >= list.length)
            {
                count = 0;
            }
		player = new ImageIcon(list[count]).getImage();
        count++;
	}

}
