var rootAddress = 'http://localhost:8080';
var defaultTimeout = 60 * 1000;
var businessNodeRoot = '';

$(document).ready(
		function() {
			let queryBusinessAlive = rootAddress
					+ '/gateway/query-business-alive';
			invokeJsonFunction(queryBusinessAlive, null, 'GET', defaultTimeout,
					handleBusinessNode, handleException, false);
		});

function handleBusinessNode(res, raw) {
	let code = res.code;
	let message = res.message;
	
	console.log("response code: " + code);
	console.log("response message: " + message);
	
	if(code == 'API-00000') {
		businessNodeRoot = res.payload;
		console.log("response session data: " + businessNodeRoot);
	}
}
function handleException(exp) {
	console.log(exp);
}

function callToBusinessNodeTest() {
	let queryBusinessAlive = businessNodeRoot
	+ '/bussiness-test/test';
	invokeJsonFunction(queryBusinessAlive, null, 'GET', defaultTimeout,
			handleSuccessed, handleExp, false);
}
function handleSuccessed(res, raw) {
	alert(JSON.stringify(res));
}
function handleExp(exp) {
	alert(exp);
}

function configAjax() {
	$.ajaxPrefilter(function(options, original_Options, jqXHR) {
		options.async = true;
	});
}

function blockUI() {
	$
			.blockUI({
				baseZ : 3000,
				blockMsgClass : 'blockMsgNew',
				message : '<img src="img/loading.gif" width = 50 height = 50/>&nbsp;&nbsp;&nbsp;&nbsp;<h4 style ="animation: blink 1s infinite;color: #fff">Loading...</h4>'
			});
}

function unblockUI() {
	$.unblockUI();
}

function invokeJsonFunction(url, datainput, method, timeout, functionName,
		errorHandle, isSendData) {
	blockUI();
	configAjax();

	if (isSendData) {
		$.ajax({
			url : url,
			crossDomain : true,
			cache : false,
			dataType : 'json',
			type : method,
			data : JSON.stringify(datainput),
			contentType : 'application/json',
			timeout : timeout,
			async : true,
			processData : false,
			success : function(data, textStatus, jQxhr) {
				functionName(data, datainput);
				unblockUI();
			},
			error : function(jqXhr, textStatus, errorThrown) {
				errorHandle(textStatus);
				unblockUI();
			}
		});
	} else {
		$.ajax({
			url : url,
			crossDomain : true,
			cache : false,
			dataType : 'json',
			type : method,
			contentType : 'application/json',
			timeout : timeout,
			async : true,
			processData : false,
			success : function(data, textStatus, jQxhr) {
				functionName(data, datainput);
				unblockUI();
			},
			error : function(jqXhr, textStatus, errorThrown) {
				errorHandle(textStatus);
				unblockUI();
			}
		});
	}
}
