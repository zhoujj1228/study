package interfaceMode;

/**
 * ���ģʽ��Facade pattern��Ϊ��ϵͳ�ṩ��һ�����߲�Ρ����򵥵Ľӿڣ�
 * Ӧ�ó�����1��Ϊһ���Ƚϸ��ӵ���ϵͳ�ṩһ���򵥵Ľӿڡ�2�����ͻ���������ϵͳ��ʵ�ֲ��ַ��룬�����ϵͳ�Ķ����ԺͿ���ֲ�ԡ�3������ϵͳ���������ϵ��
 * ��Ҫ���ã���������ϵͳ�ĸ��ӶȺ���������ʹ����ϵͳ������ʹ�ú͹���
 * �������������һ����Ϊ��ϵͳ�Ϳͻ��ṩ�򵥽ӿڵ��ࡣ
 * ע�����1����������ʱ������Ҫ���Ӷ���Ĺ��ܡ�2����Ҫ����۷����з�����ϵͳ�е�������ͻ���
 * �����н���ģʽ���� ���ģʽ������ί�У��ṩһ���ӿڸ�����ã�����ʵ��ί�и���ϵͳ��ɣ����н���ģʽ�����ǵ��ȣ������Զ�����⣬��MVC
 * @author Jay
 * @date 2017��4��27��
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
	 * ����ע�ᣬ�����û����Ƿ��ظ�����ַ�Ƿ������⣬�˻��Ƿ��ظ���ȫ��ͨ�������ע�ᱣ����Ϣ
	 * @param name
	 * @param address
	 * @param account
	 * @return �Ƿ�ע��ɹ�
	 */
	public boolean registerClient(String name, String address, String account){
		NameManager nameManager = new NameManager();
		AddressManager addressManager = new AddressManager();
		AccountManager accountManager = new AccountManager();
		if(!nameManager.isValid(name)){
			System.out.println("�û���У�鲻ͨ��");
			return false;
		}
		if(!addressManager.isValid(address)){
			System.out.println("��ַУ�鲻ͨ��");
			return false;
		}
		if(!accountManager.isValid(account)){
			System.out.println("�û���У�鲻ͨ��");
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


