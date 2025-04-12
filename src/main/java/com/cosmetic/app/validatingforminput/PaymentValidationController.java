package com.cosmetic.app.validatingforminput;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cosmetic.app.model.PaymentInfo;

//@Controller
public class PaymentValidationController implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/paymentInfo")
	public String showForm(PaymentInfo paymentInfo) {
		return "payment";
	}

	@PostMapping("/paymentInfo")
	public String checkPaymentInfo(@Validated PaymentInfo paymentInfo, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "payment";
		}

		return "redirect:/results";
	}
}
