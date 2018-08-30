package test.extend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import util.SpringContextUtil;

/**
 * ��Ҫ���ڲ��Լ��鸸������ע������
 * @author Jay
 * @date 2018��8��22��
 */

@Component
public class ExtendTest {
    @Autowired
    private Son son;
    

    public static void main(String[] args) {
        new ExtendTest().call();
    }

    private void call() {
        ApplicationContext springContext = SpringContextUtil.getAnnotationSpringContext(ExtendConfig.class);
        ExtendTest et = springContext.getBean(ExtendTest.class);
        et.getSon().test();
        System.out.println("123");
    }
    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }
}
