package indv.zqliu.rectangle;

import java.util.Comparator;
import java.util.List;

/**
 * �˽ӿ����ڶ����������μ��λ�ñȽϲ����������������Ե��ж�
 * @author ������
 * @version 1.0
 */
public interface RectangleComparison {
  /**.
   * ��ȡdouble�Ƚ�������������
   * @return double�Ƚ�������������
   */
  public double getError();
  /**.
   * �趨�߿����ֵ
   * @param t �ж������Ƿ��ܱ���Ϊ��һ��ֱ�ߵ���ֵ
   * @throws IllegalArgumentException t<0
   */
  public void setThreshold(double th);
  
  /**.
   * ��ȡ�߿����ֵ
   * @return �ж������Ƿ��ܱ���Ϊ��һ��ֱ�ߵ���ֵ
   */
  public double getThreshold();
  /**.
   * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2����ࣻ����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isOnLeft(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ��ھ���ro2���Ϸ�
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2���Ϸ�������Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isOnTop(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����Ϸ����������������Ϸ��ľ���
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2�����Ϸ�������Ϊfalse
   * @throws NullPointerException ro1��ro2����Ϊ��
   */
  public boolean isOnTopLeft(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����Ϸ����������������󷽵ľ���
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2����ࣻ����Ϊfalse
   * @throws NullPointerException ro1��ro2����Ϊ��
   */
  public boolean isOnLeftTop(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������ro2�����
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2����룻����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isLeftAlignment(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������ro2�Ҷ���
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2�Ҷ��룻����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isRightAlignment(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������ro2�϶���
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2�϶��룻����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isTopAlignment(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������ro2�¶���
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2�¶��룻����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isBottomAlignment(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������ro2�ڴ�ֱ���������Ķ���
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2�ڴ�ֱ���������Ķ��룻����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isMiddleAligmentVertically(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������ro2��ˮƽ���������Ķ���
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2��ˮƽ���������Ķ��룻����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isMiddleAligmentHorizontally(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������ro2�ܱ���Ϊͬһ������
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2���Ա���Ϊͬһ�����Σ�����Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isSameRectangle(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������ж�ro1��ro2�Ƿ���ˮƽ����������
   * @param ro1 ��һ������
   * @param ro2 �ڶ�������
   * @return true����������������ģ����򷵻�false
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isConnectedHorizontally(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������ж�ro1��ro2�Ƿ��ڴ�ֱ����������
   * @param ro1 ��һ������
   * @param ro2 �ڶ�������
   * @return true����������������ģ����򷵻�false
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isConnectedVertically(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ񱻾���ro2������
   * @param ro1 ��һ������ 
   * @param ro2 �ڶ�������
   * @return true, ���ro1��ro2������������Ϊfalse
   * @throws NullPointerException ro1,ro2����Ϊ��
   */
  public boolean isContainedBy(RectangleComparable ro1, RectangleComparable ro2);
  
  /**.
   * �˷��������жϾ���ro1�Ƿ������(x,y)
   * @param ro ���� 
   * @param x ��ĺ�����
   * @param y ��ĺ�����
   * @return true, ���ro�����õ㣻����Ϊfalse
   * @throws NullPointerException ro1����Ϊ��
   * @throws IllegalArgumentException x,y����Ϊ��
   */
  public boolean isContainPoint(RectangleComparable ro, double xp, double yp);
  
  /**.
   * ���ݸ��ඨ��ıȽ��㷨����һ���Ƚ�����
   * �ñȽ���Ӧ���Ȱ����ε�X��������
   * ����X������ͬ�ģ���Y��������
   * @return һ���Ƚ���
   */
  public Comparator<?> generateHvComparator();
  
  /**.
   * ���ݸ��ඨ��ıȽ��㷨����һ���Ƚ�����
   * �ñȽ���Ӧ���Ȱ����ε�Y��������
   * ����Y������ͬ�ģ���X��������
   * @return һ���Ƚ���
   */
  public Comparator<?> generateVhComparator();
  
  /**.
   * �Ծ����б��Ȱ�Y�����С��������
   * ����Y���꼸����ͬ�İ�X�����С��������
   * @param rects Ҫ����ľ��ε��б�
   */
  public void sortVh(List<? extends RectangleComparable> rects);
  
  /**.
   * �Ծ����б��Ȱ�X�����С��������
   * ����X���꼸����ͬ�İ�Y�����С��������
   * @param rects Ҫ����ľ��ε��б�
   */
  public void sortHv(List<? extends RectangleComparable> rects);
}
