object NoteServices {
    val notes = mutableListOf<Note>()
    val comments = mutableListOf<Comment>()

    fun add(
        title: String,
        text: String,

    ): Int {
        var title = title
        var text = text
        var addDate = System.currentTimeMillis() / 1000L
        var noteId = notes.size + 1

        val note = Note(title, text, addDate, delete = false, noteId)

        notes.add(note)

        return noteId
    }

    fun createComment(
        noteId: Int,
        message: String,

    ): Int {
        var noteId = noteId
        var message = message
        val addDate = System.currentTimeMillis() / 1000L
        var commentId = comments.size + 1

        val comment = Comment(noteId, message,addDate, delete = false, commentId)

        comments.add(comment)

        return commentId
    }

    fun delete(noteId: Int): Int {
        for(note in notes) {
            if (note.noteId == noteId) note.delete = true
        }

        return 1
    }

    fun deleteComment(commentId: Int) :Int {
        for(comment in comments) {
            if (comment.commentId == commentId) comment.delete = true
        }

        return 1
    }


    fun edit(noteId: Int, title: String, text: String): Int {
        for (note in notes) {
            if (note.noteId == noteId) {
                val noteApdate = Note(title, text, addDate = note.addDate, delete = note.delete, noteId = note.noteId)
                notes[noteId - 1] = noteApdate
            }

        }

        return 1
    }

        fun editComment(commentId: Int, message: String,): Int {
            for (comment in comments) {
                if (comment.commentId == commentId) {
                    val commentApdate = Comment(noteId = comment.noteId, message,addDate = comment.addDate, delete = comment.delete, comment.commentId)
                    comments[commentId - 1] = commentApdate
                }

            }

            return 1
        }


        fun get(arr: Array<Int>, sort: Int, count: Int): List<Note> {
            var list = mutableListOf<Note>()

            for (e in arr) {
                var note = notes[e - 1]
                if (note != null) list.add(note)
            }

            if (sort == 0) list = list.asReversed()

            return if (list.size <= count) list else list.take(count).toMutableList()
        }


        fun getById(noteId: Int): Note? {

            for (note in notes) {
                if (note.noteId == noteId) return note
            }
            return null
        }


        fun getComments(noteId: Int, sort: Int, count: Int): List<Comment> {
            var list = mutableListOf<Comment>()

            for (comment in comments) {
                if (comment.noteId == noteId) list.add(comment)
            }

            if (sort == 0) list = list.asReversed()

            return if (list.size <= count) list else list.take(count).toMutableList()
        }


        fun restoreComment(commentId: Int): Int {
            for (comment in comments) {
                if (comment.commentId == commentId) comment.delete = false
            }

            return 1
        }



}

