package mx.udg.cuvalles.mynotesapp

import androidx.room.*

@Dao
interface NotaDao {

    @Query("select * from Nota")
    suspend fun getAll():List<Nota>

    @Query("select * from nota where id = :id")
    suspend fun getBiId(id:Int):Nota

    @Update
    suspend fun actualizar(nota: Nota)

    @Insert
    suspend fun insert(notas:List<Nota>)

    @Delete
    suspend fun eliminar(nota: Nota)

}