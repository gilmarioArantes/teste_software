//homepage.spec.js

describe('homepage', function(){
	it('perform a search into de api page',function(){
		browser.get('#/api');//arrange

		element(by.model('searchTerm')).sendKeys('restart');//act1
		element(by.css('.depth-1')).click();//act2

		expect(element(by.css('.api-title')).getText()).toContain('browser.restart');//assert

	});
});
