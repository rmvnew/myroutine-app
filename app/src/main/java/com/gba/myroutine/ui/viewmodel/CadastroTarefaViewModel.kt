package com.gba.myroutine.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gba.myroutine.model.Tarefa
import com.gba.myroutine.repository.TarefaRepository

class CadastroTarefaViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application.applicationContext

    private val repository: TarefaRepository = TarefaRepository(context)

    private var mTarefaSalva = MutableLiveData<Boolean>()
    val tarefaSalva : LiveData<Boolean> = mTarefaSalva

    private var mTarefaRemovida = MutableLiveData<Boolean>()
    val tarefaRemovida : LiveData<Boolean> = mTarefaRemovida

    private var mTarefa = MutableLiveData<Tarefa>()
    val tarefa : LiveData<Tarefa> = mTarefa

    fun save(tarefa: Tarefa) {
        if (tarefa.id == 0)
            mTarefaSalva.value = repository.save(tarefa)
        else
            mTarefaSalva.value = repository.update(tarefa)
    }

    fun delete(id: Int) {
        mTarefaRemovida.value = repository.delete(Tarefa().apply {this.id = id})
    }

    fun load(id: Int) {
        if(id > 0)
            mTarefa.value = repository.get(id)
    }
}