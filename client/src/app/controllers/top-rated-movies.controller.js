/**
 * Created by VijayBhargavKongari on 8/15/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('topRatedMoviesController', topRatedMoviesController);

    topRatedMoviesController.$inject = ['dramaService'];
    function topRatedMoviesController (dramaService) {
        var topMoivesVm = this;

        console.log('In Top Rated Movies Controller');

        dramaService.getTopRatedMovies()
            .then( function (data) {
                topMoivesVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus)



            });

    }
})();