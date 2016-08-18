/**
 * Created by VijayBhargavKongari on 8/12/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('loginController', loginController);

    loginController.$inject = ['userService', '$location'];
    function loginController (userService, $location) {
        var loginVm = this;

        loginVm.validateUser = validateUser;

        console.log('In Login Controller');

        function validateUser() {
            console.log('In Login Controller');
            userService.validateUser(loginVm.user)
                .then( function (response) {
                    console.log('Login successful');
                    $location.path('');
                })
                .catch( function (errStatus) {
                    console.log(errStatus);
                })
        }


    }

})();