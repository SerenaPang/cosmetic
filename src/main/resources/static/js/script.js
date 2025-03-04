/* List of cosmetics in the cart. */
let cart = [];

/* List of cosmetics returned by the search query. */
let currentCosmetics = [];


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
			  currentCosmetics = cosmetics;
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

	       insertTableData(row, cosmetic.name);
	       insertTableData(row, cosmetic.description);
	       insertTableData(row, cosmetic.brand);
	       insertTableData(row, cosmetic.price);
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
	       addCosmetictToCart(cosmeticId)
	};
	row.appendChild(button);
}

function insertTableHeader(row, text) {
    let cell = document.createElement("th");
    let cellText = document.createTextNode(text);
    cell.appendChild(cellText);
    row.appendChild(cell);
}

function insertTableData(row, text) {
    let cell = document.createElement("td");
    let cellText = document.createTextNode(text);
    cell.appendChild(cellText);
    row.appendChild(cell);
}

function addCosmetictToCart(cosmeticId) {
    let cosmetic;

    for (let i = 0; i < currentCosmetics.length ; i++) {
        if (cosmeticId == currentCosmetics[i].id) {
            cosmetic = currentCosmetics[i];
            break;
        }
    }
  
    cart.push(cosmetic);
    renderCart();
}

/* Renders the content of the cart */
function renderCart() {
    // creates a <table> element.
    const tbl = document.createElement("table");
    const myCartDiv = document.getElementById("mycart");

    // Remove Previous elements in the div with id "mycart".
    while (myCartDiv.firstChild) {
        myCartDiv.removeChild(myCartDiv.firstChild);
    }

    const firstRow = document.createElement("tr");
    insertTableHeader(firstRow, "Name");
    insertTableHeader(firstRow, "Price");
    insertTableHeader(firstRow, "Quantity");
    tbl.appendChild(firstRow);

    // creating the table data
    for (let i = 0; i < cart.length; i++) {
        let cosmetic = cart[i];
        // creates a table row
        const row = document.createElement("tr");

        insertTableData(row, cosmetic.name);
        insertTableData(row, cosmetic.price);
        // TODO: Get the quantity from input box
        insertTableData(row, 1);

        // TODO: Add remove button.

        // add the row to the end of the table.
        tbl.appendChild(row);
    }
    // appends <table> into <body>
    myCartDiv.appendChild(tbl);
}


