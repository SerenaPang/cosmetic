function searchCosmetic(){
	let cosmeticName = document.getElementById("search_bar").value;
	
	cosmeticName = cosmeticName.trim();
	if(cosmeticName.length == 0){
		alert("Please write a comsetic product name");
		return;
	}
	searchCosmeticProductAjaxCall(cosmeticName);
}

function searchCosmeticProductAjaxCall(cosmeticName){
	let url = "/searchByQuery?query=" + cosmeticName;
	fetch(url)
		.then((response) => {
			//throws an error if the request did not succeed
			if (!response.ok) {
				throw new Error('HTTP error: ${response.status}');
			}
			//immediately returns the promise if the response succeeded
			return response.text();
		})
		.then((text)) => {
			const cosmetics = JSON.parse(text);
			renderCosmetics(cosmetics);
		})
		.catch((error)) => {
			alert('Could not fetch cosmetic products: ${error}');
		});
}






