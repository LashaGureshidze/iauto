<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.IAuto.ge</title>
<style type="text/css">
#axali_dzebna {
	width: 814px;
	background: rgb(240, 240, 240);
	border: 5px solid rgb(255, 255, 255);
	box-shadow: 4px 4px 21px -4px #858585;
	text-shadow: rgba(180, 78, 78, 0.22) 0.1em 0.1em 0.2em;
	font-weight: normal;
	margin: auto;
}

#gamochenili {
	height: 110px;
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

.dzebna {
	background: #66CCFF;
	padding: 3px 17px;
	color: black;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 17px;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 0px solid rgb(213, 150, 17);
	cursor: pointer;
	background-color: rgb(140, 140, 140);
}

.dzebna:hover {
	background-color: #3399FF;
	color: white;
}
</style>
</head>
<body>
	<form action="SearchServlet" method="post">
		<input value="1" name="search_tp" type="hidden">
		<div id="axali_dzebna">
			<div id="gamochenili">
				<div id="pirveli_rigi">
					<span class="sigane" style="width: 150px;"> <select
						name="man_id" id="man_id" class="seleqtebi"
						onChange="manBoxChange(this);" tabindex="1">
							<option value="" selected="selected">მწარმოებელი</option>
							<option value="">ყველა</option>
							<option value='1'>ALFA ROMEO</option>
							<option value='2'>ASTON MARTIN</option>
							<option value='3'>AUDI</option>
							<option value='4'>BELARUS</option>
							<option value='5'>BENTLEY</option>
							<option value='6'>BMW</option>
							<option value='7'>MERCEDESS</option>
							<option value='8'>FORD</option>
							<option value='9'>SUZUKI</option>
							<option value='10'>HUNDAI</option>
							<option value='11'>HONDA</option>
							<option value='12'>OPEL</option>
							<option value='13'>KIA</option>
							<option value='14'>CHEVROLET</option>
							<option value='15'>CHRYSLER</option>
							<option value='16'>CITROEN</option>
							<option value='17'>TOYOTA</option>
							<option value='18'>VOLVO</option>
							<option value='19'>DAEWOO</option>
							<option value='20'>DAF</option>
							<option value='21'>DAIHATSU</option>
							<option value='22'>DNEPR</option>
							<option value='23'>DODGE</option>
					</select>
					</span> <span class="sigane" style="text-align: right; width: 200px;">
						<a style="margin-left: -16px;">წელი</a> <select name="year_from"
						tabindex="4" class="seleqtebi" style="width: 75px;">
							<option>დან</option>
							<%
								for (int k = 1940; k <= 2013; k++) {
							%>
							<option value=<%=k%>><%=k%></option>
							<%
								}
							%>
					</select> <select name="year" tabindex="5" class="seleqtebi"
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
						name="gear_type" class="seleqtebi">
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
						name="model" id="model" class="seleqtebi">
							<option value="" selected="selected">მოდელი</option>
					</select>
					</span> <span class="sigane" style="text-align: right; width: 200px;">
						<a style="">ფასი</a> <input type="text" name="price_from"
						tabindex="6" value="დან" style="height: 22px; width: 69px;" /> <input
						name="price_to" tabindex="7" value="მდე"
						style="height: 22px; width: 69px;">
					</span> <span class="sigane" style="text-align: right;"> <select
						name="fuel_type" class="seleqtebi">
							<option value="0">საწვავის ტიპი</option>
							<option value="1">ელექტრო</option>
							<option value="2">ბენზინი</option>
							<option value="3">დიზელი</option>
							<option value="4">ტურბოდიზელი</option>
							<option value="8">დიზელი/ტურბოდიზელი</option>
							<option value="5">გაზი/ბენზინი</option>
							<option value="6">ჰიბრიდი</option>
					</select>

					</span> <span class="sigane" style="text-align: right;"> <span>მარჯვენა
							საჭე <select name="right_wheel" class="seleqtebi" style="width: 47px;">
								<option></option>
								<option value="1">კი</option>
								<option value="2">არა</option>
						</select>
					</span>
					</span>
				</div>
				<div id="mesame_rigi">
					<span class="sigane" style="width: 150px;"> <select
						name="category_id" class="seleqtebi">
							<option value="" selected="selected">კატეგორია</option>
							<optgroup label="ავტომობილები">
								<option value="1">ჯიპი</option>
								<option value="2">კუპე</option>
								<option value="3">ჰეჩბექი</option>
								<option value="4">უნივერსალი</option>
								<option value="5">კაბრიოლეტი</option>
								<option value="6">პიკაპი</option>
								<option value="7">მინივენი</option>
								<option value="8">მიკროავტობუსი</option>
								<option value="9">ფურგონი</option>
								<option value="10">ლიმუზინი</option>
							</optgroup>
							<optgroup label="სპეცტექნიკა">
								<option value="11">სატვირთო</option>
								<option value="12">ავტობუსი</option>
								<option value="13">საგზაო</option>
								<option value="14">მისაბმელი</option>
								<option value="15">სპეც. ტექნიკა</option>
								<option value="16">ამწე</option>
								<option value="17">ბულდოზერი</option>
								<option value="18">ექსკავატორი</option>
								<option value="19">სამშენებლო</option>
								<option value="20">სასოფლო-სამეურნეო</option>
								<option value="21">დამტვირთველი</option>
								<option value="22">მსუბუქი კომერციული</option>
								<option value="23">გამწევი</option>
							</optgroup>
					</select>
					</span> <span class="sigane"> <select
						name="location" class="seleqtebi">
							<option value="" selected="selected">მდებარეობა</option>
							<option value='1'>საქართველო</option>
							<option value='2'>&nbsp;&nbsp;&nbsp;&nbsp;თბილისი</option>
							<option value='12'>&nbsp;&nbsp;&nbsp;&nbsp;MyAuto-ს
								ავტობაზრობა</option>
							<option value='13'>&nbsp;&nbsp;&nbsp;&nbsp;რუსთავის
								ავტობაზრობა</option>
							<option value='3'>&nbsp;&nbsp;&nbsp;&nbsp;ქუთაისი</option>
							<option value='4'>&nbsp;&nbsp;&nbsp;&nbsp;ზესტაფონი</option>
							<option value='5'>&nbsp;&nbsp;&nbsp;&nbsp;ბათუმი</option>
							<option value='6'>&nbsp;&nbsp;&nbsp;&nbsp;ფოთი</option>
							<option value='7'>&nbsp;&nbsp;&nbsp;&nbsp;თელავი</option>
							<option value='8'>&nbsp;&nbsp;&nbsp;&nbsp;ზუგდიდი</option>
							<option value='9'>&nbsp;&nbsp;&nbsp;&nbsp;გორი</option>
							<option value='10'>&nbsp;&nbsp;&nbsp;&nbsp;რუსთავი</option>
							<option value='11'>&nbsp;&nbsp;&nbsp;&nbsp;მცხეთა</option>
					</select>
					</span> <span class="sigane"> <select class="seleqtebi"
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
						<button class="dzebna">ძებნა</button>
					</span>
				</div>
			</div>
		</div>
	</form>
	<table>
		<%
			//karoche aq minda vip gancxadebebis chamateba 
			//bazis saxeli ar vici saidan unda wavikitxo tore shevcham am nawils :D
		%>
	</table>
</body>
</html>