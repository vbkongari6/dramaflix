/**
 * Created by VijayBhargavKongari on 8/12/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('indexController', indexController);

    indexController.$inject = [];
    function indexController () {
        var indexVm = this;

        indexVm.toSignUp = function () {
            console.log('in signup');
            indexVm.go = $location.path( '/signup.tmpl.html' );
        }

        indexVm.toLogin = function () {
            $location.path( '/login.tmpl.html' );
        }
    }

})();