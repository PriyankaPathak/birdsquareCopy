function getLocation() {
    if (navigator.geolocation){
        navigator.geolocation.getCurrentPosition(showPosition, showError);
        console.log("getloca");
        }

    else
        alert("your browser does not support Geolocation");
}


function showPosition(position) {
    document.getElementById("addLocation").innerHTML +=
        "<form id='form-addlocation"  + "' method='post' action='checkinform'> " +
            " <input type='hidden' name='name' /> " +
            " <input type='hidden' name='latitude' value=" + position.coords.latitude +" /> " +
            " <input type='hidden' name='longitude' value=" + position.coords.longitude +" /> "+
            "</form>";

    var foursquareAPIURL = "https://api.foursquare.com/v2/venues/search?ll=" + position.coords.latitude + "," + position.coords.longitude + "&oauth_token=XQZOS4SH3WHZ32EKFAUX3YU45CFEJGYZTFR2C5F0KMB1EHCX&v=20121030"
    $.getJSON(foursquareAPIURL, function (data) {


        for (var i = 0; i < data.response.venues.length; i++) {
            var location = showLocations(data.response.venues[i]);

            document.getElementById("location-container").innerHTML +=

               "<form id='form-"+i+"' method='post' action='checkinform'> " +
               " <input type='hidden' name='name' value=\"" + location.name +"\" /> " +
               " <input type='hidden' name='latitude' value=" + location.lat +" /> " +
               " <input type='hidden' name='longitude' value=" + location.lng +" /> " +
               "</form>"+
                "<li data-corners='false' data-shadow='false' data-iconshadow='true' data-wrapperels='div' data-icon='arrow-r'"+
                "data-iconpos='right' data-theme='c' class='ui-btn ui-btn-icon-right ui-li-has-arrow ui-li ui-btn-up-c'>"+
                "<div class='ui-btn-inner ui-li'><div class='ui-btn-text'><a onclick=\"document.getElementById('form-" + i + "').submit();\" "+
                 "rel='external' class='ui-link-inherit'>"+
                 location.name + "</a></div><span class='ui-icon ui-icon-arrow-r ui-icon-shadow'>&nbsp;</span></div></li>";
        };

    });
}

function showLocations(data) {
    var locationList = new Array();
    var location = {
        "name":data.name,
        "lat":data.location.lat,
        "lng":data.location.lng
    };
    return location;
}

function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            alert("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
            alert("Location information is unavailable.");
            break;
        case error.TIMEOUT:
            alert("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            alert("An unknown error occurred.");
            break;
    }
}