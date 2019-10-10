var stompClient = null;

//与服务器建立连接
function connect() {
    var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        //接收服务端发送来的更改后的文本
        stompClient.subscribe('/topic/getShareWord', function (result) {
            //一旦收到信息就调用showContent 实时显示
            showContent(JSON.parse(result.body));
        });


    });
}

//客户端向服务器发送聊天信息
function sendMes() {
    stompClient.send("/app/shareWord", {}, JSON.stringify({'content': $("#markdown").val()}));
}

// function showUser(body) {
//     console.log("inininnini")
//     $("#userList").get(0).innerHTML = "<p>" + body.content +"</p>";
// }

function showContent(body) {
    console.log(body)
    $("#markdown").val(body.content);
}

// function start() {
//
//     connect();
//
//     $( "#send" ).click(function() { sendMes(); });
//
// };