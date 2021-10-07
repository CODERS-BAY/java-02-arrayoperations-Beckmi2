package exercise.arraysTDD;

import java.util.Arrays;

/**
 * Utility class which performs various operations with integer arrays.
 */
public class ArrayOperations {
	private final int[] numbers; // array that needs to be sorted.
	private final int[] unsorted; // reference array which stays unsorted.

	public ArrayOperations(int[] numbers) {
		this.numbers = numbers;
		this.unsorted = numbers.clone();
	}

	/*
	 * ********************************************************** Please implement
	 * the following methods. * It is intended that they are not static. *
	 ***********************************************************/

	/**
	 * Prints out the numbers array.
	 */

	public void print() {
		String myOutput = "";
		
		System.out.print("[");
		for (int number : numbers) {
			myOutput = myOutput + number + ", "; 
		}
		myOutput = myOutput.substring(0, myOutput.length() - 2);
		System.out.print(myOutput);
		System.out.println("]");
		System.out.println("");
	}

	/**
	 * @return the sorted numbers array.
	 * @see <a
	 *      href="sorting algortihms">http://faculty.cs.niu.edu/~hutchins/csci241/sorting.htm</a>
	 */
	public int[] sort() {
		/*
		moveElementsToRight(numbers, 2);
		*/
		
        for (int i = 0; i < numbers.length; i++) {
            //i ist jene Stelle, dessen Elem evtl. vertauscht wird, fals das Vergleichselement an der Stelle j kleiner ist
            for (int j = i+1; j < numbers.length; j++) {
                changeElements(numbers, i , j);
            }
        }
		return numbers;
	}

	/**
	 * @return the sorted array in reverse order
	 */
	public int[] revertSort() {
		return reverteSortedArray();
	}

	/**
	 * @return the unsorted array in reverted order.
	 */
	public int[] reverted() {
		int[] newUnsorted = new int[unsorted.length];
		int index = 0;
		
		for (int i = unsorted.length - 1; i >= 0; i--) {
			newUnsorted[index] = unsorted[i];
			index++;
		}
		return newUnsorted;
	}

	/**
	 * @param value which should be searched for.
	 * @return true if the array contains the value, false otherwise.
	 */
	public boolean contains(int value) {
		
		for (int number : numbers) {
			if (number == value) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @return the average value of all elements summed up.
	 */
	public double average() {
//		int sum = 0;
//		
//		for (int number : numbers) {
//			sum = sum + number;
//		}
		
		//return (double) sum / numbers.length;
		return (double) sum() / numbers.length;
	}

	/**
	 * @return the average value of all elements summed up, but without the highest
	 *         and the lowest value.
	 */
	public double trimmedMean() {
		return (double) (sum() - maxValue() - minValue()) / (numbers.length - 2) ;
	}

	/**
	 * @return the max value of the array. In the array [1,9,3] max would be 9.
	 */
	public int maxValue() {
		int max = 0;
		
		for (int number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		return max;
	}

	/**
	 * @return the min value of the array. In the array [1,9,3] min would be 1.
	 */
	public int minValue() {
		int min = numbers[0];
		
		for (int number : numbers) {
			if (number < min) {
				min = number;
			}
		}
		
		return min;
	}

	/*
	 * ********************************************************** Feel free to add
	 * as many private helper methods as * you like. *
	 ***********************************************************/

	private int someHelper(int[] tmp) {
		return 1;
	}
	
	private int sum() {
		int sum = 0;
		
		for (int number : numbers) {
			sum = sum + number;
		}
		
		return sum;
	}
	
	/*
	private void moveElementsToRight (int[] myNumbers, int number) {
		int[] newArray = new int[myNumbers.length + 1];
		
		for (int i = 0; i < newArray.length; i++) {
			if (i == 0) {
				newArray[i] = number;
			} else {
				newArray[i] = myNumbers[i - 1];
			}
		}
		System.out.println("vorher" + Arrays.toString(myNumbers));
		System.out.println("nachher" + Arrays.toString(newArray));
	}
	*/
	
	  public static void changeElements (int[] arr, int pos1, int pos2){
	        //int tmp = arr[0];
	        int tmp;
	
	        if (arr[pos2] < arr[pos1]) {
	            tmp = arr[pos1];
	            arr[pos1] = arr[pos2];
	            arr[pos2] = tmp;
	        }
	    }
	  
		/**
		 * @return the sorted array in reverted order.
		 */
		public int[] reverteSortedArray() {
			int[] newReverted = new int[numbers.length];
			int index = 0;
			
			for (int i = numbers.length - 1; i >= 0; i--) {
				newReverted[index] = numbers[i];
				index++;
			}
			return newReverted;
		}
}
