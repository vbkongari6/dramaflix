/**
 * Created by VijayBhargavKongari on 8/16/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('sortDramaByYearController', sortDramaByYearController);

    sortDramaByYearController.$inject = ['dramaService'];
    function sortDramaByYearController (dramaService) {
        var sortDramaVm = this;

        console.log('In Sort Drama By Year Controller');

        dramaService.getSortDramasByYear()
            .then( function (data) {
                sortDramaVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus);


            })
    }
})();