<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录页面</title>
    <style>
        body{
            margin: 0;
            padding: 0;
        }
        .login{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            color: white;
            width: 500px;
            height: 300px;
            background-color: #b78686;
        }
    </style>
</head>
<body>
    <div class="login">
        <form action="/account/user/login" method="post">
            <label for="userName">
                用户名
            </label>
            <input type="text" name="userName" id="userName">
            <br>
            <label for="passWord">
                密码
            </label>
            <input type="password" name="passWord" id="passWord">
            <br>
            <input type="checkbox" name="remember-me" value="true"/>
            <input type="submit" value="登录">
            <input type="reset" value="重置">
        </form>
    </div>
</body>
</html>