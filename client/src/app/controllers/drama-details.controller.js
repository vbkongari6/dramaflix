/**
 * Created by VijayBhargavKongari on 8/14/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('dramaDetailsController', dramaDetailsController);

    dramaDetailsController.$inject = ['dramaService', '$routeParams'];
    function dramaDetailsController (dramaService, $routeParams) {
        var dramaVm = this;

        console.log('In Drama Details Controller');

        dramaService.getDrama($routeParams.id)
            .then( function (data) {
                dramaVm.drama = data;
                return dramaService.getAvgDramaRating($routeParams.id)
            })
            .then( function (data) {
                dramaVm.drama.avgRating = data;
            })
            .catch(function (errStatus) {
                console.log(errStatus);



            });


    }
})();