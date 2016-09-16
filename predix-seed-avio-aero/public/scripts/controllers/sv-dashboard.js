/* jshint unused: false */
// jshint undef:false
define(['angular', 'sample-module' ,'heatmap'], function (angular, sampleModule) {
	'use strict';
	return sampleModule.controller('SVDashboardCtrl', ['$scope', '$http', function ($scope, $http) {


		//var finalObject = {};
		var heatMapCompare;
		$scope.models='';
		$scope.engines='';
		$scope.showEngineDiv = false;
		$scope.information = true;
		$scope.selectedModel = ' Select Model';
		$scope.selectedEngine = ' Select Engine';
		//Get All Models
		$http.get('https://predix-shopandoee-demo.run.aws-usw02-pr.ice.predix.io/models').
		success(function(data) {
			$scope.models = data;
		}).
		error(function(data) {
			console.log(data);
		});
		
		
		//On Model Selection get All Engines
		$scope.selectModelValue=function(selectValue){
			$scope.showEngineDiv=true;
			$http.get('https://predix-shopandoee-demo.run.aws-usw02-pr.ice.predix.io/engine/'+selectValue).
			success(function(data) {
				$scope.engines = data;
			}).
			error(function(data) {
				console.log(data);
			});
		};
			
		
		$scope.selectEngineValue=function(selectValue){
			$scope.esn=selectValue;
			$scope.getShopVisitChart(selectValue);
			$scope.information=false;
		
		};

		// Start of my highchart
		$scope.getShopVisitChart = function(esn) {
			$.getJSON('https://predix-shopandoee-demo.run.aws-usw02-pr.ice.predix.io/shopVisitDetailsByEsn/'+esn, function (data) {
				var shopVisitArr=[];
				
				console.log(data);
				$.each(data,function(item,val){

					var finalObject=[];
					finalObject.push(val.shopVisitDate,val.amount);
					console.log(item +'-'+ finalObject);
					shopVisitArr.push(finalObject);
				});

				console.log(shopVisitArr);
				// create the chart
				var timeSeries = new Highcharts.StockChart({
					chart: {
						renderTo: 'container',
						alignTicks: false
					},

					rangeSelector: {
						selected: 5
					},
					title: {
						text: 'Engine Shop Visits Cost'
					},
					series : [{
						type: 'column',
						name: 'Engine Shop Visits Cost',
						data : shopVisitArr,
						dataGrouping: {
							forced: true,
							units: [['week', [1]]]
						}
					}],

				});
			});
		};

/*		heatMapCompare = new Highcharts.Chart({
				chart: {
					type: 'heatmap',
					renderTo: 'comapareDiv',
					marginTop: 40,
					marginBottom: 80,
					plotBorderWidth: 1
				},
				title: {
					text: 'Sales per employee per weekday'
				},
				xAxis: {
					categories: ['Alexander', 'Marie', 'Maximilian', 'Sophia', 'Lukas', 'Maria', 'Leon', 'Anna', 'Tim', 'Laura']
				},
				yAxis: {
					categories: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
					title: null
				},
				colorAxis: {
					min: 0,
					minColor: '#FFFFFF',
					maxColor: Highcharts.getOptions().colors[0]
				},
				legend: {
					align: 'right',
					layout: 'vertical',
					margin: 0,
					verticalAlign: 'top',
					y: 25,
					symbolHeight: 280
				},
				tooltip: {
					formatter: function () {
									return '<b>' + this.series.xAxis.categories[this.point.x] + '</b> sold <br><b>' +
													this.point.value + '</b> items on <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>';
								}
				},

				series: [{
					name: 'Sales per employee',
					borderWidth: 1,
					data: [[0, 0, 10], [0, 1, 19], [0, 2, 8], [0, 3, 24], [0, 4, 67], [1, 0, 92], [1, 1, 58], [1, 2, 78], [1, 3, 117], [1, 4, 48], [2, 0, 35], [2, 1, 15], [2, 2, 123], [2, 3, 64], [2, 4, 52], [3, 0, 72], [3, 1, 132], [3, 2, 114], [3, 3, 19], [3, 4, 16], [4, 0, 38], [4, 1, 5], [4, 2, 8], [4, 3, 117], [4, 4, 115], [5, 0, 88], [5, 1, 32], [5, 2, 12], [5, 3, 6], [5, 4, 120], [6, 0, 13], [6, 1, 44], [6, 2, 88], [6, 3, 98], [6, 4, 96], [7, 0, 31], [7, 1, 1], [7, 2, 82], [7, 3, 32], [7, 4, 30], [8, 0, 85], [8, 1, 97], [8, 2, 123], [8, 3, 64], [8, 4, 84], [9, 0, 47], [9, 1, 114], [9, 2, 31], [9, 3, 48], [9, 4, 91]],
					dataLabels: {
						enabled: true,
						color: '#000000'
					}
				}]
			});




// 	// sparkline
		$http.get('/sample-data/engineHistoryCompareDummy.json')
					.success(function(response)
			{
				$scope.sparklineTable=response;
			});
				
		$scope.showGraphDiff=function(){
			Highcharts.SparkLine = function (options, callback) {
				var defaultOptions = {
						chart: {
							renderTo: (options.chart && options.chart.renderTo) || this,
							backgroundColor: null,
							borderWidth: 0,
							type: 'area',
							margin: [2, 0, 2, 0],
							width: 120,
							height: 20,
							style: {
								overflow: 'visible'
							},
							skipClone: true
						},
						title: {
								text: ''
							},
							credits: {
								enabled: false
							},
							xAxis: {
								labels: {
									enabled: false
								},
								title: {
									text: null
								},
								startOnTick: false,
								endOnTick: false,
								tickPositions: []
							},
							yAxis: {
								endOnTick: false,
								startOnTick: false,
								labels: {
									enabled: false
								},
								title: {
									text: null
								},
								tickPositions: [0]
							},
							legend: {
								enabled: false
							},
							tooltip: {
								backgroundColor: null,
								borderWidth: 0,
								shadow: false,
								useHTML: true,
								hideDelay: 0,
								shared: true,
								padding: 0,
								positioner: function (w, h, point) {
									return { x: point.plotX - w / 2, y: point.plotY - h };
								}
							},
							plotOptions: {
								series: {
									animation: false,
									lineWidth: 1,
									shadow: false,
									states: {
										hover: {
											lineWidth: 1
										}
									},
									marker: {
										radius: 1,
										states: {
											hover: {
												radius: 2
											}
										}
									},
									fillOpacity: 0.25
								},
								column: {
									negativeColor: '#910000',
									borderColor: '#FFFFFF'
								}
							}
						};
				options = Highcharts.merge(defaultOptions, options);

				return new Highcharts.Chart(options, callback);
			};

			var start = +new Date(),
					$tds = $('td[data-sparkline]'),
					fullLen = $tds.length,
					n = 0;

			// Creating 153 sparkline charts is quite fast in modern browsers, but IE8 and mobile
			// can take some seconds, so we split the input into chunks and apply them in timeouts
			// in order avoid locking up the browser process and allow interaction.
			function doChunk() {
					var time = +new Date(),
									i,
									len = $tds.length,
									$td,
									stringdata,
									arr,
									data,
									chart;

					for (i = 0; i < len; i++) {
						$td = $($tds[i]);
						stringdata = $td.data('sparkline');
						arr = stringdata.split('; ');
						data = $.map(arr[0].split(', '), parseFloat);
						chart = {};
						console.log('stringdata '+data);

						if (arr[1]) {
							chart.type = arr[1];
						}
						$td.Highcharts({
							series: [{
								type: 'sparkLine',
								data: data,
								pointStart: 1
							}],
							tooltip: {
								headerFormat: '<span style="font-size: 10px">' + $td.parent().find('th').html() + ', Q{point.x}:</span><br/>',
								pointFormat: '<b>{point.y}.000</b> USD'
							},
							chart: chart
						});

						n += 1;

						// If the process takes too much time, run a timeout to allow interaction with the browser
						if (new Date() - time > 500) {
							$tds.splice(0, i + 1);
							setTimeout(doChunk, 0);
							break;
						}

						// Print a feedback on the performance
						if (n === fullLen) {
							$('#result').html('Generated ' + fullLen + ' sparklines in ' + (new Date() - start) + ' ms');
						}
					}
				}
			doChunk();
		};

		$scope.showTextDiff = function () {
		
			$http.get('/sample-data/engineHistoryCompareDummy.json')
						.success(function(response) {
							console.log(response);
							$.each(response, function(key, val){
								val.quarterlycostdifference = val.quarterlycostdifference.substr(0,val.quarterlycostdifference.indexOf(',;'));
						});
							$scope.sparklineTable=response;
						});
		};*/

			

	}]);
});