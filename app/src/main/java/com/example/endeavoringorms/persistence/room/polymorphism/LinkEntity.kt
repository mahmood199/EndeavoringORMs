package com.example.endeavoringorms.persistence.room.polymorphism

import androidx.core.text.HtmlCompat
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "links")
data class LinkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val url: String
) : Note {
    override val displayText: CharSequence
        get() = HtmlCompat.fromHtml(
            """<a href="$url">$title</a>""",
            HtmlCompat.FROM_HTML_MODE_COMPACT
        )
}
