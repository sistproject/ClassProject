<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Form Validator</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div class="container">
      <form id="form" class="form" method=post action="signin_ok.jsp">
        <h2>SIGN IN</h2>
        <div class="form_control">
          <label for="username">Username</label>
          <input type="text" id="username" placeholder="NAME" />
          <small>Error message</small>
        </div>
       <div class="form_control">
          <label for="id">ID</label>
          <input type="text" id="id" placeholder="ID" />
          <small>Error message</small>
        </div>
        <div class="form_control">
          <label for="email">Email</label>
          <input type="text" id="email" placeholder="EMAIL" />
          <small>Error message</small>
        </div>
        <div class="form_control">
          <label for="password">Password</label>
          <input type="password" id="password" placeholder="PASSWORD" />
          <small>Error message</small>
        </div>
        <div class="form_control">
          <label for="repassword">Confirm Password</label>
          <input type="password" id="repassword" placeholder="REPASSWORD" />
          <small>Error message</small>
        </div>
        <button class="btn_submit" disabled>Submit</button>
      </form>
    </div>
    <p class="notice">
      Welcome!
    </p>
    <script src="script.js" charset="UTF-8"></script>
  </body>
</html>