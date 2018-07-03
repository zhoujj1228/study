package interfaceMode;

/**
 * 桥接模式是为了实现抽象部分与实现部分脱耦，使它们各自可以独立地变化。
 * 适用场景：一个功能模块使用到很多类，这些类可以进行抽象出来，具体的实现过程可以抽象化，通过组合实现原有功能
 * 主要作用：可以避免类和类产生静态的联系，耦合度降低
 * @author Jay
 * @date 2017年4月28日
 */
public class BridgeMode {
	public static void main(String[] args) {
		Brush brush = new BigBrush();
		brush.setColor(new Blue());
		brush.paint();
		SmallBrush smallBrush = new SmallBrush();
		smallBrush.setColor(new Blue());
		smallBrush.paint();

		// 继承会覆盖方法不会覆盖属性，也就是属性会保留，如果调用父类方法操作的仍然是父类的值		
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
		System.out.println("使用大笔刷刷出了" + getColor().getColor() + "颜色");
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
		System.out.println("使用小笔刷刷出了" + getColor().getColor() + "颜色");
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


