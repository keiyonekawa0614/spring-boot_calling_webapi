package com.example.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateResolver {

	@Bean
	public RestTemplate zipCodeSearchRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
		supportedMediaTypes.add(MediaType.TEXT_PLAIN); // text/plainのJacksonの処理対象にくわえる
		messageConverter.setSupportedMediaTypes(supportedMediaTypes);
		restTemplate.setMessageConverters(Collections.singletonList(messageConverter)); // カスタムしたHttpMessageConverterを適用
		return restTemplate;
	}
}
