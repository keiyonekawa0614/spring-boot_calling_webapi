package com.example.dto;

public class StationDataDto {

	/** 駅コード */
	String station_cd;

	/** 駅グループコード */
	String station_g_cd;

	/** 駅名 */
	String station_name;

	/** 緯度 */
	double lon;

	/** 経度 */
	double lat;

	public String getStation_cd() {
		return station_cd;
	}

	public void setStation_cd(String station_cd) {
		this.station_cd = station_cd;
	}

	public String getStation_g_cd() {
		return station_g_cd;
	}

	public void setStation_g_cd(String station_g_cd) {
		this.station_g_cd = station_g_cd;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	
}
