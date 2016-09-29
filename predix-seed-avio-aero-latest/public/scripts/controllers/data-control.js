define(['angular', 'sample-module'], function (angular, sampleModule) {
    'use strict';
    return sampleModule.controller('DataControlCtrl', ['$scope', function ($scope) {

        $scope.context = {
            name: 'This is context',
            // using api from weather underground: http://www.wunderground.com/
            alarmsurl: 'http://predix-alarmservice-sapan-km.grc-apps.svc.ice.ge.com/alaramservice',
            hospitalurl: 'http://predix-alarmservice-sapan-km.grc-apps.svc.ice.ge.com/hospital'
        };

    }]);
});
