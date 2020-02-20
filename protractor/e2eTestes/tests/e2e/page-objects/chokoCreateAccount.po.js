//chokoCreateAccount.po.js

var ChokoCreateAccountPage = function () {
    this.createAccountButton = element(by.id('element-create-account-submit'));
};

ChokoCreateAccountPage.prototype.visit = function () {
    browser.waitForAngularEnabled(false);
    browser.get('http://choko.org/create-account');
};

module.exports = ChokoCreateAccountPage;