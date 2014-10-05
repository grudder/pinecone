var _ratio = 1.0;
var _prevIndex = 0;

$(function() {
	var width = $(document.body).width();
	_ratio = parseFloat(width / 640);
	
	scalingByRatio();
	
	window.setInterval(function() {
		$("#arrow").animate({
			'top' : 700 * _ratio + 'px'
		}, 800, function() {
			$("#arrow").animate({
				'top' : 770 * _ratio + 'px'
			}, 800);
		});
	}, 1600);

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

function scalingByRatio() {	
	$(".swiper-container").css({
        "width": 640 * _ratio,
        "height": 1080 * _ratio
    });
	$(".swiper-slide").css({
        "width": 640 * _ratio,
        "height": 1080 * _ratio
    });
	$(".swiper-slide img").css({
        "width": 640 * _ratio,
        "height": 1080 * _ratio
    });
	
	$("#arrow").css({
        "width": 48 * _ratio,
        "height": 64 * _ratio,
        "left": 300 * _ratio,
        "top": 770 * _ratio
    });
}
