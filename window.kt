package game

import java.awt.Dimension
import javax.swing.JFrame

class Window(game: Game): JFrame("Window") {

    init {

        add(game)
        addKeyListener(game)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        size = Dimension(600, 400)
        isResizable = false
        isVisible = true

    }

}