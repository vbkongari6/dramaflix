(function () {
    'use strict';

    angular
        .module('dramaflix', ['ngRoute','ngMessages'])
        .config(configureRoutes)
        .run(runModule);

    configureRoutes.$inject = ['$routeProvider'];
    function configureRoutes ($routeProvider) {
        $routeProvider
            .when('/index', {
                templateUrl: 'app/views/index.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'indexController',
                controllerAs: 'indexVm'
            })
            .when('/signup', {
                templateUrl: 'app/views/signup.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'signupController',
                controllerAs: 'signupVm'
            })
            .when('/login', {
                templateUrl: 'app/views/login.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'loginController',
                controllerAs: 'loginVm'
            })
            .when('/profile/:id', {
                templateUrl: 'app/views/user-profile.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'userProfileController',
                controllerAs: 'userVm'
            })
            .when('/editprofile/:id', {
                templateUrl: 'app/views/edit-user-profile.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'editUserProfileController',
                controllerAs: 'editUserVm'
            })
            .when('/alldramas', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'allDramasController',
                controllerAs: 'allDramasVm'
            })
            .when('/adddrama', {
                templateUrl: 'app/views/add-drama.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'addDramaController',
                controllerAs: 'addDramaVm'
            })
            .when('/drama/:id', {
                templateUrl: 'app/views/drama-details.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaDetailsController',
                controllerAs: 'dramaVm'
            })
            .when('/editdrama/:id', {
                templateUrl: 'app/views/edit-drama.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'editDramaController',
                controllerAs: 'editDramaVm'
            })
            .when('/topratedmovies', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'topRatedMoviesController',
                controllerAs: 'allDramasVm'
            })
            .when('/topratedtvseries', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'topRatedTVSeriesController',
                controllerAs: 'allDramasVm'
            })
            .when('/dramas/type/:type', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaTypeController',
                controllerAs: 'allDramasVm'
            })
            .when('/dramas/year/:year', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaYearController',
                controllerAs: 'allDramasVm'
            })
            .when('/dramas/genre/:genre', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaGenreController',
                controllerAs: 'allDramasVm'
            })
            .when('/dramas/sortByYear', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'sortDramaByYearController',
                controllerAs: 'allDramasVm'
            })
            .when('/dramas/sortByIMDBRating', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'sortDramaByIMDBRatingController',
                controllerAs: 'allDramasVm'
            })
            .when('/dramas/sortByIMDBVotes', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'sortDramasByIMDBVotesController',
                controllerAs: 'allDramasVm'
            })
            .otherwise({
                redirectTo: '/index'
            });
    }

    function runModule () {
        console.log('App Started');
    }

})();