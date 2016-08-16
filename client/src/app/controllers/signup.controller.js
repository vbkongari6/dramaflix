/**
 * Created by VijayBhargavKongari on 8/12/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('signupController', signupController);

    signupController.$inject = ['userService', '$location'];
    function signupController (userService, $location) {
        var signupVm = this;

        signupVm.addUser = addUser;

        console.log('In Sign-up Controller');

        function addUser() {
            userService.addUser(signupVm.newUser)
                .then( function (data) {
                    console.log('Sing-up successful');
                    $location.path('/profile/' + data.id);
                }, function (errStatus) {
                    console.log(errStatus)
                });



        }
    }

})();