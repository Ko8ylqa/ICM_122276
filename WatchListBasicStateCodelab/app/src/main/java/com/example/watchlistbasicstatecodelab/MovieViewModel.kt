import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {
    private val _tasks = getMovieTasks().toMutableStateList()
    val tasks: List<MovieTask>
        get() = _tasks


    fun remove(item: MovieTask) {
        _tasks.remove(item)
    }

    //add
    fun add(item: MovieTask) {
        _tasks.add(item)
    }

    fun changeTaskChecked(item: MovieTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}

private fun getMovieTasks() = listOf(
    MovieTask(1, "Dune 2")
)