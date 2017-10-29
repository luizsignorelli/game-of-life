package luizsignorelli

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CenterCellOnA3x3World {

    @Test
    fun `an alive center cell dies with 1 alive neighbours`() {
        val centerCell = Cell.alive()

        val world = listOf(listOf(Cell.alive(), Cell.dead(), Cell.dead()),
                           listOf(Cell.dead(),  centerCell,  Cell.dead()),
                           listOf(Cell.dead(),  Cell.dead(), Cell.dead()))

        val centerCellAfterTick = centerCell.tick(world)

        assertTrue(centerCellAfterTick.dead())
    }

    @Test
    fun `an alive center cell dies with 4 alive neighbours`() {
        val centerCell = Cell.alive()

        val world = listOf(listOf(Cell.alive(), Cell.alive(), Cell.alive()),
                           listOf(Cell.alive(), centerCell,   Cell.alive()),
                           listOf(Cell.dead(),  Cell.dead(),  Cell.dead()))

        val centerCellAfterTick = centerCell.tick(world)

        assertTrue(centerCellAfterTick.dead())
    }

    @Test
    fun `an alive center cell lives with 2 alive neighbours`() {
        val centerCell = Cell.alive()

        val world = listOf(listOf(Cell.alive(), Cell.alive(), Cell.dead()),
                           listOf(Cell.dead(),  centerCell,   Cell.dead()),
                           listOf(Cell.dead(),  Cell.dead(),  Cell.dead()))

        val centerCellAfterTick = centerCell.tick(world)

        assertTrue(centerCellAfterTick.alive())
    }

    @Test
    fun `an alive center cell lives with 3 alive neighbours`() {
        val centerCell = Cell.alive()

        val world = listOf(listOf(Cell.alive(), Cell.alive(), Cell.alive()),
                           listOf(Cell.dead(),  centerCell,   Cell.dead()),
                           listOf(Cell.dead(),  Cell.dead(),  Cell.dead()))

        val centerCellAfterTick = centerCell.tick(world)

        assertTrue(centerCellAfterTick.alive())
    }

    @Test
    fun `a dead center cell lives with 3 alive neighbours`() {
        val centerCell = Cell.dead()

        val world = listOf(listOf(Cell.alive(), Cell.alive(), Cell.alive()),
                listOf(Cell.dead(),  centerCell,   Cell.dead()),
                listOf(Cell.dead(),  Cell.dead(),  Cell.dead()))

        val centerCellAfterTick = centerCell.tick(world)

        assertTrue(centerCellAfterTick.alive())
    }

    @Test
    fun `a dead center cell continue dead with 2 alive neighbours`() {
        val centerCell = Cell.dead()

        val world = listOf(listOf(Cell.alive(), Cell.alive(), Cell.dead()),
                           listOf(Cell.dead(),  centerCell,   Cell.dead()),
                           listOf(Cell.dead(),  Cell.dead(),  Cell.dead()))

        val centerCellAfterTick = centerCell.tick(world)

        assertTrue(centerCellAfterTick.dead())
    }

}