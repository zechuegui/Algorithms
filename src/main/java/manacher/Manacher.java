package manacher;

public class Manacher {

	private String initialString;
	private char[] transformedString;
	private int[] lsp;

	public Manacher() {
	}


	public String getLongestSubstring(String initialString) {

		this.initialString = initialString;
		this.transformedString = transform(initialString);
		lsp = new int[2 * initialString.length() + 3];

		int center = 0;
		int right = 0;

		for (int i = 1; i < transformedString.length-1; i++) {

			int mirror = 2 * center - i;

			if (right > i) {
				lsp[i] = Math.min(lsp[mirror], right - i);
			}

			while (transformedString[i + (1 + lsp[i])] == transformedString[i - (1 + lsp[i])]) {
				lsp[i]++;
			}

			if(i + lsp[i] > right){
				center = i;
				right = i + lsp[i];
			}


		}

		int length = 0;
		center = 0;
		for (int i = 1; i < lsp.length-1; i++) {
			if (lsp[i] > length) {
				length = lsp[i];
				center = i;
			}
		}
		return initialString.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
	}

	/**
	 * Transforms a String of type "abc" to "$#a#b#c#@"
	 *
	 * @param initialString
	 * @return
	 */
	private char[] transform(String initialString) {

		char[] transformedString = new char[2 * initialString.length() + 3];

		transformedString[0] = '$';
		transformedString[transformedString.length - 1] = '@';
		transformedString[transformedString.length - 2] = '#';

		for (int i = 0; i < initialString.length(); i++) {
			transformedString[2 * i + 1] = '#';
			transformedString[2 * i + 2] = initialString.charAt(i);
		}

		return transformedString;
	}

}
