package indv.zqliu.Rectangles;

/**
 * һ���򵥵ľ����࣬ʵ��RectangleOperation�ӿ�
 * @author ������
 * @version 1.0
 */
public class SimpleRectangle implements Rectangle{
	private double x;
	private double y;
	private double width;
	private double height;
	
	/**
	 * ���캯��
	 * @param a ���κ��������Сֵ
	 * @param b �������������Сֵ
	 * @param c ���εĿ��
	 * @param d ���εĸ߶�
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
