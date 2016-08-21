/**
 * Created by VijayBhargavKongari on 8/16/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('dramaGenreController', dramaGenreController);

    dramaGenreController.$inject = ['dramaService', '$routeParams', '$scope'];
    function dramaGenreController (dramaService, $routeParams, $scope) {
        var dramaGenreVm = this;

        console.log('In Drama Genre Controller');

        dramaService.getDramasByGenre($routeParams.genre)
            .then( function (data) {
                dramaGenreVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus);
            });

        $scope.$on('searching', function (event, data) {
            dramaGenreVm.searchText = data;
        });
    }
})();