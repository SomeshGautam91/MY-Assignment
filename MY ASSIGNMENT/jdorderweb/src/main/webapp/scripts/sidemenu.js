		function displayCustomerMenu(){
			$("#customerMenu").css("display", "block");
			$("#orderMenu").css("display", "none");
			$("#inventoryMenu").css("display", "none");
			return true;
		}

		function displayOrderMenu(){
			$("#customerMenu").css("display", "none");
			$("#orderMenu").css("display", "block");
			$("#inventoryMenu").css("display", "none");
			return true;
		}
		
		function displayInventoryMenu(){
			$("#customerMenu").css("display", "none");
			$("#orderMenu").css("display", "none");
			$("#inventoryMenu").css("display", "block");
			return true;
		}

		function hideMenu(){
			$("#customerMenu").css("display", "none");
			$("#orderMenu").css("display", "none");
			$("#inventoryMenu").css("display", "none");
			return true;
		}
