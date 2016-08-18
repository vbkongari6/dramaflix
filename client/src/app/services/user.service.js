/**
 * Created by VijayBhargavKongari on 8/15/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .service('userService', userService);

    userService.$inject = ['$http', '$q'];
    function userService ($http, $q) {
        var usr = this;

        usr.validateUser = validateUser;
        usr.getUsers = getUsers;
        usr.getUser = getUser;
        usr.addUser = addUser;

        function validateUser(user) {
            console.log('In User Service: Validate User');
            return $http.post('http://localhost:8080/dramaflix/api/users/authenticate', user)
                .then(successFn, failureFn);
        }
        
        function getUsers () {
            console.log('In User Service: GET Users');
            return $http.get('http://localhost:8080/dramaflix/api/users')
                .then(successFn, failureFn);
        }

        function getUser (id) {
            console.log('In User Service: GET User');
            return $http.get('http://localhost:8080/dramaflix/api/users/' + id)
                .then(successFn, failureFn);
        }

        function addUser (user) {
            console.log('In User Service: POST User');
            return $http.post('http://localhost:8080/dramaflix/api/users', user)
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