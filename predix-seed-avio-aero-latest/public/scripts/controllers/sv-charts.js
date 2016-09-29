/* jshint unused: false */
// jshint undef:false
define(['angular', 'sample-module','treemap', 'highchartsmore', 'highchart3d'], function (angular, sampleModule) {
    'use strict';
    return sampleModule.controller('SVChartsCtrl', ['$scope',
                        '$rootScope',
                        '$log',
                        '$http',
                        '$location',function ($scope, $rootScope, $log, $http, $location) {
        var chart1='';
        var chart2='';
        var chart3='';
$scope.models='';
var app = angular.module('charts', []);

app.directive('highchart', function () {
return {
    restrict: 'E',
    template: '<div></div>',
    replace: true,

    link: function (scope, element, attrs) {

        scope.$watch(function () { return attrs.chart; }, function () {

            if (!attrs.chart) return;

            var charts = JSON.parse(attrs.chart);

            $(element[0]).highcharts(charts);

        });
    }
};
});
$scope.overSpeedWorstRecords = [];

$scope.handleOverSpeedWorstRecords = function (data, status) {
    $scope.overSpeedWorstRecords = data;      
}

$http.get('https://predix-aveoaeroflightservice.run.aws-usw02-pr.ice.predix.io/getFlightParameters').success(function (data, status) {
var time = [];
    for (var i = 0; i < data.length; i++) {
        time.push(data[i].time); 
        console.log(time);  
    }
var e07 = [];
    for (var i = 0; i < data.length; i++) {
        e07.push(data[i].e07);
        console.log(e07);
    }

$scope.renderChart = {
        chart: {
           type: 'spline'
        },
        xAxis: {
            categories: [time]
        },
        series: [{
            data: [e07]
        }],

        legend: {
            enabled: false
        }
    };


});
$http.get('https://predix-shopandoee-demo.run.aws-usw02-pr.ice.predix.io/models').
        success(function(data) {
            $scope.models = data;
        }).
        error(function(data) {
            console.log(data);
        });
 


          chart1=new Highcharts.Chart({
          
            chart: {
            renderTo: 'chart1',
             type: 'spline'
          
        },
        title: {
            text: 'Flight Path'
        },
        subtitle: {
            text: 'Predix - Flight Data Visualization'
        },
           yAxis: {
           title: {
                enabled: true,
                text: 'Latitude'
            }
            },
        xAxis: {
      title: {

                enabled: true,

                text: 'Longitude'

            },
            categories: [  '124.55',
                '124.54',
                '124.54',
                '124.53',
                '124.47',
                '124.46',
                '124.46',
                '124.45',
                '124.44']
        },
           tooltip: {
            shared: true,
        },
        credits: {
           
        },
        series: [
            {
            name: 'Longitude',
           
         color: '#7cb5ec',
         dashStyle: 'dot',
            data: [12, 9.5, 5, 6,3,12,3,0,-3]
        }, {
            name: 'Latitude',
           
           color: '#7cb5ec',
           dashStyle: 'dot',
           data: [12, 1, -1.5, -2,-1,-1.5,-2.5,-3.5,-3]
        }],

    });


		// chart1 end
		//chart2 begin
	    chart2=new Highcharts.Chart({
	        chart: {
	            renderTo: 'chart2',
	            
	        },
    title: {
            text: 'Average Temperature'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
         title: {
                text: 'Time'
            },
            categories: ['1:43:08 AM',
                '1:43:17 AM',
                '1:43:22 AM',
                '1:44:32 AM',
                '1:44:42 AM',
                '1:44:55 AM',
                '1:45:07 AM',
                '1:45:12 AM',
                '1:45:22 AM',
                '1:45:25 AM',
                '1:45:37 AM',
                '1:45:45 AM',
                '1:45:55 AM']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            }
        },
     
   
       exporting: { enabled: false },
        series: [{
            name: 'Tokyo',
            data: [8.1, 8.2, 8.3, 8.4, 8.5,  9.5, 10.5, 11.5,  12.5, 11.5, 10.5, 9.5, 8.5]
        }, {
            name: 'London',
            data: [3.5, 5.5, 7.5, 9.5, 11.5, 10.5, 9.5, 8.5, 7.5, 9.5, 11.5, 13.5,15.5]
        }, {
            name: 'London',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
    });

	    //chart3 end
        chart3=new Highcharts.Chart({
            chart: {
                renderTo: 'chart3',
                
            },
    title: {
            text: ' Average Temperature'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
         title: {
                text: 'Time'
            },
            categories: ['1:43:08 AM',
                '1:43:17 AM',
                '1:43:22 AM',
                '1:44:32 AM',
                '1:44:42 AM',
                '1:44:55 AM',
                '1:45:07 AM',
                '1:45:12 AM',
                '1:45:22 AM',
                '1:45:25 AM',
                '1:45:37 AM',
                '1:45:45 AM',
                '1:45:55 AM']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: false
                },
                enableMouseTracking: true
            }
        },
        series: [{
            name: 'Tokyo',
            data: [8.1, 8.2, 8.3, 8.4, 8.5,  9.5, 10.5, 11.5,  12.5, 11.5, 10.5, 9.5, 8.5]
        }, {
            name: 'London',
            data: [3.5, 5.5, 7.5, 9.5, 11.5, 10.5, 9.5, 8.5, 7.5, 9.5, 11.5, 13.5,15.5]
        }, {
            name: 'London',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
    });
 chart5=new Highcharts.Chart({
            chart: {
                renderTo: 'chart5',
                
            },
    title: {
            text: ' Average Temperature'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
         title: {
                text: 'Time'
            },
            categories: ['1:43:08 AM',
                '1:43:17 AM',
                '1:43:22 AM',
                '1:44:32 AM',
                '1:44:42 AM',
                '1:44:55 AM',
                '1:45:07 AM',
                '1:45:12 AM',
                '1:45:22 AM',
                '1:45:25 AM',
                '1:45:37 AM',
                '1:45:45 AM',
                '1:45:55 AM']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: false
                },
                enableMouseTracking: true
            }
        },
        series: [{
            name: 'Tokyo',
            data: [8.1, 8.2, 8.3, 8.4, 8.5,  9.5, 10.5, 11.5,  12.5, 11.5, 10.5, 9.5, 8.5]
        }, {
            name: 'London',
            data: [3.5, 5.5, 7.5, 9.5, 11.5, 10.5, 9.5, 8.5, 7.5, 9.5, 11.5, 13.5,15.5]
        }, {
            name: 'London',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
    });
    }]);
});
