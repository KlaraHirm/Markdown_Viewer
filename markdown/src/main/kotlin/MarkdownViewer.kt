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

    // Create a JTextArea to display the content of the file
    val textArea = JTextArea()
    textArea.isEditable = false
    textArea.background = backgroundColor

    // Add a scroll pane for the text area
    val scrollPane = JScrollPane(textArea)
    scrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    scrollPane.preferredSize = Dimension(580, 300)

    // Add an action listener to the button
    loadButton.addActionListener {
        val fileChooser = JFileChooser()
        val result = fileChooser.showOpenDialog(frame)

        if (result == JFileChooser.APPROVE_OPTION) {
            val selectedFile: File = fileChooser.selectedFile
            if (selectedFile.extension == "md") {
                try {
                    val content = selectedFile.readText()
                    textArea.text = content
                    frame.title = "Markdown Viewer - ${selectedFile.absolutePath}"
                    loadButton.text = "Load Different Markdown File"
                } catch (e: Exception) {
                    JOptionPane.showMessageDialog(frame, "Error reading the file.", "File Error", JOptionPane.ERROR_MESSAGE)
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a Markdown (.md) file.", "Invalid File", JOptionPane.ERROR_MESSAGE)
            }
        }
    }

    panel.add(loadButton, BorderLayout.NORTH)
    panel.add(scrollPane, BorderLayout.CENTER)

    frame.contentPane = panel

    frame.isVisible = true
}