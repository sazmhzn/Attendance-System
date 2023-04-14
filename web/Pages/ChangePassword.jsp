<%-- 
    Document   : ForgotPassword
    Created on : Apr 3, 2023, 10:36:30 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Pages / Login</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Favicons -->
    <link href="Styling/assets/img/favicon.png" rel="icon" />
    <link href="Styling/assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect" />
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet"
    />

    <!-- Vendor CSS Files -->
    <link
      href="Styling/assets/vendor/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="Styling/assets/vendor/bootstrap-icons/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link href="Styling/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
    <link href="Styling/assets/vendor/quill/quill.snow.css" rel="stylesheet" />
    <link href="Styling/assets/vendor/quill/quill.bubble.css" rel="stylesheet" />
    <link href="Styling/assets/vendor/remixicon/remixicon.css" rel="stylesheet" />
    <link href="Styling/assets/vendor/simple-datatables/style.css" rel="stylesheet" />

    <!-- Template Main CSS File -->
    <link href="Styling/assets/css/style.css" rel="stylesheet" />

    <!-- =======================================================
  * Template Name: NiceAdmin - v2.5.0
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  </head>

  <body>
    <main>
      <div class="container">
        <section
          class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4"
        >
          <div class="container">
            <div class="row justify-content-center">
              <div
                class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center"
              >
                <div class="d-flex justify-content-center py-4">
                  <a
                    href="index.html"
                    class="logo d-flex align-items-center w-auto"
                  >
                    <span class="d-none d-lg-block">Attendify</span>
                  </a>
                </div>
                <!-- End Logo -->

                <div class="card mb-3">
                  <div class="card-body">
                    <div class="pt-4 pb-2">
                      <h5 class="card-title text-center pb-0 fs-4">
                        Forgot password
                      </h5>
                      <p class="text-center small">Enter a new password</p>
                    </div>

                      <form class="row g-3 needs-validation" action="RegisterServlet?page=changePassword" method="POST" novalidate>
                          <input type="hidden" name="id" value="${user.id}"> 
                      <div class="col-12">
                        <label for="yourUsername" class="form-label"
                          >Password</label
                        >
                        <div class="input-group has-validation">
                         
                          <input
                            type="password"
                            name="password"
                            class="form-control"
                            id="yourPassword"
                            
                            required
                          />
                          <div class="invalid-feedback">
                            Please enter your new password.
                          </div>
                        </div>
                      </div>

                      <div class="col-12">
                        <button class="btn btn-primary w-100" type="submit">
                          Change
                        </button>
                      </div>
                    
                    </form>
                  </div>
                </div>

                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </main>
    <!-- End #main -->

    <a
      href="#"
      class="back-to-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>

    <!-- Vendor JS Files -->
    <script src="Styling/assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="Styling/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="Styling/assets/vendor/chart.js/chart.umd.js"></script>
    <script src="Styling/assets/vendor/echarts/echarts.min.js"></script>
    <script src="Styling/assets/vendor/quill/quill.min.js"></script>
    <script src="Styling/assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="Styling/assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="Styling/assets/vendor/php-email-form/validate.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <!-- Template Main JS File -->
    <script src="Styling/assets/js/main.js"></script>
    <script>
    $(document).ready(function(){
    // Get value on button click and show alert
    $(".btn").click(function(e){
        var str = $("#yourPassword").val();

        if (str == "") { 
            $(".invalid-feedback").html("The value is null")
        } else {
            if(str.length < 8) {
                e.preventDefault();
                $(".invalid-feedback").html("The length is less than 8").show();
                $("#yourPassword").addClass("is-invalid")
                return false;
            }
            $("#yourPassword").removeClass("is-invalid")
            $(".invalid-feedback").hide()
        }

    });
});
</script>
  </body>
</html>
