<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="uk-vertical-align uk-text-center uk-height-1-1">
	<div class="uk-vertical-align-middle">

		<form action="${contextPath}/login_post" method="post" class="uk-panel uk-panel-box uk-form">
			<div class="uk-form-row">
				<input class="uk-width-1-1 uk-form-large" type="email" name="username" placeholder="e-mail"/>
			</div>
			<div class="uk-form-row">
				<input class="uk-width-1-1 uk-form-large" type="password" name="password" placeholder="password"/>
			</div>
			<div class="uk-form-row">
				<button type="submit" class="uk-width-1-1 uk-button uk-button-primary uk-button-large">log in</a>
			</div>
		</form>

	</div>
</div>