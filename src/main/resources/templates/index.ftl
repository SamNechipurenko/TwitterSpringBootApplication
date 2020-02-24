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

            <#foreach message in messageList>
                <tr>
                    <td>${message.getId()}</td>
                    <td>${message.getMessage()}</td>
                    <td>${message.getDate()}</td>
                    <td>
                        <form action="/chooseMsg" method="GET">
                            <input type="hidden" name="productId" value=${message.getId()}>
                            <input class="btn-success" type="submit" value="choose">
                        </form>
                    </td>
                </tr>
            </#foreach>
        </table>

        <form action="/sendMsg" method="POST">
            <table>
                <tr>
                    <td>message: </td>
                    <td>
                        <input type="text" class="form-control"
                               name="message" placeholder="enter your message">
                    </td>
                    <td>
                        <input class="btn-success" type="submit" value="SEND">
                    </td>
                </tr>
            </table>
        </form>
</body>
