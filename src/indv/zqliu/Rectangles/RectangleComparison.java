package indv.zqliu.Rectangles;

import java.util.Comparator;
import java.util.List;

/**
 * �˽ӿ����ڶ����������μ��λ�ñȽϲ����������������Ե��ж�
 * @author ������
 * @version 1.0
 */
public interface RectangleComparison {
	/**
	 * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2����ࣻ����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isOnLeft(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ��ھ���ro2���Ϸ�
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2���Ϸ�������Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isOnTop(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����Ϸ����������������Ϸ��ľ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�����Ϸ�������Ϊfalse
	 * @throws NullPointerException ro1��ro2����Ϊ��
	 */
	public boolean isOnTopLeft(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����Ϸ����������������󷽵ľ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2����ࣻ����Ϊfalse
	 * @throws NullPointerException ro1��ro2����Ϊ��
	 */
	public boolean isOnLeftTop(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�����
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2����룻����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isLeftAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�Ҷ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�Ҷ��룻����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isRightAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�϶���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�϶��룻����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isTopAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�¶���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�¶��룻����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isBottomAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�ڴ�ֱ���������Ķ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�ڴ�ֱ���������Ķ��룻����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isMiddleAligmentVertically(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2��ˮƽ���������Ķ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2��ˮƽ���������Ķ��룻����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isMiddleAligmentHorizontally(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�ܱ���Ϊͬһ������
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2���Ա���Ϊͬһ�����Σ�����Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isSameRectangle(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������ж�ro1��ro2�Ƿ���ˮƽ����������
	 * @param ro1 ��һ������
	 * @param ro2 �ڶ�������
	 * @return true����������������ģ����򷵻�false
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isConnectedHorizontally(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������ж�ro1��ro2�Ƿ��ڴ�ֱ����������
	 * @param ro1 ��һ������
	 * @param ro2 �ڶ�������
	 * @return true����������������ģ����򷵻�false
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isConnectedVertically(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ񱻾���ro2������
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2������������Ϊfalse
	 * @throws NullPointerException ro1,ro2����Ϊ��
	 */
	public boolean isContainedBy(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������(x,y)
	 * @param ro ���� 
	 * @param x ��ĺ�����
	 * @param y ��ĺ�����
	 * @return true, ���ro�����õ㣻����Ϊfalse
	 * @throws NullPointerException ro1����Ϊ��
	 * @throws IllegalArgumentException x,y����Ϊ��
	 */
	public boolean isContainPoint(Rectangle ro, double x, double y);
	
	/**
	 * ���ݸ��ඨ��ıȽ��㷨����һ���Ƚ�����
	 * �ñȽ���Ӧ���Ȱ����ε�X��������
	 * ����X������ͬ�ģ���Y��������
	 * @return һ���Ƚ���
	 */
	public Comparator<?> generateHVComparator();
	
	/**
	 * ���ݸ��ඨ��ıȽ��㷨����һ���Ƚ�����
	 * �ñȽ���Ӧ���Ȱ����ε�Y��������
	 * ����Y������ͬ�ģ���X��������
	 * @return һ���Ƚ���
	 */
	public Comparator<?> generateVHComparator();
	
	/**
	 * �Ծ����б��Ȱ�Y�����С��������
	 * ����Y���꼸����ͬ�İ�X�����С��������
	 * @param rects Ҫ����ľ��ε��б�
	 */
	public void sortVH(List<? extends Rectangle> rects);
	
	/**
	 * �Ծ����б��Ȱ�X�����С��������
	 * ����X���꼸����ͬ�İ�Y�����С��������
	 * @param rects Ҫ����ľ��ε��б�
	 */
	public void sortHV(List<? extends Rectangle> rects);
}
