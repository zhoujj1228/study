package interfaceMode;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ģʽ��������ϳ����νṹ�Ա�ʾ������-���塯�Ĳ�νṹ��
 * ���ģʽʹ���û��Ե����������϶����ʹ�þ���һ���ԡ��������ͽṹ�����ӽڵ�ʱ����ʶ������֦������Ҷ
 * ���ó������������������ֲ����������εĽṹʱ���Լ�ϣ���û����Ժ�����϶����뵥������Ĳ�ͬʱ��ͳһ��ʹ����Ͻṹ�е����ж���ʱ
 * @author Jay
 * @date 2017��4��28��
 */
public class CompositeMode {

	public static void main(String[] args){
		//ʵ����Ŀ¼��Ŀ¼��ǽڵ㣬ֱ�ӶԽڵ�������ÿ���Ŀ¼����Ŀ¼�����ʹ�����ģʽ
		Node rootContext = new Context();
		rootContext.setName("��Ŀ¼");
		Node oneContext = new Context();
		oneContext.setName("1Ŀ¼");
		Node twoContext = new Context();
		twoContext.setName("2Ŀ¼");
		Node oneItem = new ContextItem();
		oneItem.setName("1Ŀ¼��");
		oneContext.add(oneItem);
		rootContext.add(oneContext);
		rootContext.add(twoContext);
		rootContext.itor("  ");
		
		//�ӿ���ʵ������ı�������,�ӿ�����ȫ�ĳ���Ӧ��ӵ�б��������Խӿ����е����Զ��ǳ�������ֹ�ȶ�����д
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
