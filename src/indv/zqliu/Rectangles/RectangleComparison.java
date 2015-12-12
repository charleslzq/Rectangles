package indv.zqliu.Rectangles;

import java.util.Comparator;

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
	 */
	public boolean isOnLeft(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ��ھ���ro2���Ϸ�
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2���Ϸ�������Ϊfalse
	 */
	public boolean isOnTop(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����Ϸ����������������Ϸ��ľ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�����Ϸ�������Ϊfalse
	 */
	public boolean isOnTopLeft(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ��ھ���ro2�����Ϸ����������������󷽵ľ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2����ࣻ����Ϊfalse
	 */
	public boolean isOnLeftTop(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�����
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2����룻����Ϊfalse
	 */
	public boolean isLeftAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�Ҷ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�Ҷ��룻����Ϊfalse
	 */
	public boolean isRightAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�϶���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�϶��룻����Ϊfalse
	 */
	public boolean isTopAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�¶���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�¶��룻����Ϊfalse
	 */
	public boolean isBottomAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�ڴ�ֱ���������Ķ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2�ڴ�ֱ���������Ķ��룻����Ϊfalse
	 */
	public boolean isMiddleAligmentVertically(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2��ˮƽ���������Ķ���
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2��ˮƽ���������Ķ��룻����Ϊfalse
	 */
	public boolean isMiddleAligmentHorizontally(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������ro2�ܱ���Ϊͬһ������
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2���Ա���Ϊͬһ�����Σ�����Ϊfalse
	 */
	public boolean isSameRectangle(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������ж�ro1��ro2�Ƿ���ˮƽ����������
	 * @param ro1 ��һ������
	 * @param ro2 �ڶ�������
	 * @return true����������������ģ����򷵻�false
	 */
	public boolean isConnectedHorizontally(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������ж�ro1��ro2�Ƿ��ڴ�ֱ����������
	 * @param ro1 ��һ������
	 * @param ro2 �ڶ�������
	 * @return true����������������ģ����򷵻�false
	 */
	public boolean isConnectedVertically(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ񱻾���ro2������
	 * @param ro1 ��һ������ 
	 * @param ro2 �ڶ�������
	 * @return true, ���ro1��ro2������������Ϊfalse
	 */
	public boolean isContainedBy(Rectangle ro1, Rectangle ro2);
	
	/**
	 * �˷��������жϾ���ro1�Ƿ������(x,y)
	 * @param ro ���� 
	 * @param x ��ĺ�����
	 * @param y ��ĺ�����
	 * @return true, ���ro�����õ㣻����Ϊfalse
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
}