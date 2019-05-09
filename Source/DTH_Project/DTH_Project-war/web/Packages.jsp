<%-- 
    Document   : Packages
    Created on : Mar 5, 2016, 2:51:16 PM
    Author     : r0cklee147
--%>

<%@page import="myModel.PackageModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>       
        <jsp:include page="header.jsp"/>
        <h2>PACKAGES</h2>
        <hr/>
        <div id="pricing-table" class="clear">
            
            <%
                PackageModel model = new PackageModel();
                String str = model.getPackageList();
                out.print(str);
            %>
            
        </div>

        <jsp:include page="footer.jsp"/>
</body>
</html>
