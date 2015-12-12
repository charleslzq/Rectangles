package indv.zqliu.Rectangles;

/**
 * 一个简单的矩形类，实现RectangleOperation接口
 * @author 刘正亓
 * @version 1.0
 */
public class SimpleRectangle implements Rectangle{
	private double x;
	private double y;
	private double width;
	private double height;
	
	/**
	 * 构造函数
	 * @param a 矩形横坐标的最小值
	 * @param b 矩形纵坐标的最小值
	 * @param c 矩形的宽度
	 * @param d 矩形的高度
	 */
	public SimpleRectangle(double a, double b, double c, double d){
		x = a;
		y = b;
		width = c;
		height = d;
	}

	@Override
	public double getMinX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getMaxX() {
		// TODO Auto-generated method stub
		return x+width;
	}

	@Override
	public double getMinY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public double getMaxY() {
		// TODO Auto-generated method stub
		return y+height;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public double getMidX() {
		// TODO Auto-generated method stub
		return x+width/2;
	}

	@Override
	public double getMidY() {
		// TODO Auto-generated method stub
		return y+height/2;
	}
	
	@Override
	public void setRect(double x, double y, double w, double h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

}
