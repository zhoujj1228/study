import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		String[] str = new String[8];
		int i = 7 & 100;
		System.out.println(i);
		System.out.println("begin");
		HashMap<String, String> testMap = new HashMap<String, String>();
		testMap.put("111", "aaa");
		testMap.get("111");
		System.out.println("end");
	}

}
