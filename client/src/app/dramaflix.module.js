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
                controller: 'indexController',
                controllerAs: 'indexVm'
            })
            .when('/signup', {
                templateUrl: 'app/views/signup.tmpl.html',
                controller: 'signupController',
                controllerAs: 'signupVm'
            })
            .when('/login', {
                templateUrl: 'app/views/login.tmpl.html',
                controller: 'loginController',
                controllerAs: 'loginVm'
            })
            .when('/profile/:id', {
                templateUrl: 'app/views/user-profile.tmpl.html',
                controller: 'userProfileController',
                controllerAs: 'userVm'
            })
            .when('/editprofile/:id', {
                templateUrl: 'app/views/edit-user-profile.tmpl.html',
                controller: 'editUserProfileController',
                controllerAs: 'editUserVm'
            })
            .when('/alldramas', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                controller: 'allDramasController',
                controllerAs: 'allDramasVm'
            })
            .when('/adddrama', {
                templateUrl: 'app/views/add-drama.tmpl.html',
                controller: 'addDramaController',
                controllerAs: 'addDramaVm'
            })
            .when('/drama/:id', {
                templateUrl: 'app/views/drama-details.tmpl.html',
                controller: 'dramaDetailsController',
                controllerAs: 'dramaVm'
            })
            .when('/editdrama/:id', {
                    templateUrl: 'app/views/edit-drama.tmpl.html',
                    controller: 'editDramaController',
                    controllerAs: 'editDramaVm'
            })
            .when('/topratedmovies', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                controller: 'topRatedMoviesController',
                controllerAs: 'allDramasVm'
            })
            .when('/topratedtvseries', {
                templateUrl: 'app/views/all-dramas.tmpl.html',
                controller: 'topRatedTVSeriesController',
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