/*eslint-env browser, amd*/
//define(["orion/plugin", "orion/xhr"], function(PluginProvider, xhr) {
define(["orion/plugin"], function(PluginProvider) {
	var headers = {
		name: "FOAM Commands Plugin1",
		version: "1.0",
		description: "FOAM Commands Plugin1"
	};
	var provider = new PluginProvider(headers);
	
	var serviceProperties = {
		name: "Run FOAM verification",
		id: "sample.commands.sample1",
		key: [119], // F8
		image: "../images/gear.gif",
		forceSingleItem: true,
		tooltip: "Run FOAM verification on selected dir" /* TODO - disable on file, retain only project/dir */	
	};
	
	var serviceImpl = {
		run : function(selectedText, text, selection, fileName) {
			// TODO - I wasn't able to get xhr working with orion js library
			// so I'm using normal js xhr calls.

//			var url = "http://localhost:8080/foam" + item.Location;
//			
//			var myXhr = new XMLHttpRequest();
//			myXhr.open("GET", url, true);
//			
//			return xhr("GET", url, {
//				headers: {
//					"Orion-Version": "1"
//				},
//				timeout: 15000
//			}, myXhr).then(
//			function(result) {
//				window.alert("> Running FOAM verification on: " + result);
//			},
//			function(error) {
//				var error = JSON.stringify(error);
//				window.alert("> Error running FOAM verification: " + error + " url: " + url);
//				window.console.log(error);
//				window.console.log(url);
//			});

			// All HTML5 Rocks properties support CORS.
			// fileName contains file name of the file opened in editor
			// e.g. /file/jiri-OrionContent/foam/ucs/UC1_Process_Sale.uc
			// TODO - address from some propeperty
			var url = 'http://localhost:8081/foam' + fileName;
			
			var xhr = new XMLHttpRequest();
			xhr.open('GET', url, true);
			
			// Response handlers.
			xhr.onload = function() {
				//var responseText = xhr.responseText;
				//window.alert('Response from CORS request to ' + url + ': ' + responseText);
				var parts = fileName.split("/");
				// TODO - hardcoded address
				var resultUrl = [
					"http://localhost:8080", 
					parts[1], parts[2], parts[3], 
					"out/index.html"
				].join("/");
				
				window.open(resultUrl);
			};
			
			xhr.onerror = function(error) {
				window.alert('Woops, there was an error making the request.');
				window.console.log(error);
			};
			
			xhr.send();
		}
	};
	
	provider.registerService("orion.edit.command", serviceImpl, serviceProperties);
	provider.connect();
});
