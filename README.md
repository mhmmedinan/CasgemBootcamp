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
<li><b>@OneToMany</b> relationship exists between applicant and application</li>
<li><b>@OneToMany</b> relationship exists between applicant and blacklist</li>
</br>
<li><b>@OneToMany</b> relationship exists between applicationstate and application</li>
<li><b>@ManyToOne</b> relationship exists between application and applicant</li>
<li><b>@ManyToOne</b> relationship exists between application and bootcamp</li>
<li><b>@ManyToOne</b> relationship exists between application and applicationstate</li>
</br>
<li><b>@ManyToOne</b> relationship exists between blacklist and applicant</li>
<li><b>@ManyToOne</b> relationship exists between bootcamp and instructor</li>
<li><b>@ManyToOne</b> relationship exists between bootcamp and bootcampstate</li>
<li><b>@OneToMany</b> relationship exists between bootcamp and application</li>
<li><b>@OneToMany</b> relationship exists between bootcampstate and bootcamp</li>

# DataAccess Layer
It is the data access layer
<li>JpaRepository used</li>

# Business Layer
It is the layer where business codes are written.

<li>Request Response pattern used</li>
<li>Business rules were written to comply with the clean code and Domain Driven Design principle</li>
<li>Result infrastructure was used for the success or failure of the data.</li>
<li>Relevant repositories from DataAccess layer are used in manager classes with dependency injection method</li>

# Core Layer
It is the layer created for the use of project-independent open source codes within the project.
<li>It includes techniques such as exceptions, mapping, result</li>

# WebApi Layer
It is the layer used to transfer the project to the client side.
Uses Restful infrastructure.

<hr>
<li>Postgresql used as database</li>
<li>A global exception has been written to the bootcampapplication class for validation operations.</li>
<img src="https://github.com/mhmmedinan/CasgemBootcamp/blob/master/src/main/java/com/bootcampProject/validationexception.png" witdh=auto>
