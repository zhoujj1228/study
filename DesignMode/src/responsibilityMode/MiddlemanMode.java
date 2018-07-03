package responsibilityMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 中介者模式是将复杂的交互通过增加一个中介者使得简化，并且容易管理
 * 适用场景：多个对象交互关系复杂时
 * 应用实例：例如男的想去相亲，需要先问父母，再问对方女方父母，再问女方
 * @author Jay
 * @date 2017年6月9日
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
		if(msg.equals("想去相亲")){
			boolean isAgree = reqParentAgree(people);
			if(isAgree){
				System.out.println("放入代介绍队列");
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
			System.out.println("缺少男的");
		}else if(girls.size() == 0){
			System.out.println("缺少女的");
		}else{
			mans.remove(0);
			girls.remove(0);
			System.out.println("男女成功约会");
		}
	}
	public boolean reqParentAgree(People p){
		boolean isAgree = map.get(p).isAgree();
		System.out.println("询问父母同意");
		if(isAgree){
			System.out.println("父母同意");
		}else{
			System.out.println("父母不同意");
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
		System.out.println("想去相亲");
		callMiddleman("想去相亲");
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
		System.out.println("想去相亲");
		callMiddleman("想去相亲");
	}
	private void callMiddleman(String msg) {
		mid.accept(msg, this);
	}
}
