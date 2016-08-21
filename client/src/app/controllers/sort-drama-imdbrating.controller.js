/**
 * Created by VijayBhargavKongari on 8/16/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('sortDramaByIMDBRatingController', sortDramaByIMDBRatingController);

    sortDramaByIMDBRatingController.$inject = ['dramaService', '$scope'];
    function sortDramaByIMDBRatingController (dramaService, $scope) {
        var sortDramaVm = this;

        console.log('In Sort Drama By IMDB Rating Controller');

        dramaService.getSortDramasByIMDBRating()
            .then( function (data) {
                sortDramaVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus);
            });

        $scope.$on('searching', function (event, data) {
            sortDramaVm.searchText = data;
        });

    }
})();