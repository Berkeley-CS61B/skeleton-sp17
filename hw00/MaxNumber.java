class MaxNumber {

	/**
	 * Find the max number in an array.
	 * @param: array -- the res array to find the max number.
	 */
	public static int max(int[] array) {
		// Use a for loop to find the max number 
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
		}

		return array[maxIndex];
	}

	public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
	}
	
}