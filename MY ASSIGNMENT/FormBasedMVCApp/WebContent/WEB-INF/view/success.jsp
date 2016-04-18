<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p><h3>Congratulation!!!You Are Successfully Registered</h3></p>
Name:${user.name}<br>
Contact:${user.contact}<br>
Email:${user.email}<br>
DOB:${user.dob}<br>
SkillSet:<c:forEach items="${user.skillSets}" var="element">
			<c:out value="${element}"/>
		</c:forEach><br>
<p><h3>User Address</h3></p>
Street:${user.userAddress.street}<br>
City:${user.userAddress.city}<br>
Zip:${user.userAddress.zip}