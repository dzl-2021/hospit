$(function () {
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            type: 'pie'
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        plotOptions: {
            series: {
                cursor: 'pointer',
                point: {
                    events: {
                        click: function(e) {
                            //location.href = this.options.url;
                            //location.href = e.point.url
                            location.href = window.open(e.point.url)
                        }
                    }
                }
            }
        },
        series: [{
            data: [{
                y: 29.9,
                url: 'http://bing.com/search?q=foo'
            }, {
                y: 71.5,
                url: 'http://www.baidu.com'
            }, {
                y: 106.4,
                url: 'http://www.ecnu.edu.cn'
                //url: 'http://bing.com/search?q=foo+bar'
            }]        
        }]
    });
})