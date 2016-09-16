/**
 * Router Config
 * This is the router definition that defines all application routes.
 */
/*global define */
define(['angular', 'angular-ui-router'], function(angular) {
    'use strict';
    return angular.module('app.routes', ['ui.router']).config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function($stateProvider, $urlRouterProvider, $locationProvider) {

        //Turn on or off HTML5 mode which uses the # hash
        $locationProvider.html5Mode(true).hashPrefix('!');

        /**
         * Router paths
         * This is where the name of the route is matched to the controller and view template.
         */
        $stateProvider
           .state('Login', {
                url: '/Login',
                templateUrl: 'views/login.html',
                controller: 'LoginCtrl'
            })
           
            .state('sv-charts', {
                url: '/sv-charts',
                templateUrl: 'views/sv-charts.html',
                controller: 'SVChartsCtrl'
            })
            

        $urlRouterProvider
            .otherwise(function(){
                document.querySelector('px-app-nav').markSelected('/sv-charts');
                return '/sv-charts';
            });
    }]);
});
