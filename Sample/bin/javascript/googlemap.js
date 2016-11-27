var map;
var latlng;
var ss;

function init() {
	// map初期作成 東京駅の緯度経度を設定
	latlng = new google.maps.LatLng(35.681298, 139.766247);
	// Mapを作成
	map = new google.maps.Map(document.getElementById("map"), {
		zoom : 16,
		mapTypeId : google.maps.MapTypeId.ROADMAP, // 通常の地図
		center : latlng,
		scrollwheel : false,
	});
	console.log("aaa"+latlng);
}

function codeAddress() {
	'use strict';
	var lng = document.getElementById("show_lng").value;
	var lat = document.getElementById("show_lat").value;
	ss = new google.maps.LatLng(lat, lng);
	map = new google.maps.Map(document.getElementById("map"), {
		zoom : 16,
		mapTypeId : google.maps.MapTypeId.ROADMAP, // 通常の地図
		center : ss,
		scrollwheel : false,
	});
	console.log("bbb"+ss);
}

function setMarker(event) {
	// event.latLng.lat()がクリックしたときの経度,event.latLng.lng()が緯度を表す
	// alert("経度:"+event.latLng.lat()+"\n緯度:"+event.latLng.lng());
	var latlng = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());
	// マーカーを設置し、各種オプションを入力していく
	mk = new google.maps.Marker({
		map : map,
		position : latlng,
	});
	mk.setMap(map);
	mk_array.push(mk);
	// クリックした緯度経度を表示
	document.getElementById("show_lat").value = event.latLng.lat();
	document.getElementById("show_lng").value = event.latLng.lng();

}
