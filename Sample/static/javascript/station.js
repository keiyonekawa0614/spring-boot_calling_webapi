var xml = {};
function setMenuItem(type, code) {

	var s = document.getElementsByTagName("head")[0].appendChild(document
			.createElement("script"));
	s.type = "text/javascript";
	s.charset = "utf-8";


	var optionIndex0 = document.form.s0.options.length; // 沿線のOPTION数取得
	var optionIndex1 = document.form.s1.options.length; // 駅のOPTION数取得
	var lat;
	var lon;
	var latlng;

	if (type == 0) {
		for (i = 0; i <= optionIndex0; i++) {
			document.form.s0.options[0] = null
		} // 沿線削除
		for (i = 0; i <= optionIndex1; i++) {
			document.form.s1.options[0] = null
		} // 駅削除
		document.form.s1.options[0] = new Option("----", 0); // 駅OPTIONを空に
		if (code == 0) {
			document.form.s0.options[0] = new Option("----", 0); // 沿線OPTIONを空に
		} else {
			s.src = "http://www.ekidata.jp/api/p/" + code + ".json"; // 沿線JSONデータURL
		}
	} else if(type == 1) {
		for (i = 0; i <= optionIndex1; i++) {
			document.form.s1.options[0] = null
		} // 駅削除
		if (code == 0) {
			document.form.s1.options[0] = new Option("----", 0); // 駅OPTIONを空に
		} else {
			s.src = "http://www.ekidata.jp/api/l/" + code + ".json"; // 駅JSONデータURL
		}
	} else {
		var aa = document.form.s1.value;
		console.log("確認：" + aa);
		var data = aa.split(",");
		console.log("lat：" + data[0] + ",lon" + data[1]);
		latlng = new google.maps.LatLng(data[0],data[1]);
		// Mapを作成
		map = new google.maps.Map(document.getElementById("map"), {
			zoom : 16,
			mapTypeId : google.maps.MapTypeId.ROADMAP, // 通常の地図
			center : latlng,
			scrollwheel : false,
		});
	}
	
	
	xml.onload = function(data) {
		var line = data["line"];
		var station_l = data["station_l"];
		if (line != null) {
			document.form.s0.options[0] = new Option("----", 0); // OPTION1番目はNull
			for (i = 0; i < line.length; i++) {
				ii = i + 1 // OPTIONは2番目から表示
				var op_line_name = line[i].line_name;
				var op_line_cd = line[i].line_cd;
				document.form.s0.options[ii] = new Option(op_line_name,
						op_line_cd);
			}
		}
		if (station_l != null) {
			document.form.s1.options[0] = new Option("----", 0); // OPTION1番目はNull
			for (i = 0; i < station_l.length; i++) {
				ii = i + 1 // OPTIONは2番目から表示
				var op_station_name = station_l[i].station_name;
				var op_station_cd = station_l[i].station_cd;
				var lat = station_l[i].lat;
				var lon = station_l[i].lon;
				document.form.s1.options[ii] = new Option(op_station_name,
						lat+","+lon);

			}
		}
	}
}