<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>

<body>
    <div class="container">
        <main class="loginMain">
        <!--Login section-->
            <section class="login">
               <!--Login box-->
                <article class="login__form__container">
                   <!--Login form-->
                   <div class="login__form">
                        <h1><img src="/images/logo.jpg" alt=""></h1>
                        
                        <!--Login input-->
                        <form class="login__input" action="/auth/signin" method="POST" >
                            <input type="text" name="username" placeholder="Username" required="required" />
                            <input type="password" name="password" placeholder="Password" required="required" />
                            <button>Login</button>
                        </form>
                        <!--Login input end-->
                        
                        <!--OR-->
                        <div class="login__horizon">
                            <div class="br"></div>
                            <div class="or">or</div>
                            <div class="br"></div>
                        </div>
                        <!--OR end-->
                        
                        <!--Oauth social login-->
                        <div class="login__facebook">
                            <button onclick="javascript:location.href='/oauth2/authorization/facebook'">
                                <i class="fab fa-facebook-square"></i>
                                <span>Login by Facebook</span>
                            </button>
                        </div>
                        <!--Oauth social login end-->
                    </div>
                    
                    <!--Don't you have an account?-->
                    <div class="login__register">
                        <span>Don't you have an account?</span>
                        <a href="/auth/signup">Register in</a>
                    </div>
                    <!--Don't you have an account? end-->
                </article>
            </section>
        </main>
        
    </div>
</body>

</html>
