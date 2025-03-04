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

function renderCosmetics(cosmetics){
	// creates a <table> element and a <tbody> element
	   const tbl = document.createElement("table");
	   const resultsDiv = document.getElementById("results");

	   // Remove Previous results
	   while (resultsDiv.firstChild) {
	       resultsDiv.removeChild(resultsDiv.firstChild);
	   }

	   const firstRow = document.createElement("tr");
	   insertTableHeader(firstRow, "Name");
	   insertTableHeader(firstRow, "Description");
	   insertTableHeader(firstRow, "Brand");
	   insertTableHeader(firstRow, "Price");
	   insertTableHeader(firstRow, "Order");
	   tbl.appendChild(firstRow);

	   // creating all cells
	   for (let i = 0; i < products.length; i++) {
	       let product = products[i];
	       // creates a table row
	       const row = document.createElement("tr");

	       insertTableField(row, cosmetic.name);
	       insertTableField(row, cosmetic.description);
	       insertTableField(row, cosmetic.brand);
	       insertTableField(row, cosmetic.price);
	       insertAddToCartButton(row, cosmetic.id);

	       // add the row to the end of the table body
	       tbl.appendChild(row);
	   }
	   // appends <table> into <body>
	   resultsDiv.appendChild(tbl);
}

function insertTableHeader(row, text) {
    let cell = document.createElement("th");
    let cellText = document.createTextNode(text);
    cell.appendChild(cellText);
    row.appendChild(cell);
}

function insertTableField(row, text) {
    let cell = document.createElement("td");
    let cellText = document.createTextNode(text);
    cell.appendChild(cellText);
    row.appendChild(cell);
}




