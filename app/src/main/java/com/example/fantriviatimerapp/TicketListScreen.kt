package com.example.fantriviatimerapp

    import androidx.compose.foundation.layout.*
            import androidx.compose.foundation.lazy.LazyColumn
            import androidx.compose.foundation.lazy.items
            import androidx.compose.material3.*
            import androidx.compose.runtime.*
            import androidx.compose.ui.Modifier
            import androidx.compose.ui.unit.dp
            import androidx.hilt.navigation.compose.hiltViewModel
            import com.example.fantriviatimerapp.viewmodel.TicketViewModel

            @Composable
            fun TicketListScreen(viewModel: TicketViewModel = hiltViewModel()) {
                val tickets by viewModel.tickets.collectAsState()

                // Automatically trigger fetching the tickets once when this Composable appears
                LaunchedEffect(Unit) {
                    viewModel.fetchTickets()
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Tickets",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    LazyColumn {
                        items(tickets) { ticket ->
                            Text(
                                text = ticket,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(8.dp)
                            )
                            Divider()
                        }
                    }
                }
            }