package sort;

public class MergeSort {

	public void mergeSort(int[] arr) {

		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int left, int right) {

		if (left < right) {

			int middle = left + (right - left) / 2;


			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);

			merge(arr, left, middle, right);
		}

	}

	private void merge(int[] arr, int left, int middle, int right) {

		int n1 = middle - left + 1;
		int n2 = right - middle;

		int[] tmpLeft = new int[n1];
		int[] tmpRight = new int[n2];

		for (int i = 0; i < n1; i++) {
			tmpLeft[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			tmpRight[j] = arr[middle + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {

			if (tmpLeft[i] < tmpRight[j]) {
				arr[k] = tmpLeft[i];
				i++;
			} else {
				arr[k] = tmpRight[j];
				j++;
			}

			k++;
		}
		/**
		 * We stopped because either left array or right array is empty
		 */
		while (i < n1) { // Add all numbers from left Array

			arr[k] = tmpLeft[i];
			i++;
			k++;

		}

		while (j < n2) { // Add all numbers from right Array

			arr[k] = tmpRight[j];
			j++;
			k++;

		}
	}

}
