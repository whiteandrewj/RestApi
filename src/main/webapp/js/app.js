

/*
 * Angular module and controller for the customer search / edit page and features.
 * 
 */
var app = angular.module('grantDanielCustomerApp', []);

app.controller('customersCtrl', function($scope, $http) {
	
	$scope.resetSearch = function() {
		$scope.isGetCustomersDisabled = false;
		$scope.isClearCustomersDisabled = true;			
		$scope.hideCustomerSearchPage(false);
		$scope.hideCustomerSearchResults = true;
		$scope.hideCustomerEditDelete = true;
		$scope.nameFilter = "";
	}
			
	$scope.getCustomers = function() {
		$http.get("/RestApi/rest/customer").then(function(response) {
			$scope.myCustomers = response.data;
		});		
		$scope.hideCustomerSearchResults = false;
		$scope.isGetCustomersDisabled = true;
		$scope.isClearCustomersDisabled = false;		
	};	
	
	$scope.updateCustomer = function() {
		
		alert("time to update customer "+$scope.customer.customerId);
		
		$scope.jsonObject = angular.toJson($scope.customer, false);
		alert("customer json: "+$scope.jsonObject);
		
		$http.put("/RestApi/rest/customer", $scope.jsonObject)
		.then(
				function success(response) {
					alert("rows updated: " + response.data + ", status: " + response.status);
				},
				function error(response) {
					alert("error, return status: " + response.status)
				}
		);			
		
		$scope.updateStatus = "update successful";
		$scope.isUpdateDisabled = true;	
	};	
	
	$scope.editCustomer = function(customer) {
		alert("edit customer: " + customer.customerId + " " + customer.companyName);
		$scope.customer = customer;
		$scope.updateStatus = "";		
		$scope.hideCustomerSearchPage(true);
		$scope.hideCustomerEditDelete = false;
		$scope.isUpdateDisabled = true;			
	};	
	
	$scope.turnUpdateOn = function(id) {
		$scope.isUpdateDisabled = false;
		$scope.updateStatus = "";
	};
	
	$scope.hideCustomerSearchPage = function(hide) {
		$scope.hideCustomerSearch = hide;		
	};
	
	//do last to initialize search when app first loads
	$scope.resetSearch();
	
});

/*
 * Angular module and controller for the create customer page and features.
 * 
 */
var createApp = angular.module('grantDanielCustomerCreateApp', []);

createApp.controller('customerCreateCtrl', function($scope, $http) {
	
	$scope.countries = ['USA','Germany','Ice Land','France'];
	$scope.newCustomerCountry = $scope.countries[2];
		
	$scope.createCustomer = function() {	
		
		if ($scope.newCustomerId == undefined ) {
			$scope.idMessage = "id is required";
		} else if ($scope.newCustomerId.length != 5) {
			$scope.idMessage = "id must be 5 characters";
		} else {
			$scope.idMessage = "";
		}
		
		if ($scope.newCustomerCompanyName == undefined) {
			$scope.nameMessage = "name is required";
		} else if ($scope.newCustomerCompanyName.length < 4) {
			$scope.nameMessage = "name must be at least 4 characters";
		} else {
			$scope.nameMessage = "";
		}
		
		if ($scope.newCustomerCity == undefined) {
			$scope.cityMessage = "city is required";
		} else if ($scope.newCustomerCity.length < 4) {
			$scope.cityMessage = "city must be at least 4 characters";
		} else {
			$scope.cityMessage = "";
		}
			
		
		if ($scope.idMessage == "" && $scope.nameMessage == "" && $scope.cityMessage == "")
		{
			alert("time to create customer id: "+$scope.newCustomerId +
					", name: " + $scope.newCustomerCompanyName +
					", city: " + $scope.newCustomerCity + 
					", country: " + $scope.newCustomerCountry +
					", big? " + $scope.newBigCustomer +
					", green? " + $scope.newGreenCustomer +
					", english? " + $scope.newEnglishCustomer);
			
			var newCustomer = {customerId : $scope.newCustomerId,
								companyName : $scope.newCustomerCompanyName,
								city : $scope.newCustomerCity,
								country : $scope.newCustomerCountry };
			
			$http.post("/RestApi/rest/customer", newCustomer)
			.then(
					function success(response) {
						
						if (response.data == 1) {						
							alert("rows inserted: " + response.data + ", status: " + response.status);
							$scope.createStatus = "success. press 'Clear' to enter new customer";							
						} else {
							alert("error, return status: " + response.status);
							$scope.createStatus = "error. press 'Clear' to try again";		
						}
					},
					function error(response) {
						alert("error, return status: " + response.status);
						$scope.createStatus = "error. press 'Clear' to try again";						
					}				
			);
			
			$scope.isCreateCustomerDisabled = true;
			$scope.lock = true;
			
		} else {
			$scope.createStatus = "please fix indicated errors";
		}				
			
	};
	
	$scope.clearCreate = function() {	
		
		//clear success or error message
		$scope.createStatus = "";
		
		//clear the input elements
		$scope.newCustomerId = "";
		$scope.newCustomerCompanyName = "";
		$scope.newCustomerCity = "";
		$scope.newCustomerCountry = $scope.countries[2];
		$scope.newBigCustomer = false;
		$scope.newGreenCustomer = false;
		$scope.newEnglishCustomer = false;
		
		//clear the messages
		$scope.idMessage = "";		
		$scope.nameMessage = "";
		$scope.cityMessage = "";		
		
		//unlock input
		$scope.lock = false;
		$scope.isCreateCustomerDisabled = false;
	}
	
		
});