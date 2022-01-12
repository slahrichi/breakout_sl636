# Breakout Plan
### Saad Lahrichi


## Interesting Breakout Variants

 * Super Breakout

Although the idea is not exclusive to Super Breakout, I liked having the powerups like multi-ball triggers.
I thought this was interesting because it forces the player to make a tradeoff between having multiple balls 
and therefore more chance to break more blocks and having to save all the balls from falling. The other powerup 
of laser shooting is also fun as it makes the game easier to win. This would come in handy in levels with blocks
that require being touched more than once for them to break.

 * Pinball Breakout

I really liked this version of the game because I played extensively both games when I was younger, yet never thought 
about a possible combination of the two. However, I watched a few gameplays of this variant and thought that it may be 
too boring. That is, if once the ball is stuck in some bouncing area, the player can do nothing but watch
and the paddle does not serve any purpose.  


## Paddle Ideas

 * Bouncing depends on area hit

This is a classic implementation of the paddle and a key feature to make the game more fun. 
If the ball hits the paddle in the middle, it bounces off vertically (90 degrees), if it hits the left (right) of the paddle,
it goes back to the left (right) direction (maybe 45 degrees)

 * Pausing the ball

This would be a sort of pause for the user. If the ball is on the paddle and the user presses 'P', then 
the ball is stuck to the paddle until 'P' is pressed again. I am not sure if I would be able to 
make this even more advanced and allowing the user to move the block "paddle+ball" while stuck together and 
restart the game from a "better" position. This would require a power-up.


## Block Ideas

 * Indestructible blocks

For more difficult levels, it would be fun having some blocks that cannot break but simply return the ball.

 * Multiple-hit blocks

It can be fun to have blocks that need to be hit more than once before they break.

 * Power-up blocks

These would be lucky blocks that when broken, release a power-up.


## Power-up Ideas

 * Shrink Paddle

Some power-ups can also be negative. This would make the paddle smaller and the game harder. 

 * Speed-up the ball

This would make the ball move faster.

 * Extra lives

This would give the player an extra life and make the game longer.


## Cheat Key Ideas

 * Level cleared

This would make the player pass the current level regardless of the situation

 * Unlimited lives

This would allow the player to lose as often as possible without ever "losing" the game. That is,
there will not be a "lives" counter anymore.

 * Power-up

This would break a block containing a power-up and release it to the player without them actually breaking the block.

 * Slow down

This would slow down the speed of the ball but not the paddle so that the player can still catch the ball
if in harder levels.


## Level Descriptions

 * Protect the Queen

This level would have blocks arranged in layers of rectangle that "protect" the inner core. 
The outside rectangles require to be hit less often than the inner ones to break 

 * Reusable Paddle

This level would have a special paddle that can only hit the ball a set number of times (e.g. 70). After 
the paddle is used up, it disappears and nothing can catch the ball anymore.

 * Fortress

This level would have many indestructible blocks. 


## Class Ideas

 * Ball

useful methods: bounce, reset

 * Paddle

useful method: move

 * Block
 
useful method: break

 * player

useful method: pause

