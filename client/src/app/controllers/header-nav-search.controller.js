/**
 * Created by VijayBhargavKongari on 8/18/2016.
 */
(function () {
    'use strict';

    angular
        .module('dramaflix')
        .controller('navSearchController', navSearchController);

    navSearchController.$inject = ['$location', '$rootScope', '$scope'];
    function navSearchController ($location, $rootScope, $scope) {
        var navSearchVm = this;

        navSearchVm.goto = goto;
        navSearchVm.setSearchText = setSearchText;
        navSearchVm.logout = logout;

        console.log('In nav-search Controller');


        $scope.$on('isUserExist', function (event, data) {
            navSearchVm.isUser = data;
        });

        navSearchVm.genreList = ['Biography', 'Drama', 'History', 'Mystery', 'Sci-Fi', 'Comedy', 'Thriller', 'Action', 'Adventure', 'Documentary', 'Western', 'Romance', 'Fantasy', 'Animation', 'Family', 'News', 'Talk-Show', 'Horror'];

        navSearchVm.currentYear = new Date().getFullYear();
        navSearchVm.yearList = _.range(navSearchVm.currentYear, navSearchVm.currentYear-100, -1);

        function goto (page) {
            $location.path(page);
            navSearchVm.chosen = '';
            navSearchVm.sortBy = '';
            navSearchVm.selectedGenre = '';
            navSearchVm.selectedYear = '';
        }

        function setSearchText () {
            $rootScope.$broadcast('searching', navSearchVm.searchText);
        }
        
        function logout () {
            localStorage.removeItem('jwt');
            $location.path('');
        }

    }
})();