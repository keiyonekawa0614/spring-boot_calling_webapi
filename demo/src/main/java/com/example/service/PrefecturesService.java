package com.example.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.LineDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PrefecturesService {

	/** 都道府県API リクエストURL */
	private static final String URL = "http://www.ekidata.jp/api/p/";
	
	private static final String DELETE_TEXT1 = "if(typeof(xml)=='undefined') xml = {};";
	private static final String DELETE_TEXT2 ="xml.data = ";
	private static final String DELETE_TEXT3 = "if(typeof(xml.onload)=='function') xml.onload(xml.data);";
	
	public LineDto service(String prefcode) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL + prefcode + ".json", null,
				String.class);

		LineDto lineDto = new LineDto();
		try {
			// JSON文字列をJavaオブジェクトに変換
			ObjectMapper mapper = new ObjectMapper();
			lineDto = mapper.readValue(responseEntity.getBody().replace(DELETE_TEXT1, "").replace(DELETE_TEXT2, "").replace(DELETE_TEXT3, ""), LineDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lineDto;
	}

}
