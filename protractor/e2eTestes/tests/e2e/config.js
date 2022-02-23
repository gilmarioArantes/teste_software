// config.js

var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');

var SpecReporter = require('jasmine-spec-reporter');

var jasmineReporters = require('jasmine-reporters');

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

      
      jasmine.getEnv().addReporter(new jasmineReporters.JUnitXmlReporter({
         consolidateAll: true,
         filePrefix: 'guitest-xmloutput',
         savePath: 'reports'
      }));	
   
      jasmine.getEnv().addReporter(new SpecReporter({
         displayFailuresSummary: true,
         displayFailedSpec: true,
         dispaySuiteNumber: true,
         displaySpecDuration: true
      }));

      jasmine.getEnv().addReporter(new Jasmine2HtmlReporter({
         takeScreenshots: true,
         fixedScreenshotName: true
      }))
  },	
};
