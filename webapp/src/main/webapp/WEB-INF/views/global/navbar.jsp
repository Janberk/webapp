<%@ include file="/WEB-INF/include.jsp" %>

<!-- NAVIGATION START -->
<nav class="uk-navbar cd-navbar">
   <div class="uk-container uk-container-center uk-padding-remove">
      <ul class="uk-navbar-nav uk-hidden-small">
         <li><a class="cd-navbar-link" href="#">Home</a></li>
         <li class="uk-parent" data-uk-dropdown>
            <a class="cd-navbar-link" href="${contextPath}/myaccount">My Account</a>
            <div class="uk-dropdown uk-dropdown-navbar uk-dropdown-bottom">
               <ul class="uk-nav uk-nav-navbar">
                  <li><a href="${contextPath}/login">Login</a></li>
                  <li><a href="${contextPath}/registration">Registration</a></li>
               </ul>
            </div>
         </li>
         <li class="uk-parent" data-uk-dropdown>
            <a class="cd-navbar-link" href="${contextPath}/myaccount">Language</a>
            <div class="uk-dropdown uk-dropdown-navbar uk-dropdown-bottom">
               <ul class="uk-nav uk-nav-navbar">
                  <li><a href="?language=de_DE">Deutsch</a></li>
                  <li><a href="?language=en_US">English</a></li>
               </ul>
            </div>
         </li>         
      </ul>
      <div class="uk-navbar-flip uk-navbar-content uk-padding-remove">
         <form class="uk-form uk-margin-remove uk-display-inline-block" action="#" method="get" role="search" data-uk-search>
            <input type="text" name="search" placeholder="search" autocomplete="off">
            <button class="uk-button uk-button-primary">search</button>
         </form>
      </div>
   </div>
</nav>
<!-- NAVIGATION END -->
