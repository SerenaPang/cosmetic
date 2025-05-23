package com.cosmetic.app.postgressql;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cosmetic.app.model.ShippingInfo;
import com.cosmetic.app.repository.ShippingRepository;

@Repository
public class ShippingRepositoryImpl implements ShippingRepository {
	List<ShippingInfo> shippingInfo;

	@Override
	public void addShippingInfo(ShippingInfo info) {
		System.out.println("Shipping Info: " + info);
		shippingInfo.add(info);
	}
}
