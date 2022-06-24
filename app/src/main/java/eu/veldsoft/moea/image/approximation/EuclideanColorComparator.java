package eu.veldsoft.moea.image.approximation;

/**
 * Euclidean distance between two pixels comparator class.
 * 
 * @author Todor Balabanov
 */
class EuclideanColorComparator implements ColorComparator {
	/** Red channel difference. */
	private int deltaRed;

	/** Green channel difference. */
	private int deltaGreen;

	/** Blue channel difference. */
	private int deltaBlue;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double distance(int a, int b) {
		deltaRed = ((a & 0xFF0000) >> 16) - ((b & 0xFF0000) >> 16);
		deltaGreen = ((a & 0xFF00) >> 8) - ((b & 0xFF00) >> 8);
		deltaBlue = (a & 0xFF) - (b & 0xFF);

		return Math.sqrt(deltaRed * deltaRed + deltaGreen * deltaGreen
				+ deltaBlue * deltaBlue);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double distance(int[] rgb, int color) {
		deltaRed = rgb[0] - ((color & 0xFF0000) >> 16);
		deltaGreen = rgb[1] - ((color & 0xFF00) >> 8);
		deltaBlue = rgb[2] - (color & 0xFF);

		return Math.sqrt(deltaRed * deltaRed + deltaGreen * deltaGreen
				+ deltaBlue * deltaBlue);
	}
}
