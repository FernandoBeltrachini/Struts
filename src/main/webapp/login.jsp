<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Good One Old Man</title>
    </head>
    <body>
    	<div>
        <html:form action="/Login" >
            User Name : <html:text name="LoginForm" property="userName" /> <br>
            Password  : <html:password name="LoginForm" property="password" /> <br>
            <html:submit value="Login" />
        </html:form>
    	</div>
    </body>
</html>
