<%-- 
    Document   : StudentDetails
    Created on : Mar 17, 2023, 10:31:18 AM
    Author     : lenovo
--%>
<%@page import="jakarta.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />

        <title>Take attendance</title>
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

                    <li class="nav-item dropdown">
                        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                            <i class="bi bi-bell"></i>
                            <span class="badge bg-primary badge-number">4</span> </a
                        ><!-- End Notification Icon -->

                        <ul
                            class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications"
                            >
                            <li class="dropdown-header">
                                You have 4 new notifications
                                <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a
                                >
                            </li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>

                            <li class="notification-item">
                                <i class="bi bi-exclamation-circle text-warning"></i>
                                <div>
                                    <h4>Lorem Ipsum</h4>
                                    <p>Quae dolorem earum veritatis oditseno</p>
                                    <p>30 min. ago</p>
                                </div>
                            </li>

                            <li>
                                <hr class="dropdown-divider" />
                            </li>

                            <li class="notification-item">
                                <i class="bi bi-x-circle text-danger"></i>
                                <div>
                                    <h4>Atque rerum nesciunt</h4>
                                    <p>Quae dolorem earum veritatis oditseno</p>
                                    <p>1 hr. ago</p>
                                </div>
                            </li>

                            <li>
                                <hr class="dropdown-divider" />
                            </li>

                            <li class="notification-item">
                                <i class="bi bi-check-circle text-success"></i>
                                <div>
                                    <h4>Sit rerum fuga</h4>
                                    <p>Quae dolorem earum veritatis oditseno</p>
                                    <p>2 hrs. ago</p>
                                </div>
                            </li>

                            <li>
                                <hr class="dropdown-divider" />
                            </li>

                            <li class="notification-item">
                                <i class="bi bi-info-circle text-primary"></i>
                                <div>
                                    <h4>Dicta reprehenderit</h4>
                                    <p>Quae dolorem earum veritatis oditseno</p>
                                    <p>4 hrs. ago</p>
                                </div>
                            </li>

                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li class="dropdown-footer">
                                <a href="#">Show all notifications</a>
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
                        </a><!-- End Profile Iamge Icon -->

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
                                <span>Web Designer</span>
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
                                <a
                                    class="dropdown-item d-flex align-items-center"
                                    href="users-profile.html"
                                    >
                                    <i class="bi bi-gear"></i>
                                    <span>Account Settings</span>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>

                            <li>
                                <a
                                    class="dropdown-item d-flex align-items-center"
                                    href="pages-faq.html"
                                    >
                                    <i class="bi bi-question-circle"></i>
                                    <span>Need Help?</span>
                                </a>
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
                    <a class="nav-link collapsed" href="dashboard.html">
                        <i class="bi bi-grid"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <!-- End Dashboard Nav -->

                <li class="nav-heading">Pages</li>

                <li class="nav-item">
                    <a class="nav-link" href="PageChange?page=attendanceSheet&teach_id=">
                        <i class="bi bi-person"></i>
                        <span>Attendance Sheet</span>
                    </a>
                </li>
                <!-- End Profile Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="./studentList.html">
                        <i class="bi bi-question-circle"></i>
                        <span>Student</span>
                    </a>
                </li>
                <!-- End F.A.Q Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-contact.html">
                        <i class="bi bi-envelope"></i>
                        <span>Report</span>
                    </a>
                </li>
                <!-- End Contact Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="PageChange?page=addTeacher">
                        <i class="bi bi-card-list"></i>
                        <span>Teacher</span>
                    </a>
                </li>
                <!-- End Register Page Nav -->
                <li class="nav-heading">Extra</li>

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
                        <li class="breadcrumb-item ">Subjects</li>
                        <li class="breadcrumb-item active">Take Attendance</li>
                    </ol>
                </nav>

            </div>
            <!-- End Page Title -->

            <section class="section dashboard">
                <div class="row">
                    <!-- Top Selling -->
                    <div class="col-12">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Section A</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Section B</button>
                            </li>

                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <div class="row">
                                    <!-- Top Selling -->
                                    <div class="col-12">
                                        <div class="card top-selling overflow-auto">

                                            <div class="card-body pb-0">
                                                <h5 class="card-title">Student list </h5>

                                                <table class="table table-borderless">
                                                    <thead>
                                                        <tr>
                                                            <th><input type="checkbox" id="checkAll"></th>
                                                            <th scope="col"> #</th>
                                                            <th scope="col">Student name</th>
                                                            <th scope="col">Semester</th>
                                                            <th scope="col">Course</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <form action="AttendanceServlet?page=takeAttendance" method="POST">
                                                        <c:forEach  items="${employeeList}" var="employee">
                                                            <tr>
                                                                <td><input type="checkbox" name="attendance" value="${employee.user.id}" ></td>
                                                                <td  scope="row">${employee.user.id}</td>
                                                                <td>${employee.user.fullName}</td>
                                                                <td>${employee.user.email}</td>
                                                                <td>${employee.user.address}</td>

                                                            </tr>
                                                        </c:forEach>

                                                            <tr> 
                                                                <td><button>Submit</button>  </td>

                                                            </tr>
                                                    </form>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div><!-- End Top Selling -->
                                </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
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
                                                            <th scope="col">Email</th>
                                                            <th scope="col">Address</th>
                                                            <th scope="col">Phone</th>
                                                            <th scope="col">Semester</th>
                                                            <th scope="col">Course</th>
                                                            <th scope="col">Section</th>
                                                            <th scope="col">Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach  items="${employeeListB}" var="employee">
                                                            <tr>
                                                                <td  scope="row">${employee.user.id}</td>
                                                                <td>${employee.user.fullName}</td>
                                                                <td>${employee.user.email}</td>
                                                                <td>${employee.user.address}</td>
                                                                <td>${employee.user.phone}</td>
                                                                <td>${employee.college.semester.name}</td>
                                                                <td>${employee.college.course.name}</td>
                                                                <td>${employee.college.section.name}</td>
                                                                <td>
                                                                    <button type="button" class="btn btn-primary" >
                                                                        <a href="PageChange?page=editStudent&userId=${employee.user.id}" class="text-light"> <i class="bi bi-pencil"></i> edit</a>  
                                                                    </button>

                                                                    <!-- Button trigger modal -->
                                                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${employee.user.id}">
                                                                        <i class="bi bi-trash3"></i> Delete
                                                                    </button>

                                                                    <!-- Modal -->
                                                                    <div class="modal fade" id="exampleModal${employee.user.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                        <div class="modal-dialog">
                                                                            <div class="modal-content">
                                                                                <div class="modal-header">
                                                                                    <h5 class="modal-title" id="exampleModalLabel">Are you sure?</h5>
                                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                </div>
                                                                                <div class="modal-body">
                                                                                    You cannot undo this action
                                                                                </div>
                                                                                <div class="modal-footer">
                                                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Nope</button>
                                                                                    <button type="button" class="btn btn-primary">
                                                                                        <a href="UserServlet?page=deleteStudent&accId=${employee.roll}" class="text-light">Sure</a> 
                                                                                    </button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div><!-- End Top Selling -->
                                </div>
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
            $('.alert').alert()
        </script>
         <script>
      $(document).ready(function() {
        $("#checkAll").click(function() {
          $("input[type=checkbox]").prop('checked', $(this).prop('checked'));
        })
            });
  </script>
    </body>
</html>

