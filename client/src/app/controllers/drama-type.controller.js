/**
 * Created by VijayBhargavKongari on 8/16/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('dramaTypeController', dramaTypeController);

    dramaTypeController.$inject = ['dramaService', '$routeParams'];
    function dramaTypeController (dramaService, $routeParams) {
        var dramaTypeVm = this;

        console.log('In Drama Type Controller');

        dramaService.getDramasByType($routeParams.type)
            .then( function (data) {
                dramaTypeVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus);


            })
    }
})();