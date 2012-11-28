<%--
  Created by IntelliJ IDEA.
  User: davidortiz
  Date: 11/28/12
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<head>
    <meta name="layout" content="main"/>
</head>
</head>
<body>
<form>
  <fieldset>
    <legend>Data Consent</legend>
    <label>Study Identifier (Provided at Enrollment)</label>
    <input type="text" placeholder="Study Identifier…">
    <span class="help-block">This will be provided at enrollment time</span>

        <label>Study Site Identifier (Provided at Enrollment)</label>
    <input type="text" placeholder="Study Identifier…">
    <span class="help-block">This will be provided at enrollment time</span>



    <label class="checkbox">
      <input type="checkbox"> Check me out
    </label>
    <button type="submit" class="btn btn-danger">Enable Study Data Consent</button>
  </fieldset>
</form>
</body>
</html>