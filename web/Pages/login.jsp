<%-- 
    Document   : login
    Created on : Mar 7, 2023, 9:18:41 AM
    Author     : lenovo
--%>
<%@page import="jakarta.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="styling/style.css" />

    <title>Login!</title>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <!-- Favicons -->
  <link rel="icon" href="Styling/assets/img/favicon.png"/>
  <link href="Styling/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="Styling/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="Styling/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="Styling/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="Styling/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="Styling/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="Styling/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="Styling/assets/vendor/simple-datatables/style.css" rel="stylesheet">
  
  <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.css">-->
  
  <link rel="stylesheet" href="Styling/style.css"/>
  
  <!-- Template Main CSS File -->
  <link href="Styling/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.5.0
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->

  </head>
  <body>
      <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">Attendify</span>
      </a>
    </div><!-- End Logo -->

   
  </header><!-- End Header -->
    <div class="container-fluid h-100">
      <!-- Just an image -->
      <nav class="navbar navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="#">
<!--            <img
              src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
              height="20"
              alt="MDB Logo"
              loading="lazy"
            />-->
            Attendify
          </a>
        </div>
      </nav>

      <!-- Section: Design Block -->
      <section class="login-section">
        <!-- Jumbotron -->
        <div
          class="px-4 py-5 px-md-5 text-center text-lg-start"
          style="background-color: hsl(0, 0%, 96%); min-height:90vh;"
        >
          <div class="container login-container">
            <div class="row gx-lg-5 align-items-center">
              <div class="col-lg-6 mb-5 mb-lg-0">
                <h1 class="my-5 display-3 fw-bold ls-tight">
                  Attendance <br />
                  <span class="text-primary">for your business</span>
                </h1>
                <p style="color: hsl(217, 10%, 50.8%)">
                  Lorem ipsum dolor sit amet consectetur adipisicing elit.
                  Eveniet, itaque accusantium odio, soluta, corrupti aliquam
                  quibusdam tempora at cupiditate quis eum maiores libero
                  veritatis? Dicta facilis sint aliquid ipsum atque?
                </p>
              </div>

              <div class="col-lg-6 mb-5 mb-lg-0">
                <div class="card">
                  <div class="card-body py-5 px-md-5">
                    <form action="RegisterServlet?page=existing" method="POST">
                      
                      <% if(session.getAttribute("error_msg") != null)  {%>

                      <div class="alert alert-danger alert-dismissible fade show" role="alert">
                          <%=session.getAttribute("error_msg")%>
                          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                      </div>

                      <% } %>
                      
                      <!-- Username input -->
                      <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example3"
                          >Username</label
                        >
                        <input
                          type="text"
                          id="form3Example3"
                          name="username"
                          class="form-control"
                          
                        />
                      </div>

                      <!-- Password input -->
                      <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example4"
                          >Password</label
                        >
                        <input
                          type="password"
                          id="form3Example4 pswd"
                          name="password"
                          class="form-control"
                          id="pswd"
                        />
                      </div>

                      <!-- Submit button -->
                      <button type="submit" onclick ="verifyPassword()" class="btn btn-primary btn-block mb-2">Sign in</button>

                      <p>
                        Don't have an account?
                        <a href="PageChange?page=register" class="link-info">Register here</a>
                      </p>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Jumbotron -->
      </section>
      <!-- Section: Design Block -->
    </div>

    
                      
                      <!-- Vendor JS Files -->
  <script src="Styling/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="Styling/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="Styling/assets/vendor/chart.js/chart.umd.js"></script>
  <script src="Styling/assets/vendor/echarts/echarts.min.js"></script>
  <script src="Styling/assets/vendor/quill/quill.min.js"></script>
  <script src="Styling/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="Styling/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="Styling/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="Styling/assets/js/main.js"></script>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    
    <script>  
        const btn = document.querySelector(".btn");
        
        btn.addEventListener("click", verifyPassword);
        
function verifyPassword() {  
  var pw = document.getElementById("pswd").value;  
  console.log("inside a function");
  //check empty password field  
  if(pw === "") {  
     document.getElementById("message").innerHTML = "**Fill the password please!";  
     console.log("Less than 8");
  }  
   
 //minimum password length validation  
  if(pw.length < 8) {  
      
     document.getElementById("message").innerHTML = "**Password length must be atleast 8 characters";  
  }  
  
//maximum length of password validation  
  if(pw.length > 15) {  
     document.getElementById("message").innerHTML = "**Password length must not exceed 15 characters";  
  } else {  
     alert("Password is correct");  
  }  
}  


</script>  



  </body>
</html>