<!DOCTYPE html>
<html>
	<head>
		<title>File Upload Example</title>
	</head>
	<body>
		<h4>Upload You Log file</h4>
		<form action="upload" method="POST" enctype="multipart/form-data">
			
			<input type="file" name="file" required="required" multiple="multiple" accept=".log">
			<br/><br/>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>
