var chart = AmCharts.makeChart("chartdiv", {
    "theme": "light",
    "type": "serial",
	"startDuration": 2,
    "dataProvider": [{
        "country": "에픽하이",
        "visits": 10.6,
        "color": "#FF0F00"
    }, {
        "country": "임창정",
        "visits": 7.4,
        "color": "#FCD202"
    }, {
        "country": "아이유",
        "visits": 8.1,
        "color": "#F8FF01"
    }, {
        "country": "멜로망스",
        "visits": 8.3,
        "color": "#B0DE09"
    }, {
        "country": "EXO",
        "visits": 8.5,
        "color": "#0D8ECF"
    }, {
        "country": "방탄소년단",
        "visits": 6.5,
        "color": "#DDDDDD"
    },{
        "country": "사랑의 온도",
        "visits": 8.5,
        "color": "#0D8ECF"
    }, 
    {
        "country": "볼빨간사춘기",
        "visits": 8.5,
        "color": "#0D8ECF"
    }, 
    {
        "country": "비투비",
        "visits": 8.5,
        "color": "#0D8ECF"
    }, 
    {
        "country": "박원",
        "visits": 8.5,
        "color": "#0D8ECF"
    }],
    "valueAxes": [{
        "position": "left",
        "axisAlpha":0,
        "gridAlpha":0         
    }],
    "graphs": [{
        "balloonText": "[[category]]: <b>[[value]]</b>",
        "colorField": "color",
        "fillAlphas": 0.85,
        "lineAlpha": 0.1,
        "type": "column",
        "topRadius":1,
        "valueField": "visits"
    }],
    "depth3D": 40,
	"angle": 30,
    "chartCursor": {
        "categoryBalloonEnabled": false,
        "cursorAlpha": 0,
        "zoomable": false
    },    
    "categoryField": "country",
    "categoryAxis": {
        "gridPosition": "start",
        "axisAlpha":0,
        "gridAlpha":0
        
    },
    "export": {
    	"enabled": true
     }

},0);

jQuery('.chart-input').off().on('input change',function() {
	var property	= jQuery(this).data('property');
	var target		= chart;
	chart.startDuration = 0;

	if ( property == 'topRadius') {
		target = chart.graphs[0];
	}

	target[property] = this.value;
	chart.validateNow();
});