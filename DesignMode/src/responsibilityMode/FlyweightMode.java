package responsibilityMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *内容描述：共享同一个对象，节约资源
 *适用场景：量多，实际使用同样的对象
 *应用实例：咖啡厅卖咖啡，无论订单多少实际是只有20种咖啡，所以理论上订单里咖啡对象可以重复利用（咖啡对象是不变的）；下面例子需优化，同时也显示了工厂模式的作用
 *@author Jay
 *@date 2017年7月11日
 */
public class FlyweightMode{
	//客户下的订单
	private static List<Order> orders=new ArrayList<Order>(100);
	//订单对象生成工厂
	private static FlavorFactory flavorFactory;
	//增加订单
	private static void takeOrders(String flavor){
		orders.add(flavorFactory.getOrder(flavor));
	}
	public static void main(String []args){
		//订单生成工厂
		flavorFactory=FlavorFactory.getInstance();
		//增加订单
		takeOrders("摩卡");
		takeOrders("卡布奇诺");
		takeOrders("香草星冰乐");
		takeOrders("香草星冰乐");
		takeOrders("拿铁");
		takeOrders("卡布奇诺");
		takeOrders("拿铁");
		takeOrders("卡布奇诺");
		takeOrders("摩卡");
		takeOrders("香草星冰乐");
		takeOrders("卡布奇诺");
		takeOrders("摩卡");
		takeOrders("香草星冰乐");
		takeOrders("拿铁");
		takeOrders("拿铁");
		//卖咖啡
		for(Order order:orders){
			order.sell();
			//打印生成的订单Java对象数量
			System.out.println("\n客户一共买了"+orders.size()+"杯咖啡!");
			//打印生成的订单Java对象数量
			System.out.println("\n共生成了"+flavorFactory.getTotalFlavorsMade()+"个FlavorOrderJava对象!");
		}
	}
}



abstract class Order{
	//执行卖出动作
	public abstract void sell();

	//获取咖啡口味
	public abstract String getFlavor();
}

class FlavorOrder extends Order{
	private String flavor;

	public FlavorOrder(String flavor){
		this.flavor=flavor;
	}

	public String getFlavor(){
		return this.flavor;
	}
	public void sell(){
		System.out.println("卖出一杯["+flavor+"]");
	}
}
class FlavorFactory{
	//订单池
	private Map<String ,Order> flavorPool=new HashMap<String ,Order>(20);
	//静态工厂,负责生成订单对象
	private static FlavorFactory flavorFactory=new FlavorFactory();
	private FlavorFactory(){}
	public static FlavorFactory getInstance(){
		return flavorFactory;
	}
	//获得订单
	public Order getOrder(String flavor){
		Order order=null;
		if(flavorPool.containsKey(flavor)){
			order=flavorPool.get(flavor);
			}else{
				//获得新口味订单
				order=new FlavorOrder(flavor);
				//放入对象池
				flavorPool.put(flavor,order);
				}
		return order;
		}
	//获得已经卖出的咖啡全部口味数量
	public int getTotalFlavorsMade(){
		return flavorPool.size();
	}
}