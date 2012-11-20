public class Movie
{
  private String title;
  private String year;
  private String stars;
  private String review;
  private String genre;
  private String lent;
  private String actor1;
  private String actor2;
  private String actor3;

  public Movie(String title, String year)
  {
    this.title = title;
    this.year = year;
  }

  public Movie(String title, String year, String genre)
  {
    this.title = title;
    this.year = year;
    this.genre = genre;
  }

  public Movie(String title, String year, String genre, String lent)
  {
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.lent = lent;
  }

  public Movie(String title, String year, String genre, String lent, String stars, String review) {
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.lent = lent;
    this.stars = stars;
    this.review = review;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getYear()
  {
    return this.year;
  }

  public void setYear(String year)
  {
    this.year = year;
  }

  public String getGenre()
  {
    return this.genre;
  }

  public void setGenre(String genre)
  {
    this.genre = genre;
  }

  public String getLent()
  {
    return this.lent;
  }

  public void setLent(String lent)
  {
    this.lent = lent;
  }

  public String getStars()
  {
    return this.stars;
  }

  public void setStars(String stars)
  {
    this.stars = stars;
  }

  public String getReview()
  {
    return this.review;
  }

  public void setReview(String review)
  {
    this.review = review;
  }
}