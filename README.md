# Tennis Test

## What is this project?

This is the implementation for a simple coding test. It's not the most efficient but I found it funny to design a score graph instead of a bunch of `if` statements.

## What is the tennis coding test?

### Principle

The rules of tennis:

1.  Each player can have a score in this set of values: 0 15 30 40
2.  If a player has a score of 40 and wins the next ball, they win the _game_. However there is another rule:
3.  If both players reach 40, it is called a _deuce_.
    -  When there is a deuce, the winning player gets an _advantage_.
    -  If the player with the advantage wins the next ball, they win the game.
    -  If the player without the advantage wins the next ball, it is deuce again.
    

### Test

The goal of this test is to write a programm that, given a list with the names of the players who win the balls as input, can output the score of the game, finished or not.

### Input file & examples

This is an example of input files:

```
Nadal
Federer
Nadal
Nadal
Nadal
Federer
Federer
Nadal
Nadal
Federer
Nadal
Nadal
Federer
Federer
Federer
Nadal
Nadal
Federer
```

The result is a tie of 1 game each, with a score of 30-15 in favor of Nadal. Explanations:

```
Nadal   //15-0
Federer //15-15
Nadal   //30-15
Nadal   //40-15
Nadal   //game Nadal (1-0)
Federer //15-0
Federer //30-0
Nadal   //30-15
Nadal   //30-30
Federer //40-30
Nadal   //deuce
Nadal   //advantage Nadal
Federer //deuce
Federer //advantage Federer
Federer //game Federer (1-1)
Nadal   //15-0
Nadal   //30-0
Federer //30-15
```
