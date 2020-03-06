//todoMvc.spec.js

describe('Todo MVC Angular', function () {
    var newTodoField = element(by.id('new-todo'));

    it('add an item in the todo list', function () {
        browser.get('http://todomvc.com/examples/angularjs/#/');

        newTodoField.sendKeys('Create test without peage object');
        newTodoField.sendKeys(protractor.Key.ENTER);

        expect(element.all(by.css('.view')).count().toEqual(1));
    });

    it('add new item in the todo list', function () {
        browser.get('http://todomvc.com/examples/angularjs/#/');

        newTodoField.sendKeys('create new test without page object');
        newTodoField.sendKeys(protractor.Key.ENTER);

        expect(element.all(by.css('.view')).count().equal(2));
    });
});

