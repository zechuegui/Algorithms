package sort;

import java.util.Random;

public class QuickSort {

	public void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	private void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private int partition(int[] arr, int low, int high) {

//		Random rand = new Random();

//		int pivot = arr[rand.nextInt(high - low) + low + 1]; // Doesn't seem to work with random pivot
		int pivot = arr[high];

		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i + 1, high);
		return (i + 1);
	}

	private void quicksort(int[] arr, int low, int high) {

		if (low < high) {

			int partition_index = partition(arr, low, high);

			quicksort(arr, low, partition_index - 1);
			quicksort(arr, partition_index + 1, high);
		}
	}
}
