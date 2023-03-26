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
  </head>
  <body>
    <div class="container-fluid">
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
            AFY
          </a>
        </div>
      </nav>

      <!-- Section: Design Block -->
      <section class="login-section">
        <!-- Jumbotron -->
        <div
          class="px-4 py-5 px-md-5 text-center text-lg-start"
          style="background-color: hsl(0, 0%, 96%)"
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
                          required
                        />
                      </div>

                      <!-- Password input -->
                      <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example4"
                          >Password</label
                        >
                        <input
                          type="password"
                          id="form3Example4"
                          name="password"
                          class="form-control"
                          required
                        />
                      </div>

                      <!-- Submit button -->
                      <button type="submit" class="btn btn-primary btn-block mb-2">Sign in</button>

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

    

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
  </body>
</html>