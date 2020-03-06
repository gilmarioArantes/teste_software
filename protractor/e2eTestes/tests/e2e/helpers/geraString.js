//geraString.js

var uuid = require('node-uuid');

var GeraString = function () { };

GeraString.prototype.generateRandomString = function () {
    return uuid.v4();
};

module.exports = GeraString;