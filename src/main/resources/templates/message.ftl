<!DOCTYPE HTML>

<head>
    <title>twitter</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="shortcut icon" type="image/x-icon"
          href="https://upload.wikimedia.org/wikipedia/ru/thumb/9/9f/Twitter_bird_logo_2012.svg/1200px-Twitter_bird_logo_2012.svg.png">
</head>

<body>
simple messaging:
    <table>
        <tr>
            <td>id</td>
            <td>message</td>
            <td>date</td>
        </tr>
    `   <tr>
            <td>${message.getId()}</td>
            <td>${message.getMessage()}</td>
            <td>${message.getDate()}</td>
        </tr>
    </table>

    <form action="/sendComment" method="POST">
        <table>
            <tr>
                <td>all comments: </td>
                <td>
                    <input type="text" name="comment" placeholder="enter your comment">
                </td>
                <td>
                <input type="submit" value="SEND">
                </td>
            </tr>
        </table>
    </form>
</body>
