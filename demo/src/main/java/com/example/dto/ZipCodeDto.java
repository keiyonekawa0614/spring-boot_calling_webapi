package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class ZipCodeDto {
	
	/** ステータス */
	int status = 0;
	
	/** メッセージ */
	String message = null;
	
	/** 郵便番号情報リスト */
	List<ZipCodeDataDto> results = new ArrayList<>();

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ZipCodeDataDto> getResults() {
		return results;
	}

	public void setResults(List<ZipCodeDataDto> results) {
		this.results = results;
	}

	
	

}
