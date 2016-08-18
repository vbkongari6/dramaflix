/**
 * Created by VijayBhargavKongari on 8/15/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .service('dramaService', dramaService);

    dramaService.$inject = ['$http', '$q'];
    function dramaService ($http, $q) {
        var drm = this;

        drm.getDramas = getDramas;
        drm.getDrama = getDrama;
        drm.addDrama = addDrama;
        drm.getTopRatedMovies = getTopRatedMovies;
        drm.getTopRatedTVSeries = getTopRatedTVSeries;
        drm.getTopRatedDramas = getTopRatedDramas;
        drm.getDramasByType = getDramasByType;
        drm.getDramasByYear = getDramasByYear;
        drm.getDramasByGenre = getDramasByGenre;
        drm.getSortDramasByYear = getSortDramasByYear;
        drm.getSortDramasByIMDBRating = getSortDramasByIMDBRating;
        drm.getSortDramasByIMDBVotes = getSortDramasByIMDBVotes;
        drm.getAvgDramaRating = getAvgDramaRating;
        drm.getDramaComments = getDramaComments;

        function getDramas () {
            console.log('In Drama Service: GET Dramas');
            return $http.get('http://localhost:8080/dramaflix/api/dramas')
                .then(successFn, failureFn);
        }

        function getDrama (id) {
            console.log('In Drama Service: GET Drama');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/' + id)
                .then(successFn, failureFn);
        }

        function getAvgDramaRating (id) {
            console.log('In Drama Service: GET Drama Avg Rating');
            return $http.get('http://localhost:8080/dramaflix/api/dramareviews/avgrating/' + id)
                .then(successFn, failureFn);
        }

        function getDramaComments (id) {
            console.log('In Drama Service: GET Drama Comments');
            return $http.get('http://localhost:8080/dramaflix/api/dramareviews/drama/' + id)
                .then(successFnEdit, failureFn);
        }

        function successFnEdit (response) {
            var reviews = [];
            response = response.data;
            response.forEach( function (rD) { // rD - reviewDetails
                var review = {};
                review.firstName = rD[0];
                review.comment = rD[1];
                review.rating = rD[2];
                review.timestamp = rD[3];
                reviews.push(review);
            });
            return reviews;
        }

        function addDrama (drama) {
            console.log('In Drama Service: POST Drama');
            return $http.post('http://localhost:8080/dramaflix/api/dramas', drama)
                .then(successFn, failureFn);
        }

        function getTopRatedDramas () {
            console.log('In Drama Service: GET Top Rated Dramas');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/best')
                .then(successFn, failureFn);
        }
        
        function getTopRatedMovies () {
            console.log('In Drama Service: GET Top Rated Movies');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/bestmovies')
                .then(successFn, failureFn);
        }

        function  getTopRatedTVSeries () {
            console.log('In Drama Service: GET Top Rated TV Series');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/besttvseries')
                .then(successFn, failureFn);
        }

        function getDramasByType (type) {
            console.log('In Drama Service: GET Dramas By Type');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/type=' + type)
                .then(successFn, failureFn);
        }

        function getDramasByYear (year) {
            console.log('In Drama Service: GET Dramas By Year');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/year=' + year)
                .then(successFn, failureFn);
        }

        function getDramasByGenre (genre) {
            console.log('In Drama Service: GET Dramas By Year');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/genre=' + genre)
                .then(successFn, failureFn);
        }

        function getSortDramasByYear () {
            console.log('In Drama Service: GET Sorted Dramas By Year');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/sort=year/DESC')
                .then(successFn, failureFn);
        }

        function getSortDramasByIMDBRating () {
            return getTopRatedDramas();
        }

        function getSortDramasByIMDBVotes () {
            console.log('In Drama Service: GET Sorted Dramas By IMDB Votes');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/sort=IMDBVotes/DESC')
                .then(successFn, failureFn);
        }
        






        function successFn (response) {
            return response.data;
        }
        
        function failureFn (response) {
            return $q.reject(response.status);
        }
    }

})();