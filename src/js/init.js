$('.hiddenfield').hide();
new google.maps.event.addDomListener( window, 'load', init );
// Google Maps API copy & pasted below:
// see https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete-addressform

var placeSearch, autocomplete;
var componentForm = {
  street_number: 'short_name',
  route: 'long_name',
  locality: 'long_name',
  administrative_area_level_1: 'short_name',
  country: 'long_name',
  postal_code: 'short_name'
};

function initAutocomplete() {
  // Create the autocomplete object, restricting the search to geographical
  // location types.
  autocomplete = new google.maps.places.Autocomplete(
    /** @type {!HTMLInputElement} */
    (document.getElementById('autocomplete')), {
      types: ['geocode']
    });

  // When the user selects an address from the dropdown, populate the address
  // fields in the form.
  autocomplete.addListener('place_changed', fillInAddress);
}

function fillInAddress() {
  // Get the place details from the autocomplete object.
  var place = autocomplete.getPlace();

  for (var component in componentForm) {
    document.getElementById(component).value = '';
    document.getElementById(component).disabled = false;
  }

  // Get each component of the address from the place details
  // and fill the corresponding field on the form.
  for (var i = 0; i < place.address_components.length; i++) {
    var addressType = place.address_components[i].types[0];
    if (componentForm[addressType]) {
      var val = place.address_components[i][componentForm[addressType]];
      document.getElementById(addressType).value = val;
    }
  }
}

// Bias the autocomplete object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
function geolocate() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var geolocation = {
        lat: position.coords.latitude,
        lng: position.coords.longitude
      };
      var circle = new google.maps.Circle({
        center: geolocation,
        radius: position.coords.accuracy
      });
      autocomplete.setBounds(circle.getBounds());
    });
  }
}



/*sidenav*/
$('.button-collapse').sideNav({
      menuWidth: 300, // Default is 240
      closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
    }
  );
  $('.collapsible').collapsible();

   $(".button-collapse").sideNav({
        menuWidth: 350,
        closeOnClick: true
    });

(function($){
  $(function(){



  }); // end of document ready
})(jQuery); // end of jQuery name space

// When the window has finished loading create our google map below

function init() {
	// Basic options for a simple Google Map
	// For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
	var mapOptions = {
		center: new google.maps.LatLng( -6.143179, 106.895744 ),
		zoom: 12,
		zoomControl: true,
		zoomControlOptions: {
			style: google.maps.ZoomControlStyle.DEFAULT,
		},
		disableDoubleClickZoom: true,
		mapTypeControl: false,
		scaleControl: true,
		scrollwheel: true,
		panControl: true,
		streetViewControl: true,
		draggable: true,
		overviewMapControl: true,
		overviewMapControlOptions: {
			opened: false,
		},
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		// How you would like to style the map. 
		// This is where you would paste any style found on Snazzy Maps.
		styles: [ {
			"featureType": "all",
			"elementType": "all",
			"stylers": [ {
				"visibility": "on"
			} ]
		}, {
			"featureType": "all",
			"elementType": "labels",
			"stylers": [ {
				"visibility": "off"
			}, {
				"saturation": "-100"
			} ]
		}, {
			"featureType": "all",
			"elementType": "labels.text.fill",
			"stylers": [ {
				"saturation": 36
			}, {
				"color": "#000000"
			}, {
				"lightness": 40
			}, {
				"visibility": "off"
			} ]
		}, {
			"featureType": "all",
			"elementType": "labels.text.stroke",
			"stylers": [ {
				"visibility": "off"
			}, {
				"color": "#000000"
			}, {
				"lightness": 16
			} ]
		}, {
			"featureType": "all",
			"elementType": "labels.icon",
			"stylers": [ {
				"visibility": "off"
			} ]
		}, {
			"featureType": "administrative",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#000000"
			}, {
				"lightness": 20
			} ]
		}, {
			"featureType": "administrative",
			"elementType": "geometry.stroke",
			"stylers": [ {
				"color": "#000000"
			}, {
				"lightness": 17
			}, {
				"weight": 1.2
			} ]
		}, {
			"featureType": "landscape",
			"elementType": "geometry",
			"stylers": [ {
				"color": "#000000"
			}, {
				"lightness": 20
			} ]
		}, {
			"featureType": "landscape",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#4d6059"
			} ]
		}, {
			"featureType": "landscape",
			"elementType": "geometry.stroke",
			"stylers": [ {
				"color": "#4d6059"
			} ]
		}, {
			"featureType": "landscape.natural",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#4d6059"
			} ]
		}, {
			"featureType": "poi",
			"elementType": "geometry",
			"stylers": [ {
				"lightness": 21
			} ]
		}, {
			"featureType": "poi",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#4d6059"
			} ]
		}, {
			"featureType": "poi",
			"elementType": "geometry.stroke",
			"stylers": [ {
				"color": "#4d6059"
			} ]
		}, {
			"featureType": "road",
			"elementType": "geometry",
			"stylers": [ {
				"visibility": "on"
			}, {
				"color": "#7f8d89"
			} ]
		}, {
			"featureType": "road",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#7f8d89"
			} ]
		}, {
			"featureType": "road.highway",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#7f8d89"
			}, {
				"lightness": 17
			} ]
		}, {
			"featureType": "road.highway",
			"elementType": "geometry.stroke",
			"stylers": [ {
				"color": "#7f8d89"
			}, {
				"lightness": 29
			}, {
				"weight": 0.2
			} ]
		}, {
			"featureType": "road.arterial",
			"elementType": "geometry",
			"stylers": [ {
				"color": "#000000"
			}, {
				"lightness": 18
			} ]
		}, {
			"featureType": "road.arterial",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#7f8d89"
			} ]
		}, {
			"featureType": "road.arterial",
			"elementType": "geometry.stroke",
			"stylers": [ {
				"color": "#7f8d89"
			} ]
		}, {
			"featureType": "road.local",
			"elementType": "geometry",
			"stylers": [ {
				"color": "#000000"
			}, {
				"lightness": 16
			} ]
		}, {
			"featureType": "road.local",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#7f8d89"
			} ]
		}, {
			"featureType": "road.local",
			"elementType": "geometry.stroke",
			"stylers": [ {
				"color": "#7f8d89"
			} ]
		}, {
			"featureType": "transit",
			"elementType": "geometry",
			"stylers": [ {
				"color": "#000000"
			}, {
				"lightness": 19
			} ]
		}, {
			"featureType": "water",
			"elementType": "all",
			"stylers": [ {
				"color": "#2b3638"
			}, {
				"visibility": "on"
			} ]
		}, {
			"featureType": "water",
			"elementType": "geometry",
			"stylers": [ {
				"color": "#2b3638"
			}, {
				"lightness": 17
			} ]
		}, {
			"featureType": "water",
			"elementType": "geometry.fill",
			"stylers": [ {
				"color": "#24282b"
			} ]
		}, {
			"featureType": "water",
			"elementType": "geometry.stroke",
			"stylers": [ {
				"color": "#24282b"
			} ]
		}, {
			"featureType": "water",
			"elementType": "labels",
			"stylers": [ {
				"visibility": "off"
			} ]
		}, {
			"featureType": "water",
			"elementType": "labels.text",
			"stylers": [ {
				"visibility": "off"
			} ]
		}, {
			"featureType": "water",
			"elementType": "labels.text.fill",
			"stylers": [ {
				"visibility": "off"
			} ]
		}, {
			"featureType": "water",
			"elementType": "labels.text.stroke",
			"stylers": [ {
				"visibility": "off"
			} ]
		}, {
			"featureType": "water",
			"elementType": "labels.icon",
			"stylers": [ {
				"visibility": "off"
			} ]
		} ]
	};
	var mapElement = document.getElementById( 'map' );
	var map = new google.maps.Map( mapElement, mapOptions );
	var locations = [
		[ 'Monumen Nasional', 'undefined', 'undefined', 'undefined', 'undefined', -6.175455, 106.827085, 'https://mapbuildr.com/assets/img/markers/solid-pin-yellow.png' ],
		[ 'Fasilkom', 'undefined', 'undefined', 'undefined', 'undefined', -6.364334, 106.828689, 'https://mapbuildr.com/assets/img/markers/solid-pin-red.png' ]
	];
	for ( i = 0; i < locations.length; i++ ) {
		if ( locations[ i ][ 1 ] == 'undefined' ) {
			description = '';
		} else {
			description = locations[ i ][ 1 ];
		}
		if ( locations[ i ][ 2 ] == 'undefined' ) {
			telephone = '';
		} else {
			telephone = locations[ i ][ 2 ];
		}
		if ( locations[ i ][ 3 ] == 'undefined' ) {
			email = '';
		} else {
			email = locations[ i ][ 3 ];
		}
		if ( locations[ i ][ 4 ] == 'undefined' ) {
			web = '';
		} else {
			web = locations[ i ][ 4 ];
		}
		if ( locations[ i ][ 7 ] == 'undefined' ) {
			markericon = '';
		} else {
			markericon = locations[ i ][ 7 ];
		}
		marker = new google.maps.Marker( {
			icon: markericon,
			position: new google.maps.LatLng( locations[ i ][ 5 ], locations[ i ][ 6 ] ),
			map: map,
			title: locations[ i ][ 0 ],
			desc: description,
			tel: telephone,
			email: email,
			web: web
		} );
		link = '';
		bindInfoWindow( marker, map, locations[ i ][ 0 ], description, telephone, email, web, link );
	}

	function bindInfoWindow( marker, map, title, desc, telephone, email, web, link ) {
		var infoWindowVisible = ( function() {
			var currentlyVisible = false;
			return function( visible ) {
				if ( visible !== undefined ) {
					currentlyVisible = visible;
				}
				return currentlyVisible;
			};
		}() );
		iw = new google.maps.InfoWindow();
		google.maps.event.addListener( marker, 'click', function() {
			if ( infoWindowVisible() ) {
				iw.close();
				infoWindowVisible( false );
			} else {
				var html = "<div style='color:#000;background-color:#fff;padding:5px;width:150px;'><h4>" + title + "</h4></div>";
				iw = new google.maps.InfoWindow( {
					content: html
				} );
				iw.open( map, marker );
				infoWindowVisible( true );
			}
		} );
		google.maps.event.addListener( iw, 'closeclick', function() {
			infoWindowVisible( false );
		} );
	}
	var waypts = [];
	directionsService = new google.maps.DirectionsService();
	directionsDisplay = new google.maps.DirectionsRenderer( {
		suppressMarkers: true
	} );
	if ( locations.length > 1 ) {
		for ( var i = 0; i < locations.length; i++ ) {
			waypts.push( {
				location: new google.maps.LatLng( locations[ i ][ 5 ], locations[ i ][ 6 ] ),
				stopover: true
			} );
		};
		var request = {
			origin: new google.maps.LatLng( locations[ 0 ][ 5 ], locations[ 0 ][ 6 ] ),
			destination: new google.maps.LatLng( locations[ locations.length - 1 ][ 5 ], locations[ locations.length - 1 ][ 6 ] ),
			waypoints: waypts,
			optimizeWaypoints: true,
			travelMode: google.maps.DirectionsTravelMode.DRIVING
		};
		directionsService.route( request, function( response, status ) {
			if ( status == google.maps.DirectionsStatus.OK ) {
				polylineOptions = {
					strokeColor: '#d580ff',
					strokeWeight: '3'
				}
				directionsDisplay.setOptions( {
					polylineOptions: polylineOptions
				} );
				directionsDisplay.setDirections( response );
			}
		} );
		directionsDisplay.setMap( map );
	}
}

function myMap() {
var mapProp= {
    center:new google.maps.LatLng(51.508742,-0.120850),
    zoom:5,
};
var map=new google.maps.Map(document.getElementById("map"),mapProp);
}

