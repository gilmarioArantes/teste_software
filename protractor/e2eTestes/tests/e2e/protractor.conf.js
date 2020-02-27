//protractor.conf.js

module.exports.config = {
	seleniumAddress: 'http://localhost:4444/wd/hub',
	capabilities: {
		'browserName':'chrome'
	},
	//specs: ['specs/*.spec.js'], para executar todos os specs de uma vez
	specs: ['specs/todoMvcWithPageObjectsAndHelper.spec.js'],
	baseUrl: 'http://www.protractortest.org/' //url do projeto de testes.
};
