## Game of Life rules

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead. Every cell interacts with its eight neighbors, which are the cells that are directly horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

- Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
- Any live cell with more than three live neighbours dies, as if by overcrowding.
- Any live cell with two or three live neighbours lives on to the next generation.
- Any dead cell with exactly three live neighbours becomes a live cell.

The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed. 
Births and deaths happen simultaneously, and the discrete moment at which this happens is sometimes called a tick 
(in other words, each generation is a pure function of the one before). The rules continue to be applied repeatedly to create further generations.

## Tests

. . .    . # .    # # #
. . . -> # # # -> # # #
. . .    . # .    # # #

. . #    . # .    # # #
# . # -> # # # -> # # #
# # #    . # .    # # #

. # #    # # .    # # #
# . # -> # # # -> # # #
# # .    . # .    # # #

y, x  : 1,1
y, x-1  : 1,0
y-1, x-1: 0,0
y-1, x  : 0,1
y-1, x+1: 0,2
y, x+1  : 1,2
y+1, x+1: 2,2
y+1, x  : 2,1
y+1, x-1: 2,0