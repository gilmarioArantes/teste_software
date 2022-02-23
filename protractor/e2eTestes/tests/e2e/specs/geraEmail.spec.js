//geraString.spec.js

var GeraString = require('../helpers/geraString');
var GeraEmail = require('../helpers/geraEmail');
var ChokoSignInPage = require('../page-objects/chokoSignInPage.po')
var TimeOut = require('../helpers/timeOut')

describe('Todo MVC Angular', function () {
    var geraString = new GeraString();
    var geraEmail = new GeraEmail();
    var chokoSignInPage = new ChokoSignInPage();
    var timeOut = new TimeOut();

    it('try to sign in with a random email and random password', function () {
                
        var randomString = geraString.generateRandomString();
        var randomEmail = geraEmail.generateRandomEmail();

        chokoSignInPage.visit();
        timeOut.waitElementVisibility(chokoSignInPage.usernameField);
        timeOut.waitElementVisibility(chokoSignInPage.passwordField);

        chokoSignInPage.signIn(randomEmail,randomString);

        expect(messageWrapper.errorMessage.isDisplayed()).toBe(true);
    });
});