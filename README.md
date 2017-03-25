## Project Metis
**Efficient Route Recommendation System**

Route recommendation system using Google Maps API and calculation using QGIS. 
Made for GO-HACKATHON by GO-JEK on 25-26 March 2017 in Jakarta, ID

### Idea
#### Problem

Maps and geolocation technology utilized by location-based applications in Indonesia tend to provide inaccurate route. Most of adapted maps technology may not cover unique situations which only apply in Indonesia, such as odd-even number area policy, car free day, motorcycle-free roads policy, traffic jam, and small street shortcuts (known as *jalan tikus*) that are often uncharted on most mapping softwares.

#### Solution

**Project Metis** is trying to solve this geolocation problem and adapt existing technology to Indonesian unique traffic characteristics. With machine learning and crowd sourcing, Project Metis focuses on route suggestion, route consideration, and route exception by gathering information on factors mentioned on diagram below. Project Metis is expected to recommend more efficient, more accurate routes for motorcycles and cars based on data on events that are uniquely occuring in Indonesia.

----------------------------
## Table of Contents
[TOC]

![Titaness Metis Image](https://image.ibb.co/gec2Dv/metis.jpg "Titaness Metis Image")

## Getting Started

## Deployment

## What to do next
This project is far from finished, it barely even started. 
### Crowd Sourcing
The next step of development is implementing crowd sourcing for gathering data on events like accidents, or maybe if there is wedding that blocks the street. This can easily be achieved through Waze API.
### Moooreee Data
More dataset should be created for streets that contain tolls, 3 in 1 policy and one way street.
The final and biggest part of the application should be generating route with *jalan tikus* or *gang* in it. This can be done through GPS data gathering from drivers.

## Built With
 - [Gradle][gradle] - Dependency Manager
 - [Spark][spark] - RESTful framework for Java backend
 - [Google Maps API][gmap] - Map interface for user
 - [QGIS][qgis] - Geography Information System Application

## Authors
 - [**Valentina Kania**][balbal] Backend Developer and All-Around Code Ninja
 - [**Fellita Candini**][gelgel] Backend Developer and BANANA NINJA
 - [**Felicia**][mig] Frontend Developer and Hooman Project Manager

## License
This project is licensed under the MIT License - see the [LICENSE.md][licenselink] file for details

## Acknowledgements

[gradle]: http://www.gradle.org
[spark]: http://www.sparkjava.com
[gmap]: http://developers.google.com/maps
[qgis]: http://www.qgis.org
[mig]: https://github.com/feliciakrismanta
[gelgel]: https://github.com/canfelli25
[balbal]: https://github.com/valentinakania
[licenselink]: LICENSE.md