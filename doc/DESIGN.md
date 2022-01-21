# Breakout Design
## Saad Lahrichi


## Design Goals
Add a Paddle that can move sideways, a ball that bounces when hits the paddle, the walls, or bricks.
Bricks that have strengths and need to be hit strength times before they break. Powerups that are hidden
behind some bricks that can make the ball faster/slower, the paddle faster/slower,...

## High-Level Design
The Main class takes care of setting up the Game and displaying the scene after all nodes are added to it. It also handles the key input from the user
(to move the Paddle, pause the game, change levels...). It also handles the player's lives and score.
The Ball class is concerned with the Ball and its bouncing. The Paddle class handles the paddle movement and interacts with the Ball
class(ball bounce at contact).The Brick class simply makes Brick objects and the AllBricks class handles
reading the text file, translating it to a collection of bricks and handling bricks breaking when the ball is in contact.
It also generates PowerUps hidden behind Blocks and handles interactions with the Ball by calling its bounce method.
The PowerUp class is incomplete but is supposed to extend the Ball class (as powerups are just balls that only fall) and make changes to the game once collected
by the paddle. 

## Assumptions or Simplifications
I assumed that the text files will only have digits. At first, I represented indestructible blocks by inf but realized
that it would be hard to handle both ints and Strings when reading the file and storing it in an arraylist. I now represent 
indestructible blocks by 8.

## Changes from the Plan

The only thing I regret not completing is the PowerUps as I had some nice ideas for them. My cheat keys are also not the same. 
The player can add to themselves lives, however they cannot get powerups or clear the level. The level issue is due 
to the layout showing as superimposed, instead of clearing the current one and showing a new one. Otherwise, everything went according to plan.


## How to Add New Levels

To add new levels, we can simply add a new txt file with any disposition of digits to our resource folder.
We can also add new powerups once the Powerup superclass is functional.  
