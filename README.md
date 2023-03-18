# MusicWiki

MusicWiki is an unofficial Last.fm app that provides information about different music genres, albums, artists, and tracks listed under a particular genre. The app is built using Kotlin programming language, Last.fm API, Glide Image Library, Retrofit Library, and Android Studio.

## Table of Contents

* Features
* Technologies Used
* Architecture and Design Pattern
* Concepts Used
* Decisions and Assumptions
* Working of the App
* Contributing
* License

## Features

* Display a list of available music genres on the Home Screen.
* Display the title and description of a selected genre on the GenreInfo Activity.
* Display the list of top albums, top tracks, and top artists of a selected genre on the GenreInfo Activity.
* Display the title, artist name, and cover image (if available) of each album listed under the top albums section.
* Display the artist name and cover image (if available) of each artist listed under the top artists section.
* Display the title, artist name, and cover image (if available) of each track listed under the top tracks section.
* Display the cover image, title, and artist information (which includes the description and the list of genres in a horizontal recyclerview) of a selected album on the AlbumInfo Activity.
* Display the image, title, play count, and listeners, description, top tracks, top albums, and genres of a selected artist on the ArtistInfo Activity.
* Clicking on a listed album takes the user to the AlbumInfo Activity, while clicking on a listed artist takes the user to the ArtistInfo Activity.

## Technologies Used

* Kotlin Programming Language
* Last.fm API
* Glide Image Library
* Retrofit Library
* Android Studio

## Architecture and Design Pattern

The app uses the MVVM architecture and coroutines to asynchronously call the API. It follows the repository pattern where API calls happen through the repository, which becomes the single source of truth for the app. The ViewModels can access the repository and then provide the LiveData to the activities and fragments to observe.

## Concepts Used

* VVM Architecture
* Coroutines
* Glide Image Library
* Retrofit Library
* ViewPager and Adapter

## Decisions and Assumptions

* Changed the initial UI of the app from the TabLayout to a normal RecyclerView to display all the topTags/topGenres on the Home Screen.
* Used the Retrofit library instead of the Volley library.
Did not work much on the UI as time was limited, and made it as minimalistic as possible.
* Had to create many data classes because the API is not well-maintained and changes its parameters, making data classes non-reusable.
* For the Artists and Tracks section, the images are not visible because the API itself does not provide the right image URL.
* In the ArtistInfo Activity, it's the number of listeners and not the number of followers.
* Did not convert the listeners and play counts to the nearest number to show them in the "k" format.

## Working of the App
<img src="Sample/App.gif" height = "450" width="250">