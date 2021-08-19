const apiUrl =
    location.protocol +
    "//" +
    location.hostname +
    ":8080" +
    process.env.BASE_URL +
    "api";

export default {
    fetchCategories() {
        const url = apiUrl + "/categories";
        console.log("GET from " + url);
        return fetch(url)
            .then (response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Network response was not ok.");
            })
            .catch(reason => {
                console.log("Error fetching category data", reason);
            });
    },
    fetchSelectedCategoryBooks(name) {
        const url = apiUrl + "/categories/name/" + name + "/books";
        console.log("GET from " + url);
        return fetch(url)
            .then (response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Network response was not ok.");
            })
            .catch(reason => {
                console.log("Error fetching category data, ApiService.js", reason);
                throw reason;
            });
    },
    placeOrder(order) {
        console.log("POSTing to " + `${apiUrl}/orders`);
        return fetch(`${apiUrl}/orders`, {
            method: "POST",
            body: JSON.stringify(order),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(stream => {
            if (stream.ok) {
                return stream.json();
            }
            throw new Error("Network response was not ok.");
        });
    },
};