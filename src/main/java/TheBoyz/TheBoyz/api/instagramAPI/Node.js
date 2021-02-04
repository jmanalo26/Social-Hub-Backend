const http = require("https");

const options = {
    "method": "GET",
    "hostname": "instagram28.p.rapidapi.com",
    "port": null,
    "path": "/follower_count?user_id=10206720",
    "headers": {
        "x-rapidapi-key": "cf774832acmshd4cebf0d63a1cffp1f06fajsn0aa94789da0c",
        "x-rapidapi-host": "instagram28.p.rapidapi.com",
        "useQueryString": true
    }
};

const req = http.request(options, function (res) {
    const chunks = [];

    res.on("data", function (chunk) {
        chunks.push(chunk);
    });

    res.on("end", function () {
        const body = Buffer.concat(chunks);
        var followers = body.toString().split(",", 1);
        console.log(followers)
    });
});
req.end();
const option = {
    "method": "GET",
    "hostname": "instagram28.p.rapidapi.com",
    "port": null,
    "path": "/username?user_id=10206720",
    "headers": {
        "x-rapidapi-key": "cf774832acmshd4cebf0d63a1cffp1f06fajsn0aa94789da0c",
        "x-rapidapi-host": "instagram28.p.rapidapi.com",
        "useQueryString": true
    }
};

const reqs = http.request(option, function (res) {
    const chunks = [];

    res.on("data", function (chunk) {
        chunks.push(chunk);
    });

    res.on("end", function () {
        const body = Buffer.concat(chunks);
        const userInfo = body.toString().split(",");


        console.log(userInfo)
    });
});

reqs.end();