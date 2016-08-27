/**
 * Created by VijayBhargavKongari on 8/12/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('signupController', signupController);

    signupController.$inject = ['userService', 'dramaService', '$location'];
    function signupController (userService, dramaService, $location) {
        console.log('In Sign-up Controller');

        var signupVm = this;
        signupVm.addUser = addUser;

        function addUser() {
            userService.addUser(signupVm.newUser)
                .then( function (data) {
                    console.log('Sign-up successful');
                    $location.path('/profile/' + data.id);
                }, function (errStatus) {
                    console.log(errStatus)
                });



        }
    }

})();