<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>

<%@ page import="com.google.inject.Injector" %>

<script src="javascript/jquery.js" type="text/javascript"></script>
<%@ include file="/includes/_taglibInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Enterpride-Stores</title>
    <script type="text/javascript">
        function MakeArrayday(size) {
            this.length = size;
            for(var i = 1; i <= size; i++) {
                this[i] = "";
            }
            return this;
        }
        function MakeArraymonth(size) {
            this.length = size;
            for(var i = 1; i <= size; i++) {
                this[i] = "";
            }
            return this;
        }
        function funClock() {
            var runTime = new Date();
            var hours = runTime.getHours();
            var minutes = runTime.getMinutes();
            var seconds = runTime.getSeconds();
            var dn = "AM";

            if (hours >= 12) {

                dn = "PM";
                hours = hours - 12;
            }
            if (hours == 0) {
                hours = 12;
            }
            if (minutes <= 9) {
                minutes = "0" + minutes;
            }
            if (seconds <= 9) {
                seconds = "0" + seconds;
            }
            movingtime = ""+ hours + ":" + minutes + ":" + seconds + " " + dn + "";

            document.getElementById("clock").innerHTML = movingtime;
            setTimeout("funClock()", 1000);
        }
        setTimeout("funClock()", 100);
    </script>
</head>
<body >

<s:layout-definition>
    <table width="100%" height="100%" border="0" align="center"  style="background-color:#FCFCFC;">
        <tr >
            <td height="30" colspan="2" align="right"><s:layout-component name="header"><div align="right" style="margin-right: 5px;color:black;font-size:10px;font-family:sans-serif; font-weight: bold;">WELCOME
                <s:link beanclass="com.inwise.action.UserActionBean" event="logout" class="links" style="font-size:11px;">(Logout)</s:link></a></div>
                <div align="right" style="margin-right:5px;color:black;" class="labels">
                    <%	Date date = Calendar.getInstance().getTime();
                        DateFormat formatter = new SimpleDateFormat("dd MMMM, yyyy");
                    %>
                    <%= formatter.format(date) %>
                    <input type="hidden" name="inDate1" id="inDate1" value="<%= formatter.format(date) %>"/>
                    <span id="clock" style="position:relative;"></span>
                </div>
            </s:layout-component></td>
        </tr>
        <tr style="background: url(/images/navigation2_product_bottom.png) center center repeat-x;">
            <td height="20" colspan="2"> <s:layout-component name="menu">
                <div class="menu">





                    <ul>
                          <li><a class="hide" href="#">Customer</a>
                            <ul>
                                <li><s:link beanclass="com.inwise.action.CustomerActionBean" event="pageDirect">Add</s:link></li>
                                <li><s:link beanclass="com.inwise.action.CustomerActionBean" event="updateCustomerLink">Update</s:link></li>
                                <li><s:link beanclass="com.inwise.action.CustomerActionBean" event="deleteLink">Delete</s:link></li>

                            </ul>
                        </li>

                        <li><a class="hide" href="#">Product</a>
                                                 <ul>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="addUserLink">Add</s:link></li>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="updateUserLink">Update</s:link></li>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="deleteUserLink">Delete</s:link></li>

                                                 </ul>
                                             </li>

                         <li><a class="hide" href="#">Tax</a>
                                                 
                                             </li>
                                 <li><a class="hide" href="#">Order</a>
                                                 <ul>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="addUserLink">Add</s:link></li>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="updateUserLink">Update</s:link></li>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="deleteUserLink">Delete</s:link></li>
                                                   <li><s:link beanclass="com.inwise.action.UserActionBean" event="deleteUserLink">Advance Payment</s:link></li>
                                                 </ul>
                                             </li>
                        <li><a class="hide" href="#">Invoice</a>
                                                 <ul>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="addUserLink">Add</s:link></li>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="updateUserLink">Update</s:link></li>
                                                    

                                                 </ul>
                                             </li>
                        <li><a class="hide" href="#">Search/Print</a>
                                                 <ul>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="addUserLink">Search</s:link></li>
                                                     <li><s:link beanclass="com.inwise.action.UserActionBean" event="updateUserLink">Print</s:link></li>


                                                 </ul>
                                             </li>
                                   <li><a class="hide" href="#">User Management</a>
                            <ul>
                                <li><s:link beanclass="com.inwise.action.UserActionBean" event="addUserLink">Add</s:link></li>
                                <li><s:link beanclass="com.inwise.action.UserActionBean" event="updateUserLink">Update</s:link></li>
                                <li><s:link beanclass="com.inwise.action.UserActionBean" event="deleteUserLink">Delete</s:link></li>
                                <li><s:link beanclass="com.inwise.action.UserActionBean" event="rolePermissionLink">Role Permission</s:link></li>
                                <li><s:link beanclass="com.inwise.action.UserActionBean" event="userPermissionLink">User Permission</s:link></li>
                            </ul>
                        </li>

                           <li><a class="hide" href="#">Report</a>

                                             </li>
                        
                    </ul>

                    <!--[if lte IE 6]>
                    </td></tr></table>
                    </a>
                    <![endif]-->

                           

                </div>
                <%--<p id="iepara">Rest of content here</p>--%>
            </s:layout-component></td>
        </tr>
        <tr >
                <%--<td width="15%" height="432">${left_menu}</td>--%>
            <td valign="top">   <s:layout-component name="body"></s:layout-component></td>
        </tr>
        <tr >
            <td height="30" colspan="2"><s:layout-component name="footer"></s:layout-component></td>
        </tr>
    </table>
</s:layout-definition>
</body>
</html>