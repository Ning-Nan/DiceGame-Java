Game Rules:

1. No players added then no operations are allowed.

2. Before player rolls he must place bet first.

3. House can roll only two players are rolled.

4. Players can only roll once in the same round. And cannot place bet after roll.

5. Player information is displayed in status bar.

6. Middle panel is used to display running dice.


Some points:

1. Maintain rolled players list in Main Frame. 
	It is simple and if I maintain it in somewhere else or other classes, It will use a lot of calls and pass more parameters.
	I understand the MVC model, but we are not allowed to modify gameEngine interfaces. 
	
2. Does not give dialog Box one class.
	Just like in javascript, one call with message and it jumps out. 
	Give it one class is not necessary, even I give one, I still use it in the same way, I still need to pass the message.
	And also make the functions complex and unclear.

The points are how I understand the project. I may be wrong.