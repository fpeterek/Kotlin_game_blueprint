package game

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel
import javax.swing.Timer

class Game: JPanel(), KeyListener, ActionListener {

    private val timer = Timer(15, this)

    private val window = Window(this)

    private val square = Square()

    init {
        background = Color(120, 200, 200)
    }

    private fun gameUpdate() {

        square.update()
        repaint()

    }

    override fun paint(g: Graphics?) {

        if (g == null) {
            return
        }

        super.paint(g)

        g.color = square.color
        g.fillRoundRect(square.x, square.y, square.side, square.side, 10, 10)

    }

    override fun actionPerformed(e: ActionEvent?) {
        gameUpdate()
    }

    override fun keyPressed(e: KeyEvent?) {

        if (e == null) {
            return
        }

        when (e.keyCode) {

            KeyEvent.VK_UP -> square.jump()
            KeyEvent.VK_LEFT -> square.movingLeft = true
            KeyEvent.VK_RIGHT -> square.movingRight = true

        }

    }

    override fun keyReleased(e: KeyEvent?) {

        if (e == null) {
            return
        }

        when (e.keyCode) {

            KeyEvent.VK_LEFT -> square.movingLeft = false
            KeyEvent.VK_RIGHT -> square.movingRight = false

        }

    }

    override fun keyTyped(e: KeyEvent?) {

        if (e == null) {
            return
        }

    }

    private fun finalize() {
        timer.stop()
    }

    init {
        timer.start()
    }

}