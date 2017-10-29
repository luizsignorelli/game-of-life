package luizsignorelli

data class Cell(private val state: State) {
    companion object {
        fun alive() = Cell(State.ALIVE)
        fun dead() =  Cell(State.DEAD)
    }

    enum class State {
        ALIVE {
            override fun tick(cell: Cell, world: World): Cell {
                val aliveCells = cell.aliveNeighbours(world)
                return when {
                    aliveCells < 2  -> Cell.dead()
                    aliveCells == 2 -> Cell.alive()
                    aliveCells == 3 -> Cell.alive()
                    aliveCells > 3  -> Cell.dead()
                    else            -> throw RuntimeException("Alive cells count is a very strange number")
                }
            }
        },
        DEAD {
            override fun tick(cell: Cell, world: World): Cell {
                return when (cell.aliveNeighbours(world)) {
                    3 -> Cell.alive()
                    else -> Cell.dead()
                }
            }
        };

        abstract fun tick(cell: Cell, world: World): Cell
    }

    fun alive(): Boolean = state == State.ALIVE
    fun dead() : Boolean = !alive()

    fun tick(world: World): Cell {
        return state.tick(this, world)
    }

    private fun aliveNeighbours(world: World): Int {
        return world.aliveNeighboursOf(this)
    }

}