package com.example.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.DemoService;

@Controller
public class DemoController {
	
	@Autowired
	DemoService service;
	
	/**
	 * お問い合わせフォーム
	 * @return "contact"
	 */
	@RequestMapping("/contact/{code}")
	public String contact(@PathVariable("code") String code) {
		service.service(code);
		return "contact";
	}
	
	/**
	 * お問い合わせ完了
	 * @return "contact-end"
	 */
	@RequestMapping("/contact/end")
	public String contactend(){
		return "contact-end";	
	}
	
	@RequestMapping("/rakuten/api")
	public String rakutenApi(Model model) {
		model.addAttribute("message", "ホテル検索");
		return "hotel-list";
	}
	/**
	 * google map 表示
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping("/example")
	public String googleMap(Locale locale, Model model) {
		return "map";
	}
}
