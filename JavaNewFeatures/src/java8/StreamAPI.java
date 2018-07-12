package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * �����Stream��IO�е�Stream��ͬ�����ṩ�˶Լ��ϲ�������ǿ�����������˲������϶���ı�����
 * @author Jay
 * @date 2018��7��12��
 */
public class StreamAPI {
	
	public static List<Property> properties;
	static{
		Property p1 = new Property("���˸���", 1000, 500, 2);
	    Property p2 = new Property("��������ӹ�", 2300, 1500, 3);
	    Property p3 = new Property("���ʹ���", 580, 3000, 1);
	    Property p4 = new Property("�ϵ»�", 6000, 200, 4);
	    properties = Arrays.asList(p1, p2, p3, p4);
	}

	public static void main(String[] args) {
		new StreamAPI().parallelStream();
		new StreamAPI().collectGroupingBy();
		new StreamAPI().collectToAttrMap();
		new StreamAPI().collectToAttrList();
		new StreamAPI().collectToList();
		new StreamAPI().max();
		new StreamAPI().min();
		new StreamAPI().flatMap();
		new StreamAPI().map();
		new StreamAPI().sort();
		new StreamAPI().filter();
	}
	
	
	/**
	 * ���д����ﵽ�����ٶȣ�����Ҫע���Ƿ���Ҫʹ�ò��д���������д���ԭ��ʹ��fork/join���������ִ������
	 * ��ϲ��ķ�ʽ���е�
	 */
	private void parallelStream() {
		//ɸѡ���۸�ȼ�С��4�����վ��������2��������
		properties.stream()
	        .filter(p -> p.priceLevel < 4)
	        .sorted(Comparator.comparingInt(Property::getDistance))
	        .map(Property::getName)
	        .limit(2)
	        .collect(Collectors.toList());
		
		//���� parallelStream �������ܲ��д���
		properties.parallelStream()
	        .filter(p -> p.priceLevel < 4)
	        .sorted(Comparator.comparingInt(Property::getDistance))
	        .map(Property::getName)
	        .limit(2)
	        .collect(Collectors.toList());
	}



	private void collectGroupingBy() {
		Map<Integer, List<Property>> priceMap = properties.stream()
                .collect(Collectors.groupingBy(Property::getPriceLevel));
		System.out.println(priceMap);
	}



	private void collectToAttrMap() {
		Map<String, Integer> collect = properties.stream().
			collect(Collectors.toMap(Property::getName, Property::getPriceLevel));
		System.out.println(collect);
	}



	private void collectToAttrList() {

		List<String> collect = properties.stream()
                .map(p -> p.name)
                .collect(Collectors.toList());
		System.out.println(collect);
		
	}



	private void collectToList() {
		List<Property> collect = properties.stream()
                .filter(p -> p.sales > 1000)
                .collect(Collectors.toList());
		System.out.println(collect);
	}



	private void min() {
		Property property = properties.stream().min(Comparator.comparingInt(p -> p.priceLevel)).get();
		System.out.println("p.priceLevel��С:" + property.name + "\t" + property.priceLevel);
	}



	private void max() {
		Property property = properties.stream().max(Comparator.comparingInt(p -> p.priceLevel)).get();
		System.out.println("p.priceLevel���:" + property.name + "\t" + property.priceLevel);
	}



	/**
	 * ��ȡ�����Ĳ���
	 */
	private void flatMap() {
		//��ȡ��Щ�����г��ȴ���2�ĵ��ʸ���
		List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));
        
        long count = lists.stream()
        .flatMap(list -> list.stream())
        .filter(str -> str.length() > 2)
        .count();
        
        System.out.println("���ȴ���2�ĵ��ʸ���:" + count);
	}



	/**
	 * ��ʱ��������Ҫ�����д�����������ͽ���ת������ʱ��Ϳ���ʹ��map��������ɣ������е�ֵת��Ϊһ���µ���
	 * ����map��lambda���ʽ����һ��Property���͵Ĳ���������һ��String�� �����ͷ���ֵ��������ͬһ�����ͣ�����lambda���ʽ������Function�ӿڵ�һ��ʵ��
	 */
	private void map() {
		//�г����е��̵�����
		properties.stream().map(p -> p.name).forEach(pname -> {System.out.println(pname);});;
	}

	private void filter() {
	    
	    
		int count = 0;
		for (Property property : properties) {
		    if(property.sales > 1000){
		        count++;
		    }
		}
		System.out.println("����������1000�ĵ��̸���:" + count);
		
		long count2 = properties.stream()
                .filter(p -> p.sales > 1000)
                .count();
		System.out.println("����������1000�ĵ��̸���:" + count2);
	}

	private void sort() {
	    Collections.sort(properties, (x, y) -> x.distance.compareTo(y.distance));
	    String name = properties.get(0).name;
	    System.out.println("����������ĵ�����:" + name);
	    
	    // Stream����
	    String name2 = properties.stream()
	                    .sorted(Comparator.comparingInt(x -> x.distance))
	                    .findFirst()
	                    .get().name;
	    System.out.println("����������ĵ�����:" + name2);
	}
	
	

}

class Property {
    String  name;
    // ���룬��λ:��
    Integer distance;
    // ����������
    Integer sales;
    // �۸�����������дһ���������۸��
    Integer priceLevel;
    public Property(String name, int distance, int sales, int priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getPriceLevel() {
		return priceLevel;
	}
	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}
    
}
