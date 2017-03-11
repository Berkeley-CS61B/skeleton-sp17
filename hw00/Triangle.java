class Triangle {

	/**
	 * Draw a isosceles righttriangle with the side length
	 * @param: sideLength - the side Length of the triangle.
	 */
	public static void drawTriangle(int sideLength) {
		// index of x-axis
		int iX = 0;
		// index of y-axis
		int iY = 0;

		while (iY < sideLength) {
			while(iX <= iY) {
				System.out.print("*");
				iX += 1;
			}

			iX = 0;
			System.out.println();
			iY += 1;
		}
	}

	public static void main(String[] args) {
			drawTriangle(5);
		}	
}