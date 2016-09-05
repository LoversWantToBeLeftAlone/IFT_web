package Dao;

@SuppressWarnings("serial")
public class Customer implements java.io.Serializable {
	private String name;
	private String passwords;
	private String sex;
	private String idnumber;//���֤
	private String address;
	private int level;//��Ա�ȼ�
	private String money;//ӵ�н�Ǯ
	public String getName(){
		return this.name;
	}
	public String getPasswords(){
		return this.passwords;
	}
	public String getSex(){
		return this.sex;
	}
	public String getIdnumber(){
		return this.idnumber;
	}
	public int getLevel(){
		return this.level;
	}
	public String getMoney(){
		return this.money;
	}
	public String getAddr(){
		return this.address;
	}
	public void setNameAndPass(String name,String pass){
		this.name=name;
		this.passwords=pass;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public void setIdnumber(String idnumber){
		this.idnumber=idnumber;
	}
	public void setAddress(String addr){
		this.address=addr;
	}
	public void setLevel(int level,String money){
		this.level=level;
		this.money=money;
	}
	public Customer(){
	}
	public Customer(String name,String sex,String idnumber,String pass,String addr,int money){
		this.name=name;
		this.passwords=pass;
		this.sex=sex;
		this.address=addr;
		this.money=Integer.toString(money);
		this.level=money/500;
		this.idnumber=idnumber;
	}
	public void copy(Customer c){
		this.name=c.getName();
		this.level=c.getLevel();
		this.money=c.getMoney();
	}
	public void setCustomer(String name,int level,String money){
		this.name=name;
		this.level=level;
		this.money=money;
	}
	public void showInformation(){
		System.out.println("������"+this.name);
		System.out.println("�Ա�"+this.sex);
		System.out.println("��ס�أ�"+this.address);
		System.out.println("�ȼ�"+this.level);
		System.out.println("��"+this.money);
	}
	public void delete(){//ɾ��
		
	}
	public void add(){//����
		
	}
	public void modify(){//�޸�
		
	}
	public void search(){//����
		
	}
	public static void main(String [] args){
		System.out.println("OK");
	}
	
}
