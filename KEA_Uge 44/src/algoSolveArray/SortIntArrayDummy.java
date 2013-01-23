package algoSolveArray;

import java.util.Arrays;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class SortIntArrayDummy {

	public static void main(String[] args) 
	{
		int[] list = {2, 12, 1, 4, 7, 5, 3, 6, 9, 10, 8, 11};
		
		SortIntArrayDummy s = new SortIntArrayDummy();
	
		s.sortIntArray(list);
		
		// Sorting is done by library functions
//		int[] list2 = {2,45,1,2,51,2,31,24};
//		Arrays.sort(list2);
//		for(int e : list2)
//		{
//			System.out.print(e + " ");
//		}
	}
		
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int[] sortIntArray(int[] list)
	{

		int[] resultList = new int[list.length];
		int resultIndex = 0;
		for(int resultValue : list)
		{
			int tempIndex = 0;
			int i = 0;	
			for(int itemB : list)
			{
				if(resultValue >= itemB)
				{
					resultValue = itemB;
					tempIndex = i;
				}
				i++;
			}
			list[tempIndex] = maxValueFromIntArray(list);
			resultList[resultIndex] = resultValue;
			resultIndex++;
		}
		
		int i = 0;
		for(int item: resultList)
		{
			System.out.println("Plads " + i + " står item: " + item);
			i++;
		}
		return resultList;
	}

	/**
	 * 
	 * @param liste
	 * @return
	 */
	public int maxValueFromIntArray(int[] liste)
	{
		int temp = 0;
		for(int a : liste)
		{
			if(a > temp)
				temp = a;
		}
		return temp;
	}
}
