package indv.zqliu.rectangle.comparison;

import indv.zqliu.rectangle.RectangleComparable;
import indv.zqliu.rectangle.RectangleComparison;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

/**
 * ���������ṩ���αȽϺ������жϵ�Ĭ�ϲ�����
 * �����࣬����Ĭ�ϡ�
 * ��Ҫ�ı������ʹ��LocalRectangleComparator.
 * Y������ϵ��£�X��������ұ��
 * @author ������
 * @version 1.0
 */
public class DefaultRectangleComparator implements RectangleComparison {
  private final double threshold;
  private final ApproximateCalculator  ac;
  private static DefaultRectangleComparator instance;
  
  private DefaultRectangleComparator(double th, double er) {
    if (th < 0) {
      throw new NullPointerException("Threshold should not be less than 0.");
    }
    threshold = th;
    ac = new ApproximateCalculator(er);
  }
  
  /**.
   * 返回默认矩形比较器实例，参数由配置文件指定
   * @return 默认举行比较器实例
   */
  public static DefaultRectangleComparator getInstance() {
    if (instance == null) {
      Properties properties = new Properties();
      try {
        FileInputStream fis = new FileInputStream(
            "resources/DefaultRectangleComparisonSetting.xml");
        properties.loadFromXML(fis);
        double threshold = Double.valueOf(properties.getProperty("Threshold"));
        double error = Double.valueOf(properties.getProperty("Error"));
        instance = new DefaultRectangleComparator(threshold,error);
      } catch (NullPointerException iae) {
        iae.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return instance;
  }

  @Override
  public void setThreshold(double th) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Threshold can't be changed. Using LocalRectangleComparator instead.");
  }
  

  @Override
  public double getThreshold() {
    // TODO Auto-generated method stub
    return threshold;
  }
  
  public boolean equalWithInLineWidth(double ap, double bp) {
    return Math.abs(ap - bp) <= threshold;
  }

  @Override
  public boolean isOnLeft(RectangleComparable ro1, RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return ac.strongLess(ro1.getMinX() + threshold, ro2.getMinX());
  }

  @Override
  public boolean isOnTop(RectangleComparable ro1, RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return ac.strongLess(ro1.getMinY() + threshold, ro2.getMinY());
  }

  @Override
  public boolean isLeftAlignment(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.equalWithInLineWidth(ro1.getMinX(), ro2.getMinX());
  }

  @Override
  public boolean isRightAlignment(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.equalWithInLineWidth(ro1.getMaxX(), ro2.getMaxX());
  }

  @Override
  public boolean isTopAlignment(RectangleComparable ro1, RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.equalWithInLineWidth(ro1.getMinY(), ro2.getMinY());
  }

  @Override
  public boolean isBottomAlignment(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.equalWithInLineWidth(ro1.getMaxY(), ro2.getMaxY());
  }

  @Override
  public boolean isSameRectangle(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.isLeftAlignment(ro1, ro2)
        && this.isTopAlignment(ro1, ro2)
        && this.isRightAlignment(ro1, ro2)
        && this.isBottomAlignment(ro1, ro2);
  }

  @Override
  public boolean isContainedBy(RectangleComparable ro1, RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.isContainPoint(ro2, ro1.getMinX(), ro1.getMinY()) 
        && this.isContainPoint(ro2, ro1.getMaxX(), ro1.getMaxY());
  }

  @Override
  public boolean isContainPoint(RectangleComparable ro, double xp, double yp) {
    // TODO Auto-generated method stub
    if (ro == null || xp < 0 || yp < 0) {
      throw new NullPointerException("Rectangle cannot be null");
    }
    if (xp < 0 || yp < 0) {
      throw new IllegalArgumentException("Coordinates cannot be negative");
    }
    if (xp > ro.getMaxX()) {
      return false;
    }
    if (xp < ro.getMinX()) {
      return false;
    }
    if (yp > ro.getMaxY()) {
      return false;
    }
    if (yp < ro.getMinY()) {
      return false;
    }
    return true;
  }

  @Override
  public boolean isMiddleAligmentVertically(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.equalWithInLineWidth(ro1.getMidY(), ro2.getMidY());
  }

  @Override
  public boolean isMiddleAligmentHorizontally(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return this.equalWithInLineWidth(ro1.getMidX(), ro2.getMidX());
  }

  @Override
  public boolean isOnTopLeft(RectangleComparable ro1, RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    if (this.isTopAlignment(ro1, ro2)) {
      return this.isOnLeft(ro1, ro2);
    } else {
      return this.isOnTop(ro1, ro2);
    }
  }

  @Override
  public boolean isOnLeftTop(RectangleComparable ro1, RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    if (this.isLeftAlignment(ro1, ro2)) {
      return this.isOnTop(ro1, ro2);
    } else {
      return this.isOnLeft(ro1, ro2);
    }
  }

  @Override
  public Comparator<RectangleComparable> generateHvComparator() {
    // TODO Auto-generated method stub
    return new HvComparator((RectangleComparison)this);
  }

  @Override
  public Comparator<RectangleComparable> generateVhComparator() {
    // TODO Auto-generated method stub
    return new VhComparator((RectangleComparison)this);
  }
  
  @Override
  public boolean isConnectedHorizontally(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return ac.strongLess(Math.abs(ro1.getMaxX() - ro2.getMinX()), threshold);
  }

  @Override
  public boolean isConnectedVertically(RectangleComparable ro1,
      RectangleComparable ro2) {
    // TODO Auto-generated method stub
    if (ro1 == null || ro2 == null) {
      throw new NullPointerException("Argument can't be null");
    }
    return ac.strongLess(Math.abs(ro1.getMaxY() - ro2.getMinY()), threshold);
  }

  @Override
  public double getError() {
    // TODO Auto-generated method stub
    return ac.getErr();
  }
  
  @Override
  public void sortVh(List<? extends RectangleComparable> rects) {
    Comparator<RectangleComparable> cpt =  instance.generateVhComparator();
    Collections.sort(rects, cpt);
  }
  
  @Override
  public void sortHv(List<? extends RectangleComparable> rects) {
    Comparator<RectangleComparable> cpt =  instance.generateHvComparator();
    Collections.sort(rects, cpt);
  }

}
