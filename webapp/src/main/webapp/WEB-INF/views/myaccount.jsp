<%@ include file="/WEB-INF/include.jsp" %>

<div class="uk-text-center uk-margin-large-top">
   <div class="uk-h1">My Account</div>
   <div class="uk-margin-top">
      Welcome <spring:message code="global.gender.male"></spring:message> Demirkan
   </div>	
   <div class="uk-h3 uk-margin-top">
      <a href="${contextPath}/logout">log out</a>   
   </div>
   <div class="uk-margin-top">
      Current Locale : ${pageContext.response.locale}
   </div>   
</div>