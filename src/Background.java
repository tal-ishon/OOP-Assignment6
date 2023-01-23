import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Tal Ishon.
 * Background class.
 * This class represents the backgrounds for each level.
 */
public class Background implements Sprite {
    private String name;

    /**
     * Background constructor.
     * Instantiates a new Background.
     *
     * @param levelName the level name
     */
    public Background(String levelName) {
        name = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (name.equals("Direct Hit")) {
            // creating a target background
           d.setColor(Color.black.brighter());
           d.fillRectangle(10, 30, 790, 690);
           d.setColor(new Color(200, 100, 178));
           d.drawCircle(400, 170, 50);
           d.drawCircle(400, 170, 80);
           d.drawCircle(400, 170, 110);
           d.drawLine(400, 50, 400, 300);
           d.drawLine(250, 170, 550, 170);
        }
        if (name.equals("Wide Easy")) {
            // creating sun
            d.setColor(new Color(121, 160, 217));
            d.fillRectangle(10, 30, 790, 690);
            d.setColor(new Color(232, 215, 110, 255));
            for (int i = 0; i < 100; i++) {
                d.drawLine(200, 190, 10 + 10 * i, 300);
            }
            d.setColor(new Color(232, 215, 110, 255));
            d.fillCircle(200, 170, 80);
            d.setColor(new Color(255, 208, 0));
            d.fillCircle(200, 170, 70);
            d.setColor(Color.YELLOW);
            d.fillCircle(200, 170, 60);

        }
        if (name.equals("Green 3")) {
            d.setColor(new Color(125, 150, 100));
            d.fillRectangle(10, 30, 790, 690);
            d.setColor(new Color(212, 118, 35));
            d.fillRectangle(50, 350, 150, 300);
            d.setColor(new Color(222, 186, 155));
            d.fillRectangle(120, 200, 10, 150);
            d.setColor(Color.black);
            d.drawRectangle(50, 350, 150, 300);
            d.setColor(Color.orange);
            d.fillRectangle(105, 280, 40, 70);
            d.setColor(new Color(232, 215, 110, 255));
            d.fillCircle(125, 200, 15);
            d.setColor(new Color(255, 208, 0));
            d.fillCircle(125, 200, 10);
            d.setColor(Color.white);
            d.fillCircle(125, 200, 5);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    d.setColor(new Color(253, 239, 153, 255));
                    d.fillRectangle(62 + 45 * j, 360 + 60 * i, 36, 50);
                    d.setColor(Color.black);
                    d.drawRectangle(62 + 45 * j, 360 + 60 * i, 36, 50);
                }
            }
        }
        if (name.equals("Final Four")) {
            d.setColor(new Color(105, 84, 151, 255));
            d.fillRectangle(10, 30, 790, 690);
            d.setColor(new Color(106, 232, 220));
            // set rain
            for (int i = 0; i < 15; i++) {
                d.drawLine(50 + 10 * i, 600, 120 + 5 * i, 400);
            }
            for (int i = 0; i < 15; i++) {
                d.drawLine(620 + 10 * i, 600, 570 + 5 * i, 400);
            }
            for (int i = 0; i < 15; i++) {
                d.drawLine(350 + 10 * i, 600, 335 + 5 * i, 450);
            }
            // set clouds on screen
            for (int i = 0, j = 0; i < 3; i++) {
                if (i == 1) { // make the middle cloud lower
                    j = 50;
                }
                d.setColor(new Color(138, 137, 141, 255));
                d.fillCircle(110 + 230 * i, 400 + j, 30);
                d.setColor(new Color(162, 162, 168, 255));
                d.fillCircle(120 + 230 * i, 425 + j, 25);
                d.setColor(new Color(184, 178, 178, 255));
                d.fillCircle(150 + 230 * i, 390 + j, 40);
                d.setColor(new Color(161, 158, 170, 255));
                d.fillCircle(176 + 230 * i, 410 + j, 35);
                d.setColor(new Color(184, 178, 186, 255));
                d.fillCircle(150 + 230 * i, 420 + j, 30);
                j = 0;
            }
        }
    }

    @Override
    public void timePassed() {
    }
}
