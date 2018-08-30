package test.extend;

import org.springframework.stereotype.Service;

@Service
public class Son extends Father{
    public void test(){
        service.test();
    }
}
