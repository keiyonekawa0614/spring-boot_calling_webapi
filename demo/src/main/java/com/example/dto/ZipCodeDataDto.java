package com.example.dto;

public class ZipCodeDataDto {
	
	/** 郵便番号 */
	String zipcode = null;
	
	/** 都道府県コード */
	String prefcode = null;
	
	/** 都道府県名 */
	String address1 = null;
	
	/** 市区町村名 */
	String address2 = null;
	
	/** 町域名 */
	String address3 = null;
	
	/** 都道府県名カナ */
	String kana1 = null;
	
	/** 市区町村名カナ */
	String kana2 = null;
	
	/** 町域名カナ */
	String kana3 = null;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPrefcode() {
		return prefcode;
	}

	public void setPrefcode(String prefcode) {
		this.prefcode = prefcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getKana1() {
		return kana1;
	}

	public void setKana1(String kana1) {
		this.kana1 = kana1;
	}

	public String getKana2() {
		return kana2;
	}

	public void setKana2(String kana2) {
		this.kana2 = kana2;
	}

	public String getKana3() {
		return kana3;
	}

	public void setKana3(String kana3) {
		this.kana3 = kana3;
	}

}
