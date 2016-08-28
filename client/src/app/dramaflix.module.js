(function () {
    'use strict';

    angular
        .module('dramaflix', ['ngRoute','ngMessages', 'angular-jwt'])
        .config(configureRoutes)
        .run(runModule);

    configureRoutes.$inject = ['$routeProvider', 'jwtInterceptorProvider', '$httpProvider'];
    function configureRoutes ($routeProvider, jwtInterceptorProvider, $httpProvider) {
        $routeProvider
            .when('/index', {
                templateUrl: 'app/views/index.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'indexController',
                controllerAs: 'indexVm'
            })
            .when('/signup', { //used
                templateUrl: 'app/views/signup.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'signupController',
                controllerAs: 'signupVm'
            })
            .when('/login', { //used
                templateUrl: 'app/views/login.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'loginController',
                controllerAs: 'loginVm'
            })
            .when('/profile/:id', { //used
                templateUrl: 'app/views/user-profile.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'userProfileController',
                controllerAs: 'userVm',
                data: { requiresLogin: true }
            })
            .when('/editprofile/:id', {
                templateUrl: 'app/views/edit-user-profile.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'editUserProfileController',
                controllerAs: 'editUserVm',
                data: { requiresLogin: true }
            })
            .when('/dramas', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'allDramasController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/adddrama', {
                templateUrl: 'app/views/add-drama.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'addDramaController',
                controllerAs: 'addDramaVm',
                data: { requiresLogin: true }
            })
            .when('/drama/:id', { //used
                templateUrl: 'app/views/drama-details.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaDetailsController',
                controllerAs: 'dramaVm',
                data: { requiresLogin: true }
            })
            .when('/editdrama/:id', {
                templateUrl: 'app/views/edit-drama.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'editDramaController',
                controllerAs: 'editDramaVm',
                data: { requiresLogin: true }
            })
            .when('/movies/toprated', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'topRatedMoviesController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/tvseries/toprated', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'topRatedTVSeriesController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/dramas/type/:type', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaTypeController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/dramas/year/:year', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaYearController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/dramas/genre/:genre', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'dramaGenreController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/dramas/sortByYear', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'sortDramaByYearController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/dramas/sortByIMDBRating', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'sortDramaByIMDBRatingController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/dramas/sortByIMDBVotes', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'sortDramasByIMDBVotesController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .when('/dramas/toprated', { //used
                templateUrl: 'app/views/all-dramas.tmpl.html',
                caseInsensitiveMatch: true,
                controller: 'topRatedDramasController',
                controllerAs: 'allDramasVm',
                data: { requiresLogin: true }
            })
            .otherwise({
                redirectTo: '/index'
            });

        jwtInterceptorProvider.whiteListedDomains = '*';
        jwtInterceptorProvider.tokenGetter = function () {
            return localStorage.getItem('jwt');
        };

        $httpProvider.interceptors.push('jwtInterceptor');
    }

    runModule.inject = ['$rootScope', '$location'];
    function runModule ($rootScope, $location) {
        console.log('App Started');

        $rootScope.$on('$routeChangeStart', function (event, to) {
            var token = localStorage.getItem('jwt');

            if (to.data && to.data.requiresLogin) {
                if (!token) {
                    event.preventDefault();
                    $location.path('/login');
                }
            }
            else if (!to.data) {
                if (token && _.includes(['indexController', 'signupController', 'loginController'], to.controller)) {
                    $location.path('/dramas');
                }
                token = null;
            }

            $rootScope.$broadcast('isUserExist', token);
        });
    }

})();