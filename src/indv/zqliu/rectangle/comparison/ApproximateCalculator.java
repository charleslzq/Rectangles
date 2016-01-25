package indv.zqliu.rectangle.comparison;

/**.
* This class determines the relation between two number of double type, 
* within error can be tolerated.
* @author zqliu
* @version 1.0
*/
final class ApproximateCalculator {
  private final double err;
  
  /**.
     * This method uses an double to initialize this class
     * @param er The error.
     * @throws IllegamArgumentException e<0
     */
  ApproximateCalculator(double er) throws IllegalArgumentException {
    if (er < 0) {
      throw new IllegalArgumentException("Error can't be less than 0.");
    }
    err = er;
  }
  
  /**.
   * Return the specified error.
   * @return The error specified.
   */

  public double getErr() {
    return err;
  }
  
  /**.
   * This method compares two numbers, 
   * checks whether they are equal within an error.
   * @param ap The first number
   * @param bp The second number
   * @return true, if these two numbers can be seen as almost equal; false, otherwise.
   */
  
  public boolean alreadyEqual(double ap, double bp) {
    if (Math.abs(ap - bp) <= err) {
      return true;
    }
    return false;
  }
  
  /**.
   * This method compares two numbers, 
   * checks whether the first number 
   * is strongly smaller than the second number, 
   * within an error.
   * @param ap The first number
   * @param bp The second number
   * @return true, if b-a is more than error; false, otherwise
   */
  
  public boolean strongLess(double ap, double bp) {
    if (ap + err < bp) {
      return true;
    }
    return false;
  }
  
  
  /**.
   * This method compares two numbers, 
   * checks whether the first number 
   * is weakly smaller than the second number, 
   * within an error.
   * @param ap The first number
   * @param bp The second number
   * @return true, if a-b is less than error; false, otherwise
   */
  
  public boolean weakLess(double ap, double bp) {
    if (ap < bp + err) {
      return true;
    }
    return false;
  }
  
  /**.
   * This method compares two numbers, 
   * checks whether the first number 
   * is strongly larger than the second number, 
   * within an error.
   * @param ap The first number
   * @param bp The second number
   * @return true, if a-b is more than error; false, otherwise
   */
  
  public boolean strongMore(double ap, double bp) {
    if ( ap > bp + err) {
      return true;
    }
    return false;
  }
  
  /**.
   * This method compares two numbers, 
   * checks whether the first number 
   * is weakly larger than the second number, 
   * within an error.
   * @param ap The first number
   * @param bp The second number
   * @return true, if b-a is less than error; false, otherwise
   */
  public boolean weakMore(double ap, double bp) {
    if ( ap + err > bp) {
      return true;
    }
    return false;
  }

}
