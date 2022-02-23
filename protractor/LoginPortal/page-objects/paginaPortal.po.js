//paginaPortal.po.js

var PaginaPortal = function() {
    browser.waitForAngularEnabled(false);
    this.searchField = element(by.xpath('//*[@id="content"]/div/section/div/h2'));
};

module.exports = PaginaPortal;

