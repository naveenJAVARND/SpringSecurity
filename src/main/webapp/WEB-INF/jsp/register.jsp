<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from demos.creative-tim.com/material-dashboard-pro/examples/pages/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 20 Apr 2019 08:06:55 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Material Dashboard PRO by Creative Tim
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!-- Extra details for Live View on GitHub Pages -->
  <!-- Canonical SEO -->
 <!--  <link rel="canonical" href="https://www.creative-tim.com/product/material-dashboard-pro" />
   Social tags     
  
 
      Fonts and icons    
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="../../../../maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"> -->
  <!-- CSS Files -->
   <link rel="stylesheet" type="text/css" href="assets/css/icons.css" />
  <link href="assets/css/material-dashboard.minf066.css?v=2.1.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="assets/demo/demo.css" rel="stylesheet" />
  <!-- Google Tag Manager -->

</head>

<body class="off-canvas-sidebar">
  <!-- Extra details for Live View on GitHub Pages -->
  <!-- Google Tag Manager (noscript) -->
  <noscript>
    <iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NKDMSK6" height="0" width="0" style="display:none;visibility:hidden"></iframe>
  </noscript>
  <!-- End Google Tag Manager (noscript) -->
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top text-white">
    <div class="container">
      <div class="navbar-wrapper">
        <a class="navbar-brand" href="#pablo">Registration Page</a>
      </div>
    
    <!--   <div class="collapse navbar-collapse justify-content-end">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a href="../dashboard.html" class="nav-link">
              <i class="material-icons">dashboard</i> Dashboard
            </a>
          </li>
          <li class="nav-item ">
            <a href="register.html" class="nav-link">
              <i class="material-icons">person_add</i> Register
            </a>
          </li>
          <li class="nav-item  active ">
            <a href="login.html" class="nav-link">
              <i class="material-icons">fingerprint</i> Login
            </a>
          </li>
          <li class="nav-item ">
            <a href="lock.html" class="nav-link">
              <i class="material-icons">lock_open</i> Lock
            </a>
          </li>
        </ul>
      </div> -->
    </div>
  </nav>
  <!-- End Navbar -->
  <div class="wrapper wrapper-full-page">
    <div class="page-header login-page header-filter" filter-color="black" style="background-image: url('assets/img/login.jpg'); background-size: cover; background-position: top center;">
      <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-6 col-sm-8 ml-auto mr-auto">
           
            <form:form action="register"  modelAttribute="user"   method="POST" class="form">
              <div class="card card-login card-hidden">
                <div class="card-header card-header-rose text-center">
                  <h4 class="card-title">Registration</h4>
                 
                </div>
                <div class="card-body ">
                 ${message}
                  <c:if test="${param.error != null}">
 <p class="card-description text-center">
									
										Invalid username or password.
								
								 </p>
								</c:if>
                  
                 
                  <span class="bmd-form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="material-icons">face</i>
                        </span>
                      </div>
                      <input type="text" class="form-control" name="username" placeholder="User Name">
                    </div>
                  </span>
                
                  <span class="bmd-form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="material-icons">lock_outline</i>
                        </span>
                      </div>
                      <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                  </span>
                  
                    <span class="bmd-form-group">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="material-icons">shopping_bag</i>
                        </span>
                      </div>
                      <select name="role" class="selectpicker" data-size="7" id="format" data-style="btn btn-primary btn-round" title="Single Select">
                            <option value="admin" selected>admin</option>
                            <option value="user">user</option>
                           
                          </select>
                    </div>
                  </span>
                  
                </div>
                <div class="card-footer justify-content-center">
                  <input type="submit"  class="btn btn-rose btn-link btn-lg" value="Submit" />
                </div>
              </div>
             </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
  

 
 
</body>



</html>




