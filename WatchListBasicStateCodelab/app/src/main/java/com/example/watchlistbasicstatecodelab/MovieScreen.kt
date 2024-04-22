import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.Column

import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.watchlist.AddMovieRow

@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    movieViewModel: MovieViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        //row with input box and button
        AddMovieRow(
            onAddMovie = { title ->
                val newMovie =  MovieTask(movieViewModel.tasks.size + 1, title)
                movieViewModel.add(newMovie)
            }
        )

        MovieTasksList(
            list = movieViewModel.tasks,
            onCheckedTask = { task, checked ->
                movieViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                movieViewModel.remove(task)
            }
        )
    }
}