package chapter5.springMVC.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import chapter5.springMVC.web.domain.TestDomain;

@Component
public class SimpleService implements IService{
	public static List<TestDomain> testList = createTestList(10);
	
	
	@Override
	public List<TestDomain> getTestList(int start, int end) {
		return testList.subList(start, end+1);
	}
	
	public static List<TestDomain> createTestList(int num) {
		List<TestDomain> result = new ArrayList<TestDomain>();
		TestDomain test;
		for(int i = 0; i < num; i++){
			test = new TestDomain("id" + i,"name" + i);
			test.setAge(i);
			result.add(test);
		}
		return result;
	}

	@Override
	public TestDomain getOneDoaminById(String id) {
		for(TestDomain td : testList){
			if(td.getId().equals(id)){
				return td;
			}
		}
		return null;
	}

	@Override
	public boolean saveDomain(TestDomain td) {
		if(testList != null){
			testList.add(td);
			return true;
		}
		return false;
	}

	@Override
	public List<TestDomain> getTestList() {
		return testList;
	}

}
