package vasin.roomwordsample

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)

@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}