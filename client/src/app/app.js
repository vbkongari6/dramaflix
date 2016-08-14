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
            .when('/user-detail/:id', {
                templateUrl: 'app/views/user-detail.tmpl.html',
                controller: 'UserDetailController',
                controllerAs: 'userVm'
            })
            .when('/add-user', {
                templateUrl: 'app/views/add-user.tmpl.html',
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