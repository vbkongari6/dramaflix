/**
 * Created by VijayBhargavKongari on 8/14/2016.
 */
(function () {
    'use strict';
    
    angular
        .module('dramaflix')
        .controller('userProfileController', userProfileController);
    
    userProfileController.$inject = ['userService', '$routeParams'];
    function userProfileController (userService, $routeParams) {
        var userVm = this;

        console.log('In User Profile Controller');

        userService.getUser($routeParams.id)
            .then( function (data) {
                userVm.user = data;
            }, function (errStatus) {
                console.log(errStatus);



            });


    }
})();