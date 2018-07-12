package singleton;

/**
 * 1.����һ����(class)����ȴ�ֱ������Ͷ���Щ�����Լ����������ЩԼ���Ĵ���Ҳ�����ö�����͵ļ���ԡ���ȫ���Լ������
 * 2.���췽��ֻ�ܱ�����������
 * 
 * ʵ������ʹ�ùؼ���enum����ö�����Ͳ�����󣬱�������Ϊ��������һ����ص��࣬�����̳���Java API�е�java.lang.Enum��
 * @author Jay
 * @date 2018��7��12��
 */
public enum MySingleton {
	INSTANCE;
	int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
