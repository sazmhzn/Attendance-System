<%-- 
    Document   : StudentViewAttendance
    Created on : Apr 24, 2023, 11:16:39 AM
    Author     : lenovo
--%>

<%@page import="jakarta.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Absence Application</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Favicons -->
    <link href="Styling/assets/img/log.png" rel="icon" />
    <link href="Styling/assets/img/apple-touch-icon.png" rel="apple-touch-icon"
    />

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet"/>

    <!-- Vendor CSS Files -->
    <link href="Styling/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet"/>

    <link href="Styling/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet"/>
    <link href="Styling/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="Styling/assets/vendor/quill/quill.snow.css" rel="stylesheet"/>
    <link href="Styling/assets/vendor/quill/quill.bubble.css" rel="stylesheet"/>
    <link href="Styling/assets/vendor/remixicon/remixicon.css" rel="stylesheet"/>
    <link href="Styling/assets/vendor/simple-datatables/style.css" rel="stylesheet"/>

    <!-- Template Main CSS File -->
    <link href="Styling/assets/css/style.css" rel="stylesheet" />
  </head>

  <body>
    <!-- ======= Header ======= -->
    <header id="header" class="header fixed-top d-flex align-items-center">
      <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
          <img src="assets/img/logo.png" alt="" />
          <span class="d-none d-lg-block">Attendance</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
      </div>
      <!-- End Logo -->


      <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
          <li class="nav-item d-block d-lg-none">
            <a class="nav-link nav-icon search-bar-toggle" href="#">
              <i class="bi bi-search"></i>
            </a>
          </li>
          <!-- End Search Icon-->


          <li class="nav-item dropdown pe-3">
              <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <img src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
            <span class="d-flex justify-content-center align-items-center dropdown-toggle ps-2"> 
                <%
                   Cookie[] cookies = request.getCookies();
         
                    if( cookies != null ) {            
                    for (Cookie cookie:cookies) {
                        if( cookie.getName().equals("name")) {
                            out.print(" " + cookie.getValue( )+" ");
                        }
                    }
                    } else {
                            response.sendRedirect("Pages/login.jsp");
                     } 
                %>
                            
            </span>
          </a><!-- End Profile Image Icon -->
          
            <ul
              class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile"
            >
              <li class="dropdown-header">
                <h6> 
                    <%
                    
                    if( cookies != null ) {    
                    for (Cookie cookie:cookies) {
                        if( cookie.getName().equals("name")) {
                            out.print(" " + cookie.getValue( ));
                        } 
                    }
                        }else {
                            out.print(" Null ");
                        }
                    %> 
                </h6>
                <span>
                    <%
                    
                    if( cookies != null ) {    
                    for (Cookie cookie:cookies) {
                        if( cookie.getName().equals("role")) {
                       
                        out.print( cookie.getValue().equals("S")? "student": null);
                        } 
                    }
                        }else {
                            out.print(" Null ");
                        }
                    %> 
                </span>
              </li>
              <li>
                <hr class="dropdown-divider" />
              </li>

              <li>
                <a
                  class="dropdown-item d-flex align-items-center"
                  href="PageChange?page=Profile"
                >
                  <i class="bi bi-person"></i>
                  <span>My Profile</span>
                </a>
              </li>
              <li>
                <hr class="dropdown-divider" />
              </li>

              <li>
                <hr class="dropdown-divider" />
              </li>

              <li>
                <a class="dropdown-item d-flex align-items-center" href="PageChange?page=Logout">
                  <i class="bi bi-box-arrow-right"></i>
                  <span>Sign Out</span>
                </a>
              </li>
            </ul>
            <!-- End Profile Dropdown Items -->
          </li>
          <!-- End Profile Nav -->
        </ul>
      </nav>
      <!-- End Icons Navigation -->
    </header>
    <!-- End Header -->

    <!-- ======= Sidebar ======= -->
    <aside id="sidebar" class="sidebar">
      <ul class="sidebar-nav" id="sidebar-nav">
      

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=studentHome">
            <i class="bi bi-person"></i>
            <span>Attendance Report</span>
          </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
          <a class="nav-link " href="PageChange?page=AbsenceApplication">
            <i class="bi bi-question-circle"></i>
            <span>Absence Application</span>
          </a>
        </li>
        <!-- End F.A.Q Page Nav -->

        
        <li class="nav-heading">Extras</li>

        <li class="nav-item">
          <a class="nav-link collapsed" href="RegisterServlet?page=Logout">
            <i class="bi bi-box-arrow-in-right"></i>
            <span>Logout</span>
          </a>
        </li>
        <!-- End Login Page Nav -->
      </ul>
    </aside>
    <!-- End Sidebar-->

    
    <!-- ======= Main ======= -->
    <main id="main" class="main">
      <div class="pagetitle">
        <h1>Student</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="dashboard.html">Student</a></li>
            <li class="breadcrumb-item active">Attendance History</li>
            <!--<li class="breadcrumb-item ">Add Students</li>-->
          </ol>
        </nav>
        <button class="btn btn-primary"> <a href="PageChange?page=sendApplication" class="text-light"> send application </a>  </button>
      </div>
      <!-- End Page Title -->

    
      <section class="section dashboard">
        <div class="row">
          <div class="row">
                            
              <!-- Recent Sales -->
            <div class="col-12">
              <div class="card recent-sales overflow-auto">

                <div class="card-body">
                  <h5 class="card-title">Attendance Sheet </h5>

                  <table class="table table-borderless datatable">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col">Absence sent on</th>
                        <th scope="col">Status</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${messages}" var="messages">
                        <tr>
                        <td>${messages.id}</td>
                        <td>${messages.message}</td>
                        <td>${messages.category}</td>
                        <td>${messages.date}</td>
                        <td> <span class="badge ${messages.status == "pennding" ? "bg-success" : "bg-warning"}"> ${messages.status}</span></td>
                        </tr>
                        </c:forEach>
                    
                    </tbody>
                  </table>

                </div>

              </div>
            </div><!-- End Recent Sales -->
          </div>

      </div>
      </section>
    </main>
    <!-- End #main -->

    <a
      href="#"
      class="back-to-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>

    <!-- CDN file -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/datatables.net/1.13.3/jquery.dataTables.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/datatables.net-bs5/1.13.3/dataTables.bootstrap5.min.js"></script>

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

    <!-- Custome JS File -->
    <script>
      $(document).ready(function () {
        $("#example").DataTable();
      });
    </script>
    <script> 
    $('.alert').alert()
    </script>
  </body>
</html>

