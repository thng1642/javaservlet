<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="style/index_style.css"><!--File css-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet"> <!--Link icon-->
     <!--Font google-->
     <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
     <script src="https://kit.fontawesome.com/dd9a768261.js" crossorigin="anonymous"></script><!--Awesome icons toolkit-->
<title>Home</title>
</head>
<body>
	<h1>Hello world</h1>
	<h2>${user.name}</h2>
	
	<form class="sign-in" name="loginForm" method="post" action="TimetableServlet">			
		<input type="submit" value="Tạo th" class="btn-sign-in">
	</form>
	
	<div class="timetable-container">
        <table>
            <tr>
                <th>Monday</th>
                <th>Tuesday</th>
                <th>Wednesday</th>
                <th>Thursday</th>
                <th>Friday</th>
                <th>Saturday</th>
            </tr>
        </table>
		<!-- Timetable for mssv -->
		
        <div class="content-timetable">
            <div id="tt-monday">
                <h3>${MyTimeTable.get(0).subjectName }</h3>
                
                <div>
                    <i class="far fa-clock"></i>
                    <span>${MyTimeTable.get(0).time }</span>
                </div>

                <div>
                    <i class="fas fa-map-marked-alt"></i>
                    <span>${MyTimeTable.get(0).room }</span>
                </div>
                
            </div>

            <div id="tt-wednesday">
                <h3>Toán 1</h3>

                <div>
                    <i class="far fa-clock"></i>
                    <span>7h50p - 11h30p</span>
                </div>

                <div>
                    <i class="fas fa-map-marked-alt"></i>
                    <span>A4-201</span>
                </div>
                
            </div>

            <div id="tt-friday">
                <h3>Nhập môn ngành</h3>

                <div>
                    <i class="far fa-clock"></i>
                    <span>7h50p - 11h30p</span>
                </div>

                <div>
                    <i class="fas fa-map-marked-alt"></i>
                    <span>A3-301</span>
                </div>
                
            </div>
        </div>
    </div>
</body>
</html>