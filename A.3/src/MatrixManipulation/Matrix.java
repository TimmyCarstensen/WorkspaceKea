package MatrixManipulation;

/**
 * 
 */
public class Matrix
{
    private int[][] matrix;
    
    
    /**
     * CONTRUCTOR F�RDIG, MANGLER KOMMENTARER
     */
    public Matrix(int xydim)
    {
        matrix = new int[xydim][xydim];     
        
    }
    
    /**
     * CREATE F�RDIG, MANGLER KOMMENTARER
     * @param diagonalValue
     */
    public void diagonalCreate(int diagonalValue)
    {
    	int value = 0;
    	while(value < matrix.length){
    		matrix[value][value] = diagonalValue;
    		value++;
    	}
    }
    
    /**
     * manualCREATE IKKE F�RDIG, MANGLER KOMMENTARER
     */
    public void manualCreate()
    {
    	
    }
    /**
     * TRANSPOSE F�RDIG, MANGLER KOMMENTARER!!!
     */
    public void transpose()
    {
    	int[][] matrix2 = new int[matrix.length][matrix.length];
    	for(int j = 0; j < matrix2.length; j++){
    		for(int k = 0; k < matrix2.length; k++){
    			matrix2[j][k] = matrix[k][j];
    		}
    	}
    	matrix = matrix2;
    }
    
    /**
     * DOTPRODUCT IKKE F�RDIG, MANGLER KOMMENTARER!!!
     */
    public void dotProduct()
    {
    	
    }
        
    /**
     * PRINTMATRIX F�RDIG, MANGLER KOMMENTARER!!!
     */
    public void printMatrix()
    {
    	int value1 = 0;
    	int value2 = 0;
    	while(value1 < matrix.length){
    		while(value2 < matrix.length){
    			System.out.print(matrix[value1][value2]+" ");
    			value2++;
    		}
    		System.out.println();
    		value2 = 0;
    		value1++;
    	}
    }
    
    
}