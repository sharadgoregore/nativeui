package com.example.nativeui
import android.content.Intent
import android.net.Uri
import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.google.android.exoplayer2.ExoPlayer
//import com.google.android.exoplayer2.MediaItem
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
//import io.flutter.embedding.android.FlutterActivity
//import io.flutter.embedding.engine.FlutterEngine
//import io.flutter.plugin.common.MethodChannel
//import android.os.Bundle
//import android.widget.TextView
//import android.widget.Toast

class MainActivity: FlutterActivity(){
//    private val CHANNEL = "com.example.nativeui/textview"
//
//    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
//        super.configureFlutterEngine(flutterEngine)
//
//        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
//            if (call.method == "showTextView") {
//                showNativeTextView()
//                result.success(null)
//            } else {
//                result.notImplemented()
//            }
//        }
//    }
//
//    // Function to display a native TextView in a Toast (for example)
//    private fun showNativeTextView() {
//        // Here, we can show a Toast with a TextView as an example
//        val textView = TextView(this).apply {
//            text = "Hello from Native Android!"
//            textSize = 20f
//            setPadding(20, 20, 20, 20)
//        }
//
//        // Display the TextView within a Toast
//        Toast(this).apply {
//            duration = Toast.LENGTH_LONG
//            view = textView
//            show()
//        }
//    }
private val CHANNEL = "com.example.nativeui/videoplayer"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "playVideo") {
                val url = call.argument<String>("url")
                if (url != null) {
                    playVideo(url)
                    result.success(null)
                } else {
                    result.error("URL_NULL", "URL is null", null)
                }
            } else {
                result.notImplemented()
            }
        }
    }

    private fun playVideo(url: String) {
        val intent = Intent(this, VideoPlayerActivity::class.java)
        intent.putExtra("VIDEO_URL", url)
        startActivity(intent)
    }
}

