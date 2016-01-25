package indv.zqliu.rectangle.comparison;

import indv.zqliu.rectangle.RectangleComparable;
import indv.zqliu.rectangle.RectangleComparison;

import java.util.Comparator;



/**
 * ���εıȽ��������ڽ������Ȱ�Y�����С��������
 * ����Y�������һ������X�����С��������
 * ��Ҫ��JAVA�ڲ�����ʽ��Ϊ֮ǰ�Ĺ鲢�����㷨��Tim��������
 * @author zqliu
 * @version 1.0
 */
class VhComparator implements Comparator<RectangleComparable> {
  RectangleComparison rc;
  
  public VhComparator(RectangleComparison method) {
    rc = method;
  }

  @Override
  public int compare(RectangleComparable ro1, RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (rc.isOnTopLeft(ro1, ro2)) {
      return -1;
    }
    if (rc.isOnTopLeft(ro2, ro1)) {
      return 1;
    }
    return 0;
  }

}

