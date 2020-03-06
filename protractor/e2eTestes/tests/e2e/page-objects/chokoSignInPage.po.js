// chokoSignInPage.po.js

var ChokoSignInPage = function() {
    this.usernameField = element(by.id('element-username'));
    this.passwordField = element(by.id('element-password'));
    this.signInButton = element(by.id('element-sign-in-submit'));
};
ChokoSignInPage.prototype.visit = function() {
    browser.get('http://choko.org/sign-in');
};

ChokoSignInPage.prototype.signIn = function(email, password){
    this.usernameField.sendKeys(email);
    this.passwordField.sendKeys(password);
    this.signInButton.click();
};

module.exports = ChokoSignInPage;

