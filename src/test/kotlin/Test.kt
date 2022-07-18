import org.jetbrains.annotations.TestOnly
import NoteServices
import NoteServices.comments
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.testng.Reporter.clear

class TestNoteServices {
    private val noteService = NoteServices

    @Test
    fun add() {
        val result = noteService.add("Заголовок1","text1")
        assertEquals(1, result)
    }

    @Test
    fun createComment() {
        val result = noteService.createComment(1, "Text comment1");
        assertEquals(1, result)
    }

    @Test
    fun delete() {
        val result = noteService.delete(1)
        assertEquals(1, result)
    }

    @Test
    fun deleteComment() {
        val result = noteService.deleteComment(1)
        assertEquals(1, result)
    }

    @Test
    fun edit() {
        val result = noteService.edit(1, "Заголовок NEW", "text NEW")
        assertEquals(1, result)
    }

    @Test
    fun editComment() {
        val result = noteService.editComment(1, "Text comment NEW")
        assertEquals(1, result)
    }

    @Test
    fun get() {
        val note1 = noteService.add("Заголовок1","text1")
        val note2 = noteService.add("Заголовок2","text2")
        val note3 = noteService.add("Заголовок3","text3")
        val note4 = noteService.add("Заголовок4","text4")
        val note5 = noteService.add("Заголовок5","text5")
        val note6 = noteService.add("Заголовок6","text6")

        val get1 = noteService.getById(1)
        val get2 = noteService.getById(2)
        val get3 = noteService.getById(3)
        val get4 = noteService.getById(4)
        val get5 = noteService.getById(5)
        val get6 = noteService.getById(6)

        val result = noteService.get(arrayOf(1,3,5), 1, 3)

        assertEquals(listOf(get1, get3, get5), result)
    }

    @Test
    fun getComment() {
        val comment1 = noteService.createComment(1, "Text comment 1");
        val comment2 = noteService.createComment(2, "Text comment 2");
        val comment3 = noteService.createComment(1, "Text comment 3");
        val comment4 = noteService.createComment(2, "Text comment 4");
        val comment5 = noteService.createComment(1, "Text comment 5");
        val comment6 = noteService.createComment(2, "Text comment 6");

        val result = noteService.getComments(2, 1, 7)


        assertEquals(mutableListOf(comments[1], comments[3], comments[5]), result)
    }

    @Test
    fun restoreComment() {
    val result = noteService.restoreComment(1)
    assertEquals(result,1)
    }
}