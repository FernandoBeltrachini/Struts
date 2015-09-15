<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>You have Logged IN</title>
        
    </head>
    <body>
       <h1>GELLOW <bean:write name="LoginForm" property="userName" />
    </body>
</html>
