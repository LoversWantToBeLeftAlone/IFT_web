package Dao;

import java.util.ArrayList;

public class admin extends Customer {
	ArrayList<Customer> consumerList = new ArrayList<Customer>();

	public void delete(Customer c) {// 删除一名顾客
		consumerList.remove(c);
	}

	public void add(Customer c) {// 添加一名顾客
		consumerList.add(c);
	}

	public Customer getmember(int index) {
		Customer c = consumerList.get(index);
		return c;
	}

	public void modify(Customer oldc, Customer newc) {// 顾客新信息替换顾客旧信息
		int index = getIndex(oldc);
		while (index != -1)
			consumerList.set(index, newc);
	}

	public int getIndex(Customer c) {// 返回某个顾客的在链表中的index
		return consumerList.indexOf(c);
	}

	public boolean search(Customer c) {// 如果找到就返回true
		return consumerList.contains(c) ? true : false;
	}
}
