package com.murari.dao;

import java.util.List;

import com.murari.beans.DemandBean;

public interface DemandDao {
	
	public boolean addProduct(String userId, String prodId, int demandQty);
	
	public boolean addProduct(DemandBean userDemandBean);
	
	public boolean removeProduct(String userId, String prodId);
	
	public List<DemandBean> haveDemanded(String prodId);
	
}
