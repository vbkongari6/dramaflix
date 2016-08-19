/**
 * Created by VijayBhargavKongari on 8/18/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('navSearchController', navSearchController);

    navSearchController.$inject = ['$location'];
    function navSearchController ($location) {
        var navSearchVm = this;
        navSearchVm.genreList = ['Biography', 'Drama', 'History', 'Mystery', 'Sci-Fi', 'Comedy', 'Thriller', 'Action', 'Adventure', 'Documentary', 'Western', 'Romance', 'Fantasy', 'Animation', 'Family', 'News', 'Talk-Show', 'Horror'];

        navSearchVm.currentYear = new Date().getFullYear();
        navSearchVm.yearList = _.range(navSearchVm.currentYear, navSearchVm.currentYear-100, -1);

        console.log('In nav-search Controller');

        navSearchVm.goto = goto;
        function goto (page) {
            console.log(page);
            $location.path(page);
        }
    }
})();