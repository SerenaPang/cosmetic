package com.cosmetic.app.mysql;

import java.util.List;
import com.cosmetic.app.model.ShippingInfo;
import com.cosmetic.app.repository.ShippingRepository;

public class ShippingRepositoryImpl implements ShippingRepository{
	List<ShippingInfo> shippingInfo;
	@Override
	public void addShippingInfo(ShippingInfo info) {
		shippingInfo.add(info);
	}
	
	
}
