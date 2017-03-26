## Project Metis

![Metis App Logo](http://i.imgur.com/5nidf5w.png "Metis App Logo")

**Efficient Route Recommendation System**

Route recommendation system using Google Maps API. 

Made for GO-HACKATHON by GO-JEK on 25-26 March 2017 in Jakarta, ID

### Main Idea
#### Problem

Maps and geolocation technology utilized by location-based applications in Indonesia tend to provide inaccurate route. Most of adapted maps technology may not cover unique situations which only apply in Indonesia, such as odd-even number area policy, car free day, motorcycle-free roads policy, traffic jam, and small street shortcuts (known as *jalan tikus*) that are often uncharted on most mapping softwares.

#### Solution

**Project Metis** is trying to solve this geolocation problem and adapt existing technology to Indonesian unique traffic characteristics. With machine learning and crowd sourcing, Project Metis focuses on route suggestion, route consideration, and route exception by gathering information on factors mentioned on diagram below. Project Metis is expected to recommend more efficient, more accurate routes for motorcycles and cars based on data on events that are uniquely occuring in Indonesia.

#### Technical Details

**Route Restriction**
The main problem in developing apps in Indonesia is how nonexistent datasets are. For the sake of MVP, we manually created dataset of routes with restrictions, focusing on odd-even, motorcycle free road, and 3 in 1 policy. We have not found any automated method to create this kind of dataset, since most of the search results only contain news sites and not official government's website. One possible idea to automate this is by using sentiment analysis to find streets that are impacted by these policies. We created the data as GeoJSON to ease importing the calculated data back to Google Map API.

The algorithm we use to achieve alternative route recommendation by considering these route restriction is like this:
- User entered their departure point and destination point
- The app checks whether routes suggested by google has any exception routes in the dataset
- If there is any, the app will find intersecting point where exception route meet the original google suggested route
- App use Djikstra to find shortest, alternative route to go back to original suggested route without passing the restricted route

**Crowd sourcing** 
The easiest way possible is of course using already existing, largely adopted Waze API, but it is not entirely open, so we cannot utilize the data maximally. Another possible way to crowd source is to gather alot of GPS data, and we can calculate the average speed on that particular street to determine whether there are disruption on certain street or whether the street is a one way street.

**_Jalan Tikus_** 
This feature is, in our opinion, the hardest to implement but the main idea is like this:
In Indonesia, there are alot of so called _jalan tikus_ or narrow street that are often uncharted on Google Maps. The Google Maps Snap to Road technology is very sophisticated, it can eliminate these _jalan tikus_, even though they are quite far from the main road. The idea is we can gather alot of raw GPS data, before they are 'snapped', with certain amount of these raw data, we can use linear regression to predict whether that area has _jalan tikus_ or not, and then it could be considered for next route generation. _Jalan tikus_ are tricky little streets that only known to locals. Though travelling through these streets are often the only way to reach a place, and often can reduce user's travel time immensely.

## What we achieved in hackathon day
- We created small section of dataset covering 3 in 1 policy, motorcycle free road, odd even road and car free day in Jakarta
- We implemented the algorithm to intersecting route polygons
- We implemented the program to create alternative route according to those intersected polygons
- We created simple front end to display the output for the sake of hackathon presentation

## What's next
This project is far from finished, it barely even started. Alot need to be done and not enough time to do them. Here are a few key things we would like to be improved if time and resources allows. 
#### Crowd Sourcing
The next step of development is implementing crowd sourcing for gathering data on events like accidents, or maybe if there is wedding that blocks the street. This can easily be achieved through Waze API for some type of data, while others would need other kind of approach.
#### Mwooaaarrr Data
More dataset should be created for streets that contain tolls, 3 in 1 policy and one way street.
The final and biggest part of the application should be generating route with *jalan tikus* or *gang* in it. This can be done through GPS data gathering from drivers.

----------------------------

![Titaness Metis Image](https://image.ibb.co/gec2Dv/metis.jpg "Titaness Metis Image")

## Getting Started
This is simple instruction to get you running under 5 minutes to use the API

### Prerequisites
- JDK
- Spark
- XAMPP (or equivalent)
- Postman App (or equivalent, suggested)

### Instruction
- Clone this repo
- Post request (using postman)
```
localhost:4567/path?start=[String of starting point]&end=[String of ending point]&car=[true if car, false if motorcycle]
```
Example
```
localhost:4567/path?start=Gedung+Arsip+Nasional&end=Teater+Jakarta&car=true
```
- Open project-metis/index.html for front end interface as web app

## Built With
 - [Gradle][gradle] - Dependency Manager
 - [Spark][spark] - RESTful framework for Java backend
 - [Google Maps API][gmap] - Map interface

## Authors
 - [**Valentina Kania**][balbal] Backend Developer and All-Around Code Ninja
 - [**Fellita Candini**][gelgel] Backend Developer and BANANA NINJA
 - [**Felicia**][mig] Frontend Developer and Hooman Project Manager

## License
This project is licensed under the MIT License - see the [LICENSE.md][licenselink] file for details

## Acknowledgements
- [MaterializeCSS][materialize]
- [SnazzyMaps][snazzy]
- [Derek R Liang on codepen][codepen]

[codepen]: https://codepen.io/derekrliang/pen/GZBezL
[snazzy]: https://snazzymaps.com
[materialize]: https://materializecss.com
[gradle]: http://www.gradle.org
[spark]: http://www.sparkjava.com
[gmap]: http://developers.google.com/maps
[mig]: https://github.com/feliciakrismanta
[gelgel]: https://github.com/canfelli25
[balbal]: https://github.com/valentinakania
[licenselink]: LICENSE.md