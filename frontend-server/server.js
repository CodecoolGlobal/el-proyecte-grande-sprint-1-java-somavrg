const express = require("express");
const { createProxyMiddleware } = require("http-proxy-middleware");
const app = express();

app.use(express.static('./static'));
const path = require('path');

app.use("/api", createProxyMiddleware({target: "http://backend:8080", changeOrigin: true}));


app.get('*', (req, res) => {
    res.sendFile(path.resolve(__dirname, 'static', 'index.html'));
});

const PORT = process.env.PORT || 3000;
console.log('server started on port:',PORT);
app.listen(PORT);