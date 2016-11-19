package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String zipcodeForm(HttpSession session, Model model) {
		return "zipcode";
	}
	
	/**
	 * 郵便番号情報表示	
	 * @return "zipcode-confirm"
	 */
	@RequestMapping(value="/zipcode/confirm", method=RequestMethod.POST)
	public String zipcodeConfirm(HttpSession session, Model model, 
			                     @RequestParam("zipcode") String zipcode){
		
		// 一応必須チェックのみ 数字・桁数チェックは省略
		// nullまたは空文字の場合、入力フォームにエラーメッセージを表示
		if (zipcode == null || zipcode.equals("")) {
			model.addAttribute("errorMessage", "郵便番号を入力してください。");
			return zipcodeForm(session, model);
		}
		
		// 郵便番号検索APIサービス呼び出し
		ZipCodeDto zipCodeDto = zpcService.service(zipcode);
		// thymeleafでリストを展開して表示する
        model.addAttribute("zipcodeList", zipCodeDto.getResults());
		return "zipcode-confirm";	
	}
}
