package interfaceMode;

/**
 * 外观模式（Facade pattern）为子系统提供了一个更高层次、更简单的接口，
 * 应用场景：1、为一个比较复杂的子系统提供一个简单的接口。2、将客户程序与子系统的实现部分分离，提高子系统的独立性和可移植性。3、简化子系统间的依赖关系。
 * 主要作用：降低了子系统的复杂度和依赖。这使得子系统更易于使用和管理。
 * 简单描述：外观是一个能为子系统和客户提供简单接口的类。
 * 注意事项：1、在设计外观时，不需要增加额外的功能。2、不要从外观方法中返回子系统中的组件给客户。
 * 区别中介者模式在于 外观模式更多是委托，提供一个接口给外调用，具体实现委托给子系统完成；而中介者模式更多是调度，解决多对多的问题，如MVC
 * @author Jay
 * @date 2017年4月27日
 */
public class FacadeMode {

	public static void main(String[] args) {
		new Client().register();
	}

}

class Client{
	private String name;
	private String address;
	private String account;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public boolean register(){
		return new CustomerManagerFacade().registerClient(name, address, account);
	}
}

class CustomerManagerFacade{
	/**
	 * 进行注册，检验用户名是否重复，地址是否有问题，账户是否重复，全部通过后进行注册保存信息
	 * @param name
	 * @param address
	 * @param account
	 * @return 是否注册成功
	 */
	public boolean registerClient(String name, String address, String account){
		NameManager nameManager = new NameManager();
		AddressManager addressManager = new AddressManager();
		AccountManager accountManager = new AccountManager();
		if(!nameManager.isValid(name)){
			System.out.println("用户名校验不通过");
			return false;
		}
		if(!addressManager.isValid(address)){
			System.out.println("地址校验不通过");
			return false;
		}
		if(!accountManager.isValid(account)){
			System.out.println("用户名校验不通过");
			return false;
		}
		nameManager.saveData();
		addressManager.saveData();
		accountManager.saveData();
		return true;
	}
}

class NameManager{
	public boolean isValid(String name){
		return true;
	}
	public boolean saveData(){
		return true;
	}
}

class AddressManager{
	public boolean isValid(String address){
		return true;
	}
	public boolean saveData(){
		return true;
	}
}

class AccountManager{
	public boolean isValid(String accout){
		return true;
	}
	public boolean saveData(){
		return true;
	}
}


