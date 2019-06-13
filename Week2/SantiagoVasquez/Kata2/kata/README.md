### High Score

High Score is a multiplayer game. 
Players have 3 opportunities to score 
their highest scores and win the player 
with the highest score sum, until another 
player score a new highest score sum.

Endpoints
* Singleton:
http://{host}:{port}/high-score/{player name}/singleton
* Prototype:
http://{host}:{port}/high-score/{player name}/prototype

#### Conclusions
Singleton Beans remains their attributes until the server 
is reload without care whom is calling it, different from 
Prototype Beans that let you create multiple instances
when different clients invoke them.