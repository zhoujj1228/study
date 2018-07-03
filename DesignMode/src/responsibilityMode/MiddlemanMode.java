package responsibilityMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * �н���ģʽ�ǽ����ӵĽ���ͨ������һ���н���ʹ�ü򻯣��������׹���
 * ���ó�����������󽻻���ϵ����ʱ
 * Ӧ��ʵ���������е���ȥ���ף���Ҫ���ʸ�ĸ�����ʶԷ�Ů����ĸ������Ů��
 * @author Jay
 * @date 2017��6��9��
 */
public class MiddlemanMode {

	public static void main(String[] args) {
		Middleman md = new Middleman();
		Man man = new Man();
		Girl girl = new Girl();
		Parent mp = new Parent();
		Parent gp = new Parent();
		man.mid=md;
		girl.mid=md;
		md.registerParent(man, mp);
		md.registerParent(girl, gp);
		man.wantMeeting();
		md.createMeet();
		girl.wantMeeting();
		md.createMeet();
		
	}

}

class Middleman{
	HashMap<People, Parent> map = new HashMap<People, Parent>();
	List<Man> mans = new ArrayList<Man>();
	List<Girl> girls = new ArrayList<Girl>();
	public void accept(String msg, People people) {
		if(msg.equals("��ȥ����")){
			boolean isAgree = reqParentAgree(people);
			if(isAgree){
				System.out.println("��������ܶ���");
				if(people.getClass().equals(Man.class)){
					mans.add((Man) people);
				}else if(people.getClass().equals(Girl.class)){
					girls.add((Girl) people);
				}
			}
		}
	}
	public void createMeet(){
		if(mans.size() == 0){
			System.out.println("ȱ���е�");
		}else if(girls.size() == 0){
			System.out.println("ȱ��Ů��");
		}else{
			mans.remove(0);
			girls.remove(0);
			System.out.println("��Ů�ɹ�Լ��");
		}
	}
	public boolean reqParentAgree(People p){
		boolean isAgree = map.get(p).isAgree();
		System.out.println("ѯ�ʸ�ĸͬ��");
		if(isAgree){
			System.out.println("��ĸͬ��");
		}else{
			System.out.println("��ĸ��ͬ��");
		}
		return isAgree;
	}
	public void registerParent(People people, Parent parent){
		map.put(people, parent);
	}
	
}

abstract class People{
	
}

class Man extends People{
	Middleman mid;
	public void wantMeeting(){
		System.out.println("��ȥ����");
		callMiddleman("��ȥ����");
	}
	private void callMiddleman(String msg) {
		mid.accept(msg, this);
	}
}

class Parent extends People{
	public boolean isAgree(){
		if(Math.random() > 0.5){
			return true;
		}else{
			return false;
		}
	}
}

class Girl extends People{
	Middleman mid;
	public void wantMeeting(){
		System.out.println("��ȥ����");
		callMiddleman("��ȥ����");
	}
	private void callMiddleman(String msg) {
		mid.accept(msg, this);
	}
}
