//loginPortal.spec.js

var PaginaLogin = require('../page-objects/paginaLogin.po');
var PaginaPortal = require('../page-objects/paginaPortal.po');

describe('Teste de Login no Portal de Teste com Protractor', function () {
    var paginaLogin = new PaginaLogin();
    var paginaPortal = new PaginaPortal();

    it('logando no portal de teste',function () {
        paginaLogin.signIn('gilmararantes','gfa2706')
        expect(paginaPortal.searchField.isDisplayed()).toBe(true);
    });
});