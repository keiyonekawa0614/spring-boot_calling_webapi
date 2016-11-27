package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class LineDto {

	List<LineDataDto> line = new ArrayList<>();

	public List<LineDataDto> getLine() {
		return line;
	}

	public void setLine(List<LineDataDto> line) {
		this.line = line;
	}

}
