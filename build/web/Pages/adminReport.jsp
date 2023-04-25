<%-- 
    Document   : adminReport
    Created on : Apr 22, 2023, 12:41:48 PM
    Author     : lenovo
--%>

<%@page import="jakarta.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Report</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Favicons -->
    <link href="Styling/assets/img/favicon.png" rel="icon" />
    <link
      href="Styling/assets/img/apple-touch-icon.png"
      rel="apple-touch-icon"
    />

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect" />
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet"
    />

    <!-- Vendor CSS Files -->
    <link
      href="Styling/assets/vendor/bootstrap-icons/bootstrap-icons.css"
      rel="stylesheet"
    />

    <link
      href="Styling/assets/vendor/boxicons/css/boxicons.min.css"
      rel="stylesheet"
    />

    <link
      href="Styling/assets/vendor/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
    />

    <link
      href="Styling/assets/vendor/quill/quill.snow.css"
      rel="stylesheet"
    />

    <link
      href="Styling/assets/vendor/quill/quill.bubble.css"
      rel="stylesheet"
    />

    <link
      href="Styling/assets/vendor/remixicon/remixicon.css"
      rel="stylesheet"
    />

    <link
      href="Styling/assets/vendor/simple-datatables/style.css"
      rel="stylesheet"
    />

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
            
            </ul>
            <!-- End Notification Dropdown Items -->
          </li>
          <!-- End Notification Nav -->

          <li class="nav-item dropdown pe-3">
            <a
              class="nav-link nav-profile d-flex align-items-center pe-0"
              href="#"
              data-bs-toggle="dropdown"
            >
              <img
                src="assets/img/profile-img.jpg"
                alt="Profile"
                class="rounded-circle"
              />
              <span class="d-none d-md-block dropdown-toggle ps-2"
                >
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
              </span
              > </a
            ><!-- End Profile Iamge Icon -->

            <ul
              class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile"
            >
                <li>
                <a
                  class="dropdown-item d-flex align-items-center"
                  href="users-profile.html"
                >
                  <i class="bi bi-person"></i>
                  <span>
                      
                      <%         
                    if( cookies != null ) {            
                    for (Cookie cookie:cookies) {
                        if( cookie.getName().equals("role")) {
                        if(cookie.getValue().equals("A")) {
                            out.print("Admin");
                          } else {
                          out.print("Null");
                          }
                            
                        }
                    }
                    } else {
                            response.sendRedirect("Pages/login.jsp");
                     } 
                %>
                      
                  </span>
                </a>
              </li>

              <li>
                <a
                  class="dropdown-item d-flex align-items-center"
                  href="users-profile.html"
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
                <hr class="dropdown-divider" />
              </li>

              <li>
                <a class="dropdown-item d-flex align-items-center" href="#">
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
        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=adminDashboard">
            <i class="bi bi-grid"></i>
            <span>Dashboard</span>
          </a>
        </li>
        <!-- End Dashboard Nav -->

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=AdminAttendanceSheet">
            <i class="bi bi-journal-check"></i>
            <span>Attendance Sheet</span>
          </a>
        </li>
        <!-- End Profile Page Nav -->
        
        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=AdminAbsenceReport">
            <i class="bi bi-journal-x"></i>
            <span>Absence Application</span>
          </a>
        </li>
        <!-- End Profile Page Nav -->
        
        <li class="nav-item">
          <a class="nav-link" href="PageChange?page=AdminReport">
            <i class="bi bi-journals"></i>
            <span>Report</span>
          </a>
        </li>
        <!-- End Report Page Nav -->
        
        <li class="nav-heading">manage</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="PageChange?page=Student">
                <i class="bi bi-mortarboard"></i></i><span>Students</span>
            </a>

        </li><!-- End Student Nav -->
      
      <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=Teacher">
            <i class="bi bi-person-workspace"></i>
            <span>Teacher</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=Subject">
            <i class="bi bi-stickies"></i>
            <span>Subject</span>
          </a>
        </li><!-- End Student Nav -->

        <li class="nav-item">
          <a class="nav-link collapsed" href="PageChange?page=Other">
            <i class="bi bi-journals"></i>
            <span>Others</span>
          </a>
        </li><!-- End Student Nav -->
        
        <li class="nav-heading">Extra</li>

        <li class="nav-item">
          <a class="nav-link collapsed" href="RegisterServlet?page=logout">
            <i class="bi bi-box-arrow-in-right"></i>
            <span>Logout</span>
          </a>
        </li>
        <!-- End Logout Page Nav -->
      </ul>
    </aside>
    <!-- End Sidebar-->
    
    <!-- ======= Main ======= -->
    <main id="main" class="main">
      <div class="pagetitle">
        <h1>Reports</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">Pages</li>
            <li class="breadcrumb-item active">Report</li>
            <!--<li class="breadcrumb-item ">Add Students</li>-->
          </ol>
        </nav>
        
      </div>
      <!-- End Page Title -->

    
      <section class="section dashboard">
        <div class="row">
             <!-- Top Selling -->
            <div class="col-12">
              <div class="card overflow-auto">

                <div class="card-body">
                  <h5 class="card-title">Reporting</h5>
                  <form
                    class="row g-3"
                    action="UserServlet?page=report"
                    method="POST"
                  >
                    <div class="col-md-4">
                      <div class="form-floating">
                        <input
                          type="date"
                          class="form-control"
                          placeholder="Your Name"
                          name="from"
                          id="date"
                          onload="getDate()"
                        />
                        <label for="floatingName">From</label>
                      </div>
                    </div>

                    <div class="col-4">
                      <div class="form-floating">
                        <input
                          type="date"
                          class="form-control"
                          placeholder="email"
                          id="floatingEmail"
                          name="to"
                        />
                        <label for="floatingTextarea">To</label>
                      </div>
                    </div>
                   
                      <div class="col-md-4">
                      <div class="form-floating">
                          <select
                              class="form-select"
                          id="floatingSelect"
                          aria-label="course"
                          name="subject_id"
                              >
                              <c:forEach items="${college}" var="college">
                                  <option value="${college.subject.subject_id}">${college.subject.subject_name}</option>
                              </c:forEach>
                          </select>
                       
                      </div>
                    </div>
                      
                    <div class="text-left">
                      <button
                        type="submit"
                        id="submitBtn"
                        class="btn btn-primary"
                      >
                        generate
                      </button>
                     
                    </div>
                  </form>
                </div>
              </div>
            </div><!-- End Top Selling -->
            
        </div>
          
          <div class="row">
             <!-- Top Selling -->
            <div class="col-12">
              <div class="card top-selling overflow-auto">

                <div class="card-body pb-0">
                  <h5 class="card-title">Student list </h5>

                  <table class="table table-borderless datatable">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Student name</th>
                        <th scope="col">Section</th>
                        <th scope="col">Total present</th>
                
                       
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach  items="${report}" var="report">
                            <tr>
                                <td  scope="row">${report.student.user.id}</td>
                                <td>${report.student.user.fullName}</td>
                                <td>${report.student.college.section.name}</td>
                                <td>${report.total}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div><!-- End Top Selling -->
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
       function getDate() {
  document.getElementById("date").defaultValue = "2014-02-09";
}
    
    </script>
  </body>
</html>

