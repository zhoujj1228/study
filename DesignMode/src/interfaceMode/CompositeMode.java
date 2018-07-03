package interfaceMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式将对象组合成树形结构以表示‘部分-整体’的层次结构。
 * 组合模式使得用户对单个对象和组合对象的使用具有一致性。就像树型结构，增加节点时不用识别是树枝还是树叶
 * 适用场景：当需求中是体现部分与整体层次的结构时，以及希望用户可以忽略组合对象与单个对象的不同时，统一地使用组合结构中的所有对象时
 * @author Jay
 * @date 2017年4月28日
 */
public class CompositeMode {

	public static void main(String[] args){
		//实例，目录与目录项都是节点，直接对节点操作不用看是目录还是目录项，可以使用组合模式
		Node rootContext = new Context();
		rootContext.setName("根目录");
		Node oneContext = new Context();
		oneContext.setName("1目录");
		Node twoContext = new Context();
		twoContext.setName("2目录");
		Node oneItem = new ContextItem();
		oneItem.setName("1目录项");
		oneContext.add(oneItem);
		rootContext.add(oneContext);
		rootContext.add(twoContext);
		rootContext.itor("  ");
		
		//接口与实现子类的变量问题,接口是完全的抽象不应该拥有变量，所以接口所有的属性都是常量并且止咳读不可写
		System.out.println(oneContext.getSubNodes());
		System.out.println(oneContext.subNodes);
			
	}
	
}

interface Node{
	String name = "p";
	List<Node> subNodes = null;
	public void add(Node node);
	public abstract void itor(String offset);
	public String getName();
	public void setName(String name);
	public List<Node> getSubNodes();
	public void setSubNodes(List<Node> subNodes);
	public void deleteSubNode(String name);
}

class Context implements Node{
	String name;
	public List<Node> subNodes = new ArrayList<Node>();
	public void itor(String offset) {
		if(subNodes != null){
			System.out.println(offset + name);
			for(Node node : subNodes){
				node.itor(offset+offset);
			}
		}
	}
	public void deleteSubNode(String name){
		for(Node node : subNodes){
			if(name.equals(node.getName())){
				subNodes.remove(node);
			}
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Node> getSubNodes() {
		return subNodes;
	}
	public void setSubNodes(List<Node> subNodes) {
		this.subNodes = subNodes;
	}
	@Override
	public void add(Node node) {
		if(node != null){
			subNodes.add(node);
		}
	}
	
}

class ContextItem implements Node{
	String name;
	List<Node> subNodes = null;
	public void itor(String offset) {
		System.out.println(offset + name);
	}
	public void deleteSubNode(String name){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Node> getSubNodes() {
		return subNodes;
	}
	public void setSubNodes(List<Node> subNodes) {
		this.subNodes = subNodes;
	}
	@Override
	public void add(Node node) {
	}
	
	
}
