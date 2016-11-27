package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class StationDto {
	
	/** 沿線コード */
	String line_cd;
	
	/** 沿線名 */
	String line_name;
	
	/** 緯度 */
	Long line_lon;
	
	/** 経度 */
	Long line_lat;
	
	/** ズーム */
	int line_zoom;
	
	/** 駅情報リスト */
	List<StationDataDto> station_l = new ArrayList<>();

	public String getLine_cd() {
		return line_cd;
	}

	public void setLine_cd(String line_cd) {
		this.line_cd = line_cd;
	}

	public String getLine_name() {
		return line_name;
	}

	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}

	public Long getLine_lon() {
		return line_lon;
	}

	public void setLine_lon(Long line_lon) {
		this.line_lon = line_lon;
	}

	public Long getLine_lat() {
		return line_lat;
	}

	public void setLine_lat(Long line_lat) {
		this.line_lat = line_lat;
	}

	public int getLine_zoom() {
		return line_zoom;
	}

	public void setLine_zoom(int line_zoom) {
		this.line_zoom = line_zoom;
	}

	public List<StationDataDto> getStation_l() {
		return station_l;
	}

	public void setStation_l(List<StationDataDto> station_l) {
		this.station_l = station_l;
	}

}
