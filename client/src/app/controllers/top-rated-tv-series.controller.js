/**
 * Created by VijayBhargavKongari on 8/15/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('topRatedTVSeriesController', topRatedTVSeriesController);

    topRatedTVSeriesController.$inject = ['dramaService'];
    function topRatedTVSeriesController (dramaService) {
        var topTVSeriesVm = this;

        console.log('In Top Rated TV Series Controller');

        dramaService.getTopRatedTVSeries()
            .then( function (data) {
                topTVSeriesVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus)



            });

    }
})();