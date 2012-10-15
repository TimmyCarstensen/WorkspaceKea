


/**
 * 
 */
public class Photograph
{
    private String[] photograph;
    
    /**
     * Create a photograph.
     */
    public Photograph(String[] photograph)
    {
        if (photograph == null){
            photograph = new String[] { };
        } 
        this.photograph = photograph;
    }
        
    /**
     * Change a persons photo.
     * @param a new photograph.
     */
    public void changePhotograph(String[] photograph)
    {
        this.photograph = photograph;
    }
    
    /**
     * @return width of photo.
     */
    public int getWidth()
    {
        if (this.photograph == null){
            return 0;
        } else{
            return this.photograph[0].length();
        }
    }
    
    /**
     * 
     */
    public int getHeight()
    {
        if (this.photograph == null){
            return 0;
        } else{
            return this.photograph.length;
        }
    }
    
    /** 
     * Get the specified row of the picture. Indexed from 0.
     * @null if the index is out of bounds.
     */
    public String getRow(int index)
    {
        if (index < 0 || index >= this.photograph.length){
            return null;
        }
        return this.photograph[index];
    }
}
