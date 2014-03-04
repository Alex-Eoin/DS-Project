BSHCE4 with the National College of Ireland
Distributed Systems Project Deliverable

Lecturer:
	Brian Gillespie 

Students:
	Alex Quigley - x10205691,
	Eoin McCrann - x10201271

Project Name:
	Battlebots

Project Repository:
	https://github.com/Alex-Eoin/DS-Project

Project Description:
	Java/Corba client server based game, derived from the popular game 'Battleships'. 
	Battlebots, is a turn based strategy game requiring 2 players. Clients interact through a central Server.	

Project Requirements Summary:
	'Develop a dynamic client server based communication system that is based on Java/Corba.' 
	'The dynamic client server can be a game-based system.' 
	'System should consist of a client that can access various systems that allow communication to take place between other clients. E.G. chatroom, etc.' 

Project Marking Scheme:
	
	1. After choosing a topic area, Create an IDL file that represents the three systems i.e. the communication system that you have chosen, address book and chatroom. Hint: At the start of the project concentrate on creating a client-server communication system. At a later stage merge the communication system that you have created with the formative assessments on the address book and chatroom.
(20 marks)

	2. Create the servants that represent the functionality of the above system based on the delegation model.
(10 marks)

	3. Create a Server that stores the references to each communication system separately using the Java naming service. The name graph shall be at least 2 levels in depth.
(10 marks)

	4. Create a GUI based client that allows the user select a service to interact with. References to the service shall be identified using the Corba NameService.
(15 marks)

	5. Demonstrate the use of Any and typecodes in the communication system that you have chosen.
(15 marks)

	6. Demonstrate the use of request synchronisation when communicating from the client to your communication system. Request Synchronization shall include Synchronous, Oneway, Deferred and Asynchronous requests.
(4 x 5 marks)

	7. Discretionary (elegance, tidiness, easy to read/understand etc.
(10 marks)
