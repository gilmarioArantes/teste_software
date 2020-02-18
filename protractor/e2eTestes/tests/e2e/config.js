// config.js
exports.config = {
   directConnect: true,

   // Capabilities to be passed to the webdriver instance.
   capabilities: {
      'browserName': 'chrome'
   },

   // Framework to use. Jasmine is recommended.
   framework: 'jasmine',

   // Spec patterns are relative to the current working directory when
   // protractor is called.
   specs: ['testSpecification.js'],

   //framework: "jasmine2", //must set it if you use JUnitXmlReporter

   onPrepare: function(){ //configure junit xml report

      var jasmineReporters = require('jasmine-reporters');
      jasmine.getEnv().addReporter(new jasmineReporters.JUnitXmlReporter({
         consolidateAll: true,
         filePrefix: 'guitest-xmloutput',
         savePath: 'reports'
      }));	
  },	
};
