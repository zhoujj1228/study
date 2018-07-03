package responsibilityMode;

/**
 * ������ģʽ����һ��������һ��˳��ѡ�����´������Ҵ���Ԫ���Գ��󻯡�
 * ���ó�������Ҫ˳�򾭹�һЩ��������񣬴������ƿ���ʹ�ã�����������Ҳ��ʹ���˶�Ӧ���
 * ��Ӧʵ����ESB���䴦�����̵Ļ����������Ӧ����������ģʽ,
 * @author Jay
 * @date 2017��4��28��
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
		System.out.println("����Ԫ" + unitName +"���ڴ���" + m.getName());
		m.setName(unitName + m.getName());
		return m;
	}
	
}

class HandleUnit2 extends IHandleUnitAbClass<Mission>{
	String unitName = "unit2";
	@Override
	public Mission invoke(Mission m) {
		System.out.println("����Ԫ" + unitName +"���ڴ���" + m.getName());
		m.setName(unitName + m.getName());
		return m;
	}
	
}


class HandleUnit3 extends IHandleUnitAbClass<Mission>{
	String unitName = "unit3";
	@Override
	public Mission invoke(Mission m) {
		System.out.println("����Ԫ" + unitName +"���ڴ���" + m.getName());
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



