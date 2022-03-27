package kaden;

public class Kaden {

	public int largestSubarraySum(int[] arr) {

		int n = arr.length;
		int globalMax = Integer.MIN_VALUE;
		int localMax = 0;

		int start = 0;
		int end = 0;
		int localStart = 0;

		for (int i = 0; i < n; i++) {

			localMax = Math.max(arr[i], arr[i] + localMax);

			if (localMax == arr[i]) {
				localStart = i;
			}

			if (localMax > globalMax) {
				globalMax = localMax;
				start = localStart;
				end = i;
			}

		}

		System.out.println("start - " + start + "\nend - " + end);
		return globalMax;
	}

}
