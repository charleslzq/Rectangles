package indv.zqliu.Rectangles;

/**
 * 此抽象类的子类可以用于进行矩形比较和类型判断操作
 * @author 刘正亓
 * @version 1.0
 */
public interface RectangleComparator extends RectangleComparison,
		RectangleTypeProcessor {
	
	public double getError();
	public double getThreshold();

}