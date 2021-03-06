package com.gba.myroutine.dao

import androidx.room.*
import com.gba.myroutine.model.Usuario

@Dao
interface UsuarioDAO {
    @Insert
    fun save(Usuario: Usuario) : Long

    @Query("SELECT *FROM Usuario WHERE email=:uEmail AND senha=:uSenha")
    fun getByLogin(uEmail: String, uSenha: String) : Usuario

    @Query("SELECT *FROM Usuario WHERE email=:uEmail")
    fun getByEmail(uEmail: String) : Usuario
}