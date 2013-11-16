Code that creates players, puts them into 2 teams, balances them, plays them against eachother and then keeps track of their "score"

Each player has "skill points". Like elo as used in chess and later on in League of legends. When you win a game you gain "Skill points" and with a defeat you lose them.

First though, you calculate how much each player in each team has contributed in percent based on match score. 
Then you take say 10% of the enemy teams "skill points" and the worst player in the losing team then has to give most of his skill points. He/she was the worst player on that team and therefore he would have to go out of the match with the biggest loss of skill points. Each player on the losing team has to give some skill points. The winning team is then given the skillpoints, again based on how much he/she contributed to the team. The person with the most matchpoints is given the most skillpoints afterwards as he/she was the best so he/she should leave with the greatest increase in skill points.

When a match is started one person in the queue is selected as the seed. Then other people in the queue who are within 5-10%(not sure) of the seeds skill level and the seed is added to the pool. The player found via the seed is then the next seed. This keeps going until the pool is enough players (4-8-10-16-whatever). Then the teams are randomly divided and each team has their collected skill points counted. The players are then sorted based on their skill and if needed the players with the least skill points in each team are switched to balance the teams.

I'm not even sure if this would work and also be fair because the code doesnt work entirely yet.