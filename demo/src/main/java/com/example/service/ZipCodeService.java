package com.example.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.ZipCodeDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ZipCodeService {

	/** 郵便番号検索API リクエストURL */
	private static final String URL = "http://zipcloud.ibsnet.co.jp/api/search?zipcode=";

	public ZipCodeDto service(String zipcode) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = 
				restTemplate.postForEntity(URL + zipcode, null, String.class);
	
		ZipCodeDto zipCodeDto = new ZipCodeDto();
		try {
			// JSON文字列をJavaオブジェクトに変換
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(responseEntity.getBody());
			zipCodeDto = mapper.readValue(responseEntity.getBody(), ZipCodeDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return zipCodeDto;
	}

}
