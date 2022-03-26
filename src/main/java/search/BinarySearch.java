package search;

public class BinarySearch {

	public int search(int[] array, int value) {

		int left = 0;
		int right = array.length - 1;
		int pivot;

		while (left <= right) {

			pivot = left + (right - left) / 2;

			if (array[pivot] < value) {

				left = pivot + 1;
			} else if (array[pivot] > value) {

				right = pivot - 1;
			} else {

				return pivot;
			}

		}

		return -1;
	}

}
