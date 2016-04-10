<%@ include file="/WEB-INF/include.jsp" %>

<div class="uk-text-center uk-height-1-1 uk-margin-large-top">
   <div class="uk-h1">My Account</div>
   <div class="uk-margin-top">
      Welcome <spring:message code="global.gender.male"></spring:message> Demirkan
   </div>	
 
   <div class="uk-vertical-align-middle">
      <form:form action="${contextPath}/save-address" method="post" modelAttribute="address" cssClass="uk-panel uk-panel-box uk-form">
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="title" placeholder="title"/>
         </div>         
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="firstName" placeholder="first name"/>
         </div>
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="lastName" placeholder="last name"/>
         </div>
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="street" placeholder="street"/>
         </div>
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="affix" placeholder="affix"/>
         </div>
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="zipCode" placeholder="zip code"/>
         </div>         
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="city" placeholder="city"/>
         </div>
         <div class="uk-form-row">
            <form:input cssClass="uk-width-1-1 uk-form-large" path="country" placeholder="country"/>
         </div>                  
         <div class="uk-form-row">
            <button type="submit" class="uk-width-1-1 uk-button uk-button-primary uk-button-large">save</a>
         </div>
      </form:form>
   </div>
   
   <div class="uk-h3 uk-margin-top">
      <a href="${contextPath}/logout">log out</a>   
   </div>
   <div class="uk-margin-top">
      Current Locale : ${pageContext.response.locale}
   </div>     
</div>