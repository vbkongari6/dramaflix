/**
 * Created by VijayBhargavKongari on 8/14/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('allDramasController', allDramasController);

    allDramasController.$inject = ['dramaService', '$rootScope'];
    function allDramasController (dramaService, $rootScope) {
        console.log('In All Dramas Controller');

        var allDramasVm = this;

        allDramasVm.deleteDrama = deleteDrama;

        getDramas();
        function getDramas () {
            dramaService.getDramas()
                .then( function (data) {
                    allDramasVm.dramas = data;
                }, function (errStatus) {
                    console.log(errStatus);
                });
        }

        $rootScope.$on('searching', function (event, data) {
            allDramasVm.searchText = data;
        });

        function deleteDrama (id, title) {
            confirm('Do you really want to delete title ' + title + ' ?');

            dramaService.deleteDrama(id)
                .then( function () {
                        getDramas();
                    },
                    function (errStatus) {
                        console.log(errStatus);
                    });
        }



    }
})();