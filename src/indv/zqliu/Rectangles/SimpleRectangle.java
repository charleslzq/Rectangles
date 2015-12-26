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
	 * @param a 某个顶点的横坐标
	 * @param b 某个顶点的纵坐标
	 * @param c 宽度，可以为负
	 * @param d 高度，可以为负
	 * @throws IllegalArgumentException 某个顶点有负的坐标值
	 */
	public SimpleRectangle(double a, double b, double c, double d) throws IllegalArgumentException{
		if(a<0 || b<0 || a+c<0 || b+d<0)
			throw new IllegalArgumentException();
		x = c>=0?a:a+c;
		y = d>=0?b:b+d;
		width = c>=0?c:-c;
		height = d>=0?d:-d;
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
	public void setRect(double x, double y, double w, double h) throws IllegalArgumentException{
		if(x<0 || y<0 || x+w<0 || y+h <0)
			throw new IllegalArgumentException("Illegal Rectangle");
		this.x = w>=0?x:x+w;
		this.y = h>=0?y:y+h;
		this.width = w>=0?w:-w;
		this.height = h>=0?h:-h;
	}

}
