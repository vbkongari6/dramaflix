/**
 * Created by VijayBhargavKongari on 8/14/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('allDramasController', allDramasController);

    allDramasController.$inject = ['dramaService'];
    function allDramasController (dramaService) {
        var allDramasVm = this;

        console.log('In All Dramas Controller');

        dramaService.getDramas()
            .then( function (data) {
                allDramasVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus);



            });

    }
})();