package lab7.uvg.edu.gt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lab7.uvg.edu.gt.layout.NotificationCenterScreen
import lab7.uvg.edu.gt.ui.theme.Lab7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab7Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize())

                { innerPadding -> NotificationCenterScreen() }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NotificationCenterScreenPreview() {
    Lab7Theme {
        NotificationCenterScreen()
    }
}