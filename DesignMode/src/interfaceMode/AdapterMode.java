package interfaceMode;

import java.io.InputStream;

/**
 * 项目需要使用新接口或是类时，但是原来就有相应功能的接口和类的实现，这时就可以用到适配器模式。
 * @author Jay
 *
 */
public class AdapterMode {

	public static void main(String[] args) {

	}
}

/**
 * 项目所需的新接口
 * @author Jay
 * @date 2017年4月26日
 */
interface XmlReader {
	public InputStream xmlReader();
}

/**
 * 项目原有的接口
 * @author Jay
 * @date 2017年4月26日
 */
interface ReaderXml {
	public InputStream readerXml();
}

/**
 * 项目原有功能的实现类
 * @author Jay
 * @date 2017年4月26日
 */
class B implements ReaderXml{

	public InputStream readerXml() {
		return null;
	}
}

/**
 * 适配器模式第一种实现
 * @author Jay
 */
class Adapter1 extends B implements XmlReader{
	public InputStream xmlReader(){
		return readerXml();
	} 
}

/**
 * 适配器模式第二种实现
 * @author Jay
 */
class Adapter2 implements XmlReader {
	ReaderXml b = new B();
	public InputStream xmlReader() {
		return b.readerXml();
	}
}
