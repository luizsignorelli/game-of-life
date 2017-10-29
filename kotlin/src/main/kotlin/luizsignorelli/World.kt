package luizsignorelli

class World {
    private val cells: List<List<Cell>>
    private val indexedWorld: List<Triple<Int, Int, Cell>>

    constructor(cells: List<List<Cell>>){
        this.cells = cells
        this.indexedWorld = indexedWorld(cells).flatten()
    }

    fun aliveNeighboursOf(cell: Cell): Int  = neighboursOf(cell).count { it.alive() }

    private fun neighboursOf(cell: Cell): List<Cell> {
        val (i, j) = coordinatesOf(cell)

        return indexedWorld.filter {
            !((it.first  == i)   && (it.second == j))  &&
             ((it.first  >= i-1) && (it.first  <= i+1)) &&
             ((it.second >= j-1) && (it.second <= i+1))
        }.map { it.third }
    }

    private fun coordinatesOf(cell: Cell): Pair<Int, Int> {
        val (i, j, _) = indexedWorld.first { it.third === cell }

        return Pair(i,j)
    }

    private fun indexedWorld(cells: List<List<Cell>>): List<List<Triple<Int, Int, Cell>>> {
        return cells.mapIndexed { i, line ->
            line.mapIndexed { j, cell ->
                Triple(i, j, cell)
            }
        }
    }
}
