# CasgemBootcamp
Java Spring Boot Bootcamp Project</br>
This project was developed with monolith architecture

# Entities Layer
It is the layer where the database entities are
<li><b>users</b> folder contains applicant,employee,instructor,user</li>
<li>The applicant,employee,instructor class inherits from the user class. polymorphism technique was used</li>

<li>There are classes in the <b>evaluations</b> folder where the relevant training application information will be kept and the state status of this application information. Application,ApplicationState</li>
<li>In the <b>Applications</b> folder, there is the class where the bootcamp information will be kept, the class related to the status of these bootcamps, and the class where the students will be blacklisted so that they cannot apply for bootcamp otherwise. Bootcamp,BootcampState,Blacklist</li>
</br>
<li><b>@OneToMany</b> relationship exists between Instructor and BootCamp</li>
