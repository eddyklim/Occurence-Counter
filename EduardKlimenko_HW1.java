
/*
 * TCSS 342 – Winter 2018
 * Assignment 1
 */

import java.util.Arrays;

/**
 * This program displays the least occurring integers and their occurrence rate.
 * 0 will be treated as an integer.
 * 
 * @author Eduard Klimenko
 * @version 14 Jan, 2018
 *
 */
public class EduardKlimenko_HW1 {

	public static void main(String[] args) {
		/* Input array. */
		int[] arr = { 1, 4, 4, 3, 4, 3, 5, 2, 1 };
		/* Output array. */
		int[] minNums = new int[arr.length];
		/* Minimum occurrence rate. */
		int minOcc = Integer.MAX_VALUE;
		/* Temporary minimum occurrence rate. */
		int minOccTemp = 0;
		/* Output array index. */
		int index = 0;

		// Checks if not empty.
		if (arr.length != 0) {
			// Prints input array.
			System.out.print("Original array: ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			// Prints sorted input array.
			System.out.print("\nSorted array: ");
			Arrays.sort(arr); // O(nlog(n))
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			// Compares every element to itself
			for (int i = 0; i < arr.length; i++) {
				// If before last or the next element is not the same
				if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
					for (int j = 0; j < arr.length; j++) {
						// If same value, increments minimum occurrence count.
						if (arr[j] == arr[i]) {
							minOccTemp++;
						}
					}
					// If current minimum is less than all previous,
					// overwrite the output array starting at index 0.
					if (minOccTemp < minOcc) {
						index = 0;
						minOcc = minOccTemp;
						minNums[index++] = arr[i];
						// If the same add to output array.
					} else if (minOccTemp == minOcc) {
						minOcc = minOccTemp;
						minNums[index++] = arr[i];
					}
				}
				// Resets temporary minimum.
				minOccTemp = 0;
			}
			// Prints out all the replaced (if any) elements.
			System.out.print("\nElements: ");
			for (int k = 0; k < index; k++) {
				System.out.print(minNums[k] + " ");
			}
			// Prints out the minimum number of occurrences.
			System.out.println("\nNumber of occurances: " + minOcc);
		} else {
			// If empty array, notify user.
			System.out.println("Empty array!");
		}
	}
}
