package indv.zqliu.rectangle.impl;

import indv.zqliu.rectangle.RectangleComparison;
import indv.zqliu.rectangle.comparison.DefaultRectangleComparator;

public class RectangleFactory {
  private final RectangleComparison comparator;
  
  public RectangleFactory() {
    comparator = DefaultRectangleComparator.getInstance();
  }
  
  public RectangleFactory(RectangleComparison rc) {
    comparator = rc;
  }
  
  /**.
   * ��ȡһ������
   * @param xr ���������
   * @param yr ����������
   * @param wr ���
   * @param hr �߶�
   * @return �������趨�ľ��ξ��Σ������������Ϊ������ȸ߶����Ϊ�����ת������ֵ��ͬʱת����������
   */
  public Rectangle getRectangle(double xr, double yr, double wr, double hr) {
    xr = wr > 0 ? xr : xr + wr;
    yr = hr > 0 ? yr : yr + hr;
    wr = wr > 0 ? wr : -wr;
    hr = hr > 0 ? hr : -hr;
    if (wr <= comparator.getThreshold()) {
      if (hr <= comparator.getThreshold()) {
        return new RectPoint(xr,yr,wr,hr);
      } else {
        return new RectVLine(xr,yr,wr,hr);
      }
    } else {
      if (hr <= comparator.getThreshold()) {
        return new RectHLine(xr,yr,wr,hr);
      } else {
        return new RectCell(xr,yr,wr,hr);
      }
    }
  }
  
  /**.
   * ����һ������
   * @param rect Ҫ�����ľ���
   * @return һ���µľ��Σ�������ԭ������ȫ��ͬ
   */
  public Rectangle copy(Rectangle rect) {
    double xr = rect.getMinX();
    double yr = rect.getMinY();
    double wr = rect.getWidth();
    double hr = rect.getHeight();
    return getRectangle(xr,yr,wr,hr);
  }
  
  /**.
   * ���ںϲ����������ľ��Σ�����λ�����⣩��ͨ�÷�����
   * �ڲ��������������ж�
   * @param r1 һ������
   * @param r2 ��һ������
   * @return �¾��Σ�Ϊ�����������ε���С����
   */
  Rectangle merge(Rectangle r1, Rectangle r2) {
    assert (r1 != null && r2 != null);
    double xr = r1.getMinX() < r2.getMinX() ? r1.getMinX() : r2.getMinX();
    double yr = r1.getMinY() < r2.getMinY() ? r1.getMinY() : r2.getMinY();
    double wr = r1.getMaxX() > r2.getMaxX() ? r1.getMaxX() : r2.getMaxX() - xr;
    double hr = r1.getMaxY() > r2.getMaxY() ? r1.getMaxY() : r2.getMaxY() - yr;
    return getRectangle(xr,yr,wr,hr);
  }
  
  /**.
   * Ϊ�����趨�µ�����ֵ
   * @param r0 Ҫ���µľ���
   * @param xr �µ�x
   * @param yr �µ�y
   * @param wr �µĿ��
   * @param hr �µĸ߶�
   * @return ���º�ľ���
   */
  Rectangle update(Rectangle r0, 
      double xr, 
      double yr, 
      double wr, 
      double hr) {
    assert (r0 != null);
    Rectangle tmp = getRectangle(xr,yr,wr,hr);
    if (!tmp.getClass().equals(r0.getClass())) {
      throw new ClassCastException("Cannot cast " 
    + r0.getClass().getName() 
    + " to " 
    + tmp.getClass().getName());
    }
    return tmp;
  }

  /**
   * ���¿�ȣ�������������
   * ������º�ľ���������ԭ�������ͣ���RectVLine�Ӵ��Ⱥ���RectCell��
   * ��һ�»��׳�ClassCaseException.
   * @param r0 ԭ����
   * @param nw �µĿ��
   * @return �µľ���
   */
  public Rectangle updateWidth(Rectangle r0, int nw) {
    // TODO Auto-generated method stub
    if (r0 == null) {
      throw new NullPointerException();
    }
    return update(r0,r0.getMinX(),r0.getMinY(),nw,r0.getHeight());
  }
  
  /**
   * ���¸߶ȣ������������䡣
   * ������º�ľ���������ԭ�������ͣ���RectHLine�Ӵ�߶Ⱥ���RectCell��
   * ��һ�»��׳�ClassCaseException.
   * @param r0 ԭ����
   * @param nh �µĸ߶ȣ�����С��0
   * @return �µľ���
   */
  public Rectangle updateHeight(Rectangle r0, int nh) {
    if (r0 == null) {
      throw new NullPointerException();
    }
    return update(r0, r0.getMinX(), r0.getMinY(), r0.getWidth(), nh);
  }
}
