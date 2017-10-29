package luizsignorelli

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UpperLeftCellOnA3x3World {

    @Test
    fun `an alive upperLeft cell dies with 1 alive neighbour`() {
        val upperLeftCell = Cell.alive()

        val world = World(listOf(listOf(upperLeftCell, Cell.dead(),  Cell.dead()),
                                 listOf(Cell.dead(),   Cell.alive(), Cell.dead()),
                                 listOf(Cell.dead(),   Cell.dead(),  Cell.alive())))

        val upperLeftCellAfterTick = upperLeftCell.tick(world)

        Assertions.assertTrue(upperLeftCellAfterTick.dead())
    }

    @Test
    fun `an alive upperLeft cell lives with 2 alive neighbours`() {
        val upperLeftCell = Cell.alive()

        val world = World(listOf(listOf(upperLeftCell, Cell.alive(), Cell.dead()),
                                 listOf(Cell.dead(),  Cell.alive(), Cell.dead()),
                                 listOf(Cell.dead(), Cell.dead(), Cell.dead())))

        val upperLeftCellAfterTick = upperLeftCell.tick(world)

        Assertions.assertTrue(upperLeftCellAfterTick.alive())
    }

    @Test
    fun `an alive upperLeft cell lives with 3 alive neighbours`() {
        val upperLeftCell = Cell.alive()

        val world = World(listOf(listOf(upperLeftCell, Cell.alive(), Cell.alive()),
                           listOf(Cell.alive(),  Cell.alive(), Cell.dead()),
                           listOf(Cell.dead(), Cell.dead(), Cell.dead())))

        val upperLeftCellAfterTick = upperLeftCell.tick(world)

        Assertions.assertTrue(upperLeftCellAfterTick.alive())
    }

    @Test
    fun `a dead upperLeft cell lives with 3 alive neighbours`() {
        val upperLeftCell = Cell.dead()

        val world = World(listOf(listOf(upperLeftCell, Cell.alive(), Cell.alive()),
                                 listOf(Cell.alive(),  Cell.alive(), Cell.dead()),
                                 listOf(Cell.dead(), Cell.dead(), Cell.dead())))

        val upperLeftCellAfterTick = upperLeftCell.tick(world)

        Assertions.assertTrue(upperLeftCellAfterTick.alive())
    }

    @Test
    fun `a dead upperLeft cell continue dead with 2 alive neighbours`() {
        val upperLeftCell = Cell.dead()

        val world = World(listOf(listOf(upperLeftCell, Cell.alive(), Cell.dead()),
                                 listOf(Cell.dead(),  Cell.alive(), Cell.dead()),
                                 listOf(Cell.dead(), Cell.dead(), Cell.dead())))

        val upperLeftCellAfterTick = upperLeftCell.tick(world)

        Assertions.assertTrue(upperLeftCellAfterTick.dead())
    }

}