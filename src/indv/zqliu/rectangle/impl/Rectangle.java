package indv.zqliu.rectangle.impl;

import indv.zqliu.rectangle.RectangleComparable;

/**
 * һ���򵥵ľ����࣬ʵ��RectangleOperation�ӿ�
 * @author ������
 * @version 1.0
 */
public abstract class Rectangle implements RectangleComparable{
  private final double xp;
  private final double yp;
  private final double width;
  private final double height;
  
  /**.
   * ���캯��
   * @param ap ĳ������ĺ�����
   * @param bp ĳ�������������
   * @param cp ��ȣ�����Ϊ��
   * @param dp �߶ȣ�����Ϊ��
   * @throws IllegalArgumentException ĳ�������и�������ֵ
   */
  Rectangle(double ap, double bp, double cp, double dp) {
    if (ap < 0 || bp < 0 || ap + cp < 0 || bp + dp < 0) {
      throw new IllegalArgumentException();
    }
    xp = cp >= 0 ? ap : ap + cp;
    yp = dp >= 0 ? bp : bp + dp;
    width = cp >= 0 ? cp : -cp;
    height = dp >= 0 ? dp : -dp;
  }

  public double getMinX() {
    // TODO Auto-generated method stub
    return xp;
  }

  public double getMaxX() {
    // TODO Auto-generated method stub
    return xp + width;
  }

  public double getMinY() {
    // TODO Auto-generated method stub
    return yp;
  }

  public double getMaxY() {
    // TODO Auto-generated method stub
    return yp + height;
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
    return xp + width / 2;
  }

  public double getMidY() {
    // TODO Auto-generated method stub
    return yp + height / 2;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getClass().getSimpleName() + ":\t");
    sb.append("x:" + xp + "\t");
    sb.append("y:" + yp + "\t");
    sb.append("width:" + width + "\t");
    sb.append("height:" + height);
    
    return sb.toString();
  }

}
