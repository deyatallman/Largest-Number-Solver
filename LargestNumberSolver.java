package assign04;

import java.math.BigInteger;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargestNumberSolver {
	
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		
		for(int i = 1; i<arr.length;i++){
			T key = arr[i];
			int j = i-1;
			
			while (j >= 0 && cmp.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
		}
	}
	
	public static BigInteger findLargestNumber(Integer[] arr) {
		insertionSort(arr, (A,B)-> {
			String AB = A.toString()+B.toString();
			String BA = B.toString() + A.toString();
			return BA.compareTo(AB);		
		});
		StringBuilder bigNumber = new StringBuilder();
		for(Integer num : arr) {
			bigNumber.append(num);
		}
		
		return new BigInteger(bigNumber.toString());
		
	}

	public static int findLargestInt(Integer[] arr) throws OutOfRangeException{
		BigInteger bigNumber = findLargestNumber(arr);
		String largest =  "2147483647";
		if (bigNumber.compareTo(new BigInteger(largest.toString())) > 0) {
            throw new OutOfRangeException("Result exceeds the range.");
        }
		return (int)bigNumber.longValue();		
	}

	public static long findLargestLong(Integer[] arr) throws OutOfRangeException{
		BigInteger bigNumber = findLargestNumber(arr);
		String largest =  "2147483647";
		if (bigNumber.compareTo(new BigInteger(largest.toString())) > 0) {
            throw new OutOfRangeException("Result exceeds the range of long data type");
        }
		return bigNumber.longValue();
		
	}
	
	public static BigInteger sum(List<Integer[]> list) {
	    BigInteger totalSum = BigInteger.ZERO;

	    for (Integer[] array : list) {
	        int largestInt = findLargestInt(array); 
	        totalSum = totalSum.add(BigInteger.valueOf(largestInt)); 
	    }

	    return totalSum;
	}
	
	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
	    if (k < 0 || k >= list.size()) {
	        throw new IllegalArgumentException("k is out of range.");
	    }

	    Comparator<Integer[]> largestNumberComparator = (array1, array2) -> {
	        BigInteger number1 = findLargestNumber(array1);
	        BigInteger number2 = findLargestNumber(array2);
	        return number2.compareTo(number1);
	    };

	    list.sort(largestNumberComparator);	    
	    return list.get(k);
	}

	
	 public static List<Integer[]> readFile(String filename) {
	        File theFile;
	        try {
	            theFile = new File(filename);
	            Scanner scanFile = new Scanner(theFile);
	            List<Integer[]> returnValue = new ArrayList<>();
	            while (scanFile.hasNextLine()) {
	                String[] line = scanFile.nextLine().split(" ");
	                Integer[] integerLine = new Integer[line.length];
	                for (int i = 0; i < line.length; i++) {
	                    integerLine[i] = Integer.parseInt(line[i]);
	                }
	                returnValue.add(integerLine);
	            }
	            scanFile.close();
	            return returnValue;
	        } catch (Exception e) {
	            return new ArrayList<>();
	        }
	    }
	
}

