package indv.zqliu.Rectangles.DefaultImpl;

import indv.zqliu.Rectangles.Comparison.DefaultRectangleComparator;
import indv.zqliu.Rectangles.RectInterface.RectangleComparison;

public class RectangleFactory {
	private final RectangleComparison comparator;
	
	public RectangleFactory(){
		comparator = DefaultRectangleComparator.getInstance();
	}
	
	public RectangleFactory(RectangleComparison rc){
		comparator = rc;
	}
	
	/**
	 * ��ȡһ������
	 * @param x ���������
	 * @param y ����������
	 * @param w ���
	 * @param h �߶�
	 * @return �������趨�ľ��ξ��Σ������������Ϊ������ȸ߶����Ϊ�����ת������ֵ��ͬʱת����������
	 */
	public Rectangle getRectangle(double x, double y, double w, double h){
		x = w>0?x:x+w;
		y = h>0?y:y+h;
		w = w>0?w:-w;
		h = h>0?h:-h;
		if(w <= comparator.getThreshold()){
			if(h<=comparator.getThreshold())
				return new RectPoint(x,y,w,h);
			else
				return new RectVLine(x,y,w,h);
		}else{
			if(h<=comparator.getThreshold())
				return new RectHLine(x,y,w,h);
			else
				return new RectCell(x,y,w,h);
		}
	}
	
	/**
	 * ����һ������
	 * @param rect Ҫ�����ľ���
	 * @return һ���µľ��Σ�������ԭ������ȫ��ͬ
	 */
	public Rectangle copy(Rectangle rect){
		double x = rect.getMinX();
		double y = rect.getMinY();
		double w = rect.getWidth();
		double h = rect.getHeight();
		return getRectangle(x,y,w,h);
	}
	
	/**
	 * ���ںϲ����������ľ��Σ�����λ�����⣩��ͨ�÷�����
	 * �ڲ��������������ж�
	 * @param r1 һ������
	 * @param r2 ��һ������
	 * @return �¾��Σ�Ϊ�����������ε���С����
	 */
	Rectangle merge(Rectangle r1, Rectangle r2){
		assert(r1!=null && r2!=null);
		double x = r1.getMinX()<r2.getMinX()?r1.getMinX():r2.getMinX();
		double y = r1.getMinY()<r2.getMinY()?r1.getMinY():r2.getMinY();
		double w = r1.getMaxX()>r2.getMaxX()?r1.getMaxX():r2.getMaxX() - x;
		double h = r1.getMaxY()>r2.getMaxY()?r1.getMaxY():r2.getMaxY() - y;
		return getRectangle(x,y,w,h);
	}
	
	/**
	 * Ϊ�����趨�µ�����ֵ
	 * @param r Ҫ���µľ���
	 * @param x �µ�x
	 * @param y �µ�y
	 * @param w �µĿ��
	 * @param h �µĸ߶�
	 * @return ���º�ľ���
	 */
	Rectangle update(Rectangle r, double x, double y, double w, double h){
		assert(r!=null);
		Rectangle tmp = getRectangle(x,y,w,h);
		if(!tmp.getClass().equals(r.getClass()))
			throw new ClassCastException("Cannot cast "+r.getClass().getName()+" to "+tmp.getClass().getName());
		return tmp;
	}

	/**
	 * ���¿�ȣ�������������
	 * ������º�ľ���������ԭ�������ͣ���RectVLine�Ӵ��Ⱥ���RectCell��
	 * ��һ�»��׳�ClassCaseException.
	 * @param r ԭ����
	 * @param w �µĿ��
	 * @return �µľ���
	 */
	public Rectangle updateWidth(Rectangle r, int w) {
		// TODO Auto-generated method stub
		if(r == null)
			throw new NullPointerException();
		return update(r,r.getMinX(),r.getMinY(),w,r.getHeight());
	}
	
	/**
	 * ���¸߶ȣ������������䡣
	 * ������º�ľ���������ԭ�������ͣ���RectHLine�Ӵ�߶Ⱥ���RectCell��
	 * ��һ�»��׳�ClassCaseException.
	 * @param r ԭ����
	 * @param h �µĸ߶ȣ�����С��0
	 * @return �µľ���
	 */
	public Rectangle updateHeight(Rectangle r, int h){
		if(r == null)
			throw new NullPointerException();
		return update(r, r.getMinX(), r.getMinY(), r.getWidth(), h);
	}
}
