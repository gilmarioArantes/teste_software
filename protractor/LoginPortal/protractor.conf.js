//protractor.conf.js

module.exports.config = {
	seleniumAddress: 'http://localhost:4444/wd/hub',
	capabilities: {
		'browserName':'chrome'
	},
	specs: ['specs/loginPortal.spec.js'],
	baseUrl: 'https://testeap.intra.goias.gov.br/pas-acesso-app' //url da página de login do portal de teste
};
