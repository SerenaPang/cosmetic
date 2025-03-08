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
	   insertTableHeader(firstRow, "Quantity");
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
	       insertQuantityText(row, cosmetic.id);
	       insertAddToCartButton(row, cosmetic.id);

	       // add the row to the end of the table body
	       tbl.appendChild(row);
	   }
	   // appends <table> into <body>
	   resultsDiv.appendChild(tbl);
}

//<input type="button" value="Remove From Cart">
function insertRemoveFromCartButton(row, cosmeticId) {
    let button = document.createElement("input");
    button.type = "button";
    button.value = "Remove from cart";
	button.onclick = function () {
	       removeCosmetictFromCart(cosmeticId)
	};

	let cell = document.createElement("td");
	cell.appendChild(button);
	row.appendChild(cell);
}

function removeCosmetictFromCart(cosmeticId) {
    // Index to remove from cart array
	let index;

    for (let i = 0; i < cart.length ; i++) {
        if (cosmeticId == cart[i].id) {
			index = i;
            break;
        }
    }
	// Remove from cart one element starting from index.
	cart.splice(index, 1);
    renderCart();
}

function insertQuantityText(row, cosmeticId){
	//<input id="quantity_id" type="text" value="1">
	let text = document.createElement("input");
	text.type = "text";
	text.value = "1";
	text.id = "quantity_" + cosmeticId;

	let cell = document.createElement("td");
	cell.appendChild(text);
	row.appendChild(cell);
}

//<input type="button" value="Add to cart">
function insertAddToCartButton(row, cosmeticId) {
    let button = document.createElement("input");
    button.type = "button";
    button.value = "Add to cart";
	button.onclick = function () {
	       addCosmetictToCart(cosmeticId)
	};

	let cell = document.createElement("td");
	cell.appendChild(button);
	row.appendChild(cell);
}

//<input type="button" value="Submit Order">
function insertSubmitOrderButton() {
    let button = document.createElement("input");
    button.type = "button";
    button.value = "Submit Order";
	button.onclick = function () {
	       submitOrder(orderId)
	};
	let cell = document.createElement("td");
	cell.appendChild(button);
	row.appendChild(cell);
}

function submitOrder(orderId){
	let order;
	
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

	let quantityText = document.getElementById("quantity_" + cosmeticId);
	//console.info(element.value);

	cosmetic.quantity = quantityText.value;
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
        insertTableData(row, cosmetic.quantity);

        // TODO: Add remove button.
		insertRemoveFromCartButton(row, cosmetic.id);
        // add the row to the end of the table.
        tbl.appendChild(row);
    }
	
    // appends <table> into <body>
    myCartDiv.appendChild(tbl);
	
	//add order button
	let submitOrderButton = document.createElement("input");
	submitOrderButton.type = "button";
	submitOrderButton.value = "Submit Order";
	myCartDiv.appendChild(submitOrderButton);
}


