package indv.zqliu.Rectangles.DefaultImpl;

import indv.zqliu.Rectangles.RectInterface.RectangleComparable;

/**
 * һ���򵥵ľ����࣬ʵ��RectangleOperation�ӿ�
 * @author ������
 * @version 1.0
 */
public abstract class Rectangle implements RectangleComparable{
	private final double x;
	private final double y;
	private final double width;
	private final double height;
	
	/**
	 * ���캯��
	 * @param a ĳ������ĺ�����
	 * @param b ĳ�������������
	 * @param c ��ȣ�����Ϊ��
	 * @param d �߶ȣ�����Ϊ��
	 * @throws IllegalArgumentException ĳ�������и�������ֵ
	 */
	Rectangle(double a, double b, double c, double d){
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName()+":\t");
		sb.append("x:"+x+"\t");
		sb.append("y:"+y+"\t");
		sb.append("width:"+width+"\t");
		sb.append("height:"+height);
		
		return sb.toString();
	}

}
