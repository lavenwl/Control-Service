var containerWidth=window.screen.width-24;//��Ļ���
var bgImgWidth=1920;//����ͼƬ���
var bgImgPositionX=(bgImgWidth-containerWidth)/2
var boxMarginLeft=1210-bgImgPositionX;
//var containerHeight=document.body.clientHeight	;

$(document).ready(function() {
	layoutResize();//��ݷֱ��ʵ���ҳ��
});


function layoutResize(){
	var container=$(".login_container");
	container.width(containerWidth);
	container.css("margin-left",-containerWidth/2);
	var box=$(".info_enter");
	box.css("margin-left",boxMarginLeft);
}