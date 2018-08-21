package fatherAndSon;

/**
 * 主要测试父类声明与子类实现的同一方法的调用情况
 * @author Jay
 * @date 2018年8月21日
 */
public class FatherAndSonTest {
    public static void main(String[] args) {
        Father p = new Son();
        System.out.println(p.age());
    }
}
