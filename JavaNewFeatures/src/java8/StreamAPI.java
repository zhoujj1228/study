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
 * 这里的Stream和IO中的Stream不同，它提供了对集合操作的增强，极大的提高了操作集合对象的便利性
 * @author Jay
 * @date 2018年7月12日
 */
public class StreamAPI {
	
	public static List<Property> properties;
	static{
		Property p1 = new Property("叫了个鸡", 1000, 500, 2);
	    Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
	    Property p3 = new Property("永和大王", 580, 3000, 1);
	    Property p4 = new Property("肯德基", 6000, 200, 4);
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
	 * 并行处理，达到更快速度，但是要注意是否需要使用并行处理，这个并行处理原理使用fork/join进行任务拆分处理，完成
	 * 后合并的方式进行的
	 */
	private void parallelStream() {
		//筛选出价格等级小于4，按照距离排序的2个店铺名
		properties.stream()
	        .filter(p -> p.priceLevel < 4)
	        .sorted(Comparator.comparingInt(Property::getDistance))
	        .map(Property::getName)
	        .limit(2)
	        .collect(Collectors.toList());
		
		//调用 parallelStream 方法即能并行处理
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
		System.out.println("p.priceLevel最小:" + property.name + "\t" + property.priceLevel);
	}



	private void max() {
		Property property = properties.stream().max(Comparator.comparingInt(p -> p.priceLevel)).get();
		System.out.println("p.priceLevel最大:" + property.name + "\t" + property.priceLevel);
	}



	/**
	 * 提取子流的操作
	 */
	private void flatMap() {
		//获取这些数据中长度大于2的单词个数
		List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));
        
        long count = lists.stream()
        .flatMap(list -> list.stream())
        .filter(str -> str.length() > 2)
        .count();
        
        System.out.println("长度大于2的单词个数:" + count);
	}



	/**
	 * 有时候我们需要将流中处理的数据类型进行转换，这时候就可以使用map方法来完成，将流中的值转换为一个新的流
	 * 传给map的lambda表达式接收一个Property类型的参数，返回一个String。 参数和返回值不必属于同一种类型，但是lambda表达式必须是Function接口的一个实例
	 */
	private void map() {
		//列出所有店铺的名称
		properties.stream().map(p -> p.name).forEach(pname -> {System.out.println(pname);});;
	}

	private void filter() {
	    
	    
		int count = 0;
		for (Property property : properties) {
		    if(property.sales > 1000){
		        count++;
		    }
		}
		System.out.println("月销量大于1000的店铺个数:" + count);
		
		long count2 = properties.stream()
                .filter(p -> p.sales > 1000)
                .count();
		System.out.println("月销量大于1000的店铺个数:" + count2);
	}

	private void sort() {
	    Collections.sort(properties, (x, y) -> x.distance.compareTo(y.distance));
	    String name = properties.get(0).name;
	    System.out.println("距离我最近的店铺是:" + name);
	    
	    // Stream操作
	    String name2 = properties.stream()
	                    .sorted(Comparator.comparingInt(x -> x.distance))
	                    .findFirst()
	                    .get().name;
	    System.out.println("距离我最近的店铺是:" + name2);
	}
	
	

}

class Property {
    String  name;
    // 距离，单位:米
    Integer distance;
    // 销量，月售
    Integer sales;
    // 价格，这里简单起见就写一个级别代表价格段
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
