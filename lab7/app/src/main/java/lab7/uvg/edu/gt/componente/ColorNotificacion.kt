package lab7.uvg.edu.gt.componente

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable



@Composable
fun getNotificationBackgroundColor(type: NotificationType): Color {
    return when (type) {
        NotificationType.GENERAL -> MaterialTheme.colorScheme.primary
        NotificationType.NEW_POST -> MaterialTheme.colorScheme.secondary
        NotificationType.NEW_MESSAGE -> MaterialTheme.colorScheme.tertiary
        NotificationType.NEW_LIKE -> MaterialTheme.colorScheme.primaryContainer
    }
}


@Composable
fun getNotificationtintColor(type: NotificationType): Color {
    return when (type) {
        NotificationType.GENERAL -> MaterialTheme.colorScheme.onPrimary
        NotificationType.NEW_POST -> MaterialTheme.colorScheme.onSecondary
        NotificationType.NEW_MESSAGE -> MaterialTheme.colorScheme.onTertiary
        NotificationType.NEW_LIKE -> MaterialTheme.colorScheme.onPrimaryContainer
    }
}
