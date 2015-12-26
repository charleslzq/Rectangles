package indv.zqliu.Rectangles;

/**
* This class determines the relation between two number of double type, within error can be tolerated.
* @author zqliu
* @version 1.0
*/
class ApproximateCalculator {
		private double err;
		
		/**
		   * This method uses an double to initialize this class
		   * @param e The error.
		   * @throws IllegamArgumentException e<0
		   */
		public ApproximateCalculator(double e) throws IllegalArgumentException{
			if(e<0)
				throw new IllegalArgumentException("Error can't be less than 0.");
			err = e;
		}
		
		/**
		 * Return the specified error.
		 * @return The error specified.
		 */

		public double getErr() {
			return err;
		}
		
		/**
		 * Specify the error.
		 * @param err The error specified.
		 * * @throws IllegamArgumentException e<0
		 */
		public void setErr(double err) throws IllegalArgumentException{
			if(err<0)
				throw new IllegalArgumentException("Error can't be less than 0.");
			this.err = err;
		}
		
		/**
		 * This method compares two numbers, 
		 * checks whether they are equal within an error.
		 * @param a The first number
		 * @param b The second number
		 * @return true, if the absolute value of the difference of these two numbers is less than error specified; false, otherwise.
		 */
		
		public boolean alreadyEqual(double a, double b){
			if(Math.abs(a-b) <= err)
				return true;
			return false;
		}
		
		/**
		 * This method compares two numbers, 
		 * checks whether the first number 
		 * is strongly smaller than the second number, 
		 * within an error.
		 * @param a The first number
		 * @param b The second number
		 * @return true, if b-a is more than error; false, otherwise
		 */
		
		public boolean strongLess(double a, double b){
			if(a + err < b)
				return true;
			return false;
		}
		
		
		/**
		 * This method compares two numbers, 
		 * checks whether the first number 
		 * is weakly smaller than the second number, 
		 * within an error.
		 * @param a The first number
		 * @param b The second number
		 * @return true, if a-b is less than error; false, otherwise
		 */
		
		public boolean weakLess(double a, double b){
			if(a < b + err)
				return true;
			return false;
		}
		
		/**
		 * This method compares two numbers, 
		 * checks whether the first number 
		 * is strongly larger than the second number, 
		 * within an error.
		 * @param a The first number
		 * @param b The second number
		 * @return true, if a-b is more than error; false, otherwise
		 */
		
		public boolean strongMore(double a, double b){
			if( a > b + err)
				return true;
			return false;
		}
		
		/**
		 * This method compares two numbers, 
		 * checks whether the first number 
		 * is weakly larger than the second number, 
		 * within an error.
		 * @param a The first number
		 * @param b The second number
		 * @return true, if b-a is less than error; false, otherwise
		 */
		public boolean weakMore(double a, double b){
			if( a + err > b)
				return true;
			return false;
		}

}
