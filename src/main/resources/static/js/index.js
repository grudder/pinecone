var _ratio = 1.0;
var _clickCount = 0;

$(function () {
	var width = $(document.body).width();
	_ratio = parseFloat(width / 640);
	
	scalingByRatio();
});

function scalingByRatio() {
	$("#background").css({
        "width": 640 * _ratio,
        "height": 1080 * _ratio
    });
	
	$("#pinecone").css({
        "width": 191 * _ratio,
        "height": 190 * _ratio,
        "left": 150 * _ratio,
        "top": 120 * _ratio
    });
	
	$("#squirrel").css({
        "width": 155 * _ratio,
        "height": 432 * _ratio,
        "left": 300 * _ratio,
        "top": 455 * _ratio
    });
	
	$("#button").css({
        "width": 495 * _ratio,
        "height": 98 * _ratio,
        "left": 72 * _ratio,
        "top": 718 * _ratio
    });
}

function squirrelUp() {
	if (_clickCount < 3) {
		_clickCount++;
		
		// 隐藏按钮
		$("#button").hide(1, function () {
			// 松鼠向上移动
			var top = $("#squirrel").css("top").replace("px", "");
			top = parseInt(top);
			top -= 120 * _ratio;
			$("#squirrel").animate({'top': top + 'px'}, "slow", function () {
				if (_clickCount < 3) {
					// 显示按钮
					$("#button").show();
				}
				
				if (_clickCount == 3) {
					// 松果落下
					var pineconeTop = $("#background").height() - $("#pinecone").height();
					$("#pinecone").animate({'top': pineconeTop + 'px'}, 2000, function () {
						// 页面淡出
						$("body").fadeOut(2000, function () {
							location.href = "/home/production";
						});
					});
				}
			});
		});
	}
}
