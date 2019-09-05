import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> softList = new ArrayList<String>();
		SoftReference<List<String>> test = new SoftReference<List<String>>(softList);
		List<String> list = test.get();
	}

}
