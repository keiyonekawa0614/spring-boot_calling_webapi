package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.common.PrefectureEnum;
import com.example.dto.LineDto;
import com.example.dto.PrefectureDto;
import com.example.dto.StationDto;
import com.example.service.PrefecturesService;
import com.example.service.StationService;

@Controller
public class PrefecturesController {

	@Autowired
	PrefecturesService prefecturesService;

	@Autowired
	StationService stationService;

	@RequestMapping("/prefectures")
	public String pref(HttpSession session, Model model) {

		PrefectureEnum[] types = PrefectureEnum.values();
		List<PrefectureDto> prefList = new ArrayList<>();

		for (PrefectureEnum m : types) {
			PrefectureDto dto = new PrefectureDto();
			dto.setPrefCode(m.getCode());
			dto.setPrefName(m.getFullName());
			prefList.add(dto);
		}
		model.addAttribute("prefList", prefList);

		return "prefectures";
	}

	@RequestMapping("/prefectures/line")
	public String prefLine(HttpSession session, Model model,
			               @RequestParam("prefcode") String prefcode) {

		LineDto dto = prefecturesService.service(prefcode);
		model.addAttribute("lineList", dto.getLine());

		return "prefectures-line";
	}

	@RequestMapping("/prefectures/line/station")
	public String prefStation(HttpSession session, Model model,
			                  @RequestParam("linecode") String linecode){

		System.out.println("パラメータ確認 :" + linecode);

		StationDto dto = stationService.service(linecode);
		model.addAttribute("stationList", dto.getStation_l());

		return "station";

}
}
