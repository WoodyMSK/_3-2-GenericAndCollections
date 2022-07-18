data class Note(
    var title: String,
    var text: String,
    var addDate: Long,
    var delete: Boolean,
    var noteId: Int,

    ) {
    override fun toString(): String {
        if (delete == false) return "Заметка: $title " + "Текст заметки: $text" + "\n"

        return ""
    }


}