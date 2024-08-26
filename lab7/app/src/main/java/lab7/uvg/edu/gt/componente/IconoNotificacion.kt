package lab7.uvg.edu.gt.componente

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector


fun getNotificationIcon(type: NotificationType): ImageVector {
    return when (type) {
        NotificationType.GENERAL -> Icons.Filled.Info
        NotificationType.NEW_POST -> Icons.Filled.Add
        NotificationType.NEW_MESSAGE -> Icons.Filled.Email
        NotificationType.NEW_LIKE -> Icons.Filled.ThumbUp
    }
}
