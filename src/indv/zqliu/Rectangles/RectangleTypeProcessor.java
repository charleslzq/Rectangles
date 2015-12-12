package indv.zqliu.Rectangles;


/**
 * 此接口用于定义矩形的的类型（点，横线，竖线，单元格）判断
 * @author 刘正亓
 * @version 1.0
 */
public interface RectangleTypeProcessor {
	/**
	 * 设定判定的阈值
	 * @param t 判断矩形类型的阈值
	 */
	public void setThreshold(double t);
	
	/**
	 * 获取判定的阈值
	 * @return 判断矩形类型的阈值
	 */
	public double getThreshold();
	
	/**
	 * 判断矩形的类型
	 * @param ro 矩形
	 * @return 矩形的类型（点，横线，竖线，单元格）
	 */
	public RectangleType getType(Rectangle ro);
}
