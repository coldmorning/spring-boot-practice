let stompClient = null;

function setConnected(connected) {
    let k = connected || false;
    console.log(k);
    document.getElementById('connect').disabled = k;
    console.log("disc " +document.getElementById('disconnect'));
    document.getElementById('disconnect').disabled = !k;
    document.getElementById('conversationDiv').style.visibility
        = k ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {
    let socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    console.log("1");
    console.log(stompClient);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log("12");
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    });
}

function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    let nickName = document.getElementById('nickName').value;
    let inputMessage = document.getElementById('inputMessage').value;
    stompClient.send("/app/chat", {},
        JSON.stringify({'nickName':nickName, 'inputMessage':inputMessage}));
}

function showMessageOutput(messageOutput) {
    let response = document.getElementById('response');
    let p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(messageOutput.from + ": "
        + messageOutput.text + " (" + messageOutput.time + ")"));
    response.appendChild(p);
}