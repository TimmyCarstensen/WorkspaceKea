import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiSelectedMovie extends JFrame
  implements ActionListener
{
  Control c = new Control();
  private JPanel panel;
  private JLabel label;
  private String title;
  private String year;
  private String genre;
  private String lent;
  private String stars;
  private String review;
  private JLabel titleLabel;
  private JLabel ratingLabel;
  private JLabel imageLabel;
  private JLabel lentLabel;
  private JLabel genreLabel;
  private JLabel yearLabel;
  private JLabel reviewLabel;
  private JTextArea reviewArea;
  private JButton rateButton;
  private JButton lendButton;
  private JButton deliverButton;
  private JButton saveReviewButton;
  private URL url;
  private Image image;

  public GuiSelectedMovie(String title, String year, String genre, String lent, String stars, String review)
  {
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.lent = lent;
    this.stars = stars;
    this.review = review;

    this.c.loadAllMovies();

    setSize(700, 700);
    setTitle(title);

    setLayout(null);
    setVisible(true);

    Point p = new Point(350, 200);
    setLocation(p);

    this.reviewArea = new JTextArea(review);

    this.rateButton = new JButton("Rate Movie");
    this.lendButton = new JButton("Register lend");
    this.deliverButton = new JButton("Register Delivery");
    this.saveReviewButton = new JButton("Save Review");

    this.genreLabel = new JLabel(genre);
    this.genreLabel.setFont(new Font("Dialog", 1, 14));

    this.yearLabel = new JLabel(year);
    this.yearLabel.setFont(new Font("Dialog", 1, 14));

    this.reviewLabel = new JLabel("User Review:");
    this.reviewLabel.setFont(new Font("Dialog", 1, 14));

    this.lentLabel = new JLabel("");
    this.lentLabel.setFont(new Font("Dialog", 1, 14));
    this.lentLabel.setSize(600, 600);

    if (lent.equalsIgnoreCase(""))
    {
      this.lentLabel.setText("Movie is home");
    }
    else
    {
      this.lentLabel.setText("Movie is lent to " + lent);
    }

    this.titleLabel = new JLabel(title);
    this.titleLabel.setFont(new Font("Dialog", 1, 45));
    this.titleLabel.setSize(600, 600);
    try
    {
      this.url = new URL("http://i172.photobucket.com/albums/w34/cleverly89/none.jpg");
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    }
    try
    {
      this.image = ImageIO.read(this.url);
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    if (!lent.equalsIgnoreCase(""))
    {
      this.titleLabel.setForeground(Color.RED);
      this.titleLabel.setText(title);
    }
    else
    {
      this.titleLabel.setText(title);
    }

    this.ratingLabel = new JLabel(getRating());
    this.ratingLabel.setFont(new Font("Dialog", 1, 14));
    this.ratingLabel.setSize(600, 600);

    this.imageLabel = new JLabel(new ImageIcon(this.image));

    add(this.titleLabel);
    add(this.ratingLabel);

    add(this.rateButton);
    add(this.lendButton);
    add(this.deliverButton);
    add(this.imageLabel);
    add(this.lentLabel);
    add(this.genreLabel);
    add(this.yearLabel);
    add(this.reviewLabel);
    add(this.reviewArea);
    add(this.saveReviewButton);

    Insets insets = getInsets();

    Dimension size = this.rateButton.getPreferredSize();
    this.rateButton.setBounds(25 + insets.left, 290 + insets.top, 
      size.width, size.height);

    size = this.titleLabel.getPreferredSize();
    this.titleLabel.setBounds(25 + insets.left, 10 + insets.top, 
      size.width, size.height);

    size = this.yearLabel.getPreferredSize();
    this.yearLabel.setBounds(25 + insets.left, 110 + insets.top, 
      size.width, size.height);

    size = this.genreLabel.getPreferredSize();
    this.genreLabel.setBounds(25 + insets.left, 140 + insets.top, 
      size.width, size.height);

    size = this.ratingLabel.getPreferredSize();
    this.ratingLabel.setBounds(25 + insets.left, 170 + insets.top, 
      size.width, size.height);

    size = this.lentLabel.getPreferredSize();
    this.lentLabel.setBounds(25 + insets.left, 200 + insets.top, 
      size.width, size.height);

    size = this.imageLabel.getPreferredSize();
    this.imageLabel.setBounds(435 + insets.left, 80 + insets.top, 
      size.width, size.height);

    size = this.lendButton.getPreferredSize();
    this.lendButton.setBounds(140 + insets.left, 290 + insets.top, 
      size.width, size.height);

    size = this.deliverButton.getPreferredSize();
    this.deliverButton.setBounds(270 + insets.left, 290 + insets.top, 
      size.width, size.height);

    size = this.reviewLabel.getPreferredSize();
    this.reviewLabel.setBounds(25 + insets.left, 330 + insets.top, 
      size.width, size.height);

    size = this.reviewArea.getPreferredSize();
    this.reviewArea.setBounds(25 + insets.left, 350 + insets.top, 
      size.width, size.height);

    size = this.saveReviewButton.getPreferredSize();
    this.saveReviewButton.setBounds(25 + insets.left, 560 + insets.top, 
      size.width, size.height);

    this.rateButton.addActionListener(this);
    this.lendButton.addActionListener(this);
    this.deliverButton.addActionListener(this);
    this.saveReviewButton.addActionListener(this);

    this.reviewArea.setSize(600, 200);
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == this.rateButton)
    {
      this.ratingLabel.setText(addStars());
    }
    else if (e.getSource() == this.lendButton)
    {
      lendMovie();
    }
    else if (e.getSource() == this.deliverButton)
    {
      deliverMovie();
    }
    else if (e.getSource() == this.saveReviewButton)
    {
      saveReview();
    }
  }

  public String addStars()
  {
    String rating = "";
    String input = JOptionPane.showInputDialog("How many stars? (1-10)");
    try {
      rating = this.c.saveTheStarList(this.title, input);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    return rating;
  }

  public String getRating()
  {
    String rating = "";

    for (Movie m : this.c.getMovies())
    {
      if (!m.getTitle().equalsIgnoreCase(this.title))
        continue;
      if (m.getStars().equalsIgnoreCase(""))
      {
        rating = "No user-rating for this movie yet";
      }
      else
      {
        rating = m.getStars() + " Star rating by user";
      }

    }

    return rating;
  }

  public void lendMovie()
  {
    try {
      String input = JOptionPane.showInputDialog("Who do you want to lend " + this.title + " to?");
      try
      {
        if (input.equals(null))
        {
          JOptionPane.showMessageDialog(null, "");
        }
        else {
          this.titleLabel.setForeground(Color.RED);
          this.titleLabel.setText(this.title);
          this.lentLabel.setText("Movie is lent to " + input);
          this.lentLabel.setSize(600, 20);
          JOptionPane.showMessageDialog(null, this.title + " is now registered as lent to " + input);
          this.c.saveTheLentList(this.title, input);
        }

      }
      catch (FileNotFoundException e)
      {
        e.printStackTrace();
      }
    }
    catch (NullPointerException localNullPointerException)
    {
    }
  }

  public void deliverMovie()
  {
    try
    {
      this.titleLabel.setForeground(Color.BLACK);
      this.titleLabel.setText(this.title);
      this.lentLabel.setText("Movie is home");
      JOptionPane.showMessageDialog(null, this.title + " is now registered as delivered");
      this.c.saveTheLentList(this.title, "");
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void saveReview()
  {
    try
    {
      String newReview = this.reviewArea.getText();
      JOptionPane.showMessageDialog(null, "Review for " + this.title + " saved.");
      this.c.saveTheReviewList(this.title, newReview);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}