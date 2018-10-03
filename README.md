## General Overview

You have 3 hours to make an app that consists of 2 screens, a master view that shows a grid of profiles pictures retrieved through a read-only API and a 
details view which displays some extra information from the selected profile. It should also be possible to mark profiles as favorites. The API is available at 
[https://fierce-harbor-90458.herokuapp.com](https://fierce-harbor-90458.herokuapp.com) and  supports JSON. The first request may take a minute to load due to Heroku free tier policies.

### API Description
#### GET /profiles
Returns an array of profiles, with `id` and `profile_picture` fields. Example:

    curl https://fierce-harbor-90458.herokuapp.com/profiles
    
Response:

    [
        {
            "id":0,
            "profile_picture":"http://..."
        }, {
            "id":1,
            "profile_picture":"http://..."
        }
    ]
#### GET /profiles/:id
Returns a detailed profile with `id`, `profile_picture`, `first_name` and `last_name` fields. Example:

    curl https://fierce-harbor-90458.herokuapp.com/profiles/3
    
Response:

    {
        "id":3,
        "first_name":"Cassondra",
        "last_name":"Amo",
        "profile_picture":"http://..."
    }
    
## App Requirements
### General
* Profiles can be marked as favorites, this should be handled locally (e.g. there's no API calls for this) and should persist through app restarts
* Use the provided app icons and assets
    * [Download iOS Assets](http://goo.gl/YJrd38)
    * [Download Android Assets](http://goo.gl/ckNmm1)
* Use any library of framework
* For Android
    * Use Java
    * Use Gradle for dependency management
* For iOS
    * Use Swift
    * Use Carthage or Cocoapods for dependency management
* Use your best judgment if there are any ambiguities
* Prioritize tasks as you see fit
* Consult Google as much as necessary, but please don't use any in-person help

#### Master Screen - [Click here for the mockup](http://goo.gl/rdgl6z)
* Display a scrollable grid of all profiles pictures retrieved from the API
* Grid should be 2 columns wide
* Images should be square
* Display a star icon, layered on top of the profile if it's been added to favorites
* Tapping on a profile picture opens the details screen

#### Details Screen - [Click here for the mockup](http://goo.gl/OWYrPp)
* Retrieve the full profile from the API
* Display profile picture as a full-screen wide square
* Display the full (first + last names) in the title bar
* Display a toggle favorite button below the profile picture
