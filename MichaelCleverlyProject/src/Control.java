import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Control
{
  private Scanner input;
  private Scanner input2;
  private File movieFile = new File("movies.txt");
  private File linkTextFile = new File("links.txt");
  private File linkHtmlFile = new File("links.html");
  private String URLname = "IMDb link";
  private URL url;
  private Desktop desktop;
  ArrayList<Movie> genreList;
  ArrayList<Movie> searchList;
  private ArrayList<Movie> movies = new ArrayList();

  private ArrayList<String> moviesInFile = new ArrayList();

  public void loadMovies()
  {
    int numberOfColumns = 4;
    int numberOfRows = this.movies.size();

    Object[][] rows = new Object[numberOfRows][];
    for (int i = 0; i < numberOfRows; i++)
    {
      rows[i] = new Object[4];

      rows[i][0] = ((Movie)this.movies.get(i)).getTitle();
      rows[i][1] = ((Movie)this.movies.get(i)).getYear();
      rows[i][2] = ((Movie)this.movies.get(i)).getGenre();
      rows[i][3] = ((Movie)this.movies.get(i)).getLent();
    }
  }

  public String[] loadGenreFromFile()
  {
    String[] genres = new String[11];

    genres[0] = "Comedy";
    genres[1] = "Action";
    genres[2] = "Romance";
    genres[3] = "Horror";
    genres[4] = "Documentary";
    genres[5] = "Fantasy";
    genres[6] = "Thriller";
    genres[7] = "Sci-Fi";
    genres[8] = "Drama";
    genres[9] = "Cartoon";
    genres[10] = "Adventure";

    return genres;
  }

  public ArrayList<Movie> getMovies()
  {
    return this.movies;
  }

  public void addMovie(String title, String year, String genre, String lent)
    throws FileNotFoundException
  {
    try
    {
      FileOutputStream fos = new FileOutputStream(this.movieFile, true);
      PrintStream output = new PrintStream(fos);

      output.print(title + ";" + year + ";" + genre + ";" + lent + ";;;");

      output.close();

      Movie moviesO = new Movie(title, year, genre, lent);
      this.movies.add(moviesO);
    }
    catch (IOException localIOException)
    {
    }
  }

  public void searchMovie(String title)
  {
    this.searchList = new ArrayList();
    for (Movie m : this.movies)
    {
      boolean ending = m.getTitle().toLowerCase().endsWith(title.toLowerCase());
      boolean start = m.getTitle().toLowerCase().startsWith(title.toLowerCase());

      if (m.getTitle().equalsIgnoreCase(title))
      {
        this.searchList.add(m);
      }
      else if (ending)
      {
        this.searchList.add(m);
      } else {
        if (!start)
          continue;
        this.searchList.add(m);
      }
    }
  }

  public String listAllMovies()
  {
    String allMovies = "All movies in database:\n\n";

    for (Movie m : this.movies)
    {
      allMovies = allMovies + m.getTitle() + " - " + m.getYear() + " - " + m.getGenre() + " - " + m.getLent() + "\n";
    }

    return allMovies;
  }

  public String listAllMoviesInFile2()
  {
    String allMovies = "All movies in database:\n\n";

    for (String m : this.moviesInFile)
    {
      allMovies = allMovies + m + "\n";
    }

    return allMovies;
  }

  public void saveTheLentList(String title, String lent) throws FileNotFoundException
  {
    PrintStream output = new PrintStream(this.movieFile);

    for (Movie m : this.movies)
    {
      if (title.equalsIgnoreCase(m.getTitle()))
      {
        if (!lent.equalsIgnoreCase(m.getLent()))
        {
          m.setLent(lent);
        }

      }

      output.print(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" + m.getLent() + ";" + m.getStars() + ";" + m.getReview() + ";");
    }

    output.close();
  }

  public String saveTheStarList(String title, String stars)
    throws FileNotFoundException
  {
    String rating = "";
    PrintStream output = new PrintStream(this.movieFile);

    for (Movie m : this.movies)
    {
      if (title.equalsIgnoreCase(m.getTitle()))
      {
        m.setStars(stars);
        rating = m.getStars() + " Star rating by user";
      }

      output.print(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" + m.getLent() + ";" + m.getStars() + ";" + m.getReview() + ";");
    }
    output.close();
    return rating;
  }

  public void saveTheTitleList(String title, String oldName)
    throws FileNotFoundException
  {
    PrintStream output = new PrintStream(this.movieFile);

    for (Movie m : this.movies)
    {
      if (oldName.equalsIgnoreCase(m.getTitle()))
      {
        m.setTitle(title);
      }

      output.print(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" + m.getLent() + ";" + m.getStars() + ";" + m.getReview() + ";");
    }
    output.close();
  }

  public void saveTheYearList(String title, String year) throws FileNotFoundException
  {
    PrintStream output = new PrintStream(this.movieFile);

    for (Movie m : this.movies)
    {
      if (title.equalsIgnoreCase(m.getTitle()))
      {
        m.setYear(year);
      }

      output.print(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" + m.getLent() + ";" + m.getStars() + ";" + m.getReview() + ";");
    }
    output.close();
  }

  public void saveTheReviewList(String title, String review)
    throws FileNotFoundException
  {
    PrintStream output = new PrintStream(this.movieFile);

    for (Movie m : this.movies)
    {
      if (title.equalsIgnoreCase(m.getTitle()))
      {
        m.setReview(review);
      }

      output.print(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" + m.getLent() + ";" + m.getStars() + ";" + m.getReview() + ";");
    }
    output.close();
  }

  public void saveTheGenreList(String title, String genre)
    throws FileNotFoundException
  {
    PrintStream output = new PrintStream(this.movieFile);

    for (Movie m : this.movies)
    {
      if (title.equalsIgnoreCase(m.getTitle()))
      {
        m.setGenre(genre);
      }

      output.print(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" + m.getLent() + ";" + m.getStars() + ";" + m.getReview() + ";");
    }
    output.close();
  }

  public void openInIMDb(String title)
    throws FileNotFoundException
  {
    this.desktop = null;
    PrintStream outputText = new PrintStream(this.linkTextFile);

    FileOutputStream fos = new FileOutputStream(this.linkHtmlFile, true);
    PrintStream outputHtml = new PrintStream(fos);

    outputText.print(title);
    try
    {
      this.input = new Scanner(this.linkTextFile);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    outputHtml.print("http://www.imdb.com/find?q=");

    while (this.input.hasNext())
    {
      outputHtml.print(this.input.next() + "+");
    }

    outputHtml.print("&s=all");

    this.input.close();
    outputText.close();
    outputHtml.close();
    try
    {
      this.desktop.open(this.linkHtmlFile);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void clearLinks()
    throws FileNotFoundException
  {
    PrintStream outputText = new PrintStream(this.linkTextFile);
    PrintStream outputHtml = new PrintStream(this.linkHtmlFile);

    outputText.print("");
    outputHtml.print("");

    outputText.close();
    outputHtml.close();
  }

  public void deleteMovie(String title)
    throws FileNotFoundException
  {
    for (Movie m : this.movies)
    {
      if (!title.equalsIgnoreCase(m.getTitle()))
        continue;
      this.movies.remove(m);
      return;
    }
  }

  public void temp()
    throws IOException
  {
    PrintStream output = new PrintStream(this.movieFile);

    for (Movie m : this.movies)
    {
      output.print(m.getTitle() + ";" + m.getYear() + ";" + m.getGenre() + ";" + m.getLent() + ";" + m.getStars() + ";" + m.getReview() + ";");
    }
  }

  public void loadAllMovies()
  {
    try
    {
      this.input = new Scanner(this.movieFile);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    this.movies.clear();

    while (this.input.hasNext())
    {
      this.input.useDelimiter(";");
      String title = this.input.next();
      String year = this.input.next();
      String genre = this.input.next();
      String lent = this.input.next();
      String stars = this.input.next();
      String review = this.input.next();

      Movie moviesO = new Movie(title, year, genre, lent, stars, review);
      this.movies.add(moviesO);
    }

    this.input.close();
  }

  public void moviesByGenre(String genre)
  {
    String moviesByGenre = "All movies by the genre of " + genre + "\n\n";
    this.genreList = new ArrayList();
    for (Movie m : this.movies)
    {
      if (!m.getGenre().equals(genre))
        continue;
      this.genreList.add(m);
    }

    for (Movie g : this.genreList)
    {
      moviesByGenre = moviesByGenre + g.getTitle() + " - " + g.getYear() + " - " + g.getGenre() + "\n";
    }
  }

  public static void main(String[] args)
  {
    Gui newGUI = new Gui();
  }
}