package chapter5.springMVC.web.service;

import java.util.List;

import chapter5.springMVC.web.domain.TestDomain;

public interface IService {
	public List<TestDomain> getTestList(int start, int end);

	public TestDomain getOneDoaminById(String id);

	public boolean saveDomain(TestDomain td);
	
	public List<TestDomain> getTestList();

}
