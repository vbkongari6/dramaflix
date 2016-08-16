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

        function addDrama (drama) {
            console.log('In Drama Service: POST Drama');
            return $http.post('http://localhost:8080/dramaflix/api/dramas', drama)
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
        
        function successFn (response) {
            return response.data;
        }
        
        function failureFn (response) {
            return $q.reject(response.status);
        }
    }

})();