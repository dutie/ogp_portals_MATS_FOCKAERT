package portals;

public class ThreeQuartersTransformation implements Transformation{
	
	/**	 
	 * @invar | fraction >= (1.0/2.0) 
	 * @invar | fraction <= 2.0
	 * @immutable
	 */
	private final double fraction = (3.0/4.0);
	
	/**
	 * Returns a size of an object scaled by the portal's transformation
	 * 
	 * @pre  | 0 < objSize
	 * 
	 * @post | result == Math.round(objSize * getFraction())
	 */
	@Override
	public int apply(int objSize) {
		return (int) Math.round(objSize * fraction);
	}
	
	public double getFraction() {
		return fraction;
	}
	


	
}