const proxy = require('http-proxy-middleware')
const express = require('express');
const path = require('path');


const app = express();
 
module.exports = function(app) {


    app.use(
        '/api/*',
        proxy({
            target: "http://localhost:8080/",
            changeOrigin: true
        })
    );



 
}