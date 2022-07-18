import NoteServices.getById
import java.sql.Time
import java.time.LocalTime

data class Comment(
    var noteId: Int,
    var message: String,
    val addDate: Long,
    var delete: Boolean,
    var commentId: Int

) {
    override fun toString(): String {
        if (delete == false) return "Идентификатор комментария: $commentId; Идентификатор заметки: $noteId; Дата добавления: $addDate; Тест комментария: $message\n"

        return ""

    }
}