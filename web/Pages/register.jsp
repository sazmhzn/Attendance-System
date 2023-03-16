<%-- 
    Document   : register
    Created on : Mar 7, 2023, 9:20:12 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

    <title>Register!</title>
  </head>
  <body>
    <div class="container-fluid">
      <!-- Just an image -->
      <nav class="navbar navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="#">
            <img
              src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
              height="20"
              alt="MDB Logo"
              loading="lazy"
            />
          </a>
        </div>
      </nav>

      <!-- Section: Design Block -->
      <section class="login-section">
        <!-- Jumbotron -->
        <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
          <div class="container">
            <div class="row gx-lg-5 align-items-center">
              <div class="col-lg-6 mb-5 mb-lg-0">
                <h1 class="my-5 display-3 fw-bold ls-tight">
                  The best offer <br />
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
                      <form action="RegisterServlet?page=newUser" method="POST">
                      <!-- 2 column grid layout with text inputs for the first and last names -->
                      <div class="row">
                          
                          <div class="form-outline mb-4 d-flex gap-3">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="role" value="T" id="flexRadioDefault1" for>
                          <label class="form-check-label" for="flexRadioDefault1">
                              Teacher
                          </label>
                      </div>
                      <div class="form-check">
                          <input class="form-check-input" type="radio" name="role" value="A" id="flexRadioDefault2" checked>
                          <label class="form-check-label" for="flexRadioDefault2">
                              Admin
                          </label>
                      </div>  
                      </div>
                        <div class="col-md-6 mb-4">
                          <div class="form-outline">
                            <label class="form-label" for="form3Example1">First name</label>
                            <input type="text" name="fname" id="form3Example1" class="form-control" />
                            
                          </div>
                        </div>
                        <div class="col-md-6 mb-4">
                          <div class="form-outline">
                            <label class="form-label" for="form3Example2">Last name</label>
                            <input type="text" name="lname" id="form3Example2" class="form-control" />
                            
                          </div>
                        </div>
                      </div>
      
                      <!-- Email input -->
                      <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example3">Username</label>
                        <input type="text" name="username" id="form3Example3" class="form-control" />
                       
                      </div>
      
                      <!-- Password input -->
                      <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example4">Password</label>
                        <input type="password" name="password" id="form3Example4" class="form-control" />
                        
                      </div>
      
                      <!-- Submit button -->
                      <button type="submit" class="btn btn-primary btn-block mb-4">
                        Sign up
                      </button>
                      <p class="small mb-5 pb-lg-2">
                        <a class="text-muted" href="#!">Forgot password?</a>
                      </p>
                      <p>
                        Don't have an account?
                        <a href="PageChange?page=login" class="link-info">Login here</a>
                      </p>
                      </div>
                      
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
