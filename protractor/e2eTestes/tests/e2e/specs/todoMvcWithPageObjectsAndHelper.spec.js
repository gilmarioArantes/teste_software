//todoMvcWithPageObjectsAndHelper.spec.js

var Helper = require('../helpers/helper.js');
var TodoMvc = require('../page-objects/todoMvc.po.js');
var SignInPage = require('../page-objects/chokoSignInPage.po.js')
var MessageWrapper = require('../page-objects/chokoMessagesWrapper.po');

describe('Todo MVC Angular', function () {
    var helper = new Helper();
    var todoMvc = new TodoMvc();
    var signInPage = new SignInPage();
    var messageWrapper = new MessageWrapper();

    it('add random value in the todo list', function () {

        var randomString = helper.generateRandomString();

        todoMvc.visit();

        todoMvc.addItemOnTodoList(randomString);

        expect(todoMvc.listOfItens.getText()).toContain(randomString);
    });

    it('try to sign in with a random email and random password', function () {
        var randomEmail = helper.generateRandomEmail();
        var randomPassword = helper.generateRandomString();

        signInPage.visit();

        signInPage.signIn(randomEmail, randomPassword);

        expect(messageWrapper.errorMessage.isDisplayed()).toBe(true);
    });
});