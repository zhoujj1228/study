package interfaceMode;

import java.io.InputStream;

/**
 * ��Ŀ��Ҫʹ���½ӿڻ�����ʱ������ԭ��������Ӧ���ܵĽӿں����ʵ�֣���ʱ�Ϳ����õ�������ģʽ��
 * @author Jay
 *
 */
public class AdapterMode {

	public static void main(String[] args) {

	}
}

/**
 * ��Ŀ������½ӿ�
 * @author Jay
 * @date 2017��4��26��
 */
interface XmlReader {
	public InputStream xmlReader();
}

/**
 * ��Ŀԭ�еĽӿ�
 * @author Jay
 * @date 2017��4��26��
 */
interface ReaderXml {
	public InputStream readerXml();
}

/**
 * ��Ŀԭ�й��ܵ�ʵ����
 * @author Jay
 * @date 2017��4��26��
 */
class B implements ReaderXml{

	public InputStream readerXml() {
		return null;
	}
}

/**
 * ������ģʽ��һ��ʵ��
 * @author Jay
 */
class Adapter1 extends B implements XmlReader{
	public InputStream xmlReader(){
		return readerXml();
	} 
}

/**
 * ������ģʽ�ڶ���ʵ��
 * @author Jay
 */
class Adapter2 implements XmlReader {
	ReaderXml b = new B();
	public InputStream xmlReader() {
		return b.readerXml();
	}
}
