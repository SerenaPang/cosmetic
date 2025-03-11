package com.cosmetic.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.cosmetic.app.model.Cosmetic;

@Service
@SessionScope
public class OrderService {
	List<Cosmetic> order = new ArrayList<Cosmetic>();

	public List<Cosmetic> addToOrder(Cosmetic cosmetic) {
		order.add(cosmetic);
		return order;
	}

	public List<Cosmetic> deleteFromOrder(Cosmetic cosmetic) {
		order.remove(cosmetic);
		return order;
	}

	public List<Cosmetic> findAllCosmetics() {
		return order;
	}
}
