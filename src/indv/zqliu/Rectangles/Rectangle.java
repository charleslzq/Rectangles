package indv.zqliu.Rectangles;

/**
 * һ���򵥵ľ����࣬ʵ��RectangleOperation�ӿ�
 * @author ������
 * @version 1.0
 */
public class Rectangle{
	private double x;
	private double y;
	private double width;
	private double height;
	
	/**
	 * ���캯��
	 * @param a ĳ������ĺ�����
	 * @param b ĳ�������������
	 * @param c ��ȣ�����Ϊ��
	 * @param d �߶ȣ�����Ϊ��
	 * @throws IllegalArgumentException ĳ�������и�������ֵ
	 */
	public Rectangle(double a, double b, double c, double d){
		if(a<0 || b<0 || a+c<0 || b+d<0)
			throw new IllegalArgumentException();
		x = c>=0?a:a+c;
		y = d>=0?b:b+d;
		width = c>=0?c:-c;
		height = d>=0?d:-d;
	}

	public double getMinX() {
		// TODO Auto-generated method stub
		return x;
	}

	public double getMaxX() {
		// TODO Auto-generated method stub
		return x+width;
	}

	public double getMinY() {
		// TODO Auto-generated method stub
		return y;
	}

	public double getMaxY() {
		// TODO Auto-generated method stub
		return y+height;
	}

	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	public double getMidX() {
		// TODO Auto-generated method stub
		return x+width/2;
	}

	public double getMidY() {
		// TODO Auto-generated method stub
		return y+height/2;
	}
	
	public void setRect(double x, double y, double w, double h){
		if(x<0 || y<0 || x+w<0 || y+h <0)
			throw new IllegalArgumentException("Illegal Rectangle");
		this.x = w>=0?x:x+w;
		this.y = h>=0?y:y+h;
		this.width = w>=0?w:-w;
		this.height = h>=0?h:-h;
	}

}
