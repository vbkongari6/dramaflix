(function () {
    'use strict';

    angular
        .module('dramaflix', ['ngRoute'])
        .config(configureRoutes)
        .run(runModule);

    configureRoutes.$inject = ['$routeProvider'];
    function configureRoutes ($routeProvider) {
        $routeProvider
            .when('/index', {
                templateUrl: 'index.tmpl.html',
                controller: 'indexController',
                controllerAs: 'indexVm'
            })
            .when('/signup', {
                templateUrl: 'signup.tmpl.html',
                controller: 'signupController',
                controllerAs: 'signupVm'
            })
            .when('/login', {
                templateUrl: 'login.tmpl.html',
                controller: 'loginController',
                controllerAs: 'loginVm'
            })
            .when('/user-detail/:id', {
                templateUrl: 'user-detail.tmpl.html',
                controller: 'UserDetailController',
                controllerAs: 'userVm'
            })
            .when('/add-user', {
                templateUrl: 'add-user.tmpl.html',
                controller: 'AddUserController',
                controllerAs: 'addUserVm'
            })
            .otherwise({
                redirectTo: '/index'
            });
    }

    function runModule () {
        console.log('App Started');
    }

})();