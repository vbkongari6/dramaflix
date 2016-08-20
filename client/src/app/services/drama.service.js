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
        drm.postComment = postComment;

        function getDramas () {
            console.log('In Drama Service: GET Dramas');
            return $http.get('http://localhost:8080/dramaflix/api/dramas')
                .then(successFn2, failureFn);
        }

        function getDrama (id) {
            console.log('In Drama Service: GET Drama');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/' + id)
                .then(successFn3, failureFn);
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
                .then(successFn2, failureFn);
        }
        
        function getTopRatedMovies () {
            console.log('In Drama Service: GET Top Rated Movies');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/bestmovies')
                .then(successFn2, failureFn);
        }

        function  getTopRatedTVSeries () {
            console.log('In Drama Service: GET Top Rated TV Series');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/besttvseries')
                .then(successFn2, failureFn);
        }

        function getDramasByType (type) {
            console.log('In Drama Service: GET Dramas By Type');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/type=' + type)
                .then(successFn2, failureFn);
        }

        function getDramasByYear (year) {
            console.log('In Drama Service: GET Dramas By Year');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/year=' + year)
                .then(successFn2, failureFn);
        }

        function getDramasByGenre (genre) {
            console.log('In Drama Service: GET Dramas By Year');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/genre=' + genre)
                .then(successFn2, failureFn);
        }

        function getSortDramasByYear () {
            console.log('In Drama Service: GET Sorted Dramas By Year');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/sort=year/DESC')
                .then(successFn2, failureFn);
        }

        function getSortDramasByIMDBRating () {
            return getTopRatedDramas();
        }

        function getSortDramasByIMDBVotes () {
            console.log('In Drama Service: GET Sorted Dramas By IMDB Votes');
            return $http.get('http://localhost:8080/dramaflix/api/dramas/sort=IMDBVotes/DESC')
                .then(successFn2, failureFn);
        }

        function postComment(comment) {
            console.log('In Drama Service: POST Comment');
            var commentDetails = {
                comment: comment,
                user: { id: localStorage.getItem('id') },
                drama: { id: drm.dramaId }
            }
            return $http.post('http://localhost:8080/dramaflix/api/dramareviews/comment', commentDetails)
                .then(successFn, failureFn);
        }
        



        function successFn (response) {
            return response.data;
        }

        function successFn2 (response) {
            response = response.data;
            response.forEach( function (datum) {
                if (datum.title.length > 18) {
                    datum.title = _.truncate(datum.title, {'length': 18});
                }
            });
            return response;
        }

        function successFn3 (response) {
            response = response.data;
            drm.dramaId = response.id;
            return response;
        }
        
        function failureFn (response) {
            return $q.reject(response.status);
        }
    }

})();