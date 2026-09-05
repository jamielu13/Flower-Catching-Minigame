import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Game extends JPanel implements ActionListener
{
    private final Player player;
    private final Image bg;
    private int playerX;
    private int score;
    private Image health;
    private final Falling one;
    private final Falling two;
    private final Falling three;
    private final Falling four;
    private final Falling five;
    private final Image gameOver;
    private final Image scoreImage;

    private Image score1;
    private Image score2;
    private Image score3;
    private Clip sound;
    private boolean soundStart;
	public Game()
	{
        this.setPreferredSize(new Dimension(600,600));
		this.setBackground(Color.black);
        player = new Player();
        Timer timer = new Timer(50, this);
        timer.start();
        playerX = 0;
        one = new Falling("src/Last/redflower.png");
        two = new Falling("src/Last/blue.png");
        two.changeY(-300);
        three = new Falling("src/Last/bloodred.png");
        three.changeY(-500);
        four = new Falling("src/Last/redflower.png");
        four.changeY(-700);
        five = new Falling("src/Last/bloodred.png");
        five.changeY(-900);
        bg = new ImageIcon("src/Last/sunset.png").getImage();
        score = 0;
        health = new ImageIcon("src/Last/fullhp.png").getImage();
        gameOver = new ImageIcon("src/Last/endscreen.png").getImage();
        scoreImage = new ImageIcon("src/Last/score.png").getImage();
        score1 = new ImageIcon("src/Last/0.png").getImage();
        score2 = new ImageIcon("src/Last/0.png").getImage();
        score3 = new ImageIcon("src/Last/0.png").getImage();
        soundStart = true;
	}
    public void paint(Graphics g)
    {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bg, 0, 0, null);
		g2D.drawImage(player.getPlayer(), playerX, 470, null);
        g2D.drawImage(one.getFall(), one.getX(), one.getY(), null);
        g2D.drawImage(two.getFall(), two.getX(), two.getY(), null);
        g2D.drawImage(three.getFall(), three.getX(), three.getY(), null);
        g2D.drawImage(four.getFall(), four.getX(), four.getY(), null);
        g2D.drawImage(five.getFall(), five.getX(), five.getY(), null);
        g2D.drawImage(health, 350, 0, null);
        g2D.drawImage(scoreImage, 0,0, null);
        g2D.drawImage(score1, 0, 0, null);
        g2D.drawImage(score2, 55,0, null);
        g2D.drawImage(score3, 110,0, null);
        if(!one.getrun())
        {

            if(soundStart) {
                try {
                    File file = new File("src/Last/gameover.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    sound = AudioSystem.getClip();
                    sound.open(audioStream);
                } catch (Exception a) {
                    System.out.println("Error: " + a.getMessage());
                }
                sound.start();
                soundStart = false;
            }
            g2D.drawImage(gameOver, 0, 0, null);
        }
    }
    public int getPlayerX()
    {
        return playerX;
    }
    public void changePlayerX(int i)
    {
        playerX = i;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(Falling.getHP() == 0)
        {
            health = new ImageIcon("src/Last/0hp.png").getImage();
        }
        repaint();
		if(one.getrun())
        {
            if((one.getX() < playerX + 70 && one.getX() > playerX -  70) && (one.getY() < 530 && one.getY() > 450))
            {
                one.changeY(-100);
                one.changeF();
                score++;
                try {
                    File file = new File("src/Last/coin.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    sound = AudioSystem.getClip();
                    sound.open(audioStream);
                } catch (Exception a)
                {
                    System.out.println("Error: " + a.getMessage());
                }
                sound.start();
            }
            if(two.getX() < playerX +  70 && two.getX() > playerX -  70 && two.getY() < 530 && two.getY() > 450)
            {
                two.changeY(-100);
                two.changeF();
                score++;
                try {
                    File file = new File("src/Last/coin.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    sound = AudioSystem.getClip();
                    sound.open(audioStream);
                } catch (Exception b)
                {
                    System.out.println("Error: " + b.getMessage());
                }
                sound.start();
            }
            if(three.getX() < playerX +  70 && three.getX() > playerX -  70 && three.getY() < 530 && three.getY() > 450)
            {
                three.changeY(-100);
                three.changeF();
                score++;
                try {
                    File file = new File("src/Last/coin.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    sound = AudioSystem.getClip();
                    sound.open(audioStream);
                } catch (Exception c)
                {
                    System.out.println("Error: " + c.getMessage());
                }
                sound.start();
            }
            if(four.getX() < playerX +  70 && four.getX() > playerX -  70 && four.getY() < 530 && four.getY() > 450)
            {
                four.changeY(-100);
                four.changeF();
                score++;
                try {
                    File file = new File("src/Last/coin.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    sound = AudioSystem.getClip();
                    sound.open(audioStream);
                } catch (Exception d)
                {
                    System.out.println("Error: " + d.getMessage());
                }
                sound.start();
            }
            if(five.getX() < playerX +  70 && five.getX() > playerX -  70 && five.getY() < 530 && five.getY() > 450)
            {
                five.changeY(-100);
                five.changeF();
                score++;
                try {
                    File file = new File("src/Last/coin.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    sound = AudioSystem.getClip();
                    sound.open(audioStream);
                } catch (Exception f)
                {
                    System.out.println("Error: " + f.getMessage());
                }
                sound.start();
            }
        }

        if(Falling.getHP() == 1)
        {
            health = new ImageIcon("src/Last/1hp.png").getImage();
        }
        if(Falling.getHP() == 2)
        {
            health = new ImageIcon("src/Last/2hp.png").getImage();
        }
        switch(score%10)
        {
            case 0:
                score3 = new ImageIcon("src/Last/0.png").getImage();
                break;
            case 1:
                score3 = new ImageIcon("src/Last/1.png").getImage();
                break;
            case 2:
                score3 = new ImageIcon("src/Last/2.png").getImage();
                break;
            case 3:
                score3 = new ImageIcon("src/Last/3.png").getImage();
                break;
            case 4:
                score3 = new ImageIcon("src/Last/4.png").getImage();
                break;
            case 5:
                score3 = new ImageIcon("src/Last/5.png").getImage();
                break;
            case 6:
                score3 = new ImageIcon("src/Last/6.png").getImage();
                break;
            case 7:
                score3 = new ImageIcon("src/Last/7.png").getImage();
                break;
            case 8:
                score3 = new ImageIcon("src/Last/8.png").getImage();
                break;
            case 9:
                score3 = new ImageIcon("src/Last/9.png").getImage();
                break;

        }
        switch(score%100/10)
        {
            case 0:
                score2 = new ImageIcon("src/Last/0.png").getImage();
                break;
            case 1:
                score2 = new ImageIcon("src/Last/1.png").getImage();
                break;
            case 2:
                score2 = new ImageIcon("src/Last/2.png").getImage();
                break;
            case 3:
                score2 = new ImageIcon("src/Last/3.png").getImage();
                break;
            case 4:
                score2 = new ImageIcon("src/Last/4.png").getImage();
                break;
            case 5:
                score2 = new ImageIcon("src/Last/5.png").getImage();
                break;
            case 6:
                score2 = new ImageIcon("src/Last/6.png").getImage();
                break;
            case 7:
                score2 = new ImageIcon("src/Last/7.png").getImage();
                break;
            case 8:
                score2 = new ImageIcon("src/Last/8.png").getImage();
                break;
            case 9:
                score2 = new ImageIcon("src/Last/9.png").getImage();
                break;

        }
        switch(score/100) {
            case 0:
                score1 = new ImageIcon("src/Last/0.png").getImage();
                break;
            case 1:
                score1 = new ImageIcon("src/Last/1.png").getImage();
                break;
            case 2:
                score1 = new ImageIcon("src/Last/2.png").getImage();
                break;
            case 3:
                score1 = new ImageIcon("src/Last/3.png").getImage();
                break;
            case 4:
                score1 = new ImageIcon("src/Last/4.png").getImage();
                break;
            case 5:
                score1 = new ImageIcon("src/Last/5.png").getImage();
                break;
            case 6:
                score1 = new ImageIcon("src/Last/6.png").getImage();
                break;
            case 7:
                score1 = new ImageIcon("src/Last/7.png").getImage();
                break;
            case 8:
                score1 = new ImageIcon("src/Last/8.png").getImage();
                break;
            case 9:
                score1 = new ImageIcon("src/Last/9.png").getImage();
                break;
        }
        }
}

