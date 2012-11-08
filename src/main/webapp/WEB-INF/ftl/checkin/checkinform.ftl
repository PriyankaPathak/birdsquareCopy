<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <title>BirdSquare: Check In</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="javascript/validation.js"></script>
    <script type="text/javascript" src="javascript/location.js"></script>
    <script type="text/javascript" src="javascript/birdnameautocomplete.js"></script>
</head>

<body>

<div data-role="page" id="checkinform">

    <form name="birdinformation" onsubmit="return validateForm()" action="status" method="post" data-ajax="false">
    <#include "../headers/header-with-submit.ftl">

        <div data-role="content" id="checkinform-content">


            <label for="location-field" class="ui-accessible">You are at</label>
        <#--here, input name is to be matched up with what's in validation.js and also in the Model file. id is to match with label for-->
            <input type ="text" name="locationName" id="location-field" placeholder="Enter location name" value="${locationName}" size="20"/>
            <p></p>

            <div class="ui-widget" style="font-family: 'Arial'">
                <p>Enter sighting details</p>
                <label for="birdname-field" class="ui-hidden-accessible"></label>
                <input type="text" name="birdName" id="birdname-field" placeholder="Bird name"/>

                <label for ="numberofbirds-field" class="ui-hidden-accessible"></label>
                <input type="text" name="number" id="numberofbirds-field" placeholder="Number of birds seen" />

                <label for ="comments-field" class="ui-hidden-accessible"></label>
                <textarea id="comments" name="comments" id="comments-field" placeholder="Comments"></textarea>

                <input type="hidden" name="latitude" value="${latitude}"/>
                <input type="hidden" name="longitude" value="${longitude}"/>

            <#--<datalist id="searchresults">-->
            <#--<#list allbirds as item>-->
            <#--<option>${item}</option>-->
            <#--</#list>-->
            <#--</datalist>-->


            </div>
        </div>

    </form>
<#include "../footer.ftl">
</div><!-- /page -->

</body>
</html>

