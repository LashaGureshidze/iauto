<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.IAuto.ge</title>

<style type="text/css">
.hovermenu ul {
	font: bold 18px calibri;
	height: 25px;
}

.hovermenu ul li {
	list-style: none;
	display: inline;
}

.hovermenu ul li a {
	padding: 10px 25px 10px 25px;
	text-decoration: none;
	float: left;
	color: white;
	background-color: rgb(255, 216, 100);
	border: 1px solid rgb(255, 216, 100);
}

.hovermenu ul li a:hover {
	background-color: #FFFFFF;
	color: rgb(255, 216, 100);
}
</style>

<style type="text/css">
#axali_dzebna {
	width: 814px;
	background: url(http://myauto.ge/images/maxo.png);
	border: 5px solid rgb(255, 255, 255);
	box-shadow: 0px 4px 21px -4px #858585;
	text-shadow: rgba(78, 78, 78, 0.12) 0.1em 0.1em 0.2em;
	font-weight: normal;
}

#gamochenili {
	height: 97px;
}

.sigane {
	display: inline-block;
	width: 200px;
	text-align: center;
}

.fasi_weli_garbeni {
	width: 71px;
	height: 22px;
}

.seleqtebi {
	width: 150px;
	height: 28px;
	margin-top: 3px;
	text-shadow: rgba(78, 78, 78, 0.12) 0.1em 0.1em 0.2em;
}

#kompleqtacia {
	border: 1px solid rgb(255, 195, 118);
	background-color: rgba(255, 173, 0, 0.07);
	margin-left: 20px;
	margin-top: 4px;
	width: 570px;
	padding-bottom: 4px;
}

#dzebna {
	background: rgb(255, 153, 0);
	background: -moz-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: -webkit-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: -o-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: -ms-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: linear-gradient(top, rgb(255, 208, 60) 0%, rgb(255, 169, 16)
		100% );
	padding: 3px 17px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 17px;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 1px solid rgb(213, 150, 17);
	cursor: pointer;
}

.search_rect_down {
	cursor: pointer;
	padding-right: 4px;
	background-image: url('http://myjobs.ge/new/images/rect_down.gif');
	background-repeat: no-repeat;
	display: inline-block;
	text-indent: 15px;
	background-position: 0 3px;
}

.search_rect_up {
	background-image: url('http://myjobs.ge/new/images/rect_up.gif');
}

.search_rect_down:hover {
	color: rgb(255, 163, 0);
}

.search_rect_down1 {
	cursor: pointer;
	padding-right: 4px;
	background-image: url('http://myjobs.ge/new/images/rect_down.gif');
	background-repeat: no-repeat;
	display: inline-block;
	text-indent: 15px;
	background-position: 0 3px;
}

.search_rect_up1 {
	background-image: url('http://myjobs.ge/new/images/rect_up.gif');
}

.search_rect_down1:hover {
	color: rgb(255, 163, 0);
}
</style>
	<style type="text/css">
.button {
	color: rgb(255, 163, 100);
	width: 105px;
	height: 40px;
	background-image: url('tiny.gif');
	line-height: 20px;
	padding-bottom: 2px;
	vertical-align: middle;
	font-family: "Lucida Grande", Geneva, Verdana, Arial, Helvetica,
		sans-serif;
	font-size: 18px; <!--
	font-weight: bold; -->
	text-transform: none;
	border: 1px solid transparent;
}
</style>

</head>
<body>
	<table>
		<tr>
			<td>
				<div class="hovermenu">
					<ul>
						<li><a href="http://localhost:8080/myProject/home_page.jsp">მთავარი</a></li>
						<li><a href="http://localhost:8080/myProject/my_page.jsp">ჩემი გვერდი</a></li>
						<li><a href="http://localhost:8080/myProject/log_in.jsp">შესვლა</a></li>
						<li><a href="http://localhost:8080/myProject/register.jsp">რეგისტრაცია</a></li>
					</ul>
				</div>
			</td>
			<td width="30px">
				<form action="Add_Application" method="post">
					<input type="submit" name="add app" value="დამატება" class="button">
				</form>
			</td>
			<td width="30px">
				<form action="Log_Out" method="post">
					<input type="submit" name="log out" value="გამოსვლა" class="button">
				</form>
			</td>
		</tr>
	</table>
	<form action="Search" method="post">
		<input value="1" name="search_tp" type="hidden">
		<div id="axali_dzebna">
			<div id="gamochenili">
				<div id="pirveli_rigi">
					<span class="sigane" style="width: 150px;"> <select
						name="man_id" id="man_id" class="seleqtebi"
						onChange="manBoxChange('man_model_id_group','man_id');"
						tabindex="1">
							<option value="" selected="selected">მწარმოებელი</option>
							<option value="">ყველა</option>
							<%
								BufferedReader reader = new BufferedReader(new FileReader(
										"C://autos/factories.txt"));
								int i = 0;
								while (true) {
									String line = reader.readLine();
									if (line == null)
										break;
									i++;
							%>
							<option value="<%=i%>"><%=line%></option>
							<%
								}
								reader.close();
							%>
					</select>
					</span> <span class="sigane" style="text-align: right; width: 200px;">
						<a style="margin-left: -16px;">წელი</a> <select name="year_from"
						id="year_from" tabindex="4" class="seleqtebi" style="width: 75px;">
							<option>დან</option>
							<%
								for (int k = 1940; k <= 2013; k++) {
							%>
							<option value=<%=k%>><%=k%></option>
							<%
								}
							%>
					</select> <select name="year_to" id="year_to" tabindex="5" class="seleqtebi"
						style="width: 75px;">
							<option>მდე</option>
							<%
								for (int k = 1940; k <= 2013; k++) {
							%>
							<option value=<%=k%>><%=k%></option>
							<%
								}
							%>
					</select>
					</span> <span class="sigane" style="text-align: right;"> <select
						onChange="gearch(this.value);countresult(que);"
						name="gear_type_id" id="gear_type_id" class="seleqtebi">
							<option value="">ტრანსმისია</option>
							<option value="1">მექანიკური</option>
							<option value="2">ავტომატიკა</option>
							<option value="3">ტიპტრონიკი</option>
							<option value="4">ავტ. ან ტიპტ.</option>
					</select>
					</span> <span class="sigane" style="text-align: right;"> <span>განბაჟებული
							<select onChange="" name="customs_passed" id="customs_passed"
							class="seleqtebi" style="width: 47px;">
								<option></option>
								<option value="1">კი</option>
								<option value="2">არა</option>
						</select>
					</span>
					</span>
				</div>
				<div id="meore_rigi">
					<span class="sigane" style="width: 150px;"> <select
						onChange="manmodelch(this.value);countresult(que);"
						name="man_model_id_group" id="man_model_id_group"
						class="seleqtebi">

							<option value="" selected="selected">მოდელი</option>

					</select>
					</span> <span class="sigane" style="text-align: right; width: 200px;">
						<a style="">ფასი</a> <input type="text" name="price_from"
						id="price_from" tabindex="6" placeholder="from"
						style="height: 22px; width: 69px;" /> <input name="price_to"
						id="price_to" tabindex="7" placeholder="to"
						style="height: 22px; width: 69px;">
					</span> <span class="sigane" style="text-align: right;"> <select
						name="fuel_type_id" id="fuel_type_id" class="seleqtebi">
							<option value="0">საწვავის ტიპი</option>
							<option value="2">ბენზინი</option>
							<option value="3">დიზელი</option>
							<option value="4">ტურბოდიზელი</option>
							<option value="8">დიზელი/ტურბოდიზელი</option>
							<option value="5">გაზი/ბენზინი</option>
							<option value="6">ჰიბრიდი</option>
							<option value="7">ელექტრო</option>
					</select>

					</span> <span class="sigane" style="text-align: right;"> <span>მარჯვენა
							საჭე <select onChange="" name="right_wheel" id="right_wheel"
							class="seleqtebi" style="width: 47px;">
								<option></option>
								<option value="1">კი</option>
								<option value="2">არა</option>
						</select>
					</span>
					</span>
				</div>
				<div id="mesame_rigi">
					<span class="sigane" style="width: 150px;"> <select
						onChange="categorych(this.value);countresult(que);"
						name="category_id" id="category_id" class="seleqtebi">
							<option value="" selected="selected">კატეგორია</option>
							<optgroup label="ავტომობილები">
								<option value="5">ჯიპი</option>
								<option value="4">კუპე</option>
								<option value="2">ჰეჩბექი</option>
								<option value="3">უნივერსალი</option>
								<option value="6">კაბრიოლეტი</option>
								<option value="29">პიკაპი</option>
								<option value="30">მინივენი</option>
								<option value="7">მიკროავტობუსი</option>
								<option value="13">ფურგონი</option>
								<option value="15">ლიმუზინი</option>
							</optgroup>
							<optgroup label="სპეცტექნიკა">
								<option value="16">სატვირთო</option>
								<option value="14">ავტობუსი</option>
								<option value="37">საგზაო</option>
								<option value="19">მისაბმელი</option>
								<option value="20">სპეც. ტექნიკა</option>
								<option value="23">ამწე</option>
								<option value="24">ბულდოზერი</option>
								<option value="25">ექსკავატორი</option>
								<option value="26">სამშენებლო</option>
								<option value="27">სასოფლო-სამეურნეო</option>
								<option value="28">დამტვირთველი</option>
								<option value="35">მსუბუქი კომერციული</option>
								<option value="36">გამწევი</option>
							</optgroup>
					</select>
					</span> <span class="sigane"> <select
						onChange="locationch(this.value);countresult(que);"
						id="location_id_1" tabindex="7" name="location_id_1"
						class="seleqtebi">
							<option value="" selected="selected">მდებარეობა</option>
							<option value='1'>საქართველო</option>
							<option value='2'>&nbsp;&nbsp;&nbsp;&nbsp;თბილისი</option>
							<option value='34'>&nbsp;&nbsp;&nbsp;&nbsp;MyAuto-ს
								ავტობაზრობა</option>
							<option value='30'>&nbsp;&nbsp;&nbsp;&nbsp;რუსთავის
								ავტობაზრობა</option>
							<option value='3'>&nbsp;&nbsp;&nbsp;&nbsp;ქუთაისი</option>
							<option value='36'>&nbsp;&nbsp;&nbsp;&nbsp;ზესტაფონი</option>
							<option value='37'>&nbsp;&nbsp;&nbsp;&nbsp;ახმეტა</option>
							<option value='38'>&nbsp;&nbsp;&nbsp;&nbsp;ბორჯომი</option>
							<option value='4'>&nbsp;&nbsp;&nbsp;&nbsp;ბათუმი</option>
							<option value='5'>&nbsp;&nbsp;&nbsp;&nbsp;სოხუმი</option>
							<option value='6'>&nbsp;&nbsp;&nbsp;&nbsp;ცხინვალი</option>
							<option value='7'>&nbsp;&nbsp;&nbsp;&nbsp;ფოთი</option>
							<option value='8'>&nbsp;&nbsp;&nbsp;&nbsp;თელავი</option>
							<option value='44'>&nbsp;&nbsp;&nbsp;&nbsp;გურჯაანი</option>
							<option value='9'>&nbsp;&nbsp;&nbsp;&nbsp;ზუგდიდი</option>
							<option value='39'>&nbsp;&nbsp;&nbsp;&nbsp;კასპი</option>
							<option value='40'>&nbsp;&nbsp;&nbsp;&nbsp;საგარეჯო</option>
							<option value='41'>&nbsp;&nbsp;&nbsp;&nbsp;ქობულეთი</option>
							<option value='10'>&nbsp;&nbsp;&nbsp;&nbsp;ოზურგეთი</option>
							<option value='11'>&nbsp;&nbsp;&nbsp;&nbsp;ამბროლაური</option>
							<option value='12'>&nbsp;&nbsp;&nbsp;&nbsp;ხაშური</option>
							<option value='13'>&nbsp;&nbsp;&nbsp;&nbsp;გორი</option>
							<option value='14'>&nbsp;&nbsp;&nbsp;&nbsp;ახალქალაქი</option>
							<option value='15'>&nbsp;&nbsp;&nbsp;&nbsp;რუსთავი</option>
							<option value='31'>&nbsp;&nbsp;&nbsp;&nbsp;ახალციხე</option>
							<option value='16'>&nbsp;&nbsp;&nbsp;&nbsp;მცხეთა</option>
					</select>
					</span> <span class="sigane"> <select class="seleqtebi"
						onChange="lastdch(this.value);countresult(que);" id="last_days"
						name="last_days">
							<option value="">განცხადებები</option>
							<option value="1">ბოლო 1 საათი</option>
							<option value="2">ბოლო 2 საათი</option>
							<option value="3">ბოლო 3 საათი</option>

							<option value="4">ბოლო 1 დღე</option>
							<option value="5">ბოლო 2 დღე</option>
							<option value="6">ბოლო 3 დღე</option>

							<option value="7">ბოლო 1 კვირა</option>
							<option value="14">ბოლო 2 კვირა</option>
							<option value="21">ბოლო 3 კვირა</option>

							<option value="31">ბოლო 1 თვე</option>
					</select>
					</span> <span class="sigane">
						<button id="dzebna">ძებნა</button> <span
						style="color: rgba(255, 255, 255, 0); text-shadow: none; font-size: 14px;">....</span>
					</span>
				</div>
			</div>
		</div>
	</form>
</body>
</html>