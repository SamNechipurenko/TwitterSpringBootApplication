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
list of comments:
    <table>
        <tr>
            <td>comment id</td>
            <td>comment</td>
            <td>date</td>
        </tr>

        <#foreach comment in comments>
            <tr>
                <td>${comment.getCommentId()}</td>
                <td>${comment.getComment()}</td>
                <td>${comment.getDate()}</td>
            </tr>
        </#foreach>
    </table>

    <form action="/sendComment" method="Get">
        <table>
            <tr>
                <td>all comments: </td>
                <td>
                    <input type="hidden" name="messageId" value=${message.getId()}
                </td>
                <td>
                    <input type="text" name="comment" placeholder="enter your comment">
                    <input type="submit" value="SEND">
                </td>
            </tr>
        </table>
    </form>
</body>
