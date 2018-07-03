package responsibilityMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *��������������ͬһ�����󣬽�Լ��Դ
 *���ó��������࣬ʵ��ʹ��ͬ���Ķ���
 *Ӧ��ʵ���������������ȣ����۶�������ʵ����ֻ��20�ֿ��ȣ����������϶����￧�ȶ�������ظ����ã����ȶ����ǲ���ģ��������������Ż���ͬʱҲ��ʾ�˹���ģʽ������
 *@author Jay
 *@date 2017��7��11��
 */
public class FlyweightMode{
	//�ͻ��µĶ���
	private static List<Order> orders=new ArrayList<Order>(100);
	//�����������ɹ���
	private static FlavorFactory flavorFactory;
	//���Ӷ���
	private static void takeOrders(String flavor){
		orders.add(flavorFactory.getOrder(flavor));
	}
	public static void main(String []args){
		//�������ɹ���
		flavorFactory=FlavorFactory.getInstance();
		//���Ӷ���
		takeOrders("Ħ��");
		takeOrders("������ŵ");
		takeOrders("����Ǳ���");
		takeOrders("����Ǳ���");
		takeOrders("����");
		takeOrders("������ŵ");
		takeOrders("����");
		takeOrders("������ŵ");
		takeOrders("Ħ��");
		takeOrders("����Ǳ���");
		takeOrders("������ŵ");
		takeOrders("Ħ��");
		takeOrders("����Ǳ���");
		takeOrders("����");
		takeOrders("����");
		//������
		for(Order order:orders){
			order.sell();
			//��ӡ���ɵĶ���Java��������
			System.out.println("\n�ͻ�һ������"+orders.size()+"������!");
			//��ӡ���ɵĶ���Java��������
			System.out.println("\n��������"+flavorFactory.getTotalFlavorsMade()+"��FlavorOrderJava����!");
		}
	}
}



abstract class Order{
	//ִ����������
	public abstract void sell();

	//��ȡ���ȿ�ζ
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
		System.out.println("����һ��["+flavor+"]");
	}
}
class FlavorFactory{
	//������
	private Map<String ,Order> flavorPool=new HashMap<String ,Order>(20);
	//��̬����,�������ɶ�������
	private static FlavorFactory flavorFactory=new FlavorFactory();
	private FlavorFactory(){}
	public static FlavorFactory getInstance(){
		return flavorFactory;
	}
	//��ö���
	public Order getOrder(String flavor){
		Order order=null;
		if(flavorPool.containsKey(flavor)){
			order=flavorPool.get(flavor);
			}else{
				//����¿�ζ����
				order=new FlavorOrder(flavor);
				//��������
				flavorPool.put(flavor,order);
				}
		return order;
		}
	//����Ѿ������Ŀ���ȫ����ζ����
	public int getTotalFlavorsMade(){
		return flavorPool.size();
	}
}