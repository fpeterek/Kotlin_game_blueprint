package game

import java.awt.Color

class Square {

    val side = 50

    private var xcoor = 0
    private var ycoor = 0.0

    var movingLeft = false
    var movingRight = false

    private var force = 0.0

    val x: Int
        get() = xcoor
    val y: Int
        get() = ycoor.toInt()

    val color: Color
        get() = Color.RED

    fun update() {

        forceUpdate()

        if (movingLeft) {
            xcoor -= 3
        }
        if (movingRight) {
            xcoor += 3
        }

        ycoor -= force.toInt()

        checkBoundaries()

    }

    private fun checkBoundaries() {

        if (xcoor < 0) {
            xcoor = 0
        }
        else if (xcoor > 600 - side) {
            xcoor = 600 - side
        }

        if (ycoor < 0) {
            ycoor = 0.0
            force = 0.0
        }
        else if (ycoor > 380 - side) {
            ycoor = 380 - side.toDouble()
        }

    }

    private fun forceUpdate() {

        if (force == -7.0) {
            return
        }



        force -= if (force > 0.1) {
            0.1 + (5.0 - force) / 20.0
        } else {
            0.2 + (0 - force) / 20.0
        }

        force = Math.max(-7.0, force)

    }

    fun jump() {
        force = 5.0
    }

}
