/**
 * Created by VijayBhargavKongari on 8/16/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('dramaYearController', dramaYearController);

    dramaYearController.$inject = ['dramaService', '$routeParams', '$scope'];
    function dramaYearController (dramaService, $routeParams, $scope) {
        var dramaYearVm = this;

        console.log('In Drama Year Controller');

        dramaService.getDramasByYear($routeParams.year)
            .then( function (data) {
                dramaYearVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus);
            });

        $scope.$on('searching', function (event, data) {
            dramaYearVm.searchText = data;
        });
    }
})();