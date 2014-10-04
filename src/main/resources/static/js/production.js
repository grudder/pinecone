var _prevIndex = 0;

$(function() {
	window.setInterval(function() {
		$("#arrow").animate({
			'top' : '700px'
		}, 1000, function() {
			$("#arrow").animate({
				'top' : '770px'
			}, 1000);
		});
	}, 2000);

	var mySwiper = $(".swiper-container").swiper({
		mode : "vertical",
		onSlideChangeEnd : function(swiper, direction) {
			_prevIndex = swiper.activeIndex;
		},
		onTouchEnd : function(swiper) {
			if (_prevIndex == 3 && swiper.activeIndex == 3) {
				location.href = "/person/list";
			}
		}
	});
});
