import javax.swing.*
import java.awt.*
import java.io.File

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

    // Add an action listener to the button
    loadButton.addActionListener {
        val fileChooser = JFileChooser()
        val result = fileChooser.showOpenDialog(frame)

        if (result == JFileChooser.APPROVE_OPTION) {
            val selectedFile: File = fileChooser.selectedFile
            if (selectedFile.extension == "md") {
                try {
                    print("correct")
                } catch (e: Exception) {
                    print(e)
                }
            } else {
                print("wrong extension")
            }
        }
    }

    panel.add(loadButton, BorderLayout.NORTH)

    frame.contentPane = panel

    frame.isVisible = true
}