/**
 * Created by VijayBhargavKongari on 8/16/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('topRatedDramasController', topRatedDramasController);

    topRatedDramasController.$inject = ['dramaService', '$scope'];
    function topRatedDramasController (dramaService, $scope) {
        var topDramasVm = this;

        console.log('In Top Rated Dramas Controller');

        dramaService.getTopRatedDramas()
            .then( function (data) {
                topDramasVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus)
            });

        $scope.$on('searching', function (event, data) {
            topDramasVm.searchText = data;
        });

    }
})();