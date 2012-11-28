<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <r:require modules="bootstrap"/>
    <g:javascript library='jquery'/>
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>
<div class="page-header">
  <h1>Indivo<small> Study Consent Manager</small></h1>
  <g:if test="${session["demographic"] != null}">
    Record: ${session["demographic"].nameGiven} ${session["demographic"].nameFamily}
  </g:if>
</div>



<div class="container">
    <g:if test="${flash.message}">
        <div class="alert">${flash.message}</div>
    </g:if>
    <g:layoutBody/>
    <div class="footer" role="contentinfo"></div>

    <g:javascript library="application"/>
    <r:layoutResources/>
</div>
</body>
</html>