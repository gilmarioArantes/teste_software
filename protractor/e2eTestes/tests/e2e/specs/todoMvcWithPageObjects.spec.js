//todoMvcWithPageObject.spec.js

var TodoMvc = require('../page-objects/todoMvc.po.js');

describe('Todo MVC Angular', function () {
    var todoMvc = new TodoMvc();

    beforeEach(function () {
        todoMvc.visit();
    });

    it("add an item in the todo list", function () {
        todoMvc.addItemOnTodoList('create test with page objects');
        expect(todoMvc.listOfItens.count()).toEqual(1);
    });

    it('create new item in the todo list', function () {
        todoMvc.addItemOnTodoList('create new test with page objects');

        expect(todoMvc.listOfItens.count()).toEqual(2);

    });
});