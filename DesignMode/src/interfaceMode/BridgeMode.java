package interfaceMode;

/**
 * �Ž�ģʽ��Ϊ��ʵ�ֳ��󲿷���ʵ�ֲ������ʹ���Ǹ��Կ��Զ����ر仯��
 * ���ó�����һ������ģ��ʹ�õ��ܶ��࣬��Щ����Խ��г�������������ʵ�ֹ��̿��Գ��󻯣�ͨ�����ʵ��ԭ�й���
 * ��Ҫ���ã����Ա�������������̬����ϵ����϶Ƚ���
 * @author Jay
 * @date 2017��4��28��
 */
public class BridgeMode {
	public static void main(String[] args) {
		Brush brush = new BigBrush();
		brush.setColor(new Blue());
		brush.paint();
		SmallBrush smallBrush = new SmallBrush();
		smallBrush.setColor(new Blue());
		smallBrush.paint();

		// �̳лḲ�Ƿ������Ḳ�����ԣ�Ҳ�������Իᱣ����������ø��෽����������Ȼ�Ǹ����ֵ		
		brush = new BigBrush();
		brush.setColor(new Red());
		brush.paint();
		smallBrush = new SmallBrush();
		smallBrush.setColor(new Red());
		smallBrush.paint();
	}
}

abstract class Brush{
	Color color = null;
	public abstract void paint();
	public abstract Color getColor();
	public abstract void setColor(Color color);
}
abstract class Color{
	String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

class BigBrush extends Brush{

	public void paint() {
		System.out.println("ʹ�ô��ˢˢ����" + getColor().getColor() + "��ɫ");
	}
	@Override
	public Color getColor() {
		return color;
	}
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}

class SmallBrush extends Brush{

	public void paint() {
		System.out.println("ʹ��С��ˢˢ����" + getColor().getColor() + "��ɫ");
	}
	@Override
	public Color getColor() {
		return color;
	}
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}

class Red extends Color{
	String color = "Red";
	/*public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
*/}

class Blue extends Color{
	String color = "Blue";
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

class Green extends Color{
	String color = "Green";
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}


