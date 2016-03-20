<%@ include file="/WEB-INF/include.jsp" %>

<div class="uk-text-center uk-margin-large-top">
   <div class="uk-h1">My Account</div>
   <a href="?language=en_US">English</a>|<a href="?language=de_DE">Deutsch</a>
   <br> Welcome
   <spring:message code="global.gender.male"></spring:message>
   Demirkan
   <br>
   <span class="uk-h3">
      <a href="${contextPath}/logout">log out</a>
   </span>
   <br> Current Locale : ${pageContext.response.locale}
</div>