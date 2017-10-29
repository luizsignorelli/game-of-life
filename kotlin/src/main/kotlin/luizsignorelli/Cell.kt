package luizsignorelli

data class Cell(private val state: State) {
    companion object {
        fun alive() = Cell(State.ALIVE)
        fun dead() =  Cell(State.DEAD)
    }

    enum class State {
        ALIVE {
            override fun tick(cell: Cell, world: List<List<Cell>>): Cell {
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
            override fun tick(cell: Cell, world: List<List<Cell>>): Cell {
                return when (cell.aliveNeighbours(world)) {
                    3 -> Cell.alive()
                    else -> Cell.dead()
                }
            }
        };

        abstract fun tick(cell: Cell, world: List<List<Cell>>): Cell
    }

    fun alive(): Boolean = state == State.ALIVE
    fun dead() : Boolean = !alive()

    fun tick(world: List<List<Cell>>): Cell {
        return state.tick(this, world)
    }

    private fun aliveNeighbours(world: List<List<Cell>>): Int {
        var aliveCells = world.flatten().count { it.alive() }
        if (this.alive()) aliveCells -= 1

        return aliveCells
    }
}