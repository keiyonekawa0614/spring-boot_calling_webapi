var map;
var latlng;

function init() {
	// map初期作成 東京駅の緯度経度を設定
	latlng = new google.maps.LatLng(35.681298, 139.766247);
	// Mapを作成
	map = new google.maps.Map(document.getElementById("map"), {
		zoom : 16,
		mapTypeId : google.maps.MapTypeId.ROADMAP, // 通常の地図
		center : latlng,
	});
}
