<%@page pageEncoding="utf-8" %>

<div id="header">
	<div id="rightheader">
		<p>
			<script type="text/javascript">
			   function showTime()
			   {
			     var day = new Date();
			     var yy = day.getFullYear();
			     var mm = day.getMonth();
			     var dd = day.getDate();
			     var hh = day.getHours();
			     var m = day.getMinutes();
			     var ss = day.getSeconds();
			     var ap = (hh>12)?"pm":"am";
			     hh = (hh>12)?(hh-12):hh;
			     hh = (hh==0)?12:hh;
			     hh = (hh<10)?("0"+hh):(""+hh);
			     m = (m<10)?("0"+m):(""+m);
			     ss = (ss<10)?("0"+ss):(""+ss);
			     document.getElementById("time").innerHTML = yy+"年"+(mm+1)+"月"+dd+"日   "+hh+":"+m+":"+ss+"  "+ap;
			     
			   }
			   setInterval("showTime()",1000)
			</script>
			<span id="time"></span>
			
		<br/>
		</p>
	</div>
	<div id="topheader">
		<h1 id="title">
			<a href="#">营销数据导出系统</a>
		</h1>
	</div>
	<div id="navigation">
	   
			
	</div>
</div>
