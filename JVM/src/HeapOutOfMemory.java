import java.util.ArrayList;
import java.util.List;

/**
 * �����
 * VM args : -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * @author Jay
 * @date 2018��3��19��
 */
public class HeapOutOfMemory {

	public static void main(String[] args){ 
			List<HeapOutOfMemory> list = new ArrayList<HeapOutOfMemory>();
			while(true){ 
				list.add(new HeapOutOfMemory()); 
			} 
	}

}
