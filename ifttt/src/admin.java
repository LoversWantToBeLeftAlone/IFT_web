package Dao;

import java.util.ArrayList;

public class admin extends Customer {
	ArrayList<Customer> consumerList = new ArrayList<Customer>();

	public void delete(Customer c) {// ɾ��һ���˿�
		consumerList.remove(c);
	}

	public void add(Customer c) {// ���һ���˿�
		consumerList.add(c);
	}

	public Customer getmember(int index) {
		Customer c = consumerList.get(index);
		return c;
	}

	public void modify(Customer oldc, Customer newc) {// �˿�����Ϣ�滻�˿;���Ϣ
		int index = getIndex(oldc);
		while (index != -1)
			consumerList.set(index, newc);
	}

	public int getIndex(Customer c) {// ����ĳ���˿͵��������е�index
		return consumerList.indexOf(c);
	}

	public boolean search(Customer c) {// ����ҵ��ͷ���true
		return consumerList.contains(c) ? true : false;
	}
}
