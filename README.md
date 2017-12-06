# This is a programming assignment 

# Description
User can select origin and destination and get fare for the selected route.

# To build and run it locally 
1. Clone the repository
1. Make sure gradle installed
1. In the terminal being in the root directory run the command `gradle stage`
1. Make sure Docker and Docker Compose are installed and docker is running
1. In the terminal being in the root directory run the command `docker-compose up --build`
1. The application should be available at http://localhost:9000

![Interface](/screenshots/interface.png)
![Selecting destination](/screenshots/interface2.png)

# Building process
`gradle stage` task first triggers Frontend build, then copying files to the `src` folder of the Backend, 
then building Backend, then copying jar to the root `build` folder.

# Technologies used
1. Gradle
1. Spring Boot
1. Angular
1. Docker 
1. Docker compose