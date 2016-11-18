package com.example.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.ZipCodeDataDto;
import com.example.dto.ZipCodeDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ZipCodeService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	/** 郵便番号検索API */
	private static final String URL = "http://zipcloud.ibsnet.co.jp/api/search?zipcode=";
	
	public ZipCodeDto service(String zipcode) {

		ResponseEntity<String> responseEntity = 
				restTemplate.postForEntity(URL + zipcode, null, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		ZipCodeDto zipCodeDto = new ZipCodeDto();
		try {
			zipCodeDto = mapper.readValue(responseEntity.getBody(), ZipCodeDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return zipCodeDto;
	}
	

}
