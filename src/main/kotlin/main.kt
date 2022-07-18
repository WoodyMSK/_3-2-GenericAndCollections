import NoteServices.add
import NoteServices.comments
import NoteServices.delete
import NoteServices.edit
import NoteServices.getById
import NoteServices.notes
import NoteServices.createComment
import NoteServices.deleteComment
import NoteServices.editComment
import NoteServices.getComments
import NoteServices.get
import NoteServices.restoreComment

fun main() {
    add("Заголовок1","Коммент1")
    add("Заголовок2","Коммент2")
    add("Заголовок3","Коммент3")
    add("Заголовок4","Коммент4")
    add("Заголовок5","Коммент5")
    add("Заголовок6","Коммент6")

    createComment(1, "Text comment 1");
    createComment(2, "Text comment 2");
    createComment(1, "Text comment 3");
    createComment(2, "Text comment 4");
    createComment(1, "Text comment 5");
    createComment(2, "Text comment 6");

    println(getComments(0,1,5))

//    println(comments)
//    println(comments[2].delete)
//    println(comments[2].commentId)
//    println("---------------------------\n")
//
//    deleteComment(3)
//
//    println(comments)
//    println(comments[2].delete)
//    println(comments[2].commentId)
//    println("---------------------------\n")
//
//    println(restoreComment(3))
//
//    println(comments)
//    println(comments[2].delete)
//    println(comments[2].commentId)
}

