<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Course</title>
<a href="adminhome.jsp">Back</a>

</head>
<body>
	<h1>Add Course</h1>
	<div style="text-align: left">
		<form action="updateGradesAction" method="post">
			<table width="50%">
				<tr>
					<td><s:select name="student" list="studentList" label="Student Name " cssStyle="width:230px;"></s:select>
					</td>
					<td><s:select name="course" list="courseList"
							label="Course Name " cssStyle="width:230px;"></s:select>
					</td>
				</tr>
				<tr>
					<td><s:select name="grade" list="gradeList"
							label="Grade  " cssStyle="width:230px;"></s:select>
					</td>
				</tr>
				<tr>
					<td><s:submit align="left" value="Assign" /></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>