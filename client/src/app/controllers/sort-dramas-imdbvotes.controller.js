/**
 * Created by VijayBhargavKongari on 8/16/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('sortDramasByIMDBVotesController', sortDramasByIMDBVotesController);

    sortDramasByIMDBVotesController.$inject = ['dramaService'];
    function sortDramasByIMDBVotesController (dramaService) {
        var sortDramaVm = this;

        console.log('In Sort Drama By IMDB Votes Controller');

        dramaService.getSortDramasByIMDBVotes()
            .then( function (data) {
                sortDramaVm.dramas = data;
            }, function (errStatus) {
                console.log(errStatus);


            })
    }
})();