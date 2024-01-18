package otb.mio.anistorage.form;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Jinfo extends JFrame
{
    final int W_WIDTH = 1400;
    final int W_HEIGHT = 1300;
    JLabel lbl_test = new JLabel("Test");
    JPanel pan = new JPanel();
    ArrayList<JLabel> image_labels = new ArrayList<JLabel>();
    final int IMG_WIDTH = 200;
    final int IMG_HEIGHT = 280;

    public Jinfo()
    {
        super("Test App");
        this.setBounds(100, 100, W_WIDTH, W_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pan.setLayout(null);
        this.lbl_test.setSize(30,30);
        this.lbl_test.setLocation(10, 20);
        //this.pan.add(this.lbl_test);
        setImageLbl(this.lbl_test);

        this.setContentPane(this.pan);
        generateLabels();

    }

    public void testFetches()
    {
        image_labels.getFirst().setVisible(false);
    }
    public void generateLabels()
    {
        int loc_x;
        int loc_y = 50;
        int lbl_count = 0;

        for(int i=0; i < 4; i++)
        {
            loc_x = 50;
            for(int ii=0; ii < 6; ii++)
            {
                image_labels.add(new JLabel());
                setImageLbl(image_labels.get(lbl_count));

                image_labels.get(lbl_count).setLocation(loc_x, loc_y);

                loc_x += IMG_WIDTH + 20;

                pan.add(image_labels.get(lbl_count));

                lbl_count += 1;
            }

            loc_y += IMG_HEIGHT + 20;
        }
    }

    public void setImageLbl(JLabel jlabel)
    {
        try{
            File file = new File("data/test.jpg");
            BufferedImage bImage = ImageIO.read(file);

            Image newResizedImage = bImage.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH);
            ImageIcon newResImg = new ImageIcon(newResizedImage);

            jlabel.setSize(IMG_WIDTH,IMG_HEIGHT);
            jlabel.setIcon(newResImg);
        } catch (IOException ex){
            System.out.println("File Not Found!");
        }
    }
}

