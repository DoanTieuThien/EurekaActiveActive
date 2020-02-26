let loginUrlRequest = '/login';

function callLoginRequest() {
	let fullRequest = rootAddress + loginUrlRequest;
	let loginInput = {
			userName: $('#exampleInputEmail').val(),
			password: $('#exampleInputPassword').val()
	};
	invokeJsonFunction(fullRequest,loginInput,'POST',defaultTimeout,handleLoginSuccessed,handleLoginError,true);
}

function handleLoginSuccessed(res,rawInput) {
	let code = res.code;
	let message = res.message;
	console.log("login finished reuqest");
	console.log("response code: " + code);
	console.log("response message: " + message);
	
	if(code == 'API-00000') {
		console.log("response session data: " + JSON.stringify(res.payload));
	}
}

function handleLoginError(errorEvent) {
	console.log("login error: " + errorEvent);
}