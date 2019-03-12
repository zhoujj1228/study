package java7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��try�ﶨ�������Զ��رգ�������д�ر�
 * 
 * @author Jay
 * @date 2019��3��8��
 */
public class AutoCloseIO {
	public static void main(String[] args) {
		new AutoCloseIO().call();
	}

	private void call() {
		File file = new File("");
		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
