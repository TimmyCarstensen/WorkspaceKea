import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Gui
  implements ActionListener
{
  static Control control = new Control();
  GuiSelectedMovie gsm;
  private JFrame frame;
  private JTextField titleField;
  private JTextField yearField;
  private JTextField searchField;
  private JTextField linkField;
  private JLabel infoString;
  private JLabel searchString;
  private JLabel linkString;
  private JLabel empty1;
  private JLabel empty2;
  private JLabel empty3;
  private JLabel empty4;
  private JComboBox genreList;
  private JComboBox genreList2;
  private JTextArea screen;
  private JTable table;
  private JButton computeButton1;
  private JButton computeButton2;
  private JButton computeButton3;
  private JButton computeButton4;
  private JButton computeButton5;
  private JButton computeButton6;
  private JScrollPane scrollPane;
  private JPanel center;
  private TableRowSorter sorter;
  private URL logoUrl;
  private URL iconUrl;
  private String searchFieldText = "Enter title here";
  private JMenuItem load;
  private JMenuItem save;
  private JMenuItem exit;
  private JMenuItem lend;
  private JMenuItem delivered;
  private JMenuItem changeTitle;
  private JMenuItem changeYear;
  private JMenuItem changeGenre;
  private JMenuItem openIMDb;
  private JMenuItem openSelected;
  private int rowData;

  public Gui()
  {
    control.loadAllMovies();

    this.titleField = new JTextField(10);
    this.yearField = new JTextField(10);
    this.searchField = new JTextField(10);
    this.linkField = new JTextField(10);

    this.searchField.setText(this.searchFieldText);
    this.infoString = new JLabel("Info Screen:");
    this.searchString = new JLabel("Search Movie by name: ");
    this.empty1 = new JLabel("");
    this.empty2 = new JLabel("");
    this.empty3 = new JLabel("");
    this.empty4 = new JLabel("");
    this.titleField.setText("Enter Movie Title");
    this.yearField.setText("Enter Movie Year");
    this.linkField.setText("");
    this.computeButton1 = new JButton("Add Movie");
    this.computeButton2 = new JButton("List all movies");
    this.computeButton3 = new JButton("Search Title");
    this.computeButton4 = new JButton("Delete Movie");
    this.computeButton5 = new JButton("Search Genre");
    this.computeButton6 = new JButton("Show Table");
    this.computeButton4.setBackground(Color.RED);
    this.load = new JMenuItem("Load movies");
    this.save = new JMenuItem("Save as");
    this.exit = new JMenuItem("Exit");
    this.lend = new JMenuItem("Register lend");
    this.changeTitle = new JMenuItem("Change Movie Title");
    this.changeYear = new JMenuItem("Change Movie Year");
    this.changeGenre = new JMenuItem("Change Movie Genre");
    this.openIMDb = new JMenuItem("Search for movie on IMDb");
    this.openSelected = new JMenuItem("Open Selected Movie");
    this.delivered = new JMenuItem("Register delivery");

    this.genreList = new JComboBox(control.loadGenreFromFile());
    this.genreList2 = new JComboBox(control.loadGenreFromFile());
    this.genreList.setBackground(Color.WHITE);
    this.genreList2.setBackground(Color.WHITE);
    Font font = new Font("Palatino", 1, 12);

    this.scrollPane = new JScrollPane(this.screen);

    this.titleField.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        Gui.this.titleField.setText("");
      }
    });
    this.yearField.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        Gui.this.yearField.setText("");
      }
    });
    this.computeButton1.addActionListener(this);
    this.computeButton2.addActionListener(this);
    this.computeButton3.addActionListener(this);
    this.computeButton4.addActionListener(this);
    this.computeButton5.addActionListener(this);
    this.load.addActionListener(this);
    this.save.addActionListener(this);
    this.exit.addActionListener(this);
    this.lend.addActionListener(this);
    this.changeTitle.addActionListener(this);
    this.changeYear.addActionListener(this);
    this.changeGenre.addActionListener(this);
    this.delivered.addActionListener(this);
    this.searchField.addActionListener(this);
    this.genreList2.addActionListener(this);
    this.openIMDb.addActionListener(this);
    this.openSelected.addActionListener(this);

    this.searchField.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e) {
        Gui.this.searchField.setText("");
      }
    });
    JPanel north = new JPanel(new GridLayout(5, 2, 50, 10));
    JPanel south = new JPanel(new GridLayout(6, 2, 50, 10));
    this.center = new JPanel(new GridLayout(1, 2));

    DefaultTableModel model = new DefaultTableModel();
    this.sorter = new TableRowSorter(model);

    this.table = new JTable();

    this.table.setAutoCreateRowSorter(true);
    updateJTable();

    this.center.add(new JScrollPane(this.table));

    north.add(this.empty1);
    north.add(this.empty2);
    north.add(this.searchField);
    north.add(this.computeButton3);
    north.add(this.genreList2);
    north.add(this.computeButton5);
    north.add(this.empty3);
    north.add(this.computeButton2);

    south.add(new JLabel(""));
    south.add(new JLabel("Add movie to database:"));
    south.add(new JLabel(""));
    south.add(this.titleField);
    south.add(new JLabel(""));
    south.add(this.yearField);
    south.add(new JLabel(""));
    south.add(this.genreList);
    south.add(this.computeButton4);
    south.add(this.computeButton1);
    south.add(new JLabel(""));
    south.add(new JLabel(""));

    this.frame = new JFrame("Movie Database");
    this.frame.setDefaultCloseOperation(3);
    Point p = new Point(750, 100);

    this.frame.setLocation(p);
    this.frame.setLayout(new BorderLayout());
    this.frame.add(north, "North");
    this.frame.add(south, "South");
    this.frame.add(this.center, "Center");
    this.frame.setJMenuBar(createMenuBar());

    this.frame.pack();
    this.frame.setSize(550, 800);

    this.frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event)
  {
    if (event.getSource() == this.computeButton1)
    {
      addMovie();
    }
    else if (event.getSource() == this.computeButton2)
    {
      updateJTable();
    }
    else if (event.getSource() == this.searchField)
    {
      titleSearch();
    }
    else if (event.getSource() == this.computeButton3)
    {
      titleSearch();
    }
    else if (event.getSource() == this.computeButton4)
    {
      deleteMovie();
    }
    else if (event.getSource() == this.computeButton5)
    {
      genreSearch();
    }
    else if (event.getSource() != this.computeButton6)
    {
      if (event.getSource() == this.load)
      {
        JOptionPane.showMessageDialog(null, "Load function under construction");
      }
      else if (event.getSource() == this.save)
      {
        JOptionPane.showMessageDialog(null, "Save function under construction");
      }
      else if (event.getSource() == this.lend)
      {
        lendMovie();
      }
      else if (event.getSource() == this.delivered)
      {
        deliverMovie();
      }
      else if (event.getSource() == this.changeTitle)
      {
        changeTitle();
      }
      else if (event.getSource() == this.changeYear)
      {
        changeYear();
      }
      else if (event.getSource() == this.changeGenre)
      {
        changeGenre();
      }
      else if (event.getSource() != this.openIMDb)
      {
        if (event.getSource() == this.openSelected)
        {
          openSelectedMovie();
        }
        else if (event.getSource() == this.exit)
        {
          System.exit(1);
        }
      }
    }
  }

  public void updateJTable()
  {
    control.loadAllMovies();

    DefaultTableModel model = new DefaultTableModel();

    model.setColumnIdentifiers(new String[] { "Title", "Year", "Genre", "Lent to" });
    model.setRowCount(control.getMovies().size());

    int row = 0;
    for (Movie m : control.getMovies()) {
      model.setValueAt(m.getTitle(), row, 0);
      model.setValueAt(m.getYear(), row, 1);
      model.setValueAt(m.getGenre(), row, 2);
      model.setValueAt(m.getLent(), row, 3);
      row++;
    }

    this.table.setModel(model);
  }

  public void updateByGenre()
  {
    DefaultTableModel model = new DefaultTableModel();

    model.setColumnIdentifiers(new String[] { "Title", "Year", "Genre", "Lent to" });
    model.setRowCount(control.genreList.size());
    int row = 0;
    for (Movie m : control.genreList) {
      model.setValueAt(m.getTitle(), row, 0);
      model.setValueAt(m.getYear(), row, 1);
      model.setValueAt(m.getGenre(), row, 2);
      model.setValueAt(m.getLent(), row, 3);
      row++;
    }
    this.table.setModel(model);
  }

  public void updateByTitle()
  {
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new String[] { "Title", "Year", "Genre", "Lent to" });
    model.setRowCount(control.searchList.size());
    int row = 0;
    for (Movie m : control.searchList) {
      model.setValueAt(m.getTitle(), row, 0);
      model.setValueAt(m.getYear(), row, 1);
      model.setValueAt(m.getGenre(), row, 2);
      model.setValueAt(m.getLent(), row, 3);
      row++;
    }
    this.table.setModel(model);
  }

  public void titleSearch()
  {
    if ((this.searchField.getText().equalsIgnoreCase("")) || (this.searchField.getText().equalsIgnoreCase(this.searchFieldText)))
    {
      JOptionPane.showMessageDialog(null, "You need to search for atleast 1 letter");
    }
    else
    {
      control.searchMovie(this.searchField.getText());
      if (control.searchList.size() > 0)
      {
        updateByTitle();
      }
      else
      {
        JOptionPane.showMessageDialog(null, this.searchField.getText() + " didn't match any of your Movies");
      }
    }
  }

  public void genreSearch()
  {
    Object genreObj = this.genreList2.getSelectedItem();
    String genreString = genreObj.toString();
    control.moviesByGenre(genreString);
    if (control.genreList.size() > 0)
    {
      updateByGenre();
    }
    else
    {
      JOptionPane.showMessageDialog(null, "No movies with this genre");
    }
  }

  public void addMovie()
  {
    Object genreObj = this.genreList.getSelectedItem();
    String genreString = genreObj.toString();

    if ((this.titleField.getText().equals("Enter Movie Title")) || 
      (this.titleField.getText().equals("")) || 
      (this.yearField.getText().equals("Enter Movie Year")) || 
      (this.yearField.getText().equals("")))
    {
      JOptionPane.showMessageDialog(null, "Enter both title and year.");
    }
    else
    {
      try {
        control.addMovie(this.titleField.getText(), this.yearField.getText(), genreString, this.linkField.getText());
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      updateJTable();
      JOptionPane.showMessageDialog(null, this.titleField.getText() + " added to database.");
      this.titleField.setText("Enter Movie Title");
      this.yearField.setText("Enter Movie Year");
    }
  }

  public void lendMovie()
  {
    try
    {
      try {
        this.rowData = this.table.getSelectedRow();

        Object titleObj = this.table.getValueAt(this.rowData, 0);
        String titleString = titleObj.toString();

        String input = JOptionPane.showInputDialog("Who do you want to lend " + titleString + " to?");

        if (!input.equals(null))
        {
          this.table.setValueAt(input, this.rowData, 3);
          try
          {
            Object lentObj = this.table.getValueAt(this.rowData, 3);
            String lentString = lentObj.toString();
            control.saveTheLentList(titleString, lentString);
          }
          catch (FileNotFoundException e)
          {
            e.printStackTrace();
          }

          JOptionPane.showMessageDialog(null, titleString + " is now lent to " + input);
        }
      } catch (NullPointerException localNullPointerException) {
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Select a movie first");
    }
  }

  public void changeTitle()
  {
    try
    {
      this.rowData = this.table.getSelectedRow();

      Object titleObj = this.table.getValueAt(this.rowData, 0);
      String titleString = titleObj.toString();

      String oldName = titleString;

      String input = JOptionPane.showInputDialog("Change " + titleString + "'s name to:");

      this.table.setValueAt(input, this.rowData, 0);
      try
      {
        control.saveTheTitleList(input, oldName);
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      JOptionPane.showMessageDialog(null, titleString + "'s name is now changed to " + input);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Select a movie first");
    }
  }

  public void changeYear()
  {
    try {
      this.rowData = this.table.getSelectedRow();

      Object titleObj = this.table.getValueAt(this.rowData, 0);
      String titleString = titleObj.toString();

      String input = JOptionPane.showInputDialog("Change " + titleString + "'s year to:");

      this.table.setValueAt(input, this.rowData, 1);
      try
      {
        control.saveTheYearList(titleString, input);
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      JOptionPane.showMessageDialog(null, titleString + "'s year is now changed to " + input);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Select a movie first");
    }
  }

  public void changeGenre()
  {
    try
    {
      this.rowData = this.table.getSelectedRow();

      Object titleObj = this.table.getValueAt(this.rowData, 0);
      String titleString = titleObj.toString();

      Object input = JOptionPane.showInputDialog(null, "Select a new genre", "Change genre", 1, null, control.loadGenreFromFile(), "Valg2");
      String inputString = input.toString();

      this.table.setValueAt(input, this.rowData, 2);
      try
      {
        control.saveTheGenreList(titleString, inputString);
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      JOptionPane.showMessageDialog(null, titleString + "'s genre is now changed to " + input);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Select a movie first");
    }
  }

  public void openInIMDb()
  {
    try {
      this.rowData = this.table.getSelectedRow();

      Object titleObj = this.table.getValueAt(this.rowData, 0);
      String titleString = titleObj.toString();

      control.openInIMDb(titleString);

      control.clearLinks();
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Select a movie first");
    }
  }

  public void openSelectedMovie()
  {
    try
    {
      String selectedTitle = "";
      String selectedYear = "";
      String selectedGenre = "";
      String selectedLent = "";
      String selectedStars = "";
      String selectedReview = "";

      this.rowData = this.table.getSelectedRow();

      Object titleObj = this.table.getValueAt(this.rowData, 0);
      String titleString = titleObj.toString();

      for (Movie m : control.getMovies())
      {
        if (!titleString.equalsIgnoreCase(m.getTitle()))
          continue;
        selectedTitle = m.getTitle();
        selectedYear = m.getYear();
        selectedGenre = m.getGenre();
        selectedLent = m.getLent();
        selectedStars = m.getStars();
        selectedReview = m.getReview();
      }

      this.gsm = new GuiSelectedMovie(selectedTitle, selectedYear, selectedGenre, selectedLent, selectedStars, selectedReview);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Select a movie first");
    }
  }

  public void deliverMovie()
  {
    try
    {
      this.rowData = this.table.getSelectedRow();

      Object titleObj = this.table.getValueAt(this.rowData, 0);
      String titleString = titleObj.toString();

      this.table.setValueAt("", this.rowData, 3);
      try
      {
        Object lentObj = this.table.getValueAt(this.rowData, 3);
        String lentString = lentObj.toString();
        control.saveTheLentList(titleString, lentString);
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      JOptionPane.showMessageDialog(null, titleString + " is now registered as delivered");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Select a movie first");
    }
  }

  public void deleteMovie()
  {
    try
    {
      this.rowData = this.table.getSelectedRow();

      Object titleObj = this.table.getValueAt(this.rowData, 0);
      String titleString = titleObj.toString();

      int confirmDelete = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + titleString + "?");

      if (confirmDelete == 0)
      {
        try {
          control.deleteMovie(titleString);
          control.temp();
        }
        catch (FileNotFoundException e) {
          JOptionPane.showMessageDialog(null, "File could not be found");
        }

        updateJTable();
      }

    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "Select movie first");
    }
  }

  public JMenuBar createMenuBar()
  {
    JMenuBar menuBar = new JMenuBar();

    JMenu starter = new JMenu("File");
    JMenu options = new JMenu("Lend to Friend");
    JMenu movie = new JMenu("Movie Options");

    menuBar.add(starter);
    menuBar.add(options);
    menuBar.add(movie);

    starter.add(this.load);
    starter.add(this.save);
    starter.add(this.exit);

    options.add(this.lend);
    options.add(this.delivered);

    movie.add(this.changeTitle);
    movie.add(this.changeYear);
    movie.add(this.changeGenre);
    movie.add(this.openIMDb);
    movie.add(this.openSelected);

    return menuBar;
  }
}