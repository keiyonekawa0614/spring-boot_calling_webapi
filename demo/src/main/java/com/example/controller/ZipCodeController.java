package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ZipCodeDataDto;
import com.example.dto.ZipCodeDto;
import com.example.service.ZipCodeService;

@Controller
public class ZipCodeController {
	
	@Autowired
	ZipCodeService zpcService;
	
	/**
	 * 郵便番号入力フォーム
	 * @return "zipcode"
	 */
	@RequestMapping("/zipcode")
	public String contact(HttpSession session) {
		
		return "zipcode";
	}
	
	/**
	 * 郵便番号情報表示画面	
	 * @return "zipcode-confirm"
	 */
	@RequestMapping("/zipcode/confirm")
	public String contactend(HttpSession session, Model model, 
			                 @RequestParam String zipcode){
		ZipCodeDto zipCodeDto = zpcService.service(zipcode);
		for (ZipCodeDataDto zip : zipCodeDto.getResults()) {
			model.addAttribute("address1", zip.getAddress1());
			model.addAttribute("address2", zip.getAddress2());
			model.addAttribute("address3", zip.getAddress3());
		}
		return "zipcode-confirm";	
	}
}
