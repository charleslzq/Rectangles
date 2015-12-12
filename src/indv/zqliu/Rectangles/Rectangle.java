package indv.zqliu.Rectangles;

/**
 * �˽ӿ����ڶ�����εĻ�����������
 * @author ������
 * @version 1.0
 */
public interface Rectangle {
	
	/**
	 * �õ��þ��κ��������Сֵ
	 * @return ���������Сֵ
	 */
	public double getMinX();
	
	/**
	 * �õ��þ��κ�������м�ֵ
	 * @return ��������м�ֵ
	 */
	public double getMidX();
	
	/**
	 * �õ��þ��κ���������ֵ
	 * @return ����������ֵ
	 */
	public double getMaxX();
	
	/**
	 * �õ��þ������������Сֵ
	 * @return ���������Сֵ
	 */
	public double getMinY();
	
	/**
	 * �õ��þ�����������м�ֵ
	 * @return ��������м�ֵ
	 */
	public double getMidY();
	
	/**
	 * �õ��þ�������������ֵ
	 * @return ����������ֵ
	 */
	public double getMaxY();
	
	/**
	 * �õ��þ��εĿ��
	 * @return ���εĿ��
	 */
	public double getWidth();
	
	/**
	 * �õ��þ��εĸ߶�
	 * @return ���εĸ߶�
	 */
	public double getHeight();
	
	/**
	 * �����趨���εĲ���
	 * @param x ���������Сֵ
	 * @param y ���������Сֵ
	 * @param w ���
	 * @param h �߶�
	 */
	public void setRect(double x, double y, double w, double h);
}
