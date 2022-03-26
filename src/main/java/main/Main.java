package main;

import manacher.Manacher;
import search.BinarySearch;
import sort.MergeSort;
import sort.QuickSort;

public class Main {

	public static void main(String[] args) {
//		Manacher manacher = new Manacher();

//		System.out.println(manacher.getLongestSubstring("cbbd"));

//		BinarySearch bs = new BinarySearch();
//
//		int [] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//
//		System.out.println(bs.search(arr, 4));

		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();

		int[] arr = new int[]{6, 7, 5, 3, 1, 99, 66, 2};
//		ms.mergeSort(arr);
		qs.quicksort(arr);
		printIntArray(arr);
	}

	private static void printIntArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {

			String s = String.valueOf(arr[i]);
			s += (i+1 == arr.length) ? "" : ",";

			System.out.print(s);

		}
		System.out.println("]");
	}
}
