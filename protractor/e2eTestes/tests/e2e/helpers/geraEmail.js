//geraEmail.js

var uuid = require('shortid');

var GeraEmail = function () { };

GeraEmail.prototype.generateRandomEmail = function () {
    return shortid.generateRandomEmail() + '@email.com';
};

module.exports = GeraEmail;