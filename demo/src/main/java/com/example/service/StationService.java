package com.example.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.StationDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StationService {
	
	/** 路線API リクエストURL */
	private static final String URL = "http://www.ekidata.jp/api/l/";
	
	private static final String DELETE_TEXT1 = "if(typeof(xml)=='undefined') xml = {};";
	private static final String DELETE_TEXT2 ="xml.data = ";
	private static final String DELETE_TEXT3 = "if(typeof(xml.onload)=='function') xml.onload(xml.data);";
	
	public StationDto service(String linecode) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL + linecode + ".json", null,
				String.class);
		System.out.println("URL" + URL + linecode);

		StationDto stationDto = new StationDto();
		try {
			// JSON文字列をJavaオブジェクトに変換
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("Json文字列" + responseEntity.getBody().replace(DELETE_TEXT1, "").replace(DELETE_TEXT2, "").replace(DELETE_TEXT3, ""));
			stationDto = mapper.readValue(responseEntity.getBody().replace(DELETE_TEXT1, "").replace(DELETE_TEXT2, "").replace(DELETE_TEXT3, ""), StationDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stationDto;
	}

}
