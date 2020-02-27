//paginaLogin.po.js

var PaginaLogin = function() {
    browser.waitForAngularEnabled(false);
    this.usernameField = element(by.id('username'));
    this.passwordField = element(by.id('password'));
    this.loginButton = element(by.name('submit'));
};

PaginaLogin.prototype.visit = function() {
    browser.get('https://testeap.intra.goias.gov.br/pas-acesso-app');
};

PaginaLogin.prototype.signIn = function(username, password){
    this.usernameField.sendKeys(username);
    this.passwordField.sendKeys(password);
    this.loginButton.click();
};

module.exports = PaginaLogin;

