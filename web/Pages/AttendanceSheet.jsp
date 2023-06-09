<%-- 
    Document   : AttendanceSheet
    Created on : Mar 8, 2023, 10:06:03 AM
    Author     : lenovo
--%>
<%@page import="jakarta.servlet.http.Cookie" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Attendify</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Favicons -->
    <link href="Styling/assets/img/log.png" rel="icon" />
    <link href="Styling/assets/img/apple-touch-icon.png" rel="apple-touch-icon"/>

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet"
    />

    <!-- Vendor CSS Files -->
  <link href="Styling/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="Styling/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="Styling/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="Styling/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="Styling/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="Styling/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="Styling/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="Styling/assets/css/style.css" rel="stylesheet" />

  </head>

  <body>
    <!-- ======= Header ======= -->
    <header id="header" class="header fixed-top d-flex align-items-center">
      <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
          <img src="assets/img/logo.png" alt="" />
          <span class="d-none d-lg-block">Attendify</span>
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

          <li class="nav-item dropdown">
            <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
              <i class="bi bi-bell"></i>
              <span class="badge bg-primary badge-number">${message_size}</span> </a
            ><!-- End Notification Icon -->

            <ul
              class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications"
            >
              <li class="dropdown-header">
                You have ${message_size} new notifications
               
              </li>
              <li>
                <hr class="dropdown-divider" />
              </li>
              
              <c:forEach items="${messages}" var="message">
                  <li class="notification-item">
                      <i class="bi bi-x-circle text-danger"></i>
                      <div>
                          <h4>${message.student.user.fullName}</h4>
                          <p>${message.message}</p>
                          <p>1 hr. ago</p>
                      </div>
                  </li>
              </c:forEach>

              <li>
                <hr class="dropdown-divider" />
              </li>
             
            </ul>
            <!-- End Notification Dropdown Items -->
          </li>
          <!-- End Notification Nav -->

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
                       
                        out.print( cookie.getValue().equals("T")?" Teacher" : null);
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
          <a class="nav-link " href="PageChange?page=attendanceSheet">
            <i class="bi bi-journal-check"></i>
            <span>Attendance Sheet</span>
          </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=studentDetailsTeac">
            <i class="bi bi-stickies"></i>
            <span>Student</span>
          </a>
        </li>
        <!-- End F.A.Q Page Nav -->

        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=Report">
            <i class="bi bi-journals"></i>
            <span>Report</span>
          </a>
        </li>
        <!-- End Contact Page Nav -->
        
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
        <h1>Attendance</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="dashboard.html">Pages</a></li>
            <li class="breadcrumb-item active">Attendance sheet</li>
          </ol>
        </nav>
      </div>
      <!-- End Page Title -->

      <section class="section dashboard">
        <div class="row">
         
          <div class="row">
                            
              <!-- Recent Sales -->
            <div class="col-12">
              <div class="card recent-sales overflow-auto">

                <div class="card-body">
                  <h5 class="card-title">Recent Attendance <span>| Today</span></h5>

                  <table class="table table-borderless datatable">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Subject name</th>
                        <th scope="col">Subject Code</th>
                        <th scope="col">Semester</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${subjectList}" var="college">
                        <tr>
                        <th scope="row">#${college.subject.subject_id}</th>
                        <td>${college.subject.subject_name}</td>
                        <td>${college.subject.subject_code}</td>
                        <td>${college.semester.name}</td>
                        <td> 
                          ${college.attendance.status ? 'Taken' : 'Not taken'} 
                        </td>
                        <td><a href="PageChange?page=takeAttendanceSheet&subject_id=${college.subject.subject_id}" class="text-light btn btn-primary"> Take attendance</a></td>
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
       <script>
      const checkAll = document.querySelector(".check-all");
      const checkMe = document.querySelectorAll('input[name="roll"]');

      checkAll.addEventListener("click", function () {
        if (checkAll.checked == true) {
          console.log("The main check box is checked");
          let btn = checkMe.forEach((item) => {
            item.checked = true;
            console.log(item.value);
          });
        } else if (checkAll.checked !== null) {
          let btn = checkMe.forEach((item) => {
            item.checked = false;
          });
        }
      });
    </script>
  </body>
  
</html>