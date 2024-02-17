package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import java.math.BigInteger;

public class LargestNumberSolverTest {

    @Test
    public void testFindLargestNumber() {
        Integer[] arr1 = {3, 30, 34, 5, 9};
        assertEquals(new BigInteger("9534330"), LargestNumberSolver.findLargestNumber(arr1));

        Integer[] arr2 = {0, 0, 0, 0};
        assertEquals(new BigInteger("0"), LargestNumberSolver.findLargestNumber(arr2));

        Integer[] arr3 = {1, 2, 3, 4, 5};
        assertEquals(new BigInteger("54321"), LargestNumberSolver.findLargestNumber(arr3));
    }

    @Test
    public void testFindLargestInt() {
        Integer[] arr1 = {3, 30, 34, 5, 9};
        assertEquals(9534330, LargestNumberSolver.findLargestInt(arr1));

        Integer[] arr2 = {0, 0, 0, 0};
        assertEquals(0, LargestNumberSolver.findLargestInt(arr2));

        Integer[] arr3 = {1, 2, 3, 4, 5};
        assertEquals(54321, LargestNumberSolver.findLargestInt(arr3));

        Integer[] arr4 = {2147483647, 2, 3, 4, 5};
        try {
            LargestNumberSolver.findLargestInt(arr4);
            fail("Expected OutOfRangeException was not thrown");
        } catch (OutOfRangeException e) {
            // Expected behavior
        }
    }

    @Test
    public void testFindLargestLong() {
        Integer[] arr1 = {3, 30, 34, 5, 9};
        assertEquals(9534330L, LargestNumberSolver.findLargestLong(arr1));

        Integer[] arr2 = {0, 0, 0, 0};
        assertEquals(0L, LargestNumberSolver.findLargestLong(arr2));

        Integer[] arr3 = {1, 2, 3, 4, 5};
        assertEquals(54321L, LargestNumberSolver.findLargestLong(arr3));

        Integer[] arr4 = {2147483647, 2, 3, 4, 5};
        try {
            LargestNumberSolver.findLargestLong(arr4);
            fail("Expected OutOfRangeException was not thrown");
        } catch (OutOfRangeException e) {
            // Expected behavior
        }
    }

    @Test
    public void testSum() {
        Integer[] arr1 = {3, 30, 34, 5, 9};
        Integer[] arr2 = {1, 2, 3};
        Integer[] arr3 = {4, 5, 6};
        List<Integer[]> list = new ArrayList<Integer[]>();
        list.add(arr1);
        list.add(arr3);
        list.add(arr2);
        assertEquals(new BigInteger("9535305"), LargestNumberSolver.sum(list));
    }

    @Test
    public void testFindKthLargest() {
        Integer[] arr1 = {3, 30, 34, 5, 9};
        Integer[] arr2 = {1, 2, 3};
        Integer[] arr3 = {4, 5, 6};
        List<Integer[]> list = new ArrayList<Integer[]>();
        list.add(arr3);
        list.add(arr2);
        list.add(arr1);

        assertArrayEquals(arr1, LargestNumberSolver.findKthLargest(list, 0));
		
    }

    @Test
    public void testReadFile() {
        List<Integer[]> list = LargestNumberSolver.readFile("integers.txt");
        assertEquals(903, list.size());

    }
}