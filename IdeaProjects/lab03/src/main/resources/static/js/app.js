/**
 * Created by gersonsafj on 08/02/17.
 */
var app = angular.module("todoApp", []);


app.controller("appController", function($scope, $http) {
    $scope.selection=[];
    
    function findAllTasks() {
        $http.get('task/');
    }

});