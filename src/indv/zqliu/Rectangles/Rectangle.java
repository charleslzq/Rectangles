package indv.zqliu.Rectangles;

/**
 * 此接口用于定义矩形的基本参数操作
 * @author 刘正亓
 * @version 1.0
 */
public interface Rectangle {
	
	/**
	 * 得到该矩形横坐标的最小值
	 * @return 横坐标的最小值
	 */
	public double getMinX();
	
	/**
	 * 得到该矩形横坐标的中间值
	 * @return 横坐标的中间值
	 */
	public double getMidX();
	
	/**
	 * 得到该矩形横坐标的最大值
	 * @return 横坐标的最大值
	 */
	public double getMaxX();
	
	/**
	 * 得到该矩形纵坐标的最小值
	 * @return 纵坐标的最小值
	 */
	public double getMinY();
	
	/**
	 * 得到该矩形纵坐标的中间值
	 * @return 纵坐标的中间值
	 */
	public double getMidY();
	
	/**
	 * 得到该矩形纵坐标的最大值
	 * @return 纵坐标的最大值
	 */
	public double getMaxY();
	
	/**
	 * 得到该矩形的宽度
	 * @return 矩形的宽度
	 */
	public double getWidth();
	
	/**
	 * 得到该矩形的高度
	 * @return 矩形的高度
	 */
	public double getHeight();
	
	/**
	 * 重新设定矩形的参数
	 * @param x 横坐标的最小值
	 * @param y 纵坐标的最小值
	 * @param w 宽度
	 * @param h 高度
	 */
	public void setRect(double x, double y, double w, double h);
}
