package com.murari.dao;

import java.util.List;

import com.murari.beans.OrderBean;
import com.murari.beans.TransactionBean;

public interface OrderDao {
	
	public String paymentSuccess(String userName,double paidAmount);

	public boolean addOrder(OrderBean order);
	
	public boolean addTransaction(TransactionBean transaction);
	
	public int countSoldItem(String prodId);
	
	public List<OrderBean> getAllOrders();
}
