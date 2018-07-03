package responsibilityMode;

/**
 * 责任链模式，将一个任务按照一定顺序并选择向下处理，而且处理单元可以抽象化。
 * 适用场景：需要顺序经过一些处理的任务，处理的设计可以使用，还有拦截器也是使用了对应设计
 * 对应实例：ESB适配处理流程的基础服务就是应用了责任链模式,
 * @author Jay
 * @date 2017年4月28日
 */
public class RespsibilityChainMode {
	public static void main(String[] args){
		IHandleUnit<Mission> u1 = new HandleUnit1();
		IHandleUnit<Mission> u2 = new HandleUnit2();
		IHandleUnit<Mission> u3 = new HandleUnit3();
		Mission m = new Mission1();
		m = u1.invoke(m);
		m = u2.invoke(m);
		m = u3.invoke(m);
		
	}
}

interface IHandleUnit<M>{
	public M invoke(M m);
}

abstract class IHandleUnitAbClass<M> implements IHandleUnit<M>{
	String unitName;
}

class HandleUnit1 extends IHandleUnitAbClass<Mission>{
	String unitName = "unit1";
	@Override
	public Mission invoke(Mission m) {
		System.out.println("处理单元" + unitName +"正在处理" + m.getName());
		m.setName(unitName + m.getName());
		return m;
	}
	
}

class HandleUnit2 extends IHandleUnitAbClass<Mission>{
	String unitName = "unit2";
	@Override
	public Mission invoke(Mission m) {
		System.out.println("处理单元" + unitName +"正在处理" + m.getName());
		m.setName(unitName + m.getName());
		return m;
	}
	
}


class HandleUnit3 extends IHandleUnitAbClass<Mission>{
	String unitName = "unit3";
	@Override
	public Mission invoke(Mission m) {
		System.out.println("处理单元" + unitName +"正在处理" + m.getName());
		m.setName(unitName + m.getName());
		return m;
	}
	
}


interface Mission{
	public String getName();
	public void setName(String name);
}

class Mission1 implements Mission{
	String name = "mession";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}



