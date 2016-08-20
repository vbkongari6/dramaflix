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

        dramaVm.postComment = postComment;
        dramaVm.getDrama = getDrama;

        console.log('In Drama Details Controller');

        getDrama();

        function getDrama () {
            dramaService.getDrama($routeParams.id)
                .then( function (data) {
                    if (data.type === 'movie') { data.type = 'Movie'}
                    else if (data.type === 'series') { data.type = 'TV Series'}
                    dramaVm.drama = data;
                    return dramaService.getAvgDramaRating($routeParams.id)
                })
                .then( function (data) {
                    dramaVm.drama.avgRating = data;
                    return dramaService.getDramaComments($routeParams.id)
                })
                .then( function (data) {
                    dramaVm.drama.comments = data;
                })
                .catch(function (errStatus) {
                    console.log(errStatus);
                });
        }

        function postComment () {
            dramaService.postComment(dramaVm.comment)
                .then( function (data) {
                    getDrama();
                    dramaVm.comment = '';
                }, function (errStatus) {
                    console.log(errStatus);
                });

        }


    }
})();