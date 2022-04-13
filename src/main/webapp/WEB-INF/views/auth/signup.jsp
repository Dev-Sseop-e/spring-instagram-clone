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
           <!--Signup session-->
            <section class="login">
                <article class="login__form__container">
                  
                   <!--Signup form-->
                    <div class="login__form">
                        <!--Logo-->
                        <h1><img src="/images/logo.jpg" alt=""></h1>
                         <!--Logo end-->
                         
                         <!--Signup input-->
                        <form class="login__input" action="/auth/signup" method="post" >
                            <input type="text" name="username" placeholder="Username" required="required" />
                            <input type="password" name="password" placeholder="Password" required="required" />
                            <input type="email" name="email" placeholder="Email" required="required" />
                            <input type="text" name="name" placeholder="Name" required="required" />
                            <button>Register in</button>
                        </form>
                        <!--Signup input end-->
                    </div>
                    <!--Signup form end-->
                    
                    <!--Do you have an account?-->
                    <div class="login__register">
                        <span>Do you have an account?</span>
                        <a href="/auth/signin">Login</a>
                    </div>
                    <!--Do you have an account? end-->
                    
                </article>
            </section>
        </main>
    </div>
</body>

</html>
