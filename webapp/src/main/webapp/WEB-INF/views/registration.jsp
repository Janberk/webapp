<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="uk-vertical-align uk-text-center uk-height-1-1">
	<div class="uk-vertical-align-middle">

		<form:form action="submit-registration" method="post" modelAttribute="account" cssClass="uk-panel uk-panel-box uk-form">
			<div class="uk-form-row">
				<form:input cssClass="uk-width-1-1 uk-form-large" path="firstName" placeholder="first name"/>
			</div>
			<div class="uk-form-row">
				<form:input cssClass="uk-width-1-1 uk-form-large" path="lastName" placeholder="last name"/>
			</div>
			<div class="uk-form-row">
				<form:input cssClass="uk-width-1-1 uk-form-large" path="userName" placeholder="e-mail"/>
			</div>
			<div class="uk-form-row">
				<form:password cssClass="uk-width-1-1 uk-form-large" path="password" placeholder="password"/>
			</div>
			<div class="uk-form-row">
				<button type="submit" class="uk-width-1-1 uk-button uk-button-primary uk-button-large">register</a>
			</div>
		</form:form>

	</div>
</div>