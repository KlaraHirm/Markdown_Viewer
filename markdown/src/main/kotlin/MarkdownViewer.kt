import javax.swing.*
import java.awt.*

fun main() {
    // Create a JFrame (main window)
    val frame = JFrame("Markdown Viewer")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(600, 400)

    val backgroundColor = Color(247, 228, 244)

    val panel = JPanel()
    panel.layout = BorderLayout()
    panel.background = backgroundColor

    // Create a button to load a file
    val loadButton = JButton("Load Markdown File")

    panel.add(loadButton, BorderLayout.NORTH)

    frame.contentPane = panel

    frame.isVisible = true
}