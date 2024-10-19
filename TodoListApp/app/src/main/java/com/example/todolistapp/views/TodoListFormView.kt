package com.example.todolistapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolistapp.R
import com.example.todolistapp.viewModels.TodoListFormViewModel
import com.example.todolistapp.views.templates.TodoListDatePicker
import com.example.todolistapp.views.templates.TodoListDropdown
import com.example.todolistapp.views.templates.TodoListOutlinedTextField

@Composable
fun TodoListFormView(
    todoListFormViewModel: TodoListFormViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val todoListFormUIState = todoListFormViewModel.todoListFormUIState.collectAsState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TodoListOutlinedTextField(
                inputValue = todoListFormViewModel.titleInput,
                onValueChange = {
                    todoListFormViewModel.changeTitleInput(it)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                labelText = stringResource(R.string.title_text),
                placeholderText = stringResource(R.string.title_text),
                minLine = 1,
                maxLine = 1
            )

            TodoListOutlinedTextField(
                inputValue = todoListFormViewModel.descriptionInput,
                onValueChange = {
                    todoListFormViewModel.changeDescriptionInput(it)
                },
                labelText = stringResource(R.string.description_text),
                placeholderText = stringResource(R.string.description_text),
                minLine = 10,
                maxLine = 10,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            Row(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
            ) {
                TodoListDropdown(
                    dropdownMenuExpanded = todoListFormUIState.value.statusDropdownExpandedValue,
                    onDismissRequest = {
                        todoListFormViewModel.dismissStatusDropdownMenu()
                    },
                    dropdownItems = todoListFormUIState.value.statusDropdownItems,
                    onDropdownItemClick = {
                        todoListFormViewModel.changeStatusInput(it)
                    },
                    onDropdownMenuBoxExpandedChange = {
                        todoListFormViewModel.changeStatusExpandedValue(it)
                    },
                    selectedItem = todoListFormViewModel.statusInput,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .weight(1f),
                    labelText = "Status"
                )

                TodoListDropdown(
                    dropdownMenuExpanded = todoListFormUIState.value.priorityDropdownExpandedValue,
                    onDismissRequest = {
                        todoListFormViewModel.dismissPriorityDropdownMenu()
                    },
                    dropdownItems = todoListFormUIState.value.priorityDropdownItems,
                    onDropdownItemClick = {
                        todoListFormViewModel.changePriorityInput(it)
                    },
                    onDropdownMenuBoxExpandedChange = {
                        todoListFormViewModel.changePriorityExpandedValue(it)
                    },
                    selectedItem = todoListFormViewModel.priorityInput,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .weight(1f),
                    labelText = "Priority"
                )
            }

            // TODO: Date Picker
        }

        Column {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Gray)
            ) {
                Text(text = "Cancel")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun CreateTodoListViewPreview() {
    TodoListFormView(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )
}