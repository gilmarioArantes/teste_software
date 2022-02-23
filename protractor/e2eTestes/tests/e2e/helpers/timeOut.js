//timeOut.js

var EC = protractor.ExpectedConditions();

var TimeOut = function(){};

TimeOut.prototype.waitElementVisibility = function(element){
    browser.wait(EC.waitVisibilityOf(element),3000);
};

module.exports = TimeOut;