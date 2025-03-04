
function searchCosmetic(){
	let cosmeticName = document.getElementById("search_bar").value;
	
	cosmeticName = cosmeticName.trim();
	if(cosmeticName.length == 0){
		alert("Please write a comsetic product name");
		return;
	}
	searchCosmeticAjaxCall(cosmeticName);
}

function searchCosmeticAjaxCall(cosmeticName){
	// Webservice URL to search for products.
	  let url = "/searchByQuery?query=" + cosmeticName;

	  // https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Scripting/Network_requests
	  // Call `fetch()`, passing in the URL.
	  fetch(url)
	      // fetch() returns a promise. When we have received a response from the server,
	      // the promise's `then()` handler is called with the response.
	      .then((response) => {
	          // Our handler throws an error if the request did not succeed.
	          if (!response.ok) {
	              throw new Error(`HTTP error: ${response.status}`);
	          }
	          // Otherwise (if the response succeeded), our handler fetches the response
	          // as text by calling response.text(), and immediately returns the promise
	          // returned by `response.text()`.
	          return response.text();
	      })
	      // When response.text() has succeeded, the `then()` handler is called with
	      // the text, and we copy it into the `poemDisplay` box.
	      .then((text) => {
	          // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/parse
	          const cosmetics = JSON.parse(text);
	          renderCosmetics(cosmetics);
	      })
	      // Catch any errors that might happen, and display a message
	      // in the `poemDisplay` box.
	      .catch((error) => {
	          alert(`Could not fetch cosmetics: ${error}`);
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
	   for (let i = 0; i < cosmetics.length; i++) {
	       let cosmetic = cosmetics[i];
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

function insertAddToCartButton(row, cosmeticId) {
    let button = document.createElement("input");
    button.type = "button";
    button.value = "Add to cart";
    button.onclick = function () {
        // TODO: Call webservice and add cosmetic.
        alert("Add to cart " + cosmeticId);
    };
    row.appendChild(button);
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




