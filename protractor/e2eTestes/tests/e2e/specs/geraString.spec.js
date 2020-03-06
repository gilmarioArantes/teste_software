//geraString.spec.js

var GeraString = require('../helpers/geraString.js');
var TodoMvc = require('../page-objects/todoMvc.po.js');

describe('Todo MVC Angular', function () {
    var geraString = new GeraString();
    var todoMvc = new TodoMvc();

    it('add random value in the todo list', function () {

        var randomString = geraString.generateRandomString();

        todoMvc.visit();

        todoMvc.addItemOnTodoList(randomString);

        expect(todoMvc.listOfItens.getText()).toContain(randomString);
    });
});